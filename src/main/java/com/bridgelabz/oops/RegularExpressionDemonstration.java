package com.bridgelabz.oops;
import java.util.regex.*;
import com.bridgelabz.util.*;;

/**
 * Purpose : Read the message and replace name, full name, Mobile#, and Date with proper value
 * @author Tasif Mohammed
 * @version 1.0
 * @since 04/03/2019
 */

public class RegularExpressionDemonstration {

	public static void main(String[] args) {
		String str = "Hello <<name>>, We have your full" + 
				"name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx." + 
				"Please,let us know in case of any clarification Thank you BridgeLabz xx/xx/xxxx";
		System.out.println("Enter your full name ");
		String uname = Utility.inputString();
		
		
		String[] arr = uname.split(" ");
		String firstname = arr[0];
		String str1 = str.replace("<<full name>>", uname);
		String str2 = str1.replace("<<name>>", firstname);
		System.out.println("Enter 10 digit mobile number ");
		String mobno = Utility.inputSingleString();
		System.out.println("Enter date ");
		String date = Utility.inputSingleString();
		if(isDateValid(date) && isMobValid(mobno)) {
			String str3 = str2.replace("xxxxxxxxxx", mobno);
			String str4 = str3.replace("xx/xx/xxxx", date);
			System.out.println(str4);
		}else {
			System.out.println("Mobile or date is not valid");
		}
		
	}
	
	/**
	 * Purpose : Function to validate mobile number
	 * @param mobno as argument
	 * @return the boolean  value
	 */
	public static boolean isMobValid(String mobno) {
		Pattern p = Pattern.compile("\\d{10}"); 
        Matcher m = p.matcher(mobno); 
        return (m.find() && m.group().equals(mobno)); 
	}
	
	/**
	 * Purpose : Function to validate date
	 * @param date as a parameter
	 * @return the boolean value 
	 */
	public static boolean isDateValid(String date) {
		Pattern p = Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$"); 
        Matcher m = p.matcher(date); 
        return (m.find() && m.group().equals(date));
	}
}
