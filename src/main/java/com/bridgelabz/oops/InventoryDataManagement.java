package com.bridgelabz.oops;
import com.bridgelabz.util.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class InventoryDataManagement {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IOException {
		Rice rice = new Rice();
		Wheats wheat = new Wheats();
		Pulses pulse = new Pulses();

		String ricePath = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/Rice.json";
		String wheatsPath = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/Wheats.json";
		String pulsePath = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/Pulses.json";
		File riceFile = new File(ricePath);
		File wheatFile = new File(wheatsPath);
		File pulseFile = new File(pulsePath);
		String writeRicePath = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/RiceWrite.json";
		String writeWheatPath = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/WheatWrite.json";
		String writePulsePath = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/JsonFiles/PulseWrite.json";
		ObjectMapper objectMapper = new ObjectMapper();
		List<Rice> riceLists = new ArrayList(Arrays.asList(objectMapper.readValue(riceFile, Rice[].class)));
		List<Pulses> pulseList = new ArrayList(Arrays.asList(objectMapper.readValue(pulseFile, Pulses[].class)));
		List<Wheats> wheatsLists = new ArrayList(Arrays.asList(objectMapper.readValue(wheatFile, Wheats[].class)));
		
		boolean flag = false ;
		while(flag == false ) {
			System.out.println("Enter the choice");
			System.out.println("1:Display Inventory \t 2:Add Inventory \t 3:Total Price \t 4:Exit");
			int choice = Utility.inputInteger();
			switch(choice) {
			case 1:
				System.out.println("Reading Files");
				for(int i = 0 ; i < riceLists.size() ; i++) {
					rice = riceLists.get(i);
					System.out.println(rice);
				}
				
				for(int i = 0 ; i < wheatsLists.size() ; i++) {
					wheat = wheatsLists.get(i);
					System.out.println(wheat);
				}
				
				for(int i = 0 ; i < pulseList.size() ; i++) {
					pulse = pulseList.get(i);
					System.out.println(pulse);
				}
				break;
			case 2:
				System.out.println("Select the inventory name \t1.rice \t 2.wheat \t 3.pulses");
				int inventoryName = Utility.inputInteger();
				switch(inventoryName) {
				case 1:
					Rice inventoryRice = new Rice();
					System.out.println("Enter the name:");
					inventoryRice.setName(Utility.inputSingleString());
					System.out.println("Enter the weight");
					inventoryRice.setWeight(Utility.inputDouble());                  
					System.out.println("Enter the price");
					inventoryRice.setPrice(Utility.inputDouble());
					riceLists.add(inventoryRice);
					System.out.println("Rice inventory added successfully");
					//String riceJson = objectMapper.writeValueAsString(inventoryRice);
					Utility.writeObjectJson(riceLists, writeRicePath);
					System.out.println("File Writted Successfully");
					break;
				case 2 :
					Wheats inventoryWheat = new Wheats();
					System.out.println("Enter the name:");
					inventoryWheat.setName(Utility.inputSingleString());
					System.out.println("Enter the weight");
					inventoryWheat.setWeight(Utility.inputDouble());                  
					System.out.println("Enter the price");
					inventoryWheat.setPrice(Utility.inputDouble());
					wheatsLists.add(inventoryWheat);
					System.out.println("Wheat inventory added successfully");
					//String wheatsJson = objectMapper.writeValueAsString(inventoryWheat);
					//Utility.writeToJsonFile(wheatsJson, writeWheatPath);
					Utility.writeObjectJson(wheatsLists, writeWheatPath);
					System.out.println("File Writted Successfully");
					break;
				case 3 :
					Pulses inventoryPulses = new Pulses();
					System.out.println("Enter the name:");
					inventoryPulses.setName(Utility.inputSingleString());
					System.out.println("Enter the weight");
					inventoryPulses.setWeight(Utility.inputDouble());                  
					System.out.println("Enter the price");
					inventoryPulses.setPrice(Utility.inputDouble());
					pulseList.add(inventoryPulses);
					System.out.println("Pulse inventory added successfully");
					//String pulsesJson = objectMapper.writeValueAsString(inventoryPulses);
					//Utility.writeToJsonFile(pulsesJson, writePulsePath);
					Utility.writeObjectJson(pulseList, writePulsePath);
					System.out.println("File Writted Successfully");
					
				}
			case 3:
				for (int i = 0; i < riceLists.size(); i++) {
					Rice inventoryRice = riceLists.get(i);
					double ricePrice = inventoryRice.getWeight()*inventoryRice.getPrice();
					System.out.println("Rice name :" + inventoryRice.getName()+" total price is "+ricePrice);
				}
				for (int i = 0; i < wheatsLists.size(); i++) {
					Wheats inventoryWheat = wheatsLists.get(i);
					double wheatPrice = inventoryWheat.getWeight()*inventoryWheat.getPrice();
					System.out.println("Wheat name :" + inventoryWheat.getName()+" total price is "+wheatPrice);
					
				}
				for (int i = 0; i < pulseList.size(); i++) {
					Pulses inventoryPulse = pulseList.get(i);
					double pulsePrice = inventoryPulse.getWeight()*inventoryPulse.getPrice();
					System.out.println("Pulse name :" + inventoryPulse.getName()+" total price is "+pulsePrice);
					
				}
				break;
			case 4 :
				System.exit(0);
			}
			
		}
		
		
	}
}
