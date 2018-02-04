import json
from kafka import KafkaProducer
from kafka.errors import KafkaError


def send(item):
    producer = KafkaProducer(bootstrap_servers=['10.10.1.110:9092','10.10.1.111:9092'],value_serializer=lambda m: json.dumps(m).encode('utf-8'))
    future = producer.send('news', item.__dict__)

    # Block for 'synchronous' sends
    try:
        record_metadata = future.get(timeout=10)
        print(record_metadata.topic)
        print(record_metadata.offset)
    except KafkaError:
        print("error")
        pass
