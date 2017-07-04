Deprecated: does not support latest SHARE API

# share-client
This client retrieves records from the SHARE API based on search parameters provided.

The ShareApiIterator allows you to build a set of SHARE results and  either retrieve a list of records using getCurrentRecordList(), or iterate over all matching results using next().  The next() function will automatically paginate through the API results.

The results are returned as List<Record> where Record contains the properties of a single SHARE record as Java POJOs.

<em>Note: this was developed to harvest specific components of the SHARE data, so the Record model is incomplete. It does not, for example, include License fields, or all possible "otherProperties" among others.</em>

## Getting started
build via 
```
mvn clean install
```
This will create an executable jar file in 
```
share-client/target/share-client-{$version}.jar
```

##Example code
```
HashMap<String, String> params = new HashMap<>();
params.put("q", "heart");
params.put("size", "50"); //if this is not included, next() will iterate through all matching results
ShareApiIterator iterator = new ShareApiIterator(params);
do {
  Record rec = iterator.next();
  String title = rec.getTitle();
  List<Agent> contributors = rec.getContributors();
  
  [...]

} while(iterator.hasNext());
```


