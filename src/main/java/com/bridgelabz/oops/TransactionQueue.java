package com.bridgelabz.oops;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.ds.Queue;
import com.bridgelabz.util.Utility;

/**
 * Purpose : maintain DateTime of the transaction in a Queue implemented using LinkedList to indicate when the transactions were done.
 * @author : Tasif Mohammed
 * @version : 1.0
 */
public class TransactionQueue {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Company company = new Company();
		Customer customer = new Customer();
		String companyPath = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/CompJson.json";
		File companyFile = new File(companyPath) ;
		String customerJsonPath = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/CustJson.json";
		File customerFile = new File(customerJsonPath);
		ObjectMapper objectMapper = new ObjectMapper();
		List<Company> listCompany  = objectMapper.readValue(companyFile, new org.codehaus.jackson.type.TypeReference<List<Company>>() {});
		List<Customer> listCustomer  = objectMapper.readValue(customerFile, new org.codehaus.jackson.type.TypeReference<List<Customer>>() {});
		System.out.println("Transaction queue\n--------------------------------------------------------");
		System.out.println(listCompany);
		System.out.println(listCustomer);
		Queue<String> buydate = new Queue<String>();
		Queue<String> selldate = new Queue<String>();
		boolean flag = false ;
		while (flag == false) {
			company = (Company) listCompany.get(0);
			customer = (Customer) listCustomer.get(0);
			System.out.println(company);
			System.out.println(customer);
			System.out.print("Enter your choice what you want to do ");
			System.out.println("\t 1.Buy Shares \t 2.Sell Shares \t 3.Display Date of buyed and Sold Shares \t 4.Exit");
			int customerChoice = Utility.inputInteger();
			switch(customerChoice) {
			case 1:
				company = (Company) listCompany.get(0);
				customer = (Customer) listCustomer.get(0);
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
					buydate.enqueue(date);
					listCompany.add(company);
					listCustomer.add(customer);
					Utility.writeObjectJson(listCompany, companyPath);
					Utility.writeObjectJson(listCustomer, customerJsonPath);
				}
				break;
			case 2 :
				company = (Company) listCompany.get(0);
				customer = (Customer) listCustomer.get(0);
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
					selldate.enqueue(date);
					listCompany.add(company);
					listCustomer.add(customer);
					Utility.writeObjectJson(listCompany, companyPath);
					Utility.writeObjectJson(listCustomer, customerJsonPath);
				}
				break;
				
			case 3 :
				System.out.println("Date of buyed stock is ");
				buydate.print();
				System.out.println("Date of selled Stock is ");
				selldate.print();
				break;
			case 4 :
				System.exit(0);
			}
		}
	}

}