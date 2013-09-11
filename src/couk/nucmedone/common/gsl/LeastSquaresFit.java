/**
 * @author Neil J Thomson (njt@fishlegs.co.uk)
 *
 * Copyright (C) 2013 Neil J Thomson
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or (at
 * your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 */
package couk.nucmedone.common.gsl;

/**
 * Inspired by gsl-1.16/fit/fit.c from the GNU Scientific Library project.<br />
 * <br />
 * Fit the data (<i>x</i>_<i>i</i>, <i>y</i>_<i>i</i>) to the linear
 * relationship<br />
 * <br />
 * 
 * <i>Y</i> = <i>c</i>0 + <i>c</i>1 <i>x</i> <br />
 * <br />
 * returning,<br />
 * <br />
 * <i>c</i>0, <i>c</i>1 -- coefficients cov00, cov01, cov11 --
 * variance-covariance matrix of <i>c</i>0 and <i>c</i>1, sumsq -- sum of
 * squares of residuals. <br />
 * <br />
 * This fit can be used in the case where the errors for the data are uknown,
 * but assumed equal for all points. The resulting variance-covariance matrix
 * estimates the error in the coefficients from the observed variance of the
 * points around the best fit line.
 */
public class LeastSquaresFit {

	private double c0;
	private double c1;
	private double cov00;
	private double cov01;
	private double cov11;
	private double sumsq=0;

	public LeastSquaresFit(double[] x, double[] y, int n, int xstride,
			int ystride) {

		double m_x = 0;
		double m_y = 0;

		for (int i = 0; i < n; i++) {
			m_x += (x[i * xstride] - m_x) / (i + 1.0);
			m_y += (y[i * ystride] - m_y) / (i + 1.0);
		}

		double m_dx2 = 0;
		double m_dxdy = 0;

		for (int i = 0; i < n; i++) {
			double dx = x[i * xstride] - m_x;
			double dy = y[i * ystride] - m_y;

			m_dx2 += (dx * dx - m_dx2) / (i + 1.0);
			m_dxdy += (dx * dy - m_dxdy) / (i + 1.0);
		}

		// In terms of y = c0 + c1 x
		double s2 = 0;
		c1 = m_dxdy / m_dx2;
		c0 = m_y - m_x * c1;

		// Compute chi^2 = \sum (y_i - (a + b * x_i))^2
		for (int i = 0; i < n; i++) {
			double dx = x[i * xstride] - m_x;
			double dy = y[i * ystride] - m_y;
			double d = dy - c1 * dx;
			sumsq += d * d;
		}

		s2 = sumsq / (n - 2.0); /* chisq per degree of freedom */

		cov00 = s2 * (1.0 / n) * (1 + m_x * m_x / m_dx2);
		cov11 = s2 * 1.0 / (n * m_dx2);
		cov01 = s2 * (-m_x) / (n * m_dx2);

	}
	
	public double c0(){
		return c0;
	}
	
	public double c1(){
		return c1;
	}
	
	public double covariance00(){
		return cov00;
	}
	
	public double covariance01(){
		return cov01;
	}

	public double covariance11(){
		return cov11;
	}
	
	public double residual(){
		return sumsq;
	}
}
