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

public class StockReport {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Company company = new Company();
		String companyPath = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/Company.json";
		File companyFile = new File(companyPath) ;
		ObjectMapper objectMapper = new ObjectMapper();
		List companyLists = new ArrayList(Arrays.asList(objectMapper.readValue(companyFile, Company[].class)));
		boolean flag = false;
		while(flag == false) {
			System.out.println("Enter \t 1 . Add Stock \t 2 . Calculate Value of stock \t 3.Exit");
			int input = Utility.inputInteger();
			
			switch(input) {
			case 1:
				System.out.println("Enter the stock details");
				System.out.println("Enter the company name");
				company.setName(Utility.inputSingleString());
				System.out.println("Enter number of shares");
				company.setTotalShares(Utility.inputInteger());
				System.out.println("Enter the stock price");
				company.setStockPrice(Utility.inputInteger());
				companyLists.add(company);
				System.out.println("Stock Details added successfully");
				//String companyJson = objectMapper.writeValueAsString(company);
				//Utility.writeToJsonFileWithOutOverWriting(companyJson, companyPath);
				Utility.writeObjectJson(companyLists, companyPath);
				System.out.println(company);
				System.out.println("File writted successfully");
				break;
			case 2:
				for (int i = 0 ; i < companyLists.size() ; i++) {
					Company comp = (Company)companyLists.get(i);
					int stockValue = comp.getStockPrice()*comp.getTotalShares();
					System.out.println("Name of the Company : "+comp.getName()+"\ntotal value of each stock is "+comp.getStockPrice()+"\nStock Value of company :" + stockValue);
					System.out.println("--------------------------------------------------------------");
				}
				break;
			case 3:
				System.exit(0);
			}
			
		
		}
		
	}

}
