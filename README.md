# TwitterHire


### Prerequisites

What things you need to install the software and how to install them

 * Scala
 * Apache Spark Engine
 * Maven
     

### Installing

Install Apache Spark Engine 

*	Download the latest spark version spark-2.1.0-bin-hadoop2.7.tgz from the official website.
*	Extract the tgz file with the command tar -xzf spark-2.1.0-bin-hadoop2.7.tgz or we can just do it by clicking options 
*	Move the spark folder to the current root directory.
*	Set the environment variables in ~/.basrc file


```
gedit ~/.bashrc
```

*	export SPARK_HOME=/home/hadoop/work/spark-1.3.1-bin-hadoop1
*	export PATH=$PATH: $SPARK_HOME/bin

Start Spark Engine

```
Spark-shell
```

Twitter API: In twitter API, there are four parameters namely Consumer key, Consumer secret, Access Token, Access Token Secret. These parameters are used to access the twitter streaming data into the spark application. By using Ouath API we can access the tweets into the spark without logging in to the twitter account [TwitterApps](https://apps.twitter.com/)


## Execution

Run

```
$spark-submit –class org.apache.spark.examples.streaming TwitterJobs –master local –jar TwitterHire-0.0.1-SNAPSHOT.jar –files twitter4j.properties 
```
In the above command we are including the package of the project and the master is set to local and the .jar files which are generated are and also the file with all the arguments is passed through spark-submit.


## Built With

* [Apache Spark](https://spark.apache.org/)



