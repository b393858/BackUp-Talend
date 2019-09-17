package org.talend.designer.codegen.translators.databasesnosql.dynamodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TDynamoDBInputBeginJava
{
  protected static String nl;
  public static synchronized TDynamoDBInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDynamoDBInputBeginJava result = new TDynamoDBInputBeginJava();
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
  protected final String TEXT_29 = NL + "\tint nb_line_";
  protected final String TEXT_30 = " = 0;" + NL + "\t" + NL + "\t";
  protected final String TEXT_31 = NL + NL + "\t\t\t";
  protected final String TEXT_32 = "\t" + NL + "\t";
  protected final String TEXT_33 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_34 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = "; ";
  protected final String TEXT_39 = NL + "\t" + NL + "\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_40 = " = null;" + NL + "\t" + NL + "\t";
  protected final String TEXT_41 = NL + "\tcredentialsProvider_";
  protected final String TEXT_42 = " = new com.amazonaws.auth.InstanceProfileCredentialsProvider();" + NL + "\t";
  protected final String TEXT_43 = NL + "\t" + NL + "\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_44 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_45 = ",decryptedPassword_";
  protected final String TEXT_46 = ");" + NL + "\tcredentialsProvider_";
  protected final String TEXT_47 = " = new com.amazonaws.internal.StaticCredentialsProvider(credentials_";
  protected final String TEXT_48 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_49 = NL + "\tint sessionDurationSeconds_";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = " * 60;" + NL + "\tcom.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder credentialsProviderBuilder_";
  protected final String TEXT_52 = " = new com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider" + NL + "\t\t\t\t\t\t.Builder(";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ")";
  protected final String TEXT_55 = ".withServiceEndpoint(";
  protected final String TEXT_56 = ")";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t.withLongLivedCredentialsProvider(credentialsProvider_";
  protected final String TEXT_58 = ")" + NL + "\t\t\t\t\t\t.withRoleSessionDurationSeconds(sessionDurationSeconds_";
  protected final String TEXT_59 = ");" + NL + "\t" + NL + "\tcredentialsProvider_";
  protected final String TEXT_60 = " = credentialsProviderBuilder_";
  protected final String TEXT_61 = ".build();" + NL + "\t";
  protected final String TEXT_62 = NL + NL + "\t\t\tcom.amazonaws.services.dynamodbv2.AmazonDynamoDBClient dynamoDBClient_";
  protected final String TEXT_63 = " = new com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient(" + NL + "\t\t\t\tcredentialsProvider_";
  protected final String TEXT_64 = "," + NL + "\t\t\t\tcom.amazonaws.PredefinedClientConfigurations.dynamoDefault().withUserAgent(\"";
  protected final String TEXT_65 = "\")" + NL + "\t\t\t);" + NL + "   " + NL + "\t\t\tif(";
  protected final String TEXT_66 = ")" + NL + "\t\t\t{" + NL + "\t\t\t\tdynamoDBClient_";
  protected final String TEXT_67 = " = dynamoDBClient_";
  protected final String TEXT_68 = ".withEndpoint(";
  protected final String TEXT_69 = ");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\tdynamoDBClient_";
  protected final String TEXT_71 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_72 = "));" + NL + "\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\tcom.amazonaws.services.dynamodbv2.document.DynamoDB dynamoDB_";
  protected final String TEXT_74 = " = new com.amazonaws.services.dynamodbv2.document.DynamoDB(dynamoDBClient_";
  protected final String TEXT_75 = ");" + NL + "\t\t\tcom.amazonaws.services.dynamodbv2.document.Table table_";
  protected final String TEXT_76 = " = dynamoDB_";
  protected final String TEXT_77 = ".getTable(";
  protected final String TEXT_78 = ");" + NL + "\t\t" + NL + "" + NL + "\t\t";
  protected final String TEXT_79 = NL + "\t\t\t" + NL + "\t\t\tjava.util.HashMap<String,Object> valueMap_";
  protected final String TEXT_80 = " = new java.util.HashMap<String,Object>();\t\t\t" + NL + "\t\t\tjava.util.HashMap<String,String> nameMap_";
  protected final String TEXT_81 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t" + NL + "\t\t\tString keyConditionExpression_";
  protected final String TEXT_82 = " = null;" + NL + "\t\t\tString filterExpression_";
  protected final String TEXT_83 = " = null;" + NL + "\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\tnameMap_";
  protected final String TEXT_85 = ".put(\"";
  protected final String TEXT_86 = "\", \"";
  protected final String TEXT_87 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\tvalueMap_";
  protected final String TEXT_89 = ".put(\"";
  protected final String TEXT_90 = "\", ";
  protected final String TEXT_91 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\t\tvalueMap_";
  protected final String TEXT_93 = ".put(\"";
  protected final String TEXT_94 = "\",  ";
  protected final String TEXT_95 = ");\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\tvalueMap_";
  protected final String TEXT_97 = ".put(\"";
  protected final String TEXT_98 = "\",  ";
  protected final String TEXT_99 = ");\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t" + NL + "\t\t\t\tkeyConditionExpression_";
  protected final String TEXT_101 = " = \"";
  protected final String TEXT_102 = "\";" + NL + "\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\tkeyConditionExpression_";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = ";\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\tcom.amazonaws.services.dynamodbv2.document.spec.QuerySpec querySpec_";
  protected final String TEXT_107 = " = new com.amazonaws.services.dynamodbv2.document.spec.QuerySpec()" + NL + "\t\t\t\t.withKeyConditionExpression(keyConditionExpression_";
  protected final String TEXT_108 = ");" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_109 = "\t" + NL + "\t\t\t\t\t\t\t\tvalueMap_";
  protected final String TEXT_110 = ".put(\"";
  protected final String TEXT_111 = "\",  ";
  protected final String TEXT_112 = ");\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_113 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tvalueMap_";
  protected final String TEXT_114 = ".put(\"";
  protected final String TEXT_115 = "\",  ";
  protected final String TEXT_116 = ");\t\t\t\t\t" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t" + NL + "\t\t\t\t\tfilterExpression_";
  protected final String TEXT_118 = " = \"";
  protected final String TEXT_119 = "\";" + NL + "\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t\tfilterExpression_";
  protected final String TEXT_121 = " = ";
  protected final String TEXT_122 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_123 = "\t\t\t\t" + NL + "\t\t\t\tif(!filterExpression_";
  protected final String TEXT_124 = ".isEmpty()){\t\t\t" + NL + "\t\t\t\t\tquerySpec_";
  protected final String TEXT_125 = " = querySpec_";
  protected final String TEXT_126 = ".withFilterExpression(filterExpression_";
  protected final String TEXT_127 = ");\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t" + NL + "\t\t\tif(valueMap_";
  protected final String TEXT_129 = ".size() > 0)" + NL + "\t\t\t{" + NL + "\t\t\t\tquerySpec_";
  protected final String TEXT_130 = " = querySpec_";
  protected final String TEXT_131 = ".withValueMap(valueMap_";
  protected final String TEXT_132 = ");\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(nameMap_";
  protected final String TEXT_133 = ".size() > 0)" + NL + "\t\t\t{" + NL + "\t\t\t\tquerySpec_";
  protected final String TEXT_134 = " = querySpec_";
  protected final String TEXT_135 = ".withNameMap(nameMap_";
  protected final String TEXT_136 = ");\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tcom.amazonaws.services.dynamodbv2.document.ItemCollection<com.amazonaws.services.dynamodbv2.document.QueryOutcome> items_";
  protected final String TEXT_137 = " = null;" + NL + "" + NL + "\t\t\titems_";
  protected final String TEXT_138 = " = table_";
  protected final String TEXT_139 = ".query(querySpec_";
  protected final String TEXT_140 = ");" + NL + "\t\t";
  protected final String TEXT_141 = NL + "\t\t\tcom.amazonaws.services.dynamodbv2.document.spec.ScanSpec scanSpec_";
  protected final String TEXT_142 = " = new com.amazonaws.services.dynamodbv2.document.spec.ScanSpec();\t" + NL + "\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\tjava.util.HashMap<String,Object> valueMap_";
  protected final String TEXT_144 = " = new java.util.HashMap<String,Object>();\t\t\t" + NL + "\t\t\t\tjava.util.HashMap<String,String> nameMap_";
  protected final String TEXT_145 = " = new java.util.HashMap<String,String>();\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\tnameMap_";
  protected final String TEXT_147 = ".put(\"";
  protected final String TEXT_148 = "\", \"";
  protected final String TEXT_149 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_150 = NL + NL + "\t\t\t\t\t\t\tvalueMap_";
  protected final String TEXT_151 = ".put(\"";
  protected final String TEXT_152 = "\", ";
  protected final String TEXT_153 = ");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\tString filterExpression_";
  protected final String TEXT_155 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_156 = NL + "\t\t\t\t\t\t\t\tvalueMap_";
  protected final String TEXT_157 = ".put(\"";
  protected final String TEXT_158 = "\",  ";
  protected final String TEXT_159 = ");\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_160 = "\t" + NL + "\t\t\t\t\t\tvalueMap_";
  protected final String TEXT_161 = ".put(\"";
  protected final String TEXT_162 = "\",  ";
  protected final String TEXT_163 = ");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\t" + NL + "\t\t\t\t\tfilterExpression_";
  protected final String TEXT_165 = " = \"";
  protected final String TEXT_166 = "\";\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\t\tfilterExpression_";
  protected final String TEXT_168 = " = ";
  protected final String TEXT_169 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t\tif(!filterExpression_";
  protected final String TEXT_171 = ".isEmpty()){\t\t\t" + NL + "\t\t\t\t\tscanSpec_";
  protected final String TEXT_172 = " = scanSpec_";
  protected final String TEXT_173 = ".withFilterExpression(filterExpression_";
  protected final String TEXT_174 = ");\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tif(valueMap_";
  protected final String TEXT_175 = ".size() > 0)" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tscanSpec_";
  protected final String TEXT_176 = " = scanSpec_";
  protected final String TEXT_177 = ".withValueMap(valueMap_";
  protected final String TEXT_178 = ");\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tif(nameMap_";
  protected final String TEXT_179 = ".size() > 0)" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tscanSpec_";
  protected final String TEXT_180 = " = scanSpec_";
  protected final String TEXT_181 = ".withNameMap(nameMap_";
  protected final String TEXT_182 = ");\t" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\tcom.amazonaws.services.dynamodbv2.document.ItemCollection<com.amazonaws.services.dynamodbv2.document.ScanOutcome> items_";
  protected final String TEXT_184 = " = null;" + NL + "\t\t\titems_";
  protected final String TEXT_185 = " = table_";
  protected final String TEXT_186 = ".scan(scanSpec_";
  protected final String TEXT_187 = ");" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_188 = NL + "\t\tcom.amazonaws.services.dynamodbv2.document.Item item_";
  protected final String TEXT_189 = " = null;" + NL + "\t\tjava.util.Iterator<com.amazonaws.services.dynamodbv2.document.Item> iterator_";
  protected final String TEXT_190 = " = null;" + NL + "\t\titerator_";
  protected final String TEXT_191 = " = items_";
  protected final String TEXT_192 = ".iterator();" + NL + "\t\twhile (iterator_";
  protected final String TEXT_193 = ".hasNext()) {" + NL + "  ";
  protected final String TEXT_194 = NL + "          nb_line_";
  protected final String TEXT_195 = "++;" + NL + "          item_";
  protected final String TEXT_196 = " = iterator_";
  protected final String TEXT_197 = ".next();" + NL + "          ";
  protected final String TEXT_198 = NL + "\t\t\t\tObject valueObj_";
  protected final String TEXT_199 = "=null;";
  protected final String TEXT_200 = NL + "\t\t\t\t\tvalueObj_";
  protected final String TEXT_201 = "=item_";
  protected final String TEXT_202 = ".get(\"";
  protected final String TEXT_203 = "\");" + NL;
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_205 = ".";
  protected final String TEXT_206 = " = valueObj_";
  protected final String TEXT_207 = ";";
  protected final String TEXT_208 = NL + "\t\t\t\t\t\tif(valueObj_";
  protected final String TEXT_209 = "!=null && valueObj_";
  protected final String TEXT_210 = ".toString().length() > 0) {";
  protected final String TEXT_211 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = " = ParserUtils.parseTo_Date((String)valueObj_";
  protected final String TEXT_214 = ", ";
  protected final String TEXT_215 = ");";
  protected final String TEXT_216 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = " = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap((byte[])valueObj_";
  protected final String TEXT_219 = ")).toString().getBytes(utf8Charset);";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = " = valueObj_";
  protected final String TEXT_223 = ".toString();";
  protected final String TEXT_224 = NL + "\t\t\t\t\t\t\t\tif (valueObj_";
  protected final String TEXT_225 = ".getClass().equals(Double.class)) {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_228 = ".toString()).intValue();" + NL + "\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = " = ParserUtils.parseTo_";
  protected final String TEXT_231 = "(valueObj_";
  protected final String TEXT_232 = ".toString());" + NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_233 = "\t" + NL + "\t\t\t\t\t\t\t\tif (valueObj_";
  protected final String TEXT_234 = ".getClass().equals(Double.class)) {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_237 = ".toString()).longValue();" + NL + "\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = " = ParserUtils.parseTo_";
  protected final String TEXT_240 = "(valueObj_";
  protected final String TEXT_241 = ".toString());" + NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_242 = NL + "\t\t\t\t\t\t\t\tif (valueObj_";
  protected final String TEXT_243 = ".getClass().equals(Double.class)) {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_244 = ".";
  protected final String TEXT_245 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_246 = ".toString()).shortValue();" + NL + "\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_247 = ".";
  protected final String TEXT_248 = " = ParserUtils.parseTo_";
  protected final String TEXT_249 = "(valueObj_";
  protected final String TEXT_250 = ".toString());" + NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = " = ParserUtils.parseTo_";
  protected final String TEXT_254 = "(valueObj_";
  protected final String TEXT_255 = ".toString());";
  protected final String TEXT_256 = NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_257 = ".";
  protected final String TEXT_258 = " = ";
  protected final String TEXT_259 = ";" + NL + "\t\t\t\t\t\t}" + NL + "          ";
  protected final String TEXT_260 = NL;
  protected final String TEXT_261 = NL;

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

	String region = ElementParameterParser.getValue(node, "__REGION__");

	boolean useEndPoint = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_ENDPOINT__"));
	boolean useFilterExpression = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_FILTER_EXPRESSION__"));
	boolean useAdvancedKeyConditionExpression = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_ADVANCED_KEY_CONDITION_EXPRESSION__"));
	boolean useAdvancedFilterExpression = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_ADVANCED_FILTER_EXPRESSION__"));
	final String AWSTracker = org.talend.core.utils.TrackerUtil.getAWSTracker();
	
    String endPoint   = ElementParameterParser.getValue(node, "__ENDPOINT__");
    String table   = ElementParameterParser.getValue(node, "__TABLE__");
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	
	String advancedKeyConditionExpression = ElementParameterParser.getValue(node, "__ADVANCED_KEY_CONDITION_EXPRESSION__");
	String advancedFilterExpression = ElementParameterParser.getValue(node, "__ADVANCED_FILTER_EXPRESSION__");
	
	List<Map<String, String>> keyConditionExpression = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__KEY_CONDITION_EXPRESSION__");
	List<Map<String, String>> filterExpression = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILTER_EXPRESSION__");
	
	List<Map<String, String>> nameMap = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAME_MAPPING__");
	List<Map<String, String>> valueMap = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__VALUE_MAPPING__");
	
  	List<IMetadataTable> metadatas = node.getMetadataList();
  	List<IMetadataColumn> columnList = null;
  	List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
  	String firstConnName = "";
  	if (outputs.size() > 0){
		IConnection out = outputs.get(0);
		if(out!=null && out.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			firstConnName = out.getName();
		}
    }
	
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){		
			columnList = metadata.getListColumns();
			int sizeColumns = columnList.size();
		
    stringBuffer.append(TEXT_31);
    
	String accesskey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	
	boolean inheritCredentials = "true".equals(ElementParameterParser.getValue(node, "__INHERIT_CREDENTIALS__"));
	
	boolean assumeRole = "true".equals(ElementParameterParser.getValue(node, "__ASSUME_ROLE__"));
	
	String arn = ElementParameterParser.getValue(node, "__ARN__");
	
	String roleSessionName = ElementParameterParser.getValue(node, "__ROLE_SESSION_NAME__");
	
	String sessionDuration = ElementParameterParser.getValue(node,"__SESSION_DURATION__");
	if(sessionDuration == null || sessionDuration.isEmpty()) {
		sessionDuration = "15";
	}
	
	boolean setStsEndpoint = "true".equals(ElementParameterParser.getValue(node, "__SET_STS_ENDPOINT__"));
	
	String stsEndpoint = ElementParameterParser.getValue(node, "__STS_ENDPOINT__");

    
	String passwordFieldName = "__SECRET_KEY__";
	
    stringBuffer.append(TEXT_32);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_35);
    } else {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
	if(inheritCredentials) {
	
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    } else {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(accesskey);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    }
	if(assumeRole) {
	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(sessionDuration);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(arn);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(roleSessionName);
    stringBuffer.append(TEXT_54);
    if(setStsEndpoint) {
    stringBuffer.append(TEXT_55);
    stringBuffer.append(stsEndpoint);
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
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(AWSTracker);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(useEndPoint);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(endPoint);
    stringBuffer.append(TEXT_69);
    
			if(!useEndPoint && region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region)){
			
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_72);
    
			}
		
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_78);
    
		if(action.equalsIgnoreCase("Query")){
		
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
			for(Map<String,String> subNameMap : nameMap)
			{
				String placeholder = subNameMap.get("PLACEHOLDER");
				String name = subNameMap.get("NAME");
				
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(placeholder);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_87);
    
			}
			
			
			if(useAdvancedKeyConditionExpression || useAdvancedFilterExpression)
			{			
				for(Map<String,String> subValueMap : valueMap)
				{
					String placeholder = subValueMap.get("PLACEHOLDER");
					String value = subValueMap.get("VALUE");
					
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(placeholder);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_91);
    
				}
			}
					
			StringBuffer sb = new StringBuffer();	
			
			if(!useAdvancedKeyConditionExpression){			
				for(Map<String,String> subExpression : keyConditionExpression)
				{
					String reservedKeyPlaceHolder = null;
					String valuePlaceHolder1 = null;
					String valuePlaceHolder2 = null;
					String keyColumn = subExpression.get("KEY_COLUMN");

					valuePlaceHolder1 = ":keyCondition_" + keyColumn +"_1";
					valuePlaceHolder2 = ":keyCondition_" + keyColumn +"_2";
				
					for(Map<String,String> subNameMap : nameMap){
						String placeholder = subNameMap.get("PLACEHOLDER");
						String name = subNameMap.get("NAME");
						if(name.equals(keyColumn))
						{
							reservedKeyPlaceHolder = placeholder;							
							break;
						}
					}
				
					String functionStr = subExpression.get("FUNCTION");
					String value1 = subExpression.get("VALUE_1");
					String value2 = subExpression.get("VALUE_2");
					

					
					if(functionStr.equalsIgnoreCase("Begins_With"))
					{
						if(sb.length()>0){
							sb.append(" and ");	
						}
						sb.append(functionStr);

						if(reservedKeyPlaceHolder!=null){
							sb.append("("+ reservedKeyPlaceHolder + "," + valuePlaceHolder1 + ")");
						}
						else{
							sb.append("("+ keyColumn + "," + valuePlaceHolder1 + ")");
						}
					}
					else{
						if(sb.length()>0){
							sb.append(" and ");	
						}
			
						if(reservedKeyPlaceHolder!=null){
							sb.append(reservedKeyPlaceHolder);
						}
						else{
							sb.append(keyColumn);
						}
						sb.append(" ");
						sb.append(functionStr);
						sb.append(" ");
						sb.append(valuePlaceHolder1);	
						sb.append(" ");
						
						if(functionStr.equalsIgnoreCase("Between"))
						{
							sb.append("AND");	
							sb.append(" ");
							sb.append(valuePlaceHolder2);	
							sb.append(" ");
						
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(valuePlaceHolder2);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(value2);
    stringBuffer.append(TEXT_95);
    
						}							
					}			
					
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(valuePlaceHolder1);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(value1);
    stringBuffer.append(TEXT_99);
    
					
				}
				
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(sb);
    stringBuffer.append(TEXT_102);
    
			}
			else{
				
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(advancedKeyConditionExpression);
    stringBuffer.append(TEXT_105);
    
			}
			
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
			if(useFilterExpression)
			{
				sb = new StringBuffer();
				
				if(!useAdvancedFilterExpression){	
			
				
					for(Map<String,String> subExpression : filterExpression)
					{
						String reservedKeyPlaceHolder = null;
						String valuePlaceHolder1 = null;
						String valuePlaceHolder2 = null;
						String columnName = subExpression.get("COLUMN_NAME");
						valuePlaceHolder1 = ":filter_" + columnName +"_1";
						valuePlaceHolder2 = ":filter_" + columnName +"_2";					
						
						for(Map<String,String> subNameMap : nameMap){
							String placeholder = subNameMap.get("PLACEHOLDER");
							String name = subNameMap.get("NAME");
							if(name.equals(columnName))
							{
								reservedKeyPlaceHolder = placeholder;							
								break;
							}
						}
	
						String functionStr = subExpression.get("FUNCTION");
						String value1 = subExpression.get("VALUE_1");
						String value2 = subExpression.get("VALUE_2");
						
						if(functionStr.equalsIgnoreCase("Begins_With"))
						{
							if(sb.length()>0){
								sb.append(" and ");	
							}
							sb.append(functionStr);
							
							if(reservedKeyPlaceHolder!=null){
								sb.append("("+ reservedKeyPlaceHolder + "," + valuePlaceHolder1 + ")");
							}
							else{
								sb.append("("+ columnName + "," + valuePlaceHolder1 + ")");
							}
						}
						else{
							if(sb.length()>0){
								sb.append(" and ");	
							}
							
							if(reservedKeyPlaceHolder!=null){
								sb.append(reservedKeyPlaceHolder);
							}
							else{
								sb.append(columnName);
							}
							sb.append(" ");
							sb.append(functionStr);
							sb.append(" ");
							sb.append(valuePlaceHolder1);	
							sb.append(" ");
							
							if(functionStr.equalsIgnoreCase("Between"))
							{
								sb.append("AND");	
								sb.append(" ");
								sb.append(valuePlaceHolder2);	
								sb.append(" ");
							
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(valuePlaceHolder2);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(value2);
    stringBuffer.append(TEXT_112);
    
							}							
						}	
						
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(valuePlaceHolder1);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(value1);
    stringBuffer.append(TEXT_116);
    
						
					}
					
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(sb);
    stringBuffer.append(TEXT_119);
    					
				}	
				else{
					
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(advancedFilterExpression);
    stringBuffer.append(TEXT_122);
    
				}
				
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    	
			}
			
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
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
    
		}
		else {
			
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
			if(useFilterExpression){
			
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    	
				for(Map<String,String> subNameMap : nameMap)
				{
					String placeholder = subNameMap.get("PLACEHOLDER");
					String name = subNameMap.get("NAME");
					
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(placeholder);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_149);
    
				}
				
				if(useAdvancedFilterExpression)
				{
				
					for(Map<String,String> subValueMap : valueMap)
					{
						String placeholder = subValueMap.get("PLACEHOLDER");
						String value = subValueMap.get("VALUE");
						
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(placeholder);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_153);
    
					}
				}
				
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
				
				StringBuffer sb = new StringBuffer();	
				if(!useAdvancedFilterExpression){	
				
					for(Map<String,String> subExpression : filterExpression)
					{
						String reservedKeyPlaceHolder = null;
						String valuePlaceHolder1 = null;
						String valuePlaceHolder2 = null;
						String columnName = subExpression.get("COLUMN_NAME");
						valuePlaceHolder1 = ":filter_" + columnName +"_1";
						valuePlaceHolder2 = ":filter_" + columnName +"_2";
						
						for(Map<String,String> subNameMap : nameMap){
							String placeholder = subNameMap.get("PLACEHOLDER");
							String name = subNameMap.get("NAME");
							if(name.equals(columnName))
							{
								reservedKeyPlaceHolder = placeholder;							
								break;
							}
						}
					
						String functionStr = subExpression.get("FUNCTION");
						String value1 = subExpression.get("VALUE_1");
						String value2 = subExpression.get("VALUE_2");			
								
						if(functionStr.equalsIgnoreCase("Begins_With"))
						{
							if(sb.length()>0){
								sb.append(" and ");	
							}
							sb.append(functionStr);

							if(reservedKeyPlaceHolder!=null){
								sb.append("("+ reservedKeyPlaceHolder + "," + valuePlaceHolder1 + ")");
							}
							else{
								sb.append("("+ columnName + "," + valuePlaceHolder1 + ")");
							}
						}
						else{
							if(sb.length()>0){
								sb.append(" and ");	
							}
							if(reservedKeyPlaceHolder!=null){
								sb.append(reservedKeyPlaceHolder);
							}
							else{
								sb.append(columnName);
							}
							sb.append(" ");
							sb.append(functionStr);
							sb.append(" ");
							sb.append(valuePlaceHolder1);	
							sb.append(" ");
							
							if(functionStr.equalsIgnoreCase("Between"))
							{
								sb.append("AND");	
								sb.append(" ");
								sb.append(valuePlaceHolder2);	
								sb.append(" ");
								
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(valuePlaceHolder2);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(value2);
    stringBuffer.append(TEXT_159);
    
							}	
							
							
						}
						
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(valuePlaceHolder1);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(value1);
    stringBuffer.append(TEXT_163);
    
						
					}
					
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(sb);
    stringBuffer.append(TEXT_166);
    
				}
				else{				
				
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(advancedFilterExpression);
    stringBuffer.append(TEXT_169);
    	
				}
				
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
			}
			
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
		}
		
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
      
          columnList = metadata.getListColumns();
          sizeColumns = columnList.size();

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
			if(firstConnName.length()>0){	

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columnList.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_203);
    
          			if(javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_204);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    
          			}else{

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
							if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_211);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_215);
    
							}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_216);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
							} else if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_220);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    
							} else if (javaType == JavaTypesManager.INTEGER){

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
							} else if (javaType == JavaTypesManager.LONG){

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    
							} else if (javaType == JavaTypesManager.SHORT){

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    
							} else {

    stringBuffer.append(TEXT_251);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
							}

    stringBuffer.append(TEXT_256);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_259);
    
					}
				}
			}

	}

} 

    stringBuffer.append(TEXT_260);
    stringBuffer.append(TEXT_261);
    return stringBuffer.toString();
  }
}
