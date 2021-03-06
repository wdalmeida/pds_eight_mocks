from datetime import datetime
from faker import Faker
import urllib.request, json, random, socket
from bean.rssfeed import RSSFeed
from utils import kafkaProducer
import time


def main():
    title= fake.text(40)
    description = fake.text(140)
    text= []
    for y in range(10):
     text.append(fake.text(1000))
    date= datetime.now().strftime('%Y-%m-%d%H%M%S%f')
    ts = int(time.time())
    link= "http://rss.eight.inside.esiag.info/news/news"+date+".html"
    print(date)
    f= open("/var/www/html/news/news%s.html" % (date),"w+")
    f.write("<!DOCTYPE html>\r\n<html>\r\n<body>")
    f.write("<h1>%s</h1>\r\n" % (title))
    img=getrandomimage("https://pixabay.com/api/?key=7556704-e5037c27e687e614ba637565b&q=finance+bank&image_type=photo")
    f.write("<img src='%s'/>" %(img))
    for z in range(random.randrange(1,len(text))):
      f.write("<p>%s</p>" %(text[z]))
    f.write("<img src='https://pixabay.com/static/img/logo.svg'/>")
    f.write("</body></html>")
    f.close()
    sendItemToFeed(title,link,description,img,ts)


def getrandomimage(url):
    with urllib.request.urlopen(url) as response:
      data = json.loads(response.read().decode())
      rand = random.randrange(len(data["hits"]))
      print(random.randrange(rand))
      img=data["hits"][random.randrange(rand)]["webformatURL"]
    return img


def sendItemToFeed(title,link,description,imgLink,date):
    item = RSSFeed(title,link,description,imgLink,date)
    kafkaProducer.send(item)
    print(json.dumps(item.__dict__))

if __name__== "__main__":
  fake = Faker('fr_Fr')
  main()