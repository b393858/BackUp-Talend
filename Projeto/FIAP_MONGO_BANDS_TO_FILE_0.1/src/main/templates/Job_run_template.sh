#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/dom4j-1.6.1.jar:$ROOT_PATH/../lib/log4j-1.2.17.jar:$ROOT_PATH/../lib/mongo-java-driver-3.8.2.jar:$ROOT_PATH/../lib/talendcsv.jar:$ROOT_PATH/mongo_bands_to_file_0_1.jar: fiap.mongo_bands_to_file_0_1.mongo_bands_to_file  "$@"