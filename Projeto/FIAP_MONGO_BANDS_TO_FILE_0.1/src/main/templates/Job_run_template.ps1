$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' -cp '.;../lib/routines.jar;../lib/dom4j-1.6.1.jar;../lib/log4j-1.2.17.jar;../lib/mongo-java-driver-3.8.2.jar;../lib/talendcsv.jar;mongo_bands_to_file_0_1.jar;' fiap.mongo_bands_to_file_0_1.mongo_bands_to_file  %*