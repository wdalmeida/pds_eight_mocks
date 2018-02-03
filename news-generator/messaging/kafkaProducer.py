import json
from kafka import KafkaProducer
from kafka.errors import KafkaError


def send(item):
    producer = KafkaProducer(bootstrap_servers=['10.10.1.110.:9092','10.10.1.110.:9092'],value_serializer=lambda m: json.dumps(m).encode('utf-8'))

    # produce json messages
    future = producer.send('news', item.__dict__)

    # Block for 'synchronous' sends
    try:
        record_metadata = future.get(timeout=10)
        # Successful result returns assigned partition and offset
        print(record_metadata.topic)
        print(record_metadata.offset)
    except KafkaError:
        print("error")
        pass
