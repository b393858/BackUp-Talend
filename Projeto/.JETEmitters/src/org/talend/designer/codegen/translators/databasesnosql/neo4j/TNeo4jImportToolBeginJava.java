package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TNeo4jImportToolBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jImportToolBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jImportToolBeginJava result = new TNeo4jImportToolBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "// Transform nodes files params" + NL + "java.util.List<java.util.Map<String, String>> nodes = new java.util.ArrayList();";
  protected final String TEXT_3 = NL + "                java.util.Map<String, String> mapN_";
  protected final String TEXT_4 = " = new java.util.HashMap<>();";
  protected final String TEXT_5 = NL + "                    mapN_";
  protected final String TEXT_6 = ".put(\"";
  protected final String TEXT_7 = "\", ";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "                nodes.add(mapN_";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + NL + "// Transform nodes files params to a List" + NL + "java.util.List<java.util.Map<String, String>> relationships = new java.util.ArrayList();";
  protected final String TEXT_12 = NL + "            java.util.Map<String, String> mapR_";
  protected final String TEXT_13 = " = new java.util.HashMap<>();";
  protected final String TEXT_14 = NL + "                mapR_";
  protected final String TEXT_15 = ".put(\"";
  protected final String TEXT_16 = "\", ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "            relationships.add(mapR_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + NL + "// Transform neo4j configuration params to a Map" + NL + "java.util.Map<String, String> configNeo = new java.util.HashMap();";
  protected final String TEXT_21 = NL + "                configNeo.put(\"";
  protected final String TEXT_22 = "\", ";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + NL + "// Transform import configuration params to a Map" + NL + "java.util.Map<String, String> configImport = new java.util.HashMap();";
  protected final String TEXT_25 = NL + "                configImport.put(\"";
  protected final String TEXT_26 = "\", ";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + NL + NL + "// Just create the importTool" + NL + "org.neo4j.talend.Neo4jImportTool neo4jImportTool_";
  protected final String TEXT_29 = " = new org.neo4j.talend.Neo4jImportTool(";
  protected final String TEXT_30 = ", configNeo, configImport, nodes, relationships);";
  protected final String TEXT_31 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    // General Talend object
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    // Component parameters
    String dbPath = ElementParameterParser.getValue(node, "__DATABASE_PATH__");
    List<Map<String, String>> nodesFiles = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__NODE_FILES__");
    List<Map<String, String>> relationshipsFiles = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__RELATIONSHIP_FILES__");
    List<Map<String, String>> importConfig = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__IMPORT_CONFIGURATION__");
    List<Map<String, String>> neo4jConfig = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__NEO4J_CONFIGURATION__");

    stringBuffer.append(TEXT_2);
    
    if (nodesFiles != null) {
        int i=0;
        for (java.util.Map<String, String> params : nodesFiles) {
            i++;
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_4);
    
                    for(java.util.Map.Entry<String, String> entry : params.entrySet()) {
                
    stringBuffer.append(TEXT_5);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(entry.getValue());
    stringBuffer.append(TEXT_8);
    
                    }
                
    stringBuffer.append(TEXT_9);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_10);
    
        }
    }

    stringBuffer.append(TEXT_11);
    
    if (relationshipsFiles != null) {
        int j=0;
        for (java.util.Map<String, String> params : relationshipsFiles) {
            j++;
            
    stringBuffer.append(TEXT_12);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_13);
    
                for(java.util.Map.Entry<String, String> entry : params.entrySet()) {
            
    stringBuffer.append(TEXT_14);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(entry.getValue());
    stringBuffer.append(TEXT_17);
    
                }
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_19);
    
        }
    }

    stringBuffer.append(TEXT_20);
    
    if (neo4jConfig != null) {
        for (Map<String, String> params : neo4jConfig) {
            
    stringBuffer.append(TEXT_21);
    stringBuffer.append(params.get("KEY"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(params.get("VALUE"));
    stringBuffer.append(TEXT_23);
    
        }
    }

    stringBuffer.append(TEXT_24);
    
    if (importConfig != null) {
        for (Map<String, String> params : importConfig) {
            
    stringBuffer.append(TEXT_25);
    stringBuffer.append(params.get("KEY"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(params.get("VALUE"));
    stringBuffer.append(TEXT_27);
    
        }
    }

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dbPath);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}
