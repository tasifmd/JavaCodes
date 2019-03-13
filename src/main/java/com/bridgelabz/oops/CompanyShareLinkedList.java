package com.bridgelabz.oops;

import java.io.*;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.ds.*;
import com.bridgelabz.util.*;

/**
 * Purpose : Maintain the List of CompanyShares in a Linked List So new CompanyShares can be added or removed easily. Do not use any Collection Library to implement Linked List.
 * @author : Tasif Mohammed
 * @version : 1.0
 */
public class CompanyShareLinkedList {
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Company company = new Company();
		String companyPath = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/Company.json";
		File companyFile = new File(companyPath) ;
		ObjectMapper objectMapper = new ObjectMapper();
		List<Company> list  = objectMapper.readValue(companyFile, new org.codehaus.jackson.type.TypeReference<List<Company>>() {});
		System.out.println(list);
		LinkedList<Company> linkedlist = new LinkedList<Company>();
		for(int i = 0 ; i < list.size() ; i++) {
			linkedlist.add(list.get(i));
		}
		linkedlist.print();
		
		boolean flag =false ;
		while (flag == false) {
			System.out.println("Enter your choice");
			System.out.println("1.Add Company Share \t 2.Remove Company Share \t 3.Exit");
			int choice = Utility.inputInteger();
			switch(choice) {
			case 1:
				System.out.println("Enter the stock details");
				System.out.println("Enter the company name");
				company.setName(Utility.inputSingleString());
				System.out.println("Enter number of shares");
				company.setTotalShares(Utility.inputInteger());
				System.out.println("Enter the stock price");
				company.setStockPrice(Utility.inputInteger());
				linkedlist.add(company);
				//objectMapper.writeValue(companyFile, linkedlist);
				Utility.writeObjectJsonLinkesList(linkedlist, companyPath);
				System.out.println("Stock Details added successfully");
				linkedlist.print();
				break;
			case 2:
				System.out.println("Remove stock details");
				System.out.println("Enter Company name");
				String companyName = Utility.inputSingleString();
				for(int i = 0 ; i < linkedlist.size() ; i++) {
					if(linkedlist.getElement(i).getName().equals(companyName)) {
						linkedlist.delete(companyName);;
						System.out.println("Object Deleted");
					}
				}
				Utility.writeObjectJsonLinkesList(linkedlist, companyPath);
				System.out.println("Stock Details deleted successfully");
				linkedlist.print();
				break;
			case 3:
				System.exit(0);
			}
		}
	}

}