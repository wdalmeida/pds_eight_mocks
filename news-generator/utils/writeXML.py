#!/usr/bin/python3.6
# -*- coding: utf-8 -*-
import os
import datetime
from subprocess import call


def create_xml_header():
    f = open("header.xml", "w+" )
    f.write('<?xml version="1.0" encoding="UTF-8" ?>\r\n')
    f.write('<rss version="2.0">\r\n')
    f.write('<channel>\r\n')
    f.write('  <title>BEM Finance</title>\r\n')
    f.write('  <link>http://rss.eight.inside.esiag.info</link>\r\n')
    f.write('  <description>Informations sur l\'écomomie et la finance</description>\r\n')


def createXMLBody():
    if os.path.isfile("item.xml") and os.path.isfile("body.xml"):
        print("exist")
        call(["mv","body.xml","body_old.xml"])
        os.system("cat item.xml body_old.xml > body.xml")
    else:
        print("new  file")
        os.system("cat item.xml > body.xml")

def createXMLFooter():
    f = open("footer.xml", "w+" )
    f.write('</channel>\r\n')
    f.write('</rss>')
    f.close()


def createXMLItem(item):
    f = open("item.xml", "w+", )
    f.write('  <item>\r\n')
    f.write('    <title>'+item['title']+'</title>\r\n')
    f.write('    <link>'+item['link']+'</link>\r\n')
    f.write('    <description>'+item['description']+'</description>\r\n')
    f.write('    <enclosure url="'+item['imgLink']+'"/>\r\n')
    f.write('    <pubDate>'+datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')+'</pubDate>\r\n')
    f.write('  </item>\r\n')


def createXMLFeed():
    if os.path.isfile("header.xml") and os.path.isfile("body.xml") and os.path.isfile("footer.xml"):
        print("Writing rss file")
        if os.path.isfile("rss.xml"):
            call(["mv","rss.xml","rss_old.xml"])
        os.system("cat header.xml body.xml footer.xml > rss.xml")
        call(["cp", "rss.xml", "/var/www/html/"])


def create(item):
    create_xml_header()
    createXMLFooter()
    createXMLItem(item)
    createXMLBody()
    createXMLFeed()