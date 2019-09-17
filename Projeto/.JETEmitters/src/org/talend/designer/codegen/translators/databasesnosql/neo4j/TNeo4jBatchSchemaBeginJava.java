package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TNeo4jBatchSchemaBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jBatchSchemaBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jBatchSchemaBeginJava result = new TNeo4jBatchSchemaBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t// Transform configuration to Map configuration" + NL + "\t\tjava.util.Map<String, String> config = new java.util.HashMap();" + NL + "\t";
  protected final String TEXT_2 = NL + "\t                config.put(\"";
  protected final String TEXT_3 = "\", ";
  protected final String TEXT_4 = ");" + NL + "\t            ";
  protected final String TEXT_5 = NL + "\t\t// Just put the database into the global map" + NL + "\t\torg.neo4j.talend.Neo4jBatchDatabase neo4jBatchDatabase_";
  protected final String TEXT_6 = " = new org.neo4j.talend.Neo4jBatchDatabase(";
  protected final String TEXT_7 = ", config);" + NL + "\t" + NL + "\t";
  protected final String TEXT_8 = NL + NL + "// Retrieve connection" + NL + "org.neo4j.talend.Neo4jBatchDatabase neo4jBatchDatabase_";
  protected final String TEXT_9 = " = (org.neo4j.talend.Neo4jBatchDatabase) globalMap.get(\"";
  protected final String TEXT_10 = "\");" + NL + "\t";
  protected final String TEXT_11 = NL + "\ttry{" + NL + "\t";
  protected final String TEXT_12 = NL + "                neo4jBatchDatabase_";
  protected final String TEXT_13 = ".createSchema(\"";
  protected final String TEXT_14 = "\", ";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "    }finally{";
  protected final String TEXT_18 = NL + "    \tneo4jBatchDatabase_";
  protected final String TEXT_19 = ".shutdown();" + NL + "\t";
  protected final String TEXT_20 = NL + "    }" + NL;
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    // General Talend object
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    // Component parameter
    String idConn = "neo4jBatchDatabase_" + ElementParameterParser.getValue(node, "__CONNECTION__");
    List<Map<String, String>> schemaDefinitions = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__SCHEMA__");
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    boolean shutdownDb = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SHUTDOWN_DB__"));
    
	if(!useExistingConnection) {
	    List<Map<String, String>> configuration = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__CONFIGURATION__");
	    String dbPath = ElementParameterParser.getValue(node, "__DATABASE_PATH__");
	
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
    	
	}else{
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(idConn);
    stringBuffer.append(TEXT_10);
    
	}
	
    stringBuffer.append(TEXT_11);
    
    if (schemaDefinitions != null) {
        for (Map<String, String> definition : schemaDefinitions) {
            
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(definition.get("TYPE"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(definition.get("LABEL"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(definition.get("PROPERTY"));
    stringBuffer.append(TEXT_16);
    
        }
    }

    stringBuffer.append(TEXT_17);
    
        if(!useExistingConnection||(useExistingConnection && shutdownDb)){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
