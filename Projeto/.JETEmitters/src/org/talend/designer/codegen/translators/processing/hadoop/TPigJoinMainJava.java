package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.Java2STLangTypesHelper;
import java.util.List;
import java.util.Map;

public class TPigJoinMainJava
{
  protected static String nl;
  public static synchronized TPigJoinMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigJoinMainJava result = new TPigJoinMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_8 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_11 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_16 = " - Written records count: \" + nb_line_";
  protected final String TEXT_17 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_19 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_22 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Writing the record \" + nb_line_";
  protected final String TEXT_25 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processing the record \" + nb_line_";
  protected final String TEXT_28 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_30 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_31 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_32 = "\t" + NL + "\t" + NL + "\t\troutines.system.PigHelper helper_";
  protected final String TEXT_33 = " = new routines.system.PigHelper();" + NL + "\t\t" + NL + "\t\tStringBuilder sb_";
  protected final String TEXT_34 = " = new StringBuilder();\t\t" + NL + "\t\t" + NL + "\t\tsb_";
  protected final String TEXT_35 = " = new StringBuilder();" + NL;
  protected final String TEXT_36 = NL + "\t\t\tString decryptedS3Password_";
  protected final String TEXT_37 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "            String decryptedS3Password_";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ";";
  protected final String TEXT_42 = NL + "\t\tsb_";
  protected final String TEXT_43 = ".append(\"";
  protected final String TEXT_44 = "_LOOKUP = LOAD '\" + \"s3a://\" + ";
  protected final String TEXT_45 = " +\":\" + decryptedS3Password_";
  protected final String TEXT_46 = " + " + NL + "\t\t\t\t\t\"@\" + ";
  protected final String TEXT_47 = " + \"' using PigStorage('\"+";
  protected final String TEXT_48 = "+\"')\");";
  protected final String TEXT_49 = NL + "\t\tsb_";
  protected final String TEXT_50 = ".append(\"";
  protected final String TEXT_51 = "_LOOKUP = load '\"+";
  protected final String TEXT_52 = "+\"' using PigStorage('\"+";
  protected final String TEXT_53 = "+\"')\");";
  protected final String TEXT_54 = NL + "\t\t" + NL + "\t\tString schema_";
  protected final String TEXT_55 = "=\"\";";
  protected final String TEXT_56 = NL + "\t\t\t\tsb_";
  protected final String TEXT_57 = ".append(\" AS (\");";
  protected final String TEXT_58 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_59 = ".append(\"";
  protected final String TEXT_60 = ":";
  protected final String TEXT_61 = "\");";
  protected final String TEXT_62 = NL + "\t\t\t\tsb_";
  protected final String TEXT_63 = ".append(\")\");";
  protected final String TEXT_64 = NL + "\t\tsb_";
  protected final String TEXT_65 = ".append(\";\");\t\t" + NL + "\t\t" + NL + "\t\thelper_";
  protected final String TEXT_66 = ".add(\"query\",sb_";
  protected final String TEXT_67 = ".toString());" + NL + "\t\t" + NL + "\t\tsb_";
  protected final String TEXT_68 = " = new StringBuilder();" + NL + "\t\tsb_";
  protected final String TEXT_69 = ".append(\"";
  protected final String TEXT_70 = "_JOIN_RESULT = JOIN ";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = "_RESULT BY (\");";
  protected final String TEXT_73 = NL + "\t\t\tsb_";
  protected final String TEXT_74 = ".append(\"";
  protected final String TEXT_75 = "\");";
  protected final String TEXT_76 = NL + "\t\t\tsb_";
  protected final String TEXT_77 = ".append(\",\");";
  protected final String TEXT_78 = NL + "\t\tsb_";
  protected final String TEXT_79 = ".append(\")\");";
  protected final String TEXT_80 = NL + "\t\t\tsb_";
  protected final String TEXT_81 = ".append(\" LEFT\");";
  protected final String TEXT_82 = NL + "\t\t\tsb_";
  protected final String TEXT_83 = ".append(\" RIGHT\");";
  protected final String TEXT_84 = NL + "\t\t\tsb_";
  protected final String TEXT_85 = ".append(\" FULL\");";
  protected final String TEXT_86 = NL + "\t\tsb_";
  protected final String TEXT_87 = ".append(\", ";
  protected final String TEXT_88 = "_LOOKUP BY (\");";
  protected final String TEXT_89 = NL + "\t\t\tsb_";
  protected final String TEXT_90 = ".append(\"";
  protected final String TEXT_91 = "\");";
  protected final String TEXT_92 = NL + "\t\t\tsb_";
  protected final String TEXT_93 = ".append(\",\");";
  protected final String TEXT_94 = NL + "\t\tsb_";
  protected final String TEXT_95 = ".append(\")\");";
  protected final String TEXT_96 = NL + "\t\t\tsb_";
  protected final String TEXT_97 = ".append(\" USING '";
  protected final String TEXT_98 = "'\");";
  protected final String TEXT_99 = NL + "\t\t\tsb_";
  protected final String TEXT_100 = ".append(\" PARTITION BY \"+";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\t\t\tsb_";
  protected final String TEXT_103 = ".append(\" PARALLEL ";
  protected final String TEXT_104 = "\");";
  protected final String TEXT_105 = "\t\t" + NL + "\t\tsb_";
  protected final String TEXT_106 = ".append(\";\");" + NL + "\t\t" + NL + "\t\thelper_";
  protected final String TEXT_107 = ".add(\"query\",sb_";
  protected final String TEXT_108 = ".toString());" + NL + "" + NL + "\t\tsb_";
  protected final String TEXT_109 = " = new StringBuilder();" + NL + "\t\tsb_";
  protected final String TEXT_110 = ".append(\"";
  protected final String TEXT_111 = "_";
  protected final String TEXT_112 = "_RESULT = FOREACH ";
  protected final String TEXT_113 = "_JOIN_RESULT GENERATE \");" + NL;
  protected final String TEXT_114 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_115 = ".append(\"";
  protected final String TEXT_116 = "$";
  protected final String TEXT_117 = " AS ";
  protected final String TEXT_118 = "\");";
  protected final String TEXT_119 = NL + "\t\tsb_";
  protected final String TEXT_120 = ".append(\";\");" + NL + "\t\t\t" + NL + "\t\thelper_";
  protected final String TEXT_121 = ".add(\"query\",sb_";
  protected final String TEXT_122 = ".toString());" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_123 = NL + "\tjava.util.List<String[]> pigLatins_";
  protected final String TEXT_124 = " = helper_";
  protected final String TEXT_125 = ".getPigLatins();";
  protected final String TEXT_126 = NL + "\t\t";
  protected final String TEXT_127 = NL + "        \tjava.util.List<com.amazonaws.services.s3.model.S3ObjectSummary> s3Objects_";
  protected final String TEXT_128 = " = s3Client_";
  protected final String TEXT_129 = ".listObjectsV2(";
  protected final String TEXT_130 = ").getObjectSummaries();" + NL + "        \tjava.util.Set<String> s3Keys_";
  protected final String TEXT_131 = " = s3Objects_";
  protected final String TEXT_132 = ".stream().map(obj -> obj.getKey()).collect(java.util.stream.Collectors.toSet());";
  protected final String TEXT_133 = NL + NL + "\t\tfor(String[] pigLatin_";
  protected final String TEXT_134 = " : pigLatins_";
  protected final String TEXT_135 = ") {" + NL + "\t\t\tString type_";
  protected final String TEXT_136 = " = pigLatin_";
  protected final String TEXT_137 = "[0];" + NL + "\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_139 = " - register \" + type_";
  protected final String TEXT_140 = " + \": \" + pigLatin_";
  protected final String TEXT_141 = "[1]);" + NL + "\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\tif(\"query\".equals(type_";
  protected final String TEXT_143 = ")) {";
  protected final String TEXT_144 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_145 = ".write(pigLatin_";
  protected final String TEXT_146 = "[1]);";
  protected final String TEXT_147 = NL + "\t\t\t\t\tstatements_";
  protected final String TEXT_148 = ".append(pigLatin_";
  protected final String TEXT_149 = "[1]);" + NL + "\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_151 = ".registerQuery(pigLatin_";
  protected final String TEXT_152 = "[1]);";
  protected final String TEXT_153 = NL + "\t\t\t} else if (\"jar\".equals(type_";
  protected final String TEXT_154 = ")) {";
  protected final String TEXT_155 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_156 = ".write(\"REGISTER \" + wasbPath_";
  protected final String TEXT_157 = " + new java.io.File(pigLatin_";
  protected final String TEXT_158 = "[1]).getName() + \";\");" + NL + "\t\t\t\t\tlibjars_";
  protected final String TEXT_159 = ".append(pigLatin_";
  protected final String TEXT_160 = "[1] + \",\");";
  protected final String TEXT_161 = NL + "\t\t\t\t\tString jarName_";
  protected final String TEXT_162 = " = new String();" + NL + "\t\t\t\t\tString[] pathSplit = pigLatin_";
  protected final String TEXT_163 = "[1].split(\"/\");" + NL + "            \t\tjarName_";
  protected final String TEXT_164 = " = pathSplit[pathSplit.length - 1];" + NL + "            \t\tjava.util.regex.Pattern jarPattern = java.util.regex.Pattern.compile(\".*\\\\.jar\");" + NL + "\t\t\t\t\tif (!jarPattern.matcher(jarName_";
  protected final String TEXT_165 = ").matches()) {" + NL + "            \t\t\tthrow new IllegalArgumentException(\"";
  protected final String TEXT_166 = " - Incorrect jar path: \" + pigLatin_";
  protected final String TEXT_167 = "[1]);" + NL + "        \t\t\t}" + NL + "        \t\t\tboolean exist = s3Keys_";
  protected final String TEXT_168 = ".contains(";
  protected final String TEXT_169 = ".replaceAll(\"^/+|/+$\", \"\") + \"/\" + jarName_";
  protected final String TEXT_170 = ");" + NL + "        \t\t\tif (!exist) {" + NL + "\t\t\t\t\t\ts3Client_";
  protected final String TEXT_171 = ".putObject(";
  protected final String TEXT_172 = ", ";
  protected final String TEXT_173 = ".replaceAll(\"^/+|/+$\", \"\") + \"/\" + jarName_";
  protected final String TEXT_174 = ", new java.io.File(pigLatin_";
  protected final String TEXT_175 = "[1]));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tstatements_";
  protected final String TEXT_176 = ".append(\"REGISTER s3a://\" + ";
  protected final String TEXT_177 = " + \":\" + routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_178 = ") + \"@\" + ";
  protected final String TEXT_179 = " + \"/\" + ";
  protected final String TEXT_180 = ".replaceAll(\"^/+|/+$\", \"\") + \"/\" + jarName_";
  protected final String TEXT_181 = " + \";\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_183 = " - upload jar to S3: \" + pigLatin_";
  protected final String TEXT_184 = "[1] + \" --> s3a://\" + ";
  protected final String TEXT_185 = " + \"/\" + ";
  protected final String TEXT_186 = ".replaceAll(\"^/+|/+$\", \"\") + \"/\" + jarName_";
  protected final String TEXT_187 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_189 = ".registerJar(pigLatin_";
  protected final String TEXT_190 = "[1]);";
  protected final String TEXT_191 = NL + "\t\t\t} else if (\"script\".equals(type_";
  protected final String TEXT_192 = ")) {";
  protected final String TEXT_193 = NL + "\t\t\t\t\t\tbw_";
  protected final String TEXT_194 = ".write(pigLatin_";
  protected final String TEXT_195 = "[1]);";
  protected final String TEXT_196 = NL + "\t\t\t\t\t\t// Script is not supported on qubole.";
  protected final String TEXT_197 = NL + "\t\t\t\t\t\tpigServer_";
  protected final String TEXT_198 = ".registerScript(new java.io.ByteArrayInputStream(pigLatin_";
  protected final String TEXT_199 = "[1].getBytes()));";
  protected final String TEXT_200 = NL + "\t\t\t} else if (\"function\".equals(type_";
  protected final String TEXT_201 = ")) {";
  protected final String TEXT_202 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_203 = ".write(\"DEFINE \" + pigLatin_";
  protected final String TEXT_204 = "[1] + \" \" + pigLatin_";
  protected final String TEXT_205 = "[2] + \";\");";
  protected final String TEXT_206 = NL + "\t\t\t\t\t\t// DEFINE is not supported on qubole.";
  protected final String TEXT_207 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_208 = ".registerFunction(pigLatin_";
  protected final String TEXT_209 = "[1], new org.apache.pig.FuncSpec(pigLatin_";
  protected final String TEXT_210 = "[2]));";
  protected final String TEXT_211 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_212 = NL + "    \tpigScript_";
  protected final String TEXT_213 = ".addAll(pigLatins_";
  protected final String TEXT_214 = ");";
  protected final String TEXT_215 = NL + "\tpigLatins_";
  protected final String TEXT_216 = ".clear();";
  protected final String TEXT_217 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String previous_node="";
	String start_node="";

	boolean inMain = true;
	boolean isExecutedThroughWebHCat = false;
	
	boolean isQuboleDistribution = false;
	boolean isCloudDistribution = false;
	boolean isQuboleS3Resource = false;
	String quboleS3ResourceAccessKey = "";
	String quboleS3ResourceSecretKey = "";
	String quboleS3ResourceBucketName = "";
	String quboleS3ResourceBucketKey = "";

	String previousOutputConnectionName = "";
	
	if(node.getIncomingConnections()!=null && node.getIncomingConnections().size()>0) {
		IConnection connection = node.getIncomingConnections().get(0);
		previous_node = connection.getSource().getUniqueName();
		INode loadNode = node.getDesignSubjobStartNode();
		start_node = loadNode.getUniqueName();

		boolean isLocal = "true".equals(ElementParameterParser.getValue(loadNode, "__LOCAL__"));

        if(!isLocal) {
            String loadDistribution = ElementParameterParser.getValue(loadNode, "__DISTRIBUTION__");
            String loadPigVersion = ElementParameterParser.getValue(loadNode, "__PIG_VERSION__");
            org.talend.hadoop.distribution.component.PigComponent pigDistrib = null;
            try {
                pigDistrib = (org.talend.hadoop.distribution.component.PigComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(loadDistribution, loadPigVersion);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return "";
            }

            boolean isCustom = pigDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
            isExecutedThroughWebHCat = !isCustom && pigDistrib != null && pigDistrib.isExecutedThroughWebHCat();
            isQuboleDistribution = pigDistrib != null && pigDistrib.isQuboleDistribution();
            isCloudDistribution = pigDistrib != null && pigDistrib.isCloudDistribution();
            if (isQuboleDistribution && ElementParameterParser.getBooleanValue(loadNode, "__QUBOLE_S3__")) {
            	quboleS3ResourceAccessKey = ElementParameterParser.getValue(loadNode, "__QUBOLE_S3_ACCESS_KEY__");
            	quboleS3ResourceSecretKey = ElementParameterParser.getPasswordValue(loadNode, "__QUBOLE_S3_SECRET_KEY__");
            	quboleS3ResourceBucketName = ElementParameterParser.getValue(loadNode, "__QUBOLE_S3_BUCKET_NAME__");
            	quboleS3ResourceBucketKey = ElementParameterParser.getValue(loadNode, "__QUBOLE_S3_BUCKET_KEY__");
            }
        }

		inMain = loadNode.isSubtreeStart();
		previousOutputConnectionName = connection.getName();
	}
	
	String outputConnectionName = "";
	List<IConnection> outputConnections = (List<IConnection>)node.getOutgoingConnections();
	if(outputConnections!=null && outputConnections.size()>0) {
		outputConnectionName = outputConnections.get(0).getName();
	}
	
	String lookup_filename = ElementParameterParser.getValue(node, "__LOOKUP_FILENAME__");
	String lookup_separator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR_CHAR_LOOKUP__");
	
	List<Map<String, String>> joinKeyColumns = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__JOIN_KEY__");
	String joinMode = ElementParameterParser.getValue(node, "__JOIN_MODE__");
	
	boolean optimize = "true".equals(ElementParameterParser.getValue(node, "__OPTIMIZE__"));
	String using = ElementParameterParser.getValue(node, "__USING__");
	
	boolean usePartition = "true".equals(ElementParameterParser.getValue(node, "__USE_PARTITION__"));
	String partition = ElementParameterParser.getValue(node, "__PARTITION__");
	
	boolean useParallel = "true".equals(ElementParameterParser.getValue(node, "__INCREASE_PARALLELISM__"));
	String reduce_number = ElementParameterParser.getValue(node, "__REDUCE_NUMBER__");
	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
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
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	log4jFileUtil.componentStartInfo(node);
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    	
	boolean isS3Location = "true".equals(ElementParameterParser.getValue(node, "__S3_LOCATION_LOAD__"));
	
	if (isS3Location) {
		String s3bucket = ElementParameterParser.getValue(node, "__S3_BUCKET_LOAD__");
		String s3username = ElementParameterParser.getValue(node, "__S3_USERNAME_LOAD__");
		String passwordFieldName = "__S3_PASSWORD_LOAD__";
    	
        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_38);
    
        } else {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_41);
    
        }

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(lookup_separator);
    stringBuffer.append(TEXT_48);
    
    } else {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(lookup_filename);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(lookup_separator);
    stringBuffer.append(TEXT_53);
    
    }

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if(metadatas != null && metadatas.size() > 2) {
		    metadata = metadatas.get(2);
		}
		if(metadata!=null) {
			if(metadata.getListColumns() != null && metadata.getListColumns().size() > 0) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
				for(int i=0; i<metadata.getListColumns().size(); i++) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i!=0?", ":"");
    stringBuffer.append(metadata.getListColumns().get(i).getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(Java2STLangTypesHelper.getPigType(metadata, metadata.getListColumns().get(i).getLabel()));
    stringBuffer.append(TEXT_61);
    

				}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
			}
		}

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
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_72);
    
		for(int i=0;i<joinKeyColumns.size();i++){
			Map<String, String> line = joinKeyColumns.get(i);

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(line.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_75);
    
			if(i!=joinKeyColumns.size()-1){

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
			}
		}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
		if("left-outer-join".equals(joinMode)) {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
		}
		if("right-outer-join".equals(joinMode)) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
		}
		if("full-outer-join".equals(joinMode)) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
		}

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
		for(int i=0;i<joinKeyColumns.size();i++){
			Map<String, String> line = joinKeyColumns.get(i);

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(line.get("LOOKUP_COLUMN"));
    stringBuffer.append(TEXT_91);
    
			if(i!=joinKeyColumns.size()-1){

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
			}
		}
		

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
		if(optimize) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(using);
    stringBuffer.append(TEXT_98);
    
		}
		
		if(usePartition && !("skewed".equals(using))) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(partition);
    stringBuffer.append(TEXT_101);
    
		}
		
		if(useParallel) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(reduce_number);
    stringBuffer.append(TEXT_104);
    
		}
		

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
		if(metadatas != null && metadatas.size() > 0) {
		    metadata = metadatas.get(0);
		}
		if(metadata!=null) {
			if(metadata.getListColumns() != null && metadata.getListColumns().size() > 0) {
				for(int i=0; i<metadata.getListColumns().size(); i++) {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(i!=0?", ":"");
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(metadata.getListColumns().get(i).getLabel());
    stringBuffer.append(TEXT_118);
    

				}
			}
		}

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
	if(inMain) {

    stringBuffer.append(TEXT_126);
    if (isQuboleDistribution && isQuboleS3Resource) {
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(quboleS3ResourceBucketName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    if(isLog4jEnabled && !isQuboleDistribution) {
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_144);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    					
				} else if (isQuboleDistribution) {
				
    stringBuffer.append(TEXT_147);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
				} else {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
				}

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    					
				} else if (isQuboleDistribution) {
					if (isQuboleS3Resource) {
				
    stringBuffer.append(TEXT_161);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(quboleS3ResourceBucketKey);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(quboleS3ResourceBucketName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(quboleS3ResourceBucketKey);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(quboleS3ResourceAccessKey);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(quboleS3ResourceSecretKey);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(quboleS3ResourceBucketName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(quboleS3ResourceBucketKey);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_181);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(quboleS3ResourceBucketName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(quboleS3ResourceBucketKey);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_187);
    }
					}
				} else {

    stringBuffer.append(TEXT_188);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
				}

    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
					if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_193);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    					
					} else if (isQuboleDistribution) {

    stringBuffer.append(TEXT_196);
    
					} else {

    stringBuffer.append(TEXT_197);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
					}

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
					if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_202);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    					
					} else if (isQuboleDistribution) {

    stringBuffer.append(TEXT_206);
    
					} else {

    stringBuffer.append(TEXT_207);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
					}

    stringBuffer.append(TEXT_211);
    
	} else {

    stringBuffer.append(TEXT_212);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
	}

    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(TEXT_217);
    return stringBuffer.toString();
  }
}
