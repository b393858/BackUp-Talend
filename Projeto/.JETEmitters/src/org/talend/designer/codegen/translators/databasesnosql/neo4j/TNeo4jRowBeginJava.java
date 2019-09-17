package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;

public class TNeo4jRowBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jRowBeginJava result = new TNeo4jRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\torg.neo4j.driver.v1.Driver driver_";
  protected final String TEXT_2 = " = (org.neo4j.driver.v1.Driver)globalMap.get(\"";
  protected final String TEXT_3 = "\");" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_5 = " = (org.neo4j.graphdb.GraphDatabaseService) globalMap.get(\"";
  protected final String TEXT_6 = "\");" + NL + "\t";
  protected final String TEXT_7 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = "; ";
  protected final String TEXT_13 = NL + "        org.neo4j.driver.v1.Driver driver_";
  protected final String TEXT_14 = " = org.neo4j.driver.v1.GraphDatabase.driver(";
  protected final String TEXT_15 = ", org.neo4j.driver.v1.AuthTokens.basic(";
  protected final String TEXT_16 = ", decryptedPassword_";
  protected final String TEXT_17 = "));" + NL;
  protected final String TEXT_18 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_19 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = "; ";
  protected final String TEXT_24 = NL + "                    org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_25 = " = new org.neo4j.rest.graphdb.RestGraphDatabase(";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = ", decryptedPassword_";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "                    org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_30 = " = new org.neo4j.rest.graphdb.RestGraphDatabase(";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "                    org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_33 = " = new org.neo4j.kernel.EmbeddedGraphDatabase(";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "                    org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_36 = " = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "        try(org.neo4j.driver.v1.Session session_";
  protected final String TEXT_39 = " = driver_";
  protected final String TEXT_40 = ".session()){" + NL + "            org.neo4j.driver.v1.Transaction transaction_";
  protected final String TEXT_41 = " = session_";
  protected final String TEXT_42 = ".beginTransaction();";
  protected final String TEXT_43 = "   " + NL + "    org.neo4j.rest.graphdb.query.QueryEngine<java.util.Map<String, Object>> queryEngine_";
  protected final String TEXT_44 = " = null;" + NL + "    org.neo4j.cypher.ExecutionEngine engine_";
  protected final String TEXT_45 = " = null;" + NL + "    if (databaseService_";
  protected final String TEXT_46 = " instanceof org.neo4j.rest.graphdb.RestGraphDatabase) {" + NL + "    \torg.neo4j.rest.graphdb.RestGraphDatabase restDatabase_";
  protected final String TEXT_47 = " = (org.neo4j.rest.graphdb.RestGraphDatabase) databaseService_";
  protected final String TEXT_48 = "; " + NL + "    \tqueryEngine_";
  protected final String TEXT_49 = " = new org.neo4j.rest.graphdb.query.RestCypherQueryEngine(restDatabase_";
  protected final String TEXT_50 = ".getRestAPI());" + NL + "    } else {";
  protected final String TEXT_51 = NL + "            engine_";
  protected final String TEXT_52 = " = new org.neo4j.cypher.ExecutionEngine(databaseService_";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "            engine_";
  protected final String TEXT_55 = " = new org.neo4j.cypher.ExecutionEngine(databaseService_";
  protected final String TEXT_56 = ", org.neo4j.kernel.impl.util.StringLogger.SYSTEM);";
  protected final String TEXT_57 = NL + "            engine_";
  protected final String TEXT_58 = " = new org.neo4j.cypher.ExecutionEngine(databaseService_";
  protected final String TEXT_59 = ", org.neo4j.logging.FormattedLogProvider.toOutputStream(System.out));";
  protected final String TEXT_60 = NL + "    }" + NL + "    " + NL + "    if (databaseService_";
  protected final String TEXT_61 = ".getClass().equals(org.neo4j.kernel.EmbeddedGraphDatabase.class)) {";
  protected final String TEXT_62 = NL + "            ((org.neo4j.kernel.EmbeddedGraphDatabase)databaseService_";
  protected final String TEXT_63 = ").isAvailable(10000l);";
  protected final String TEXT_64 = NL + "            while (((org.neo4j.kernel.EmbeddedGraphDatabase)databaseService_";
  protected final String TEXT_65 = ").transactionRunning()){" + NL + "                // wait the end of the previous transaction" + NL + "            }";
  protected final String TEXT_66 = NL + "    }" + NL + "    org.neo4j.graphdb.Transaction tx_";
  protected final String TEXT_67 = " = databaseService_";
  protected final String TEXT_68 = ".beginTx();" + NL + "    " + NL + "    ";
  protected final String TEXT_69 = NL + "    resourceMap.put(\"databaseService_";
  protected final String TEXT_70 = "\", databaseService_";
  protected final String TEXT_71 = "); ";
  protected final String TEXT_72 = NL + NL + "long counter_";
  protected final String TEXT_73 = " = 0;" + NL + "long nbNodeInserted_";
  protected final String TEXT_74 = " = 0;" + NL + "long nbRelationshipInserted_";
  protected final String TEXT_75 = " = 0;" + NL + "long nbPropertiesUpdated_";
  protected final String TEXT_76 = " = 0;" + NL + "long nbNodeDeleted_";
  protected final String TEXT_77 = " = 0;" + NL + "long nbRelationshipDeleted_";
  protected final String TEXT_78 = " = 0;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    boolean shutdownDb = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SHUTDOWN_DB__"));
    String dbVersion = ElementParameterParser.getValue(node,"__DB_VERSION__");
	if(useExistingConnection){
	    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
        dbVersion = ElementParameterParser.getValue(connectionNode, "__DB_VERSION__");
    	String dbconn = "dbService_" + connection;
    	if("NEO4J_3_2_X".equals(dbVersion)){
		
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dbconn);
    stringBuffer.append(TEXT_3);
    } else {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dbconn);
    stringBuffer.append(TEXT_6);
    
		}
    } else {
        if("NEO4J_3_2_X".equals(dbVersion)){
            String serverUrl = ElementParameterParser.getValue(node, "__SERVER_URL__");
            String username = ElementParameterParser.getValue(node, "__USERNAME__");
            String passwordFieldName = "__PASSWORD__";
        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    } else {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(serverUrl);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
        }else{
        	boolean remoteServer = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOTE_SERVER__"));
        	if (remoteServer) {
                String serverUrl = ElementParameterParser.getValue(node, "__SERVER_URL__");
                boolean setUsername = ElementParameterParser.getBooleanValue(node, "__SET_USERNAME__");
                String username = ElementParameterParser.getValue(node, "__USERNAME__");
                String passwordFieldName = "__PASSWORD__";
                if ((setUsername) || ((!"NEO4J_1_X_X".equals(dbVersion)) && (!"NEO4J_2_1_X".equals(dbVersion)))) {
                    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_20);
    } else {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(serverUrl);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
                } else {
                    
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(serverUrl);
    stringBuffer.append(TEXT_31);
    
                }
        	} else {
    	    	String databasePath = ElementParameterParser.getValue(node, "__DATABASE_PATH__");
    	    	if ("NEO4J_1_X_X".equals(dbVersion)) {
                    
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(databasePath);
    stringBuffer.append(TEXT_34);
    
                } else { // NEO4J_2_1_X or NEO4J_2_2_X or "NEO4J_2_3_X"
                    
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(databasePath);
    stringBuffer.append(TEXT_37);
    
                }
    		}
		}
    }

if ("NEO4J_3_2_X".equals(dbVersion)){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
}else{

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
        if ("NEO4J_1_X_X".equals(dbVersion)) {
            
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
        } else if (("NEO4J_2_1_X".equals(dbVersion)) || ("NEO4J_2_2_X".equals(dbVersion)) || ("NEO4J_3_X_X".equals(dbVersion))) { // NEO4J_2_X before moving to spring framework
            
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
        } else { // NEO4J_2_3 and more using spring framework
            
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
        }
        
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
        if ("NEO4J_2_2_X".equals(dbVersion) || "NEO4J_2_3_X".equals(dbVersion) || ("NEO4J_3_X_X".equals(dbVersion))) { // usage of Spring rest
    
            
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
        } else {
            
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
        }
        
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
    	if (!useExistingConnection||(useExistingConnection && shutdownDb)) {
    
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
    	}
}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    return stringBuffer.toString();
  }
}
