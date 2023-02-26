azati-JMeter
===

`simpleApp` is a simple REST application for saving a number to the Database
 
Go to simpleApp directory and build it first:

```
gradle build
```

###For manual testing you can use this end-points:

- POST to URL:  http://localhost:8080/simple 

JSON example
```
{ "intValue": 60 }
```

- GET to URL: http://localhost:8080/simple/{id}

###For testing with JMeter just run the script `exec-jmeter.sh`, which creates a JMeter master and n JMeter slaves. 

To create 3 instances:

```
./exec-jmeter.sh 3
```

The script will run all `scripts/*.jmx` files.

the results will be saved to `/results` folder.