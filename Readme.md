# COMANDOS ESENCIALES KAFKA

## Iniciar zookeper
bin/zookeeper-server-start.sh config/zookeeper.properties

## Iniciar broker o servidor
bin/kafka-server-start.sh config/server.properties

## Crear un topic
bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic aalvaropc -partitions 5 --replication-factor 1

## Listar los topics
bin/kafka-topics.sh --list --bootstrap-server localhost:9092

## Describir un topic
bin/kafka-topics.sh --describe --topic aalvaropc --bootstrap-server localhost:9092

## Iniciar consumer

bin/kafka-console-consumer.sh --topic aalvaropc --bootstrap-server localhost:9092 
bin/kafka-console-consumer.sh --topic aalvaropc --from-beginning --bootstrap-server localhost:9092
bin/kafka-console-consumer.sh --topic aalvaropc --from-beginning --bootstrap-server localhost:9092 --property print.key=true --property key.separator=" ==> " 

## Iniciar producer
bin/kafka-console-producer.sh --topic aalvaropc --bootstrap-server localhost:9092 