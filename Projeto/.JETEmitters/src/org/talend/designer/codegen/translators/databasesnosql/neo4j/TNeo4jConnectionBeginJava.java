package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TNeo4jConnectionBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jConnectionBeginJava result = new TNeo4jConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t// Transform configuration to Map configuration" + NL + "\t\tjava.util.Map<String, String> config = new java.util.HashMap();" + NL + "\t";
  protected final String TEXT_2 = NL + "\t                config.put(\"";
  protected final String TEXT_3 = "\", ";
  protected final String TEXT_4 = ");" + NL + "\t            ";
  protected final String TEXT_5 = NL + "\t\t// Just put the database into the global map" + NL + "\t\tglobalMap.put(\"neo4jBatchDatabase_";
  protected final String TEXT_6 = "\", new org.neo4j.talend.Neo4jBatchDatabase(";
  protected final String TEXT_7 = ", config));" + NL + "\t" + NL + "\t";
  protected final String TEXT_8 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = "; ";
  protected final String TEXT_14 = NL + "        org.neo4j.driver.v1.Driver driver_";
  protected final String TEXT_15 = " = org.neo4j.driver.v1.GraphDatabase.driver(";
  protected final String TEXT_16 = ", org.neo4j.driver.v1.AuthTokens.basic(";
  protected final String TEXT_17 = ", decryptedPassword_";
  protected final String TEXT_18 = "));" + NL + "        globalMap.put(\"dbService_";
  protected final String TEXT_19 = "\", driver_";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t        ";
  protected final String TEXT_22 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_23 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = "; ";
  protected final String TEXT_28 = NL + "\t\t\t    org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_29 = " = new org.neo4j.rest.graphdb.RestGraphDatabase(";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ", decryptedPassword_";
  protected final String TEXT_32 = ");" + NL + "\t\t\t    ";
  protected final String TEXT_33 = NL + "\t\t\t    org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_34 = " = new org.neo4j.rest.graphdb.RestGraphDatabase(";
  protected final String TEXT_35 = ");" + NL + "\t\t\t    ";
  protected final String TEXT_36 = NL + "\t            java.util.Map config = new java.util.HashMap();" + NL + "//\t            config.put( \"read_only\", \"true\" );" + NL + "\t\t\t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_37 = " = new org.neo4j.graphdb.factory.GraphDatabaseFactory()" + NL + "\t\t\t\t        .newEmbeddedDatabaseBuilder(";
  protected final String TEXT_38 = ")" + NL + "\t\t\t\t        .setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.read_only, \"true\").newGraphDatabase();" + NL + "//\t\t\t\t        .setConfig(config).newGraphDatabase();" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_40 = " = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(";
  protected final String TEXT_41 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\tglobalMap.put(\"dbService_";
  protected final String TEXT_43 = "_path\", ";
  protected final String TEXT_44 = ");" + NL + "\t    globalMap.put(\"dbService_";
  protected final String TEXT_45 = "\", databaseService_";
  protected final String TEXT_46 = ");" + NL + "\t";
  protected final String TEXT_47 = NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbPath = ElementParameterParser.getValue(node, "__DATABASE_PATH__");

	boolean remoteServer = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOTE_SERVER__"));
	boolean readOnlyMode = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__READ_ONLY_MODE__"));
	String dbVersion = ElementParameterParser.getValue(node,"__DB_VERSION__");

	
	if("NEO4J_3_2_X".equals(dbVersion)&&!remoteServer) {
	    List<Map<String, String>> configuration = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__CONFIGURATION__");
	
    stringBuffer.append(TEXT_1);
    
	    if (configuration != null) {
	        for (Map<String, String> params : configuration) {
	            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(params.get("KEY"));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(params.get("VALUE"));
    stringBuffer.append(TEXT_4);
    
	        }
	    }
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dbPath);
    stringBuffer.append(TEXT_7);
    	
	} else {
	    if("NEO4J_3_2_X".equals(dbVersion)){
            String serverUrl = ElementParameterParser.getValue(node, "__SERVER_URL__");
            String username = ElementParameterParser.getValue(node, "__USERNAME__");
            String passwordFieldName = "__PASSWORD__";
        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    } else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(serverUrl);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
        }else{
		if (remoteServer) {
			String serverUrl = ElementParameterParser.getValue(node, "__SERVER_URL__");
	        boolean setUsername = ElementParameterParser.getBooleanValue(node, "__SET_USERNAME__");
	        String username = ElementParameterParser.getValue(node, "__USERNAME__");
	        String passwordFieldName = "__PASSWORD__";
	        if ((setUsername) || ((!"NEO4J_1_X_X".equals(dbVersion)) && (!"NEO4J_2_1_X".equals(dbVersion)))) {
			    
    stringBuffer.append(TEXT_21);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_24);
    } else {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(serverUrl);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
			} else {
			    
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(serverUrl);
    stringBuffer.append(TEXT_35);
    
			}
		} else {
			if (readOnlyMode) {
				
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(dbPath);
    stringBuffer.append(TEXT_38);
    
			} else {
				
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(dbPath);
    stringBuffer.append(TEXT_41);
    
			}
		}
		
		
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(dbPath);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
     } 
	}
    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}
