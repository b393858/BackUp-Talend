package org.talend.designer.codegen.translators.elt.map.oracle;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.commons.utils.generation.CodeGenerationUtils;
import org.talend.core.model.metadata.MetadataToolHelper;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class TELTOracleOutputMainJava
{
  protected static String nl;
  public static synchronized TELTOracleOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTOracleOutputMainJava result = new TELTOracleOutputMainJava();
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
  protected final String TEXT_29 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_30 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_31 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_33 = " - Uses an existing connection ";
  protected final String TEXT_34 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_36 = " - Uses an existing connection. Connection URL: \" + conn_";
  protected final String TEXT_37 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_39 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_40 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_41 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\tconn_";
  protected final String TEXT_44 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_45 = ", dbUser_";
  protected final String TEXT_46 = ", dbPwd_";
  protected final String TEXT_47 = ");" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\tconn_";
  protected final String TEXT_49 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_50 = ");" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\tconn_";
  protected final String TEXT_52 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\tconn_";
  protected final String TEXT_54 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\tconn_";
  protected final String TEXT_56 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\tconn_";
  protected final String TEXT_58 = ".setAutoCommit(";
  protected final String TEXT_59 = ");" + NL + "\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\tlog.";
  protected final String TEXT_61 = "(\"";
  protected final String TEXT_62 = " - \" + ";
  protected final String TEXT_63 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t    \t\tlog.";
  protected final String TEXT_65 = "(\"";
  protected final String TEXT_66 = "\");" + NL + "\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_68 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_70 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_71 = ": pstmt_";
  protected final String TEXT_72 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_73 = " += (countEach_";
  protected final String TEXT_74 = " < 0 ? 0 : ";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_76 = NL;
  protected final String TEXT_77 = NL + "\tString select_query_";
  protected final String TEXT_78 = " = null;" + NL + "\tString tableName_";
  protected final String TEXT_79 = " = null;" + NL + "\t";
  protected final String TEXT_80 = NL + "\t\tselect_query_";
  protected final String TEXT_81 = " = (String) globalMap.get(\"";
  protected final String TEXT_82 = "\"+\"QUERY\"+\"";
  protected final String TEXT_83 = "\");" + NL + "" + NL + "\t\t";
  protected final String TEXT_84 = NL + "\tString dbschema_";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = ";" + NL + "\tif(dbschema_";
  protected final String TEXT_87 = " != null && dbschema_";
  protected final String TEXT_88 = ".trim().length() > 0) {" + NL + "\t\ttableName_";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = " + \".\" + ";
  protected final String TEXT_91 = ";" + NL + "\t}else {" + NL + "\t\ttableName_";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = ";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_94 = NL + NL;
  protected final String TEXT_95 = NL + "    java.sql.Connection conn_";
  protected final String TEXT_96 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_97 = "\");";
  protected final String TEXT_98 = NL + "    String driverClass_";
  protected final String TEXT_99 = " = \"oracle.jdbc.driver.OracleDriver\";" + NL + "    java.lang.Class.forName(driverClass_";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "        String url_";
  protected final String TEXT_102 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_103 = " + \":\" + ";
  protected final String TEXT_104 = " + \":\" + ";
  protected final String TEXT_105 = ";";
  protected final String TEXT_106 = NL + "        String url_";
  protected final String TEXT_107 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_108 = " + \")(port=\" + ";
  protected final String TEXT_109 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_110 = " + \")))\";";
  protected final String TEXT_111 = NL + "        String url_";
  protected final String TEXT_112 = " = ";
  protected final String TEXT_113 = ";";
  protected final String TEXT_114 = NL + "    String dbUser_";
  protected final String TEXT_115 = " = ";
  protected final String TEXT_116 = ";" + NL;
  protected final String TEXT_117 = NL;
  protected final String TEXT_118 = NL + "    ";
  protected final String TEXT_119 = "String decryptedPassword_";
  protected final String TEXT_120 = " = null;";
  protected final String TEXT_121 = " " + NL + "\tdecryptedPassword_";
  protected final String TEXT_122 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + "\tdecryptedPassword_";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = "; ";
  protected final String TEXT_127 = NL + NL + "    String dbPwd_";
  protected final String TEXT_128 = " = decryptedPassword_";
  protected final String TEXT_129 = ";" + NL;
  protected final String TEXT_130 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_131 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_132 = ",dbUser_";
  protected final String TEXT_133 = ",dbPwd_";
  protected final String TEXT_134 = ");";
  protected final String TEXT_135 = NL + "\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_136 = " = new java.util.Properties();" + NL + "\tatnParamsPrope_";
  protected final String TEXT_137 = ".put(\"user\",dbUser_";
  protected final String TEXT_138 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_139 = ".put(\"password\",dbPwd_";
  protected final String TEXT_140 = ");" + NL + "    if(";
  protected final String TEXT_141 = " != null && !\"\\\"\\\"\".equals(";
  protected final String TEXT_142 = ") && !\"\".equals(";
  protected final String TEXT_143 = ")){" + NL + "        atnParamsPrope_";
  protected final String TEXT_144 = ".load(new java.io.ByteArrayInputStream(";
  protected final String TEXT_145 = ".replace(\"&\", \"\\n\").getBytes()));" + NL + "    }" + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_146 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_147 = ", atnParamsPrope_";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = NL;
  protected final String TEXT_150 = NL;
  protected final String TEXT_151 = NL + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_152 = " =null;" + NL;
  protected final String TEXT_153 = NL + "\tString insertQuery_";
  protected final String TEXT_154 = " = \"INSERT INTO \"+tableName_";
  protected final String TEXT_155 = "+\"(";
  protected final String TEXT_156 = ") (\"+select_query_";
  protected final String TEXT_157 = "+\")\";";
  protected final String TEXT_158 = NL + "\t    StringBuffer insertStringBuffer_";
  protected final String TEXT_159 = " = new StringBuffer(insertQuery_";
  protected final String TEXT_160 = ");" + NL + "\t    insertStringBuffer_";
  protected final String TEXT_161 = ".insert(insertQuery_";
  protected final String TEXT_162 = ".indexOf(\"INSERT\")+ \"INSERT\".length() + 1 , ";
  protected final String TEXT_163 = " + \" \");" + NL + "\t    insertQuery_";
  protected final String TEXT_164 = " =insertStringBuffer_";
  protected final String TEXT_165 = ".toString();";
  protected final String TEXT_166 = NL + "\tpstmt_";
  protected final String TEXT_167 = " = conn_";
  protected final String TEXT_168 = ".prepareStatement(insertQuery_";
  protected final String TEXT_169 = ");" + NL;
  protected final String TEXT_170 = NL + "\tString updateQuery_";
  protected final String TEXT_171 = " = \"UPDATE \"+tableName_";
  protected final String TEXT_172 = "+\" SET (";
  protected final String TEXT_173 = ") = (\"+select_query_";
  protected final String TEXT_174 = "+\") \"";
  protected final String TEXT_175 = NL + "\t\t+\"  WHERE \" + ";
  protected final String TEXT_176 = NL + "\t;";
  protected final String TEXT_177 = NL + "\t    StringBuffer updateStringBuffer_";
  protected final String TEXT_178 = " = new StringBuffer(updateQuery_";
  protected final String TEXT_179 = ");" + NL + "\t    updateStringBuffer_";
  protected final String TEXT_180 = ".insert(updateQuery_";
  protected final String TEXT_181 = ".indexOf(\"UPDATE\")+ \"UPDATE\".length() +1 , ";
  protected final String TEXT_182 = "  + \" \");" + NL + "\t    updateQuery_";
  protected final String TEXT_183 = " =updateStringBuffer_";
  protected final String TEXT_184 = ".toString();";
  protected final String TEXT_185 = NL + "\tpstmt_";
  protected final String TEXT_186 = " = conn_";
  protected final String TEXT_187 = ".prepareStatement(updateQuery_";
  protected final String TEXT_188 = ");" + NL;
  protected final String TEXT_189 = NL + NL + "String deleteQuery_";
  protected final String TEXT_190 = " = \"DELETE  FROM \"+ tableName_";
  protected final String TEXT_191 = "+\" WHERE EXISTS (\"+select_query_";
  protected final String TEXT_192 = "+\") \"";
  protected final String TEXT_193 = NL + "+\"  AND \" + ";
  protected final String TEXT_194 = NL + ";";
  protected final String TEXT_195 = NL + "    StringBuffer deleteStringBuffer_";
  protected final String TEXT_196 = " = new StringBuffer(deleteQuery_";
  protected final String TEXT_197 = ");" + NL + "    deleteStringBuffer_";
  protected final String TEXT_198 = ".insert(deleteQuery_";
  protected final String TEXT_199 = ".indexOf(\"DELETE\")+ \"DELETE\".length()+1 , ";
  protected final String TEXT_200 = "  + \" \" );" + NL + "    deleteQuery_";
  protected final String TEXT_201 = " =deleteStringBuffer_";
  protected final String TEXT_202 = ".toString();";
  protected final String TEXT_203 = NL + "pstmt_";
  protected final String TEXT_204 = " = conn_";
  protected final String TEXT_205 = ".prepareStatement(deleteQuery_";
  protected final String TEXT_206 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_207 = NL + "\tString mergeQuery = \"MERGE INTO \"+ tableName_";
  protected final String TEXT_208 = " +\" target\"  + \" USING (\" + select_query_";
  protected final String TEXT_209 = " + \") source ON (\" +" + NL + "" + NL + "\t\t\"";
  protected final String TEXT_210 = "\" + \")\" ;" + NL + "" + NL + "\t\t";
  protected final String TEXT_211 = NL + "\t\t\tmergeQuery += \" WHEN MATCHED THEN UPDATE SET ";
  protected final String TEXT_212 = " \" ;" + NL + "\t\t\t";
  protected final String TEXT_213 = NL + "\t\t\t\tmergeQuery += \"WHERE \" + \"\";" + NL + "\t\t\t";
  protected final String TEXT_214 = NL + "\t\t\t\t\tmergeQuery += \"WHERE \" + ";
  protected final String TEXT_215 = ";" + NL + "\t\t\t";
  protected final String TEXT_216 = NL + "\t\t\t";
  protected final String TEXT_217 = NL + "\t\t\t\t\tmergeQuery += \" DELETE WHERE \" + \"\" ;" + NL + "\t\t\t";
  protected final String TEXT_218 = NL + "\t\t\t\t\tmergeQuery += \" DELETE WHERE \" + ";
  protected final String TEXT_219 = " ;" + NL + "\t\t  ";
  protected final String TEXT_220 = NL + "\t\t";
  protected final String TEXT_221 = NL + "\t\t";
  protected final String TEXT_222 = NL + "\t\t\t\tmergeQuery += \" WHEN NOT MATCHED THEN INSERT ( ";
  protected final String TEXT_223 = ") VALUES ( ";
  protected final String TEXT_224 = ") \";" + NL + "\t\t\t";
  protected final String TEXT_225 = NL + "\t\t\t\tmergeQuery += \" WHERE \" + \"\";" + NL + "\t\t\t";
  protected final String TEXT_226 = NL + "\t\t\t\tmergeQuery += \" WHERE \" + ";
  protected final String TEXT_227 = " ;" + NL + "\t\t\t";
  protected final String TEXT_228 = NL + " \t\t\tpstmt_";
  protected final String TEXT_229 = " = conn_";
  protected final String TEXT_230 = ".prepareStatement(mergeQuery);" + NL + "\t";
  protected final String TEXT_231 = NL + "int nb_line_";
  protected final String TEXT_232 = " = 0;" + NL + "int nb_line_updated_";
  protected final String TEXT_233 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_234 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_235 = " = 0;" + NL + "int nb_line_merged_";
  protected final String TEXT_236 = " = 0;" + NL + "\t";
  protected final String TEXT_237 = NL;
  protected final String TEXT_238 = "System.out.println(\"Inserting with : \\n\" + insertQuery_";
  protected final String TEXT_239 = " + \"\\n\");";
  protected final String TEXT_240 = NL + "nb_line_inserted_";
  protected final String TEXT_241 = " = pstmt_";
  protected final String TEXT_242 = ".executeUpdate();";
  protected final String TEXT_243 = "System.out.println(\"--> \" + nb_line_inserted_";
  protected final String TEXT_244 = " + \" rows inserted. \\n\");";
  protected final String TEXT_245 = NL + NL + "\t";
  protected final String TEXT_246 = "System.out.println(\"Updating with : \\n\" + updateQuery_";
  protected final String TEXT_247 = " +\"\\n\");";
  protected final String TEXT_248 = NL + "nb_line_updated_";
  protected final String TEXT_249 = " = pstmt_";
  protected final String TEXT_250 = ".executeUpdate();";
  protected final String TEXT_251 = NL + "\t";
  protected final String TEXT_252 = "System.out.println(\"--> \" + nb_line_updated_";
  protected final String TEXT_253 = " + \" rows updated. \\n\");";
  protected final String TEXT_254 = NL + "\t";
  protected final String TEXT_255 = NL + "\t";
  protected final String TEXT_256 = "System.out.println(\"Deleting with : \\n\" + deleteQuery_";
  protected final String TEXT_257 = " +\"\\n\");";
  protected final String TEXT_258 = NL + "\t\t";
  protected final String TEXT_259 = NL + "\t\tnb_line_deleted_";
  protected final String TEXT_260 = " = pstmt_";
  protected final String TEXT_261 = ".executeUpdate();" + NL + "\t\t";
  protected final String TEXT_262 = NL + "\t";
  protected final String TEXT_263 = "System.out.println(\"--> \" + nb_line_deleted_";
  protected final String TEXT_264 = " + \" rows deleted. \\n\");";
  protected final String TEXT_265 = NL + "\t\t";
  protected final String TEXT_266 = NL + "\t";
  protected final String TEXT_267 = "System.out.println(\"Merge with : \\n\" + mergeQuery +\"\\n\");";
  protected final String TEXT_268 = NL + "\t\t";
  protected final String TEXT_269 = NL + "\t    nb_line_merged_";
  protected final String TEXT_270 = " = pstmt_";
  protected final String TEXT_271 = ".executeUpdate();" + NL + "\t\t";
  protected final String TEXT_272 = NL + "\t";
  protected final String TEXT_273 = "System.out.println(\"--> \" + nb_line_merged_";
  protected final String TEXT_274 = " + \" rows merged. \\n\");";
  protected final String TEXT_275 = NL + "\t";
  protected final String TEXT_276 = NL + NL + "pstmt_";
  protected final String TEXT_277 = ".close();" + NL;
  protected final String TEXT_278 = NL + "    if(conn_";
  protected final String TEXT_279 = " != null && !conn_";
  protected final String TEXT_280 = ".isClosed()) {" + NL + "\t\t";
  protected final String TEXT_281 = NL + "    }";
  protected final String TEXT_282 = NL + "nb_line_";
  protected final String TEXT_283 = " = nb_line_updated_";
  protected final String TEXT_284 = " + nb_line_inserted_";
  protected final String TEXT_285 = " + nb_line_deleted_";
  protected final String TEXT_286 = " + nb_line_merged_";
  protected final String TEXT_287 = ";" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_288 = "_NB_LINE\",nb_line_";
  protected final String TEXT_289 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_290 = "_NB_LINE_UPDATED\",nb_line_updated_";
  protected final String TEXT_291 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_292 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_293 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_294 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_295 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_296 = "_NB_LINE_MERGED\",nb_line_merged_";
  protected final String TEXT_297 = ");" + NL;
  protected final String TEXT_298 = NL + "\tlog.info(\"";
  protected final String TEXT_299 = " - Has ";
  protected final String TEXT_300 = " records count: \" + nb_line_";
  protected final String TEXT_301 = "_";
  protected final String TEXT_302 = " + \".\");";
  protected final String TEXT_303 = NL;

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
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			useExistConnection(node, true);
		}

		public void useExistConnection(INode node, boolean needUserAndPassword){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_34);
    } else if (!needUserAndPassword){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    } else {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			if ("SSO".equals(ElementParameterParser.getValue(node, "__JDBC_URL__"))){
				connectWithSSO();
			} else {
				connect();
			}
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
			connect_end();
		}
		
		public void connectWithSSO(){
			connect_begin_noUser();
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_59);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_60);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_63);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_64);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_66);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_75);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_76);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();

	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();

	String dbtable = null;
	String dbschema = ElementParameterParser.getValue(node,"__ELT_SCHEMA_NAME__");
	String uniqueNameConnection = null;
	INode previousNode = null;

	String differenttable = ElementParameterParser.getValue(node, "__DIFFERENT_TABLE_NAME__");
	boolean useDifferentTable = "true".equals(ElementParameterParser.getValue(node, "__USE_DIFFERENT_TABLE__"));
	boolean isTableNameVariable="true".equals(ElementParameterParser.getValue(node, "__IS_TABLE_NAME_VARIABLE__"));

	
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
	List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
	if(connections != null && connections.size() > 0 && connections.get(0) != null) {
	    IConnection connection = connections.get(0);
	    previousNode = connection.getSource();
	    String previousComponentName = previousNode.getUniqueName();
		dbtable = connection.getName();
		uniqueNameConnection = connection.getUniqueName();

		
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_83);
    
	}
	 String tableName=null;
	 if(useDifferentTable){
		  tableName=differenttable;
	 }else{
	 	  if(isTableNameVariable){
	 	      tableName=dbtable;
	 	  }else{
	 	      tableName="\""+dbtable +"\"";
	 	  }
	 }
	
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_93);
    
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

        String dbhost = null;
        String dbport = null;
        String dbname = null;
        String dbuser = null;
	    String connectionType = null;
	    boolean useExistingConn = false;
	    String dbproperties = null;
        if(previousNode != null) {
	        dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
	        dbport = ElementParameterParser.getValue(previousNode, "__PORT__");
	        dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
	        dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
	    	connectionType = ElementParameterParser.getValue(previousNode, "__CONNECTION_TYPE__");
	    	useExistingConn = ("true").equals(ElementParameterParser.getValue(previousNode, "__USE_EXISTING_CONNECTION__"));
	    	dbproperties = ElementParameterParser.getValue(previousNode, "__PROPERTIES__");
        }

        String whereClause = ElementParameterParser.getValue(node, "__WHERE_CLAUSE__");


    stringBuffer.append(TEXT_94);
    
if(useExistingConn) {
    String connection = ElementParameterParser.getValue(previousNode, "__CONNECTION__");
    String conn = "conn_" + connection;
    
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_97);
    
	log4jCodeGenerateUtil.useExistConnection(node);
} else {
    
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
    if(connectionType == null || ("ORACLE_SID").equals(connectionType)) {
        
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_105);
    
    } else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {
        
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_110);
    
    } else if("ORACLE_RAC".equals(connectionType)) {
    	String rac_url = ElementParameterParser.getValue(previousNode, "__RAC_URL__");
        
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(rac_url);
    stringBuffer.append(TEXT_113);
    
    }
    
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_116);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_117);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    if (ElementParameterParser.canEncrypt(previousNode, passwordFieldName)) {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(previousNode, passwordFieldName));
    stringBuffer.append(TEXT_123);
    } else {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append( ElementParameterParser.getValue(previousNode, passwordFieldName));
    stringBuffer.append(TEXT_126);
    }
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
	log4jCodeGenerateUtil.debugConnectionParams(node);
	log4jCodeGenerateUtil.connect_begin();
	if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
	} else {

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
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_141);
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_142);
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
	}
	log4jCodeGenerateUtil.connect_end();

    stringBuffer.append(TEXT_149);
    
}

    stringBuffer.append(TEXT_150);
    
List<IMetadataColumn> columnList = null;

List<IMetadataTable> metadatas = node.getMetadataList();
IMetadataTable metadata = null;
if(metadatas !=null && metadatas.size()>0){
	metadata = metadatas.get(0);
	if(metadata != null){
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    

if(columnList != null && columnList.size()>0){

class Column{

	IMetadataColumn column;

	String name;

	String sqlStmt;

	String value;

	String validateName;

	boolean addCol;

	List<Column> replacement = new ArrayList<Column>();

	public Column(IMetadataColumn column){
		this.column = column;
		String columname = column.getOriginalDbColumnName();
		if(columname!=null && columname.trim().length()>0){
			this.name = columname;
		}else{
			this.name = column.getLabel();
		}
		this.sqlStmt = "=?";
		this.value = "?";
		this.addCol =false;
		this.validateName=MetadataToolHelper.validateValue(this.name);
		if(!this.name.equals(this.validateName)){
    		this.name = "\\\""+this.name+"\\\"";
    	}
	}

	public boolean isReplaced(){
		return replacement.size()>0;
	}

	public List<Column> getReplacement(){
		return this.replacement;
	}

	public IMetadataColumn getColumn(){
		return this.column;
	}

	public String getName(){
		return this.name;
	}

	public boolean isAddCol(){
		return this.addCol;
	}

	public String getSqlStmt(){
		return this.sqlStmt;
	}

	public String getValue(){
		return this.value;
	}

}

StringBuilder insertColName = new StringBuilder();

StringBuilder insertValueStmt = new StringBuilder();

StringBuilder updateSetStmt = new StringBuilder();

StringBuilder updateWhereStmt = new StringBuilder();

StringBuilder mergeCondition = new StringBuilder ();

List<Column> stmtStructure =  new LinkedList<Column>();

for(IMetadataColumn column:columnList){

	stmtStructure.add(new Column(column));

}


int counterOuter =0;
boolean firstKey = true;
boolean firstNoneKey = true;
boolean isfirstKey = true;
for(Column colStmt:stmtStructure){
	String colName=colStmt.getName();
	String suffix = ",";

	if (colStmt.getColumn().isKey()){
		if (isfirstKey) {
			isfirstKey = false;
		}else {
			mergeCondition.append(" AND ");
		}
		mergeCondition.append("target." + colName + "=source." + colName);
	}
	if(colStmt.isReplaced()){
		List<Column> replacedColumns = colStmt.getReplacement();
		int counterReplace = 0;
		if(counterOuter==(stmtStructure.size()-1) && counterReplace==(replacedColumns.size()-1) ){
			suffix = "";
		}
		for(Column replacement:replacedColumns){
			insertColName.append(replacement.getName()+suffix);
			insertValueStmt.append(replacement.getSqlStmt()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append(replacement.getName());
				updateSetStmt.append(replacement.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append(replacement.getName());
				updateWhereStmt.append(replacement.getSqlStmt());
			}
			counterReplace++;
		}
	}else{
		if(counterOuter==(stmtStructure.size()-1)){
			suffix = "";
		}
		if(colStmt.isAddCol()){
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getSqlStmt()+suffix);
			updateSetStmt.append(colStmt.getName());
			updateSetStmt.append(colStmt.getSqlStmt()+suffix);
		}else{
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getValue()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append(colStmt.getName());
				updateSetStmt.append(colStmt.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append(colStmt.getName());
				updateWhereStmt.append(colStmt.getSqlStmt());
			}
		}
	}
	counterOuter ++;
}

///// hint options/////
boolean useHintOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_HINT_OPTIONS__"));
Map<String, String> hintsValues = null;
if (useHintOptions) {
	List<Map<String, String>> hintOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HINT_OPTIONS__");
	hintsValues = new HashMap<String, String>();
	String hintValue = null;
	boolean firstInsert = true;
	boolean firstUpdate = true;
	boolean firstDelete = true;
	boolean firstTableName = true;
	for(java.util.Map<String, String> option : hintOptions) {
		//get
		if(option.get("HINT").matches("\"/\\*NORMALIZED_HINT\\*/\"")) {
			String id = cid.replace(node.getComponent().getName() + "_", "");
			hintValue = "\"/*\"+" + dbtable + "+\".\" + "  + "\"" + option.get("SQL_STMT")+ ".\"" + "+" +  id   +  "+\"*/\" " ;
		}else if (option.get("HINT").matches("\"/\\*+.*\\*/\"")) {
			hintValue = option.get("HINT");
		}
		//set
		if ("INSERT".equalsIgnoreCase(option.get("SQL_STMT"))){
			if(firstInsert){
				hintsValues.put("INSERT", hintValue) ;
				firstInsert = false;
			}else {
				hintsValues.put("INSERT", hintsValues.get("INSERT") + "+" + hintValue) ;
			}
		}else if ("UPDATE".equalsIgnoreCase(option.get("SQL_STMT"))) {
			if(firstUpdate){
				hintsValues.put("UPDATE", hintValue) ;
				firstUpdate = false;
			}else {
				hintsValues.put("UPDATE", hintsValues.get("UPDATE") + "+" + hintValue) ;
			}
		}else if ("DELETE".equalsIgnoreCase(option.get("SQL_STMT"))) {
			if (firstDelete){
				hintsValues.put("DELETE", hintValue) ;
				firstDelete =false;
			}else {
				hintsValues.put("DELETE", hintsValues.get("DELETE") + "+" + hintValue) ;
			}
		}else if ("TABLE_NAME".equalsIgnoreCase(option.get("SQL_STMT"))){
			if (firstTableName){
				hintsValues.put("TABLE_NAME", hintValue) ;
				firstTableName = false;
			}else {
				hintsValues.put("TABLE_NAME", hintsValues.get("TABLE_NAME") + "+" + hintValue) ;
			}
		}
	}
}
//// hint options end ////

	if(("INSERT").equals(dataAction)){

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    
		if (useHintOptions && hintsValues.get("INSERT") != null){

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(hintsValues.get("INSERT"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
		}

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    
	}else if (("UPDATE").equals(dataAction)){

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    
		if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    
		}

    stringBuffer.append(TEXT_176);
    		if (useHintOptions && hintsValues.get("UPDATE") != null){

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(hintsValues.get("UPDATE"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
		}

    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    
	}else if (("DELETE").equals(dataAction)){
	
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {
    stringBuffer.append(TEXT_193);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    }
    stringBuffer.append(TEXT_194);
    
	if(useHintOptions && hintsValues.get("DELETE") != null) {

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(hintsValues.get("DELETE"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
  }
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    
	}else if ("MERGE".equals(dataAction)) {
	// get parameter
	boolean useMergeUpdate = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_MERGE_UPDATE__"));
	boolean useMergeInsert = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_MERGE_INSERT__"));

	boolean useUpdateWhere =  "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_MERGE_UPDATE_WHERE__"));
	boolean useUpdateDeleteWhere = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_MERGE_UPDATE_DELETE_WHERE__"));
	boolean useInsertWhere = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_MERGE_INSERT_WHERE__"));



	List<Map<String, String>> updateColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMA_UPDATE__");
	List<Map<String, String>> insertColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMA_INSERT__");

	StringBuilder mergeUpdate = new StringBuilder() ;
	StringBuilder mergeInsertName = new StringBuilder() ;
	StringBuilder mergeInsertValue = new StringBuilder() ;
	
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(mergeCondition);
    stringBuffer.append(TEXT_210);
    
		if(!useMergeUpdate)
			useUpdateWhere =false;
		if (useMergeUpdate) {
		boolean isfirstUpdateSet = true;
		String keyColumnName=null;
			for(Map<String, String> keyColumn:updateColumns){
				if (keyColumn.get("UPDATE").equals("true")) {
					if (isfirstUpdateSet) {
					  	isfirstUpdateSet = false;
					}else {
						mergeUpdate.append(",");
					}
					keyColumnName=keyColumn.get("SCHEMA_COLUMN");
					keyColumnName=new Column(metadata.getColumn(keyColumnName)).getName();
					mergeUpdate.append("target."  + keyColumnName + "=source." + keyColumnName);
				}
			}
		
    stringBuffer.append(TEXT_211);
    stringBuffer.append(mergeUpdate);
    stringBuffer.append(TEXT_212);
    if (useUpdateWhere) {
				String useUpdateWhereString = ElementParameterParser.getValue(node,"__MERGE_UPDATE_WHERE_STRING__");
				if(useUpdateWhereString == null || useUpdateWhereString.length() == 0){

			
    stringBuffer.append(TEXT_213);
    
				}
				else {
    stringBuffer.append(TEXT_214);
    stringBuffer.append(useUpdateWhereString );
    stringBuffer.append(TEXT_215);
    	}
			}
    stringBuffer.append(TEXT_216);
    if (useUpdateDeleteWhere) {
				String useUpdateDeleteWhereString = ElementParameterParser.getValue(node,"__MERGE_UPDATE_DELETE_WHERE_STRING__");
				if(useUpdateDeleteWhereString == null || useUpdateDeleteWhereString.length() == 0){
			
    stringBuffer.append(TEXT_217);
    
				}
				else {
    stringBuffer.append(TEXT_218);
    stringBuffer.append(useUpdateDeleteWhereString);
    stringBuffer.append(TEXT_219);
    	}
			}
    stringBuffer.append(TEXT_220);
    
		}
    stringBuffer.append(TEXT_221);
    
		if(!useMergeInsert)
			useInsertWhere = false;
		if (useMergeInsert) {
		    boolean isfirstInsertWhere = true;
		    String keyColumnName=null;
			for(Map<String, String> keyColumn:insertColumns){
				if (keyColumn.get("INSERT").equals("true")) {
					if (isfirstInsertWhere) {
	 			 		isfirstInsertWhere = false;
					}else {
						mergeInsertName.append(",");
						mergeInsertValue.append(",");
					}
					keyColumnName=keyColumn.get("SCHEMA_COLUMN");
					keyColumnName = new Column(metadata.getColumn(keyColumnName)).getName();
					mergeInsertName.append(keyColumnName);
					mergeInsertValue.append("source." + keyColumnName);
				}
			}
			
    stringBuffer.append(TEXT_222);
    stringBuffer.append(mergeInsertName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(mergeInsertValue);
    stringBuffer.append(TEXT_224);
    
			}
			if (useInsertWhere) {
			String useInsertWhereString = ElementParameterParser.getValue(node,"__MERGE_INSERT_WHERE_STRING__");
			if(useInsertWhereString == null || useInsertWhereString.length() == 0){
			
    stringBuffer.append(TEXT_225);
    
			} else {
    stringBuffer.append(TEXT_226);
    stringBuffer.append(useInsertWhereString);
    stringBuffer.append(TEXT_227);
    }
			}
			
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
	}
	
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    

}

if(dbtable != null && columnList != null){
	if(("INSERT").equals(dataAction)){
	
    stringBuffer.append(TEXT_237);
    if(!isLog4jEnabled){
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    }
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+insertQuery_"+ cid +"+\"");
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    if(!isLog4jEnabled){
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    }
    stringBuffer.append(TEXT_245);
    
	}else if(("UPDATE").equals(dataAction)){

	
    if(!isLog4jEnabled){
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    }
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+updateQuery_"+ cid +"+\"");
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_251);
    if(!isLog4jEnabled){
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    }
    stringBuffer.append(TEXT_254);
    
	}else if (("DELETE").equals(dataAction)){
		
    stringBuffer.append(TEXT_255);
    if(!isLog4jEnabled){
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    }
    stringBuffer.append(TEXT_258);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+deleteQuery_"+ cid +"+\"");
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_262);
    if(!isLog4jEnabled){
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    }
    stringBuffer.append(TEXT_265);
    
	}else if (("MERGE").equals(dataAction)){
	
    stringBuffer.append(TEXT_266);
    if(!isLog4jEnabled){
    stringBuffer.append(TEXT_267);
    }
    stringBuffer.append(TEXT_268);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+mergeQuery+\"");
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_272);
    if(!isLog4jEnabled){
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    }
    stringBuffer.append(TEXT_275);
    
	}
}
// END


    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    
if(!useExistingConn) {
    
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    log4jCodeGenerateUtil.close(node);
    stringBuffer.append(TEXT_281);
    
}

    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    
if(isLog4jEnabled){
	Map<String,String> actionMap=new java.util.HashMap<String,String>();
	actionMap.put("INSERT","inserted");
	actionMap.put("UPDATE","updated");
	actionMap.put("DELETE","deleted");
	actionMap.put("MERGE","merged");
	
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(actionMap.get(dataAction));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(actionMap.get(dataAction));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    
}

    stringBuffer.append(TEXT_303);
    return stringBuffer.toString();
  }
}
