/**
 * @author Neil Thomson
 *
 * Copyright (C) 2013 Neil Thomson
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

package couk.nucmedone.common.stock;

import java.util.Calendar;

import couk.nucmedone.common.base.DoublePlus;
import couk.nucmedone.common.nuclides.Nuclides;

/**
 * A class for holding radioactive stock phials.
 * 
 * @author Neil Thomson
 *
 */
public class Phial {

	private String batch;
	private DoublePlus currentVolume;
	private Calendar expDate;
	private DoublePlus initVol;
	private String lot;
	private String manufacturer;
	private Nuclides nuclide;
	private String pharmaceutical;
	private double refActivity;
	private Calendar refDate;

	public String getBatch() {
		return batch;
	}

	public DoublePlus getCurrentVolume() {
		return currentVolume;
	}

	public Calendar getExpDate() {
		return expDate;
	}

	public DoublePlus getInitVol() {
		return initVol;
	}

	public String getLot() {
		return lot;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public Nuclides getNuclide() {
		return nuclide;
	}

	public String getPharmaceutical() {
		return pharmaceutical;
	}

	public double getRefActivity() {
		return refActivity;
	}

	public Calendar getRefDate() {
		return refDate;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public void setCurrentVolume(DoublePlus currentVolume) {
		this.currentVolume = currentVolume;
	}

	public void setExpDate(Calendar expDate) {
		this.expDate = expDate;
	}

	public void setInitVol(DoublePlus initVol) {
		this.initVol = initVol;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setNuclide(Nuclides nuclide) {
		this.nuclide = nuclide;
	}

	public void setPharmaceutical(String pharmaceutical) {
		this.pharmaceutical = pharmaceutical;
	}

	public void setRefActivity(double refActivity) {
		this.refActivity = refActivity;
	}

	public void setRefDate(Calendar refDate) {
		this.refDate = refDate;
	}

}
