package org.rishabhs.keyValueStore.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.rishabhs.keyValueStore.database.DataBaseClass;
import org.rishabhs.keyValueStore.models.KeyValueModel;

public class KeyValueService {

	private Map<String, String> keyValueMap= DataBaseClass.getKeyValueMap();

	public ArrayList<String> getValues(String[] keyArray){
		ArrayList<String> listOfValues=new ArrayList<>();
		for (String key : keyArray){
			String value=keyValueMap.get(key);
			if(null!=value){
				listOfValues.add(value);
			}
		}
		return listOfValues;
	}

	public void addKeyValuePair(Collection<KeyValueModel> collection) {
		Iterator<KeyValueModel> iterator = collection.iterator();
		while(iterator.hasNext()){
			KeyValueModel keyValuePair = iterator.next();
			keyValueMap.put(keyValuePair.getKey(),keyValuePair.getValue());			
		}
	}

	public Map<String, String> getGreaterValues(double number) {

		Map<String,String> filterMap = keyValueMap.entrySet().stream().filter(entry->{
			return null!=isFloat(entry.getValue()) && isFloat(entry.getValue())>number ;}).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		return filterMap;
	}

	private Float isFloat(String value) {
		try{
			return Float.valueOf(value);
		}catch(NumberFormatException ex){
			return null;
		}
	}

	public Map<String, String> matchValuePattern(String pattern) {
		Map<String,String> filterOfMatchedValues = keyValueMap.entrySet().stream().filter(entry->{
			return null==isFloat(entry.getValue()) && ifMatches(pattern,entry.getValue()) ;}).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		return filterOfMatchedValues;
	}

	/*
	 * method to match the patterns
	 * returns true if matches, else false
	 */
	private boolean ifMatches(String pattern, String value) {
		Pattern patternObj = Pattern.compile(pattern);
		Matcher matcher = patternObj.matcher(value);  
		return matcher.matches();
	}

}
