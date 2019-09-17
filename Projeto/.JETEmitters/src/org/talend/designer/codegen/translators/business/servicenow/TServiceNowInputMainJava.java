package org.talend.designer.codegen.translators.business.servicenow;

import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TServiceNowInputMainJava
{
  protected static String nl;
  public static synchronized TServiceNowInputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TServiceNowInputMainJava result = new TServiceNowInputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                if(log.is";
  protected final String TEXT_3 = "Enabled())";
  protected final String TEXT_4 = NL + "            log.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + (";
  protected final String TEXT_8 = ") ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "            if (log.isDebugEnabled()) {" + NL + "                class BytesLimit65535_";
  protected final String TEXT_11 = "{" + NL + "                    public void limitLog4jByte() throws Exception{" + NL + "                    StringBuilder ";
  protected final String TEXT_12 = " = new StringBuilder();";
  protected final String TEXT_13 = NL + "                    ";
  protected final String TEXT_14 = ".append(\"Parameters:\");";
  protected final String TEXT_15 = NL + "                            ";
  protected final String TEXT_16 = ".append(\"";
  protected final String TEXT_17 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_18 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_19 = NL + "                            ";
  protected final String TEXT_20 = ".append(\"";
  protected final String TEXT_21 = "\" + \" = \" + ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "                        ";
  protected final String TEXT_24 = ".append(\" | \");";
  protected final String TEXT_25 = NL + "                    } " + NL + "                } " + NL + "            new BytesLimit65535_";
  protected final String TEXT_26 = "().limitLog4jByte();" + NL + "            }";
  protected final String TEXT_27 = NL + "            StringBuilder ";
  protected final String TEXT_28 = " = new StringBuilder();    ";
  protected final String TEXT_29 = NL + "                    ";
  protected final String TEXT_30 = ".append(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "                    if(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " == null){";
  protected final String TEXT_36 = NL + "                        ";
  protected final String TEXT_37 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_38 = NL + "                        ";
  protected final String TEXT_39 = ".append(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ");" + NL + "                    }   ";
  protected final String TEXT_42 = NL + "                ";
  protected final String TEXT_43 = ".append(\"|\");";
  protected final String TEXT_44 = NL + NL + NL + "nb_line_";
  protected final String TEXT_45 = "++;" + NL + "Object obj_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = "_resultArray.get(";
  protected final String TEXT_48 = "_i);" + NL + "if(obj_";
  protected final String TEXT_49 = " instanceof org.json.JSONObject){";
  protected final String TEXT_50 = NL + "    ";
  protected final String TEXT_51 = "_result = (org.json.JSONObject) ";
  protected final String TEXT_52 = "_resultArray.get(";
  protected final String TEXT_53 = "_i);" + NL + "}" + NL;
  protected final String TEXT_54 = NL + "\t";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " = null; // reset row value";
  protected final String TEXT_57 = NL + "\t\tdynamic_";
  protected final String TEXT_58 = ".clearColumnValues();" + NL + "    \tfor(int j_";
  protected final String TEXT_59 = " = 0; j_";
  protected final String TEXT_60 = " < dynamic_";
  protected final String TEXT_61 = ".getColumnCount(); j_";
  protected final String TEXT_62 = "++){" + NL + "\t\t\troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_63 = " = dynamic_";
  protected final String TEXT_64 = ".getColumnMetadata(j_";
  protected final String TEXT_65 = ");" + NL + "\t\t\tString columnName_";
  protected final String TEXT_66 = " = dynamicMetadata_";
  protected final String TEXT_67 = ".getName();" + NL + "\t\t\t" + NL + "\t\t\tString value_";
  protected final String TEXT_68 = " = (!";
  protected final String TEXT_69 = "_result.has(columnName_";
  protected final String TEXT_70 = ") || (";
  protected final String TEXT_71 = "_result.get(columnName_";
  protected final String TEXT_72 = ") == null)) ? null : ";
  protected final String TEXT_73 = "_result.get(columnName_";
  protected final String TEXT_74 = ").toString()";
  protected final String TEXT_75 = ".trim()";
  protected final String TEXT_76 = ";" + NL + "\t\t\t" + NL + "\t\t\tif(value_";
  protected final String TEXT_77 = " == null){" + NL + "\t\t\t\tdynamic_";
  protected final String TEXT_78 = ".addColumnValue(null);" + NL + "\t\t\t}else{" + NL + "\t\t\t\tif(\"id_String\".equals(dynamicMetadata_";
  protected final String TEXT_79 = ".getType()) || \"id_Object\".equals(dynamicMetadata_";
  protected final String TEXT_80 = ".getType())) {" + NL + "\t\t\t\t\tdynamic_";
  protected final String TEXT_81 = ".addColumnValue(value_";
  protected final String TEXT_82 = ");" + NL + "\t\t\t\t} else if(!value_";
  protected final String TEXT_83 = ".isEmpty()) {" + NL + "        \t\t\tif(\"id_Date\".equals(dynamicMetadata_";
  protected final String TEXT_84 = ".getType())){" + NL + "        \t\t\t\tdynamic_";
  protected final String TEXT_85 = ".addColumnValue(ParserUtils.parseTo_Date(value_";
  protected final String TEXT_86 = ", dynamicMetadata_";
  protected final String TEXT_87 = ".getFormat()));" + NL + "        \t\t\t}else if(\"id_Integer\".equals(dynamicMetadata_";
  protected final String TEXT_88 = ".getType())){" + NL + "        \t\t\t\tdynamic_";
  protected final String TEXT_89 = ".addColumnValue(ParserUtils.parseTo_Integer(value_";
  protected final String TEXT_90 = "));" + NL + "        \t\t\t}else if(\"id_Double\".equals(dynamicMetadata_";
  protected final String TEXT_91 = ".getType())){" + NL + "        \t\t\t\tdynamic_";
  protected final String TEXT_92 = ".addColumnValue(ParserUtils.parseTo_Double(value_";
  protected final String TEXT_93 = "));" + NL + "        \t\t\t}else if(\"id_Boolean\".equals(dynamicMetadata_";
  protected final String TEXT_94 = ".getType())){" + NL + "        \t\t\t\tdynamic_";
  protected final String TEXT_95 = ".addColumnValue(ParserUtils.parseTo_Boolean(value_";
  protected final String TEXT_96 = "));" + NL + "        \t\t\t}else if(\"id_Float\".equals(dynamicMetadata_";
  protected final String TEXT_97 = ".getType())){" + NL + "        \t\t\t\tdynamic_";
  protected final String TEXT_98 = ".addColumnValue(ParserUtils.parseTo_Float(value_";
  protected final String TEXT_99 = "));" + NL + "        \t\t\t}else if(\"id_BigDecimal\".equals(dynamicMetadata_";
  protected final String TEXT_100 = ".getType())){" + NL + "        \t\t\t\tdynamic_";
  protected final String TEXT_101 = ".addColumnValue(ParserUtils.parseTo_BigDecimal(value_";
  protected final String TEXT_102 = "));" + NL + "        \t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdynamic_";
  protected final String TEXT_103 = ".addColumnValue(null);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = dynamic_";
  protected final String TEXT_106 = ";";
  protected final String TEXT_107 = NL + NL + "\t//check data type" + NL + "  \tif (";
  protected final String TEXT_108 = "_result.has(\"";
  protected final String TEXT_109 = "\")) {" + NL + "    \tString value_";
  protected final String TEXT_110 = " = (";
  protected final String TEXT_111 = "_result.get(\"";
  protected final String TEXT_112 = "\") == null) ? null : ";
  protected final String TEXT_113 = "_result.get(\"";
  protected final String TEXT_114 = "\").toString()";
  protected final String TEXT_115 = ".trim()";
  protected final String TEXT_116 = ";" + NL + "    \t";
  protected final String TEXT_117 = NL + "  \t\t\t";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = " = value_";
  protected final String TEXT_120 = ";" + NL + "      \t";
  protected final String TEXT_121 = NL + "      \t\tif (value_";
  protected final String TEXT_122 = " != null && !value_";
  protected final String TEXT_123 = ".isEmpty()) {";
  protected final String TEXT_124 = NL + "          \t";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = " = value_";
  protected final String TEXT_127 = ";" + NL + "      \t";
  protected final String TEXT_128 = NL + "\t    \t";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = " = ParserUtils.parseTo_Date(value_";
  protected final String TEXT_131 = ", ";
  protected final String TEXT_132 = ");" + NL + "      \t";
  protected final String TEXT_133 = NL + "        \t";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = " = value_";
  protected final String TEXT_136 = ".getBytes();//use default encoding";
  protected final String TEXT_137 = NL + "        \t";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " = ParserUtils.parseTo_";
  protected final String TEXT_140 = "(value_";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL + "            } else {" + NL + "                //use the default value of java" + NL + "            }" + NL + "\t  \t";
  protected final String TEXT_143 = NL + "\t} else {" + NL + "  \t";
  protected final String TEXT_144 = NL + "  \t\tlog.warn(\"";
  protected final String TEXT_145 = " - Object: '\" + \"";
  protected final String TEXT_146 = "\" + \"' not found.\");";
  protected final String TEXT_147 = NL + "\t}";
  protected final String TEXT_148 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$") || cidx.matches("^.*?tDBOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
            }
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
    
    
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_14);
    
                    java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
                    ignoredParamsTypes.addAll(
                        java.util.Arrays.asList(
                            org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                            org.talend.core.model.process.EParameterFieldType.LABEL,
                            org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                            org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                            org.talend.core.model.process.EParameterFieldType.IMAGE,
                            org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                            org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                            org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                            org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                            org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                            org.talend.core.model.process.EParameterFieldType.VERSION,
                            org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                            org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                            org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                            org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                            org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                            org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                            org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                            )
                    );
                    for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                        if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                            continue;
                        }
                        String name = ep.getName();
                        if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                            String epName = "__" + name + "__";
                            String password = "";
                            if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                                password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                            }else{
                                String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                                if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                                    passwordValue = "\"\"";
                                } 
                                password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                            } 
                            
    stringBuffer.append(TEXT_15);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_18);
    
                        }else{
                            String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                            if(value.length()>10000){
                            value = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(value);
                            }
                            
    stringBuffer.append(TEXT_19);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_22);
    
                        }   
                        
    stringBuffer.append(TEXT_23);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_24);
    
                    }
                    debug(var("log4jParamters")); 
                    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
        } 
        
    
    } 
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_27);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_28);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_29);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    
                }else{
                
    stringBuffer.append(TEXT_33);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_41);
    
                }
                
    stringBuffer.append(TEXT_42);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_43);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;

log = new LogUtil(node);
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

//get column list
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas == null) || (metadatas.isEmpty())) {
	return stringBuffer.toString();
}

IMetadataTable metadata = metadatas.get(0);

if (metadata == null) {
	return stringBuffer.toString();
}

List<IMetadataColumn> columnList = metadata.getListColumns();                        
List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

//if output columns are defined
if(columnList==null || columnList.isEmpty() || outgoingConns == null || outgoingConns.isEmpty()){
	return stringBuffer.toString();
}

IConnection outgoingConn = outgoingConns.get(0);

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
for (int i = 0; i < columnList.size(); i++) {
	IMetadataColumn column = columnList.get(i);
	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);
	JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
	String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
	

    stringBuffer.append(TEXT_54);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_56);
    	
	if("id_Dynamic".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    if(isTrimAll){
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
		continue;
	}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_114);
    if(isTrimAll){
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    
    	if (javaType == JavaTypesManager.STRING) {
      	
    stringBuffer.append(TEXT_117);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
    	} else {
		
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
        if(javaType == JavaTypesManager.OBJECT) {
      	
    stringBuffer.append(TEXT_124);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
        } else if(javaType == JavaTypesManager.DATE) {
      	
    stringBuffer.append(TEXT_128);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_132);
    
        } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
      	
    stringBuffer.append(TEXT_133);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
 	 	} else {
        
    stringBuffer.append(TEXT_137);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
      	}
      	
    stringBuffer.append(TEXT_142);
    
  		}
      	
    stringBuffer.append(TEXT_143);
    
  	if(isLog4jEnabled){
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_146);
    
  	}
  	
    stringBuffer.append(TEXT_147);
    
}// column loop

    stringBuffer.append(TEXT_148);
    return stringBuffer.toString();
  }
}