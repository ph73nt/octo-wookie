/**
 * @author Neil
 *
 * Copyright (C) 2013 Neil
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

public class PatientName {
	
	private String familyName;
	private String middleNames;
	private String givenName;
	private String prefix;
	private String suffix;
	
	public PatientName(){
		
	}
	
	public PatientName(String familyname, String givenName, String middlenames, String prefix, String suffix){
		this.familyName = familyname;
		this.givenName = givenName;
		this.middleNames = middlenames;
		this.prefix = prefix;
		this.suffix = suffix;
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
		name.append(givenName == null ? "" : givenName);
		name.append("^");
		name.append(middleNames == null ? "" : middleNames);
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
