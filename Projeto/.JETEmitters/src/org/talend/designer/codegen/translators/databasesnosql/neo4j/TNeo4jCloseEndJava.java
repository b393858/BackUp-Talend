package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;

public class TNeo4jCloseEndJava
{
  protected static String nl;
  public static synchronized TNeo4jCloseEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jCloseEndJava result = new TNeo4jCloseEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " \t   org.neo4j.driver.v1.Driver driver_";
  protected final String TEXT_2 = " = (org.neo4j.driver.v1.Driver)globalMap.get(\"";
  protected final String TEXT_3 = "\");" + NL + "\t    if(driver_";
  protected final String TEXT_4 = "!=null){" + NL + "       \t \tdriver_";
  protected final String TEXT_5 = ".close();" + NL + "    \t}";
  protected final String TEXT_6 = NL + "    \t\t//Close batch connection" + NL + "\t\torg.neo4j.talend.Neo4jBatchDatabase neo4jBatchDatabase_";
  protected final String TEXT_7 = " = (org.neo4j.talend.Neo4jBatchDatabase) globalMap.get(\"";
  protected final String TEXT_8 = "\");" + NL + "\t\tif (neo4jBatchDatabase_";
  protected final String TEXT_9 = " != null) {" + NL + "\t    \tneo4jBatchDatabase_";
  protected final String TEXT_10 = ".shutdown();" + NL + "    \t\tglobalMap.remove(\"";
  protected final String TEXT_11 = "\");" + NL + "    \t\t}" + NL + "\t\t";
  protected final String TEXT_12 = NL + NL + "org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_13 = " = (org.neo4j.graphdb.GraphDatabaseService) globalMap.get(\"";
  protected final String TEXT_14 = "\");" + NL + "" + NL + "if (databaseService_";
  protected final String TEXT_15 = " != null) {" + NL + "\tdatabaseService_";
  protected final String TEXT_16 = ".shutdown();" + NL + "}" + NL + NL;
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
    String dbconn = "dbService_" + connection;
    String idBatchConn = "neo4jBatchDatabase_" + connection;
    INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
    String dbVersion = ElementParameterParser.getValue(connectionNode, "__DB_VERSION__");
    boolean remoteServer = "true".equalsIgnoreCase(ElementParameterParser.getValue(connectionNode, "__REMOTE_SERVER__"));
    if("NEO4J_3_2_X".equals(dbVersion)){
    	if(remoteServer){
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dbconn);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
     }else{
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(idBatchConn);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(idBatchConn);
    stringBuffer.append(TEXT_11);
    }
     }else{ 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbconn);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
