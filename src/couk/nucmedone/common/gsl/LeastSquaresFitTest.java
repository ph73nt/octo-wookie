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

import org.junit.Assert;
import org.junit.Test;

/**
 * Inspired by gsl-1.16/fit/test.c from the GNU Scientific Library project. <br />
 * <br />
 * Tests are based on the NIST Statistical Reference Datasets. See
 * {@link www.nist.gov/itl/div898/strd/index.html} for more information
 * 
 * @author Neil J Thomson
 * 
 */
public class LeastSquaresFitTest {

	private int norris_n = 36;

	private double norris_x[] = { 0.2, 337.4, 118.2, 884.6, 10.1, 226.5, 666.3,
			996.3, 448.6, 777.0, 558.2, 0.4, 0.6, 775.5, 666.9, 338.0, 447.5,
			11.6, 556.0, 228.1, 995.8, 887.6, 120.2, 0.3, 0.3, 556.8, 339.1,
			887.2, 999.0, 779.0, 11.1, 118.3, 229.2, 669.1, 448.9, 0.5 };

	private double norris_y[] = { 0.1, 338.8, 118.1, 888.0, 9.2, 228.1, 668.5,
			998.5, 449.1, 778.9, 559.2, 0.3, 0.1, 778.1, 668.8, 339.3, 448.9,
			10.8, 557.7, 228.3, 998.0, 888.8, 119.6, 0.3, 0.6, 557.6, 339.3,
			888.0, 998.5, 778.9, 10.2, 117.6, 228.9, 668.4, 449.2, 0.2 };

	@Test
	public void test() {

		double[] x = new double[1000];
		double[] y = new double[1000];
		int xstride = 2;
		int ystride = 5;

		for (int i = 0; i < norris_n; i++) {
			x[i * xstride] = norris_x[i];
			y[i * ystride] = norris_y[i];
		}

		LeastSquaresFit lsf = new LeastSquaresFit(x, y, norris_n, xstride,
				ystride);

		double expected_c0 = -0.262323073774029;
		Assert.assertEquals(expected_c0, lsf.c0(), 1e-10);

		double expected_c1 = 1.00211681802045;
		Assert.assertEquals(expected_c1, lsf.c1(), 1e-10);

		double expected_cov00 = Math.pow(0.232818234301152, 2.0);
		Assert.assertEquals(expected_cov00, lsf.covariance00(), 1e-10);

		double expected_cov01 = -7.74327536339570e-05; /* computed from octave */
		Assert.assertEquals(expected_cov01, lsf.covariance01(), 1e-10);

		double expected_cov11 = Math.pow(0.429796848199937E-03, 2.0);
		Assert.assertEquals(expected_cov11, lsf.covariance11(), 1e-10);

		double expected_sumsq = 26.6173985294224;
		Assert.assertEquals(expected_sumsq, lsf.residual(), 1e-10);

	}

}
