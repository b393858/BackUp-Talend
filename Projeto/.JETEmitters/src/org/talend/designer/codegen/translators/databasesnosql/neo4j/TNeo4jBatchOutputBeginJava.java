package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TNeo4jBatchOutputBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jBatchOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jBatchOutputBeginJava result = new TNeo4jBatchOutputBeginJava();
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
  protected final String TEXT_11 = NL + "// Create Batch Node insert" + NL + "org.neo4j.talend.Neo4jBatchInserterNode neo4jBatchNodeInserter_";
  protected final String TEXT_12 = " = new org.neo4j.talend.Neo4jBatchInserterNode(neo4jBatchDatabase_";
  protected final String TEXT_13 = ", \"";
  protected final String TEXT_14 = "\", ";
  protected final String TEXT_15 = ", \"";
  protected final String TEXT_16 = "\",";
  protected final String TEXT_17 = ",";
  protected final String TEXT_18 = ");" + NL + "" + NL + "// Put the index name into the global map" + NL + "globalMap.put(\"neo4jBatchDatabaseIndexName_";
  protected final String TEXT_19 = "\", ";
  protected final String TEXT_20 = ");" + NL + "globalMap.put(\"neo4jBatchDatabaseIndexMap_";
  protected final String TEXT_21 = "\", neo4jBatchDatabase_";
  protected final String TEXT_22 = ".getBatchInserterIndexes());" + NL + "" + NL + "// Create counter" + NL + "int nb_line_";
  protected final String TEXT_23 = " = 0;" + NL + "" + NL + "   try{";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    // General Talend object
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    // Component parameter
    String idConn = "neo4jBatchDatabase_" + ElementParameterParser.getValue(node, "__CONNECTION__");
    String labelsField = (String) ElementParameterParser.getValue(node, "__LABEL_FIELD__");
    String batchIndexName = (String) ElementParameterParser.getValue(node, "__IMPORT_INDEX_NAME__");
    String batchIndexFieldName = (String) ElementParameterParser.getValue(node, "__IMPORT_ID_FIELD__");
    Boolean insertIndexFieldName = Boolean.valueOf(ElementParameterParser.getValue(node, "__INSERT_IMPORT_ID_FIELD__"));
    Integer indexCacheSize = Integer.valueOf(ElementParameterParser.getValue(node, "__IMPORT_INDEX_CACHE_SIZE__"));
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(labelsField);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(batchIndexName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(batchIndexFieldName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(insertIndexFieldName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(indexCacheSize);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(batchIndexName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
