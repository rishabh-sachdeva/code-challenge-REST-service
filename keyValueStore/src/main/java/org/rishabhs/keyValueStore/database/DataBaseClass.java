package org.rishabhs.keyValueStore.database;

import java.util.HashMap;
import java.util.Map;

public class DataBaseClass {
	private static Map<String,String> keyValuePair = new HashMap<>();
	private DataBaseClass(){}

	public void put(String key,String value){
		keyValuePair.put(key, value);
	}
	public static Map<String, String> getKeyValueMap(){
		return keyValuePair;

	}

}
