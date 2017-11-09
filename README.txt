Сравнивает скорость подсчёта количества слов >12 символов на С++, Джаве, Спарке(Скала) в императивном  и фунциональном стилях
с распараллеливанием и без
(по мотивам К. Хорстманна)

g++ -std=c++14 -o Alice Alice.cpp && ./Alice
javac AliceJ.java && java AliceJ
sbt clean package && $SPARK_HOME/bin/spark-submit --class "Alice" target/scala-2.11/alice_2.11-1.0.jar
