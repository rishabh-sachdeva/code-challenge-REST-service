package org.rishabhs.keyValueStore.wrappers;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Wrapper is created because Jersey
 * demands annotation of XmlRootElement over return type of API 
 */

@XmlRootElement
public class ArrayListWrapper {

	public ArrayList<String> arrayListOfValues= new ArrayList<>();
}
