%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=%cd%/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/dom4j-1.6.1.jar;../lib/log4j-1.2.17.jar;../lib/ojdbc6.jar;../lib/talend-oracle-timestamptz.jar;../lib/talend_file_enhanced_20070724.jar;../lib/talendcsv.jar;files_to_oracle_0_1.jar; fiap.files_to_oracle_0_1.files_to_oracle  %*