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
    f.write('  <link>http://prod.eight.inside.esiag.info</link>\r\n')
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


def createXMLItem():
    f = open("item.xml", "w+", )
    f.write('  <item>\r\n')
    f.write('    <title>Seconde Ones</title>\r\n')
    f.write('    <link>https://www.google.com/</link>\r\n')
    f.write('    <description>New RSS tutorial on W3Schools</description>\r\n')
    f.write('    <enclosure url="https://www.w3schools.com/xml/rss.mp3"/>\r\n')
    f.write('    <pubDate>'+datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')+'</pubDate>\r\n')
    f.write('  </item>\r\n')


def createXMLFeed():
    if os.path.isfile("header.xml") and os.path.isfile("body.xml") and os.path.isfile("footer.xml"):
        print("Writing rss file")
        if os.path.isfile("rss.xml"):
            call(["mv","rss.xml","rss_old.xml"])
        os.system("cat header.xml body.xml footer.xml > rss.xml")


def main():
    create_xml_header()
    createXMLFooter()
    createXMLItem()
    createXMLBody()
    createXMLFeed()


if __name__ == "__main__":
    main()
