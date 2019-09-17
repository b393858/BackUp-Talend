package org.talend.designer.codegen.translators.databasesnosql.neo4j;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.utils.NodeUtil;

public class TNeo4jInputMainJava
{
  protected static String nl;
  public static synchronized TNeo4jInputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jInputMainJava result = new TNeo4jInputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "     org.neo4j.driver.v1.Record row_";
  protected final String TEXT_2 = " = resultIterator_";
  protected final String TEXT_3 = ".next();" + NL + "     org.neo4j.driver.v1.Value value_";
  protected final String TEXT_4 = " = null;";
  protected final String TEXT_5 = NL + "\t\texpression_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";" + NL + "\t\tvalue_";
  protected final String TEXT_8 = " = neo4jUtil_";
  protected final String TEXT_9 = ".getPropertyValue(expression_";
  protected final String TEXT_10 = ",row_";
  protected final String TEXT_11 = ");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t\tvalue_";
  protected final String TEXT_13 = " = row_";
  protected final String TEXT_14 = ".get(0);" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\t\tif (value_";
  protected final String TEXT_16 = ".isNull()) {" + NL + "\t\t\t\t";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ";" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_21 = ".type().name().equals(\"LONG\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = " = new java.util.Date(value_";
  protected final String TEXT_24 = ".asLong());" + NL + "\t\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\t\t} else if (value_";
  protected final String TEXT_26 = ".type().name().equals(\"STRING\")) {" + NL + "\t\t\t\t\t\t\tjava.text.SimpleDateFormat formater_";
  protected final String TEXT_27 = " = new SimpleDateFormat(";
  protected final String TEXT_28 = ");" + NL + "\t\t\t\t\t\t\ttry {" + NL + "            \t\t\t\t\t";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = " = formater_";
  protected final String TEXT_31 = ".parse(value_";
  protected final String TEXT_32 = ".asString());" + NL + "        \t\t\t\t\t} catch (ParseException e_";
  protected final String TEXT_33 = ") {" + NL + "            \t\t\t\t\tthrow new RuntimeException(\"Unable to parse date\");" + NL + "        \t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tthrow new RuntimeException(\"Unable to parse date, review your configuration\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_36 = ".type().name().equals(\"LIST\")) {\t\t\t\t" + NL + "\t\t\t\t\t\tjava.util.Collection<?> collection = value_";
  protected final String TEXT_37 = ".asList();\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = " = new java.util.ArrayList(collection);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The returned parameter is not a Collection\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_41 = ".type().name().equals(\"STRING\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = " =  value_";
  protected final String TEXT_44 = ".asString();" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " = value_";
  protected final String TEXT_47 = ".toString();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_49 = ".type().name().equals(\"LONG\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = " =  value_";
  protected final String TEXT_52 = ".asLong();" + NL + "\t\t\t\t\t} else if (value_";
  protected final String TEXT_53 = ".type().name().equals(\"DOUBLE\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = " = (Long) Math.round( value_";
  protected final String TEXT_56 = ".asDouble());" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = " = new Long(value_";
  protected final String TEXT_59 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_61 = ".type().name().equals(\"INTEGER\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = " =  value_";
  protected final String TEXT_64 = ".asInt();" + NL + "\t\t\t\t\t} else if (value_";
  protected final String TEXT_65 = ".type().name().equals(\"DOUBLE\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = " = (int) Math.round(value_";
  protected final String TEXT_68 = ".asDouble());" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = " = new Integer(value_";
  protected final String TEXT_71 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_73 = ".type().name().equals(\"FLOAT\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = " = value_";
  protected final String TEXT_76 = ".asFloat();" + NL + "\t\t\t\t\t} else if (value_";
  protected final String TEXT_77 = ".type().name().equals(\"DOUBLE\")) {" + NL + "\t\t\t\t\t \t";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = " = (value_";
  protected final String TEXT_80 = ".asDouble()).floatValue();" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = " = new Float(value_";
  protected final String TEXT_83 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_85 = ".type().name().equals(\"BOOLEAN\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = " = value_";
  protected final String TEXT_88 = ".asBoolean();" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = " = new Boolean(value_";
  protected final String TEXT_91 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_93 = ".type().name().equals(\"DOUBLE\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = " = value_";
  protected final String TEXT_96 = ".asDouble();" + NL + "\t\t\t\t\t} else if (value_";
  protected final String TEXT_97 = ".type().name().equals(\"FLOAT\")) {" + NL + "\t\t\t\t\t \t";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = " = (value_";
  protected final String TEXT_100 = ".asFloat()).doubleValue();" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = " = new Double(value_";
  protected final String TEXT_103 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_105 = ".type().name().equals(\"BYTEARRAY\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = " =  value_";
  protected final String TEXT_108 = ".asByteArray();" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = value_";
  protected final String TEXT_111 = ".toString().getBytes();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t\t\t";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = " = value_";
  protected final String TEXT_115 = ".asObject();" + NL + "\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_117 = ".asObject() instanceof ";
  protected final String TEXT_118 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = " = (";
  protected final String TEXT_121 = ") value_";
  protected final String TEXT_122 = ".asObject();" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = "=ParserUtils.parseTo_";
  protected final String TEXT_125 = "(value_";
  protected final String TEXT_126 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_128 = NL + "\tjava.util.Map<String, Object> row_";
  protected final String TEXT_129 = " = resultIterator_";
  protected final String TEXT_130 = ".next();" + NL + "\tObject value_";
  protected final String TEXT_131 = " = null;";
  protected final String TEXT_132 = NL + "\t\texpression_";
  protected final String TEXT_133 = " = ";
  protected final String TEXT_134 = "!=null?";
  protected final String TEXT_135 = ":\"\";" + NL + "\t\tvalue_";
  protected final String TEXT_136 = " = row_";
  protected final String TEXT_137 = ".get(expression_";
  protected final String TEXT_138 = ");" + NL + "\t\tif (value_";
  protected final String TEXT_139 = " == null) {" + NL + "\t\t\tvalue_";
  protected final String TEXT_140 = " = neo4jUtil_";
  protected final String TEXT_141 = ".getPropertyValue(expression_";
  protected final String TEXT_142 = ",row_";
  protected final String TEXT_143 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_144 = NL + "\t\t\tif (value_";
  protected final String TEXT_145 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = " = ";
  protected final String TEXT_148 = ";" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_150 = " instanceof Number) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = " = new java.util.Date(((Number) value_";
  protected final String TEXT_153 = ").longValue());" + NL + "\t\t\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\t} else if (value_";
  protected final String TEXT_155 = " instanceof String) {" + NL + "\t\t\t\t\t\t\tjava.text.SimpleDateFormat formater_";
  protected final String TEXT_156 = " = new SimpleDateFormat(";
  protected final String TEXT_157 = ");" + NL + "\t\t\t\t\t\t\ttry {" + NL + "            \t\t\t\t\t";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = " = formater_";
  protected final String TEXT_160 = ".parse((String)value_";
  protected final String TEXT_161 = ");" + NL + "        \t\t\t\t\t} catch (ParseException e_";
  protected final String TEXT_162 = ") {" + NL + "            \t\t\t\t\tthrow new RuntimeException(\"Unable to parse date\");" + NL + "        \t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tthrow new RuntimeException(\"Unable to parse date, review your configuration\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_165 = " instanceof java.util.Collection<?>) {\t\t\t\t" + NL + "\t\t\t\t\t\tjava.util.Collection<?> collection = (java.util.Collection<?>) value_";
  protected final String TEXT_166 = ";\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_167 = ".";
  protected final String TEXT_168 = " = new java.util.ArrayList(collection);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The returned parameter is not a Collection\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_170 = " instanceof String) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_171 = ".";
  protected final String TEXT_172 = " = (String) value_";
  protected final String TEXT_173 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = " = value_";
  protected final String TEXT_176 = ".toString();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_178 = " instanceof Long) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_179 = ".";
  protected final String TEXT_180 = " = (Long) value_";
  protected final String TEXT_181 = ";" + NL + "\t\t\t\t\t} else if (value_";
  protected final String TEXT_182 = " instanceof Double) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_183 = ".";
  protected final String TEXT_184 = " = (Long) Math.round((Double) value_";
  protected final String TEXT_185 = ");" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_186 = ".";
  protected final String TEXT_187 = " = new Long(value_";
  protected final String TEXT_188 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_189 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_190 = " instanceof Integer) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " = (Integer) value_";
  protected final String TEXT_193 = ";" + NL + "\t\t\t\t\t} else if (value_";
  protected final String TEXT_194 = " instanceof Double) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_195 = ".";
  protected final String TEXT_196 = " = (int) Math.round((Double) value_";
  protected final String TEXT_197 = ");" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = " = new Integer(value_";
  protected final String TEXT_200 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_202 = " instanceof Float) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_203 = ".";
  protected final String TEXT_204 = " = (Float) value_";
  protected final String TEXT_205 = ";" + NL + "\t\t\t\t\t} else if (value_";
  protected final String TEXT_206 = " instanceof Double) {" + NL + "\t\t\t\t\t \t";
  protected final String TEXT_207 = ".";
  protected final String TEXT_208 = " = ((Double) value_";
  protected final String TEXT_209 = ").floatValue();" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = " = new Float(value_";
  protected final String TEXT_212 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_213 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_214 = " instanceof Boolean) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_215 = ".";
  protected final String TEXT_216 = " = (Boolean) value_";
  protected final String TEXT_217 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_218 = ".";
  protected final String TEXT_219 = " = new Boolean(value_";
  protected final String TEXT_220 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_222 = " instanceof Double) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_223 = ".";
  protected final String TEXT_224 = " = (Double) value_";
  protected final String TEXT_225 = ";" + NL + "\t\t\t\t\t} else if (value_";
  protected final String TEXT_226 = " instanceof Float) {" + NL + "\t\t\t\t\t \t";
  protected final String TEXT_227 = ".";
  protected final String TEXT_228 = " = ((Float) value_";
  protected final String TEXT_229 = ").doubleValue();" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_230 = ".";
  protected final String TEXT_231 = " = new Double(value_";
  protected final String TEXT_232 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_233 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_234 = " instanceof byte[]) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = " = (byte[]) value_";
  protected final String TEXT_237 = ";" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = "=(new sun.misc.BASE64Decoder()).decodeBuffer(value_";
  protected final String TEXT_240 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\t\t";
  protected final String TEXT_242 = ".";
  protected final String TEXT_243 = " = value_";
  protected final String TEXT_244 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_245 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_246 = " instanceof ";
  protected final String TEXT_247 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_248 = ".";
  protected final String TEXT_249 = " = (";
  protected final String TEXT_250 = ") value_";
  protected final String TEXT_251 = ";" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = "=ParserUtils.parseTo_";
  protected final String TEXT_254 = "(value_";
  protected final String TEXT_255 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_256 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_257 = NL + "nb_line_";
  protected final String TEXT_258 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    List<Map<String, String>> mapping = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__MAPPING__");
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    String dbVersion = ElementParameterParser.getValue(node,"__DB_VERSION__");
	if(useExistingConnection){
	    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
        dbVersion = ElementParameterParser.getValue(connectionNode, "__DB_VERSION__");
    }
    
    // Retrieve internal schema
    List<IMetadataColumn> columns = null;
    List<IMetadataTable> metadatas = node.getMetadataList();    
   	Map<String, IMetadataColumn> columnsMapped = new HashMap<String, IMetadataColumn>();
    if (metadatas != null && metadatas.size() > 0) {
    	IMetadataTable metadata = metadatas.get(0);
    	if (metadata != null){
    		columns = metadata.getListColumns();
    	}
    	for (Map<String, String> rowMapping : mapping) {
	    	String returnParameter = rowMapping.get("RETURN_PARAMETER");
	    	IMetadataColumn column = metadata.getColumn(rowMapping.get("SCHEMA_COLUMN"));
	    	columnsMapped.put(returnParameter, column);
    	}
    }
    
    // Retrieve input and output Talend connections
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
    
     if ("NEO4J_3_2_X".equals(dbVersion)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
     for (Map.Entry<String, IMetadataColumn> columnMapped : columnsMapped.entrySet()) {
		String returnParameter = columnMapped.getKey();	
		IMetadataColumn column = columnMapped.getValue();	
		if(returnParameter!=null&&!"".equals(returnParameter)){
		
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(returnParameter);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		}else{
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
		}
		String cType = column.getTalendType();
		String typeToGenerate = JavaTypesManager.getTypeToGenerate(cType, column.isNullable());
		if (outgoingConnName != null) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_19);
    
				if (cType.equals("id_Date")) {
					
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
					if (column.getPattern() != null && !column.getPattern().isEmpty()) {
						
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
					} else {
						
    stringBuffer.append(TEXT_34);
    
					}
				} else if (cType.equals("id_List")) {
					
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_39);
    
				} else if (cType.equals("id_String")) {
					
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
				} else if (cType.equals("id_Long")) {
					
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
				} else if (cType.equals("id_Integer")) {
					
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
				} else if (cType.equals("id_Float")) {
					
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
				} else if (cType.equals("id_Boolean")) {
					
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
				} else if (cType.equals("id_Double")) {
					
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
				} else if (cType.equals("id_byte[]")) {
					
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
				} else if (cType.equals("id_Object")) {
					
    stringBuffer.append(TEXT_112);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
				} else{
					
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(cType,true));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(cType,true));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
				}
			
    stringBuffer.append(TEXT_127);
    
		}
	}
 } else { 
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
	for (Map.Entry<String, IMetadataColumn> columnMapped : columnsMapped.entrySet()) {
		String returnParameter = columnMapped.getKey();	
		IMetadataColumn column = columnMapped.getValue();	
		
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(returnParameter);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(returnParameter);
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
    
		String cType = column.getTalendType();
		String typeToGenerate = JavaTypesManager.getTypeToGenerate(cType, column.isNullable());
		if (outgoingConnName != null) {
			
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_148);
    
				if (cType.equals("id_Date")) {
					
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
					if (column.getPattern() != null && !column.getPattern().isEmpty()) {
						
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
					} else {
						
    stringBuffer.append(TEXT_163);
    
					}
				} else if (cType.equals("id_List")) {
					
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_168);
    
				} else if (cType.equals("id_String")) {
					
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
				} else if (cType.equals("id_Long")) {
					
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
				} else if (cType.equals("id_Integer")) {
					
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    
				} else if (cType.equals("id_Float")) {
					
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    
				} else if (cType.equals("id_Boolean")) {
					
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
				} else if (cType.equals("id_Double")) {
					
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
				} else if (cType.equals("id_byte[]")) {
					
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    
				} else if (cType.equals("id_Object")) {
					
    stringBuffer.append(TEXT_241);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    
				} else{
					
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(cType,true));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(cType,true));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
				}
			
    stringBuffer.append(TEXT_256);
    
		}
	}
}

    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    return stringBuffer.toString();
  }
}
