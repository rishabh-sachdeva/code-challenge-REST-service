# keyValue-Store
A consumer, via REST endpoints, must be able to:  
1. Store a key and a value. The value can either be a String or a Float. 
2. Retrieve a value for a key. Multiple keys could also be provided. 
3. Query for values matching a particular pattern (regex). This method should only return the key, value pairs which are Strings. Any entry holding a Float should be skipped. 
4. Query for values greater than a given number. This method should only return the key, value pairs which are Floats. Any entry holding a String should be skipped. 

USE CASES:
1. To create key value pair:
url: POST keyValueStore/webapi/create

sample payload: 
[
{
"key":"bike",
"value":"Yamaha FZ"
},
{
"key":"car",
"value":"Honda City"
},
{
"key":"bike_cc",
"value":"150"
}
]


2. To get values:
url: GET keyValueStore/webapi/{key1,key2}

3. To get matched pair by pattern(only considers values of type String)
url: GET keyValueStore/webapi/patternMatch/{pattern}

4.To get values with value greater than parameter provided
url GET: keyValueStore/webapi/greaterThan/{numberParam}


Note: 
1.The project is Mavenized.
2. Use Java 8
