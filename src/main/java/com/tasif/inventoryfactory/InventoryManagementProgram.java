package com.tasif.inventoryfactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class InventoryManagementProgram {
	public static void main(String[] args) throws IOException, ParseException {
		String path = "/home/admin1/eclipse-workspace/tasif/oops/oops/src/main/java/com/tasif/inventoryfactory/inventory.json";
		InventoryFactory factory = InventoryFactory.getFactory();
		List<JSONObject> jsonList;
		jsonList = factory.getObjects(path);
		List<Inventory> allInventory = new ArrayList<Inventory>();
		for (JSONObject jsonObject : jsonList) {
			Inventory inventory = new Inventory();
			inventory.setProduct(jsonObject.get("product").toString());
			inventory.setInventoryPrice(Integer.parseInt(jsonObject.get("inventoryPrice").toString())* Integer.parseInt(jsonObject.get("numberofinventory").toString()));
			allInventory.add(inventory);
		}

		JSONArray array = new JSONArray();
		for (Inventory inventory : allInventory) {
			JSONObject inventoryObject = new JSONObject();
			inventoryObject.put("inventoryPrice", inventory.getInventoryPrice());
			inventoryObject.put("product", inventory.getProduct());
			array.add(inventoryObject);
		}
		System.out.println(array.toJSONString());
	}
}
