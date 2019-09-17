package org.talend.designer.codegen.translators.bigdata.dbfs;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TDBFSPutBeginJava
{
  protected static String nl;
  public static synchronized TDBFSPutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDBFSPutBeginJava result = new TDBFSPutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t";
  protected final String TEXT_2 = NL + NL + "\t";
  protected final String TEXT_3 = NL + NL + "\torg.talend.bigdata.launcher.fs.DatabricksFileSystem dbfs_";
  protected final String TEXT_4 = " = new org.talend.bigdata.launcher.fs.DatabricksFileSystem(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ", routines.system.Constant.getUserAgent(\"";
  protected final String TEXT_7 = "\"));" + NL + "\t" + NL + "\tdbfs_";
  protected final String TEXT_8 = ".setOverwrite(";
  protected final String TEXT_9 = ");" + NL + "" + NL + "\tint nb_file_";
  protected final String TEXT_10 = " = 0;" + NL + "\tint nb_success_";
  protected final String TEXT_11 = " = 0;" + NL + "\t" + NL + "\tjava.util.List<String> msg_";
  protected final String TEXT_12 = " = new java.util.ArrayList<String>();" + NL + "    java.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_13 = " = new java.util.ArrayList<java.util.Map<String,String>>();\t" + NL + "\t";
  protected final String TEXT_14 = "    " + NL + "\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_15 = "_";
  protected final String TEXT_16 = " = new java.util.HashMap<String,String>();" + NL + "\t\tmap_";
  protected final String TEXT_17 = "_";
  protected final String TEXT_18 = ".put(";
  protected final String TEXT_19 = ",";
  protected final String TEXT_20 = ");\t\t" + NL + "\t \tlist_";
  protected final String TEXT_21 = ".add(map_";
  protected final String TEXT_22 = "_";
  protected final String TEXT_23 = ");       " + NL + "\t";
  protected final String TEXT_24 = "\t" + NL + "" + NL + "\tString localdir_";
  protected final String TEXT_25 = "  = ";
  protected final String TEXT_26 = ";\t" + NL + "\tfor (java.util.Map<String, String> map_";
  protected final String TEXT_27 = " : list_";
  protected final String TEXT_28 = ") " + NL + "\t{" + NL;
  protected final String TEXT_29 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");	
	String remotedir = ElementParameterParser.getValue(node, "__DATABRICKS_DBFS_FOLDER__");
	String overwrite = ElementParameterParser.getValue(node, "__OVERWRITE__");
	List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");

    stringBuffer.append(TEXT_2);
    
boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
String endpoint = ElementParameterParser.getValue(node, "__DATABRICKS_ENDPOINT__");
String token = ElementParameterParser.getValue(node, "__DATABRICKS_TOKEN__");

if(useExistingConnection) { // We re use the existing connection, coming from the linked component.
    String connectionSid = ElementParameterParser.getValue(node, "__CONNECTION__");
    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
    for(INode targetNode : nodes){
		if (targetNode.getUniqueName().equals(connectionSid)) {
		    endpoint = ElementParameterParser.getValue(targetNode, "__DATABRICKS_ENDPOINT__");
		    token = ElementParameterParser.getValue(targetNode, "__DATABRICKS_TOKEN__");
		    break;
		}
	}
}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(token);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(org.talend.commons.utils.VersionUtils.getDisplayVersion());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(overwrite);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
    for (int i=0; i<files.size(); i++) {
    	Map<String, String> line = files.get(i);
		
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_23);
    
	}
	
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}
