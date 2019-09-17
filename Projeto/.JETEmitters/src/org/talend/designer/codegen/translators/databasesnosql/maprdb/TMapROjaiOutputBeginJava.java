package org.talend.designer.codegen.translators.databasesnosql.maprdb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;

public class TMapROjaiOutputBeginJava
{
  protected static String nl;
  public static synchronized TMapROjaiOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMapROjaiOutputBeginJava result = new TMapROjaiOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "    java.util.Map<String, String> pathMap_";
  protected final String TEXT_30 = " = new java.util.HashMap<String, String>();" + NL + "    String path_";
  protected final String TEXT_31 = " = null;" + NL;
  protected final String TEXT_32 = NL + NL + "    path_";
  protected final String TEXT_33 = " = new String(";
  protected final String TEXT_34 = ");" + NL + "    path_";
  protected final String TEXT_35 = " = \"\".equals(path_";
  protected final String TEXT_36 = ") ? \"";
  protected final String TEXT_37 = "\" : path_";
  protected final String TEXT_38 = " + \".\" + \"";
  protected final String TEXT_39 = "\";" + NL + "    pathMap_";
  protected final String TEXT_40 = ".put(\"";
  protected final String TEXT_41 = "\", path_";
  protected final String TEXT_42 = ");" + NL + "    ";
  protected final String TEXT_43 = NL + NL;
  protected final String TEXT_44 = NL + "        class ExeCMd_";
  protected final String TEXT_45 = "{" + NL + "\t\t    private boolean UsePwd = false;" + NL + "\t\t    String message;" + NL + "\t\t    " + NL + "\t\t    public boolean exec(String[] arg0) throws Exception{" + NL + "\t\t        boolean result = true;" + NL + "\t\t    " + NL + "\t\t        Process process = Runtime.getRuntime().exec(arg0);" + NL + "\t\t\t\tlog.debug(\"Commend: \" + java.util.Arrays.asList(arg0).toString());" + NL + "\t\t        if(UsePwd){" + NL + "\t\t            java.io.PrintWriter pwout = new java.io.PrintWriter(process.getOutputStream());" + NL + "\t\t        ";
  protected final String TEXT_46 = NL + "\t\t        ";
  protected final String TEXT_47 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_48 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = "; ";
  protected final String TEXT_53 = NL + "\t\t            pwout.println(decryptedPassword_";
  protected final String TEXT_54 = "); " + NL + "\t\t            pwout.flush();" + NL + "\t\t        ";
  protected final String TEXT_55 = NL + "\t\t        }" + NL + "\t\t    " + NL + "\t\t        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));" + NL + "\t\t        while ((message = bufferedReader.readLine()) != null) {" + NL + "\t\t\t        System.out.println(message);" + NL + "\t\t        }" + NL + "\t\t        java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(process.getErrorStream()));" + NL + "\t\t        while ((message = bufferedReader2.readLine()) != null) {" + NL + "\t\t\t        System.err.println(message);" + NL + "\t\t\t        result = false;" + NL + "\t\t        }" + NL + "\t\t        process.waitFor();" + NL + "\t\t        return result;" + NL + "\t\t    }" + NL + "\t\t    " + NL + "\t\t    public void setUsePwd(boolean usePwd){" + NL + "\t\t       UsePwd = usePwd;" + NL + "\t\t    }" + NL + "\t\t    " + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tExeCMd_";
  protected final String TEXT_56 = " exeCMd_";
  protected final String TEXT_57 = " = new ExeCMd_";
  protected final String TEXT_58 = "();" + NL + "\t\t" + NL + "        " + NL + "\t\tjava.util.ArrayList<String> cmd_";
  protected final String TEXT_59 = " = new java.util.ArrayList<String>();" + NL + "\t\tcmd_";
  protected final String TEXT_60 = ".add(\"kinit\");" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\tcmd_";
  protected final String TEXT_62 = ".add(\"-k\");" + NL + "\t\tcmd_";
  protected final String TEXT_63 = ".add(\"-t\");" + NL + "\t\tcmd_";
  protected final String TEXT_64 = ".add(";
  protected final String TEXT_65 = ");" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\texeCMd_";
  protected final String TEXT_67 = ".setUsePwd(true);" + NL + "\t\t";
  protected final String TEXT_68 = NL + "\t\tcmd_";
  protected final String TEXT_69 = ".add(";
  protected final String TEXT_70 = ");" + NL + "\t\t" + NL + "\t\tif(!exeCMd_";
  protected final String TEXT_71 = ".exec(cmd_";
  protected final String TEXT_72 = ".toArray(new String[0]))){" + NL + "\t\t    throw new RuntimeException(\"Kerberos Authentication Failed.\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tjava.util.ArrayList<String> cmd2_";
  protected final String TEXT_73 = " = new java.util.ArrayList<String>();" + NL + "\t\t" + NL + "\t\tString os_";
  protected final String TEXT_74 = " = System.getProperty(\"os.name\");  " + NL + "        if(os_";
  protected final String TEXT_75 = ".toLowerCase().startsWith(\"win\")){  " + NL + "           cmd2_";
  protected final String TEXT_76 = ".add(\"maprlogin.bat\");" + NL + "        }else{" + NL + "           cmd2_";
  protected final String TEXT_77 = ".add(\"maprlogin\");" + NL + "        }" + NL + "\t\t   cmd2_";
  protected final String TEXT_78 = ".add(\"kerberos\");" + NL + "\t\t   " + NL + "\t\tboolean loginResult_";
  protected final String TEXT_79 = " = new ExeCMd_";
  protected final String TEXT_80 = "().exec(cmd2_";
  protected final String TEXT_81 = ".toArray(new String[0]));" + NL + "\t\tif(!loginResult_";
  protected final String TEXT_82 = "){" + NL + "\t\t    throw new RuntimeException(\"Mapr Login failed. Please see the error log at MAPR_HOME/log for more details\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_83 = NL + NL + "  \t    int nb_line_";
  protected final String TEXT_84 = "=0;" + NL + "  \t    int rejectedCount_";
  protected final String TEXT_85 = "=0;" + NL + "  \t    boolean whetherReject_";
  protected final String TEXT_86 = " = false;" + NL + "  \t  \tcom.mapr.db.Admin admin_";
  protected final String TEXT_87 = " = com.mapr.db.MapRDB.newAdmin();" + NL + "  \t\tcom.mapr.db.TableDescriptor tableDescriptor_";
  protected final String TEXT_88 = " = com.mapr.db.MapRDB.newTableDescriptor(";
  protected final String TEXT_89 = ");" + NL + "  \t\tlong bulkWriteSize_";
  protected final String TEXT_90 = " = Long.parseLong(";
  protected final String TEXT_91 = ");" + NL + "  \t\tcom.mapr.db.Table table_";
  protected final String TEXT_92 = "=null;" + NL + "  \t";
  protected final String TEXT_93 = NL + "  \t" + NL + "  \t    table_";
  protected final String TEXT_94 = " = com.mapr.db.MapRDB.getTable(";
  protected final String TEXT_95 = ");" + NL + "  \t" + NL + "  \t    ";
  protected final String TEXT_96 = NL + "  \t\tcom.mapr.db.MapRDB.deleteTable(";
  protected final String TEXT_97 = ");" + NL + "  \t\ttable_";
  protected final String TEXT_98 = " = admin_";
  protected final String TEXT_99 = ".createTable(tableDescriptor_";
  protected final String TEXT_100 = ");" + NL + "  \t\t  \t";
  protected final String TEXT_101 = NL + "  \t\ttable_";
  protected final String TEXT_102 = " = admin_";
  protected final String TEXT_103 = ".createTable(tableDescriptor_";
  protected final String TEXT_104 = ");" + NL + "  \t\t  \t";
  protected final String TEXT_105 = NL + "  \t\tif(!com.mapr.db.MapRDB.tableExists(";
  protected final String TEXT_106 = ")){" + NL + "  \t\t    table_";
  protected final String TEXT_107 = " = admin_";
  protected final String TEXT_108 = ".createTable(tableDescriptor_";
  protected final String TEXT_109 = ");" + NL + "  \t\t}else{" + NL + "  \t\t    table_";
  protected final String TEXT_110 = " = com.mapr.db.MapRDB.getTable(";
  protected final String TEXT_111 = ");" + NL + "  \t\t}" + NL + "  \t\t" + NL + "  \t\t  \t";
  protected final String TEXT_112 = NL + "  \t\t" + NL + "  \t\tif(com.mapr.db.MapRDB.tableExists(";
  protected final String TEXT_113 = ")){" + NL + "  \t\t    com.mapr.db.MapRDB.deleteTable(";
  protected final String TEXT_114 = ");" + NL + "  \t\t}" + NL + "  \t\ttable_";
  protected final String TEXT_115 = " = admin_";
  protected final String TEXT_116 = ".createTable(tableDescriptor_";
  protected final String TEXT_117 = ");" + NL + "  \t\t" + NL + "  \t\t  \t";
  protected final String TEXT_118 = NL + "  \t\ttable_";
  protected final String TEXT_119 = " = com.mapr.db.MapRDB.getTable(";
  protected final String TEXT_120 = ");" + NL + "  \t\t  \t    // all records in the table" + NL + "\t    org.ojai.DocumentStream rst_";
  protected final String TEXT_121 = " = table_";
  protected final String TEXT_122 = ".find();" + NL + "        java.util.Iterator<org.ojai.Document> itrst_";
  protected final String TEXT_123 = " = rst_";
  protected final String TEXT_124 = ".iterator();" + NL + "        org.ojai.Document readRecord_";
  protected final String TEXT_125 = ";" + NL + "        while (itrst_";
  protected final String TEXT_126 = ".hasNext()) {" + NL + "          readRecord_";
  protected final String TEXT_127 = " = itrst_";
  protected final String TEXT_128 = ".next();" + NL + "          table_";
  protected final String TEXT_129 = ".delete(readRecord_";
  protected final String TEXT_130 = ".getId());" + NL + "        }" + NL + "        rst_";
  protected final String TEXT_131 = ".close();" + NL + "        table_";
  protected final String TEXT_132 = ".flush();" + NL + "  \t\t  \t";
  protected final String TEXT_133 = NL + "  \t\tadmin_";
  protected final String TEXT_134 = ".close();" + NL + "  \t\t";
  protected final String TEXT_135 = NL + "  \t\t\t" + NL + "  \t\t\tlong bulkCount_";
  protected final String TEXT_136 = " = 0l;" + NL + "  \t\t\tjava.io.File temp_";
  protected final String TEXT_137 = " = java.io.File.createTempFile(\"";
  protected final String TEXT_138 = "\", \".jsontemp\");" + NL + "  \t\t\tjava.io.BufferedWriter out_";
  protected final String TEXT_139 = " = new java.io.BufferedWriter(new java.io.FileWriter(temp_";
  protected final String TEXT_140 = "));" + NL + "  \t\t\tclass DelegateImpl_";
  protected final String TEXT_141 = " extends org.ojai.json.Events.BaseDelegate {}" + NL + "  \t\t\tDelegateImpl_";
  protected final String TEXT_142 = " di_";
  protected final String TEXT_143 = " = new DelegateImpl_";
  protected final String TEXT_144 = "();" + NL + "  \t\t\tjava.util.Map<org.ojai.FieldPath, org.ojai.Value.Type> fieldPathTypeMap_";
  protected final String TEXT_145 = " = new java.util.HashMap<org.ojai.FieldPath, org.ojai.Value.Type>();";
  protected final String TEXT_146 = NL + "\t\t\t\t\t        path_";
  protected final String TEXT_147 = " = pathMap_";
  protected final String TEXT_148 = ".get(\"";
  protected final String TEXT_149 = "\");" + NL + "                            fieldPathTypeMap_";
  protected final String TEXT_150 = ".put(org.ojai.FieldPath.parseFrom(path_";
  protected final String TEXT_151 = "),org.ojai.Value.Type.";
  protected final String TEXT_152 = ");" + NL;
  protected final String TEXT_153 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
  	String cid = node.getUniqueName();
  	java.util.List<java.util.Map<String, String>> mappings = (java.util.List<java.util.Map<String, String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
    String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");
    String table = ElementParameterParser.getValue(node,"__TABLE__");
    boolean setBulkWrite = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_BULK_WRITE__"));
    String bulkWriteOperationSize = ElementParameterParser.getValue(node, "__BULK_WRITE_SIZE__");
    boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
	String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
	String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
    List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);

    IConnection inConn = null;
    IMetadataTable metadata = null;
    
    if(inConns!=null && inConns.size()> 0) {
        inConn = inConns.get(0);
        metadata = inConn.getMetadataTable();
    }
    
    List<IMetadataColumn> columnList = metadata.getListColumns();
    Map<String, IMetadataColumn> columnMap = new java.util.HashMap<String, IMetadataColumn>();
    
    for  (IMetadataColumn column : columnList) {
        columnMap.put(column.getLabel(), column);
    }

    
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
    for (Map<String, String> pathElement : mappings) {
        String schemaColumn = pathElement.get("SCHEMA_COLUMN");
        String dbColumn = (columnMap.get(schemaColumn)).getOriginalDbColumnName();

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(pathElement.get("PARENT_FIELD_PATH"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dbColumn);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbColumn);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(dbColumn);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
    }

    stringBuffer.append(TEXT_43);
    if(useKrb){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    if(!useKeytab){
		        String passwordFieldName = "__KERBEROS_PASSWORD__";
    stringBuffer.append(TEXT_46);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_49);
    } else {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    if(useKeytab){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_65);
    }else{
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(bulkWriteOperationSize);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
  		if("NONE".equals(tableAction)){
  		
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_95);
    
  		}else if("DROP_CREATE".equals(tableAction)){
  		
    stringBuffer.append(TEXT_96);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
  		}else if("CREATE".equals(tableAction)){
  		
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
  		}else if("CREATE_IF_NOT_EXISTS".equals(tableAction)){
  		
    stringBuffer.append(TEXT_105);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_111);
    
  		}else if("DROP_IF_EXISTS_AND_CREATE".equals(tableAction)){
  		
    stringBuffer.append(TEXT_112);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
  		}else if("TRUNCATE".equals(tableAction)){
  		
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
  		}
  		
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
  			if(setBulkWrite){
  			
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
	if (metadata!=null) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		for (IConnection conn : conns) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				int sizeColumns = columnList.size();
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columnList.get(i);
					
					        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					        String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					        String rowType = null;
					        if(("java.util.Date").equals(typeToGenerate)){
					            rowType = "DATE";
					        }else if ("BigDecimal".equals(typeToGenerate)){
					            rowType = "DECIMAL";
					        }else if ("byte[]".equals(typeToGenerate)){
					            rowType = "BINARY";
					        }else if ("Integer".equals(typeToGenerate)){
					            rowType = "INT";
					        }else if ("Character".equals(typeToGenerate)){
					        	rowType = "STRING";
					        }
					        else{
					            rowType = typeToGenerate.toUpperCase();
					        }

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(rowType);
    stringBuffer.append(TEXT_152);
    
                            }
                        }
                  }
  			}
  		}
  		
    stringBuffer.append(TEXT_153);
    return stringBuffer.toString();
  }
}
