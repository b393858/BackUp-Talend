package org.talend.designer.codegen.translators.databases;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.MappingTypeRetriever;
import java.util.List;
import java.util.ArrayList;

public class TCreateTableMainJava
{
  protected static String nl;
  public static synchronized TCreateTableMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCreateTableMainJava result = new TCreateTableMainJava();
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
  protected final String TEXT_76 = NL + "    try{";
  protected final String TEXT_77 = NL + "            ";
  protected final String TEXT_78 = NL + "        ";
  protected final String TEXT_79 = NL + "            java.sql.Statement stmt_";
  protected final String TEXT_80 = " = conn_";
  protected final String TEXT_81 = ".createStatement();";
  protected final String TEXT_82 = NL + "                log.info(\"";
  protected final String TEXT_83 = " - Creating table '\" + tableName_";
  protected final String TEXT_84 = " + \"'.\");";
  protected final String TEXT_85 = NL + "            stmt_";
  protected final String TEXT_86 = ".execute(\"";
  protected final String TEXT_87 = "\");";
  protected final String TEXT_88 = NL + "                log.info(\"";
  protected final String TEXT_89 = " - Create table '\" + tableName_";
  protected final String TEXT_90 = " + \"' has succeeded.\");";
  protected final String TEXT_91 = NL + "            ";
  protected final String TEXT_92 = NL + "            boolean whetherExist_";
  protected final String TEXT_93 = " = false;";
  protected final String TEXT_94 = NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t            java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_96 = " = conn_";
  protected final String TEXT_97 = ".getMetaData();" + NL + "\t            if(tableNameForSearch_";
  protected final String TEXT_98 = ".indexOf(\"\\\"\")==-1){" + NL + "            \t\ttableNameForSearch_";
  protected final String TEXT_99 = " = tableNameForSearch_";
  protected final String TEXT_100 = ".toUpperCase();" + NL + "            \t}else{" + NL + "            \t\ttableNameForSearch_";
  protected final String TEXT_101 = " = tableNameForSearch_";
  protected final String TEXT_102 = ".replaceAll(\"\\\"\",\"\");" + NL + "            \t}" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_103 = " = dbMetaData_";
  protected final String TEXT_104 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_105 = ", tableNameForSearch_";
  protected final String TEXT_106 = ", new String[]{\"TABLE\"});" + NL + "\t            if(rsTable_";
  protected final String TEXT_107 = ".next()) {" + NL + "\t            \twhetherExist_";
  protected final String TEXT_108 = " = true;" + NL + "\t            }     ";
  protected final String TEXT_109 = NL + "                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_110 = " = conn_";
  protected final String TEXT_111 = ".getMetaData();" + NL + "                java.sql.ResultSet rsTable_";
  protected final String TEXT_112 = " = dbMetaData_";
  protected final String TEXT_113 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                while(rsTable_";
  protected final String TEXT_114 = ".next()) {" + NL + "                    String table_";
  protected final String TEXT_115 = " = rsTable_";
  protected final String TEXT_116 = ".getString(\"TABLE_NAME\");" + NL + "                    String schema_";
  protected final String TEXT_117 = " = rsTable_";
  protected final String TEXT_118 = ".getString(\"TABLE_SCHEM\");" + NL + "                    if(table_";
  protected final String TEXT_119 = ".equals";
  protected final String TEXT_120 = "IgnoreCase";
  protected final String TEXT_121 = "(";
  protected final String TEXT_122 = ") " + NL + "                        && (schema_";
  protected final String TEXT_123 = ".equals";
  protected final String TEXT_124 = "IgnoreCase";
  protected final String TEXT_125 = "(dbSchema_";
  protected final String TEXT_126 = ") || (dbSchema_";
  protected final String TEXT_127 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_128 = ".equalsIgnoreCase(schema_";
  protected final String TEXT_129 = ")))) {" + NL + "                        whetherExist_";
  protected final String TEXT_130 = " = true;" + NL + "                        break;" + NL + "                    }" + NL + "                }";
  protected final String TEXT_131 = NL + "                    java.sql.PreparedStatement tempTablePs_";
  protected final String TEXT_132 = " = conn_";
  protected final String TEXT_133 = ".prepareStatement(\"SELECT * FROM information_schema.tables WHERE table_type='LOCAL TEMPORARY' AND table_name = ?\");" + NL + "                    tempTablePs_";
  protected final String TEXT_134 = ".setString(1, ";
  protected final String TEXT_135 = ");" + NL + "                    java.sql.ResultSet rsTable_";
  protected final String TEXT_136 = " = tempTablePs_";
  protected final String TEXT_137 = ".executeQuery();" + NL + "                    whetherExist_";
  protected final String TEXT_138 = " = rsTable_";
  protected final String TEXT_139 = ".next();";
  protected final String TEXT_140 = NL + "                    java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_141 = " = conn_";
  protected final String TEXT_142 = ".getMetaData();" + NL + "                    java.sql.ResultSet rsTable_";
  protected final String TEXT_143 = " = dbMetaData_";
  protected final String TEXT_144 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                    String defaultSchema_";
  protected final String TEXT_145 = " = \"public\";" + NL + "                    if(dbSchema_";
  protected final String TEXT_146 = " == null || dbSchema_";
  protected final String TEXT_147 = ".trim().length() == 0) {" + NL + "                        java.sql.Statement stmtSchema_";
  protected final String TEXT_148 = " = conn_";
  protected final String TEXT_149 = ".createStatement();" + NL + "                        java.sql.ResultSet rsSchema_";
  protected final String TEXT_150 = " = stmtSchema_";
  protected final String TEXT_151 = ".executeQuery(\"select current_schema() \");" + NL + "                        while(rsSchema_";
  protected final String TEXT_152 = ".next()){" + NL + "                            defaultSchema_";
  protected final String TEXT_153 = " = rsSchema_";
  protected final String TEXT_154 = ".getString(\"current_schema\");" + NL + "                        }" + NL + "                        rsSchema_";
  protected final String TEXT_155 = ".close();" + NL + "                        stmtSchema_";
  protected final String TEXT_156 = ".close();" + NL + "                    }" + NL + "                    while(rsTable_";
  protected final String TEXT_157 = ".next()) {" + NL + "                        String table_";
  protected final String TEXT_158 = " = rsTable_";
  protected final String TEXT_159 = ".getString(\"TABLE_NAME\");" + NL + "                        String schema_";
  protected final String TEXT_160 = " = rsTable_";
  protected final String TEXT_161 = ".getString(\"TABLE_SCHEM\");" + NL + "                        if(table_";
  protected final String TEXT_162 = ".equals";
  protected final String TEXT_163 = "IgnoreCase";
  protected final String TEXT_164 = "(";
  protected final String TEXT_165 = ") " + NL + "                            && (schema_";
  protected final String TEXT_166 = ".equals";
  protected final String TEXT_167 = "IgnoreCase";
  protected final String TEXT_168 = "(dbSchema_";
  protected final String TEXT_169 = ") || ((dbSchema_";
  protected final String TEXT_170 = " ==null || dbSchema_";
  protected final String TEXT_171 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_172 = ".equals";
  protected final String TEXT_173 = "IgnoreCase";
  protected final String TEXT_174 = "(schema_";
  protected final String TEXT_175 = ")))) {" + NL + "                            whetherExist_";
  protected final String TEXT_176 = " = true;" + NL + "                            break;" + NL + "                        }" + NL + "                    }";
  protected final String TEXT_177 = NL + "                java.sql.Statement rsTable_";
  protected final String TEXT_178 = " = conn_";
  protected final String TEXT_179 = ".createStatement();" + NL + "                try {" + NL + "                    rsTable_";
  protected final String TEXT_180 = ".execute(\"SELECT TOP 1 1 FROM [\" +  tableName_";
  protected final String TEXT_181 = " + \"]\" );" + NL + "                    whetherExist_";
  protected final String TEXT_182 = " = true;" + NL + "                } catch (Exception e){" + NL + "                    whetherExist_";
  protected final String TEXT_183 = " = false;" + NL + "                }";
  protected final String TEXT_184 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_185 = " = conn_";
  protected final String TEXT_186 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_187 = " = dbMetaData_";
  protected final String TEXT_188 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            while(rsTable_";
  protected final String TEXT_189 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_190 = " = rsTable_";
  protected final String TEXT_191 = ".getString(\"TABLE_NAME\");" + NL + "\t                String schema_";
  protected final String TEXT_192 = " = rsTable_";
  protected final String TEXT_193 = ".getString(\"TABLE_SCHEM\");" + NL + "\t                if(table_";
  protected final String TEXT_194 = ".equals";
  protected final String TEXT_195 = "IgnoreCase";
  protected final String TEXT_196 = "(";
  protected final String TEXT_197 = ") " + NL + "\t                \t&& (schema_";
  protected final String TEXT_198 = ".equals";
  protected final String TEXT_199 = "IgnoreCase";
  protected final String TEXT_200 = "(dbSchema_";
  protected final String TEXT_201 = ") || dbSchema_";
  protected final String TEXT_202 = ".trim().length() ==0)) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_203 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }" + NL + NL;
  protected final String TEXT_204 = NL + "\t\t\t\t\t\tString dbUser_";
  protected final String TEXT_205 = " = (String) globalMap.get(\"username_";
  protected final String TEXT_206 = "\");";
  protected final String TEXT_207 = NL + "\t\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_208 = " = conn_";
  protected final String TEXT_209 = ".getMetaData();" + NL + "\t\t\t\t\tjava.sql.ResultSet rsTable_";
  protected final String TEXT_210 = " = dbMetaData_";
  protected final String TEXT_211 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t\t\t\t\twhile(rsTable_";
  protected final String TEXT_212 = ".next()) {" + NL + "\t\t\t\t\t\tString table_";
  protected final String TEXT_213 = " = rsTable_";
  protected final String TEXT_214 = ".getString(\"TABLE_NAME\");" + NL + "\t\t\t\t\t\tString schema_";
  protected final String TEXT_215 = " = rsTable_";
  protected final String TEXT_216 = ".getString(\"TABLE_SCHEM\");" + NL + "\t\t\t\t\t\tif(table_";
  protected final String TEXT_217 = ".equals";
  protected final String TEXT_218 = "IgnoreCase";
  protected final String TEXT_219 = "(";
  protected final String TEXT_220 = ") " + NL + "\t\t\t\t\t\t\t&& (schema_";
  protected final String TEXT_221 = ".equals";
  protected final String TEXT_222 = "IgnoreCase";
  protected final String TEXT_223 = "(dbname_";
  protected final String TEXT_224 = ") || (dbname_";
  protected final String TEXT_225 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_226 = ".equalsIgnoreCase(schema_";
  protected final String TEXT_227 = ")))) {" + NL + "\t\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_228 = " = true;" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL;
  protected final String TEXT_229 = NL + "\t            java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_230 = " = conn_";
  protected final String TEXT_231 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_232 = " = dbMetaData_";
  protected final String TEXT_233 = ".getTables(conn_";
  protected final String TEXT_234 = ".getCatalog(), conn_";
  protected final String TEXT_235 = ".getSchema(),(";
  protected final String TEXT_236 = ")";
  protected final String TEXT_237 = ", new String[] { \"TABLE\" });" + NL + "\t            if(rsTable_";
  protected final String TEXT_238 = ".next()) {" + NL + "\t                whetherExist_";
  protected final String TEXT_239 = " = true;" + NL + "\t            }     ";
  protected final String TEXT_240 = NL + "                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_241 = " = conn_";
  protected final String TEXT_242 = ".getMetaData();" + NL + "                java.sql.ResultSet rsTable_";
  protected final String TEXT_243 = " = dbMetaData_";
  protected final String TEXT_244 = ".getTables(";
  protected final String TEXT_245 = ", null, null, new String[]{\"TABLE\"});" + NL + "                while(rsTable_";
  protected final String TEXT_246 = ".next()) {" + NL + "                    String table_";
  protected final String TEXT_247 = " = rsTable_";
  protected final String TEXT_248 = ".getString(\"TABLE_NAME\");" + NL + "                    if(table_";
  protected final String TEXT_249 = ".equals";
  protected final String TEXT_250 = "IgnoreCase";
  protected final String TEXT_251 = "(";
  protected final String TEXT_252 = ")) {" + NL + "                        whetherExist_";
  protected final String TEXT_253 = " = true;" + NL + "                        break;" + NL + "                    }" + NL + "                }  ";
  protected final String TEXT_254 = NL + "\t            java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_255 = " = conn_";
  protected final String TEXT_256 = ".getMetaData();" + NL + "\t            java.sql.ResultSet rsTable_";
  protected final String TEXT_257 = " = dbMetaData_";
  protected final String TEXT_258 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t            while(rsTable_";
  protected final String TEXT_259 = ".next()) {" + NL + "\t                String table_";
  protected final String TEXT_260 = " = rsTable_";
  protected final String TEXT_261 = ".getString(\"TABLE_NAME\");" + NL + "\t                if(table_";
  protected final String TEXT_262 = ".equals";
  protected final String TEXT_263 = "IgnoreCase";
  protected final String TEXT_264 = "(";
  protected final String TEXT_265 = ")) {" + NL + "\t                    whetherExist_";
  protected final String TEXT_266 = " = true;" + NL + "\t                    break;" + NL + "\t                }" + NL + "\t            }     ";
  protected final String TEXT_267 = NL + "            rsTable_";
  protected final String TEXT_268 = ".close();";
  protected final String TEXT_269 = NL + "                if(!whetherExist_";
  protected final String TEXT_270 = ") {" + NL + "                    java.sql.Statement stmt_";
  protected final String TEXT_271 = " = conn_";
  protected final String TEXT_272 = ".createStatement();";
  protected final String TEXT_273 = NL + "                        log.info(\"";
  protected final String TEXT_274 = " - Creating table '\" + tableName_";
  protected final String TEXT_275 = " + \"'.\");";
  protected final String TEXT_276 = NL + "                    stmt_";
  protected final String TEXT_277 = ".execute(\"";
  protected final String TEXT_278 = "\");                ";
  protected final String TEXT_279 = NL + "                        log.info(\"";
  protected final String TEXT_280 = " - Create table '\" + tableName_";
  protected final String TEXT_281 = " + \"' has succeeded.\");";
  protected final String TEXT_282 = NL + "\t\t            ";
  protected final String TEXT_283 = NL + "                }";
  protected final String TEXT_284 = NL + "                if(whetherExist_";
  protected final String TEXT_285 = ") {" + NL + "                    java.sql.Statement stmtDrop_";
  protected final String TEXT_286 = " = conn_";
  protected final String TEXT_287 = ".createStatement();";
  protected final String TEXT_288 = NL + "                        log.info(\"";
  protected final String TEXT_289 = " - Droping table '\" + tableName_";
  protected final String TEXT_290 = " + \"'.\");";
  protected final String TEXT_291 = NL + "                    stmtDrop_";
  protected final String TEXT_292 = ".execute(\"";
  protected final String TEXT_293 = "\");";
  protected final String TEXT_294 = NL + "                        log.info(\"";
  protected final String TEXT_295 = " - Drop table '\" + tableName_";
  protected final String TEXT_296 = " + \"' has succeeded.\");";
  protected final String TEXT_297 = NL + "                }" + NL + "                java.sql.Statement stmt_";
  protected final String TEXT_298 = " = conn_";
  protected final String TEXT_299 = ".createStatement();";
  protected final String TEXT_300 = NL + "                    log.info(\"";
  protected final String TEXT_301 = " - Creating table '\" + tableName_";
  protected final String TEXT_302 = " + \"'.\");";
  protected final String TEXT_303 = NL + "                stmt_";
  protected final String TEXT_304 = ".execute(\"";
  protected final String TEXT_305 = "\"); ";
  protected final String TEXT_306 = NL + "                    log.info(\"";
  protected final String TEXT_307 = " - Create table '\" + tableName_";
  protected final String TEXT_308 = " + \"' has succeeded.\");";
  protected final String TEXT_309 = NL + "\t            ";
  protected final String TEXT_310 = NL + "        ";
  protected final String TEXT_311 = NL + "        globalMap.put(\"";
  protected final String TEXT_312 = "_QUERY\", \"";
  protected final String TEXT_313 = "\");        " + NL + "    } catch(java.lang.Exception e) {" + NL + "        globalMap.put(\"";
  protected final String TEXT_314 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "        throw new RuntimeException(\"Creating table failed\", e);" + NL + "    }";
  protected final String TEXT_315 = NL;
  protected final String TEXT_316 = NL;

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

    	
abstract class Manager {
    protected String dbName;
    protected String tableName;
    protected String userName;
    protected String cid;
    protected INode node;
    protected boolean temporary;
    protected boolean unlogged;
    protected DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil;
    protected abstract String getDriver();
    public abstract String getConnectionURL();
    protected abstract String getDBMSId();
    public Manager(String dbName, String userName) {
        this.dbName = dbName;
        this.userName = userName;
    }
    public Manager(String dbName, String userName, String cid) {
        this(dbName, userName);
        this.cid = cid;
    }
    public Manager(String dbName, String tableName, String userName, String cid) {
        this(dbName, userName, cid);
        this.tableName = tableName;
    }
    public String difineConnParam(){
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("String driverClass_"+cid+"=\"" + getDriver()+ "\";\r\n");
        javaCode.append("String url_"+cid+"=" + getConnectionURL()+ ";\r\n");
        javaCode.append("String dbUser_"+cid+"=" + userName + ";\r\n");
        return javaCode.toString();
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(retrieveTable());
        javaCode.append("java.lang.Class.forName(\"" + getDriver()+ "\");\r\n");
        log4jCodeGenerateUtil.connect_begin();
        String passwordFieldName = "__PASS__";
        if(ElementParameterParser.canEncrypt(node, passwordFieldName)) {
        	javaCode.append("final String decryptedPassword_" + cid + "= routines.system.PasswordEncryptUtil.decryptPassword(" + ElementParameterParser.getEncryptedValue(node, passwordFieldName) + ");\r\n");
        } else {
        	javaCode.append("final String decryptedPassword_" + cid + "= " + ElementParameterParser.getValue(node, passwordFieldName) + ";\r\n");
        }
        
        javaCode.append("java.sql.Connection conn_" + cid + "= java.sql.DriverManager.getConnection(url_" + cid + ",dbUser_" + cid + ", decryptedPassword_" + cid + ");\r\n");
        return javaCode.toString();
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("if(conn_" + cid + " != null && !conn_" + cid + ".isClosed()) {\r\n");
        javaCode.append("conn_" + cid + ".close();\r\n");
        javaCode.append("}\r\n");
        return javaCode.toString();
    }
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("String tableName_" + cid + " = " + tableName + ";\r\n");
        return javaCode.toString();
    }
    public String getDropTableSQL() {
        StringBuilder dropTableSQL = new StringBuilder();
        dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
        return dropTableSQL.toString();
    }
    public String getCreateTableSQL(List<IMetadataColumn> listColumn) {
        MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
        StringBuilder createTableSQL = new StringBuilder();
        String temp = "";
        if(temporary) {
            temp = "TEMPORARY "; 
        }
        String unlog = "";
        if (unlogged && !temporary) {
            unlog = "UNLOGGED ";
        }
        createTableSQL.append("CREATE ").append(temp).append(unlog).append("TABLE " + getLProtectedChar( "\" + tableName_" + cid + " + \"" ) + "\" + tableName_" + cid + " + \"" + getRProtectedChar("\" + tableName_" + cid + " + \"") + "(");
        List<String> pkList = new ArrayList<String>();
        int count = 0;
        String ending = ",";
        for(IMetadataColumn metadataColumn : listColumn) {
            if(metadataColumn.isKey()) {
                pkList.add(getLProtectedChar(metadataColumn.getOriginalDbColumnName()) + metadataColumn.getOriginalDbColumnName() + getRProtectedChar(metadataColumn.getOriginalDbColumnName()));
            }
            createTableSQL.append(getLProtectedChar(metadataColumn.getOriginalDbColumnName()) + metadataColumn.getOriginalDbColumnName() + getRProtectedChar(metadataColumn.getOriginalDbColumnName()) + " ");
            String dataType = null;
            if(metadataColumn.getType() == null || metadataColumn.getType().trim().length() == 0) {
                dataType = mappingType.getDefaultSelectedDbType(metadataColumn.getTalendType());
            } else {
                dataType = metadataColumn.getType();
            }
            
            Integer length = metadataColumn.getLength() == null ? 0 : metadataColumn.getLength();
            
            if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED") ) {
            	createTableSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ; 
            }else if("oracle_id".equalsIgnoreCase(getDBMSId()) && dataType.matches("TIMESTAMP WITH TIME ZONE")){
            	createTableSQL.append("TIMESTAMP("+length+") WITH TIME ZONE");
            }else{
            	createTableSQL.append(dataType);
            }
                        
            Integer precision = metadataColumn.getPrecision() == null ? 0 : metadataColumn.getPrecision();
            boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
            boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
            String prefix = "";
            String suffix = "";
            String comma = "";
            
            
            if(mappingType.isPreBeforeLength(getDBMSId(),dataType)) {
                if(!precisionIgnored) {
                    prefix = "(";
                    suffix = ") ";
                    createTableSQL.append(prefix + precision);
                }
                if(!lengthIgnored) {
                    prefix = (("").equals(prefix) ? "(" : prefix);
                    suffix = (("").equals(suffix) ? ") " : suffix);
                    if(precisionIgnored) {
                        createTableSQL.append(prefix);
                        comma = "";
                    } else {
                        comma = ",";
                    }
                    createTableSQL.append(comma + length);
                }
                createTableSQL.append(suffix);
            } else {
                boolean isPostgresishDB = ("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) || "greenplum_id".equalsIgnoreCase(getDBMSId()) );
                if(!lengthIgnored) {
                    if (isPostgresishDB && metadataColumn.getLength() == null) {
                    }else {
                        prefix = "(";
                        suffix = ") ";
                        createTableSQL.append(prefix + length);
                    }
                }
                if(!precisionIgnored) {
                    prefix = (("").equals(prefix) ? "(" : prefix);
                    suffix = (("").equals(suffix) ? ") " : suffix);
                    if(lengthIgnored) {
                        createTableSQL.append(prefix);
                        comma = "";
                    } else {
                        comma = ",";
                    }
                    if (!isPostgresishDB || metadataColumn.getLength() != null) {
                        createTableSQL.append(comma + precision);
                    }
                }

                if (isPostgresishDB && metadataColumn.getLength() == null) {
                } else {
                    createTableSQL.append(suffix);
                }
                
                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                    createTableSQL.append("UNSIGNED");
                }
            }
            createTableSQL.append(getDefaultValueSQL(metadataColumn.getDefault()));            
            createTableSQL.append(setNullable(metadataColumn.isNullable()));            
            if(count == listColumn.size() - 1 && pkList.size() == 0) {
                ending = "";
            }
            createTableSQL.append(ending);
            count++;
        }
        if(pkList.size() > 0) {                
            createTableSQL.append("primary key(");                
            int i = 0;                
            for(String pk : pkList) {                    
                createTableSQL.append(pk);                    
                if(i != pkList.size() - 1) {                        
                    createTableSQL.append(",");                        
                }                    
                i++;                    
            }                
            createTableSQL.append(")");                
        }
        createTableSQL.append(")");
        return createTableSQL.toString();
    }
    protected String setNullable(boolean nullable) {
        if(!nullable) {
            return " not null ";
        } else {
            return "";
        }
    }    
    protected String getDefaultValueSQL(String defaultValue) {
        if(defaultValue == null || ("\"\"").equals(defaultValue) || ("").equals(defaultValue)) {
            return " ";
        } else if((defaultValue.startsWith("\"") || defaultValue.startsWith("'")) && (defaultValue.endsWith("\"") || defaultValue.endsWith("'"))) {
            return " default '" + defaultValue.substring(1,defaultValue.length() - 1) + "' ";
        } else if(defaultValue.equalsIgnoreCase("null")) {
            return " default null ";
        } else {
            return " default " + defaultValue + " ";
        }            
    }
    protected String getLProtectedChar() {
    	return "";
    }
    protected String getRProtectedChar() {
    	return "";
    }
    
    protected String getLProtectedChar(String keyword){
    	return getLProtectedChar();
    }
    protected String getRProtectedChar(String keyword){
    	return getRProtectedChar();
    }
    
    public void setNode(INode node){
    	this.node = node;
    	log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil(node);
    }
	public String generateCode4TabelExist() {
	    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	    String connection = getConnectionName();
	    StringBuilder code = new StringBuilder();  
	    code.append("String tableNameForSearch_" + cid + "= " + getTableName4Search(useExistingConnection, connection) + ";\r\n");
	    if (hasSchema()) {
		    code.append("String dbschemaForSearch_" + cid + "= null;\r\n");
		    code.append("if(dbSchema_" + cid + "== null || dbSchema_" + cid + ".trim().length() == 0) {\r\n");
		  	code.append("dbschemaForSearch_" + cid + "= null" + ";\r\n");
		    code.append("} else {\r\n");
		    code.append("dbschemaForSearch_" + cid + "= " + getShemaName4Search(useExistingConnection, connection)+ ";\r\n");
		    code.append("}\r\n");
	    }
	    return code.toString();
	}
	
	protected String getConnectionName() {
	    return "";
	}
	
	protected String getTableName4Search(boolean useExistingConnection, String connection) {
	    return "\""+getLProtectedChar()+ "\" + " + ElementParameterParser.getValue(node,"__TABLE__") +" + \"" + getRProtectedChar() + "\""; 
	}
	
    protected String getUserName4Search(boolean useExistingConnection, String connection) {
        return "";   
    }

    /*
     * maybe some db need add getLProtectedChar() and getRProtectedChar() to schema name.
     * this because of some db default add getLProtectedChar() and getRProtectedChar() to schaem when create table. e.g:db2
     * 
     * in fact the db add getLProtectedChar() and getRProtectedChar() to scheam when create table that is wrong
    */
    protected String getShemaName4Search(boolean useExistingConnection, String connection) {
        return "";   
    }	
    
    protected boolean hasSchema() {
        return false;
    }
}

class AS400Manager extends Manager {
    private String host;
    private String dbproperty;
    private boolean useExistingConnection;
	private String connection;
    public AS400Manager(String host, String dbName, String tableName, String userName, String cid,String dbproperties,boolean useExistingConnection, String connection ) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.dbproperty = dbproperties;
        this.useExistingConnection = useExistingConnection;
		this.connection = connection;
    }
    protected String getDriver() {
        return "com.ibm.as400.access.AS400JDBCDriver";
    }
    public String getConnectionURL() {
        if(dbproperty == null || ("\"\"").equals(dbproperty) || ("").equals(dbproperty)){
            return "\"jdbc:as400://\" + " + host + " + \"/\" + "+ dbName;
        }else{
            return "\"jdbc:as400://\" + " + host + " + \"/\" + "+ dbName + "+\";\"+"+ dbproperty;
        }
    }
    protected String getDBMSId() {
        return "as400_id";
    }
    protected String getLProtectedChar() {
        return "";
    }
    protected String getRProtectedChar() {
        return "";
    }
    
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }  
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
}   
class AccessManager extends Manager {
    private String dbproperty;
    private boolean useExistingConnection;
	private String connection;
    public AccessManager(String dbName, String tableName, String userName, String cid,String dbproperties,boolean useExistingConnection, String connection) {
        super(dbName, tableName, userName, cid);
		this.dbproperty = dbproperties;
        this.useExistingConnection = useExistingConnection;
		this.connection = connection;
    }
    protected String getDriver() {
        return "sun.jdbc.odbc.JdbcOdbcDriver";
    }
    public String getConnectionURL() {
        return "\"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=\" + " + dbName;
    }
    protected String getDBMSId() {
        return "access_id";
    }
    protected String getLProtectedChar() {
        return "[";
    }
    protected String getRProtectedChar() {
        return "]";
    }
	public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }  
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
}
class DB2Manager extends Manager {
    private String host;
    private String port;
    private String userName;
    private String dbSchema;
    private boolean useExistingConnection;
	private String connection;
    public DB2Manager(String host, String port, String dbName, String tableName, String userName, String cid, String dbSchema,boolean useExistingConnection, String connection) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.port = port;
        this.dbSchema = dbSchema;
        this.userName = userName;
        this.useExistingConnection = useExistingConnection;
		this.connection = connection;
    }
    protected String getDriver() {
        return "com.ibm.db2.jcc.DB2Driver";
    }
    public String getConnectionURL() {
        return "\"jdbc:db2://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
    }
    protected String getDBMSId() {
        return "ibmdb2_id";
    }
    protected String getLProtectedChar() {
        return "\\\"";
    }
    protected String getRProtectedChar() {
        return "\\\"";
    }
    
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }  
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.retrieveTable());
        if(useExistingConnection) {
            javaCode.append("String dbSchema_" + cid + " = (String)globalMap.get(\"tableschema_" + connection + "\");\r\n"); 
            javaCode.append("String dbUser_" + cid + " = (String)globalMap.get(\"username_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbSchema_" + cid + " = " + dbSchema + ";\r\n");            
        }
        javaCode.append("if(dbSchema_" + cid + " != null && dbSchema_" + cid + ".trim().length() != 0) {");
        javaCode.append("tableName_" + cid + " = dbSchema_" + cid + " + \"" + getLProtectedChar() + "." + getRProtectedChar() + "\" + tableName_" + cid + ";\r\n");
        javaCode.append("}");
        return javaCode.toString();
    } 
}
class FirebirdManager extends Manager {
    private String host;
    private boolean useExistingConnection;
	private String connection;
    public FirebirdManager(String host, String dbName, String tableName, String userName, String cid,boolean useExistingConnection, String connection ) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.useExistingConnection = useExistingConnection;
		this.connection = connection;
    }
    protected String getDriver() {
        return "org.firebirdsql.jdbc.FBDriver";
    }
    public String getConnectionURL() {
        return "\"jdbc:firebirdsql:\" + " + host + " + \":\" + " + dbName;
    }
    protected String getDBMSId() {
        return "firebird_id";
    }
    protected String getLProtectedChar() {
        return "";
    }
    protected String getRProtectedChar() {
        return "";
    }
     public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }  
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
}
class HSQLDBManager extends Manager {
    private String runningMode;
    private String host;
    private String port;
    private String dbPath;
    private String dbAlias;
    private boolean tls;
    public HSQLDBManager(String host, String port, String dbPath, String dbName, String tableName, String dbAlias, String userName, 
            String runningMode, boolean tls, String cid) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.port = port;
        this.dbPath = dbPath;
        this.dbAlias = dbAlias;
        this.runningMode = runningMode;
        this.tls = tls;
    }
    protected String getDriver() {
        return "org.hsqldb.jdbcDriver";
    }
    public String getConnectionURL() {
        String connectionURL = null;
        if(("HSQLDB_SERVER").equals(runningMode)) {
            if(tls) {
                connectionURL = "\"jdbc:hsqldb:hsqls://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbAlias;
            } else {
                connectionURL = "\"jdbc:hsqldb:hsql://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbAlias;
            }
        } else if(("HSQLDB_WEBSERVER").equals(runningMode)) {
            if(tls) {
                connectionURL = "\"jdbc:hsqldb:https://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbAlias;
            } else {
                connectionURL = "\"jdbc:hsqldb:http://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbAlias;
            }               
        } else {
            connectionURL = "\"jdbc:hsqldb:file:\" + " + dbPath + " + \"/\" + " + dbName + " + \";ifexists=true\"";
        }
        return connectionURL;
    }
    protected String getDBMSId() {
        return "hsqldb_id";
    }
    protected String getLProtectedChar() {
        boolean  tableNameCaseSensitive = "true".equals(ElementParameterParser.getValue(node,"__CASESENSITIVE__"));
        if(tableNameCaseSensitive){
            return "\\\"";
        }
        return "";
    }
    protected String getRProtectedChar() {
        boolean  tableNameCaseSensitive = "true".equals(ElementParameterParser.getValue(node,"__CASESENSITIVE__"));
        if(tableNameCaseSensitive){
            return "\\\"";
        }
        return "";
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("if(conn_" + cid + " != null && !conn_" + cid + ".isClosed()) {\r\n");
        javaCode.append("java.sql.Statement stmtClose_" + cid + " = conn_" + cid + ".createStatement();\r\n");
        javaCode.append("stmtClose_" + cid + ".execute(\"SHUTDOWN\");\r\n");
        javaCode.append("conn_" + cid + ".close();\r\n");
        javaCode.append("}\r\n");
        return javaCode.toString();
    }
}
class InformixManager extends Manager {
    private String host;
    private String port;
    private String dbServer;
	private String dbSchema;
	private boolean useExistingConnection;
	private String connection;
    public InformixManager(String host, String port, String dbName, String tableName, String dbServer, String userName, 
    					 	String cid, String dbSchema, boolean useExistingConnection, String connection ) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.port = port;
        this.dbServer = dbServer;
        this.dbSchema = dbSchema;
        this.useExistingConnection = useExistingConnection;
		this.connection = connection;
    }
    protected String getDriver() {
        return "com.informix.jdbc.IfxDriver";
    }
    public String getConnectionURL() {
        return "\"jdbc:informix-sqli://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName + " + \":informixserver=\" + " + dbServer;
    }
    protected String getDBMSId() {
        return "informix_id";
    }
    protected String getLProtectedChar() {
        return "";
    }
    protected String getRProtectedChar() {
        return "";
    }
    
	public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }  
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.retrieveTable());
        if(useExistingConnection) {
            javaCode.append("String dbSchema_" + cid + " = (String)globalMap.get(\"dbschema_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbSchema_" + cid + " = " + dbSchema + ";\r\n");            
        }
        javaCode.append("if(dbSchema_" + cid + " != null && dbSchema_" + cid + ".trim().length() != 0) {");
        javaCode.append("tableName_" + cid + " = dbSchema_" + cid + " + \"" + getLProtectedChar() + "." + getRProtectedChar() + "\" + tableName_" + cid + ";\r\n");
        javaCode.append("}");
        return javaCode.toString();
    } 
}
class IngresManager extends Manager {
    private String host;
    private String port;
    private boolean useExistingConnection;
	private String connection;
    public IngresManager(String host, String port, String dbName, String tableName, String userName, String cid, boolean useExistingConnection, String connection ) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.port = port;
        this.useExistingConnection = useExistingConnection;
		this.connection = connection;
    }
    protected String getDriver() {
        return "com.ingres.jdbc.IngresDriver";
    }
    public String getConnectionURL() {
        return "\"jdbc:ingres://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
    }
    protected String getDBMSId() {
        return "ingres_id";
    }
    protected String getLProtectedChar() {
        return "\\\"";
    }
    protected String getRProtectedChar() {
        return "\\\"";
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }  
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
}
class InterbaseManager extends Manager {
    private String host;
    private boolean useExistingConnection;
	private String connection;
    public InterbaseManager(String host, String dbName, String tableName, String userName, String cid, boolean useExistingConnection, String connection ) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.useExistingConnection = useExistingConnection;
		this.connection = connection;
    }
    protected String getDriver() {
        return "interbase.interclient.Driver";
    }
    public String getConnectionURL() {
        return "\"jdbc:interbase://\" + " + host + " + \"/\" + " + dbName;
    }
    protected String getDBMSId() {
        return "interbase_id";
    }
    protected String getLProtectedChar() {
        return "\\\"";
    }
    protected String getRProtectedChar() {
        return "\\\"";
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }  
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
}
class JavaDBManager extends Manager {
    private String host;
    private String port;
    private String dbRootPath;
    private String frameworkType;
    private boolean connectionFlag;
    public JavaDBManager(String host, String port, String dbRootPath, String dbName, String tableName, String userName, String frameworkType, boolean connectionFlag, String cid) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.port = port;
        this.dbRootPath = dbRootPath;
        this.frameworkType = frameworkType;
        this.connectionFlag = connectionFlag;
    }
    protected String getDriver() {
        String driver = null;
        if(("EMBEDED").equals(frameworkType)) {
            driver = "org.apache.derby.jdbc.EmbeddedDriver";
        }else if(("JCCJDBC").equals(frameworkType)) {
            driver = "com.ibm.db2.jcc.DB2Driver";
        } else {
            driver = "org.apache.derby.jdbc.ClientDriver";
        }
        return driver;
    }
    public String getConnectionURL() {
        String connectionURL = null;
        if(("EMBEDED").equals(frameworkType)) {
            connectionURL = "\"jdbc:derby:\" + " + dbName;
        } else if(("JCCJDBC").equals(frameworkType)) {
            connectionURL = "\"jdbc:derby:net://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
        } else {
            connectionURL = "\"jdbc:derby://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
        }
        return connectionURL;
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(("EMBEDED").equals(frameworkType)) {
            javaCode.append("System.setProperty(\"derby.system.home\", " + dbRootPath + ");\r\n");              
        } else {
            if(!connectionFlag) {
                javaCode.append(startServer());
            }
        }
        javaCode.append(super.getConnection());
        return javaCode.toString();
    }
    private String startServer() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("org.apache.derby.drda.NetworkServerControl serverControl_" + cid + " = new org.apache.derby.drda.NetworkServerControl(java.net.InetAddress.getByName(" + host + "),Integer.parseInt(" + port + "));\r\n");
        javaCode.append("serverControl_" + cid + ".start(new java.io.PrintWriter(System.out,true));\r\n");
        javaCode.append("boolean isServerUp_" + cid + " = false;\r\n");
        javaCode.append("int timeOut_" + cid + " = 5;\r\n");
        javaCode.append("while(!isServerUp_" + cid + " && timeOut_" + cid + " > 0) {\r\n");
        javaCode.append("try {\r\n");
        javaCode.append("timeOut_" + cid + "--;\r\n");
        javaCode.append("serverControl_" + cid + ".ping();\r\n");
        javaCode.append("isServerUp_" + cid + " = true;\r\n");
        javaCode.append("} catch(java.lang.Exception e) {\r\n");
        javaCode.append("Thread.currentThread().sleep(3000);\r\n");
        javaCode.append("}\r\n");
        javaCode.append("}\r\n");
        javaCode.append("if(!isServerUp_" + cid + ") {\r\n");
        javaCode.append("throw new java.lang.Exception(\"Can not obtain a connection to network server\");\r\n");
        javaCode.append("}\r\n");
        return javaCode.toString();
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.closeConnection());
        if(("EMBEDED").equals(frameworkType)) {
            javaCode.append("try {\r\n");
            javaCode.append("java.sql.DriverManager.getConnection(\"jdbc:derby:\" + " + dbName+ " + \" +;shutdown=true\");\r\n");
            javaCode.append("} catch(java.sql.SQLException se) {\r\n");
            javaCode.append("}\r\n");               
        }
        return javaCode.toString();
    }
    protected String getDBMSId() {
        return "javadb_id";
    }
    protected String getLProtectedChar() {
        return "\\\"";
    }
    protected String getRProtectedChar() {
        return "\\\"";
    }
}
class MaxDBManager extends Manager {
    private String host;
    private String port;
    public MaxDBManager(String host, String port, String dbName, String tableName, String userName, String cid) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.port = port;
    }
    protected String getDriver() {
        return "com.sap.dbtech.jdbc.DriverSapDB";
    }
    public String getConnectionURL() {
        return "\"jdbc:sapdb://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
    }
    protected String getDBMSId() {
        return "maxdb_id";
    }
    protected String getLProtectedChar() {
        return "";
    }
    protected String getRProtectedChar() {
        return "";
    }
}
class MSSQLManager extends Manager {
    private String host;
    private String port;
    private String dbSchema;
    private boolean useExistingConnection;
    private String connection;
    private String dbproperty;
    private String driver;
    public MSSQLManager(String host, String port, String dbName, String dbSchema, String tableName, String userName, boolean useExistingConnection, String connection, String cid, String dbproperty, String driver) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.port = port;
        this.dbSchema = dbSchema;
        this.useExistingConnection = useExistingConnection;
        this.connection = connection;
        this.dbproperty = dbproperty;
        this.driver = driver;
    }
    protected String getDriver() {
    	if("JTDS".equals(driver)) {
        	return "net.sourceforge.jtds.jdbc.Driver";
        } else {
        	return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        }
    }
    public String getConnectionURL() {
    	StringBuilder connectionUrl = new StringBuilder();
    	if("JTDS".equals(driver)) {
    		connectionUrl.append("\"jdbc:jtds:sqlserver://\" + ");
    	} else {
    		connectionUrl.append("\"jdbc:sqlserver://\" + ");
    	}
    	connectionUrl.append(host).append(" + \":\" + ").append(port);
    	if("JTDS".equals(driver)) {
    		connectionUrl.append(" + \"//\" + ");
    	} else {
    		connectionUrl.append(" + \";databaseName=\" + ");
    	}
    	connectionUrl.append(dbName);
    	if(dbproperty != null && !dbproperty.equals("\"\"") && !dbproperty.equals("")) {
    		connectionUrl.append("+\";\"+").append(dbproperty);
    	}
    	
    	return connectionUrl.toString();
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }
    protected String getDBMSId() {
        return "id_MSSQL";
    }
    protected String getLProtectedChar() {
        return "[";
    }
    protected String getRProtectedChar() {
        return "]";
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.retrieveTable());
        if(useExistingConnection) {
            javaCode.append("String dbSchema_" + cid + " = (String)globalMap.get(\"dbschema_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbSchema_" + cid + " = " + dbSchema + ";\r\n");            
        }
        javaCode.append("if(dbSchema_" + cid + " != null && dbSchema_" + cid + ".trim().length() != 0) {");
        javaCode.append("tableName_" + cid + " = dbSchema_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + tableName_" + cid + ";\r\n");
        javaCode.append("}");
        return javaCode.toString();        
    }
}
class MysqlManager extends Manager {
    private String host;
    private String port;
    private boolean useExistingConnection;
    private String connection;        
    private String dbVersion;
    public MysqlManager(String host, String port, String dbName, String tableName, String userName, boolean useExistingConnection, String connection, boolean temporary, String cid, String dbVersion) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.port = port;
        this.useExistingConnection = useExistingConnection;
        this.connection = connection;
        this.temporary = temporary;
        this.dbVersion = dbVersion;
    }
    protected String getDriver() {
        if("MARIADB".equals(dbVersion)){
            return "org.mariadb.jdbc.Driver";
        } else if ("MYSQL_8".equals(dbVersion)){
            return "com.mysql.cj.jdbc.Driver";
        } else {
            return "com.mysql.jdbc.Driver";
        }
    }
    public String getConnectionURL() {
    	String jdbcURL = "\"jdbc:mysql\"";
    	if("MARIADB".equals(dbVersion)){
			jdbcURL = "\"jdbc:mariadb\"";
		}
        return jdbcURL+"+\"://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }        
    protected String getDBMSId() {
        return "mysql_id";
    }
    protected String getLProtectedChar() {
        return "`";
    }
    protected String getRProtectedChar() {
        return "`";
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }    
}

class NetezzaManager extends Manager {
    private String host;
    private String port;
    private boolean useExistingConnection;
    private String connection;        
    public NetezzaManager(String host, String port, String dbName, String tableName, String userName, boolean useExistingConnection, String connection, String cid) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.port = port;
        this.useExistingConnection = useExistingConnection;
        this.connection = connection;
    }
    protected String getDriver() {
        return "org.netezza.Driver";
    }
    public String getConnectionURL() {
        return "\"jdbc:netezza://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }        
    protected String getDBMSId() {
        return "netezza_id";
    }
    protected String getLProtectedChar() {
        return "";
    }
    protected String getRProtectedChar() {
        return "";
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }    
}

class OracleManager extends Manager {
    private String host;
    private String port;
    private String dbSchema;
    private String connectionType;
    private boolean useExistingConnection;
    private String connection;
    private String jdbcURL;
    private String rac_url;
    private String localServiceName;
    private String[] oracleKeyWords= {
    	"ACCESS" ,"AUDIT","COMPRESS","DESC" , 
    	"ADD","ACCESS","CONNECT","DISTINCT" ,
    	"ALL","BY","CREATE","DROP",
    	"ALTER","CHAR","CURRENT","ELSE",
    	"AND","CHECK","DATE","EXCLUSIVE",
    	"ANY","CLUSTER","DECIMAL","	EXISTS",
    	"AS","COLUMN","DEFAULT","FILE",
    	"ASC","COMMENT","DELETE","FLOAT",
    	"FOR","LONG","PCTFREE","SUCCESSFUL",
    	"FROM","MAXEXTENTS","PRIOR","SYNONYM",
    	"GRANT","MINUS","PRIVILEGES","SYSDATE",
    	"GROUP","MODE","PUBLIC","TABLE",
    	"HAVING","MODIFY","RAW","THEN",
    	"IDENTIFIED","NETWORK","RENAME","TO",
		"IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
		"IN","NOCOMPRESS","REVOKE","UID",
		"INCREMENT","NOT","ROW","UNION",
		"INDEX","NOWAIT","ROWID","UNIQUE",
		"INITIAL","NULL","ROWNUM","UPDATE",
		"INSERT","NUMBER","ROWS","USER",
		"INTEGER","OF","SELECT","VALIDATE",
		"INTERSECT","OFFLINE","SESSION","VALUES",
		"INTO","ON","SET","VARCHAR",
		"IS","ONLINE","SHARE","VARCHAR2",
		"LEVEL","OPTION","SIZE","VIEW",
		"LIKE","OR","SMALLINT","WHENEVER",
		"LOCK","ORDER","START","WHERE","WITH"
    	};
    private String dbVersion;
            
    public OracleManager(String host, String port, String dbName, String tableName, String dbSchema, String useName, String connectionType, boolean useExistingConnection, String connection, String cid,String jdbcURL,String rac_url,String localServiceName, String dbVersion) {
        super(dbName, tableName, useName, cid);
        this.host = host;
        this.port = port;
        this.dbSchema = dbSchema;
        this.connectionType = connectionType;
        this.useExistingConnection = useExistingConnection;
        this.connection = connection;
        this.jdbcURL = jdbcURL;
        this.rac_url = rac_url;
        this.localServiceName = localServiceName;
        this.dbVersion = dbVersion;
    }
    protected String getDriver() {
        return ("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_12".equals(dbVersion) || "ORACLE_18".equals(dbVersion)) ?
            "oracle.jdbc.OracleDriver" : "oracle.jdbc.driver.OracleDriver";
    }
    public String getConnectionURL() {
        String connectionURL = null;
        if(("ORACLE_RAC").equals(connectionType)) {
        	connectionURL = rac_url;
        } else if(("ORACLE_SID").equals(connectionType)) {
            connectionURL = "\"jdbc:oracle:thin:@\" + " + host + " + \":\" + " + port + " + \":\" + " + dbName;
        } else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {
            connectionURL = "\"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + " + host + " + \")(port=\" + " + port + " + \"))(connect_data=(service_name=\" + " + dbName + " + \")))\"";
        }
  		 else if(("ORACLE_OCI").equals(connectionType)) {
         connectionURL = "\"jdbc:oracle:oci8:@\" + " + localServiceName ;
        }
        else if(("ORACLE_WALLET").equals(connectionType)) {
         connectionURL = jdbcURL ;
				}
        return connectionURL;
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        }
         else if (("ORACLE_WALLET").equals(connectionType)) 
        	{
        	 javaCode.append(retrieveTable());
        	 javaCode.append("java.lang.Class.forName(\"" + getDriver()+ "\");\r\n");
        	 log4jCodeGenerateUtil.connect_begin_noUser();
          	 javaCode.append("java.sql.Connection conn_" + cid + "= java.sql.DriverManager.getConnection(" + getConnectionURL() + ");\r\n");
        	}
          else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }        
    protected String getDBMSId() {
        return "oracle_id";
    }
    protected String getLProtectedChar() {
        return "";
    }
    protected String getRProtectedChar() {
        return "";
    }
    protected boolean isOracleKeyword (String keyword) {
        for (int i=0 ; i < oracleKeyWords.length ; i++){
            if (oracleKeyWords[i].equalsIgnoreCase(keyword)) {
            	return true;
            }
        }
    	return false;
    }
    protected String getLProtectedChar(String keyword) {
    	if (isOracleKeyword(keyword)){
    		return "\\\"";
    	}
    	return getLProtectedChar();
    }
    protected String getRProtectedChar(String keyword) {
    	if (isOracleKeyword(keyword)){
    		return "\\\"";
    	}
    	return getRProtectedChar();
    }    
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.retrieveTable());
        if(useExistingConnection) {
            javaCode.append("String dbSchema_" + cid + " = (String)globalMap.get(\"dbschema_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbSchema_" + cid + " = " + dbSchema + ";\r\n");            
        }
        javaCode.append("if(dbSchema_" + cid + " != null && dbSchema_" + cid + ".trim().length() != 0) {");
        javaCode.append("tableName_" + cid + " = dbSchema_" + cid + " + \"" + getLProtectedChar() + "." + getRProtectedChar() + "\" + tableName_" + cid + ";\r\n");
        javaCode.append("}");
        return javaCode.toString();
    }
    
    protected String getConnectionName() {
	    return ElementParameterParser.getValue(node,"__CONNECTION_ORACLE__");
	}
    
    protected String getTableName4Search(boolean useExistingConnection, String connection) {
        return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
    }
    
    protected String getUserName4Search(boolean useExistingConnection, String connection) {
        if (useExistingConnection) {
          return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
        } else {
          return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
        }    
    }

    protected String getShemaName4Search(boolean useExistingConnection, String connection) {
        return "dbSchema_" + cid + ".toUpperCase()"; 
    }   
    
    protected boolean hasSchema() {
        return true;
    }
}
class PostgreManager extends Manager {
    private String host;
    private String port;
    private String dbSchema;
    private boolean useExistingConnection;
    private String connection;
    public PostgreManager(String host, String port, String dbName, String tableName, String dbSchema, String userName, boolean useExistingConnection, String connection, String cid,
            boolean temporary, boolean unlogged) {
        super(dbName, tableName, userName ,cid);
        this.host = host;
        this.port = port;
        this.dbSchema = dbSchema;
        this.useExistingConnection = useExistingConnection;
        this.connection = connection;
        this.temporary = temporary;
        this.unlogged = unlogged;
    }
    protected String getDriver() {
        return "org.postgresql.Driver";
    }
    public String getConnectionURL() {
        return "\"jdbc:postgresql://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }        
    protected String getDBMSId() {
        return "postgres_id";
    }
    protected String getLProtectedChar() {
        return "\\\"";
    }
    protected String getRProtectedChar() {
        return "\\\"";
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.retrieveTable());
        if(useExistingConnection) {
            javaCode.append("String dbSchema_" + cid + " = (String)globalMap.get(\"schema_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbSchema_" + cid + " = " + dbSchema + ";\r\n");            
        }
        javaCode.append("if(dbSchema_" + cid + " != null && dbSchema_" + cid + ".trim().length() != 0) {");
        javaCode.append("tableName_" + cid + " = dbSchema_" + cid + " + \"" + getLProtectedChar() + "." + getRProtectedChar() + "\" + tableName_" + cid + ";\r\n");
        javaCode.append("}");
        return javaCode.toString();        
    }
}
class PostgrePlusManager extends Manager {
    private String host;
    private String port;
    private String dbSchema;
    private boolean useExistingConnection;
    private String connection;        
    public PostgrePlusManager(String host, String port, String dbName, String tableName, String dbSchema, String userName, boolean useExistingConnection, String connection, String cid) {
        super(dbName, tableName, userName ,cid);
        this.host = host;
        this.port = port;
        this.dbSchema = dbSchema;
        this.useExistingConnection = useExistingConnection;
        this.connection = connection;
    }
    protected String getDriver() {
        return "org.postgresql.Driver";
    }
    public String getConnectionURL() {
        return "\"jdbc:postgresql://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }        
    protected String getDBMSId() {
        return "postgresplus_id";
    }
    protected String getLProtectedChar() {
        return "\\\"";
    }
    protected String getRProtectedChar() {
        return "\\\"";
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.retrieveTable());
        if(useExistingConnection) {
            javaCode.append("String dbSchema_" + cid + " = (String)globalMap.get(\"schema_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbSchema_" + cid + " = " + dbSchema + ";\r\n");            
        }
        javaCode.append("if(dbSchema_" + cid + " != null && dbSchema_" + cid + ".trim().length() != 0) {");
        javaCode.append("tableName_" + cid + " = dbSchema_" + cid + " + \"" + getLProtectedChar() + "." + getRProtectedChar() + "\" + tableName_" + cid + ";\r\n");
        javaCode.append("}");
        return javaCode.toString();        
    }    
}
class SQLiteManager extends Manager {
	private boolean useExistingConnection;
	private String connection;
    public SQLiteManager(String dbName, String tableName, String userName, String cid, boolean useExistingConnection, String connection ) {
        super(dbName, tableName, userName, cid);
		this.useExistingConnection = useExistingConnection;
		this.connection = connection;
    }
    protected String getDriver() {
        return "org.sqlite.JDBC";
    }
    public String getConnectionURL() {
        return "\"jdbc:sqlite:/\" + " + dbName;
    }
    protected String getDBMSId() {
        return "sqlite_id";
    }
    protected String getLProtectedChar() {
        return "\\\"";
    }
    protected String getRProtectedChar() {
        return "\\\"";
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }  
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
}
class SybaseManager extends Manager {
    private String host;
    private String port;
    private String dbSchema;
    private boolean useExistingConnection;
	private String connection;
    public SybaseManager(String host, String port, String dbName, String dbSchema, String tableName, String userName, String cid, boolean useExistingConnection, String connection) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.port = port;
        this.dbSchema = dbSchema;
        this.useExistingConnection = useExistingConnection;
		this.connection = connection;
    }
    protected String getDriver() {
        String dbVersion = ElementParameterParser.getValue(node, "__DB_SYBASE_VERSION__");
		    if("SYBSEIQ_16".equals(dbVersion)){
			    return "com.sybase.jdbc4.jdbc.SybDriver";
			    }else{
			    return "com.sybase.jdbc3.jdbc.SybDriver";
			    }
    }
    public String getConnectionURL() {
        return "\"jdbc:sybase:Tds:\" + " + host + "+ \":\" + " + port + "+ \"/\" + " + dbName;
    }
    protected String getDBMSId() {
        return "sybase_id";
    }
    protected String getLProtectedChar() {
        return "";
    }
    protected String getRProtectedChar() {
        return "";
    }
    protected String setNullable(boolean nullable) {
        if(!nullable) {
            return " not null ";
        } else {
            return " null ";
        }
    } 
	public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }  
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }   
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.retrieveTable());
        if(useExistingConnection) {
            javaCode.append("String dbSchema_" + cid + " = (String)globalMap.get(\"dbschema_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbSchema_" + cid + " = " + dbSchema + ";\r\n");            
        }
        javaCode.append("if(dbSchema_" + cid + " != null && dbSchema_" + cid + ".trim().length() != 0) {");
        javaCode.append("tableName_" + cid + " = dbSchema_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + tableName_" + cid + ";\r\n");
        javaCode.append("}");
        return javaCode.toString();        
    }
}
class ODBCManager extends Manager {
    public ODBCManager(String dbName, String tableName, String userName, String cid) {
        super(dbName, tableName, userName, cid);
    }
    protected String getDriver() {
        return "sun.jdbc.odbc.JdbcOdbcDriver";
    }
    public String getConnectionURL() {
        return "\"jdbc:odbc:\" + " + dbName;
    }
    protected String getDBMSId() {
        return "MSODBC";
    }
    protected String getLProtectedChar() {
        return "\\\"";
    }
    protected String getRProtectedChar() {
        return "\\\"";
    }
}
class TeradataManager extends Manager {
    private String host;
    private String port;
    private boolean useExistingConnection;
	private String connection;
    protected TeradataManager(String host, String port, String dbName, String tableName, 
    							String userName, String cid, boolean useExistingConnection, String connection ) {
        super(dbName, tableName, userName, cid);
        this.host = host;
        this.port = port;
        this.useExistingConnection = useExistingConnection;
		this.connection = connection;
    }
    protected String getDriver() {
        return "com.teradata.jdbc.TeraDriver";
    }
    public String getConnectionURL() {
        return "\"jdbc:teradata://\" + " + host;
    }
    protected String getDBMSId() {
        return "teradata_id";
    }
    protected String getLProtectedChar() {
        return "\\\"";
    }
    protected String getRProtectedChar() {
        return "\\\"";
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }  
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
	protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("String tableName_" + cid + " = null;\r\n");
		if(useExistingConnection) {
            javaCode.append("String dbname_" + cid + " = (String)globalMap.get(\"dbname_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbname_" + cid + " = " + dbName + ";\r\n");         
        }
       
        javaCode.append("if ( dbname_" + cid + " == null || dbname_" + cid + ".trim().length() == 0) { \r\n");
        javaCode.append("\t tableName_" + cid + " = " + tableName + ";\r\n");
        javaCode.append(" } else { \r\n");
		javaCode.append("\t tableName_" + cid + " = dbname_" + cid + " + \"\\\".\\\"\" + " + tableName + ";\r\n");
		javaCode.append("}\r\n");
        return javaCode.toString();
    }
    
      public String getCreateTableSQL(List<IMetadataColumn> listColumn) {
        MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
        StringBuilder createTableSQL = new StringBuilder();
        
        String tableType = ElementParameterParser.getValue(node, "__CREATE_TABLE_TYPE__");
        
        createTableSQL.append("CREATE " + tableType + " TABLE " + getLProtectedChar( "\" + tableName_" + cid + " + \"" ) + "\" + tableName_" + cid + " + \"" + getRProtectedChar("\" + tableName_" + cid + " + \"") + "(");
        List<String> pkList = new ArrayList<String>();
        int count = 0;
        String ending = ",";
        for(IMetadataColumn metadataColumn : listColumn) {
            if(metadataColumn.isKey()) {
                pkList.add(getLProtectedChar(metadataColumn.getOriginalDbColumnName()) + metadataColumn.getOriginalDbColumnName() + getRProtectedChar(metadataColumn.getOriginalDbColumnName()));
            }
            createTableSQL.append(getLProtectedChar(metadataColumn.getOriginalDbColumnName()) + metadataColumn.getOriginalDbColumnName() + getRProtectedChar(metadataColumn.getOriginalDbColumnName()) + " ");
            String dataType = null;
            if(metadataColumn.getType() == null || metadataColumn.getType().trim().length() == 0) {
                dataType = mappingType.getDefaultSelectedDbType(metadataColumn.getTalendType());
            } else {
                dataType = metadataColumn.getType();
            }
            if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED") ) {
            	createTableSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ; 
            }else {
            	createTableSQL.append(dataType);
            }            
            Integer length = metadataColumn.getLength() == null ? 0 : metadataColumn.getLength();
            Integer precision = metadataColumn.getPrecision() == null ? 0 : metadataColumn.getPrecision();
            boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
            boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
            String prefix = "";
            String suffix = "";
            String comma = "";
            
            
            if(mappingType.isPreBeforeLength(getDBMSId(),dataType)) {
                if(!precisionIgnored) {
                    prefix = "(";
                    suffix = ") ";
                    createTableSQL.append(prefix + precision);
                }
                if(!lengthIgnored) {
                    prefix = (("").equals(prefix) ? "(" : prefix);
                    suffix = (("").equals(suffix) ? ") " : suffix);
                    if(precisionIgnored) {
                        createTableSQL.append(prefix);
                        comma = "";
                    } else {
                        comma = ",";
                    }
                    createTableSQL.append(comma + length);
                }
                createTableSQL.append(suffix);
            } else {
                if(!lengthIgnored) {                
                	if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) || "greenplum_id".equalsIgnoreCase(getDBMSId()) ) && metadataColumn.getLength() == null) {
                	}else {
	                    prefix = "(";
	                    suffix = ") ";
	                    createTableSQL.append(prefix + length);                	                	
                	}
                }
                if(!precisionIgnored) {
                    prefix = (("").equals(prefix) ? "(" : prefix);
                    suffix = (("").equals(suffix) ? ") " : suffix);
                    if(lengthIgnored) {
                        createTableSQL.append(prefix);
                        comma = "";                        
                    } else {
                        comma = ",";
                    }
                    createTableSQL.append(comma + precision);
                }
                
                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ||"greenplum_id".equalsIgnoreCase(getDBMSId()) ) && metadataColumn.getLength() == null) {                	
                } else {
                	createTableSQL.append(suffix);
                }
                
                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                    createTableSQL.append("UNSIGNED");
                }                
            }
            createTableSQL.append(getDefaultValueSQL(metadataColumn.getDefault()));            
            createTableSQL.append(setNullable(metadataColumn.isNullable()));            
            if(count == listColumn.size() - 1 && pkList.size() == 0) {
                ending = "";
            }
            createTableSQL.append(ending);
            count++;
        }
        if(pkList.size() > 0) {                
            createTableSQL.append("primary key(");                
            int i = 0;                
            for(String pk : pkList) {                    
                createTableSQL.append(pk);                    
                if(i != pkList.size() - 1) {                        
                    createTableSQL.append(",");                        
                }                    
                i++;                    
            }                
            createTableSQL.append(")");                
        }
        createTableSQL.append(")");
        return createTableSQL.toString();
    }
}
class GreenplumManager extends Manager {
    private String host;
    private String port;
    private String dbSchema;
    private boolean useExistingConnection;
    private String connection;        
    public GreenplumManager(String host, String port, String dbName, String tableName, String dbSchema, String userName, boolean useExistingConnection, String connection, String cid) {
        super(dbName, tableName, userName ,cid);
        this.host = host;
        this.port = port;
        this.dbSchema = dbSchema;
        this.useExistingConnection = useExistingConnection;
        this.connection = connection;
    }
    protected String getDriver() {
        return "org.postgresql.Driver";
    }
    public String getConnectionURL() {
        return "\"jdbc:postgresql://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }        
    protected String getDBMSId() {
        return "greenplum_id";
    }
    protected String getLProtectedChar() {
        return "\\\"";
    }
    protected String getRProtectedChar() {
        return "\\\"";
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.retrieveTable());
        if(useExistingConnection) {
            javaCode.append("String dbSchema_" + cid + " = (String)globalMap.get(\"schema_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbSchema_" + cid + " = " + dbSchema + ";\r\n");            
        }
        javaCode.append("if(dbSchema_" + cid + " != null && dbSchema_" + cid + ".trim().length() != 0) {");
        javaCode.append("tableName_" + cid + " = dbSchema_" + cid + " + \"" + getLProtectedChar() + "." + getRProtectedChar() + "\" + tableName_" + cid + ";\r\n");
        javaCode.append("}");
        return javaCode.toString();        
    }
}

class VerticaManager extends Manager {
    private String host;
    private String port;
    private String dbSchema;
    private String db_version;
    private boolean useExistingConnection;
    private String connection;        
    public VerticaManager(String host, String port, String dbName, String tableName, String dbSchema, String userName, boolean useExistingConnection, String connection, String cid, String db_version) {
        super(dbName, tableName, userName ,cid);
        this.host = host;
        this.port = port;
        this.dbSchema = dbSchema;
        this.db_version = db_version;
        this.useExistingConnection = useExistingConnection;
        this.connection = connection;
    }
    protected String getDriver() {
		if("VERTICA_7_1_X".equals(db_version) || "VERTICA_7_0_X".equals(db_version) || "VERTICA_6_1_X".equals(db_version) || "VERTICA_6_0".equals(db_version) || "VERTICA_5_1".equals(db_version)){
			return "com.vertica.jdbc.Driver";
		}else{
			return "com.vertica.Driver";
		}
    }
    public String getConnectionURL() {
        return "\"jdbc:vertica://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }        
    protected String getDBMSId() {
        return "vertica_id";
    }
    protected String getLProtectedChar() {
        return "";
    }
    protected String getRProtectedChar() {
        return "";
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.retrieveTable());
        if(useExistingConnection) {
            javaCode.append("String dbSchema_" + cid + " = (String)globalMap.get(\"dbschema_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbSchema_" + cid + " = " + dbSchema + ";\r\n");            
        }
        javaCode.append("if(dbSchema_" + cid + " != null && dbSchema_" + cid + ".trim().length() != 0) {");
        javaCode.append("tableName_" + cid + " = dbSchema_" + cid + " + \"" + getLProtectedChar() + "." + getRProtectedChar() + "\" + tableName_" + cid + ";\r\n");
        javaCode.append("}");
        return javaCode.toString();        
    }
    public String getDropTableSQL() {
        StringBuilder dropTableSQL = new StringBuilder();
        dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
		boolean useCascade = "true".equals(ElementParameterParser.getValue(node,"__VERTICA_USE_CASCADE__"));
    	if(useCascade){
    		dropTableSQL.append(" cascade ");
    	}
        return dropTableSQL.toString();
    }
    
    public String generateCode(List<IMetadataColumn> columnList){
    	StringBuilder columnListStr = new StringBuilder();
    	for(IMetadataColumn column:columnList){
    		columnListStr.append(column.getOriginalDbColumnName());
			columnListStr.append(",");
    	}
    	int lastCommaIndex = columnListStr.length()-1;
   		if(lastCommaIndex>-1){
   			columnListStr.deleteCharAt(lastCommaIndex);
   		}
		StringBuilder javaCode = new StringBuilder();
		javaCode.append("stmt_" + cid + ".execute(\"CREATE PROJECTION \" + tableName_" + cid + "+\"_proj ("+columnListStr.toString()+") AS SELECT "+columnListStr.toString()+" FROM \" + tableName_" + cid+");");
		return javaCode.toString();
	}
}

class ExasolManager extends Manager {
    private String host;
    private String port;
    private String dbSchema;
    private boolean useExistingConnection;
    private String connection;        
    public ExasolManager(String host, String port, String dbSchema, String tableName, String userName, boolean useExistingConnection, String connection, String cid) {
        super(null, tableName, userName ,cid);
        this.host = host;
        this.port = port;
        this.dbSchema = dbSchema;
        this.useExistingConnection = useExistingConnection;
        this.connection = connection;
    }
    protected String getDriver() {
        return "com.exasol.jdbc.EXADriver";
    }
    public String getConnectionURL() {
    	
        return "\"jdbc:exa:\" + " + host + " + \":\" + " + port + " + \";schema=\"  + " + dbSchema;
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }        
    protected String getDBMSId() {
        return "Exasol_id";
    }
    protected String getLProtectedChar() {
        return "";
    }
    protected String getRProtectedChar() {
    	return "";
    }
    
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.retrieveTable());
        if(useExistingConnection) {
            javaCode.append("String dbSchema_" + cid + " = (String)globalMap.get(\"dbschema_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbSchema_" + cid + " = " + dbSchema + ";\r\n");            
        }
        javaCode.append("if(dbSchema_" + cid + " != null && dbSchema_" + cid + ".trim().length() != 0) {\r\n");
        javaCode.append("tableName_" + cid + " = dbSchema_" + cid + "+\".\"+" +  "tableName_" + cid + ";\r\n");
        javaCode.append("}");
        return javaCode.toString();        
    }
    
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
   
}

class RedshiftManager extends Manager {
    private String host;
    private String port;
    private String dbSchema;
    private boolean useExistingConnection;
    private String connection;        
    public RedshiftManager(String host, String port, String dbName, String tableName, String dbSchema, String userName, boolean useExistingConnection, String connection, String cid) {
        super(dbName, tableName, userName ,cid);
        this.host = host;
        this.port = port;
        this.dbSchema = dbSchema;
        this.useExistingConnection = useExistingConnection;
        this.connection = connection;
    }
    protected String getDriver() {
        return "com.amazon.redshift.jdbc41.Driver";
    }
    public String getConnectionURL() {
        return "\"jdbc:redshift://\" + " + host + " + \":\" + " + port + " + \"/\" + " + dbName;
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"conn_" + connection + "\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }        
    protected String getDBMSId() {
        return "redshift_id";
    }
    protected String getLProtectedChar() {
        return "\\\"";
    }
    protected String getRProtectedChar() {
        return "\\\"";
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    }
    protected String retrieveTable() {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(super.retrieveTable());
        if(useExistingConnection) {
            javaCode.append("String dbSchema_" + cid + " = (String)globalMap.get(\"schema_" + connection + "\");\r\n"); 
        } else {
            javaCode.append("String dbSchema_" + cid + " = " + dbSchema + ";\r\n");            
        }
        javaCode.append("if(dbSchema_" + cid + " != null && dbSchema_" + cid + ".trim().length() != 0) {");
        javaCode.append("tableName_" + cid + " = dbSchema_" + cid + " + \"" + getLProtectedChar() + "." + getRProtectedChar() + "\" + tableName_" + cid + ";\r\n");
        javaCode.append("}");
        return javaCode.toString();        
    }    
}

class SnowflaketManager extends Manager {
    private String account;
    private String warehouse;
    private String role;
    private String dbSchema;
    private boolean useExistingConnection;
    private String connection;
    boolean enforceDelimitedIdentifiers;
    public SnowflaketManager(String account,String dbName,String dbSchema, String userName,String role,String tableName, String connection, boolean useExistingConnection, String cid, boolean enforceDelimitedIdentifiers) {
        super(dbName, tableName, userName , cid);
        this.account=account;
        this.role=role;
        this.dbSchema=dbSchema;
        this.connection=connection;
        this.useExistingConnection=useExistingConnection;
        this.enforceDelimitedIdentifiers=enforceDelimitedIdentifiers;
    }
    protected String getDriver() {
        return "net.snowflake.client.jdbc.SnowflakeDriver";
    }
    public String getConnectionURL() {
        StringBuilder stringBuilder = new StringBuilder("\"jdbc:snowflake://\"");

        if (isPropertyValueEmpty(account)) {
            throw new IllegalArgumentException("Missing account");
        }else{
        		stringBuilder.append("+"+account+"+");
        }
        stringBuilder.append("\".snowflakecomputing.com/?\"+");
        if(!isPropertyValueEmpty(warehouse) && !("\"\"").equals(warehouse)){
            stringBuilder.append("\"warehouse=\"");
            stringBuilder.append("+"+warehouse+"+");
            stringBuilder.append("\"&\"+");
        }
        if (isPropertyValueEmpty(dbName)) {
            throw new IllegalArgumentException("Missing database");
        }else{
        		stringBuilder.append("\"db=\"");
            stringBuilder.append("+"+dbName+"+");
            stringBuilder.append("\"&\"+");
        }
        if (isPropertyValueEmpty(dbSchema)) {
            throw new IllegalArgumentException("Missing dbSchema");
        }else{
        		stringBuilder.append("\"schema=\"");
            stringBuilder.append("+"+dbSchema);
        }
        if(!isPropertyValueEmpty(role) && !("\"\"").equals(role)){
            stringBuilder.append("+\"&\"+");
            stringBuilder.append("\"role=\"");
            stringBuilder.append("+"+role);
        }

        return stringBuilder.toString();
    }
    private boolean isPropertyValueEmpty(String propertyValue) {
        if (propertyValue != null && !propertyValue.isEmpty()) {
            return false;
        }
        return true;
    }
    public String getConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append(retrieveTable());
            javaCode.append("java.sql.Connection conn_" + cid + " = (java.sql.Connection)globalMap.get(\"" + connection + "_Connection\");");
        } else {
            javaCode.append(super.getConnection());
        }
        return javaCode.toString();
    }        
    protected String getDBMSId() {
        return "snowflake_id";
    }
    protected String getLProtectedChar() {
        return enforceDelimitedIdentifiers ? "\\\"" : "";
    }
    protected String getRProtectedChar() {
        return enforceDelimitedIdentifiers ? "\\\""  :"";
    }
    public String closeConnection() {
        StringBuilder javaCode = new StringBuilder();
        if(useExistingConnection) {
            javaCode.append("");
        } else {
            javaCode.append(super.closeConnection());            
        }
        return javaCode.toString();
    } 
}

class StringUtil {
    public String getString(String source) {
        String tmp = null;
        if(source == null || ("").equals(source) || ("\"\"").equals(source)) {
            tmp = "";
        } else {
            if(source.startsWith("\"") && source.endsWith("\"")) {
                tmp = source.substring(1, source.length() - 1);
            } else {
                tmp = source;
            }
        }
        return tmp;
    }
}
class ManagerFactory {
    private StringUtil stringUtil = new StringUtil();
    public Manager createManager(String dbType, INode node) {
        Manager manager = null;
        String cid = node.getUniqueName();
        String tableName = ElementParameterParser.getValue(node,"__TABLE__");
        if(("ACCESS").equals(dbType)) {
            String dbName = ElementParameterParser.getValue(node, "__DBFILE_ACCESS__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
			String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_ACCESS__"));
            manager = new AccessManager(dbName, tableName, userName, cid,dbproperties,useExistingConnection, connection);
        } else if(("AS400").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
			String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_AS400__"));
            manager = new AS400Manager(host, dbName, tableName, userName, cid,dbproperties,useExistingConnection, connection);
        } else if(("DB2").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
			String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_DB2__"));
            manager = new DB2Manager(host, port, dbName, tableName, userName, cid, dbSchema,useExistingConnection, connection);
        } else if(("FIREBIRD").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String dbName = ElementParameterParser.getValue(node, "__DBFILE_FIREBIRD__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
			String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_FIREBIRD__"));
            manager = new FirebirdManager(host, dbName, tableName, userName, cid, useExistingConnection, connection);
        } else if(("HSQLDB").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbPath = ElementParameterParser.getValue(node, "__DBPATH_HSQL__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME_HSQL__");
            String dbAlias = ElementParameterParser.getValue(node, "__DATABASE_ALIAS__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            String runningMode = ElementParameterParser.getValue(node, "__RUNNING_MODE__");
            boolean tls = ("true").equals(ElementParameterParser.getValue(node, "__TLS__"));
            manager = new HSQLDBManager(host, port, dbPath, dbName, tableName, dbAlias, userName, runningMode, tls, cid);
        } else if(("INFORMIX").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String dbServer = ElementParameterParser.getValue(node, "__DBSERVER__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
			String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
			boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
			String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_INFORMIX__"));
            manager = new InformixManager(host, port, dbName, tableName, dbServer, userName, cid, dbSchema,useExistingConnection, connection);
        } else if(("INGRES").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
			String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_INGRES__"));
            manager = new IngresManager(host, port, dbName, tableName, userName, cid,useExistingConnection, connection);
        } else if(("INTERBASE").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String dbName = ElementParameterParser.getValue(node, "__DBFILE_INTERBASE__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
			String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_INTERBASE__"));
            manager = new InterbaseManager(host, dbName, tableName, userName, cid,useExistingConnection, connection);
        } else if(("JAVADB").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbRootPath = ElementParameterParser.getValue(node, "__DBROOTPATH__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME_JAVADB__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            String frameworkType = ElementParameterParser.getValue(node, "__FRAMEWORK_TYPE__");
            boolean connectionFlag = ("true").equals(ElementParameterParser.getValue(node, "__CONNECTION_FLAG__"));
            manager = new JavaDBManager(host, port, dbRootPath, dbName, tableName, userName, frameworkType, connectionFlag, cid);
        } else if(("MAXDB").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            manager = new MaxDBManager(host, port, dbName, tableName, userName, cid);
        } else if(("MSSQL").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
            String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_MSSQL__"));
            String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
            String driver = ElementParameterParser.getValue(node, "__MSSQL_DRIVER__");
            manager = new MSSQLManager(host, port, dbName,dbSchema, tableName, userName, useExistingConnection, connection, cid, dbproperties, driver);
        } else if(("MYSQL").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
            String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_MYSQL__"));
            boolean temporary = ("true").equals(ElementParameterParser.getValue(node, "__TEMPTABLE__"));
            String dbVersion = ElementParameterParser.getValue(node, "__DB_MYSQL_VERSION__");
            manager = new MysqlManager(host, port, dbName, tableName, userName, useExistingConnection, connection, temporary, cid, dbVersion);
        } else if(("NETEZZA").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
            String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_NETEZZA__"));
            manager = new NetezzaManager(host, port, dbName, tableName, userName, useExistingConnection, connection, cid);
        } else if(("DBORACLE").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
            String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_ORACLE__"));
             String jdbcURL = ElementParameterParser.getValue(node, "__JDBC_URL__");
            String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
            String rac_url = ElementParameterParser.getValue(node, "__RAC_URL__");
            String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");;
            manager = new OracleManager(host, port, dbName, tableName, dbSchema, userName, connectionType, useExistingConnection, connection,cid,jdbcURL,rac_url,localServiceName,dbVersion);
            } else if(("POSTGRE").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
            String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_POSTGRE__"));
            boolean tempTable = ("true").equals(ElementParameterParser.getValue(node, "__TEMPTABLE__"));
            boolean unloggedTable = ("true").equals(ElementParameterParser.getValue(node, "__UNLOGGED__"));
            manager = new PostgreManager(host, port, dbName, tableName, dbSchema, userName, useExistingConnection, connection, cid, tempTable, unloggedTable);
        } else if(("POSTGREPLUS").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
            String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_POSTGREPLUS__"));
            manager = new PostgrePlusManager(host, port, dbName, tableName, dbSchema, userName, useExistingConnection, connection, cid);            
        } else if(("SQLITE").equals(dbType)) {
            String dbName = ElementParameterParser.getValue(node, "__DBFILE_SQLITE__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
			String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_SQLITE__"));
            manager = new SQLiteManager(dbName, tableName, userName, cid,useExistingConnection, connection);
        } else if(("SYBASE").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
			String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_SYBASE__"));
            manager = new SybaseManager(host, port, dbName, dbSchema, tableName, userName, cid,useExistingConnection, connection);
        } else if(("TERADATA").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
			String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_TERADATA__"));
            manager = new TeradataManager(host, port, dbName, tableName, userName, cid,useExistingConnection, connection);
            manager.setNode(node);
        } else if(("ODBC").equals(dbType)) {
            String odbcName = ElementParameterParser.getValue(node, "__ODBCNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            manager = new ODBCManager(odbcName, tableName, userName, cid);
        }else if(("GREENPLUM").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
            String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_"+dbType+"__"));
            manager = new GreenplumManager(host, port, dbName, tableName, dbSchema, userName, useExistingConnection, connection, cid);
        } else if(("VERTICA").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String db_version = ElementParameterParser.getValue(node, "__DB_VERTICA_VERSION__");
            String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
            String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_"+dbType+"__"));
            manager = new VerticaManager(host, port, dbName, tableName, dbSchema, userName, useExistingConnection, connection, cid,db_version);
        } else if(("EXASOL").equals(dbType)) {
        	 String host = ElementParameterParser.getValue(node, "__HOST__");
             String port = ElementParameterParser.getValue(node, "__PORT__");
             String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
             String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
             String userName = ElementParameterParser.getValue(node, "__USER__");
             boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
             String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_"+dbType+"__"));
             manager = new ExasolManager(host, port, dbSchema, tableName, userName, useExistingConnection, connection, cid);
        } else if(("REDSHIFT").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
            String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_"+dbType+"__"));
            manager = new RedshiftManager(host, port, dbName, tableName, dbSchema, userName, useExistingConnection, connection, cid);
        } else if(("SNOWFLAKE").equals(dbType)) {
            String host = ElementParameterParser.getValue(node, "__HOST__");
            String port = ElementParameterParser.getValue(node, "__PORT__");
            String dbSchema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
            String account = ElementParameterParser.getValue(node, "__ACCOUNT__");
            String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
            String userName = ElementParameterParser.getValue(node, "__USER__");
            String role = ElementParameterParser.getValue(node, "__ROLE__");
            boolean enforceDelimitedIdentifiers = ("true").equals(ElementParameterParser.getValue(node, "__ENFORCE_DELIMITED_IDENTIFIERS__"));
            boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
            String connection = stringUtil.getString(ElementParameterParser.getValue(node, "__CONNECTION_"+dbType+"__"));
            manager = new SnowflaketManager(account,dbName,dbSchema, userName,role,tableName, connection, useExistingConnection, cid, enforceDelimitedIdentifiers);
        }
        return manager;
    }
}
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    columnList = metadata.getListColumns();
}
if(columnList != null && columnList.size() > 0) {
    boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();
    String dbType = ElementParameterParser.getValue(node,"__DBTYPE__");    
    ManagerFactory factory = new ManagerFactory();
    Manager manager = factory.createManager(dbType,node);
    manager.setNode(node);
    String tableAction = ElementParameterParser.getValue(node,"__TABLEACTION__");
    String cid = node.getUniqueName();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    boolean tableNameCaseSensitive=false;
    if("DB2".equalsIgnoreCase(dbType)||"POSTGRE".equalsIgnoreCase(dbType)||"POSTGREPLUS".equalsIgnoreCase(dbType)||"GREENPLUM".equalsIgnoreCase(dbType)){
    	tableNameCaseSensitive=true;
    }
    if(("HSQLDB").equals(dbType)){
        tableNameCaseSensitive = "true".equals(ElementParameterParser.getValue(node,"__CASESENSITIVE__")); 
    }
    String createProjectionStr = "";
    if("VERTICA".equals(dbType)){
	    boolean createProjection = "true".equals(ElementParameterParser.getValue(node,"__VERTICA_CREATE_PROJECTION__"));
	    if(createProjection){
	    	createProjectionStr = ((VerticaManager)manager).generateCode(columnList);
	    }
    }
    
    stringBuffer.append(TEXT_76);
    
        boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
        if(!useExistingConnection) {
        
    stringBuffer.append(TEXT_77);
    stringBuffer.append(manager.difineConnParam());
    
            log4jCodeGenerateUtil.debugConnectionParams(node);
            //log4jCodeGenerateUtil.connect_begin();
        }
        
    stringBuffer.append(TEXT_78);
    stringBuffer.append(manager.getConnection());
    
        if(useExistingConnection) {
            log4jCodeGenerateUtil.useExistConnection(node);
        }else{
            log4jCodeGenerateUtil.connect_end();
        }
        if(("CREATE_TABLE").equals(tableAction)) {
            
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(manager.getCreateTableSQL(columnList));
    stringBuffer.append(TEXT_87);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(createProjectionStr);
    
        } else {
            String tableName = ElementParameterParser.getValue(node,"__TABLE__");
            
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
            if("DBORACLE".equalsIgnoreCase(dbType)) {
			
    stringBuffer.append(TEXT_94);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
            } else if("DB2".equalsIgnoreCase(dbType)){

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_124);
    }
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
    
            } else if ("GREENPLUM".equalsIgnoreCase(dbType) || "POSTGRE".equalsIgnoreCase(dbType) || "POSTGREPLUS".equalsIgnoreCase(dbType)) {
                if ("true".equals(ElementParameterParser.getValue(node, "__TEMPTABLE__"))) {

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
                } else {

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_163);
    }
    stringBuffer.append(TEXT_164);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_167);
    }
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
                }
            } else if ("MSSQL".equalsIgnoreCase(dbType)){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
            } else if ( "SYBASE".equalsIgnoreCase(dbType)
						|| "INFORMIX".equalsIgnoreCase(dbType) ) {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_195);
    }
    stringBuffer.append(TEXT_196);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_199);
    }
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
			} else if ("TERADATA".equalsIgnoreCase(dbType)) {
					if (useExistingConnection) {

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CONNECTION_TERADATA__"));
    stringBuffer.append(TEXT_206);
    
					}

    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_218);
    }
    stringBuffer.append(TEXT_219);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_222);
    }
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
				} else if ("SNOWFLAKE".equalsIgnoreCase(dbType)) {
				    boolean enforceDelimitedIdentifiers = ("true").equals(ElementParameterParser.getValue(node, "__ENFORCE_DELIMITED_IDENTIFIERS__"));

    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(enforceDelimitedIdentifiers?"":".toUpperCase()");
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    
            } else if("MYSQL".equalsIgnoreCase(dbType)) {
                boolean useExistMySQLConn = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
                String dbnameMySQL = "";
                if (useExistMySQLConn) {
                    List< ? extends INode> nodes =  node.getProcess().getNodesOfType("tMysqlConnection");
                    String connectionMySQL = ElementParameterParser.getValue(node,"__CONNECTION__");
                    for (INode ne : nodes) {
                        if (connectionMySQL.equals(ne.getUniqueName())) {
                            dbnameMySQL = ElementParameterParser.getValue(ne, "__DBNAME__");
                        }
                    }
                } else {
                    dbnameMySQL = ElementParameterParser.getValue(node, "__DBNAME__");
                }
                if (dbnameMySQL == null || dbnameMySQL.isEmpty()) dbnameMySQL = "\"\"";
            
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(dbnameMySQL);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_250);
    }
    stringBuffer.append(TEXT_251);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    
            } else {
            
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_263);
    }
    stringBuffer.append(TEXT_264);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    
            }
            
            
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    
            if(("CREATE_IF_NOT_EXIST").equals(tableAction)) {
                
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    }
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(manager.getCreateTableSQL(columnList));
    stringBuffer.append(TEXT_278);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    }
    stringBuffer.append(TEXT_282);
    stringBuffer.append(createProjectionStr);
    stringBuffer.append(TEXT_283);
    
            } else if(("DROP_IF_EXIST_CREATE").equals(tableAction)) {
                
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    }
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_293);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    }
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    }
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(manager.getCreateTableSQL(columnList));
    stringBuffer.append(TEXT_305);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    }
    stringBuffer.append(TEXT_309);
    stringBuffer.append(createProjectionStr);
    
            }
        }
        log4jCodeGenerateUtil.close_begin();
        
    stringBuffer.append(TEXT_310);
    stringBuffer.append(manager.closeConnection());
    log4jCodeGenerateUtil.close_end();
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(manager.getCreateTableSQL(columnList));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    
}

    stringBuffer.append(TEXT_315);
    stringBuffer.append(TEXT_316);
    return stringBuffer.toString();
  }
}