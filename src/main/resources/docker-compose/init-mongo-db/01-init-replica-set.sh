#!/bin/bash

echo "########### Waiting for primary ###########"
until mongo --host primary  --eval "printjson(db.runCommand({ serverStatus: 1}).ok)"
  do
    echo "########### Sleeping  ###########"
    sleep 5
  done


echo "########### Waiting for replica 01  ###########"
until mongo --host replica01 --eval "printjson(db.runCommand({ serverStatus: 1}).ok)"
  do
    echo "########### Sleeping  ###########"
    sleep 5
  done


echo "########### Waiting for replica 02  ###########"
until mongo --host replica02 --eval "printjson(db.runCommand({ serverStatus: 1}).ok)"
  do
    echo "########### Sleeping  ###########"
    sleep 5
  done

echo "########### All replicas are ready!!!  ###########"

echo "########### Setting up cluster config  ###########"

echo "########### Getting replica set status  ###########"
mongosh --host primary -u root -p root <<EOF
rs.status()
EOF
echo "########### Initiating replica set ###########"
mongosh --host primary -u root -p root  <<EOF
rs.initiate(
   {
      _id: "tutorial-cluster",
      version: 1,
      members: [
         { _id: 0, host : "primary:27017" },
         { _id: 1, host : "replica01:27017" },
         { _id: 2, host : "replica02:27017" }
      ]
   }
)
EOF

echo "########### Getting replica set status again  ###########"
mongosh --host primary -u root -p root   <<EOF
rs.status()
EOF

echo "########### Stopping TEMP instance  ###########"
mongod --shutdown


