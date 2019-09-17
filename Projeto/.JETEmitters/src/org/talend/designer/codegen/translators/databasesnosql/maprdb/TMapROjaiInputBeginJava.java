package org.talend.designer.codegen.translators.databasesnosql.maprdb;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TMapROjaiInputBeginJava
{
  protected static String nl;
  public static synchronized TMapROjaiInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMapROjaiInputBeginJava result = new TMapROjaiInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
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
  protected final String TEXT_30 = NL + "\t";
  protected final String TEXT_31 = NL + NL + "    java.util.Map<String, String> pathMap_";
  protected final String TEXT_32 = " = new java.util.HashMap<String, String>();" + NL + "    String path_";
  protected final String TEXT_33 = " = null;" + NL;
  protected final String TEXT_34 = NL + NL + "    path_";
  protected final String TEXT_35 = " = new String(";
  protected final String TEXT_36 = ");" + NL + "    path_";
  protected final String TEXT_37 = " = \"\".equals(path_";
  protected final String TEXT_38 = ") ? \"";
  protected final String TEXT_39 = "\" : path_";
  protected final String TEXT_40 = " + \".\" + \"";
  protected final String TEXT_41 = "\";" + NL + "    pathMap_";
  protected final String TEXT_42 = ".put(\"";
  protected final String TEXT_43 = "\", path_";
  protected final String TEXT_44 = ");" + NL + "    ";
  protected final String TEXT_45 = NL + NL + "//-->Kerberos stuff start";
  protected final String TEXT_46 = NL + "        class ExeCMd_";
  protected final String TEXT_47 = "{" + NL + "\t\t    private boolean UsePwd = false;" + NL + "\t\t    String message;" + NL + "\t\t    " + NL + "\t\t    public boolean exec(String[] arg0) throws Exception{" + NL + "\t\t        boolean result = true;" + NL + "\t\t    " + NL + "\t\t        Process process = Runtime.getRuntime().exec(arg0);" + NL + "\t\t\t\tlog.debug(\"Commend: \" + java.util.Arrays.asList(arg0).toString());" + NL + "\t\t        if(UsePwd){" + NL + "\t\t            java.io.PrintWriter pwout = new java.io.PrintWriter(process.getOutputStream());" + NL + "\t\t        ";
  protected final String TEXT_48 = NL + "\t\t        ";
  protected final String TEXT_49 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_50 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = "; ";
  protected final String TEXT_55 = NL + "\t\t            pwout.println(decryptedPassword_";
  protected final String TEXT_56 = "); " + NL + "\t\t            pwout.flush();" + NL + "\t\t        ";
  protected final String TEXT_57 = NL + "\t\t        }" + NL + "\t\t    " + NL + "\t\t        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));" + NL + "\t\t        while ((message = bufferedReader.readLine()) != null) {" + NL + "\t\t\t        System.out.println(message);" + NL + "\t\t        }" + NL + "\t\t        java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(process.getErrorStream()));" + NL + "\t\t        while ((message = bufferedReader2.readLine()) != null) {" + NL + "\t\t\t        System.err.println(message);" + NL + "\t\t\t        result = false;" + NL + "\t\t        }" + NL + "\t\t        process.waitFor();" + NL + "\t\t        return result;" + NL + "\t\t    }" + NL + "\t\t    " + NL + "\t\t    public void setUsePwd(boolean usePwd){" + NL + "\t\t       UsePwd = usePwd;" + NL + "\t\t    }" + NL + "\t\t    " + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tExeCMd_";
  protected final String TEXT_58 = " exeCMd_";
  protected final String TEXT_59 = " = new ExeCMd_";
  protected final String TEXT_60 = "();" + NL + "\t\t" + NL + "        " + NL + "\t\tjava.util.ArrayList<String> cmd_";
  protected final String TEXT_61 = " = new java.util.ArrayList<String>();" + NL + "\t\tcmd_";
  protected final String TEXT_62 = ".add(\"kinit\");" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_63 = NL + "\t\tcmd_";
  protected final String TEXT_64 = ".add(\"-k\");" + NL + "\t\tcmd_";
  protected final String TEXT_65 = ".add(\"-t\");" + NL + "\t\tcmd_";
  protected final String TEXT_66 = ".add(";
  protected final String TEXT_67 = ");" + NL + "\t\t";
  protected final String TEXT_68 = NL + "\t\texeCMd_";
  protected final String TEXT_69 = ".setUsePwd(true);" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\tcmd_";
  protected final String TEXT_71 = ".add(";
  protected final String TEXT_72 = ");" + NL + "\t\t" + NL + "\t\tif(!exeCMd_";
  protected final String TEXT_73 = ".exec(cmd_";
  protected final String TEXT_74 = ".toArray(new String[0]))){" + NL + "\t\t    throw new RuntimeException(\"Kerberos Authentication Failed.\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tjava.util.ArrayList<String> cmd2_";
  protected final String TEXT_75 = " = new java.util.ArrayList<String>();" + NL + "\t\t" + NL + "\t\tString os_";
  protected final String TEXT_76 = " = System.getProperty(\"os.name\");  " + NL + "        if(os_";
  protected final String TEXT_77 = ".toLowerCase().startsWith(\"win\")){  " + NL + "           cmd2_";
  protected final String TEXT_78 = ".add(\"maprlogin.bat\");" + NL + "        }else{" + NL + "           cmd2_";
  protected final String TEXT_79 = ".add(\"maprlogin\");" + NL + "        }" + NL + "\t\t   cmd2_";
  protected final String TEXT_80 = ".add(\"kerberos\");" + NL + "\t\t   " + NL + "\t\tboolean loginResult_";
  protected final String TEXT_81 = " = new ExeCMd_";
  protected final String TEXT_82 = "().exec(cmd2_";
  protected final String TEXT_83 = ".toArray(new String[0]));" + NL + "\t\tif(!loginResult_";
  protected final String TEXT_84 = "){" + NL + "\t\t    throw new RuntimeException(\"Mapr Login failed. Please see the error log at MAPR_HOME/log for more details\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_85 = NL + "//<--Kerberos stuff end" + NL + "" + NL + "    int nb_line_";
  protected final String TEXT_86 = " = 0;" + NL + "\torg.ojai.DocumentStream rst_";
  protected final String TEXT_87 = " = null;" + NL + "    java.util.Collection<String> fieldList_";
  protected final String TEXT_88 = " = pathMap_";
  protected final String TEXT_89 = ".values();" + NL;
  protected final String TEXT_90 = NL + "\t" + NL + "\tcom.mapr.db.Table table_";
  protected final String TEXT_91 = " = com.mapr.db.MapRDB.getTable(";
  protected final String TEXT_92 = ");" + NL + "\t\t" + NL + "\t//no json-style condition support in ojai 1.0" + NL + "\tif (!fieldList_";
  protected final String TEXT_93 = ".isEmpty()) {" + NL + "  \t\trst_";
  protected final String TEXT_94 = " = table_";
  protected final String TEXT_95 = ".find(fieldList_";
  protected final String TEXT_96 = ".toArray(new String[fieldList_";
  protected final String TEXT_97 = ".size()]));" + NL + "  \t} else {" + NL + "  \t  \trst_";
  protected final String TEXT_98 = " = table_";
  protected final String TEXT_99 = ".find();" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_100 = NL + NL + "\torg.ojai.store.Connection conn_";
  protected final String TEXT_101 = " = org.ojai.store.DriverManager.getConnection(\"ojai:mapr:\");" + NL + "\torg.ojai.store.DocumentStore store_";
  protected final String TEXT_102 = " = conn_";
  protected final String TEXT_103 = ".getStore(";
  protected final String TEXT_104 = ");" + NL + "  \torg.ojai.store.Query qry_";
  protected final String TEXT_105 = " = conn_";
  protected final String TEXT_106 = ".newQuery();" + NL + "  \t" + NL + "  \tif (!fieldList_";
  protected final String TEXT_107 = ".isEmpty()) {" + NL + "  \t\tqry_";
  protected final String TEXT_108 = ".select(fieldList_";
  protected final String TEXT_109 = ".toArray(new String[fieldList_";
  protected final String TEXT_110 = ".size()]));" + NL + "  \t}" + NL + "  \t" + NL + "  \tif (";
  protected final String TEXT_111 = ") {" + NL + "  \t\tqry_";
  protected final String TEXT_112 = ".setOption(\"ojai.mapr.query.force-noncovering-sort\", true);" + NL + "  \t}" + NL + "  \t  \t" + NL + "  \tqry_";
  protected final String TEXT_113 = ".where(";
  protected final String TEXT_114 = ").build();//json-style condition support in ojai 2.0 and higher" + NL + "  \trst_";
  protected final String TEXT_115 = " = store_";
  protected final String TEXT_116 = ".findQuery(qry_";
  protected final String TEXT_117 = ");" + NL + "  \t";
  protected final String TEXT_118 = NL + NL + "  \tjava.util.Iterator<org.ojai.Document> itrst_";
  protected final String TEXT_119 = " = rst_";
  protected final String TEXT_120 = ".iterator();" + NL + "    org.ojai.Document readRecord_";
  protected final String TEXT_121 = ";" + NL + "\t" + NL + "    while (itrst_";
  protected final String TEXT_122 = ".hasNext()) {" + NL + "\t\tnb_line_";
  protected final String TEXT_123 = " ++;" + NL + "       \treadRecord_";
  protected final String TEXT_124 = " = itrst_";
  protected final String TEXT_125 = ".next();" + NL + "\t\torg.ojai.Value valueObj_";
  protected final String TEXT_126 = " = null;" + NL;
  protected final String TEXT_127 = NL + NL + "\t\tpath_";
  protected final String TEXT_128 = " = pathMap_";
  protected final String TEXT_129 = ".get(\"";
  protected final String TEXT_130 = "\");" + NL + "        valueObj_";
  protected final String TEXT_131 = " = readRecord_";
  protected final String TEXT_132 = ".getValue(path_";
  protected final String TEXT_133 = ");" + NL;
  protected final String TEXT_134 = NL + NL + "\t\t";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = " = valueObj_";
  protected final String TEXT_137 = " == null ? null : valueObj_";
  protected final String TEXT_138 = ".getObject();" + NL + "\t\t";
  protected final String TEXT_139 = NL + NL + "\t\tif(valueObj_";
  protected final String TEXT_140 = " != null) {" + NL + "\t\t";
  protected final String TEXT_141 = NL + "\t\t\tif (valueObj_";
  protected final String TEXT_142 = ".getType().equals(org.ojai.Value.Type.STRING)) {//when bulk write = true, Date is stored as String" + NL + "\t\t\t\t";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = " = (org.ojai.types.OTimestamp.parse(valueObj_";
  protected final String TEXT_145 = ".getString())).toDate();" + NL + "\t\t\t} else {//when bulk write = false, Date is stored as Timestamp " + NL + "\t\t\t\t";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = " = valueObj_";
  protected final String TEXT_148 = ".getTimestamp().toDate();" + NL + "\t\t\t}" + NL + "            ";
  protected final String TEXT_149 = NL + NL + "\t\t\t";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = " = valueObj_";
  protected final String TEXT_152 = ".getBinary().array();" + NL + "\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\t";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = " = valueObj_";
  protected final String TEXT_156 = ".getString();" + NL + "\t\t\t";
  protected final String TEXT_157 = NL + NL + "           \t";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = " = valueObj_";
  protected final String TEXT_160 = ".getInt();" + NL + "            ";
  protected final String TEXT_161 = NL + NL + "           \t";
  protected final String TEXT_162 = ".";
  protected final String TEXT_163 = " = valueObj_";
  protected final String TEXT_164 = ".getLong();" + NL + "            ";
  protected final String TEXT_165 = NL + NL + "           \t";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = " = valueObj_";
  protected final String TEXT_168 = ".getShort();" + NL + "            ";
  protected final String TEXT_169 = NL + NL + "           \t";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = " = valueObj_";
  protected final String TEXT_172 = ".getByte();";
  protected final String TEXT_173 = NL + NL + "\t\t\torg.json.JSONObject jsonObj = new org.json.JSONObject(valueObj_";
  protected final String TEXT_174 = ".asJsonString());" + NL + "\t\t\tString xml = \"<xml>\" + org.json.XML.toString(jsonObj) + \"</xml>\";" + NL + "\t\t\torg.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);" + NL + "\t\t\t";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = " = new routines.system.Document();" + NL + "           \t";
  protected final String TEXT_177 = ".";
  protected final String TEXT_178 = ".setDocument(doc);" + NL + "            ";
  protected final String TEXT_179 = NL;
  protected final String TEXT_180 = NL + "            ";
  protected final String TEXT_181 = ".";
  protected final String TEXT_182 = " = ParserUtils.parseTo_";
  protected final String TEXT_183 = "(valueObj_";
  protected final String TEXT_184 = ".toString());" + NL + "            ";
  protected final String TEXT_185 = NL + NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_186 = ".";
  protected final String TEXT_187 = " = ";
  protected final String TEXT_188 = ";" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_189 = NL + "\t\t";

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
	
    stringBuffer.append(TEXT_30);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean restrictPartialSorts = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__RESTRICT_PARTIAL_SORTS__"));
	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	String table = ElementParameterParser.getValue(node, "__TABLE__");
    boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
	String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
	String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
  	List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
	IConnection outConn = null;
	IMetadataTable metadata = null;
  	String firstConnName = "";
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	if(outputs!=null && outputs.size()> 0) {
		outConn = outputs.get(0);

		if(outConn!=null && outConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			firstConnName = outConn.getName();
			metadata = outConn.getMetadataTable();
		}
	}

  	List<IMetadataColumn> columnList = metadata.getListColumns();
  	Map<String, IMetadataColumn> columnMap = new java.util.HashMap<String, IMetadataColumn>();
  	
  	for  (IMetadataColumn column : columnList) {
  	    columnMap.put(column.getLabel(), column);
  	}
  	
    String query = ElementParameterParser.getValue(node,"__QUERY__");
    query = query.replaceAll("\n","");
    query = query.replaceAll("\r","");
    List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
	log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
    for (Map<String, String> pathElement : mapping) {
        String schemaColumn = pathElement.get("SCHEMA_COLUMN");
        String dbColumn = (columnMap.get(schemaColumn)).getOriginalDbColumnName();

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(pathElement.get("PARENT_FIELD_PATH"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
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
    stringBuffer.append(dbColumn);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
    }

    stringBuffer.append(TEXT_45);
    if(useKrb){
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    if(!useKeytab){
		        String passwordFieldName = "__KERBEROS_PASSWORD__";
    stringBuffer.append(TEXT_48);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_51);
    } else {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    if(useKeytab){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_67);
    }else{
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(userPrincipal);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
	if ("MAPROJAI_5_1".equals(dbVersion) || "MAPROJAI_5_2".equals(dbVersion)) { //OJAI 1.0)

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    
                   } else { //MAPR 6.0 (OJAI 2.0)

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(table );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(restrictPartialSorts );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(query );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
    }

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    
      	
       	int sizeColumns = columnList.size();

		if (firstConnName.length() > 0) {

			for (IMetadataColumn column : columnList) {
				
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
       			if (javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
          		} else {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
					if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_149);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
					} else if (javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
					} else if (javaType == JavaTypesManager.INTEGER) {

    stringBuffer.append(TEXT_157);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
                   } else if (javaType == JavaTypesManager.LONG) {

    stringBuffer.append(TEXT_161);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
                   } else if (javaType == JavaTypesManager.SHORT){

    stringBuffer.append(TEXT_165);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
                   } else if (javaType == JavaTypesManager.BYTE){

    stringBuffer.append(TEXT_169);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
                   } else if ("Document".equals(javaType.getLabel())){

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_178);
    
                   } else {

    stringBuffer.append(TEXT_179);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
				   }

    stringBuffer.append(TEXT_185);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_188);
    
				}
			}
		}
		

    stringBuffer.append(TEXT_189);
    return stringBuffer.toString();
  }
}
