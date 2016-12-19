from simple import MQTTClient

# Connection information
mqtthost = 'mqtt.enco.io'
mqttport = 8883
mqttssl = True
# Channel specific parameters
uname = '<< YOUR INFO HERE >>'
pwval = '<< YOUR INFO HERE >>'
topicName = '<< YOUR INFO HERE >>'
deviceId = '<< YOUR INFO HERE >>'

# Create an instance for further use, connect and use directly
connection = MQTTClient(client_id=deviceId, server=mqtthost,  port=mqttport,user=uname, password=pwval, ssl=mqttssl)
print('Connect to broker',mqtthost,':', str(mqttport))
connection.connect()
print('Publish to ', topicName)
connection.publish(topicName, b'MQTTS Greetings from the WiPy !!')
print('Close')
connection.disconnect()
print('All done')