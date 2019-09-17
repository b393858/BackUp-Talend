package org.talend.designer.codegen.translators.databasesnosql.maprdb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;

public class TMapROjaiOutputMainJava
{
  protected static String nl;
  public static synchronized TMapROjaiOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMapROjaiOutputMainJava result = new TMapROjaiOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "            ";
  protected final String TEXT_31 = " = null;";
  protected final String TEXT_32 = NL;
  protected final String TEXT_33 = NL + "\t\t\t\torg.ojai.Document doc_";
  protected final String TEXT_34 = " = com.mapr.db.MapRDB.newDocument();" + NL + "\t\t\t\tString key = null;" + NL + "\t\t\t\t";
  protected final String TEXT_35 = NL + "\t                           path_";
  protected final String TEXT_36 = " = pathMap_";
  protected final String TEXT_37 = ".get(\"";
  protected final String TEXT_38 = "\");" + NL + "\t" + NL + "\t                            if (";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " != null) {" + NL + "                                    doc_";
  protected final String TEXT_41 = ".set(path_";
  protected final String TEXT_42 = ",";
  protected final String TEXT_43 = ");" + NL + "\t                            }";
  protected final String TEXT_44 = NL + "  \t\ttry{" + NL + "  \t\t";
  protected final String TEXT_45 = NL + "                table_";
  protected final String TEXT_46 = ".insert(doc_";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "                table_";
  protected final String TEXT_49 = ".replace(doc_";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "                table_";
  protected final String TEXT_52 = ".insertOrReplace(doc_";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "                table_";
  protected final String TEXT_55 = ".delete(doc_";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "\t\t\t\ttable_";
  protected final String TEXT_58 = ".flush();" + NL + "\t\t";
  protected final String TEXT_59 = NL + "\t\t" + NL + "\t            out_";
  protected final String TEXT_60 = ".write(doc_";
  protected final String TEXT_61 = ".toString());" + NL + "\t            bulkCount_";
  protected final String TEXT_62 = "++;" + NL + "\t\t     " + NL + "\t\t     if(bulkCount_";
  protected final String TEXT_63 = ">=bulkWriteSize_";
  protected final String TEXT_64 = "){" + NL + "\t\t         out_";
  protected final String TEXT_65 = ".close();" + NL + "\t\t         java.io.FileInputStream fis_";
  protected final String TEXT_66 = " = new java.io.FileInputStream(temp_";
  protected final String TEXT_67 = ");" + NL + "\t\t         org.ojai.json.impl.JsonDocumentStream jds_";
  protected final String TEXT_68 = " = new org.ojai.json.impl.JsonDocumentStream(fis_";
  protected final String TEXT_69 = ",fieldPathTypeMap_";
  protected final String TEXT_70 = ",di_";
  protected final String TEXT_71 = ");" + NL + "\t\t        ";
  protected final String TEXT_72 = NL + "                table_";
  protected final String TEXT_73 = ".insert(jds_";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "                table_";
  protected final String TEXT_76 = ".replace(jds_";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "                table_";
  protected final String TEXT_79 = ".insertOrReplace(jds_";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "                table_";
  protected final String TEXT_82 = ".delete(jds_";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "\t\t         jds_";
  protected final String TEXT_85 = ".close();" + NL + "\t\t         fis_";
  protected final String TEXT_86 = ".close();" + NL + "\t\t         " + NL + "\t\t         temp_";
  protected final String TEXT_87 = ".delete();" + NL + "\t\t         temp_";
  protected final String TEXT_88 = " = java.io.File.createTempFile(\"tMapROjaiOutput\", \".jsontemp\");" + NL + "\t\t         out_";
  protected final String TEXT_89 = " = new java.io.BufferedWriter(new java.io.FileWriter(temp_";
  protected final String TEXT_90 = "));" + NL + "\t\t         bulkCount_";
  protected final String TEXT_91 = "=0;" + NL + "\t\t     }" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t}catch(Exception e_";
  protected final String TEXT_93 = "){" + NL + "\t\t\t\t    ";
  protected final String TEXT_94 = NL + "\t\t\t\t        throw e_";
  protected final String TEXT_95 = ";" + NL + "\t\t\t\t    ";
  protected final String TEXT_96 = NL + "\t\t\t\t        whetherReject_";
  protected final String TEXT_97 = " = true;" + NL + "\t\t\t\t    ";
  protected final String TEXT_98 = NL + "                            ";
  protected final String TEXT_99 = " = new ";
  protected final String TEXT_100 = "Struct();";
  protected final String TEXT_101 = NL + "                                ";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = " = ";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = ";";
  protected final String TEXT_106 = NL + "                            rejectedCount_";
  protected final String TEXT_107 = " =  rejectedCount_";
  protected final String TEXT_108 = "+ 1;";
  protected final String TEXT_109 = NL + "                            ";
  protected final String TEXT_110 = ".errorMessage = e_";
  protected final String TEXT_111 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_112 = ";";
  protected final String TEXT_113 = NL + "                            System.err.print(e_";
  protected final String TEXT_114 = ".getMessage());";
  protected final String TEXT_115 = NL + "\t\t\t\t  " + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_116 = NL + "            if(!whetherReject_";
  protected final String TEXT_117 = ") {";
  protected final String TEXT_118 = NL + "                            ";
  protected final String TEXT_119 = " = new ";
  protected final String TEXT_120 = "Struct();";
  protected final String TEXT_121 = NL + "                                ";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = " = ";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = ";";
  protected final String TEXT_126 = NL + "            }else{" + NL + "                whetherReject_";
  protected final String TEXT_127 = " = false;" + NL + "            }";
  protected final String TEXT_128 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_129 = " ++;" + NL + "\t\t\t\t";
  protected final String TEXT_130 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
  	String cid = node.getUniqueName();
  	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
  	java.util.List<java.util.Map<String, String>> mappings = (java.util.List<java.util.Map<String, String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
  	boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean setBulkWrite = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_BULK_WRITE__"));
    String bulkWriteType = ElementParameterParser.getValue(node, "__BULK_WRITE_TYPE__");
    
    String incomingConnName = null;
    List<IMetadataColumn> columnList =null;

    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");

    IMetadataTable metadataTable = null;
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
        metadataTable = rejectConn.getMetadataTable();
    }

    List<IMetadataColumn> rejectColumnList = null;

    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();
    }

    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    for(IConnection conn : outgoingConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_31);
    
        }
    }
    
    stringBuffer.append(TEXT_32);
    
		IConnection inConn = null;
	IMetadataTable metadata = null;
	
	if(inConns!=null && inConns.size()> 0) {
		inConn = inConns.get(0);
		metadata = inConn.getMetadataTable();
	}
	
	  		java.util.Map<String, String> pathMap = new java.util.HashMap<String, String>();
			for (int i=0;i<mappings.size();i++) {
				String path = mappings.get(i).get("PARENT_FIELD_PATH");
				if(path==null || "".equals(path)){
					path="";
				}
				String schemaColumn=mappings.get(i).get("SCHEMA_COLUMN");
				pathMap.put(schemaColumn,path);
			}
	
	if (metadata!=null) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		for (IConnection conn : conns) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				columnList = metadata.getListColumns();
				incomingConnName = conn.getName();
				int sizeColumns = columnList.size();
				
				// Create the BasicDBObject
				
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
				// Set key/values of the BasicObject
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columnList.get(i);
					
					        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					        String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					        String rowData = null;
					        if(("java.util.Date").equals(typeToGenerate)){
					            rowData = "new org.ojai.types.OTimestamp("+conn.getName()+"."+column.getLabel()+".getTime())";
					        }else if ("BigDecimal".equals(typeToGenerate)){
					            rowData = conn.getName()+"."+column.getLabel()+".toString()";
					        }else if ("Document".equals(typeToGenerate)){
					        	rowData = "com.mapr.db.MapRDB.newDocument(org.json.XML.toJSONObject(" + conn.getName()+"."+column.getLabel()+".getDocument().asXML()).getJSONObject(\"xml\").toString())";
					        }
					        else{
					            rowData = conn.getName()+"."+column.getLabel();
					        }
					        
					        String schemaData = null;
				            if("".equals(pathMap.get(column.getLabel()))){
				                schemaData=column.getOriginalDbColumnName();
				            }else{
				                schemaData=pathMap.get(column.getLabel()).replaceAll("\"","")+"."+column.getOriginalDbColumnName();
				            }
					        
	                            
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(rowData);
    stringBuffer.append(TEXT_43);
    
                     }
                }
  				// Get the BasicDBObject
  			}
  		}
  		
    stringBuffer.append(TEXT_44);
    
  		if(!setBulkWrite){
				if ("INSERT".equalsIgnoreCase(dataAction)){
                                    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
                }else if("REPLACE".equalsIgnoreCase(dataAction)){
                
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
                }else if("INSERT_OR_REPLACE".equalsIgnoreCase(dataAction)){
                
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
                }else if("DELETE".equalsIgnoreCase(dataAction)){
                
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
                }
                
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    }else{
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
		        if ("INSERT".equalsIgnoreCase(dataAction)){
                
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
                }else if("REPLACE".equalsIgnoreCase(dataAction)){
                
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
                }else if("INSERT_OR_REPLACE".equalsIgnoreCase(dataAction)){
                
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
                }else if("DELETE".equalsIgnoreCase(dataAction)){
                
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
                }
                
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    if(dieOnError){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    }else{
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_98);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_100);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_101);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_105);
    
                            }
                            
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_112);
    
                        } else {
                            
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
                        }
				    }
				    
    stringBuffer.append(TEXT_115);
    
		    if(outgoingConns != null && outgoingConns.size() > 0) {
            
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
                for(IConnection outgoingConn : outgoingConns) {
                    if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                        if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {  
                        

                            
    stringBuffer.append(TEXT_118);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_120);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_121);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_125);
    
                            }
                        }
                    }
                }
            
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
        }
        
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(TEXT_130);
    return stringBuffer.toString();
  }
}
