%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=%cd%/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/dom4j-1.6.1.jar;../lib/log4j-1.2.17.jar;../lib/ojdbc6.jar;../lib/talend-oracle-timestamptz.jar;../lib/talendcsv.jar;oracle_hr_to_file__0_1.jar; fiap.oracle_hr_to_file__0_1.oracle_hr_to_file_  %*