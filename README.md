# Tenpo

## To run this service please type the below command in terminal:
```
mvn clean install spring-boot:run
```
  
## Deploy the build in Docker: 
```
docker build --build-arg JAR_FILE=target/*.jar -t  Tenpo-1.0.jar
```
  
## To run the application in Docker Environment:
```
docker run -p 8080:8080 Tenpo
```

  
## database.env
```
POSTGRES_USER=root
POSTGRES_PASSWORD=
POSTGRES_DB=TenpoDB
```
  
## Schema created for this service named **db_schema_1**
  
## PostMan collection can be found [here](https://github.com/ashokchakravarthi/tenpo/blob/master/Tenpo%20Collection.postman_collection.json)

  
## Screenshot of the service:

![screenshot](https://github.com/ashokchakravarthi/tenpo/blob/master/screenshot.png)
