from kafka import KafkaConsumer
import json

from utils import writeXML

consumer = KafkaConsumer('news',
                             group_id='rssConsumer',
                             bootstrap_servers=['10.10.1.110:9092','10.10.1.111:9092'], auto_offset_reset='latest',
                             enable_auto_commit=True)
for message in consumer:
    print("%s:%d:%d: key=%s value=%s" % (message.topic, message.partition,
                                         message.offset, message.key,
                                         message.value.decode('utf-8')))
    json_data = message.value.decode('utf-8')
    writeXML.create(json.loads(json_data))