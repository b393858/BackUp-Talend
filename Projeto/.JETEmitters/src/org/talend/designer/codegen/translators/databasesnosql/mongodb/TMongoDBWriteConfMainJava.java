package org.talend.designer.codegen.translators.databasesnosql.mongodb;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;

public class TMongoDBWriteConfMainJava
{
  protected static String nl;
  public static synchronized TMongoDBWriteConfMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBWriteConfMainJava result = new TMongoDBWriteConfMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Trying to parse a json string.\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - The JSON string:\"+json_";
  protected final String TEXT_6 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\torg.bson.Document data_";
  protected final String TEXT_8 = "=org.bson.Document.parse(json_";
  protected final String TEXT_9 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Parsed Successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + NL + "\t\t\t// Replace Date and Bytes by true mongoDB types." + NL + "            Object ";
  protected final String TEXT_13 = "_dbobject = data_";
  protected final String TEXT_14 = ";" + NL + "            String pathString_";
  protected final String TEXT_15 = " = \"\";" + NL + "            String[] path_";
  protected final String TEXT_16 = ";" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "                            // root";
  protected final String TEXT_18 = NL + "                            ";
  protected final String TEXT_19 = "_dbobject = (org.bson.Document) data_";
  protected final String TEXT_20 = ";" + NL + "                            pathString_";
  protected final String TEXT_21 = " = \"";
  protected final String TEXT_22 = "\";";
  protected final String TEXT_23 = NL + "                                pathString_";
  protected final String TEXT_24 = " = pathString_";
  protected final String TEXT_25 = ".substring(pathString_";
  protected final String TEXT_26 = ".indexOf(\"/\") + 1);";
  protected final String TEXT_27 = NL + "                            path_";
  protected final String TEXT_28 = " = pathString_";
  protected final String TEXT_29 = ".split(\"/\");";
  protected final String TEXT_30 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_31 = ".processTree(";
  protected final String TEXT_32 = "_dbobject, path_";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_36 = ".processTree(";
  protected final String TEXT_37 = "_dbobject, path_";
  protected final String TEXT_38 = ", null);";
  protected final String TEXT_39 = NL + "                            // loop";
  protected final String TEXT_40 = NL + "                            ";
  protected final String TEXT_41 = "_dbobject = (org.bson.Document) data_";
  protected final String TEXT_42 = ";" + NL + "                            pathString_";
  protected final String TEXT_43 = " = \"";
  protected final String TEXT_44 = "\";";
  protected final String TEXT_45 = NL + "                                pathString_";
  protected final String TEXT_46 = " = pathString_";
  protected final String TEXT_47 = ".substring(pathString_";
  protected final String TEXT_48 = ".indexOf(\"/\") + 1);";
  protected final String TEXT_49 = NL + "                            path_";
  protected final String TEXT_50 = " = pathString_";
  protected final String TEXT_51 = ".split(\"/\");";
  protected final String TEXT_52 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_53 = ".processTree(";
  protected final String TEXT_54 = "_dbobject, path_";
  protected final String TEXT_55 = ", ";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_58 = ".processTree(";
  protected final String TEXT_59 = "_dbobject, path_";
  protected final String TEXT_60 = ", null);";
  protected final String TEXT_61 = NL + "                            // group";
  protected final String TEXT_62 = NL + "                            ";
  protected final String TEXT_63 = "_dbobject = (org.bson.Document) data_";
  protected final String TEXT_64 = ";" + NL + "                            pathString_";
  protected final String TEXT_65 = " = \"";
  protected final String TEXT_66 = "\";";
  protected final String TEXT_67 = NL + "                                pathString_";
  protected final String TEXT_68 = " = pathString_";
  protected final String TEXT_69 = ".substring(pathString_";
  protected final String TEXT_70 = ".indexOf(\"/\") + 1);";
  protected final String TEXT_71 = NL + "                            path_";
  protected final String TEXT_72 = " = pathString_";
  protected final String TEXT_73 = ".split(\"/\");";
  protected final String TEXT_74 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_75 = ".processTree(";
  protected final String TEXT_76 = "_dbobject, path_";
  protected final String TEXT_77 = ", ";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_80 = ".processTree(";
  protected final String TEXT_81 = "_dbobject, path_";
  protected final String TEXT_82 = ", null);";
  protected final String TEXT_83 = NL + "\t\t\t" + NL + "\t\t\torg.bson.Document queryObj_";
  protected final String TEXT_84 = "=null;" + NL + "\t\t\tif(data_";
  protected final String TEXT_85 = "!=null){" + NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_87 = " < bulkWriteOperationSize_";
  protected final String TEXT_88 = "){" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_89 = ".add(new com.mongodb.client.model.InsertOneModel<org.bson.Document>(data_";
  protected final String TEXT_90 = "));" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_91 = "++;" + NL + "\t\t\t\t\t\t} else {" + NL + "                            bulkWriteOperation_";
  protected final String TEXT_92 = ".add(new com.mongodb.client.model.InsertOneModel<org.bson.Document>(data_";
  protected final String TEXT_93 = "));" + NL + "\t\t\t\t\t\t\tcoll_";
  protected final String TEXT_94 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_95 = ", new com.mongodb.client.model.BulkWriteOptions().ordered(";
  protected final String TEXT_96 = "));" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_97 = "=1;" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_98 = " = new java.util.ArrayList();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\tcoll_";
  protected final String TEXT_100 = ".insertOne(data_";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_103 = " < bulkWriteOperationSize_";
  protected final String TEXT_104 = "){" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_105 = ".add(new com.mongodb.client.model.DeleteOneModel<org.bson.Document>(data_";
  protected final String TEXT_106 = "));" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_107 = "++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t    bulkWriteOperation_";
  protected final String TEXT_108 = ".add(new com.mongodb.client.model.DeleteOneModel<org.bson.Document>(data_";
  protected final String TEXT_109 = "));" + NL + "\t\t\t\t\t\t\t\t\tcoll_";
  protected final String TEXT_110 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_111 = ");" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_112 = "=1;" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_113 = " = new java.util.ArrayList();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\t\t\tcoll_";
  protected final String TEXT_115 = ".deleteOne(data_";
  protected final String TEXT_116 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t\tqueryObj_";
  protected final String TEXT_118 = " = (org.bson.Document) data_";
  protected final String TEXT_119 = ".get(";
  protected final String TEXT_120 = ");" + NL + "\t\t\t\t\tdata_";
  protected final String TEXT_121 = " = (org.bson.Document) data_";
  protected final String TEXT_122 = ".get(";
  protected final String TEXT_123 = ");" + NL + "\t\t\t\t\tif(data_";
  protected final String TEXT_124 = "!=null && queryObj_";
  protected final String TEXT_125 = "!=null){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_126 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_127 = " < bulkWriteOperationSize_";
  protected final String TEXT_128 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_129 = ".add(new com.mongodb.client.model.ReplaceOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_130 = ",data_";
  protected final String TEXT_131 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_132 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_133 = ".add(new com.mongodb.client.model.ReplaceOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_134 = ",data_";
  protected final String TEXT_135 = "));" + NL + "                                    coll_";
  protected final String TEXT_136 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_137 = ", new com.mongodb.client.model.BulkWriteOptions().ordered(";
  protected final String TEXT_138 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_139 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_140 = " = new java.util.ArrayList();" + NL + "                                }";
  protected final String TEXT_141 = NL + "                                coll_";
  protected final String TEXT_142 = ".replaceOne(queryObj_";
  protected final String TEXT_143 = ",data_";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_146 = " < bulkWriteOperationSize_";
  protected final String TEXT_147 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_148 = ".add(new com.mongodb.client.model.UpdateOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_149 = ",new org.bson.Document(\"$set\", data_";
  protected final String TEXT_150 = ")));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_151 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_152 = ".add(new com.mongodb.client.model.UpdateOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_153 = ",new org.bson.Document(\"$set\", data_";
  protected final String TEXT_154 = ")));" + NL + "                                    coll_";
  protected final String TEXT_155 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_156 = ", new com.mongodb.client.model.BulkWriteOptions().ordered(";
  protected final String TEXT_157 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_158 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_159 = " = new java.util.ArrayList();" + NL + "                                }";
  protected final String TEXT_160 = NL + "                                coll_";
  protected final String TEXT_161 = ".updateMany(queryObj_";
  protected final String TEXT_162 = ",new org.bson.Document(\"$set\", data_";
  protected final String TEXT_163 = "));";
  protected final String TEXT_164 = NL + "                                coll_";
  protected final String TEXT_165 = ".updateOne(queryObj_";
  protected final String TEXT_166 = ",new org.bson.Document(\"$set\", data_";
  protected final String TEXT_167 = "));";
  protected final String TEXT_168 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_169 = " < bulkWriteOperationSize_";
  protected final String TEXT_170 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_171 = ".add(new com.mongodb.client.model.ReplaceOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_172 = ",data_";
  protected final String TEXT_173 = ",new com.mongodb.client.model.UpdateOptions().upsert(true)));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_174 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_175 = ".add(new com.mongodb.client.model.ReplaceOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_176 = ",data_";
  protected final String TEXT_177 = ",new com.mongodb.client.model.UpdateOptions().upsert(true)));" + NL + "                                    coll_";
  protected final String TEXT_178 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_179 = ", new com.mongodb.client.model.BulkWriteOptions().ordered(";
  protected final String TEXT_180 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_181 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_182 = " = new java.util.ArrayList();" + NL + "                                }" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\t\t\t\t\tcoll_";
  protected final String TEXT_184 = ".replaceOne(queryObj_";
  protected final String TEXT_185 = ",data_";
  protected final String TEXT_186 = ",new com.mongodb.client.model.UpdateOptions().upsert(true));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_187 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_188 = " < bulkWriteOperationSize_";
  protected final String TEXT_189 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_190 = ".add(new com.mongodb.client.model.UpdateOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_191 = ",new org.bson.Document(\"$set\", data_";
  protected final String TEXT_192 = "),new com.mongodb.client.model.UpdateOptions().upsert(true)));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_193 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_194 = ".add(new com.mongodb.client.model.UpdateOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_195 = ",new org.bson.Document(\"$set\", data_";
  protected final String TEXT_196 = "),new com.mongodb.client.model.UpdateOptions().upsert(true)));" + NL + "                                    coll_";
  protected final String TEXT_197 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_198 = ", new com.mongodb.client.model.BulkWriteOptions().ordered(";
  protected final String TEXT_199 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_200 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_201 = " = new java.util.ArrayList();" + NL + "                                }";
  protected final String TEXT_202 = NL + "                                coll_";
  protected final String TEXT_203 = ".updateMany(queryObj_";
  protected final String TEXT_204 = ",new org.bson.Document(\"$set\", data_";
  protected final String TEXT_205 = "),new com.mongodb.client.model.UpdateOptions().upsert(true));";
  protected final String TEXT_206 = NL + "                                coll_";
  protected final String TEXT_207 = ".updateOne(queryObj_";
  protected final String TEXT_208 = ",new org.bson.Document(\"$set\", data_";
  protected final String TEXT_209 = "),new com.mongodb.client.model.UpdateOptions().upsert(true));";
  protected final String TEXT_210 = "\t" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_211 = NL + "\t\t\t\t\t\t\tthrow new Exception(\"Data node or Query node configuration error! \");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_213 = " - Data node or Query node configuration error!\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_214 = NL + "\t\t\t\t\t\t\tSystem.err.println(\"Data node or Query node configuration error!\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_215 = "\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_216 = NL + NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_217 = NL + "\t\t\t\t\tthrow new Exception(\"There no data in json,Please check the json configuration\");" + NL + "\t\t\t\t";
  protected final String TEXT_218 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_219 = " - There no data in json,Please check the json configuration\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t\t\tSystem.err.println(\"There no data in json,Please check the json configuration\");" + NL + "\t\t\t\t";
  protected final String TEXT_221 = "\t" + NL + "\t\t\t}\t\t" + NL + "\t\t";
  protected final String TEXT_222 = NL + "\t";
  protected final String TEXT_223 = NL + "\t\t\tcom.mongodb.WriteResult resultMessage_";
  protected final String TEXT_224 = "=null;" + NL + "\t\t\t";
  protected final String TEXT_225 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_226 = " - Trying to parse a json string.\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_227 = " - The JSON string:\"+json_";
  protected final String TEXT_228 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_229 = NL + "\t\t\tObject data_";
  protected final String TEXT_230 = "=com.mongodb.BasicDBObject.parse(json_";
  protected final String TEXT_231 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_232 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_233 = " - Parsed Successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_234 = NL + NL + "\t\t\t// Replace Date and Bytes by true mongoDB types." + NL + "            Object ";
  protected final String TEXT_235 = "_dbobject = data_";
  protected final String TEXT_236 = ";" + NL + "            String pathString_";
  protected final String TEXT_237 = " = \"\";" + NL + "            String[] path_";
  protected final String TEXT_238 = ";" + NL + "\t\t\t";
  protected final String TEXT_239 = NL + "                            // root";
  protected final String TEXT_240 = NL + "                            ";
  protected final String TEXT_241 = "_dbobject = (com.mongodb.BasicDBObject) data_";
  protected final String TEXT_242 = ";" + NL + "                            pathString_";
  protected final String TEXT_243 = " = \"";
  protected final String TEXT_244 = "\";";
  protected final String TEXT_245 = NL + "                                pathString_";
  protected final String TEXT_246 = " = pathString_";
  protected final String TEXT_247 = ".substring(pathString_";
  protected final String TEXT_248 = ".indexOf(\"/\") + 1);";
  protected final String TEXT_249 = NL + "                            path_";
  protected final String TEXT_250 = " = pathString_";
  protected final String TEXT_251 = ".split(\"/\");";
  protected final String TEXT_252 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_253 = ".processTree(";
  protected final String TEXT_254 = "_dbobject, path_";
  protected final String TEXT_255 = ", ";
  protected final String TEXT_256 = ");";
  protected final String TEXT_257 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_258 = ".processTree(";
  protected final String TEXT_259 = "_dbobject, path_";
  protected final String TEXT_260 = ", null);";
  protected final String TEXT_261 = NL + "                            // loop";
  protected final String TEXT_262 = NL + "                            ";
  protected final String TEXT_263 = "_dbobject = (com.mongodb.BasicDBObject) data_";
  protected final String TEXT_264 = ";" + NL + "                            pathString_";
  protected final String TEXT_265 = " = \"";
  protected final String TEXT_266 = "\";";
  protected final String TEXT_267 = NL + "                                pathString_";
  protected final String TEXT_268 = " = pathString_";
  protected final String TEXT_269 = ".substring(pathString_";
  protected final String TEXT_270 = ".indexOf(\"/\") + 1);";
  protected final String TEXT_271 = NL + "                            path_";
  protected final String TEXT_272 = " = pathString_";
  protected final String TEXT_273 = ".split(\"/\");";
  protected final String TEXT_274 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_275 = ".processTree(";
  protected final String TEXT_276 = "_dbobject, path_";
  protected final String TEXT_277 = ", ";
  protected final String TEXT_278 = ");";
  protected final String TEXT_279 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_280 = ".processTree(";
  protected final String TEXT_281 = "_dbobject, path_";
  protected final String TEXT_282 = ", null);";
  protected final String TEXT_283 = NL + "                            // group";
  protected final String TEXT_284 = NL + "                            ";
  protected final String TEXT_285 = "_dbobject = (com.mongodb.BasicDBObject) data_";
  protected final String TEXT_286 = ";" + NL + "                            pathString_";
  protected final String TEXT_287 = " = \"";
  protected final String TEXT_288 = "\";";
  protected final String TEXT_289 = NL + "                                pathString_";
  protected final String TEXT_290 = " = pathString_";
  protected final String TEXT_291 = ".substring(pathString_";
  protected final String TEXT_292 = ".indexOf(\"/\") + 1);";
  protected final String TEXT_293 = NL + "                            path_";
  protected final String TEXT_294 = " = pathString_";
  protected final String TEXT_295 = ".split(\"/\");";
  protected final String TEXT_296 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_297 = ".processTree(";
  protected final String TEXT_298 = "_dbobject, path_";
  protected final String TEXT_299 = ", ";
  protected final String TEXT_300 = ");";
  protected final String TEXT_301 = NL + "                                mongoDBTreeConverter_";
  protected final String TEXT_302 = ".processTree(";
  protected final String TEXT_303 = "_dbobject, path_";
  protected final String TEXT_304 = ", null);";
  protected final String TEXT_305 = NL + "\t\t\t" + NL + "\t\t\tObject queryObj_";
  protected final String TEXT_306 = "=null;" + NL + "\t\t\tif(data_";
  protected final String TEXT_307 = "!=null){" + NL + "\t\t\t\t";
  protected final String TEXT_308 = NL + "\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_309 = " < bulkWriteOperationSize_";
  protected final String TEXT_310 = "){" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_311 = ".insert((com.mongodb.DBObject)data_";
  protected final String TEXT_312 = ");" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_313 = "++;" + NL + "\t\t\t\t\t\t} else {" + NL + "                            bulkWriteOperation_";
  protected final String TEXT_314 = ".insert((com.mongodb.DBObject)data_";
  protected final String TEXT_315 = ");" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_316 = ".execute();" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_317 = "=1;" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_318 = " = coll_";
  protected final String TEXT_319 = ".initialize";
  protected final String TEXT_320 = "BulkOperation();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_321 = NL + "\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_322 = "=coll_";
  protected final String TEXT_323 = ".insert((com.mongodb.DBObject)data_";
  protected final String TEXT_324 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_325 = NL + "\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_326 = " < bulkWriteOperationSize_";
  protected final String TEXT_327 = "){" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_328 = ".find((com.mongodb.DBObject)data_";
  protected final String TEXT_329 = ").remove();" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_330 = "++;" + NL + "\t\t\t\t\t\t}else{" + NL + "                            bulkWriteOperation_";
  protected final String TEXT_331 = ".find((com.mongodb.DBObject)data_";
  protected final String TEXT_332 = ").remove();" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_333 = ".execute();" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_334 = "=1;" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_335 = " = coll_";
  protected final String TEXT_336 = ".initialize";
  protected final String TEXT_337 = "BulkOperation();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_338 = NL + "\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_339 = "=coll_";
  protected final String TEXT_340 = ".remove((com.mongodb.DBObject)data_";
  protected final String TEXT_341 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_342 = NL + "\t\t\t\t\tqueryObj_";
  protected final String TEXT_343 = " =((com.mongodb.DBObject)data_";
  protected final String TEXT_344 = ").get(";
  protected final String TEXT_345 = ");" + NL + "\t\t\t\t\tdata_";
  protected final String TEXT_346 = "=((com.mongodb.DBObject)data_";
  protected final String TEXT_347 = ").get(";
  protected final String TEXT_348 = ");" + NL + "\t\t\t\t\tif(data_";
  protected final String TEXT_349 = "!=null && queryObj_";
  protected final String TEXT_350 = "!=null){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_351 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_352 = " < bulkWriteOperationSize_";
  protected final String TEXT_353 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_354 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_355 = ").replaceOne((com.mongodb.DBObject)data_";
  protected final String TEXT_356 = ");" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_357 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_358 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_359 = ").replaceOne((com.mongodb.DBObject)data_";
  protected final String TEXT_360 = ");" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_361 = ".execute();" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_362 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_363 = " = coll_";
  protected final String TEXT_364 = ".initialize";
  protected final String TEXT_365 = "BulkOperation();" + NL + "                                }";
  protected final String TEXT_366 = NL + "                                resultMessage_";
  protected final String TEXT_367 = "=coll_";
  protected final String TEXT_368 = ".update((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_369 = ",(com.mongodb.DBObject)data_";
  protected final String TEXT_370 = ");";
  protected final String TEXT_371 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_372 = " < bulkWriteOperationSize_";
  protected final String TEXT_373 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_374 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_375 = ").update(new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_376 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_377 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_378 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_379 = ").update(new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_380 = "));" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_381 = ".execute();" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_382 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_383 = " = coll_";
  protected final String TEXT_384 = ".initialize";
  protected final String TEXT_385 = "BulkOperation();" + NL + "                                }";
  protected final String TEXT_386 = NL + "                                resultMessage_";
  protected final String TEXT_387 = "=coll_";
  protected final String TEXT_388 = ".update((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_389 = ",new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_390 = "));";
  protected final String TEXT_391 = NL + "\t\t\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_392 = " < bulkWriteOperationSize_";
  protected final String TEXT_393 = "){" + NL + "\t\t\t\t\t\t\t\t\tcom.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_394 = " = bulkWriteOperation_";
  protected final String TEXT_395 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_396 = ");" + NL + "\t\t\t\t\t\t\t\t\tcom.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_397 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_398 = ".upsert();" + NL + "\t\t\t\t\t\t\t\t\tbulkUpdateRequestBuilder_";
  protected final String TEXT_399 = ".replaceOne((com.mongodb.DBObject)data_";
  protected final String TEXT_400 = ");" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_401 = "++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "                                    com.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_402 = " = bulkWriteOperation_";
  protected final String TEXT_403 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_404 = ");" + NL + "                                    com.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_405 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_406 = ".upsert();" + NL + "                                    bulkUpdateRequestBuilder_";
  protected final String TEXT_407 = ".replaceOne((com.mongodb.DBObject)data_";
  protected final String TEXT_408 = ");" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_409 = ".execute();" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_410 = "=1;" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_411 = " = coll_";
  protected final String TEXT_412 = ".initialize";
  protected final String TEXT_413 = "BulkOperation();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_414 = NL + "\t\t\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_415 = "=coll_";
  protected final String TEXT_416 = ".update((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_417 = ",(com.mongodb.DBObject)data_";
  protected final String TEXT_418 = ",true,false);" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_419 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_420 = " < bulkWriteOperationSize_";
  protected final String TEXT_421 = "){" + NL + "                                    com.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_422 = " = bulkWriteOperation_";
  protected final String TEXT_423 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_424 = ");" + NL + "                                    com.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_425 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_426 = ".upsert();" + NL + "                                    bulkUpdateRequestBuilder_";
  protected final String TEXT_427 = ".update(new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_428 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_429 = "++;" + NL + "                                }else{" + NL + "                                    com.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_430 = " = bulkWriteOperation_";
  protected final String TEXT_431 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_432 = ");" + NL + "                                    com.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_433 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_434 = ".upsert();" + NL + "                                    bulkUpdateRequestBuilder_";
  protected final String TEXT_435 = ".update(new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_436 = "));" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_437 = ".execute();" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_438 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_439 = " = coll_";
  protected final String TEXT_440 = ".initialize";
  protected final String TEXT_441 = "BulkOperation();" + NL + "                                }";
  protected final String TEXT_442 = NL + "                                resultMessage_";
  protected final String TEXT_443 = "=coll_";
  protected final String TEXT_444 = ".update((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_445 = ",new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_446 = "),true,false);";
  protected final String TEXT_447 = "\t" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_448 = NL + "\t\t\t\t\t\t\tthrow new Exception(\"Data node or Query node configuration error! \");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_449 = NL + "\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_450 = " - Data node or Query node configuration error!\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_451 = NL + "\t\t\t\t\t\t\tSystem.err.println(\"Data node or Query node configuration error!\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_452 = "\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_453 = NL + "    \t\t\t\tif(resultMessage_";
  protected final String TEXT_454 = "!=null && resultMessage_";
  protected final String TEXT_455 = ".getError()!=null){" + NL + "    \t\t\t\t\t";
  protected final String TEXT_456 = NL + "    \t\t\t\t\t\tthrow new Exception(resultMessage_";
  protected final String TEXT_457 = ".getError());" + NL + "    \t\t\t\t\t";
  protected final String TEXT_458 = NL + "    \t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_459 = " - \" + resultMessage_";
  protected final String TEXT_460 = ".getError());" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_461 = NL + "    \t\t\t\t\t\tSystem.err.println(resultMessage_";
  protected final String TEXT_462 = ".getError());" + NL + "    \t\t\t\t\t";
  protected final String TEXT_463 = NL + "    \t\t\t\t}" + NL + "    \t\t\t\t";
  protected final String TEXT_464 = NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_465 = NL + "\t\t\t\t\tthrow new Exception(\"There no data in json,Please check the json configuration\");" + NL + "\t\t\t\t";
  protected final String TEXT_466 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_467 = " - There no data in json,Please check the json configuration\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_468 = NL + "\t\t\t\t\tSystem.err.println(\"There no data in json,Please check the json configuration\");" + NL + "\t\t\t\t";
  protected final String TEXT_469 = "\t" + NL + "\t\t\t}\t\t" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String dbversion;
	if(useExistingConnection){
	    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
        dbversion = ElementParameterParser.getValue(connectionNode, "__DB_VERSION__");
    }else{
        dbversion = ElementParameterParser.getValue(node, "__DB_VERSION__");
    }

    stringBuffer.append(TEXT_1);
    if("MONGODB_3_5_X".equals(dbversion)) {
    stringBuffer.append(TEXT_2);
    
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	String dataNode = ElementParameterParser.getValue(node,"__DATA_NODE__");
	String queryNode = ElementParameterParser.getValue(node,"__QUERY_NODE__");
	boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    boolean setBulkWrite = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_BULK_WRITE__"));
    String bulkWriteOperationSize = ElementParameterParser.getValue(node, "__BULK_WRITE_SIZE__");
    boolean bulkWriteType = "Ordered".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BULK_WRITE_TYPE__"));
    boolean removeRoot = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOVE_ROOT__"));
    List<Map<String, String>> rootTable = 
        (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
    List<Map<String, String>> loopTable = 
        (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
    List<Map<String, String>> groupTable = 
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");

    // BulkWrite is only supportted on Mongo 2.6+ drivers
    final boolean bulkWrite = setBulkWrite;
    boolean updateAll = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__UPDATE_ALL__"));
    
    List<IMetadataTable> metadatas = node.getMetadataList();
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
            for (IMetadataColumn column: metadata.getListColumns()) {
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                if ((javaType == JavaTypesManager.DATE) || (javaType == JavaTypesManager.BYTE_ARRAY)) {
                    for (Map<String, String> root: rootTable) {
                        if (root.get("COLUMN").equals(column.getLabel())) {
                            
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(root.get("PATH"));
    stringBuffer.append(TEXT_22);
    
                            if (removeRoot) {
                                
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
                            }
                            
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
                            if (javaType == JavaTypesManager.DATE) {
                                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_34);
    
                            } else { // Byte Array
                                
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
                            }
                            // note: we cannot break here, they may be multiple values
                        }
                    }

                    for (Map<String, String> loop: loopTable) {
                        if (loop.get("COLUMN").equals(column.getLabel())) {
                            
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(loop.get("PATH"));
    stringBuffer.append(TEXT_44);
    
                            if (removeRoot) {
                                
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
                            }
                            
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
                            if (javaType == JavaTypesManager.DATE) {
                                
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_56);
    
                            } else { // Byte Array
                                
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
                            }
                            // note: we cannot break here, they may be multiple values
                        }
                    }

                    for (Map<String, String> group: groupTable) {
                        if (group.get("COLUMN").equals(column.getLabel())) {
                            
    stringBuffer.append(TEXT_61);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(group.get("PATH"));
    stringBuffer.append(TEXT_66);
    
                            if (removeRoot) {
                                
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
                            }
                            
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
                            if (javaType == JavaTypesManager.DATE) {
                                
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_78);
    
                            } else { // Byte Array
                                
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
                            }
                            // note: we cannot break here, they may be multiple values
                        }
                    }
                }
            }
			
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
				if("Insert".equalsIgnoreCase(dataAction)){
					// Bulk Writes
					if(bulkWrite){
						// Add inserts untill bulksize is reached then execute and re-initialze the bulk operation
						
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
					// Single Writes
					}else{
					
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
					}
				// Other operations (UPDATE, UPSERT, DELETE)
				}else if("DELETE".equalsIgnoreCase(dataAction)){
				// Bulk Delete
					if(bulkWrite){
						
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
					}else{
						
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
					}
				}else{
				
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(queryNode);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(dataNode);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
						if("UPDATE".equalsIgnoreCase(dataAction)){
	                        // Bulk Updates
                            if(bulkWrite){
                                
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
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
                            }else{
                            
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
                            }
                        } else if("SET".equalsIgnoreCase(dataAction)){
                            // Bulk Updates
                            if(bulkWrite){
                                
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
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
                            }else{
                                if(updateAll){
                            	
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
                                } else {
                                
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
                                }
                            }
                        } else if("UPSERT".equalsIgnoreCase(dataAction)){
                            // Bulk Upsert
							if(bulkWrite){
								
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
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
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
							}else{
								
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
							}
                        } else if("UPSERT_WITH_SET".equalsIgnoreCase(dataAction)){
                            // Bulk Upsert
                            if(bulkWrite){
                                
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
                            }else{
                                if(updateAll){
                            	
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    
                                } else {
                                
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
                                }
                            }
                        }
						
    stringBuffer.append(TEXT_210);
    
						if(dieOnError){
						
    stringBuffer.append(TEXT_211);
    
						}else{
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
							}
							
    stringBuffer.append(TEXT_214);
    
						}
						
    stringBuffer.append(TEXT_215);
    
				}
    			
    stringBuffer.append(TEXT_216);
    
				if(dieOnError){
				
    stringBuffer.append(TEXT_217);
    
				}else{
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
					}
					
    stringBuffer.append(TEXT_220);
    
				}
				
    stringBuffer.append(TEXT_221);
    
		}
	}
	
    } else {
    stringBuffer.append(TEXT_222);
    
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	String dataNode = ElementParameterParser.getValue(node,"__DATA_NODE__");
	String queryNode = ElementParameterParser.getValue(node,"__QUERY_NODE__");
	boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    boolean setBulkWrite = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_BULK_WRITE__"));
    String bulkWriteOperationSize = ElementParameterParser.getValue(node, "__BULK_WRITE_SIZE__");
    String bulkWriteType = ElementParameterParser.getValue(node, "__BULK_WRITE_TYPE__");

    boolean removeRoot = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOVE_ROOT__"));
    List<Map<String, String>> rootTable = 
        (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
    List<Map<String, String>> loopTable = 
        (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
    List<Map<String, String>> groupTable = 
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");

    // BulkWrite is only supportted on Mongo 2.6+ drivers
    final boolean bulkWrite = setBulkWrite & (!"MONGODB_2_5_X".equalsIgnoreCase(dbversion));
    
    List<IMetadataTable> metadatas = node.getMetadataList();
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){
		
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
			}
			
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    
			}
			
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    
            for (IMetadataColumn column: metadata.getListColumns()) {
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                if ((javaType == JavaTypesManager.DATE) || (javaType == JavaTypesManager.BYTE_ARRAY)) {
                    for (Map<String, String> root: rootTable) {
                        if (root.get("COLUMN").equals(column.getLabel())) {
                            
    stringBuffer.append(TEXT_239);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(root.get("PATH"));
    stringBuffer.append(TEXT_244);
    
                            if (removeRoot) {
                                
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
                            }
                            
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    
                            if (javaType == JavaTypesManager.DATE) {
                                
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_256);
    
                            } else { // Byte Array
                                
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    
                            }
                            // note: we cannot break here, they may be multiple values
                        }
                    }

                    for (Map<String, String> loop: loopTable) {
                        if (loop.get("COLUMN").equals(column.getLabel())) {
                            
    stringBuffer.append(TEXT_261);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(loop.get("PATH"));
    stringBuffer.append(TEXT_266);
    
                            if (removeRoot) {
                                
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    
                            }
                            
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    
                            if (javaType == JavaTypesManager.DATE) {
                                
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_278);
    
                            } else { // Byte Array
                                
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
                            }
                            // note: we cannot break here, they may be multiple values
                        }
                    }

                    for (Map<String, String> group: groupTable) {
                        if (group.get("COLUMN").equals(column.getLabel())) {
                            
    stringBuffer.append(TEXT_283);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(group.get("PATH"));
    stringBuffer.append(TEXT_288);
    
                            if (removeRoot) {
                                
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    
                            }
                            
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    
                            if (javaType == JavaTypesManager.DATE) {
                                
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_300);
    
                            } else { // Byte Array
                                
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
                            }
                            // note: we cannot break here, they may be multiple values
                        }
                    }
                }
            }
			
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
				if("Insert".equalsIgnoreCase(dataAction)){
					// Bulk Writes
					if(bulkWrite){
						// Add inserts untill bulksize is reached then execute and re-initialze the bulk operation
						
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_320);
    
					// Single Writes
					}else{
					
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    
					}
				// Other operations (UPDATE, UPSERT, DELETE)
				}else if("DELETE".equalsIgnoreCase(dataAction)){
				// Bulk Delete
					if(bulkWrite){
						
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_337);
    
					}else{
						
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
					}
				}else{
				
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(queryNode);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(dataNode);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    
						if("UPDATE".equalsIgnoreCase(dataAction)){
	                        // Bulk Updates
                            if(bulkWrite){
                                
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
    stringBuffer.append(cid);
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
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_365);
    
                            }else{
                                
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    
                            }
                        } else if("SET".equalsIgnoreCase(dataAction)){
                            // Bulk Updates
                            if(bulkWrite){
                                
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_385);
    
                            }else{
                                
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    
                            }
                        } else if("UPSERT".equalsIgnoreCase(dataAction)){
                            // Bulk Upsert
							if(bulkWrite){
								
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_413);
    
							}else{
								
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    
							}
                        } else if("UPSERT_WITH_SET".equalsIgnoreCase(dataAction)){
                            // Bulk Upsert
                            if(bulkWrite){
                                
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_441);
    
                            }else{
                                
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    
                            }
                        }
						
    stringBuffer.append(TEXT_447);
    
						if(dieOnError){
						
    stringBuffer.append(TEXT_448);
    
						}else{
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    
							}
							
    stringBuffer.append(TEXT_451);
    
						}
						
    stringBuffer.append(TEXT_452);
    
				}
				
                if (dbversion.equals("MONGODB_2_5_X")) {
                
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    
    					if(dieOnError){
    					
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    
    					}else{
    						if(isLog4jEnabled){
    						
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    
    						}
    						
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    
    					}
    					
    stringBuffer.append(TEXT_463);
    
                }
    			
    stringBuffer.append(TEXT_464);
    
				if(dieOnError){
				
    stringBuffer.append(TEXT_465);
    
				}else{
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    
					}
					
    stringBuffer.append(TEXT_468);
    
				}
				
    stringBuffer.append(TEXT_469);
    
		}
	}
	
    }
    return stringBuffer.toString();
  }
}
