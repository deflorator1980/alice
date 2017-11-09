g++ -std=c++14 -o Alice Alice.cpp
sbt clean package && $SPARK_HOME/bin/spark-submit target/scala-2.11/alice_2.11-1.0.jar