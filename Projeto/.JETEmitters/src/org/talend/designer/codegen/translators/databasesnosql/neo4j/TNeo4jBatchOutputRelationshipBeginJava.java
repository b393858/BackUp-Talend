package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TNeo4jBatchOutputRelationshipBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jBatchOutputRelationshipBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jBatchOutputRelationshipBeginJava result = new TNeo4jBatchOutputRelationshipBeginJava();
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
  protected final String TEXT_11 = NL + "// Retrieve start index name" + NL + "String startIndexName = (String) globalMap.get(\"neo4jBatchDatabaseIndexName_";
  protected final String TEXT_12 = "\");" + NL + "neo4jBatchDatabase_";
  protected final String TEXT_13 = ".setBatchInserterIndexes(globalMap.get(\"neo4jBatchDatabaseIndexMap_";
  protected final String TEXT_14 = "\"));" + NL + "" + NL + "// Retrieve end index name" + NL + "String endIndexName = (String)  globalMap.get(\"neo4jBatchDatabaseIndexName_";
  protected final String TEXT_15 = "\");" + NL + "neo4jBatchDatabase_";
  protected final String TEXT_16 = ".setBatchInserterIndexes(globalMap.get(\"neo4jBatchDatabaseIndexMap_";
  protected final String TEXT_17 = "\"));" + NL + "" + NL + "// Create Batch insert" + NL + "org.neo4j.talend.Neo4jBatchInserterRelationship neo4jBatchRelInserter_";
  protected final String TEXT_18 = " = new org.neo4j.talend" + NL + ".Neo4jBatchInserterRelationship(neo4jBatchDatabase_";
  protected final String TEXT_19 = ", \"";
  protected final String TEXT_20 = "\", \"";
  protected final String TEXT_21 = "\"," + NL + "startIndexName, \"";
  protected final String TEXT_22 = "\", endIndexName, \"";
  protected final String TEXT_23 = "\", ";
  protected final String TEXT_24 = ");" + NL + "" + NL + "// Create counter" + NL + "int nb_line_";
  protected final String TEXT_25 = " = 0;" + NL + "    try{";
  protected final String TEXT_26 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    // General Talend object
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    // Component parameters
    String idConn = "neo4jBatchDatabase_" + ElementParameterParser.getValue(node, "__CONNECTION__");
    String relationshipTypeField = ElementParameterParser.getValue(node, "__RELATIONSHIP_TYPE__");
    String direction = ElementParameterParser.getValue(node, "__RELATIONSHIP_DIRECTION__");
    String startIndexNameCid = ElementParameterParser.getValue(node, "__START_INDEX_NAME__");
    String startIndexField = ElementParameterParser.getValue(node, "__START_INDEX_FIELD__");
    String endIndexNameCid = ElementParameterParser.getValue(node, "__END_INDEX_NAME__");
    String endIndexField = ElementParameterParser.getValue(node, "__END_INDEX_FIELD__");
    Boolean skipOnError = !Boolean.valueOf(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
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
    stringBuffer.append(startIndexNameCid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(startIndexNameCid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(endIndexNameCid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(endIndexNameCid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(relationshipTypeField);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(direction);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(startIndexField);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(endIndexField);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(skipOnError);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}
