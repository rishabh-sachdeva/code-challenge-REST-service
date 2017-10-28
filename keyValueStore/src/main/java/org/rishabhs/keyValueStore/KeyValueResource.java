package org.rishabhs.keyValueStore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.rishabhs.keyValueStore.models.KeyValueModel;
import org.rishabhs.keyValueStore.service.KeyValueService;
import org.rishabhs.keyValueStore.wrappers.ArrayListWrapper;
import org.rishabhs.keyValueStore.wrappers.HashMapWrapper;

@Path("/")
public class KeyValueResource {

	KeyValueService valueService= new KeyValueService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public void addKeyValuePair(Collection<KeyValueModel> collection){
		valueService.addKeyValuePair(collection);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{keyParams}")
	public ArrayListWrapper getValues(@PathParam("keyParams") String keys){
		String[] keyArray = keys.split(",");
		ArrayList<String> valueList = valueService.getValues(keyArray);
		ArrayListWrapper wrapper = new ArrayListWrapper();
		wrapper.arrayListOfValues = valueList;
		return wrapper;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON )
	@Path("/greaterThan/{number}")
	public HashMapWrapper getValuesGreaterThanParam(@PathParam("number") double number){
		HashMap<String, String> filteredMap = (HashMap<String, String>) valueService.getGreaterValues(number);
		HashMapWrapper wrapper = new HashMapWrapper();
		wrapper.mapOfMatchedvalues=filteredMap;
		return wrapper;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/patternMatch/{pattern}")
	public HashMapWrapper matchPattern(@PathParam("pattern") String pattern){
		Map<String, String> filterOfMatchedValues = valueService.matchValuePattern(pattern);
		HashMapWrapper wrapper =new HashMapWrapper();
		wrapper.mapOfMatchedvalues=(HashMap<String, String>) filterOfMatchedValues;
		return wrapper;
	}
}
