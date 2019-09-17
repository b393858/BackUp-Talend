package org.talend.designer.codegen.translators.databasesnosql.mongodb;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMongoDBOutputFinallyJava
{
  protected static String nl;
  public static synchronized TMongoDBOutputFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBOutputFinallyJava result = new TMongoDBOutputFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tif(resourceMap.get(\"finish_";
  protected final String TEXT_2 = "\") == null){" + NL + "\t\t\tif(resourceMap.get(\"mongo_";
  protected final String TEXT_3 = "\") != null){" + NL + "" + NL + "\t\t\t" + NL + "\t\t    ";
  protected final String TEXT_4 = NL + "\t\t    \t\t\t";
  protected final String TEXT_5 = NL + "\t\t                       log.info(\"";
  protected final String TEXT_6 = " - Closing the connection \" + ((com.mongodb.MongoClient)resourceMap.get(\"mongo_";
  protected final String TEXT_7 = "\")).getServerAddressList() + \".\");" + NL + "\t\t    \t\t\t";
  protected final String TEXT_8 = NL + "\t\t    \t\t\t       ((com.mongodb.MongoClient)resourceMap.get(\"mongo_";
  protected final String TEXT_9 = "\")).close();" + NL + "\t\t    ";
  protected final String TEXT_10 = NL + "\t\t               ";
  protected final String TEXT_11 = NL + "\t\t                       log.info(\"";
  protected final String TEXT_12 = " - Closing the connection \" + ((com.mongodb.Mongo)resourceMap.get(\"mongo_";
  protected final String TEXT_13 = "\")).getServerAddressList() + \".\");" + NL + "\t\t               ";
  protected final String TEXT_14 = NL + "\t\t                       ((com.mongodb.Mongo)resourceMap.get(\"mongo_";
  protected final String TEXT_15 = "\")).close();" + NL + "\t\t    ";
  protected final String TEXT_16 = NL + "\t\t    " + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_18 = " - The connection was closed successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_20 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	    String dbversion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	if(!"true".equals(useExistingConn)){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    if(dbversion.equals("MONGODB_3_5_X")){
    stringBuffer.append(TEXT_4);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    } else {
    stringBuffer.append(TEXT_10);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
			}
			
    stringBuffer.append(TEXT_19);
    
	}

    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
