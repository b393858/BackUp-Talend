package org.talend.designer.codegen.translators.bigdata.dbfs;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TDBFSGetBeginJava
{
  protected static String nl;
  public static synchronized TDBFSGetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDBFSGetBeginJava result = new TDBFSGetBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + NL + "\torg.talend.bigdata.launcher.fs.DatabricksFileSystem dbfs_";
  protected final String TEXT_3 = " = new org.talend.bigdata.launcher.fs.DatabricksFileSystem(";
  protected final String TEXT_4 = ", ";
  protected final String TEXT_5 = ", routines.system.Constant.getUserAgent(\"";
  protected final String TEXT_6 = "\"));" + NL + "\t" + NL + "\t" + NL + "\tint nb_file_";
  protected final String TEXT_7 = " = 0;" + NL + "\tint nb_success_";
  protected final String TEXT_8 = " = 0;" + NL + "\t" + NL + "\tString localPath_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ";" + NL + "\tif(localPath_";
  protected final String TEXT_11 = "!=null&&!\"\".equals(localPath_";
  protected final String TEXT_12 = ")){" + NL + "\t\tjava.io.File localDir_";
  protected final String TEXT_13 = " = new java.io.File(localPath_";
  protected final String TEXT_14 = ");" + NL + "\t\tlocalDir_";
  protected final String TEXT_15 = ".mkdirs();" + NL + "\t}else{" + NL + "\t\tthrow new RuntimeException(\"The local Dir required\");" + NL + "\t}" + NL + "\tjava.util.List<String> msg_";
  protected final String TEXT_16 = " = new java.util.ArrayList<String>();" + NL + "    java.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_17 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "\t";
  protected final String TEXT_18 = "    " + NL + "\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_19 = "_";
  protected final String TEXT_20 = " = new java.util.HashMap<String,String>();" + NL + "\t\tmap_";
  protected final String TEXT_21 = "_";
  protected final String TEXT_22 = ".put(";
  protected final String TEXT_23 = ",";
  protected final String TEXT_24 = ");\t\t" + NL + "\t \tlist_";
  protected final String TEXT_25 = ".add(map_";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = ");       " + NL + "\t";
  protected final String TEXT_28 = NL + NL + "\tfor (java.util.Map<String, String> map_";
  protected final String TEXT_29 = " : list_";
  protected final String TEXT_30 = ") " + NL + "\t{" + NL;
  protected final String TEXT_31 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");
	boolean overwrite = ElementParameterParser.getBooleanValue(node, "__OVERWRITE__");
	String remotedir = ElementParameterParser.getValue(node, "__DATABRICKS_DBFS_FOLDER__");
	boolean includeSubDir = ElementParameterParser.getBooleanValue(node, "__INCLUDSUBDIR__");
	List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_1);
    
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(token);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(org.talend.commons.utils.VersionUtils.getDisplayVersion());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
    for (int i=0; i<files.size(); i++) {
       	Map<String, String> line = files.get(i);
	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_27);
    
  	}
	
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}
