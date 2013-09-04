package couk.nucmedone.common.patient;

public class PatientName {
	
	private String familyName;
	private String middleNames;
	private String givenName;
	private String prefix;
	private String suffix;
	
	public PatientName(){
		
	}

	/**
	 * Makes a valid DICOM compliant name. Trailing "^" characters are stripped.
	 * @return A DICOM name as {@link String} in the form:<br /><br />
	 * <i>familyName(s)^middleNames(s)^givenName(s)^prefixesAndTitles^suffixes</i>
	 */
	public String getDicomName(){
		
		// Make basic name
		StringBuffer name = new StringBuffer(64);
		name.append(familyName == null ? "" : familyName);
		name.append("^");
		name.append(middleNames == null ? "" : middleNames);
		name.append("^");
		name.append(givenName == null ? "" : givenName);
		name.append("^");
		name.append(prefix == null ? "" : prefix);
		name.append("^");
		name.append(suffix == null ? "" : suffix);
		
		// trim unnecessary trailing circumflexes
		while(name.charAt(name.length()) -1 == '^'){
			name.deleteCharAt(name.length() -1);
		}
		
		return name.toString();
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public String getMiddleNames() {
		return middleNames;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public void setMiddleNames(String middleNames) {
		this.middleNames = middleNames;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

}
