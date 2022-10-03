package com.yash.helper;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	public static final String DATE_FORMAT_DEFAULT = "dd/MM/yyyy";

	public static final String DATETIME_FORMAT_DEFAULT = "dd/MM/yyyy hh:mm aa";

	public static final String DATETIME_FORMAT_GOOGLE_YOUTUBE = "yyyy-MM-dd'T'HH:mm:ssZ";

	public static final String TIME_FORMAT_DEFAULT = "hh:mm:ss aa";

	public static final String dateToString(Date date) {
		return dateToString(date, DATE_FORMAT_DEFAULT);
	}

	public static final String TimeToString(Date date) {
		return dateToString(date, TIME_FORMAT_DEFAULT);
	}

	public static final String dateToString(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static final Date stringToDate(String dateString) throws ParseException {
		return stringToDate(dateString, DATE_FORMAT_DEFAULT);
	}

	public static final Timestamp stringToTimeStamp(String dateString) throws ParseException {
		return new java.sql.Timestamp(stringToDate(dateString, TIME_FORMAT_DEFAULT).getTime());

	}

	public static final Date changeDateFormat(Date date, String format) throws ParseException {
		DateFormat dateformat = new SimpleDateFormat(format);
		return dateformat.parse(dateformat.format(date));
	}

	public static Date getCurrentDate() {
		return new Date();

	}

	public static final Date getCurrentDate(String format) throws ParseException {
		DateFormat dateformat = new SimpleDateFormat(format);
		return dateformat.parse(dateformat.format(new Date()));
	}

	public static Date stringToDate(String dateString, String pattern) throws ParseException {
		if (dateString == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateString);

	}


}
