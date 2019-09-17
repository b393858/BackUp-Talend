package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;

public class TNeo4jInputEndJava
{
  protected static String nl;
  public static synchronized TNeo4jInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jInputEndJava result = new TNeo4jInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    }";
  protected final String TEXT_2 = NL + "    \t" + NL + "    }finally{";
  protected final String TEXT_3 = NL + "    \tdriver_";
  protected final String TEXT_4 = ".close();" + NL;
  protected final String TEXT_5 = NL + "    }";
  protected final String TEXT_6 = NL + "\t\t" + NL + "\t}finally{" + NL + "\t\tdatabaseService_";
  protected final String TEXT_7 = ".shutdown();" + NL + "\t}";
  protected final String TEXT_8 = NL + NL + NL + "globalMap.put(\"";
  protected final String TEXT_9 = "_NB_LINE\", nb_line_";
  protected final String TEXT_10 = ");";

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
    }
    stringBuffer.append(TEXT_1);
    
    if ("NEO4J_3_2_X".equals(dbVersion)) {
    
    stringBuffer.append(TEXT_2);
    if (!useExistingConnection||(useExistingConnection && shutdownDb)) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    
    } else{
	if (!useExistingConnection||(useExistingConnection && shutdownDb)) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
	}
}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
