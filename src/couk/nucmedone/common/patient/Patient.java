package couk.nucmedone.common.patient;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A container class for demographic objects.
 * @author Neil
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
