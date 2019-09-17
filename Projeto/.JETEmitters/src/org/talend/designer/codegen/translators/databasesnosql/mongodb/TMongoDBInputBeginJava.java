package org.talend.designer.codegen.translators.databasesnosql.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TMongoDBInputBeginJava
{
  protected static String nl;
  public static synchronized TMongoDBInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBInputBeginJava result = new TMongoDBInputBeginJava();
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
  protected final String TEXT_30 = " = 0;" + NL + "\t";
  protected final String TEXT_31 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\t\tcom.mongodb.MongoClient mongo_";
  protected final String TEXT_33 = "=null;" + NL + "\t\t\tcom.mongodb.client.MongoDatabase db_";
  protected final String TEXT_34 = "=null;" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\t\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_36 = "=null;" + NL + "\t\t\tcom.mongodb.DB db_";
  protected final String TEXT_37 = "=null;" + NL + "\t\t";
  protected final String TEXT_38 = NL + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_41 = "=(com.mongodb.MongoClient)globalMap.get(\"mongo_";
  protected final String TEXT_42 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_43 = " = (com.mongodb.client.MongoDatabase) globalMap.get(\"db_";
  protected final String TEXT_44 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_46 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_47 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_48 = " = (com.mongodb.DB) globalMap.get(\"db_";
  protected final String TEXT_49 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + NL + NL + "\t\t\t\t";
  protected final String TEXT_51 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_52 = " - Get an existing client from \" + \"";
  protected final String TEXT_53 = "\" + \".\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_54 = " - Get an existing DB from \" + \"";
  protected final String TEXT_55 = "\" + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t    ";
  protected final String TEXT_57 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.OFF);" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.SEVERE);";
  protected final String TEXT_59 = NL + "\t\t\ttry{ // link with the \"finally\" on the \"finally.javajet\"" + NL + "\t\t\t\t";
  protected final String TEXT_60 = NL + NL + "                // Empty client options" + NL + "                com.mongodb.MongoClientOptions clientOptions_";
  protected final String TEXT_61 = " = new com.mongodb.MongoClientOptions.Builder().build();";
  protected final String TEXT_62 = NL + "                    clientOptions_";
  protected final String TEXT_63 = " = new com.mongodb.MongoClientOptions.Builder()" + NL + "                    .socketFactory(javax.net.ssl.SSLSocketFactory.getDefault())" + NL + "                    .build();";
  protected final String TEXT_64 = NL + "                // Empty client credentials list" + NL + "                java.util.List<com.mongodb.MongoCredential> mongoCredentialList_";
  protected final String TEXT_65 = " = new java.util.ArrayList<com.mongodb.MongoCredential>();" + NL;
  protected final String TEXT_66 = NL + "                    com.mongodb.MongoCredential mongoCredential_";
  protected final String TEXT_67 = ";";
  protected final String TEXT_68 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_69 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_72 = " = ";
  protected final String TEXT_73 = "; ";
  protected final String TEXT_74 = NL + "                    \t\t\tmongoCredential_";
  protected final String TEXT_75 = " = com.mongodb.MongoCredential.createCredential(";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ", new String(decryptedPassword_";
  protected final String TEXT_78 = ").toCharArray());";
  protected final String TEXT_79 = NL + "                    \t\t\tmongoCredential_";
  protected final String TEXT_80 = " = com.mongodb.MongoCredential.createMongoCRCredential(";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = ", new String(decryptedPassword_";
  protected final String TEXT_83 = ").toCharArray());";
  protected final String TEXT_84 = NL + "                            mongoCredential_";
  protected final String TEXT_85 = " = com.mongodb.MongoCredential.createPlainCredential(";
  protected final String TEXT_86 = ", \"$external\", new String(decryptedPassword_";
  protected final String TEXT_87 = ").toCharArray());";
  protected final String TEXT_88 = NL + "                            mongoCredential_";
  protected final String TEXT_89 = " = com.mongodb.MongoCredential.createScramSha1Credential(";
  protected final String TEXT_90 = ", ";
  protected final String TEXT_91 = ", new String(decryptedPassword_";
  protected final String TEXT_92 = ").toCharArray());";
  protected final String TEXT_93 = NL + "                        System.setProperty(\"java.security.krb5.realm\", ";
  protected final String TEXT_94 = ");" + NL + "                        System.setProperty(\"java.security.krb5.kdc\", ";
  protected final String TEXT_95 = ");" + NL + "                        System.setProperty(\"javax.security.auth.useSubjectCredsOnly\", \"false\");" + NL + "                        mongoCredential_";
  protected final String TEXT_96 = " = com.mongodb.MongoCredential.createGSSAPICredential(";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "                    mongoCredentialList_";
  protected final String TEXT_99 = ".add(mongoCredential_";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "\t\t\t\t\tList<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_102 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\t\t\taddrs_";
  protected final String TEXT_104 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_105 = ",";
  protected final String TEXT_106 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_107 = NL + "                    mongo_";
  protected final String TEXT_108 = " = new ";
  protected final String TEXT_109 = "(addrs_";
  protected final String TEXT_110 = ", mongoCredentialList_";
  protected final String TEXT_111 = ", clientOptions_";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "                    com.mongodb.ServerAddress serverAddress_";
  protected final String TEXT_114 = " = new com.mongodb.ServerAddress(";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = ");" + NL + "                    mongo_";
  protected final String TEXT_117 = " = new ";
  protected final String TEXT_118 = "(serverAddress_";
  protected final String TEXT_119 = ", mongoCredentialList_";
  protected final String TEXT_120 = ", clientOptions_";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL + "\t\t\t\t\tdb_";
  protected final String TEXT_123 = " = mongo_";
  protected final String TEXT_124 = ".getDatabase(";
  protected final String TEXT_125 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\tdb_";
  protected final String TEXT_127 = " = mongo_";
  protected final String TEXT_128 = ".getDB(";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t            mongo_";
  protected final String TEXT_132 = ".setReadPreference(com.mongodb.ReadPreference.primary());" + NL + "\t\t\t            ";
  protected final String TEXT_133 = NL + "\t\t\t            mongo_";
  protected final String TEXT_134 = ".setReadPreference(com.mongodb.ReadPreference.primaryPreferred());" + NL + "\t\t\t            ";
  protected final String TEXT_135 = NL + "\t\t\t            mongo_";
  protected final String TEXT_136 = ".setReadPreference(com.mongodb.ReadPreference.secondary());" + NL + "\t\t\t            ";
  protected final String TEXT_137 = NL + "\t\t\t            mongo_";
  protected final String TEXT_138 = ".setReadPreference(com.mongodb.ReadPreference.secondaryPreferred());" + NL + "\t\t\t            ";
  protected final String TEXT_139 = NL + "\t\t\t            mongo_";
  protected final String TEXT_140 = ".setReadPreference(com.mongodb.ReadPreference.nearest());" + NL + "\t\t\t            ";
  protected final String TEXT_141 = NL + "\t\t\t            // Unhandled" + NL + "\t\t\t            ";
  protected final String TEXT_142 = NL + "\t\t\t\t\tmongo_";
  protected final String TEXT_143 = ".addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);" + NL + "\t\t        ";
  protected final String TEXT_144 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_145 = " - Connecting to \" + mongo_";
  protected final String TEXT_146 = ".getServerAddressList() + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_147 = NL + "\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t\t\tcom.mongodb.client.MongoCollection<org.bson.Document> coll_";
  protected final String TEXT_149 = " = db_";
  protected final String TEXT_150 = ".getCollection(";
  protected final String TEXT_151 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\t\tcom.mongodb.DBCollection coll_";
  protected final String TEXT_153 = " = db_";
  protected final String TEXT_154 = ".getCollection(";
  protected final String TEXT_155 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_156 = NL + "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t// Add warning if an index is not in the query." + NL + "\t\t\t\t\tboolean needIndexWarning = true;" + NL + "\t\t\t\t\tString indexList = \"\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_157 = NL + "\t\t\t\t\tfor (com.mongodb.DBObject index: coll_";
  protected final String TEXT_158 = ".listIndexes(com.mongodb.DBObject.class)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_159 = NL + "\t\t\t\t\tfor (com.mongodb.DBObject index: coll_";
  protected final String TEXT_160 = ".getIndexInfo()) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_161 = NL + "\t                " + NL + "\t                    for (String key: ((com.mongodb.DBObject)index.get(\"key\")).keySet()) {" + NL + "\t                        // The regexp is:" + NL + "\t                        // - contain the db DBcolumnName between two backslashed quotes" + NL + "\t                        // - is followed at some point by a colon" + NL + "\t                        // - there is no comma between the the DBcolumnName and the colon" + NL + "\t                        if  ((";
  protected final String TEXT_162 = ").matches(\".*\" + key + \"[^,]*:.*\")) {" + NL + "\t                            // We have an index, do not print error message" + NL + "\t                            needIndexWarning = false;" + NL + "\t                        } else {" + NL + "\t                            // This index is not in the query, add it into the indexList" + NL + "\t                            indexList += \", \" + key;" + NL + "\t                        }" + NL + "\t                    }" + NL + "\t                }" + NL + "\t                if ((!\"\".equals(indexList)) && (needIndexWarning)) {" + NL + "\t                    ";
  protected final String TEXT_163 = NL + "\t                        log.warn(\"";
  protected final String TEXT_164 = " - The query does not contain any reference an index.  [\" + indexList.substring(1) + \" ]\");" + NL + "\t                        ";
  protected final String TEXT_165 = NL + "\t                        System.err.println(\"";
  protected final String TEXT_166 = " - The query does not contain any reference an index.  [\" + indexList.substring(1) + \" ]\");" + NL + "\t                        ";
  protected final String TEXT_167 = NL + "\t                }" + NL + "\t            }catch(com.mongodb.MongoException e){" + NL + "\t            \t// caught an exception after issuing the getIndexInfo()" + NL + "\t            \t// don't fail the whole job" + NL + "\t            \t// maybe due to authorization" + NL + "\t            }" + NL;
  protected final String TEXT_168 = NL + "\t                \t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t\t\tjava.util.List<org.bson.Document> aggregationStages = new java.util.ArrayList<org.bson.Document>();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t\t\t\t\tjava.util.List<com.mongodb.DBObject> aggregationStages = new java.util.ArrayList<com.mongodb.DBObject>();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_171 = NL + "\t                \t" + NL + "\t                ";
  protected final String TEXT_172 = NL + "\t                \t";
  protected final String TEXT_173 = NL + "\t\t\t\t\t\t\taggregationStages.add(org.bson.Document.parse(";
  protected final String TEXT_174 = "));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_175 = NL + "\t\t\t\t\t\t\taggregationStages.add((com.mongodb.DBObject) com.mongodb.util.JSON.parse(";
  protected final String TEXT_176 = "));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_177 = NL + "\t                \t" + NL + "\t                ";
  protected final String TEXT_178 = NL + "\t                \t";
  protected final String TEXT_179 = NL + "\t\t\t\t\t\t\tcom.mongodb.client.MongoCursor<org.bson.Document> cursor_";
  protected final String TEXT_180 = " = coll_";
  protected final String TEXT_181 = ".aggregate(aggregationStages).allowDiskUse(";
  protected final String TEXT_182 = ").iterator();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\t\t\t\tcom.mongodb.Cursor cursor_";
  protected final String TEXT_184 = " = coll_";
  protected final String TEXT_185 = ".aggregate(aggregationStages, com.mongodb.AggregationOptions.builder().outputMode(com.mongodb.AggregationOptions.OutputMode.CURSOR).allowDiskUse(";
  protected final String TEXT_186 = ").build());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_187 = NL + "\t                " + NL + "\t                ";
  protected final String TEXT_188 = NL + "\t                " + NL + "\t                ";
  protected final String TEXT_189 = NL + "\t\t\t\t\torg.bson.Document myQuery_";
  protected final String TEXT_190 = " = org.bson.Document.parse(";
  protected final String TEXT_191 = ");" + NL + "\t                com.mongodb.client.FindIterable<org.bson.Document> fi_";
  protected final String TEXT_192 = " = coll_";
  protected final String TEXT_193 = ".find(myQuery_";
  protected final String TEXT_194 = ").noCursorTimeout(";
  protected final String TEXT_195 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t\t\tcom.mongodb.DBObject myQuery_";
  protected final String TEXT_197 = " = (com.mongodb.DBObject) com.mongodb.util.JSON.parse(";
  protected final String TEXT_198 = ");" + NL + "\t\t    \t\tcom.mongodb.DBObject fields_";
  protected final String TEXT_199 = " = new com.mongodb.BasicDBObject();" + NL + "\t\t  \t\t\tcom.mongodb.DBCursor cursor_";
  protected final String TEXT_200 = " = coll_";
  protected final String TEXT_201 = ".find(myQuery_";
  protected final String TEXT_202 = ", fields_";
  protected final String TEXT_203 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_204 = NL + "\t                " + NL + "\t\t  \t\t\t" + NL + "\t\t  \t\t\t" + NL + "" + NL + "\t\t  \t\t\t " + NL + "\t                ";
  protected final String TEXT_205 = NL + "\t\t\t\t" + NL + "\t\t\t\tclass DBObjectInputUtil_";
  protected final String TEXT_206 = "{" + NL + "\t\t\t\t\t// Get the node value in embedded document, " + NL + "\t\t\t\t\t//If have no embedded document get root document node." + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tpublic Object getValue(String parentNode,String currentName,";
  protected final String TEXT_207 = " dbObject){" + NL + "\t\t\t\t\t\tObject value=null;" + NL + "\t\t\t\t\t\tif(dbObject==null){" + NL + "\t\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode)) {" + NL + "\t\t\t\t\t\t    if (\"*\".equals(currentName)) {" + NL + "\t\t\t\t\t\t        value = dbObject;" + NL + "\t\t\t\t\t\t    } else if (dbObject.get(currentName)!=null){" + NL + "\t\t\t\t\t\t\t\tvalue=dbObject.get(currentName);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tString objNames[] = objNames = parentNode.split(\"\\\\.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_208 = " currentObj=dbObject;" + NL + "\t\t\t\t\t\t\tfor(int i=0;i<objNames.length;i++){" + NL + "\t\t\t\t\t\t\t\tcurrentObj=(";
  protected final String TEXT_209 = ")currentObj.get(objNames[i]);" + NL + "\t\t\t\t\t\t\t\tif(currentObj==null){" + NL + "\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif (\"*\".equals(currentName)) {" + NL + "                                value = currentObj;" + NL + "                            } else if(currentObj!=null){" + NL + "\t\t\t\t\t\t\t\tvalue=currentObj.get(currentName);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn value;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tDBObjectInputUtil_";
  protected final String TEXT_210 = " dbObjectInputUtil_";
  protected final String TEXT_211 = "=new DBObjectInputUtil_";
  protected final String TEXT_212 = "();" + NL + "\t\t\t\tjava.util.Map<String, String> pathMap_";
  protected final String TEXT_213 = "=new java.util.HashMap<String, String>();";
  protected final String TEXT_214 = NL + "\t\t\t\tpathMap_";
  protected final String TEXT_215 = ".put(\"";
  protected final String TEXT_216 = "\",";
  protected final String TEXT_217 = ");";
  protected final String TEXT_218 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\t\t\tfi_";
  protected final String TEXT_220 = " = fi_";
  protected final String TEXT_221 = ".limit(";
  protected final String TEXT_222 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\t\t\tcursor_";
  protected final String TEXT_224 = " = cursor_";
  protected final String TEXT_225 = ".limit(";
  protected final String TEXT_226 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_227 = NL + "\t  \t\t\t";
  protected final String TEXT_228 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_229 = NL + "\t\t\t\t\tcom.mongodb.BasicDBObject orderBy_";
  protected final String TEXT_230 = " = new com.mongodb.BasicDBObject();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\t\tcom.mongodb.DBObject orderBy_";
  protected final String TEXT_232 = " = new com.mongodb.BasicDBObject();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_233 = NL + "\t\t  \t\t";
  protected final String TEXT_234 = NL + "\t\t  \t\torderBy_";
  protected final String TEXT_235 = ".put(";
  protected final String TEXT_236 = ",";
  protected final String TEXT_237 = ");";
  protected final String TEXT_238 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_239 = NL + "\t\t\t\t\tfi_";
  protected final String TEXT_240 = ".sort(orderBy_";
  protected final String TEXT_241 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\t\t\tcursor_";
  protected final String TEXT_243 = ".sort(orderBy_";
  protected final String TEXT_244 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_245 = NL + "\t\t\t\t";
  protected final String TEXT_246 = NL + NL + "\t\t\t\t\t\t";
  protected final String TEXT_247 = NL + "\t\t\t\t\tcom.mongodb.client.MongoCursor<org.bson.Document> cursor_";
  protected final String TEXT_248 = " = fi_";
  protected final String TEXT_249 = ".iterator();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_250 = NL + "\t\t\t\twhile (cursor_";
  protected final String TEXT_251 = ".hasNext()){";
  protected final String TEXT_252 = NL + "\t\t\t\t";
  protected final String TEXT_253 = " o_";
  protected final String TEXT_254 = " = cursor_";
  protected final String TEXT_255 = ".next();" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_256 = "++;";
  protected final String TEXT_257 = NL + "\t\t\t\tObject valueObj_";
  protected final String TEXT_258 = "=null;";
  protected final String TEXT_259 = NL + "                    valueObj_";
  protected final String TEXT_260 = "=dbObjectInputUtil_";
  protected final String TEXT_261 = ".getValue(pathMap_";
  protected final String TEXT_262 = ".get(\"";
  protected final String TEXT_263 = "\"),\"";
  protected final String TEXT_264 = "\",o_";
  protected final String TEXT_265 = ");";
  protected final String TEXT_266 = NL + "\t\t\t\t";
  protected final String TEXT_267 = ".";
  protected final String TEXT_268 = " = valueObj_";
  protected final String TEXT_269 = ";";
  protected final String TEXT_270 = NL + "\t\t\t\tif(valueObj_";
  protected final String TEXT_271 = "!=null && valueObj_";
  protected final String TEXT_272 = ".toString().length() > 0) {";
  protected final String TEXT_273 = NL + "                            if (valueObj_";
  protected final String TEXT_274 = " instanceof java.util.Date) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_275 = ".";
  protected final String TEXT_276 = " = ParserUtils.parseTo_Date((java.util.Date)valueObj_";
  protected final String TEXT_277 = ", ";
  protected final String TEXT_278 = ");" + NL + "                            } else {";
  protected final String TEXT_279 = NL + "                                ";
  protected final String TEXT_280 = ".";
  protected final String TEXT_281 = " = ParserUtils.parseTo_Date((String)valueObj_";
  protected final String TEXT_282 = ", ";
  protected final String TEXT_283 = ");" + NL + "                            }";
  protected final String TEXT_284 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_285 = NL + "\t\t\t\t\t";
  protected final String TEXT_286 = ".";
  protected final String TEXT_287 = " = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(((org.bson.types.Binary)valueObj_";
  protected final String TEXT_288 = ").getData())).toString().getBytes(utf8Charset);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_289 = NL + "\t\t\t\t\t";
  protected final String TEXT_290 = ".";
  protected final String TEXT_291 = " = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap((byte[])valueObj_";
  protected final String TEXT_292 = ")).toString().getBytes(utf8Charset);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_293 = NL + "\t\t\t\t\t";
  protected final String TEXT_294 = ".";
  protected final String TEXT_295 = " = valueObj_";
  protected final String TEXT_296 = ".toString();";
  protected final String TEXT_297 = NL + "                            if (valueObj_";
  protected final String TEXT_298 = ".getClass().equals(Double.class)) {";
  protected final String TEXT_299 = NL + "                                ";
  protected final String TEXT_300 = ".";
  protected final String TEXT_301 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_302 = ".toString()).intValue();" + NL + "                            } else {";
  protected final String TEXT_303 = NL + "                                ";
  protected final String TEXT_304 = ".";
  protected final String TEXT_305 = " = ParserUtils.parseTo_";
  protected final String TEXT_306 = "(valueObj_";
  protected final String TEXT_307 = ".toString());" + NL + "                            }";
  protected final String TEXT_308 = NL + "                            if (valueObj_";
  protected final String TEXT_309 = ".getClass().equals(Double.class)) {";
  protected final String TEXT_310 = NL + "                                ";
  protected final String TEXT_311 = ".";
  protected final String TEXT_312 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_313 = ".toString()).longValue();" + NL + "                            } else {";
  protected final String TEXT_314 = NL + "                                ";
  protected final String TEXT_315 = ".";
  protected final String TEXT_316 = " = ParserUtils.parseTo_";
  protected final String TEXT_317 = "(valueObj_";
  protected final String TEXT_318 = ".toString());" + NL + "                            }";
  protected final String TEXT_319 = NL + "                            if (valueObj_";
  protected final String TEXT_320 = ".getClass().equals(Double.class)) {";
  protected final String TEXT_321 = NL + "                                ";
  protected final String TEXT_322 = ".";
  protected final String TEXT_323 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_324 = ".toString()).shortValue();" + NL + "                            } else {";
  protected final String TEXT_325 = NL + "                                ";
  protected final String TEXT_326 = ".";
  protected final String TEXT_327 = " = ParserUtils.parseTo_";
  protected final String TEXT_328 = "(valueObj_";
  protected final String TEXT_329 = ".toString());" + NL + "                            }";
  protected final String TEXT_330 = NL + "                            ";
  protected final String TEXT_331 = ".";
  protected final String TEXT_332 = " = ParserUtils.parseTo_";
  protected final String TEXT_333 = "(valueObj_";
  protected final String TEXT_334 = ".toString());";
  protected final String TEXT_335 = NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_336 = ".";
  protected final String TEXT_337 = " = ";
  protected final String TEXT_338 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_339 = NL;
  protected final String TEXT_340 = NL;

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

    String dbhost   = ElementParameterParser.getValue(node, "__HOST__");
    String dbname   = ElementParameterParser.getValue(node, "__DATABASE__");
    String dbuser   = ElementParameterParser.getValue(node, "__USERNAME__");
    boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    String authenticationMechanism = ElementParameterParser.getValue(node, "__AUTHENTICATION_MECHANISM__");
    String krbUserPrincipal = ElementParameterParser.getValue(node, "__KRB_USER_PRINCIPAL__");
    String krbRealm = ElementParameterParser.getValue(node, "__KRB_REALM__");
    String krbKdc = ElementParameterParser.getValue(node, "__KRB_KDC__");
    String dbpass   = ElementParameterParser.getValue(node, "__PASSWORD__");
    String mongoPort = ElementParameterParser.getValue(node, "__PORT__");
    String dbport = mongoPort.startsWith("context.") ? "Integer.valueOf(" + mongoPort + ").intValue()" : mongoPort.replace("\"", "");
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String collection = ElementParameterParser.getValue(node,"__COLLECTION__");
    String query = ElementParameterParser.getValue(node,"__QUERY__");
    query = query.replaceAll("\n","");
    query = query.replaceAll("\r","");
  	String limit = ElementParameterParser.getValue(node,"__LIMIT__");

  	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
  	List<Map<String, String>> sorts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SORT__");
  	boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
  	boolean setReadPreference = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_READ_PREFERENCE__"));
    String readPreference = ElementParameterParser.getValue(node, "__READ_PREFERENCE__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    List<Map<String, String>> aggregationStages = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AGGREGATION_STAGES__");
    boolean isAggregationQuery = "AGGREGATION_QUERY".equals(ElementParameterParser.getValue(node,"__QUERY_TYPE__"));
    boolean useAuthDB = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_AUTHENTICATION_DATABASE__"));
    String authDB = ElementParameterParser.getValue(node, "__AUTHENTICATION_DATABASE__");
    String usedAuthenticationDB = useAuthDB ? authDB : dbname;
    boolean useExternalSort = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__EXTERNAL_SORT_AGGREGATION__"));
    boolean queryOptionNoTimeOut;
	String dbversion;
	if(useExistingConnection){
	    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
        dbversion = ElementParameterParser.getValue(connectionNode, "__DB_VERSION__");
        queryOptionNoTimeOut = "true".equalsIgnoreCase(ElementParameterParser.getValue(connectionNode, "__QUERYOPTION_NOTIMEOUT__"));
    }else{
        dbversion = ElementParameterParser.getValue(node, "__DB_VERSION__");
        queryOptionNoTimeOut = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__QUERYOPTION_NOTIMEOUT__"));
    }
    boolean version_3_5_X = "MONGODB_3_5_X".equals(dbversion);
    String objectType = version_3_5_X?"org.bson.Document":"com.mongodb.DBObject";

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
		
    stringBuffer.append(TEXT_31);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    } else {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    
      		if (useExistingConnection){
      			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				
    stringBuffer.append(TEXT_39);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_44);
    } else {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_55);
    
				}
			}else{
			
    stringBuffer.append(TEXT_56);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_57);
    }else{
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    
	 			List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");

                boolean useSSL = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_SSL__"));
                String mongoDbDriver = "com.mongodb.MongoClient";
                
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
                if (useSSL) {
                    
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
                }
                
                // Client Credentials
                
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
                // Authentication
                if (authentication){
                    
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
                    if((authenticationMechanism.equals("NEGOTIATE_MEC"))||(authenticationMechanism.equals("PLAIN_MEC"))||(authenticationMechanism.equals("SCRAMSHA1_MEC"))){
                        String passwordFieldName = "__PASSWORD__";
                        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_70);
    } else {
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_73);
    }
    
                        if(authenticationMechanism.equals("NEGOTIATE_MEC")){
                			if(dbversion.equals("MONGODB_3_0_X") || dbversion.equals("MONGODB_3_2_X") || version_3_5_X) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
                        
                			} else {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
                			}
                        } else if(authenticationMechanism.equals("PLAIN_MEC")){
                            
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
                        } else if(authenticationMechanism.equals("SCRAMSHA1_MEC")){
                            
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
                        }
                    } else { // GSSAPI SASL (KERBEROS)
                        
    stringBuffer.append(TEXT_93);
    stringBuffer.append(krbRealm);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(krbKdc);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(krbUserPrincipal);
    stringBuffer.append(TEXT_97);
    
                    }
                    
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
                }

                // the client
				if(useReplicaSet){
				    
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
					for(Map<String,String> replicaAddr:replicaAddrs){
					
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_106);
    
					}
                    
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
				}else{
                    
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
				}
                
    if(version_3_5_X) {
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_125);
    } else {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    
			}

			if (setReadPreference) {
			        if (readPreference.equals("PRIMARY")) {
			            
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
			        } else if (readPreference.equals("PRIMARY_PREFERRED")) {
			            
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
			        } else if (readPreference.equals("SECONDARY")) {
			            
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
			        } else if (readPreference.equals("SECONDARY_PREFERRED")) {
			            
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
			        } else if (readPreference.equals("NEAREST")) {
			            
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
			        } else {
			            
    stringBuffer.append(TEXT_141);
    
			        }
			}

			if(queryOptionNoTimeOut && !useExistingConnection &&!version_3_5_X){
		        
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
    		}

			if(isLog4jEnabled){
			    
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
			}
			log4jFileUtil.startRetriveDataInfo();

			
    stringBuffer.append(TEXT_147);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_151);
    } else {
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    } else {
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    }
    stringBuffer.append(TEXT_161);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_162);
    
	                    if(isLog4jEnabled){
	                        
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
	                    } else {
	                        
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
	                    }
	                    
    stringBuffer.append(TEXT_167);
    
                // AGGREGATION QUERY
                if(isAggregationQuery){
	                
    stringBuffer.append(TEXT_168);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_169);
    } else {
    stringBuffer.append(TEXT_170);
    }
    stringBuffer.append(TEXT_171);
    
	                for (int i=0; i<aggregationStages.size(); i++){
	                
    stringBuffer.append(TEXT_172);
    if(version_3_5_X) {
	                	
    stringBuffer.append(TEXT_173);
    stringBuffer.append(aggregationStages.get(i).get("AGGREGATION_STAGE"));
    stringBuffer.append(TEXT_174);
    } else {
    stringBuffer.append(TEXT_175);
    stringBuffer.append(aggregationStages.get(i).get("AGGREGATION_STAGE"));
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(TEXT_177);
    
	                }
	                
    stringBuffer.append(TEXT_178);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(useExternalSort);
    stringBuffer.append(TEXT_182);
    } else {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(useExternalSort);
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    
	            // FIND QUERY
                } else {
	                
    stringBuffer.append(TEXT_188);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(queryOptionNoTimeOut);
    stringBuffer.append(TEXT_195);
    } else {
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    }
    stringBuffer.append(TEXT_204);
    
                }
                
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
			for (int i=0;i<mapping.size();i++) {
				String path = mapping.get(i).get("PARENT_NODE_PATH");
				if(path==null || "".equals(path)){
					path="\"\"";
				}
				String schemaColumn=mapping.get(i).get("SCHEMA_COLUMN");

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(schemaColumn);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_217);
    
			}

			// Note: Aggregation queriess do not support limit
			if (limit != null && !"\"\"".equals(limit) && limit.length() > 0 && !isAggregationQuery){

    stringBuffer.append(TEXT_218);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_222);
    } else {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_226);
    }
    stringBuffer.append(TEXT_227);
    
			}

			// Note: Aggregation queriess do not support sort
			if(sorts.size()>0 && !isAggregationQuery){

    stringBuffer.append(TEXT_228);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    } else {
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    }
    stringBuffer.append(TEXT_233);
    
				for(Map<String, String> line:sorts){
					int order=-1;
					if(("asc").equals(line.get("ORDER"))){
        				order=1;
        			}

    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(line.get("COLNAME"));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(order);
    stringBuffer.append(TEXT_237);
    
				}

    stringBuffer.append(TEXT_238);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    } else {
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    }
    stringBuffer.append(TEXT_245);
    
			}

    stringBuffer.append(TEXT_246);
    if(version_3_5_X && !isAggregationQuery) {
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    }
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    
          	columnList = metadata.getListColumns();
          	int sizeColumns = columnList.size();

    stringBuffer.append(TEXT_252);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    
			if(firstConnName.length()>0){

    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columnList.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    
          			if(javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_266);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    
          			}else{

    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
						if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_283);
    
						}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_284);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_285);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    } else {
    stringBuffer.append(TEXT_289);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    }
    
						} else if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_293);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    
						} else if (javaType == JavaTypesManager.INTEGER){

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
                        } else if (javaType == JavaTypesManager.LONG){

    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    
                        } else if (javaType == JavaTypesManager.SHORT){

    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    
                        } else {

    stringBuffer.append(TEXT_330);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    
						}

    stringBuffer.append(TEXT_335);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_338);
    
          			}
				}
				log4jFileUtil.debugRetriveData(node);
			}
      	}
  	}

    stringBuffer.append(TEXT_339);
    stringBuffer.append(TEXT_340);
    return stringBuffer.toString();
  }
}
