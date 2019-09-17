package org.talend.designer.codegen.translators.databases.dbspecifics.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;

public class THiveInputBeginJava
{
  protected static String nl;
  public static synchronized THiveInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveInputBeginJava result = new THiveInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
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
  protected final String TEXT_30 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_31 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_32 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_34 = " - Uses an existing connection ";
  protected final String TEXT_35 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_37 = " - Uses an existing connection. Connection URL: \" + conn_";
  protected final String TEXT_38 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_40 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_41 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_42 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\tconn_";
  protected final String TEXT_45 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_46 = ", dbUser_";
  protected final String TEXT_47 = ", dbPwd_";
  protected final String TEXT_48 = ");" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\tconn_";
  protected final String TEXT_50 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_51 = ");" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\tconn_";
  protected final String TEXT_53 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\tconn_";
  protected final String TEXT_55 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\tconn_";
  protected final String TEXT_57 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\tconn_";
  protected final String TEXT_59 = ".setAutoCommit(";
  protected final String TEXT_60 = ");" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\tlog.";
  protected final String TEXT_62 = "(\"";
  protected final String TEXT_63 = " - \" + ";
  protected final String TEXT_64 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "\t    \t\tlog.";
  protected final String TEXT_66 = "(\"";
  protected final String TEXT_67 = "\");" + NL + "\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_69 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_71 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_72 = ": pstmt_";
  protected final String TEXT_73 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_74 = " += (countEach_";
  protected final String TEXT_75 = " < 0 ? 0 : ";
  protected final String TEXT_76 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_77 = NL + "            java.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_78 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_79 = ") {";
  protected final String TEXT_80 = NL + "    \t\t\tString dsAlias_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";" + NL + "        \t\tif (dataSources_";
  protected final String TEXT_83 = ".get(dsAlias_";
  protected final String TEXT_84 = ") == null) {" + NL + "           \t\t\tthrow new RuntimeException(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_85 = " + \" available!\");" + NL + "              \t}" + NL + "        \t\tconn_";
  protected final String TEXT_86 = " = dataSources_";
  protected final String TEXT_87 = ".get(dsAlias_";
  protected final String TEXT_88 = ").getConnection();" + NL + "            } else {";
  protected final String TEXT_89 = NL + "\t\t\t\tString driverClass_";
  protected final String TEXT_90 = " = \"";
  protected final String TEXT_91 = "\";" + NL + "\t\t\t    java.lang.Class.forName(driverClass_";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL + "\t\t\t\t\tString dbUser_";
  protected final String TEXT_94 = " = ";
  protected final String TEXT_95 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_97 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_98 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = "; ";
  protected final String TEXT_103 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tString dbPwd_";
  protected final String TEXT_104 = " = decryptedPassword_";
  protected final String TEXT_105 = ";";
  protected final String TEXT_106 = NL + "\t\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\tconn_";
  protected final String TEXT_109 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_110 = ",dbUser_";
  protected final String TEXT_111 = ",dbPwd_";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "\t\t\t\tconn_";
  protected final String TEXT_114 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "\t\t        ";
  protected final String TEXT_117 = NL + "\t\t    }";
  protected final String TEXT_118 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_119 = " = conn_";
  protected final String TEXT_120 = ".createStatement();";
  protected final String TEXT_121 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_122 = " = conn_";
  protected final String TEXT_123 = ".createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjava.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\t\ttmpContent_";
  protected final String TEXT_125 = " = rs_";
  protected final String TEXT_126 = ".getString(";
  protected final String TEXT_127 = "column_index_";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "                        if(tmpContent_";
  protected final String TEXT_130 = " != null) {" + NL + "                            tmpContent_";
  protected final String TEXT_131 = " = tmpContent_";
  protected final String TEXT_132 = ";" + NL + "                        }";
  protected final String TEXT_133 = NL + "                    if(tmpContent_";
  protected final String TEXT_134 = " != null && tmpContent_";
  protected final String TEXT_135 = ".length() > 0) {\t\t\t  \t";
  protected final String TEXT_136 = NL + "                        ";
  protected final String TEXT_137 = ".";
  protected final String TEXT_138 = " = tmpContent_";
  protected final String TEXT_139 = ".charAt(0);\t\t\t  \t\t" + NL + "                    } else {\t\t\t  \t";
  protected final String TEXT_140 = "\t\t\t  \t    " + NL + "                            if(tmpContent_";
  protected final String TEXT_141 = " == null) {\t\t\t  \t   \t";
  protected final String TEXT_142 = NL + "                                ";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = " = null;\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t";
  protected final String TEXT_145 = NL + "                                ";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            }";
  protected final String TEXT_148 = "\t\t\t  \t\t" + NL + "                            if((\"\").equals(tmpContent_";
  protected final String TEXT_149 = ")) {\t\t\t  \t\t";
  protected final String TEXT_150 = NL + "                                ";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            } else {" + NL + "        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_153 = "' in '";
  protected final String TEXT_154 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "                            }\t\t\t  \t\t";
  protected final String TEXT_155 = NL + "                    }";
  protected final String TEXT_156 = NL + "\t\t\t";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = " = routines.system.JDBCUtil.getDate(rs_";
  protected final String TEXT_159 = ", ";
  protected final String TEXT_160 = "column_index_";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "        \t";
  protected final String TEXT_163 = ".";
  protected final String TEXT_164 = " = routines.system.JDBCUtil.getString(rs_";
  protected final String TEXT_165 = ", ";
  protected final String TEXT_166 = "column_index_";
  protected final String TEXT_167 = ", ";
  protected final String TEXT_168 = "false";
  protected final String TEXT_169 = "true";
  protected final String TEXT_170 = ");";
  protected final String TEXT_171 = NL + "            if(rs_";
  protected final String TEXT_172 = ".getObject(";
  protected final String TEXT_173 = "column_index_";
  protected final String TEXT_174 = ") != null) {";
  protected final String TEXT_175 = NL + "                ";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = " = rs_";
  protected final String TEXT_178 = ".get";
  protected final String TEXT_179 = "(";
  protected final String TEXT_180 = "column_index_";
  protected final String TEXT_181 = ");" + NL + "            } else {";
  protected final String TEXT_182 = NL + "                    ";
  protected final String TEXT_183 = ".";
  protected final String TEXT_184 = " = null;";
  protected final String TEXT_185 = NL + "                    throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_186 = NL + "            }";
  protected final String TEXT_187 = NL + NL + "\t";
  protected final String TEXT_188 = NL + "\t\t\tString dbname_";
  protected final String TEXT_189 = " = (String)globalMap.get(\"";
  protected final String TEXT_190 = "\");" + NL + "        \tif(dbname_";
  protected final String TEXT_191 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_192 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_193 = ".trim())) {" + NL + "            \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_194 = " = conn_";
  protected final String TEXT_195 = ".createStatement();" + NL + "            \tgoToDatabase_";
  protected final String TEXT_196 = ".execute(\"use \" + dbname_";
  protected final String TEXT_197 = ");" + NL + "            \tgoToDatabase_";
  protected final String TEXT_198 = ".close();" + NL + "        \t}" + NL + "" + NL + "        \tString dbUser_";
  protected final String TEXT_199 = " = (String)globalMap.get(\"";
  protected final String TEXT_200 = "\");" + NL + "        \tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_201 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "    \t\tif(dbUser_";
  protected final String TEXT_202 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_203 = ".trim())) {" + NL + "    \t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_204 = ");" + NL + "    \t\t\t//make relative file path work for hive" + NL + "    \t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "    \t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_205 = ");" + NL + "    \t\t}";
  protected final String TEXT_206 = NL + "\t\t\t\tif(true) {" + NL + "\t\t\t\t\tthrow new java.lang.Exception(\"The distribution ";
  protected final String TEXT_207 = " does not support this version of Hive . Please check your component configuration.\");" + NL + "\t\t\t\t}";
  protected final String TEXT_208 = NL + "\t\t\t\tif(true) {" + NL + "\t\t\t\t\tthrow new java.lang.Exception(\"The distribution ";
  protected final String TEXT_209 = " does not support this connection mode . Please check your component configuration.\");" + NL + "\t\t\t\t}";
  protected final String TEXT_210 = NL + "\t\t\t\tif(true) {" + NL + "\t\t\t\t\tthrow new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t\t}";
  protected final String TEXT_211 = NL + "\t\t\tjava.sql.Statement init_";
  protected final String TEXT_212 = " = conn_";
  protected final String TEXT_213 = ".createStatement();";
  protected final String TEXT_214 = NL + "\t        \tinit_";
  protected final String TEXT_215 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_216 = ");" + NL + "\t\t    \tinit_";
  protected final String TEXT_217 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_218 = ");";
  protected final String TEXT_219 = NL + "\t\t\t\tinit_";
  protected final String TEXT_220 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_221 = ");";
  protected final String TEXT_222 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_223 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_224 = ");";
  protected final String TEXT_225 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_226 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_227 = ");";
  protected final String TEXT_228 = NL + "            \t\tinit_";
  protected final String TEXT_229 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "            \t\tinit_";
  protected final String TEXT_230 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_231 = ");";
  protected final String TEXT_232 = NL + "        \t\t\tinit_";
  protected final String TEXT_233 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_234 = ");" + NL + "        \t\t\t";
  protected final String TEXT_235 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_236 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_237 = ");";
  protected final String TEXT_238 = NL + "\t                init_";
  protected final String TEXT_239 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");" + NL + "\t                init_";
  protected final String TEXT_240 = ".execute(\"SET dfs.datanode.use.datanode.hostname=true\");" + NL + "\t                ";
  protected final String TEXT_241 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_242 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_243 = ");";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\tinit_";
  protected final String TEXT_245 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\tinit_";
  protected final String TEXT_247 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t\t\t\t\t\tinit_";
  protected final String TEXT_248 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_249 = NL + "\t\t\t\t\t\tinit_";
  protected final String TEXT_250 = ".execute(\"SET mapreduce.application.classpath=";
  protected final String TEXT_251 = "\");";
  protected final String TEXT_252 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_253 = ".execute(\"SET yarn.application.classpath=";
  protected final String TEXT_254 = "\");";
  protected final String TEXT_255 = NL + "        \t\t\tinit_";
  protected final String TEXT_256 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_257 = ");" + NL + "        \t\t\tinit_";
  protected final String TEXT_258 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_259 = ");" + NL + "        \t\t\tinit_";
  protected final String TEXT_260 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_261 = ");";
  protected final String TEXT_262 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_263 = ".execute(\"SET \"+";
  protected final String TEXT_264 = "+\"=\"+";
  protected final String TEXT_265 = ");";
  protected final String TEXT_266 = NL + "\t\t\t";
  protected final String TEXT_267 = NL + "            \t";
  protected final String TEXT_268 = NL;
  protected final String TEXT_269 = NL + "    \t\tinit_";
  protected final String TEXT_270 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_271 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_272 = NL;
  protected final String TEXT_273 = NL + "        String username_";
  protected final String TEXT_274 = " = (";
  protected final String TEXT_275 = " != null && !\"\".equals(";
  protected final String TEXT_276 = ")) ? ";
  protected final String TEXT_277 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_278 = " = null;";
  protected final String TEXT_279 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_280 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_281 = ".set(\"";
  protected final String TEXT_282 = "\", ";
  protected final String TEXT_283 = ");" + NL + "        ";
  protected final String TEXT_284 = NL + "            conf_";
  protected final String TEXT_285 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_286 = NL + "        \t\tconf_";
  protected final String TEXT_287 = ".set(";
  protected final String TEXT_288 = " ,";
  protected final String TEXT_289 = ");" + NL + "        \t";
  protected final String TEXT_290 = NL + "            username_";
  protected final String TEXT_291 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_292 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_293 = ");" + NL + "    \t\t";
  protected final String TEXT_294 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_295 = ", ";
  protected final String TEXT_296 = ");" + NL + "    \t\t";
  protected final String TEXT_297 = NL + "\t\t\tconf_";
  protected final String TEXT_298 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_299 = "+\",\"+username_";
  protected final String TEXT_300 = ");" + NL + "        \tfs_";
  protected final String TEXT_301 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_302 = ");";
  protected final String TEXT_303 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_304 = " == null || \"\".equals(username_";
  protected final String TEXT_305 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_306 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_307 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_308 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_309 = ".get(\"";
  protected final String TEXT_310 = "\")),conf_";
  protected final String TEXT_311 = ",username_";
  protected final String TEXT_312 = ");" + NL + "        \t}\t";
  protected final String TEXT_313 = NL + "                    String hdfsUserName_";
  protected final String TEXT_314 = " = (";
  protected final String TEXT_315 = " != null && !\"\".equals(";
  protected final String TEXT_316 = ")) ? ";
  protected final String TEXT_317 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_318 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_319 = " + \"/talend_tez_libs/";
  protected final String TEXT_320 = "\";";
  protected final String TEXT_321 = NL + "                    String tezLibPath_";
  protected final String TEXT_322 = " = ";
  protected final String TEXT_323 = ";";
  protected final String TEXT_324 = NL + "                fs_";
  protected final String TEXT_325 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_326 = "));";
  protected final String TEXT_327 = NL + "                String[] classPaths_";
  protected final String TEXT_328 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_329 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_330 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_331 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_332 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_333 = " : classPaths_";
  protected final String TEXT_334 = "){";
  protected final String TEXT_335 = NL + "                        if(classPath_";
  protected final String TEXT_336 = ".endsWith(\"";
  protected final String TEXT_337 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_338 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_339 = " + \"/";
  protected final String TEXT_340 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_341 = ".exists(tezJarPath_";
  protected final String TEXT_342 = ")){" + NL + "                                fs_";
  protected final String TEXT_343 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_344 = "), tezJarPath_";
  protected final String TEXT_345 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_346 = NL + "                }";
  protected final String TEXT_347 = NL + "                String tezLibPath_";
  protected final String TEXT_348 = " = ";
  protected final String TEXT_349 = ";";
  protected final String TEXT_350 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_351 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_352 = " = tezLibPath_";
  protected final String TEXT_353 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_354 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_355 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_356 = " : tezLibPaths_";
  protected final String TEXT_357 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_358 = ".append(";
  protected final String TEXT_359 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_360 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_361 = " < tezLibPaths_";
  protected final String TEXT_362 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_363 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_364 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_365 = ".execute(script_";
  protected final String TEXT_366 = ".toString());" + NL + "\t\t";
  protected final String TEXT_367 = NL + "            \t";
  protected final String TEXT_368 = NL + NL + "\t\t\tinit_";
  protected final String TEXT_369 = ".close();" + NL + "" + NL + "        \tString dbname_";
  protected final String TEXT_370 = " = ";
  protected final String TEXT_371 = ";" + NL + "        \tif(dbname_";
  protected final String TEXT_372 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_373 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_374 = ".trim())) {" + NL + "            \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_375 = " = conn_";
  protected final String TEXT_376 = ".createStatement();" + NL + "            \tgoToDatabase_";
  protected final String TEXT_377 = ".execute(\"use \" + dbname_";
  protected final String TEXT_378 = ");" + NL + "            \tgoToDatabase_";
  protected final String TEXT_379 = ".close();" + NL + "        \t}";
  protected final String TEXT_380 = NL + "    \t\t\tjava.sql.Statement statement_";
  protected final String TEXT_381 = " = conn_";
  protected final String TEXT_382 = ".createStatement();" + NL + "        \t\t";
  protected final String TEXT_383 = NL + "        \t\t\tstatement_";
  protected final String TEXT_384 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_385 = ");" + NL + "        \t\t";
  protected final String TEXT_386 = NL + NL + "        \t\t";
  protected final String TEXT_387 = NL + "        \t\t\tstatement_";
  protected final String TEXT_388 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_389 = ");" + NL + "        \t\t";
  protected final String TEXT_390 = NL + NL + "\t\t\t\t";
  protected final String TEXT_391 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_392 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_393 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_394 = NL + NL + "\t\t\t\t";
  protected final String TEXT_395 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_396 = ".execute(\"SET hbase.security.authentication=kerberos\");" + NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_397 = ".execute(\"SET hbase.rpc.engine=org.apache.hadoop.hbase.ipc.SecureRpcEngine\");" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_398 = NL + "\t\t\t\t\t\tstatement_";
  protected final String TEXT_399 = ".execute(\"SET hbase.master.kerberos.principal=\"+";
  protected final String TEXT_400 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_401 = NL + "\t\t\t\t\t";
  protected final String TEXT_402 = NL + "\t\t\t\t\t\tstatement_";
  protected final String TEXT_403 = ".execute(\"SET hbase.regionserver.kerberos.principal=\"+";
  protected final String TEXT_404 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_405 = NL + "\t\t\t\t";
  protected final String TEXT_406 = NL + NL + "        \t\t";
  protected final String TEXT_407 = NL + "    \t\t\t\tstatement_";
  protected final String TEXT_408 = ".execute(\"add jar \"+";
  protected final String TEXT_409 = ");" + NL + "        \t\t";
  protected final String TEXT_410 = NL + "    \t\t\tstatement_";
  protected final String TEXT_411 = ".close();";
  protected final String TEXT_412 = NL + "\t\t\t\tSystem.setProperty(";
  protected final String TEXT_413 = " ,";
  protected final String TEXT_414 = ");";
  protected final String TEXT_415 = NL + "\t\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_416 = ");";
  protected final String TEXT_417 = NL + "\t\t\t\tSystem.setProperty(\"";
  protected final String TEXT_418 = "\", ";
  protected final String TEXT_419 = ");";
  protected final String TEXT_420 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_421 = ");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_422 = NL + "                    System.setProperty(\"hive.security.authorization.enabled\", \"false\");";
  protected final String TEXT_423 = NL + "                    System.setProperty(\"hive.security.authorization.enabled\", \"true\");";
  protected final String TEXT_424 = NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_425 = ");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_426 = ");" + NL + "" + NL + "        \t\t";
  protected final String TEXT_427 = NL + NL + "        \t\t";
  protected final String TEXT_428 = NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_429 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_430 = ");" + NL + "       \t\t \t";
  protected final String TEXT_431 = NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_432 = " = ";
  protected final String TEXT_433 = ";" + NL + "    \t\t\t";
  protected final String TEXT_434 = NL + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_435 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_436 = ");";
  protected final String TEXT_437 = NL + "                \tSystem.setProperty(\"hive.server2.authentication.kerberos.principal\", ";
  protected final String TEXT_438 = ");" + NL + "               \t\tSystem.setProperty(\"hive.server2.authentication.kerberos.keytab\", ";
  protected final String TEXT_439 = ");";
  protected final String TEXT_440 = NL + "\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_441 = ", ";
  protected final String TEXT_442 = ");";
  protected final String TEXT_443 = NL + "\t            String username_";
  protected final String TEXT_444 = " = ";
  protected final String TEXT_445 = ";" + NL + "\t            if(username_";
  protected final String TEXT_446 = "!=null && !\"\".equals(username_";
  protected final String TEXT_447 = ".trim())) {" + NL + "\t                System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_448 = ");" + NL + "\t            }" + NL + "\t            ";
  protected final String TEXT_449 = NL + "\t\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_450 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_451 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_452 = " + \":\" + ";
  protected final String TEXT_453 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\t\tString url_";
  protected final String TEXT_454 = " = \"jdbc:";
  protected final String TEXT_455 = "://\";";
  protected final String TEXT_456 = NL + "    \t\t\t\tif(dbUser_";
  protected final String TEXT_457 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_458 = ".trim())) {" + NL + "    \t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_459 = ");" + NL + "    \t\t\t\t\t//make relative file path work for hive" + NL + "    \t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "    \t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_460 = ");" + NL + "    \t\t\t\t}";
  protected final String TEXT_461 = NL + "\t\t\t            System.setProperty(\"pname\", \"MapRLogin\");" + NL + "\t\t\t            System.setProperty(\"https.protocols\", \"TLSv1.2\");" + NL + "\t\t\t            System.setProperty(\"mapr.home.dir\", ";
  protected final String TEXT_462 = ");" + NL + "\t\t\t            System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_463 = ");" + NL + "\t\t\t            ";
  protected final String TEXT_464 = NL + "\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_465 = ", ";
  protected final String TEXT_466 = ");";
  protected final String TEXT_467 = NL + "\t\t\t            com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_468 = " = new com.mapr.login.client.MapRLoginHttpsClient();" + NL + "\t\t\t            maprLogin_";
  protected final String TEXT_469 = ".getMapRCredentialsViaKerberos(";
  protected final String TEXT_470 = ", ";
  protected final String TEXT_471 = ");" + NL + "\t\t\t            ";
  protected final String TEXT_472 = NL + "\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_473 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_474 = ");";
  protected final String TEXT_475 = NL + "\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_476 = " = ";
  protected final String TEXT_477 = ";";
  protected final String TEXT_478 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_479 = " = \"jdbc:";
  protected final String TEXT_480 = "://\" + ";
  protected final String TEXT_481 = " + \":\" + ";
  protected final String TEXT_482 = " + \"/\" + ";
  protected final String TEXT_483 = " + \";principal=\" + ";
  protected final String TEXT_484 = "+\";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_485 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_486 = ";";
  protected final String TEXT_487 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_488 = " = \"jdbc:";
  protected final String TEXT_489 = "://\" + ";
  protected final String TEXT_490 = " + \":\" + ";
  protected final String TEXT_491 = " + \"/\" + ";
  protected final String TEXT_492 = " + \";principal=\" + ";
  protected final String TEXT_493 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_494 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_495 = " = \"jdbc:";
  protected final String TEXT_496 = "://\" + ";
  protected final String TEXT_497 = " + \":\" + ";
  protected final String TEXT_498 = " + \"/\" + ";
  protected final String TEXT_499 = " + \";principal=\" + ";
  protected final String TEXT_500 = ";";
  protected final String TEXT_501 = NL + "                        System.setProperty(\"pname\", \"MapRLogin\");" + NL + "                        System.setProperty(\"https.protocols\", \"TLSv1.2\");" + NL + "                        System.setProperty(\"mapr.home.dir\", ";
  protected final String TEXT_502 = ");" + NL + "                        com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_503 = " = new com.mapr.login.client.MapRLoginHttpsClient();";
  protected final String TEXT_504 = NL + "                            System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_505 = ");";
  protected final String TEXT_506 = NL + "                            maprLogin_";
  protected final String TEXT_507 = ".setCheckUGI(false);";
  protected final String TEXT_508 = NL + "                            String decryptedMaprPassword_";
  protected final String TEXT_509 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_510 = ");";
  protected final String TEXT_511 = NL + "                            String decryptedMaprPassword_";
  protected final String TEXT_512 = " = ";
  protected final String TEXT_513 = ";";
  protected final String TEXT_514 = NL + "                        \tmaprLogin_";
  protected final String TEXT_515 = ".getMapRCredentialsViaPassword(";
  protected final String TEXT_516 = ", ";
  protected final String TEXT_517 = ", decryptedMaprPassword_";
  protected final String TEXT_518 = ", ";
  protected final String TEXT_519 = ", \"\");" + NL + "                        \t";
  protected final String TEXT_520 = NL + "                        \tmaprLogin_";
  protected final String TEXT_521 = ".getMapRCredentialsViaPassword(";
  protected final String TEXT_522 = ", ";
  protected final String TEXT_523 = ", decryptedMaprPassword_";
  protected final String TEXT_524 = ", ";
  protected final String TEXT_525 = ");" + NL + "                        \t";
  protected final String TEXT_526 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_527 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_528 = ");";
  protected final String TEXT_529 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_530 = " = ";
  protected final String TEXT_531 = ";";
  protected final String TEXT_532 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_533 = " = \"jdbc:";
  protected final String TEXT_534 = "://\" + ";
  protected final String TEXT_535 = " + \":\" + ";
  protected final String TEXT_536 = " + \"/\" + ";
  protected final String TEXT_537 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_538 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_539 = ";";
  protected final String TEXT_540 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_541 = " = \"jdbc:";
  protected final String TEXT_542 = "://\" + ";
  protected final String TEXT_543 = " + \":\" + ";
  protected final String TEXT_544 = " + \"/\" + ";
  protected final String TEXT_545 = ";";
  protected final String TEXT_546 = NL + "\t\t\t\tString additionalJdbcSettings_";
  protected final String TEXT_547 = " = ";
  protected final String TEXT_548 = ";" + NL + "\t\t\t\tif(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_549 = ".trim())) {" + NL + "\t\t\t\t\tif(!additionalJdbcSettings_";
  protected final String TEXT_550 = ".startsWith(\";\")) {" + NL + "\t\t\t\t\t\tadditionalJdbcSettings_";
  protected final String TEXT_551 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_552 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_553 = " += additionalJdbcSettings_";
  protected final String TEXT_554 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_555 = NL + "\t\t\t\tif(true) {" + NL + "\t\t\t\t\tthrow new java.lang.UnsupportedOperationException(\"Parquet is only supported if the distribution uses embedded Hive version 0.10 or later.\");" + NL + "\t\t\t\t}";
  protected final String TEXT_556 = NL + "\t\t\t\t\troutines.system.GetJarsToRegister getJarsToRegister_";
  protected final String TEXT_557 = " = new routines.system.GetJarsToRegister();";
  protected final String TEXT_558 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_559 = NL + "\tclass GetHiveJarsToRegister_";
  protected final String TEXT_560 = " extends routines.system.GetJarsToRegister {" + NL + "\t\t" + NL + "\t\tprivate String uploadJarToHDFS(String jar) throws Exception {" + NL + "\t\t\t";
  protected final String TEXT_561 = NL;
  protected final String TEXT_562 = NL + "        String username_";
  protected final String TEXT_563 = " = (";
  protected final String TEXT_564 = " != null && !\"\".equals(";
  protected final String TEXT_565 = ")) ? ";
  protected final String TEXT_566 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_567 = " = null;";
  protected final String TEXT_568 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_569 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_570 = ".set(\"";
  protected final String TEXT_571 = "\", ";
  protected final String TEXT_572 = ");" + NL + "        ";
  protected final String TEXT_573 = NL + "            conf_";
  protected final String TEXT_574 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_575 = NL + "        \t\tconf_";
  protected final String TEXT_576 = ".set(";
  protected final String TEXT_577 = " ,";
  protected final String TEXT_578 = ");" + NL + "        \t";
  protected final String TEXT_579 = NL + "            username_";
  protected final String TEXT_580 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_581 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_582 = ");" + NL + "    \t\t";
  protected final String TEXT_583 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_584 = ", ";
  protected final String TEXT_585 = ");" + NL + "    \t\t";
  protected final String TEXT_586 = NL + "\t\t\tconf_";
  protected final String TEXT_587 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_588 = "+\",\"+username_";
  protected final String TEXT_589 = ");" + NL + "        \tfs_";
  protected final String TEXT_590 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_591 = ");";
  protected final String TEXT_592 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_593 = " == null || \"\".equals(username_";
  protected final String TEXT_594 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_595 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_596 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_597 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_598 = ".get(\"";
  protected final String TEXT_599 = "\")),conf_";
  protected final String TEXT_600 = ",username_";
  protected final String TEXT_601 = ");" + NL + "        \t}\t";
  protected final String TEXT_602 = NL + "\t\t\t";
  protected final String TEXT_603 = NL + "\t\t\t" + NL + "\t\t\tString pathUsername_";
  protected final String TEXT_604 = " = username_";
  protected final String TEXT_605 = " == null ? org.apache.hadoop.security.UserGroupInformation.getLoginUser().getShortUserName() : username_";
  protected final String TEXT_606 = ";" + NL + "\t\t\tfs_";
  protected final String TEXT_607 = ".mkdirs(new org.apache.hadoop.fs.Path(\"/user/\" + pathUsername_";
  protected final String TEXT_608 = " + \"/tmp\"), new org.apache.hadoop.fs.permission.FsPermission(org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL));" + NL + "\t\t\tfs_";
  protected final String TEXT_609 = ".copyFromLocalFile(false, true, new org.apache.hadoop.fs.Path(jar), new org.apache.hadoop.fs.Path(\"/user/\" + pathUsername_";
  protected final String TEXT_610 = " + \"/tmp\"));" + NL + "\t\t\treturn ";
  protected final String TEXT_611 = " + \"/user/\" + pathUsername_";
  protected final String TEXT_612 = " + \"/tmp/\" + new java.io.File(jar).getName();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\tString classPathLine = super.replaceJarPaths(originalClassPathLine);" + NL + "\t\t\tString hdfsPath = uploadJarToHDFS(classPathLine);" + NL + "\t\t\treturn hdfsPath;" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t\t\t\t\tGetHiveJarsToRegister_";
  protected final String TEXT_613 = " getJarsToRegister_";
  protected final String TEXT_614 = " = new GetHiveJarsToRegister_";
  protected final String TEXT_615 = "();";
  protected final String TEXT_616 = NL + "\t\t\t\t\tjava.sql.Statement addJar_";
  protected final String TEXT_617 = " = null;";
  protected final String TEXT_618 = NL + "\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_619 = " = conn_";
  protected final String TEXT_620 = ".createStatement();" + NL + "\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_621 = ".execute(\"add jar \" + getJarsToRegister_";
  protected final String TEXT_622 = ".replaceJarPaths(\"";
  protected final String TEXT_623 = "\"));" + NL + "\t\t\t\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_624 = ".close();" + NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_625 = NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_626 = NL + NL + "java.text.DateFormat dateStrFormat_";
  protected final String TEXT_627 = " = new java.text.SimpleDateFormat(\"yyyyMMddHHmmss\");" + NL + "final String queryIdentifier_";
  protected final String TEXT_628 = " = projectName + \"_\" + jobName + \"_\" + jobVersion.replace(\".\", \"_\") + \"_";
  protected final String TEXT_629 = "_\" + dateStrFormat_";
  protected final String TEXT_630 = ".format(new Date(startTime));" + NL + "// For MapReduce Mode" + NL + "stmt_";
  protected final String TEXT_631 = ".execute(\"set mapred.job.name=\" + queryIdentifier_";
  protected final String TEXT_632 = ");";
  protected final String TEXT_633 = NL + "    // For Tez Mode" + NL + "    stmt_";
  protected final String TEXT_634 = ".execute(\"set hive.query.name=\" + queryIdentifier_";
  protected final String TEXT_635 = ");";
  protected final String TEXT_636 = NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_637 = NL + "\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");";
  protected final String TEXT_638 = NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_639 = ");";
  protected final String TEXT_640 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_641 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_642 = NL + "\t\t    int nb_line_";
  protected final String TEXT_643 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_644 = " = null;";
  protected final String TEXT_645 = NL + "\t\t        conn_";
  protected final String TEXT_646 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_647 = "\");";
  protected final String TEXT_648 = NL + "\t\t\t\t";
  protected final String TEXT_649 = NL + "             boolean currentAutoCommitMode";
  protected final String TEXT_650 = " =  conn_";
  protected final String TEXT_651 = ".getAutoCommit();" + NL + "             conn_";
  protected final String TEXT_652 = ".setAutoCommit(true);" + NL + "             try{";
  protected final String TEXT_653 = NL + "                           try{" + NL + "                               conn_";
  protected final String TEXT_654 = ".createStatement().execute(\"BEGIN QUERY LOGGING WITH SQL,OBJECTS ON \" + ";
  protected final String TEXT_655 = ");" + NL + "                           }catch(Exception e){" + NL + "                                 System.err.println(e.getMessage());" + NL + "                           }";
  protected final String TEXT_656 = NL + "                 conn_";
  protected final String TEXT_657 = ".createStatement().execute(" + NL + "              \"SET QUERY_BAND='\" +";
  protected final String TEXT_658 = NL + "               ";
  protected final String TEXT_659 = " + \"=\" + ";
  protected final String TEXT_660 = " + \";\" +";
  protected final String TEXT_661 = " \"' FOR SESSION\"" + NL + "           );" + NL + "              }catch(Exception e){" + NL + "               System.err.println(e.getMessage());" + NL + "      }" + NL + "      conn_";
  protected final String TEXT_662 = ".setAutoCommit(currentAutoCommitMode";
  protected final String TEXT_663 = ");";
  protected final String TEXT_664 = NL + "\t\t    ";
  protected final String TEXT_665 = NL + NL + "\t\t    String dbquery_";
  protected final String TEXT_666 = " = ";
  protected final String TEXT_667 = ";" + NL + "\t\t\t";
  protected final String TEXT_668 = NL + "                log.debug(\"";
  protected final String TEXT_669 = " - Executing the query: '\"+dbquery_";
  protected final String TEXT_670 = "+\"'.\");" + NL + "\t\t\t";
  protected final String TEXT_671 = NL;
  protected final String TEXT_672 = NL + "            \tglobalMap.put(\"";
  protected final String TEXT_673 = "_QUERY\",dbquery_";
  protected final String TEXT_674 = ");";
  protected final String TEXT_675 = NL + "            \tglobalMap.put(\"";
  protected final String TEXT_676 = "_QUERY\",dbquery_";
  protected final String TEXT_677 = ");";
  protected final String TEXT_678 = NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_679 = " = null;" + NL + "" + NL + "\t\t    try {" + NL + "\t\t    \trs_";
  protected final String TEXT_680 = " = stmt_";
  protected final String TEXT_681 = ".executeQuery(dbquery_";
  protected final String TEXT_682 = ");" + NL + "\t\t    \tjava.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_683 = " = rs_";
  protected final String TEXT_684 = ".getMetaData();" + NL + "\t\t    \tint colQtyInRs_";
  protected final String TEXT_685 = " = rsmd_";
  protected final String TEXT_686 = ".getColumnCount();" + NL;
  protected final String TEXT_687 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_688 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_689 = ".setDbmsId(\"";
  protected final String TEXT_690 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_691 = "=new java.util.ArrayList<String>();" + NL + "\t\t    ";
  protected final String TEXT_692 = NL + "\t\t    \t    listSchema_";
  protected final String TEXT_693 = ".add(\"";
  protected final String TEXT_694 = "\");" + NL + "\t    \t    ";
  protected final String TEXT_695 = NL + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_696 = " = ";
  protected final String TEXT_697 = ";" + NL + "" + NL + "            for (int i = ";
  protected final String TEXT_698 = "; i <= rsmd_";
  protected final String TEXT_699 = ".getColumnCount()-";
  protected final String TEXT_700 = "; i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_701 = ".contains(rsmd_";
  protected final String TEXT_702 = ".getColumnLabel(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_703 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_704 = ".setName(rsmd_";
  protected final String TEXT_705 = ".getColumnLabel(i));" + NL + "                \tdcm_";
  protected final String TEXT_706 = ".setDbName(rsmd_";
  protected final String TEXT_707 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_708 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_709 = "\", rsmd_";
  protected final String TEXT_710 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_711 = ".getPrecision(i), rsmd_";
  protected final String TEXT_712 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_713 = ".setDbType(rsmd_";
  protected final String TEXT_714 = ".getColumnTypeName(i));" + NL + "                \tdcm_";
  protected final String TEXT_715 = ".setDbTypeId(rsmd_";
  protected final String TEXT_716 = ".getColumnType(i));";
  protected final String TEXT_717 = NL + "                \tdcm_";
  protected final String TEXT_718 = ".setFormat(";
  protected final String TEXT_719 = ");";
  protected final String TEXT_720 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_721 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_722 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_723 = ".setLength(rsmd_";
  protected final String TEXT_724 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_725 = ".setLength(rsmd_";
  protected final String TEXT_726 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_727 = NL + "\t\t\tdcm_";
  protected final String TEXT_728 = ".setLength(rsmd_";
  protected final String TEXT_729 = ".getPrecision(i));";
  protected final String TEXT_730 = NL + "                \tdcm_";
  protected final String TEXT_731 = ".setPrecision(rsmd_";
  protected final String TEXT_732 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_733 = ".setNullable(rsmd_";
  protected final String TEXT_734 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_735 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_736 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_737 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_738 = ".metadatas.add(dcm_";
  protected final String TEXT_739 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_740 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_741 = " = null;" + NL + "\t\t    ";
  protected final String TEXT_742 = NL + "\t\t    \tint column_index_";
  protected final String TEXT_743 = " =1;" + NL + "\t\t    ";
  protected final String TEXT_744 = NL + "\t\t    ";
  protected final String TEXT_745 = NL + "\t\t    \tlog.debug(\"";
  protected final String TEXT_746 = " - Retrieving records from the database.\");" + NL + "\t\t    ";
  protected final String TEXT_747 = NL + "\t\t    while (rs_";
  protected final String TEXT_748 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_749 = "++;" + NL + "\t\t        ";
  protected final String TEXT_750 = NL + "\t\t\t\t\t\t\t\t\tcolumn_index_";
  protected final String TEXT_751 = " = ";
  protected final String TEXT_752 = " + dcg_";
  protected final String TEXT_753 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_754 = NL + "\t\t\t\t\t\t\t\t\tcolumn_index_";
  protected final String TEXT_755 = " = ";
  protected final String TEXT_756 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_757 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_758 = NL + "\t\t\t\t\t\t\tif(colQtyInRs_";
  protected final String TEXT_759 = " < ";
  protected final String TEXT_760 = "column_index_";
  protected final String TEXT_761 = ") {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_762 = ".";
  protected final String TEXT_763 = " = ";
  protected final String TEXT_764 = ";" + NL + "\t\t\t\t\t\t\t} else {";
  protected final String TEXT_765 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_766 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_767 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_768 = NL + "\t\t                            ";
  protected final String TEXT_769 = ".";
  protected final String TEXT_770 = " = (List)rs_";
  protected final String TEXT_771 = ".getObject(";
  protected final String TEXT_772 = "column_index_";
  protected final String TEXT_773 = ");";
  protected final String TEXT_774 = NL + "\t                         \t\t";
  protected final String TEXT_775 = NL + "\t                         \t\t";
  protected final String TEXT_776 = NL + "\t                         \t\t";
  protected final String TEXT_777 = NL + "                                    oracle.sql.STRUCT jGeomStruct = (oracle.sql.STRUCT) rs_";
  protected final String TEXT_778 = ".getObject(";
  protected final String TEXT_779 = "column_index_";
  protected final String TEXT_780 = ");" + NL + "                                    if (jGeomStruct != null) {" + NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load(jGeomStruct);" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_781 = NL + "                                    ";
  protected final String TEXT_782 = ".";
  protected final String TEXT_783 = " = new Geometry(wktValue);" + NL + "                                    } else {";
  protected final String TEXT_784 = NL + "                                      ";
  protected final String TEXT_785 = ".";
  protected final String TEXT_786 = " = null;" + NL + "                                    }";
  protected final String TEXT_787 = NL + "                                        if (";
  protected final String TEXT_788 = ".";
  protected final String TEXT_789 = " != null) {";
  protected final String TEXT_790 = NL + "                                        ";
  protected final String TEXT_791 = ".";
  protected final String TEXT_792 = ".setEPSG(";
  protected final String TEXT_793 = ");" + NL + "                                        }";
  protected final String TEXT_794 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_795 = NL + "                                  ";
  protected final String TEXT_796 = ".";
  protected final String TEXT_797 = "=dcg_";
  protected final String TEXT_798 = ";";
  protected final String TEXT_799 = NL + "\t\t\t\t\t\t\t\t\t\tList<String> list_";
  protected final String TEXT_800 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_801 = " = ";
  protected final String TEXT_802 = "; i_";
  protected final String TEXT_803 = "  <= rsmd_";
  protected final String TEXT_804 = ".getColumnCount(); i_";
  protected final String TEXT_805 = " ++){" + NL + "\t\t\t\t\t    \t\t\t\t\t";
  protected final String TEXT_806 = NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_807 = ".getColumnTypeName(i_";
  protected final String TEXT_808 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_809 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_810 = ".getClob(i_";
  protected final String TEXT_811 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_812 = " !=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_813 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_814 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_815 = ".add(tNTextImpl_";
  protected final String TEXT_816 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_817 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t";
  protected final String TEXT_818 = " " + NL + "\t\t\t\t\t\t   \t\t\t\t\tif(\"NTEXT\".equals(rsmd_";
  protected final String TEXT_819 = ".getColumnTypeName(i_";
  protected final String TEXT_820 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t   \t\t\t\t\t\tlist_";
  protected final String TEXT_821 = ".add(rs_";
  protected final String TEXT_822 = ".getString(i_";
  protected final String TEXT_823 = "));" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t";
  protected final String TEXT_824 = NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_825 = ".";
  protected final String TEXT_826 = ", rs_";
  protected final String TEXT_827 = ", fixedColumnCount_";
  protected final String TEXT_828 = ",list_";
  protected final String TEXT_829 = ",";
  protected final String TEXT_830 = ");";
  protected final String TEXT_831 = NL + "\t\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.readColumnsFromDatabase_Access(";
  protected final String TEXT_832 = ".";
  protected final String TEXT_833 = ", rs_";
  protected final String TEXT_834 = ", fixedColumnCount_";
  protected final String TEXT_835 = ",";
  protected final String TEXT_836 = ");";
  protected final String TEXT_837 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_838 = ".";
  protected final String TEXT_839 = ", rs_";
  protected final String TEXT_840 = ", fixedColumnCount_";
  protected final String TEXT_841 = ",";
  protected final String TEXT_842 = ");";
  protected final String TEXT_843 = NL + "                                  Object geom = rs_";
  protected final String TEXT_844 = ".getObject(";
  protected final String TEXT_845 = "column_index_";
  protected final String TEXT_846 = ");" + NL + "                                  if (geom != null) {" + NL + "                                  \torg.postgis.Geometry o =" + NL + "                                      org.postgis.PGgeometry.geomFromString(geom.toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_847 = ".";
  protected final String TEXT_848 = " = new Geometry(sb.toString());" + NL + "                                  } else {" + NL + "                                  \t";
  protected final String TEXT_849 = ".";
  protected final String TEXT_850 = " = null;" + NL + "                                  }";
  protected final String TEXT_851 = NL + "\t\t                          ";
  protected final String TEXT_852 = NL + "\t\t                    }";
  protected final String TEXT_853 = NL + "\t\t\t\t\t";
  protected final String TEXT_854 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_855 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_856 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_857 = NL + "\t\t                            ";
  protected final String TEXT_858 = ".";
  protected final String TEXT_859 = " = ";
  protected final String TEXT_860 = ".";
  protected final String TEXT_861 = ";" + NL + "\t\t                            ";
  protected final String TEXT_862 = NL;

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
			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_35);
    } else if (!needUserAndPassword){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    } else {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    
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
			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
			connect_end();
		}
		
		public void connectWithSSO(){
			connect_begin_noUser();
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
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
			
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
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
			
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
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
			
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_60);
    
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
	    	
    stringBuffer.append(TEXT_61);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_64);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_65);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_67);
    
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
			
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_76);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	//this util class use by connection component
	class DefaultDBInputUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
		protected String dbport;
		protected String dbname;
		protected String dbuser;
		protected String dbpwd ;
		protected boolean isLog4jEnabled;
		protected boolean isDynamic;
		protected DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil;

		public void beforeComponentProcess(INode node){
			cid = node.getUniqueName();
			List<IMetadataTable> metadatas = node.getMetadataList();
			if ((metadatas != null) && (metadatas.size()>0)) {
				IMetadataTable metadata = metadatas.get(0);
				if (metadata != null) {
					isDynamic = metadata.isDynamicSchema();
				}
			}
			log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();
		}

		public void afterUseExistConnection(INode node) {
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
	    
	    public void afterUseNewConnection(INode node) {
	    }
	    
	    public void setURL(INode node) {
	    }
	    
		public void createConnection(INode node) {
			this.createConnection(node, true);
		}

		public void createConnection(INode node, boolean needUserAndPassword) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");

	 		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
 		if(specify_alias){

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
		}

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
                  if (needUserAndPassword){
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_95);
    
					String passwordFieldName = "__PASS__";
					
    stringBuffer.append(TEXT_96);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_99);
    } else {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
                  }
    stringBuffer.append(TEXT_106);
    this.setURL(node);
    stringBuffer.append(TEXT_107);
    
				log4jCodeGenerateUtil.debugConnectionParams(node);
				if ("SSO".equals(ElementParameterParser.getValue(node, "__JDBC_URL__"))){
					log4jCodeGenerateUtil.connect_begin_noUser();
				} else {
					log4jCodeGenerateUtil.connect_begin();
				}
				
    
			if(needUserAndPassword) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
			} else {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    
			}
			log4jCodeGenerateUtil.connect_end();

    stringBuffer.append(TEXT_116);
    this.afterUseNewConnection(node);
    
			if(specify_alias){

    stringBuffer.append(TEXT_117);
    
			}
		}
		
		public String getQueryString(INode node) {
			String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			
			return dbquery;
		}
		
		public void createStatement(INode node) {

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
		}
		public void createMinValueStatement(INode node){

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    }
		public String mappingType(String typeToGenerate) {
		
            if(("byte[]").equals(typeToGenerate)) {
                return "Bytes";
            } else if(("java.util.Date").equals(typeToGenerate)) {
                return "Timestamp";
            } else if(("Integer").equals(typeToGenerate)) {
               return "Int";
            } else {
                return typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringCharAndCharacterSet(String firstConnName, IMetadataColumn column, int currentColNo,
					String trimMethod, String typeToGenerate, boolean whetherTrimAllCol, boolean whetherTrimCol) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    if(isDynamic){
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_128);
    
                    if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_132);
    
                    }

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
                        if(("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_147);
    
                        } else {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_154);
    
                        }

    stringBuffer.append(TEXT_155);
    
		}
		
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    if(isDynamic){
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_161);
    
	    }
	    
	    public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {

    stringBuffer.append(TEXT_162);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    if(isDynamic){
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_167);
    if(trimMethod==null||trimMethod.isEmpty()){
    stringBuffer.append(TEXT_168);
    } else {
    stringBuffer.append(TEXT_169);
    }
    stringBuffer.append(TEXT_170);
    
	    }
	    
	    public void generateDoubleResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    	generateOthersResultSet(firstConnName, column, currentColNo, "Double");
	    }
	    
	    public void generateBooleanResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    	generateOthersResultSet(firstConnName, column, currentColNo, "Boolean");
	    }
	    
	    public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
	    public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    if(isDynamic){
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_174);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_179);
    if(isDynamic){
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_181);
    
                if(column.isNullable()) {
                    
    stringBuffer.append(TEXT_182);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_184);
    
                } else {
                    
    stringBuffer.append(TEXT_185);
        
                }
                
    stringBuffer.append(TEXT_186);
    
	    }
	    //---------end according schema type to generate ResultSet
	    
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultDBInputUtil class
	
	DefaultDBInputUtil dbInputBeginUtil = new DefaultDBInputUtil();
	
	

    stringBuffer.append(TEXT_187);
    
	class DBInputBeginUtil extends DefaultDBInputUtil{
		private String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		private String hiveServer = "hive";
		private org.talend.hadoop.distribution.component.HiveComponent hiveDistrib;
		private boolean isCustom;


		public void createConnection(INode node) {
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");

			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean securityIsEnabled = useKrb && (this.isCustom || (this.hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			if(securedStandaloneHive2) {
				super.createConnection(node, false);
			} else {
				super.createConnection(node);
			}
		}

		public void afterUseExistConnection(INode node) {
			String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	        String db = "db_" + connection;
	        String dbUser = "dbUser_" + connection;

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    
	    }

	    public void beforeComponentProcess(INode node){
	    	super.beforeComponentProcess(node);
	    	this.hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");

			String theDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
			String theVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");

		    if("true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"))) {
		        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
		        for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
		            if(connection!=null && connection.equals(pNode.getUniqueName())) {
		                theDistribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
		                theVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
		                this.hiveServer = ElementParameterParser.getValue(pNode, "__HIVE_SERVER__");
		                connectionMode = ElementParameterParser.getValue(pNode, "__CONNECTION_MODE__");
		            }
		        }
		    }

			try {
				this.hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(theDistribution, theVersion);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
				return;
			}
			this.isCustom = this.hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

			if(hiveServer!=null && !"".equals(hiveServer.trim()) && (isCustom || hiveDistrib.doSupportHive2())) {
				hiveServer = hiveServer.toLowerCase();
				if ("hive2".equals(hiveServer)) {
					javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
				}
			} else {
				hiveServer = "hive";
			}

			if(("hive".equals(this.hiveServer) && !hiveDistrib.doSupportHive1()) || ("hive2".equals(this.hiveServer) && !hiveDistrib.doSupportHive2())) {

    stringBuffer.append(TEXT_206);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_207);
    
			}

			if(("STANDALONE".equals(connectionMode) && !hiveDistrib.doSupportStandaloneMode()) || ("EMBEDDED".equals(connectionMode) && !hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_208);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_209);
    
			}

			if("STANDALONE".equals(connectionMode) && "hive".equals(this.hiveServer) && !hiveDistrib.doSupportHive1Standalone()) {

    stringBuffer.append(TEXT_210);
    
			}
	    }

		public void afterUseNewConnection(INode node) {

        	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

        	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
        	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
        	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
			String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");
			String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASE_MASTER_PRINCIPAL__");
			String hbaseReigonServerPrincipal = ElementParameterParser.getValue(node, "__HBASE_REIGONSERVER_PRINCIPAL__");
        	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
        	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");

        	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
        	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));

			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean securityIsEnabled = useKrb && (this.isCustom || (this.hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
			boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    

		    if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
		        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
		        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_218);
    
    		}

			boolean isKerberosAvailableHadoop2 = !this.isCustom && this.hiveDistrib.isHadoop2() && this.hiveDistrib.doSupportKerberos();
			boolean isHadoop2 = !this.isCustom && this.hiveDistrib.isHadoop2();
			boolean isKerberosAvailableHadoop1 = !this.isCustom && this.hiveDistrib.isHadoop1() && this.hiveDistrib.doSupportKerberos();

			if(securedEmbedded) {
				String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_221);
    
				if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
					String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_224);
    
				}
				if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
					String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_227);
    
				}

			}

        	if((this.isCustom && useYarn) || (!this.isCustom && isHadoop2)) {
        		if(setResourceManager) {
        			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_231);
    
				}

        		boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
        		if(setJobHistoryAddress) {
        			String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
        			
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_234);
    
        		}

				boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
				if(setSchedulerAddress) {
					String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_237);
    
				}

				if ("true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"))) {
				    
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    
				}

				if("true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
        			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_243);
    
				}

				if("EMBEDDED".equals(connectionMode) && (this.isCustom || this.hiveDistrib.doSupportEmbeddedMode())) {
					boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
					if((this.isCustom && useYarn && crossPlatformSubmission) || (!this.isCustom && this.hiveDistrib.doSupportCrossPlatformSubmission())) {

    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    
					}

					if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
					}

					if(this.hiveDistrib.doSupportCustomMRApplicationCP()){

    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(this.hiveDistrib.getCustomMRApplicationCP());
    stringBuffer.append(TEXT_251);
    
					}

    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(this.hiveDistrib.getYarnApplicationClasspath());
    stringBuffer.append(TEXT_254);
    
    			}

    			boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
    			if(setMemory) {
        			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
        			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
        			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_261);
    
				}
			}

            List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        	if(advProps!=null) {
				for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_265);
    
				}
			}

    stringBuffer.append(TEXT_266);
    
			boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
			if(!useExistingConnection){
			
    stringBuffer.append(TEXT_267);
    stringBuffer.append(TEXT_268);
    
class PrepareTez{
	public void invoke(INode node, String cid){
        String hiveDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

        org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
        try {
            hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(hiveDistribution, hiveVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

        boolean changePathSeparator = !hiveDistrib.isExecutedThroughWebHCat();

        String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
        boolean useTez = "tez".equals(ElementParameterParser.getValue(node, "__EXECUTION_ENGINE__"));
    	boolean supportTez = (isCustom || hiveDistrib.doSupportTezForHive()) && "EMBEDDED".equals(connectionMode);
    	if(supportTez && useTez){
    	
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_271);
      
                    }
                }
            }
            boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
            if(installTez){
                //prepare the folder
                
    stringBuffer.append(TEXT_272);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_283);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_289);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_293);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_294);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_296);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    
        }else{
        
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_320);
    
                }else{
                
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_323);
    
                }
                
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    
                List<String> tezLibJarsName = new java.util.ArrayList<String>();
                if(isCustom){
                    List<Map<String,String>> tezLibJarsNameValue = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__TEZ_LIB_NAME__");
                    for(Map<String, String> tezLibJarsNameV : tezLibJarsNameValue){
                        tezLibJarsName.add(tezLibJarsNameV.get("JAR_NAME"));
                    }
                }else{
                    String tezLibJarsNameValue = ElementParameterParser.getValue(node, "__TEZ_JARS_NAME__");
                    if(tezLibJarsNameValue != null && !"".equals(tezLibJarsNameValue)){
                        tezLibJarsName = java.util.Arrays.asList(tezLibJarsNameValue.split(","));
                    }
                }
                
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    if(changePathSeparator){
    stringBuffer.append(TEXT_329);
    }else{
    stringBuffer.append(TEXT_330);
    }
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    
                    }
                    
    stringBuffer.append(TEXT_346);
    
            }else{
            
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_349);
    
            }
            //define the location of tez lib    
            
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    
    	}
    }
}

    stringBuffer.append(TEXT_367);
    
            	(new PrepareTez()).invoke(node, cid);
            }
            
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    
    		if("true".equalsIgnoreCase(storeByHBase) && (this.isCustom || this.hiveDistrib.doSupportHBaseForHive())) {
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_385);
    }
    stringBuffer.append(TEXT_386);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_389);
    }
    stringBuffer.append(TEXT_390);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_393);
    }
    stringBuffer.append(TEXT_394);
    if(useKrb){
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    if(hbaseMasterPrincipal!=null && !"".equals(hbaseMasterPrincipal) && !"\"\"".equals(hbaseMasterPrincipal)){
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_400);
    }
    stringBuffer.append(TEXT_401);
    if(hbaseReigonServerPrincipal!=null && !"".equals(hbaseReigonServerPrincipal) && !"\"\"".equals(hbaseReigonServerPrincipal)){
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(hbaseReigonServerPrincipal);
    stringBuffer.append(TEXT_404);
    }
    stringBuffer.append(TEXT_405);
    }
    stringBuffer.append(TEXT_406);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
        			for(Map<String, String> jar : registerJarForHBase){
        				String path = jar.get("JAR_PATH");
        				if(path == null || "".equals(path) || "\"\"".equals(path)) {
        					continue;
        				}
        		
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_409);
    
        			}
        		}
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    
			}
    	}

		public void setURL(INode node) {
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String fsDefalutName = "fs.default.name";

			boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
			boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
			List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");

			boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));

			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean securityIsEnabled = useKrb && (this.isCustom || (this.hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
			boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);

			String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");
			boolean useSsl = "true".equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
			String sslTrustStore = ElementParameterParser.getValue(node, "__SSL_TRUST_STORE__");
			String sslStorepasswordFieldName = "__SSL_TRUST_STORE_PASSWORD__";

	        boolean useMapRTicket = ElementParameterParser.getBooleanValue(node, "__USE_MAPRTICKET__");
	        String mapRTicketUsername = ElementParameterParser.getValue(node, "__MAPRTICKET_USERNAME__");
	        String mapRTicketCluster = ElementParameterParser.getValue(node, "__MAPRTICKET_CLUSTER__");
	        String mapRTicketDuration = ElementParameterParser.getValue(node, "__MAPRTICKET_DURATION__");

	        boolean setMapRHomeDir = ElementParameterParser.getBooleanValue(node, "__SET_MAPR_HOME_DIR__");
	        String mapRHomeDir = ElementParameterParser.getValue(node, "__MAPR_HOME_DIR__");

	        boolean setMapRHadoopLogin = ElementParameterParser.getBooleanValue(node, "__SET_HADOOP_LOGIN__");
	        String mapRHadoopLogin = ElementParameterParser.getValue(node, "__HADOOP_LOGIN__");

	        String passwordFieldName = "";
	        if(hadoopProps.size() > 0){
				for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_412);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_414);
    
				}
			}

			if(((this.isCustom && !useYarn) || (!this.isCustom && this.hiveDistrib.isHadoop1())) && setMapredJT) {
				String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_415);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_416);
    
			}

			if(setNamenode) {
				String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_417);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_419);
    
			}

			if(securedEmbedded) {
				String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
				String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
				String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_420);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_421);
    if(securedEmbeddedHive2){
					// Disable authorization when using local HiveServer2 in secure mode
					
    stringBuffer.append(TEXT_422);
    
                }else{
                    
    stringBuffer.append(TEXT_423);
    
                 }
                
    stringBuffer.append(TEXT_424);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_426);
    
        		passwordFieldName = "__METASTORE_PASSWORD__";
        		
    stringBuffer.append(TEXT_427);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_430);
    } else {
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_433);
    }
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_436);
    
               	if(securedEmbeddedHive2){
                
    stringBuffer.append(TEXT_437);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_PRINCIPAL__"));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_KEYTAB__"));
    stringBuffer.append(TEXT_439);
    
                }
                
    
				if(useKeytab) {

    stringBuffer.append(TEXT_440);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_442);
    
				}
			}

	        boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(node, "__SET_HADOOP_USER__"));
	        if (setHadoopUser) {
	            String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");
	            
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_448);
    
	        }

    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    
			if("EMBEDDED".equals(connectionMode) && (this.isCustom || this.hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_451);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_455);
    
				if(this.isCustom || (!this.isCustom && this.hiveDistrib.doSupportImpersonation())) {

    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_460);
    
				}
			} else if("STANDALONE".equals(connectionMode) && (this.isCustom || this.hiveDistrib.doSupportStandaloneMode())) {
				if(securedStandaloneHive2) {
					// using keytab with HiveServer2 in standalone mode
					boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
					String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
					String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

			        if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
			            
    stringBuffer.append(TEXT_461);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(setMapRHadoopLogin ? mapRHadoopLogin : "\"kerberos\"");
    stringBuffer.append(TEXT_463);
    
			        }
					if(useKeytab) {

    stringBuffer.append(TEXT_464);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_466);
    
					}

					if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
			            
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_471);
    
			        }

					// Using SSL in Secure Mode
					if(useSsl && this.hiveDistrib.doSupportSSL()){

						// Does the distrib support SSL + KERBEROS
						if(this.hiveDistrib.doSupportSSLwithKerberos()){
							if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_474);
    
							}else{

    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_477);
    
							}

    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    
						// Does the distrib support only SASL-QOP + KERBEROS
						} else {
						

    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_493);
    
						}
					}else{

    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_500);
    
					}
				} else {
				    // Mapr ticket
				    if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
                        passwordFieldName = "__MAPRTICKET_PASSWORD__";
                        
    stringBuffer.append(TEXT_501);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    
                        if (setMapRHadoopLogin) {
                            
    stringBuffer.append(TEXT_504);
    stringBuffer.append(mapRHadoopLogin);
    stringBuffer.append(TEXT_505);
    
                        } else {
                            
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    
                        }
                        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_510);
    } else {
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_513);
    }
    
                        if(hiveDistrib.doSupportMaprTicketV52API()){
							
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(mapRTicketUsername);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_519);
    
                        } else {
                        	
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(mapRTicketUsername);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_525);
    
                        }
                    }
                    // Using SSL in non Secure Mode
					if(useSsl && this.hiveDistrib.doSupportSSL()){
						if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_528);
    
						}else{

    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_531);
    
						}

    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    
					}else{

    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_545);
    
					}
				}
				String additionalJdbcSettings = ElementParameterParser.getValue(node, "__HIVE_ADDITIONAL_JDBC__");

    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(additionalJdbcSettings);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    
			}
		}

		public String getDirverClassName(INode node){
			return javaDbDriver;
		}

		public void createStatement(INode node) {
			boolean useParquet = "true".equals(ElementParameterParser.getValue(node,"__USE_PARQUET__"));
			String processId = node.getProcess().getId();

			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			boolean setFsDefaultName = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
			String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
			INode connectionInformationNode = node;

			boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

			if(useExistingConnection) {
				connectionMode = "";
				setFsDefaultName = false;
				fsDefaultName = "";
				dbuser = "";
				String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
					if(connection!=null && connection.equals(pNode.getUniqueName())) {
						connectionMode = ElementParameterParser.getValue(pNode, "__CONNECTION_MODE__");
						setFsDefaultName = "true".equals(ElementParameterParser.getValue(pNode, "__SET_FS_DEFAULT_NAME__"));
						fsDefaultName = ElementParameterParser.getValue(pNode, "__FS_DEFAULT_NAME__");
						dbuser = ElementParameterParser.getValue(pNode, "__USER__");
						connectionInformationNode = pNode;
						break;
					}
				}
			}

			boolean isParquetSupported = this.isCustom || this.hiveDistrib.doSupportParquetFormat();;
			if(useParquet && !isParquetSupported) {

    stringBuffer.append(TEXT_555);
    
			}

			boolean generateAddJarCodeForAll = useParquet;

			// Register jars to handle the parquet format.

			java.util.List<String> jarsToRegister = null;
			java.util.List<String> jars = null;
			if(generateAddJarCodeForAll) {
				String[] commandLine = new String[] {"<command>"};
				try {
					commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
				} catch (ProcessorException e) {
					e.printStackTrace();
				}

				jarsToRegister = new java.util.ArrayList();

				jarsToRegister.add("snappy-java");
				jarsToRegister.add("parquet-hive-bundle");
				//jarsToRegister.add("parquet-hadoop-bundle");

				for (int j = 0; j < commandLine.length; j++) {
					if(commandLine[j].contains("jar")) {
						jars = java.util.Arrays.asList(commandLine[j].split(";"));
						break;
					}
				}
			}


			if(jarsToRegister!=null && jars!=null) {
				if("EMBEDDED".equalsIgnoreCase(connectionMode)) {

    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_557);
    
				} else {
					generateAddJarCodeForAll = false;
					if(setFsDefaultName) {
						generateAddJarCodeForAll = true;

    stringBuffer.append(TEXT_558);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(TEXT_561);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_572);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_578);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_582);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_583);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_585);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    
        }else{
        
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    
        }
    }
}

    stringBuffer.append(TEXT_602);
    
			(new GetFileSystem()).invoke(connectionInformationNode, cid);
			
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    
					}
				}

				if(generateAddJarCodeForAll) {

    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    
					for(int i=0; i<jarsToRegister.size(); i++) {
						String jarToRegister = jarsToRegister.get(i);
						for(int j=0; j<jars.size(); j++) {
							if(jars.get(j).contains(jarToRegister)) {

    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_622);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    
							}
						}
					}
				}
			}

			// End of parquet format handling.

			super.createStatement(node);
			
    stringBuffer.append(TEXT_625);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_632);
     
if(hiveDistrib.doSupportTezForHive()) {

    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_635);
    
}

    stringBuffer.append(TEXT_636);
    
		}

	}//end class

	dbInputBeginUtil = new DBInputBeginUtil();
	
    stringBuffer.append(TEXT_637);
    
	CodeGeneratorArgument codeGenArg = (CodeGeneratorArgument) argument;
	INode hiveNode = (INode)codeGenArg.getArgument();
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(hiveNode, "__SET_TEMP_PATH__"));
	if(setTempPath) {
		String tempPath = ElementParameterParser.getValue(hiveNode, "__TEMP_PATH__");

    stringBuffer.append(TEXT_638);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_639);
    
	}

	String yarnClasspathSeparator = ElementParameterParser.getValue(hiveNode, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_640);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_641);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");

	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String enableStream = ElementParameterParser.getValue(node, "__ENABLE_STREAM__");
	String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
	if("tJDBCInput".equals(node.getComponent().getName())) {
		boolean isEnableMapping = ("true").equals(ElementParameterParser.getValue(node, "__ENABLE_MAPPING__"));
		if (!isEnableMapping) {
			dbms = "";
		}
	}
	
	boolean isAmazonAurora = "mysql_id".equalsIgnoreCase(dbms) && node.isVirtualGenerateNode() && (cid.matches("^.*?tAmazonAuroraInput_\\d+_in$") || cid.matches("^.*?tDBInput_\\d+_in$"));
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");

    dbInputBeginUtil.beforeComponentProcess(node);
    int dynamic_index=-1;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {

    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;
		        
		        if(isAmazonAurora){
                    conn += "_in";
                }

    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_647);
    
				if ("REDSHIFT".equals(type)){
					String jdbcUrl = "";
					//Retrieve connection node and check if SSO was used for correct logging
					List< ? extends INode> nodes =  node.getProcess().getNodesOfType("tRedshiftConnection");
					String connectionRedShift = ElementParameterParser.getValue(node,"__CONNECTION__");
					for (INode ne : nodes) {
						if (connectionRedShift.equals(ne.getUniqueName())) {
							jdbcUrl = ElementParameterParser.getValue(ne, "__JDBC_URL__");
						}
					}
					boolean needUserAndPassword = !"SSO".equals(jdbcUrl);
					log4jCodeGenerateUtil.useExistConnection(node, needUserAndPassword);
				} else {
					log4jCodeGenerateUtil.useExistConnection(node);
				}

    
				dbInputBeginUtil.afterUseExistConnection(node);
		    } else {
				dbInputBeginUtil.createConnection(node);
				if ("teradata_id".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_648);
    
      boolean queryBand = "true".equals(ElementParameterParser.getValue(node, "__QUERY_BAND__"));
      boolean activateQueryLogging = "true".equals(ElementParameterParser.getValue(node, "__ACTIVATE_QUERY_LOGGING__"));
      String usrName = ElementParameterParser.getValue(node, "__USER__");
      List<Map<String, String>> queryBandList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__QUERY_BAND_PARAMETERS__");
      if(queryBand){
    stringBuffer.append(TEXT_649);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    
                    if(activateQueryLogging){
                        
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append( usrName );
    stringBuffer.append(TEXT_655);
    
                    }
                  
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    
            for(Map<String, String> map : queryBandList) {

    stringBuffer.append(TEXT_658);
    stringBuffer.append( map.get("KEY") );
    stringBuffer.append(TEXT_659);
    stringBuffer.append( map.get("VALUE") );
    stringBuffer.append(TEXT_660);
    
            }

    stringBuffer.append(TEXT_661);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_662);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_663);
    }
    
				}
		    }

    stringBuffer.append(TEXT_664);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_667);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    }
    stringBuffer.append(TEXT_671);
     
            if(isAmazonAurora){
            // why 3: ==> "_in".length()
            
    stringBuffer.append(TEXT_672);
    stringBuffer.append( cid.substring(0,cid.length() - 3) );
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    
            }else{
            
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    
            }
            
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_686);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();
		    boolean isDynamic = metadata.isDynamicSchema();
		    if(isDynamic){
		    	String DynamicDatePattern = "\"dd-MM-yyyy\"";
		    	for(IMetadataColumn column : columnList) {
		    		if("id_Dynamic".equals(column.getTalendType())) {
		    			DynamicDatePattern = column.getPattern();
		    			break;
		    		}
		    	}
		    
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    

		    for(int i=0; i< columnList.size(); i++) {
		        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
		            dynamic_index = i+1;
		        }else{
		            IMetadataColumn column = columnList.get(i);
		            String columName = column.getOriginalDbColumnName();
		            if(columName==null || "".equals(columName)){
		                columName = column.getLabel();
		            }
	            
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(columName.toUpperCase());
    stringBuffer.append(TEXT_694);
    
		    	}
			}
		    
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(columnList.size()-dynamic_index);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_719);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_726);
    
		} else {

    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_729);
    
		}

    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_739);
    
		    }
		    
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    if(isDynamic){
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_743);
    }
    stringBuffer.append(TEXT_744);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_745);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_746);
    }
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_749);
    
		        if(conns != null && conns.size() > 0) {
		            IConnection conn = conns.get(0);
		            String firstConnName = conn.getName();
		            int currentColNo = 1;
		            for(IMetadataColumn column : columnList) {
		                boolean whetherTrimCol = false;
		                if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
		                    for(Map<String, String> trimColumn : trimColumnList) {
		                        if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
		                            if(("true").equals(trimColumn.get("TRIM"))) {
		                                whetherTrimCol = true;
		                                break;
		                            }
		                        }
		                    }
		                }
		                String trimMethod = "";
		                if(whetherTrimAllCol || whetherTrimCol) {
		                    trimMethod = ".trim()";
		                }
		                String columnType = column.getType();

		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
		                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							if(isDynamic){
								if(!("Dynamic").equals(typeToGenerate) && dynamic_index < currentColNo) {
								
    stringBuffer.append(TEXT_750);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(currentColNo-1);
    stringBuffer.append(TEXT_752);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_753);
    }else{
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_755);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_756);
    }
    stringBuffer.append(TEXT_757);
    
							}
							
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_759);
    if(isDynamic){
    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_761);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_762);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_763);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_764);
    
								typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);

								if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_765);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    
								} else if(("Timestamp").equals(typeToGenerate)) {
									if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_766);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_767);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_768);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_769);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_770);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_771);
    if(isDynamic){
    stringBuffer.append(TEXT_772);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_773);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_774);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if(("Double").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_775);
    dbInputBeginUtil.generateDoubleResultSet(firstConnName, column, currentColNo);
    
								} else if(("Boolean").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_776);
    dbInputBeginUtil.generateBooleanResultSet(firstConnName, column, currentColNo);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_777);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_778);
    if(isDynamic){
    stringBuffer.append(TEXT_779);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_780);
    stringBuffer.append(TEXT_781);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_782);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_783);
    stringBuffer.append(TEXT_784);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_786);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_787);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_788);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_789);
    stringBuffer.append(TEXT_790);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_792);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_793);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_794);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_795);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_796);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_798);
     //for bug TDI-20886
									boolean trim = whetherTrimAllCol || whetherTrimCol;
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {
										String driver = "";
										if(("true").equals(useExistingConn)) {
											String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
											INode connectionNode = null; 
											for (INode processNode : node.getProcess().getGeneratingNodes()) { 
												if(connection.equals(processNode.getUniqueName())) { 
													connectionNode = processNode; 
													break; 
												} 
											}
											driver = ElementParameterParser.getValue(connectionNode,"__DRIVER__");
										} else {
											driver = ElementParameterParser.getValue(node,"__DRIVER__");
										}

    stringBuffer.append(TEXT_799);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_800);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_801);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_803);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_805);
     if("JTDS".equals(driver)) { 
    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_807);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_808);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_809);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_811);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_812);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_814);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_815);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_816);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_817);
     } else {
    stringBuffer.append(TEXT_818);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_819);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_821);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_822);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_823);
     } 
    stringBuffer.append(TEXT_824);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_826);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_829);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_830);
    
									}else if("access_id".equalsIgnoreCase(dbms)){

    stringBuffer.append(TEXT_831);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_833);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_834);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_835);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_836);
    
									}else{

    stringBuffer.append(TEXT_837);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_838);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_839);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_840);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_841);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_842);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_843);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_844);
    if(isDynamic){
    stringBuffer.append(TEXT_845);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_846);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_847);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_848);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_849);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_850);
    
                 	            } else {

    stringBuffer.append(TEXT_851);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_852);
    
		                    currentColNo++;
		                }
		            }

    stringBuffer.append(TEXT_853);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_854);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_855);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_856);
    }
    
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_857);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_858);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_859);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_861);
    
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_862);
    return stringBuffer.toString();
  }
}
