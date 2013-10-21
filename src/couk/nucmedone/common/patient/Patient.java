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
package couk.nucmedone.common.patient;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A container class for demographic objects.
 * @author Neil Thomson
 *
 */
public class Patient {

	private static SimpleDateFormat dicomDateFormat = new SimpleDateFormat("YYYYMMDD");
	
	private Calendar dateOfBirth;
	private double height;
	private PatientName patientName;
	private String primaryID;
	private double weight;
	
	public Patient(){
		
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Get a patient's date of birth in DICOM format.
	 * @return The date of birth {@link String} as YYYYMMDD.
	 */
	public String getDicomDateOfBirth(){
		return dicomDateFormat.format(dateOfBirth.getTime());
	}

	public double getHeight() {
		return height;
	}

	public PatientName getPatientName() {
		return patientName;
	}
	
	public String getPrimaryID() {
		return primaryID;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setPatientName(PatientName patientName) {
		this.patientName = patientName;
	}

	public void setPrimaryID(String primaryID) {
		this.primaryID = primaryID;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}
	
}
