package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TNeo4jBatchOutputRelationshipEndJava
{
  protected static String nl;
  public static synchronized TNeo4jBatchOutputRelationshipEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jBatchOutputRelationshipEndJava result = new TNeo4jBatchOutputRelationshipEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "    neo4jBatchRelInserter_";
  protected final String TEXT_2 = ".finish();" + NL + "" + NL + "    globalMap.put(\"";
  protected final String TEXT_3 = "_NB_LINE\", nb_line_";
  protected final String TEXT_4 = ");" + NL + "" + NL + "        }finally{";
  protected final String TEXT_5 = NL + "    \tneo4jBatchDatabase_";
  protected final String TEXT_6 = ".shutdown();" + NL + "\t";
  protected final String TEXT_7 = NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    // General Talend object
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean shutdownDb = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SHUTDOWN_DB__"));
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
        if(!useExistingConnection||(useExistingConnection && shutdownDb)){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
