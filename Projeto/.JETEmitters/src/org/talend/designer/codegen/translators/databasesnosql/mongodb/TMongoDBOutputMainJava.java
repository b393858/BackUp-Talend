package org.talend.designer.codegen.translators.databasesnosql.mongodb;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;

public class TMongoDBOutputMainJava
{
  protected static String nl;
  public static synchronized TMongoDBOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBOutputMainJava result = new TMongoDBOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "try{";
  protected final String TEXT_4 = NL + "\t\t\t\tupdateObjectUtil_";
  protected final String TEXT_5 = ".setObject(new org.bson.Document());" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\t\tqueryObjectUtil_";
  protected final String TEXT_7 = ".setObject(new org.bson.Document());" + NL + "\t\t\t\t\tint countKey_";
  protected final String TEXT_8 = "=0;" + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "\t                            if (";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = " != null) {" + NL + "    \t                            ";
  protected final String TEXT_12 = NL + "    \t                                    queryObjectUtil_";
  protected final String TEXT_13 = ".putkeyNode(pathMap_";
  protected final String TEXT_14 = ".get(\"";
  protected final String TEXT_15 = "\"),\"";
  protected final String TEXT_16 = "\", ";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ");" + NL + "    \t                                    countKey_";
  protected final String TEXT_19 = "++;" + NL + "    \t                                ";
  protected final String TEXT_20 = NL + "                                    updateObjectUtil_";
  protected final String TEXT_21 = ".put(pathMap_";
  protected final String TEXT_22 = ".get(\"";
  protected final String TEXT_23 = "\"),\"";
  protected final String TEXT_24 = "\", ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ");" + NL + "\t                            }";
  protected final String TEXT_27 = NL + "                                        queryObjectUtil_";
  protected final String TEXT_28 = ".putkeyNode(pathMap_";
  protected final String TEXT_29 = ".get(\"";
  protected final String TEXT_30 = "\"),\"";
  protected final String TEXT_31 = "\", ";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ");" + NL + "                                        countKey_";
  protected final String TEXT_34 = "++;";
  protected final String TEXT_35 = NL + "                                updateObjectUtil_";
  protected final String TEXT_36 = ".put(pathMap_";
  protected final String TEXT_37 = ".get(\"";
  protected final String TEXT_38 = "\"),\"";
  protected final String TEXT_39 = "\", ";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\t\t\t\torg.bson.Document updateObj_";
  protected final String TEXT_43 = " = updateObjectUtil_";
  protected final String TEXT_44 = ".getObject();" + NL + "\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_46 = " < bulkWriteOperationSize_";
  protected final String TEXT_47 = "){" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_48 = ".add(new com.mongodb.client.model.InsertOneModel<org.bson.Document>(updateObj_";
  protected final String TEXT_49 = "));" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_50 = "++;" + NL + "\t\t\t\t\t\t} else {" + NL + "                            bulkWriteOperation_";
  protected final String TEXT_51 = ".add(new com.mongodb.client.model.InsertOneModel<org.bson.Document>(updateObj_";
  protected final String TEXT_52 = "));" + NL + "\t\t\t\t\t\t\tcoll_";
  protected final String TEXT_53 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_54 = ", new com.mongodb.client.model.BulkWriteOptions().ordered(";
  protected final String TEXT_55 = "));" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_56 = "=1;" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_57 = " = new java.util.ArrayList();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\tcoll_";
  protected final String TEXT_59 = ".insertOne(updateObj_";
  protected final String TEXT_60 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\tif(countKey_";
  protected final String TEXT_62 = " <=0){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\t\t\tthrow new Exception(\"Must have at least one key in schema\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_65 = " - Must have at least one key in schema\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\t\t\tSystem.err.println(\"Must have at least one key in schema\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\torg.bson.Document queryObj_";
  protected final String TEXT_68 = " = queryObjectUtil_";
  protected final String TEXT_69 = ".getObject();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_71 = " < bulkWriteOperationSize_";
  protected final String TEXT_72 = "){" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_73 = ".add(new com.mongodb.client.model.ReplaceOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_74 = ",updateObj_";
  protected final String TEXT_75 = "));" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_76 = "++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_77 = ".add(new com.mongodb.client.model.ReplaceOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_78 = ",updateObj_";
  protected final String TEXT_79 = "));" + NL + "\t\t\t\t\t\t\t\t\tcoll_";
  protected final String TEXT_80 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_81 = ", new com.mongodb.client.model.BulkWriteOptions().ordered(";
  protected final String TEXT_82 = "));" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_83 = "=1;" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_84 = " = new java.util.ArrayList();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\t\t\t\tcoll_";
  protected final String TEXT_86 = ".replaceOne(queryObj_";
  protected final String TEXT_87 = ", updateObj_";
  protected final String TEXT_88 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_89 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_90 = " < bulkWriteOperationSize_";
  protected final String TEXT_91 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_92 = ".add(new com.mongodb.client.model.UpdateOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_93 = ",new org.bson.Document(\"$set\", updateObj_";
  protected final String TEXT_94 = ")));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_95 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_96 = ".add(new com.mongodb.client.model.UpdateOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_97 = ",new org.bson.Document(\"$set\", updateObj_";
  protected final String TEXT_98 = ")));" + NL + "                                    coll_";
  protected final String TEXT_99 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_100 = ", new com.mongodb.client.model.BulkWriteOptions().ordered(";
  protected final String TEXT_101 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_102 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_103 = " = new java.util.ArrayList();" + NL + "                                }";
  protected final String TEXT_104 = NL + "                                coll_";
  protected final String TEXT_105 = ".updateMany(queryObj_";
  protected final String TEXT_106 = ",new org.bson.Document(\"$set\", updateObj_";
  protected final String TEXT_107 = "));";
  protected final String TEXT_108 = NL + "                                coll_";
  protected final String TEXT_109 = ".updateOne(queryObj_";
  protected final String TEXT_110 = ",new org.bson.Document(\"$set\", updateObj_";
  protected final String TEXT_111 = "));";
  protected final String TEXT_112 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_113 = " < bulkWriteOperationSize_";
  protected final String TEXT_114 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_115 = ".add(new com.mongodb.client.model.ReplaceOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_116 = ",updateObj_";
  protected final String TEXT_117 = ",new com.mongodb.client.model.UpdateOptions().upsert(true)));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_118 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_119 = ".add(new com.mongodb.client.model.ReplaceOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_120 = ",updateObj_";
  protected final String TEXT_121 = ",new com.mongodb.client.model.UpdateOptions().upsert(true)));" + NL + "                                    coll_";
  protected final String TEXT_122 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_123 = ", new com.mongodb.client.model.BulkWriteOptions().ordered(";
  protected final String TEXT_124 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_125 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_126 = " = new java.util.ArrayList();" + NL + "                                }";
  protected final String TEXT_127 = NL + "                                coll_";
  protected final String TEXT_128 = ".replaceOne(queryObj_";
  protected final String TEXT_129 = ",updateObj_";
  protected final String TEXT_130 = ",new com.mongodb.client.model.UpdateOptions().upsert(true));";
  protected final String TEXT_131 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_132 = " < bulkWriteOperationSize_";
  protected final String TEXT_133 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_134 = ".add(new com.mongodb.client.model.UpdateOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_135 = ",new org.bson.Document(\"$set\", updateObj_";
  protected final String TEXT_136 = "),new com.mongodb.client.model.UpdateOptions().upsert(true)));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_137 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_138 = ".add(new com.mongodb.client.model.UpdateOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_139 = ",new org.bson.Document(\"$set\", updateObj_";
  protected final String TEXT_140 = "),new com.mongodb.client.model.UpdateOptions().upsert(true)));" + NL + "                                    coll_";
  protected final String TEXT_141 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_142 = ", new com.mongodb.client.model.BulkWriteOptions().ordered(";
  protected final String TEXT_143 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_144 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_145 = " = new java.util.ArrayList();" + NL + "                                }";
  protected final String TEXT_146 = NL + "                                coll_";
  protected final String TEXT_147 = ".updateMany(queryObj_";
  protected final String TEXT_148 = ",new org.bson.Document(\"$set\", updateObj_";
  protected final String TEXT_149 = "),new com.mongodb.client.model.UpdateOptions().upsert(true));";
  protected final String TEXT_150 = NL + "                                coll_";
  protected final String TEXT_151 = ".updateOne(queryObj_";
  protected final String TEXT_152 = ",new org.bson.Document(\"$set\", updateObj_";
  protected final String TEXT_153 = "),new com.mongodb.client.model.UpdateOptions().upsert(true));";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_155 = " < bulkWriteOperationSize_";
  protected final String TEXT_156 = "){" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_157 = ".add(new com.mongodb.client.model.DeleteOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_158 = "));" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_159 = "++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t    bulkWriteOperation_";
  protected final String TEXT_160 = ".add(new com.mongodb.client.model.DeleteOneModel<org.bson.Document>(queryObj_";
  protected final String TEXT_161 = "));" + NL + "\t\t\t\t\t\t\t\t\tcoll_";
  protected final String TEXT_162 = ".bulkWrite(bulkWriteOperation_";
  protected final String TEXT_163 = ");" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_164 = "=1;" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_165 = " = new java.util.ArrayList();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\t\t\t\t\tcoll_";
  protected final String TEXT_167 = ".deleteOne(queryObj_";
  protected final String TEXT_168 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t\t} catch (Exception e_";
  protected final String TEXT_171 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_172 = NL + "    \t\t\t\t\t";
  protected final String TEXT_173 = NL + "    \t\t\t\t\t\tthrow e_";
  protected final String TEXT_174 = ";" + NL + "    \t\t\t\t\t";
  protected final String TEXT_175 = NL + "    \t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_176 = " - \" + e_";
  protected final String TEXT_177 = ".getMessage());" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_178 = NL + "    \t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_179 = ".getMessage());" + NL + "    \t\t\t\t\t";
  protected final String TEXT_180 = NL + "    \t\t\t}" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_181 = " ++;" + NL + "\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_183 = " - [";
  protected final String TEXT_184 = "] - Writing the record \" + nb_line_";
  protected final String TEXT_185 = " + \" into database.\");" + NL + "\t\t\t\t";
  protected final String TEXT_186 = NL + "\t";
  protected final String TEXT_187 = NL + "\t\t\t\tcom.mongodb.WriteResult resultMessage_";
  protected final String TEXT_188 = "=null;" + NL + "\t\t\t\tupdateObjectUtil_";
  protected final String TEXT_189 = ".setObject(new com.mongodb.BasicDBObject());" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_190 = NL + "\t\t\t\t\tqueryObjectUtil_";
  protected final String TEXT_191 = ".setObject(new com.mongodb.BasicDBObject());" + NL + "\t\t\t\t\tint countKey_";
  protected final String TEXT_192 = "=0;" + NL + "\t\t\t\t";
  protected final String TEXT_193 = NL + "\t                            if (";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = " != null) {" + NL + "    \t                            ";
  protected final String TEXT_196 = NL + "    \t                                    queryObjectUtil_";
  protected final String TEXT_197 = ".putkeyNode(pathMap_";
  protected final String TEXT_198 = ".get(\"";
  protected final String TEXT_199 = "\"),\"";
  protected final String TEXT_200 = "\", ";
  protected final String TEXT_201 = ".";
  protected final String TEXT_202 = ");" + NL + "    \t                                    countKey_";
  protected final String TEXT_203 = "++;" + NL + "    \t                                ";
  protected final String TEXT_204 = NL + "                                    updateObjectUtil_";
  protected final String TEXT_205 = ".put(pathMap_";
  protected final String TEXT_206 = ".get(\"";
  protected final String TEXT_207 = "\"),\"";
  protected final String TEXT_208 = "\", ";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = ");" + NL + "\t                            }";
  protected final String TEXT_211 = NL + "                                        queryObjectUtil_";
  protected final String TEXT_212 = ".putkeyNode(pathMap_";
  protected final String TEXT_213 = ".get(\"";
  protected final String TEXT_214 = "\"),\"";
  protected final String TEXT_215 = "\", ";
  protected final String TEXT_216 = ".";
  protected final String TEXT_217 = ");" + NL + "                                        countKey_";
  protected final String TEXT_218 = "++;";
  protected final String TEXT_219 = NL + "                                updateObjectUtil_";
  protected final String TEXT_220 = ".put(pathMap_";
  protected final String TEXT_221 = ".get(\"";
  protected final String TEXT_222 = "\"),\"";
  protected final String TEXT_223 = "\", ";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = ");";
  protected final String TEXT_226 = NL + "\t\t\t\tcom.mongodb.BasicDBObject updateObj_";
  protected final String TEXT_227 = " = updateObjectUtil_";
  protected final String TEXT_228 = ".getObject();" + NL + "\t\t\t\t";
  protected final String TEXT_229 = NL + "\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_230 = " < bulkWriteOperationSize_";
  protected final String TEXT_231 = "){" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_232 = ".insert(updateObj_";
  protected final String TEXT_233 = ");" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_234 = "++;" + NL + "\t\t\t\t\t\t} else {" + NL + "                            bulkWriteOperation_";
  protected final String TEXT_235 = ".insert(updateObj_";
  protected final String TEXT_236 = ");" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_237 = ".execute();" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_238 = "=1;" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_239 = " = coll_";
  protected final String TEXT_240 = ".initialize";
  protected final String TEXT_241 = "BulkOperation();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_243 = "=coll_";
  protected final String TEXT_244 = ".insert(updateObj_";
  protected final String TEXT_245 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_246 = NL + "\t\t\t\t\tif(countKey_";
  protected final String TEXT_247 = " <=0){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_248 = NL + "\t\t\t\t\t\t\tthrow new Exception(\"Must have at least one key in schema\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_249 = NL + "\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_250 = " - Must have at least one key in schema\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\t\tSystem.err.println(\"Must have at least one key in schema\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_252 = NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tcom.mongodb.BasicDBObject queryObj_";
  protected final String TEXT_253 = " = queryObjectUtil_";
  protected final String TEXT_254 = ".getObject();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_255 = NL + "\t\t\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_256 = " < bulkWriteOperationSize_";
  protected final String TEXT_257 = "){" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_258 = ".find(queryObj_";
  protected final String TEXT_259 = ").replaceOne(updateObj_";
  protected final String TEXT_260 = ");" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_261 = "++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_262 = ".find(queryObj_";
  protected final String TEXT_263 = ").replaceOne(updateObj_";
  protected final String TEXT_264 = ");" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_265 = ".execute();" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_266 = "=1;" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_267 = " = coll_";
  protected final String TEXT_268 = ".initialize";
  protected final String TEXT_269 = "BulkOperation();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_270 = NL + "\t\t\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_271 = "=coll_";
  protected final String TEXT_272 = ".update(queryObj_";
  protected final String TEXT_273 = ", updateObj_";
  protected final String TEXT_274 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_275 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_276 = " < bulkWriteOperationSize_";
  protected final String TEXT_277 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_278 = ".find(queryObj_";
  protected final String TEXT_279 = ").update(new com.mongodb.BasicDBObject(\"$set\", updateObj_";
  protected final String TEXT_280 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_281 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_282 = ".find(queryObj_";
  protected final String TEXT_283 = ").update(new com.mongodb.BasicDBObject(\"$set\", updateObj_";
  protected final String TEXT_284 = "));" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_285 = ".execute();" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_286 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_287 = " = coll_";
  protected final String TEXT_288 = ".initialize";
  protected final String TEXT_289 = "BulkOperation();" + NL + "                                }";
  protected final String TEXT_290 = NL + "                                resultMessage_";
  protected final String TEXT_291 = "=coll_";
  protected final String TEXT_292 = ".update(queryObj_";
  protected final String TEXT_293 = ",new com.mongodb.BasicDBObject(\"$set\", updateObj_";
  protected final String TEXT_294 = "), false, ";
  protected final String TEXT_295 = ");";
  protected final String TEXT_296 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_297 = " < bulkWriteOperationSize_";
  protected final String TEXT_298 = "){" + NL + "                                    com.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_299 = " = bulkWriteOperation_";
  protected final String TEXT_300 = ".find(queryObj_";
  protected final String TEXT_301 = ");" + NL + "                                    com.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_302 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_303 = ".upsert();" + NL + "                                    bulkUpdateRequestBuilder_";
  protected final String TEXT_304 = ".replaceOne(updateObj_";
  protected final String TEXT_305 = ");" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_306 = "++;" + NL + "                                }else{" + NL + "                                    com.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_307 = " = bulkWriteOperation_";
  protected final String TEXT_308 = ".find(queryObj_";
  protected final String TEXT_309 = ");" + NL + "                                    com.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_310 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_311 = ".upsert();" + NL + "                                    bulkUpdateRequestBuilder_";
  protected final String TEXT_312 = ".replaceOne(updateObj_";
  protected final String TEXT_313 = ");" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_314 = ".execute();" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_315 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_316 = " = coll_";
  protected final String TEXT_317 = ".initialize";
  protected final String TEXT_318 = "BulkOperation();" + NL + "                                }";
  protected final String TEXT_319 = NL + "                                resultMessage_";
  protected final String TEXT_320 = "=coll_";
  protected final String TEXT_321 = ".update(queryObj_";
  protected final String TEXT_322 = ",updateObj_";
  protected final String TEXT_323 = ",true,false);";
  protected final String TEXT_324 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_325 = " < bulkWriteOperationSize_";
  protected final String TEXT_326 = "){" + NL + "                                    com.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_327 = " = bulkWriteOperation_";
  protected final String TEXT_328 = ".find(queryObj_";
  protected final String TEXT_329 = ");" + NL + "                                    com.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_330 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_331 = ".upsert();" + NL + "                                    bulkUpdateRequestBuilder_";
  protected final String TEXT_332 = ".update(new com.mongodb.BasicDBObject(\"$set\", updateObj_";
  protected final String TEXT_333 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_334 = "++;" + NL + "                                }else{" + NL + "                                    com.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_335 = " = bulkWriteOperation_";
  protected final String TEXT_336 = ".find(queryObj_";
  protected final String TEXT_337 = ");" + NL + "                                    com.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_338 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_339 = ".upsert();" + NL + "                                    bulkUpdateRequestBuilder_";
  protected final String TEXT_340 = ".update(new com.mongodb.BasicDBObject(\"$set\", updateObj_";
  protected final String TEXT_341 = "));" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_342 = ".execute();" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_343 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_344 = " = coll_";
  protected final String TEXT_345 = ".initialize";
  protected final String TEXT_346 = "BulkOperation();" + NL + "                                }";
  protected final String TEXT_347 = NL + "                                resultMessage_";
  protected final String TEXT_348 = "=coll_";
  protected final String TEXT_349 = ".update(queryObj_";
  protected final String TEXT_350 = ",new com.mongodb.BasicDBObject(\"$set\", updateObj_";
  protected final String TEXT_351 = "),true,";
  protected final String TEXT_352 = ");";
  protected final String TEXT_353 = NL + "\t\t\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_354 = " < bulkWriteOperationSize_";
  protected final String TEXT_355 = "){" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_356 = ".find(queryObj_";
  protected final String TEXT_357 = ").remove();" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_358 = "++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_359 = ".find(queryObj_";
  protected final String TEXT_360 = ").remove();" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_361 = ".execute();" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_362 = "=1;" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_363 = " = coll_";
  protected final String TEXT_364 = ".initialize";
  protected final String TEXT_365 = "BulkOperation();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_366 = NL + "\t\t\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_367 = "=coll_";
  protected final String TEXT_368 = ".remove(queryObj_";
  protected final String TEXT_369 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_370 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_371 = NL + "    \t\t\t\tif(resultMessage_";
  protected final String TEXT_372 = "!=null && resultMessage_";
  protected final String TEXT_373 = ".getError()!=null){" + NL + "    \t\t\t\t\t";
  protected final String TEXT_374 = NL + "    \t\t\t\t\t\tthrow new Exception(resultMessage_";
  protected final String TEXT_375 = ".getError());" + NL + "    \t\t\t\t\t";
  protected final String TEXT_376 = NL + "    \t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_377 = " - \" + resultMessage_";
  protected final String TEXT_378 = ".getError());" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_379 = NL + "    \t\t\t\t\t\tSystem.err.println(resultMessage_";
  protected final String TEXT_380 = ".getError());" + NL + "    \t\t\t\t\t";
  protected final String TEXT_381 = NL + "    \t\t\t\t}" + NL + "    \t\t\t\t";
  protected final String TEXT_382 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_383 = " ++;" + NL + "\t\t\t\t";
  protected final String TEXT_384 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_385 = " - [";
  protected final String TEXT_386 = "] - Writing the record \" + nb_line_";
  protected final String TEXT_387 = " + \" into database.\");" + NL + "\t\t\t\t";

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
	boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    java.util.List<java.util.Map<String, String>> mappings = (java.util.List<java.util.Map<String, String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");

    boolean bulkWrite = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_BULK_WRITE__"));
    String bulkWriteOperationSize = ElementParameterParser.getValue(node, "__BULK_WRITE_SIZE__");
    boolean bulkWriteType = "Ordered".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BULK_WRITE_TYPE__"));
    boolean updateAll = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__UPDATE_ALL__"));

	IConnection inConn = null;
	IMetadataTable metadata = null;
	
	if(inConns!=null && inConns.size()> 0) {
		inConn = inConns.get(0);
		metadata = inConn.getMetadataTable();
	}

    stringBuffer.append(TEXT_3);
    

	if (metadata!=null) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		for (IConnection conn : conns) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				List<IMetadataColumn> columnList = metadata.getListColumns();
				int sizeColumns = columnList.size();

				// Create the BasicDBObject
				
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
				if(!"INSERT".equalsIgnoreCase(dataAction)){
				
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
				}
				// Set key/values of the BasicObject
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columnList.get(i);
					
					for (java.util.Map<String, String> mapping: mappings) {
					    if (column.getLabel().equals(mapping.get("SCHEMA_COLUMN"))) {
	                        if ("true".equals(mapping.get("REMOVE_NULL_FIELD"))) {
	                            
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_11);
    
    	                            if (!"INSERT".equalsIgnoreCase(dataAction) && column.isKey()){
    	                                
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                                    }
                                    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    
                            } else {
                                if (!"INSERT".equalsIgnoreCase(dataAction) && column.isKey()){
                                    
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
                                }
                                
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_41);
    
                            }
                            break;
                        }
		            }
  				}
  				// Get the BasicDBObject
				
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    

				// INSERT operation
				if ("INSERT".equalsIgnoreCase(dataAction)) {
					// Bulk Writes
					if(bulkWrite){
						// Add inserts untill bulksize is reached then execute and re-initialze the bulk operation
						
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
					// Single Writes
					}else{
					
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
					}
				// Other operations (UPDATE, UPSERT, DELETE)
				}else{
				
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
						if(dieOnError){
						
    stringBuffer.append(TEXT_63);
    
						}else{
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
							}
							
    stringBuffer.append(TEXT_66);
    
						}
						
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
						// UPDATE
						if("UPDATE".equalsIgnoreCase(dataAction)){
							// Bulk Updates 
							if(bulkWrite){
								
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
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
							}else{
								
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
							}
						// SET
						} else if("SET".equalsIgnoreCase(dataAction)){
                            // Bulk Updates
                            if(bulkWrite){
                                
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
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
                            }else{
                                if(updateAll){
                            	
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
                                } else {
                                
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
                                }
                            }
                        // UPSERT
						} else if("UPSERT".equalsIgnoreCase(dataAction)){
                            // Bulk Upsert
                            if(bulkWrite){
                                
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
                            }else{
                                
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
                            }
                        // UPSERT WITH SET
                        } else if("UPSERT_WITH_SET".equalsIgnoreCase(dataAction)){
                            // Bulk Upsert
                            if(bulkWrite){
                                
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
                            }else{
                                if(updateAll){
                            	
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
                                } else {
                                
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
                                }
                            }
                        // DELETE
                        } else if("DELETE".equalsIgnoreCase(dataAction)){
							// Bulk Delete
							if(bulkWrite){
								
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
							}else{
								
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
							}
						}
						
    stringBuffer.append(TEXT_169);
    
				}
				
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    

				// Die on Error 
				// Used only with MONGODB 2.5
				// 2.5 doesn't support BulkWrites => No BulkWrites Die and Error
                    
    stringBuffer.append(TEXT_172);
    
    					if(dieOnError){
    					
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
    					}else{
    						if(isLog4jEnabled){
    						
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
    						}
    						
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    
    					}
    					
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    

				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    
				}

			}
		}
	}
	
    } else {
    stringBuffer.append(TEXT_186);
    
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    java.util.List<java.util.Map<String, String>> mappings = (java.util.List<java.util.Map<String, String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");

    boolean setBulkWrite = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_BULK_WRITE__"));
    String bulkWriteOperationSize = ElementParameterParser.getValue(node, "__BULK_WRITE_SIZE__");
    String bulkWriteType = ElementParameterParser.getValue(node, "__BULK_WRITE_TYPE__");
    // BulkWrite is only supportted on Mongo 2.6+ drivers
    final boolean bulkWrite = setBulkWrite & (!"MONGODB_2_5_X".equalsIgnoreCase(dbversion));
    boolean updateAll = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__UPDATE_ALL__"));

	IConnection inConn = null;
	IMetadataTable metadata = null;
	
	if(inConns!=null && inConns.size()> 0) {
		inConn = inConns.get(0);
		metadata = inConn.getMetadataTable();
	}

	if (metadata!=null) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		for (IConnection conn : conns) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				List<IMetadataColumn> columnList = metadata.getListColumns();
				int sizeColumns = columnList.size();

				// Create the BasicDBObject
				
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
				if(!"INSERT".equalsIgnoreCase(dataAction)){
				
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
				}
				// Set key/values of the BasicObject
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columnList.get(i);
					
					for (java.util.Map<String, String> mapping: mappings) {
					    if (column.getLabel().equals(mapping.get("SCHEMA_COLUMN"))) {
	                        if ("true".equals(mapping.get("REMOVE_NULL_FIELD"))) {
	                            
    stringBuffer.append(TEXT_193);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_195);
    
    	                            if (!"INSERT".equalsIgnoreCase(dataAction) && column.isKey()){
    	                                
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
                                    }
                                    
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_210);
    
                            } else {
                                if (!"INSERT".equalsIgnoreCase(dataAction) && column.isKey()){
                                    
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
                                }
                                
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_225);
    
                            }
                            break;
                        }
		            }
  				}
  				// Get the BasicDBObject
				
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    

				// INSERT operation
				if ("INSERT".equalsIgnoreCase(dataAction)) {
					// Bulk Writes
					if(bulkWrite){
						// Add inserts untill bulksize is reached then execute and re-initialze the bulk operation
						
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_241);
    
					// Single Writes
					}else{
					
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    
					}
				// Other operations (UPDATE, UPSERT, DELETE)
				}else{
				
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
						if(dieOnError){
						
    stringBuffer.append(TEXT_248);
    
						}else{
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    
							}
							
    stringBuffer.append(TEXT_251);
    
						}
						
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    
						// UPDATE
						if("UPDATE".equalsIgnoreCase(dataAction)){
							// Bulk Updates 
							if(bulkWrite){
								
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_269);
    
							}else{
								
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    
							}
						// SET
						} else if("SET".equalsIgnoreCase(dataAction)){
                            // Bulk Updates
                            if(bulkWrite){
                                
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_289);
    
                            }else{
                            	
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(updateAll);
    stringBuffer.append(TEXT_295);
    
                            }
                        // UPSERT
						} else if("UPSERT".equalsIgnoreCase(dataAction)){
                            // Bulk Upsert
                            if(bulkWrite){
                                
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_318);
    
                            }else{
                                
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    
                            }
                        // UPSERT WITH SET
                        } else if("UPSERT_WITH_SET".equalsIgnoreCase(dataAction)){
                            // Bulk Upsert
                            if(bulkWrite){
                                
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
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
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_346);
    
                            }else{
                            	
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(updateAll);
    stringBuffer.append(TEXT_352);
    
                            }
                        // DELETE
                        } else if("DELETE".equalsIgnoreCase(dataAction)){
							// Bulk Delete
							if(bulkWrite){
								
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
    
							}
						}
						
    stringBuffer.append(TEXT_370);
    
				}

				// Die on Error 
				// Used only with MONGODB 2.5
				// 2.5 doesn't support BulkWrites => No BulkWrites Die and Error
                if (dbversion.equals("MONGODB_2_5_X")) {
                    
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    
    					if(dieOnError){
    					
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    
    					}else{
    						if(isLog4jEnabled){
    						
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    
    						}
    						
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    
    					}
    					
    stringBuffer.append(TEXT_381);
    
                }

    			
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    

				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    
				}

			}
		}
	}
	
    }
    return stringBuffer.toString();
  }
}
