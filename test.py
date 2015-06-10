#coding=utf-8
#!/usr/bin/python
import requests
import json
import MySQLdb

r = requests.get('http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads/A014A5A11001768D/comments/hot/0/10/100/50/50')
print(r.json())

