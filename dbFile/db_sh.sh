#!/bin/bash
if [ $# -eq 0 ]; then
  echo "No arguments supplied"
fi
mysql -h "devsecopspocmysql.mysql.database.azure.com" -u "devsecopspoc" -p "Eadevops#1234" 
