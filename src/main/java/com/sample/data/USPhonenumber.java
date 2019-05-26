package com.sample.data;

import java.util.regex.Pattern;

public class USPhonenumber implements PhoneNumber {

	private static Pattern AREA_CODE = Pattern.compile("^[0-9]{3}");
	private static Pattern PREFIX = Pattern.compile("^[0-9]{3}");
	private static Pattern SUFFIX = Pattern.compile("^[0-9]{3}");

	private String areaCode;
	private String prefix;
	private String suffix;

	@Override
	public boolean validate() {
		return AREA_CODE.matcher(areaCode).matches() && PREFIX.matcher(this.prefix).matches()
				&& SUFFIX.matcher(suffix).matches();
	}

	@Override
	public String toString() {
		return String.format("(%s) %s-%s", areaCode, prefix, suffix);
	}

}
