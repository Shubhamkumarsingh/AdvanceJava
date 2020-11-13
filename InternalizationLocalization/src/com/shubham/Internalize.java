package com.shubham;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Internalize {
	private static String lang;
	private static Map<String, String> properties=new HashMap<String, String>();
	public static void setLanguage(String lang)
	{
		Internalize.lang=lang;
		Bundle();
	}
	public static void Bundle()
	{
		if(lang.equals("en"))
		{
			Locale.setDefault(new Locale(lang,"US"));
			ResourceBundle rs=ResourceBundle.getBundle("Message");
			properties.put("question", rs.getString("question"));
			properties.put("answer", rs.getString("answer"));
		}else if(lang.equals("fr"))
		{
			Locale.setDefault(new Locale(lang,"FR"));
			ResourceBundle rs=ResourceBundle.getBundle("Message");
			properties.put("question", rs.getString("question"));
			properties.put("answer", rs.getString("answer"));
		}else if(lang.equals("it"))
		{
			Locale.setDefault(new Locale(lang,"IT"));
			ResourceBundle rs=ResourceBundle.getBundle("Message");
			properties.put("question", rs.getString("question"));
			properties.put("answer", rs.getString("answer"));
		}
	}
	public static Map<String, String> getProperties()
	{
		return properties;
	}
}
