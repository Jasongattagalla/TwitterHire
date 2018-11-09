package org.apache.spark.streaming.examples
//import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import StreamingContext._
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext._
import org.apache.spark.streaming.twitter._

object TwitterPopularTags {
  def main(args: Array[String]) {
 if (args.length < 1) {
      System.err.println("Usage: TwitterPopularTags <consumer key><consumer secret>" +
        "<access token> <access token secret> [<filter>]")
      System.exit(1)
    }

    //StreamingExamples.setStreamingLogLevels()
    
    val Array(consumerKey,consumerSecret, accessToken, accessTokenSecret) = args.take(4)
    val filters = args.takeRight(args.length-4)
    
    System.setProperty("twitter4j.oauth.consumerKey", consumerKey)
    System.setProperty("twitter4j.oauth.consumerSecret", consumerSecret)
    System.setProperty("twitter4j.oauth.accessToken", accessToken)
    System.setProperty("twitter4j.oauth.accessTokenSecret", accessTokenSecret)
    

    //val (master, filters) = (args.head, args.tail)
    val sparkConf =  new sparkConf().setAppName("TwitterPopularTags").setMaster("local[*]")
    val ssc = new StreamingContext(sparkConf, Seconds(2))
    //System.getenv("/home/jason/project/spark-2.1.0-bin-hadoop2.7").StreamingContext.jarOfClass(this.getClass))
    //val lines = ssc.socketTextStream("localhost", 6997)
    val stream = TwitterUtils.createStream(ssc, None, filters)

    val hashTags = stream.flatMap(status => status.getText.split(" ").filter(_.startsWith("#")))



                     //for writing output to the external source s3
val data=ssc.textfile("s3n://###)

)
    // Printing tweets with the hashtags #jobs #hire
    topCounts60.foreachRDD(rdd => {
      val topList = rdd.take(5)
      println("\nPopular topics in last 60 seconds (%s total):".format(rdd.count()))
      topList.foreach{case (count, tag) => println("%s (%s tweets)".format(tag, count))}
    })
    //if the RDD receives no data from the stream
    if(!rdd.partitions.isEmpty)
   rdd.saveAsTextFile(outputDir)
   
   
   println("*************************************************************************************************************************")
    ssc.start()
    ssc.awaitTermination()
