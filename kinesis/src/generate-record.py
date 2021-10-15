import json
import datetime
import random
import testdata
from boto import kinesis

kinesis = kinesis.connect_to_region("us-west-2")

def getData(iotName, lowVal, highVal):
   data = {}
   data["iotName"] = iotName
   data["iotValue"] = random.randint(lowVal, highVal)
   return data

while 1:
   rnd = random.random()
   if (rnd < 0.01):
      data = json.dumps(getData("DemoSensor", 100, 120))
      kinesis.put_record("RawStreamData", data, "DemoSensor")
      print '***************************** anomaly ************************* ' + data
   else:
      data = json.dumps(getData("DemoSensor", 10, 20))
      kinesis.put_record("RawStreamData", data, "DemoSensor")
      print data