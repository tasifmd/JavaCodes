package com.bridgelabz.oops;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.util.Utility;

/**
 * Purpose : Program to implements a data type that might be used by a financial institution to keep track of customer information
 * @author admin1
 * @version 1.0
 */
public class CommercialDataProcessing {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Company company = new Company();
		Customer customer = new Customer();
		ObjectMapper objectMapper = new ObjectMapper();
		String companyJsonPath = "//home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/CompanyCommercial.json";
		String customerJsonPath = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/Customer.json";
		File customerFile = new File(customerJsonPath);
		File companyFile = new File(companyJsonPath);
		List companyLists = new ArrayList(Arrays.asList(objectMapper.readValue(companyFile, Company.class)));
		List customerList = new ArrayList(Arrays.asList(objectMapper.readValue(customerFile, Customer.class)));
		boolean flag = false ;
		while (flag == false) {
			company = (Company) companyLists.get(0);
			customer = (Customer) customerList.get(0);
			System.out.println(company);
			System.out.println(customer);
			System.out.print("Enter your choice what you want to do ");
			System.out.println("\t 1.Buy Shares \t 2.Sell Shares \t 3.Exit");
			int customerChoice = Utility.inputInteger();
			switch (customerChoice) {
			case 1 :
				company = (Company) companyLists.get(0);
				customer = (Customer) customerList.get(0);
				System.out.println(company);
				System.out.println(customer);
				System.out.println("Please enter the number of shares you want to buy");
				int buyNumShares = Utility.inputInteger();
				if(buyNumShares>company.getTotalShares()) {
					System.out.print(buyNumShares+" number of share is not available ");
					
				}else {
					int companyShare = company.getTotalShares() - buyNumShares;
					int customerShare = customer.getAvailableShares() + buyNumShares;
					company.setTotalShares(companyShare);
					customer.setAvailableShares(customerShare);
					System.out.println("Enter the date");
					String date = Utility.inputSingleString();
					customer.setDate(date);
					System.out.println("You have successfully buyed "+buyNumShares+" of "+company.getName()+" on "+customer.getDate());
					companyLists.add(company);
					customerList.add(customer);
					objectMapper.writeValue(companyFile, company);
					objectMapper.writeValue(customerFile, customer);
				}
				break;
			case 2 :
				company = (Company) companyLists.get(0);
				customer = (Customer) customerList.get(0);
				System.out.println(company);
				System.out.println(customer);
				System.out.println("Please enter the number of shares you want to sell");
				int selNumShares = Utility.inputInteger();
				if(selNumShares>customer.getAvailableShares()) {
					System.out.println(selNumShares+" number of share is not available");
	
				}else {
					int customerShare = customer.getAvailableShares() - selNumShares;
					int companyShare = company.getTotalShares() + selNumShares;
					company.setTotalShares(companyShare);
					customer.setAvailableShares(customerShare);
					System.out.println("Enter the date");
					String date = Utility.inputSingleString();
					customer.setDate(date);
					System.out.println("You have successfully selled "+selNumShares+" to "+company.getName()+" on "+customer.getDate());
					companyLists.add(company);
					customerList.add(customer);
					objectMapper.writeValue(companyFile, company);
					objectMapper.writeValue(customerFile, customer);
				}
				break;
			case 3:
				System.exit(0);
			}
		}
		
		
	}

}
