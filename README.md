azati-JMeter
===

`simpleApp` is a simple REST application for saving a number to the Database
 
Go to simpleApp directory and build it first:

```
gradle build
```

###For manual testing you can use this end-points:

- POST to URL:  http://localhost:8080/simple 

set any number to `intValue` parameter in request body

- GET to URL: http://localhost:8080/simple/{id}

###For testing with JMeter just run the script `exec-jmeter.sh`, which creates a JMeter master and n JMeter slaves. 

To create 3 instances:

```
./exec-jmeter.sh 3
```

The script will run all `scripts/*.jmx` files.

the results will be saved to `/results` folder.

###Additionally listing of metriks from Jmeter test execution:

1,000 REQUESTS (100 threads created in 1 sec. with 10 loop):
```
summary =   1000 in 00:00:23 =   43.4/s Avg:  2150 Min:    30 Max: 16326 Err:     0 (0.00%)
```

100,000 REQUESTS (1000 threads created in 10 sec. with 100 loop):
```
summary = 100000 in 00:09:16 =  179.8/s Avg:  5319 Min:    11 Max: 30405 Err:     0 (0.00%)
```

1 million REQUESTS (1000 threads created in 10 sec. with 1000 loop):
```
summary = 1000000 in 01:07:43 =  246.1/s Avg:  4044 Min:     7 Max: 110533 Err:   350 (0.03%)
```
