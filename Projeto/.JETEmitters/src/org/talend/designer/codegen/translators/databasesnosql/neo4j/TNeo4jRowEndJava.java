package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.utils.NodeUtil;

public class TNeo4jRowEndJava
{
  protected static String nl;
  public static synchronized TNeo4jRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jRowEndJava result = new TNeo4jRowEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        transaction_";
  protected final String TEXT_2 = ".success();" + NL + "    \ttransaction_";
  protected final String TEXT_3 = ".close();" + NL + "        globalMap.put(\"";
  protected final String TEXT_4 = "_NB_NODE_INSERTED\", nbNodeInserted_";
  protected final String TEXT_5 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_6 = "_NB_RELATIONSHIP_INSERTED\", nbRelationshipInserted_";
  protected final String TEXT_7 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_8 = "_NB_PROPERTY_UPDATED\", nbPropertiesUpdated_";
  protected final String TEXT_9 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_10 = "_NB_NODE_DELETED\", nbNodeDeleted_";
  protected final String TEXT_11 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_12 = "_NB_RELATIONSHIP_DELETED\", nbRelationshipDeleted_";
  protected final String TEXT_13 = ");" + NL + "    }finally{";
  protected final String TEXT_14 = NL + "    \tdriver_";
  protected final String TEXT_15 = ".close();" + NL;
  protected final String TEXT_16 = NL + "    }";
  protected final String TEXT_17 = NL + "        if (counter_";
  protected final String TEXT_18 = " % Long.parseLong(";
  protected final String TEXT_19 = ") > 0) {" + NL + "            tx_";
  protected final String TEXT_20 = ".success();" + NL + "            tx_";
  protected final String TEXT_21 = ".finish();" + NL + "        }";
  protected final String TEXT_22 = NL + "        try {" + NL + "            tx_";
  protected final String TEXT_23 = ".success();" + NL + "        } finally {" + NL + "            tx_";
  protected final String TEXT_24 = ".close();" + NL + "        }";
  protected final String TEXT_25 = NL + "\tdatabaseService_";
  protected final String TEXT_26 = ".shutdown();" + NL + "\tresourceMap.put(\"finish_";
  protected final String TEXT_27 = "\", true); ";
  protected final String TEXT_28 = NL + "\tif(engine_";
  protected final String TEXT_29 = "!=null){" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_30 = "_NB_NODE_INSERTED\", nbNodeInserted_";
  protected final String TEXT_31 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_32 = "_NB_RELATIONSHIP_INSERTED\", nbRelationshipInserted_";
  protected final String TEXT_33 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_34 = "_NB_PROPERTY_UPDATED\", nbPropertiesUpdated_";
  protected final String TEXT_35 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_36 = "_NB_NODE_DELETED\", nbNodeDeleted_";
  protected final String TEXT_37 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_38 = "_NB_RELATIONSHIP_DELETED\", nbRelationshipDeleted_";
  protected final String TEXT_39 = ");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_40 = NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean shutdownDb = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SHUTDOWN_DB__"));
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__"); 

    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    String dbVersion = ElementParameterParser.getValue(node,"__DB_VERSION__");
	if(useExistingConnection){
	    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
        dbVersion = ElementParameterParser.getValue(connectionNode, "__DB_VERSION__");
    }
    if ("NEO4J_3_2_X".equals(dbVersion)) {
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    if (!useExistingConnection||(useExistingConnection && shutdownDb)) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    
    } else{
    	 if ("NEO4J_1_X_X".equals(dbVersion)) {
        
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
    } else { // NEO4J_2_1_X or NEO4J_2_2_X
        
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
    }
	if (!useExistingConnection||(useExistingConnection && shutdownDb)) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
	}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
