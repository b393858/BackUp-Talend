package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TNeo4jBatchOutputRelationshipMainJava
{
  protected static String nl;
  public static synchronized TNeo4jBatchOutputRelationshipMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jBatchOutputRelationshipMainJava result = new TNeo4jBatchOutputRelationshipMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "    List<String> columnList_";
  protected final String TEXT_3 = " = new java.util.ArrayList<String>();" + NL;
  protected final String TEXT_4 = NL + "            columnList_";
  protected final String TEXT_5 = ".add(\"";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = NL + NL + "    neo4jBatchRelInserter_";
  protected final String TEXT_8 = ".create(";
  protected final String TEXT_9 = ",  columnList_";
  protected final String TEXT_10 = ");" + NL + "" + NL + "    // Increment counter" + NL + "    nb_line_";
  protected final String TEXT_11 = "++;" + NL + NL + NL + NL + NL;
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    // General Talend object
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if (metadatas != null && metadatas.size() > 0) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata != null) {
            for(IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_6);
    
             }
        }
    }

    List<? extends IConnection> inputs = node.getIncomingConnections();
    List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
    String incomingConnName = null;
    String outgoingConnName = null;

    if (inputs.size() > 0) {
        IConnection in = inputs.get(0);
        incomingConnName = in.getName();
    }

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
