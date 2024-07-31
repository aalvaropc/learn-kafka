# Comandos Esenciales de Kafka

Este documento proporciona una guía rápida para realizar operaciones básicas con Apache Kafka, como iniciar Zookeeper y el broker, crear y listar topics, y utilizar los consumidores y productores de Kafka.

## Iniciar Zookeeper

Para iniciar el servicio de Zookeeper, ejecute el siguiente comando:

```sh
bin/zookeeper-server-start.sh config/zookeeper.properties
```

## Iniciar el Broker de Kafka

Inicie el broker o servidor de Kafka con el siguiente comando:

```sh
bin/kafka-server-start.sh config/server.properties
```

## Crear un Topic

Para crear un nuevo topic llamado aalvaropc con 5 particiones y un factor de replicación de 1, utilice el siguiente comando:

```sh
bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic aalvaropc --partitions 5 --replication-factor 1
```

## Listar los Topics

Para listar todos los topics disponibles en el broker de Kafka, use el siguiente comando:

```sh
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```

## Describir un Topic

Puede obtener una descripción detallada de un topic específico, como aalvaropc, utilizando el siguiente comando:

```sh
bin/kafka-topics.sh --describe --topic aalvaropc --bootstrap-server localhost:9092
```
## Iniciar un Consumer

Para iniciar un consumidor que consuma mensajes del topic aalvaropc, ejecute:

```sh
bin/kafka-console-consumer.sh --topic aalvaropc --bootstrap-server localhost:9092
```

Si desea consumir mensajes desde el principio del topic:

```sh
bin/kafka-console-consumer.sh --topic aalvaropc --from-beginning --bootstrap-server localhost:9092
```

Para consumir mensajes y mostrar las claves junto con los valores:

```sh
bin/kafka-console-consumer.sh --topic aalvaropc --from-beginning --bootstrap-server localhost:9092 --property print.key=true --property key.separator=" ==> "
```

## Iniciar un Producer

Para iniciar un productor que envíe mensajes al topic aalvaropc, utilice el siguiente comando:

```sh
bin/kafka-console-producer.sh --topic aalvaropc --bootstrap-server localhost:9092
```
