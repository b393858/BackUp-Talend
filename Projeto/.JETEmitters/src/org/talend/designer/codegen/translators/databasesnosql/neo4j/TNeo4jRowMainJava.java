package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class TNeo4jRowMainJava
{
  protected static String nl;
  public static synchronized TNeo4jRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jRowMainJava result = new TNeo4jRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    java.util.Map<String, Object> parameters_";
  protected final String TEXT_2 = " = new java.util.HashMap<String, Object>();";
  protected final String TEXT_3 = NL + "    \tparameters_";
  protected final String TEXT_4 = ".put(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ");" + NL + "    \t";
  protected final String TEXT_8 = NL + "    org.neo4j.driver.v1.StatementResult result_";
  protected final String TEXT_9 = " = null;" + NL + "    try{" + NL + "        result_";
  protected final String TEXT_10 = " = transaction_";
  protected final String TEXT_11 = ".run(";
  protected final String TEXT_12 = ", parameters_";
  protected final String TEXT_13 = ");" + NL + "    ";
  protected final String TEXT_14 = NL + "\torg.neo4j.cypher.ExecutionResult result_";
  protected final String TEXT_15 = " = null;" + NL + "    try {" + NL + "    \tif(engine_";
  protected final String TEXT_16 = "!=null){" + NL + "    \t\tresult_";
  protected final String TEXT_17 = " = engine_";
  protected final String TEXT_18 = ".execute(";
  protected final String TEXT_19 = ", parameters_";
  protected final String TEXT_20 = ");" + NL + "    \t}" + NL + "    \tif(queryEngine_";
  protected final String TEXT_21 = "!=null){" + NL + "    \t\tqueryEngine_";
  protected final String TEXT_22 = ".query(";
  protected final String TEXT_23 = ", parameters_";
  protected final String TEXT_24 = ");" + NL + "    \t}";
  protected final String TEXT_25 = NL + "    } catch (Exception e_";
  protected final String TEXT_26 = ") {" + NL + "    \t";
  protected final String TEXT_27 = NL + "    \t\tthrow(e_";
  protected final String TEXT_28 = ");" + NL + "    \t\t";
  protected final String TEXT_29 = NL + "    \t\t\t";
  protected final String TEXT_30 = " = new ";
  protected final String TEXT_31 = "Struct();" + NL + "    \t\t\t";
  protected final String TEXT_32 = NL + "    \t\t\t\t\t";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ";" + NL + "    \t\t\t\t\t";
  protected final String TEXT_37 = NL + "    \t\t\t";
  protected final String TEXT_38 = ".errorMessage = e_";
  protected final String TEXT_39 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_40 = ";" + NL + "    \t\t\t";
  protected final String TEXT_41 = NL + "    \t\t\tSystem.err.print(e_";
  protected final String TEXT_42 = ".getMessage());" + NL + "    \t\t\t";
  protected final String TEXT_43 = NL + "    }";
  protected final String TEXT_44 = NL + "    if(result_";
  protected final String TEXT_45 = "!=null) {" + NL + "        globalMap.put(\"";
  protected final String TEXT_46 = "_StatementResult\", result_";
  protected final String TEXT_47 = ");" + NL + "    \torg.neo4j.driver.v1.summary.SummaryCounters sc_";
  protected final String TEXT_48 = " = result_";
  protected final String TEXT_49 = ".consume().counters();" + NL + "        nbNodeInserted_";
  protected final String TEXT_50 = " += sc_";
  protected final String TEXT_51 = ".nodesCreated();" + NL + "        nbRelationshipInserted_";
  protected final String TEXT_52 = " += sc_";
  protected final String TEXT_53 = ".relationshipsCreated();" + NL + "        nbPropertiesUpdated_";
  protected final String TEXT_54 = " += sc_";
  protected final String TEXT_55 = ".propertiesSet();" + NL + "        nbNodeDeleted_";
  protected final String TEXT_56 = " += sc_";
  protected final String TEXT_57 = ".nodesDeleted();" + NL + "        nbRelationshipDeleted_";
  protected final String TEXT_58 = " += sc_";
  protected final String TEXT_59 = ".relationshipsDeleted();" + NL + "        " + NL + "    }";
  protected final String TEXT_60 = NL + NL + "\tif(result_";
  protected final String TEXT_61 = "!=null) {" + NL + "\t\tnbNodeInserted_";
  protected final String TEXT_62 = " += result_";
  protected final String TEXT_63 = ".queryStatistics().nodesCreated();" + NL + "\t\tnbRelationshipInserted_";
  protected final String TEXT_64 = " += result_";
  protected final String TEXT_65 = ".queryStatistics().relationshipsCreated();" + NL + "\t\tnbPropertiesUpdated_";
  protected final String TEXT_66 = " += result_";
  protected final String TEXT_67 = ".queryStatistics().propertiesSet();" + NL + "\t\t";
  protected final String TEXT_68 = NL + "            nbNodeDeleted_";
  protected final String TEXT_69 = " += result_";
  protected final String TEXT_70 = ".queryStatistics().deletedNodes();" + NL + "            nbRelationshipDeleted_";
  protected final String TEXT_71 = " += result_";
  protected final String TEXT_72 = ".queryStatistics().deletedRelationships();" + NL + "\t        ";
  protected final String TEXT_73 = NL + "            nbNodeDeleted_";
  protected final String TEXT_74 = " += result_";
  protected final String TEXT_75 = ".queryStatistics().nodesDeleted();" + NL + "            nbRelationshipDeleted_";
  protected final String TEXT_76 = " += result_";
  protected final String TEXT_77 = ".queryStatistics().relationshipsDeleted();" + NL + "\t        ";
  protected final String TEXT_78 = NL + "\t}" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_79 = NL + "\t" + NL + "\tcounter_";
  protected final String TEXT_80 = "++;" + NL + "" + NL + "\tif (counter_";
  protected final String TEXT_81 = " % Long.parseLong(";
  protected final String TEXT_82 = ") == 0) {" + NL + "\t    ";
  protected final String TEXT_83 = NL + "\t    \ttransaction_";
  protected final String TEXT_84 = ".success();" + NL + "\t    \ttransaction_";
  protected final String TEXT_85 = ".close();" + NL + "\t    \ttransaction_";
  protected final String TEXT_86 = " = session_";
  protected final String TEXT_87 = ".beginTransaction();" + NL + "\t    \t" + NL + "\t    ";
  protected final String TEXT_88 = NL + "            tx_";
  protected final String TEXT_89 = ".success();" + NL + "            tx_";
  protected final String TEXT_90 = ".finish();";
  protected final String TEXT_91 = NL + "            try {" + NL + "                tx_";
  protected final String TEXT_92 = ".success();" + NL + "            } finally {" + NL + "                tx_";
  protected final String TEXT_93 = ".close();" + NL + "            }" + NL + "" + NL + "            if (databaseService_";
  protected final String TEXT_94 = ".getClass().equals(org.neo4j.kernel.EmbeddedGraphDatabase.class)) {" + NL + "                while (((org.neo4j.kernel.EmbeddedGraphDatabase)databaseService_";
  protected final String TEXT_95 = ").transactionRunning()){" + NL + "                    // wait the end of the previous transaction" + NL + "                }" + NL + "            }";
  protected final String TEXT_96 = NL + "            try {" + NL + "                tx_";
  protected final String TEXT_97 = ".success();" + NL + "            } finally {" + NL + "                tx_";
  protected final String TEXT_98 = ".close();" + NL + "            }" + NL + "" + NL + "            if (databaseService_";
  protected final String TEXT_99 = ".getClass().equals(org.neo4j.kernel.EmbeddedGraphDatabase.class)) {" + NL + "                ((org.neo4j.kernel.EmbeddedGraphDatabase)databaseService_";
  protected final String TEXT_100 = ").isAvailable(10000l);" + NL + "            }";
  protected final String TEXT_101 = NL + NL + "\t\t tx_";
  protected final String TEXT_102 = " = databaseService_";
  protected final String TEXT_103 = ".beginTx();" + NL + "\t\t ";
  protected final String TEXT_104 = NL + "\t}";
  protected final String TEXT_105 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
    String query = ElementParameterParser.getValue(node, "__QUERY__");
    query = query.replaceAll("\n"," ");
    query = query.replaceAll("\r"," ");
    List<Map<String, String>> listParameters = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__PARAMETERS__");
    boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));   
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__"); 

    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    String dbVersion = ElementParameterParser.getValue(node,"__DB_VERSION__");
	if(useExistingConnection){
	    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
        dbVersion = ElementParameterParser.getValue(connectionNode, "__DB_VERSION__");
    }

    List<IMetadataColumn> columnList = null;
    List<IMetadataTable> metadatas = node.getMetadataList();
    
    if (metadatas != null && metadatas.size() > 0) {
    	IMetadataTable metadata = metadatas.get(0);
    	if (metadata != null) {
    		columnList = metadata.getListColumns();
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
    
    if (outputs.size() > 0) {
    	IConnection out = outputs.get(0);
    	outgoingConnName = out.getName();
    }
    
    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if (rejectConns != null && rejectConns.size() > 0) {
    	IConnection rejectConn = rejectConns.get(0);
    	rejectConnName = rejectConn.getName();
    }
    
    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if (metadataTable != null) {
    	rejectColumnList = metadataTable.getListColumns();
    }
    
    Set<String> inputCols = new HashSet();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			List< ? extends IConnection> conns = node.getIncomingConnections();
			columnList = metadata.getListColumns();
			if(conns != null && conns.size()>0){
				IConnection conn = conns.get(0);
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					incomingConnName = conn.getName();
					IMetadataTable inputMetadataTable = conn.getMetadataTable();
					for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
						inputCols.add(inputCol.getLabel());
					}
				}
			}
		}
	}
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
    for (Map<String, String> parameter : listParameters) {
    	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(parameter.get("PARAMETER_NAME"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(parameter.get("PARAMETER_VALUE"));
    stringBuffer.append(TEXT_7);
    
    }   
    if("NEO4J_3_2_X".equals(dbVersion)){
    
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
    	if (dieOnError) {
    		
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
    	} else {
    		if (rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_31);
    
    			if (incomingConnName != null) {
    				for (IMetadataColumn column : columnList) {
    					if (inputCols.contains(column.getLabel())) {
    					
    stringBuffer.append(TEXT_32);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_36);
    
    					}
    				}
    			}
    			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_40);
    
    		} else {
    			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
    		}
    	}
    	
    stringBuffer.append(TEXT_43);
    
        if("NEO4J_3_2_X".equals(dbVersion)){
    
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    } else {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
	    if ("NEO4J_1_X_X".equals(dbVersion)) {
	        
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
	    } else { // NEO4J_2_1_X or NEO4J_2_2_X
	        
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
	    }
	    
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_82);
    
	    if ("NEO4J_3_2_X".equals(dbVersion)) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    }else {
	    	if ("NEO4J_1_X_X".equals(dbVersion)) {
            
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
        	} else if ("NEO4J_2_1_X".equals(dbVersion)) { // NEO4J_2_1_X
            
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
        	} else { // NEO4J_2_2_X : usage of Spring rest
            
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
        	}
        
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(TEXT_105);
    return stringBuffer.toString();
  }
}
