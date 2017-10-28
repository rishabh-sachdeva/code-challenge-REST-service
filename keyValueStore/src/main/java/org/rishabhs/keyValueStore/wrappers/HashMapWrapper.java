package org.rishabhs.keyValueStore.wrappers;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Wrapper is created because Jersey
 * demands annotation of XmlRootElement over return type of API 
 */

@XmlRootElement
public class HashMapWrapper {
	public HashMap<String, String> mapOfMatchedvalues=new HashMap<>();
}
