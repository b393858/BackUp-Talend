package org.talend.designer.codegen.translators.databasesnosql.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TMongoDBOutputBeginJava
{
  protected static String nl;
  public static synchronized TMongoDBOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBOutputBeginJava result = new TMongoDBOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\tint nb_line_";
  protected final String TEXT_4 = " = 0;" + NL + "\t";
  protected final String TEXT_5 = NL + "\t\t\tclass DBObjectUtil_";
  protected final String TEXT_6 = " {" + NL + "\t\t\t\t" + NL + "\t\t\t\tprivate org.bson.Document object = null;" + NL + "\t\t\t\t//Put value to embedded document" + NL + "\t\t\t\t//If have no embedded document, put the value to root document" + NL + "\t\t\t\tpublic void put(String parentNode, String curentName, Object value) {" + NL + "\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode)) {" + NL + "\t\t\t\t\t\tobject.put(curentName, value);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tString objNames[]= parentNode.split(\"\\\\.\");" + NL + "\t\t\t\t\t\torg.bson.Document lastNode = getParentNode(parentNode, objNames.length-1);" + NL + "\t\t\t\t\t\tlastNode.put(curentName, value);" + NL + "\t\t\t\t\t\torg.bson.Document parenttNode = null;" + NL + "\t\t\t\t\t\tfor (int i = objNames.length - 1; i >=0; i--) {" + NL + "\t\t\t\t\t\t\tparenttNode=getParentNode(parentNode, i-1);" + NL + "\t\t\t\t\t\t\tparenttNode.put(objNames[i], lastNode);" + NL + "\t\t\t\t\t\t\tlastNode=clone(parenttNode);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tobject=lastNode;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tprivate org.bson.Document clone(org.bson.Document source){" + NL + "\t\t\t\t\torg.bson.Document to = new org.bson.Document();" + NL + "\t\t\t\t\tfor(java.util.Map.Entry<String,Object> cur:source.entrySet()) {" + NL + "\t\t\t\t\t\tto.append(cur.getKey(), cur.getValue());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn to;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\t//Get node(embedded document) by path configuration" + NL + "\t\t\t\tpublic org.bson.Document getParentNode(String parentNode, int index) {" + NL + "\t\t\t\t\torg.bson.Document document = object;" + NL + "\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode)) {" + NL + "\t\t\t\t\t\treturn object;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tString objNames[] = parentNode.split(\"\\\\.\");" + NL + "\t\t\t\t\t\tfor (int i = 0; i <= index; i++) {" + NL + "\t\t\t\t\t\t\tdocument = (org.bson.Document) document" + NL + "\t\t\t\t\t\t\t\t\t.get(objNames[i]);" + NL + "\t\t\t\t\t\t\tif (document == null) {" + NL + "\t\t\t\t\t\t\t\tdocument = new org.bson.Document();" + NL + "\t\t\t\t\t\t\t\treturn document;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif (i == index) {" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn document;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void putkeyNode(String parentNode, String curentName, Object value){" + NL + "\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode) || \".\".equals(parentNode)) {" + NL + "\t\t\t\t\t\tput(parentNode, curentName, value);" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tput(\"\", parentNode+\".\"+curentName, value);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\tpublic org.bson.Document getObject() {" + NL + "\t\t\t\t\treturn this.object;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void setObject(org.bson.Document object){" + NL + "\t\t\t\t\tthis.object=object;" + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tDBObjectUtil_";
  protected final String TEXT_7 = " updateObjectUtil_";
  protected final String TEXT_8 = "=new DBObjectUtil_";
  protected final String TEXT_9 = "();" + NL + "\t\t\tDBObjectUtil_";
  protected final String TEXT_10 = " queryObjectUtil_";
  protected final String TEXT_11 = "=new DBObjectUtil_";
  protected final String TEXT_12 = "();" + NL + "\t\t\tjava.util.Map<String, String> pathMap_";
  protected final String TEXT_13 = "=new java.util.HashMap<String, String>();" + NL + "\t\t\tcom.mongodb.MongoClient mongo_";
  protected final String TEXT_14 = "=null;" + NL + "\t\t\tcom.mongodb.client.MongoDatabase db_";
  protected final String TEXT_15 = "=null;" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tpathMap_";
  protected final String TEXT_17 = ".put(\"";
  protected final String TEXT_18 = "\",";
  protected final String TEXT_19 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_21 = "=(com.mongodb.MongoClient)globalMap.get(\"mongo_";
  protected final String TEXT_22 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_23 = " = (com.mongodb.client.MongoDatabase) globalMap.get(\"db_";
  protected final String TEXT_24 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_25 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_26 = " - Get an existing client from \" + \"";
  protected final String TEXT_27 = "\" + \".\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Get an existing DB from \" + \"";
  protected final String TEXT_29 = "\" + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.OFF);" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.SEVERE);";
  protected final String TEXT_32 = NL + "\t \t\t    // Empty client options" + NL + "                com.mongodb.MongoClientOptions clientOptions_";
  protected final String TEXT_33 = " = new com.mongodb.MongoClientOptions.Builder().build();";
  protected final String TEXT_34 = NL + "                    clientOptions_";
  protected final String TEXT_35 = " = new com.mongodb.MongoClientOptions.Builder()" + NL + "                    .socketFactory(javax.net.ssl.SSLSocketFactory.getDefault())" + NL + "                    .build();";
  protected final String TEXT_36 = NL + "                // Empty client credentials list" + NL + "                java.util.List<com.mongodb.MongoCredential> mongoCredentialList_";
  protected final String TEXT_37 = " = new java.util.ArrayList<com.mongodb.MongoCredential>();" + NL;
  protected final String TEXT_38 = NL + "                    com.mongodb.MongoCredential mongoCredential_";
  protected final String TEXT_39 = ";";
  protected final String TEXT_40 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_41 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = "; ";
  protected final String TEXT_46 = NL + "                    \t\t\tmongoCredential_";
  protected final String TEXT_47 = " = com.mongodb.MongoCredential.createCredential(";
  protected final String TEXT_48 = ", ";
  protected final String TEXT_49 = ", new String(decryptedPassword_";
  protected final String TEXT_50 = ").toCharArray());" + NL;
  protected final String TEXT_51 = NL + "                            mongoCredential_";
  protected final String TEXT_52 = " = com.mongodb.MongoCredential.createPlainCredential(";
  protected final String TEXT_53 = ", \"$external\", new String(decryptedPassword_";
  protected final String TEXT_54 = ").toCharArray());";
  protected final String TEXT_55 = NL + "                            mongoCredential_";
  protected final String TEXT_56 = " = com.mongodb.MongoCredential.createScramSha1Credential(";
  protected final String TEXT_57 = ", ";
  protected final String TEXT_58 = ", new String(decryptedPassword_";
  protected final String TEXT_59 = ").toCharArray());";
  protected final String TEXT_60 = NL + "                        System.setProperty(\"java.security.krb5.realm\", ";
  protected final String TEXT_61 = ");" + NL + "                        System.setProperty(\"java.security.krb5.kdc\", ";
  protected final String TEXT_62 = ");" + NL + "                        System.setProperty(\"javax.security.auth.useSubjectCredsOnly\", \"false\");" + NL + "                        mongoCredential_";
  protected final String TEXT_63 = " = com.mongodb.MongoCredential.createGSSAPICredential(";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "                    mongoCredentialList_";
  protected final String TEXT_66 = ".add(mongoCredential_";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "                    List<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_69 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();";
  protected final String TEXT_70 = NL + "                        addrs_";
  protected final String TEXT_71 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_72 = ",";
  protected final String TEXT_73 = "));";
  protected final String TEXT_74 = NL + "                    mongo_";
  protected final String TEXT_75 = " = new ";
  protected final String TEXT_76 = "(addrs_";
  protected final String TEXT_77 = ", mongoCredentialList_";
  protected final String TEXT_78 = ", clientOptions_";
  protected final String TEXT_79 = ");";
  protected final String TEXT_80 = NL + "                    com.mongodb.ServerAddress serverAddress_";
  protected final String TEXT_81 = " = new com.mongodb.ServerAddress(";
  protected final String TEXT_82 = ", ";
  protected final String TEXT_83 = ");" + NL + "                    mongo_";
  protected final String TEXT_84 = " = new ";
  protected final String TEXT_85 = "(serverAddress_";
  protected final String TEXT_86 = ", mongoCredentialList_";
  protected final String TEXT_87 = ", clientOptions_";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "\t\t\t\tresourceMap.put(\"mongo_";
  protected final String TEXT_90 = "\", mongo_";
  protected final String TEXT_91 = ");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_92 = " = mongo_";
  protected final String TEXT_93 = ".getDatabase(";
  protected final String TEXT_94 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t    db_";
  protected final String TEXT_96 = ".withWriteConcern(com.mongodb.WriteConcern.";
  protected final String TEXT_97 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t";
  protected final String TEXT_99 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_100 = " - Connecting to \" + mongo_";
  protected final String TEXT_101 = ".getServerAddressList() + \".\");" + NL + "\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\t\tdb_";
  protected final String TEXT_103 = ".getCollection(";
  protected final String TEXT_104 = ").drop();" + NL + "\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\tcom.mongodb.client.MongoCollection<org.bson.Document> coll_";
  protected final String TEXT_106 = " = db_";
  protected final String TEXT_107 = ".getCollection(";
  protected final String TEXT_108 = ");" + NL + "\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\tList<com.mongodb.client.model.InsertOneModel<org.bson.Document>> bulkWriteOperation_";
  protected final String TEXT_110 = " = new java.util.ArrayList<com.mongodb.client.model.InsertOneModel<org.bson.Document>>();" + NL + "\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\tList<com.mongodb.client.model.ReplaceOneModel<org.bson.Document>> bulkWriteOperation_";
  protected final String TEXT_112 = " = new java.util.ArrayList<com.mongodb.client.model.ReplaceOneModel<org.bson.Document>>();" + NL + "\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\tList<com.mongodb.client.model.DeleteOneModel<org.bson.Document>> bulkWriteOperation_";
  protected final String TEXT_114 = " = new java.util.ArrayList<com.mongodb.client.model.DeleteOneModel<org.bson.Document>>();" + NL + "\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\tList<com.mongodb.client.model.UpdateOneModel<org.bson.Document>> bulkWriteOperation_";
  protected final String TEXT_116 = " = new java.util.ArrayList<com.mongodb.client.model.UpdateOneModel<org.bson.Document>>();" + NL + "\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t" + NL + "\t\t\t\tint bulkWriteOperationCounter_";
  protected final String TEXT_118 = " = 1;" + NL + "\t\t\t\tint bulkWriteOperationSize_";
  protected final String TEXT_119 = " = Integer.parseInt(";
  protected final String TEXT_120 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_122 = " - Start to write data into database [\" + db_";
  protected final String TEXT_123 = ".getName() + \"].\");" + NL + "\t\t\t";
  protected final String TEXT_124 = NL + "\t";
  protected final String TEXT_125 = NL + "\tint nb_line_";
  protected final String TEXT_126 = " = 0;" + NL + "\t";
  protected final String TEXT_127 = NL + "\t\t\tclass DBObjectUtil_";
  protected final String TEXT_128 = " {" + NL + "\t\t\t" + NL + "\t\t\t\tprivate com.mongodb.BasicDBObject object = null;" + NL + "\t\t\t\t//Put value to embedded document" + NL + "\t\t\t\t//If have no embedded document, put the value to root document" + NL + "\t\t\t\tpublic void put(String parentNode, String curentName, Object value) {" + NL + "\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode)) {" + NL + "\t\t\t\t\t\tobject.put(curentName, value);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tString objNames[]= parentNode.split(\"\\\\.\");" + NL + "\t\t\t\t\t\tcom.mongodb.BasicDBObject lastNode = getParentNode(parentNode, objNames.length-1);" + NL + "\t\t\t\t\t\tlastNode.put(curentName, value);" + NL + "\t\t\t\t\t\tcom.mongodb.BasicDBObject parenttNode = null;" + NL + "\t\t\t\t\t\tfor (int i = objNames.length - 1; i >=0; i--) {" + NL + "\t\t\t\t\t\t\tparenttNode=getParentNode(parentNode, i-1);" + NL + "\t\t\t\t\t\t\tparenttNode.put(objNames[i], lastNode);" + NL + "\t\t\t\t\t\t\tlastNode=(com.mongodb.BasicDBObject)parenttNode.clone();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tobject=lastNode;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t//Get node(embedded document) by path configuration" + NL + "\t\t\t\tpublic com.mongodb.BasicDBObject getParentNode(String parentNode, int index) {" + NL + "\t\t\t\t\tcom.mongodb.BasicDBObject basicDBObject = object;" + NL + "\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode)) {" + NL + "\t\t\t\t\t\treturn object;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tString objNames[] = parentNode.split(\"\\\\.\");" + NL + "\t\t\t\t\t\tfor (int i = 0; i <= index; i++) {" + NL + "\t\t\t\t\t\t\tbasicDBObject = (com.mongodb.BasicDBObject) basicDBObject" + NL + "\t\t\t\t\t\t\t\t\t.get(objNames[i]);" + NL + "\t\t\t\t\t\t\tif (basicDBObject == null) {" + NL + "\t\t\t\t\t\t\t\tbasicDBObject = new com.mongodb.BasicDBObject();" + NL + "\t\t\t\t\t\t\t\treturn basicDBObject;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif (i == index) {" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn basicDBObject;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void putkeyNode(String parentNode, String curentName, Object value){" + NL + "\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode) || \".\".equals(parentNode)) {" + NL + "\t\t\t\t\t\tput(parentNode, curentName, value);" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tput(\"\", parentNode+\".\"+curentName, value);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\tpublic com.mongodb.BasicDBObject getObject() {" + NL + "\t\t\t\t\treturn this.object;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void setObject(com.mongodb.BasicDBObject object){" + NL + "\t\t\t\t\tthis.object=object;" + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tDBObjectUtil_";
  protected final String TEXT_129 = " updateObjectUtil_";
  protected final String TEXT_130 = "=new DBObjectUtil_";
  protected final String TEXT_131 = "();" + NL + "\t\t\tDBObjectUtil_";
  protected final String TEXT_132 = " queryObjectUtil_";
  protected final String TEXT_133 = "=new DBObjectUtil_";
  protected final String TEXT_134 = "();" + NL + "\t\t\tjava.util.Map<String, String> pathMap_";
  protected final String TEXT_135 = "=new java.util.HashMap<String, String>();" + NL + "\t\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_136 = "=null;" + NL + "\t\t\tcom.mongodb.DB db_";
  protected final String TEXT_137 = " =null;" + NL + "\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\tpathMap_";
  protected final String TEXT_139 = ".put(\"";
  protected final String TEXT_140 = "\",";
  protected final String TEXT_141 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_143 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_144 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_145 = " = (com.mongodb.DB) globalMap.get(\"db_";
  protected final String TEXT_146 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_147 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_148 = " - Get an existing client from \" + \"";
  protected final String TEXT_149 = "\" + \".\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_150 = " - Get an existing DB from \" + \"";
  protected final String TEXT_151 = "\" + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.OFF);" + NL + "\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.SEVERE);";
  protected final String TEXT_154 = NL + "\t \t\t    // Empty client options" + NL + "                com.mongodb.MongoClientOptions clientOptions_";
  protected final String TEXT_155 = " = new com.mongodb.MongoClientOptions.Builder().build();";
  protected final String TEXT_156 = NL + "                    clientOptions_";
  protected final String TEXT_157 = " = new com.mongodb.MongoClientOptions.Builder()" + NL + "                    .socketFactory(javax.net.ssl.SSLSocketFactory.getDefault())" + NL + "                    .build();";
  protected final String TEXT_158 = NL + "                // Empty client credentials list" + NL + "                java.util.List<com.mongodb.MongoCredential> mongoCredentialList_";
  protected final String TEXT_159 = " = new java.util.ArrayList<com.mongodb.MongoCredential>();" + NL;
  protected final String TEXT_160 = NL + "                    com.mongodb.MongoCredential mongoCredential_";
  protected final String TEXT_161 = ";";
  protected final String TEXT_162 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_163 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_164 = ");";
  protected final String TEXT_165 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_166 = " = ";
  protected final String TEXT_167 = "; ";
  protected final String TEXT_168 = NL + "                    \t\t\tmongoCredential_";
  protected final String TEXT_169 = " = com.mongodb.MongoCredential.createCredential(";
  protected final String TEXT_170 = ", ";
  protected final String TEXT_171 = ", new String(decryptedPassword_";
  protected final String TEXT_172 = ").toCharArray());";
  protected final String TEXT_173 = NL + "                    \t\t\tmongoCredential_";
  protected final String TEXT_174 = " = com.mongodb.MongoCredential.createMongoCRCredential(";
  protected final String TEXT_175 = ", ";
  protected final String TEXT_176 = ", new String(decryptedPassword_";
  protected final String TEXT_177 = ").toCharArray());";
  protected final String TEXT_178 = NL + "                            mongoCredential_";
  protected final String TEXT_179 = " = com.mongodb.MongoCredential.createPlainCredential(";
  protected final String TEXT_180 = ", \"$external\", new String(decryptedPassword_";
  protected final String TEXT_181 = ").toCharArray());";
  protected final String TEXT_182 = NL + "                            mongoCredential_";
  protected final String TEXT_183 = " = com.mongodb.MongoCredential.createScramSha1Credential(";
  protected final String TEXT_184 = ", ";
  protected final String TEXT_185 = ", new String(decryptedPassword_";
  protected final String TEXT_186 = ").toCharArray());";
  protected final String TEXT_187 = NL + "                        System.setProperty(\"java.security.krb5.realm\", ";
  protected final String TEXT_188 = ");" + NL + "                        System.setProperty(\"java.security.krb5.kdc\", ";
  protected final String TEXT_189 = ");" + NL + "                        System.setProperty(\"javax.security.auth.useSubjectCredsOnly\", \"false\");" + NL + "                        mongoCredential_";
  protected final String TEXT_190 = " = com.mongodb.MongoCredential.createGSSAPICredential(";
  protected final String TEXT_191 = ");";
  protected final String TEXT_192 = NL + "                    mongoCredentialList_";
  protected final String TEXT_193 = ".add(mongoCredential_";
  protected final String TEXT_194 = ");";
  protected final String TEXT_195 = NL + "                    List<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_196 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();";
  protected final String TEXT_197 = NL + "                        addrs_";
  protected final String TEXT_198 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_199 = ",";
  protected final String TEXT_200 = "));";
  protected final String TEXT_201 = NL + "                    mongo_";
  protected final String TEXT_202 = " = new ";
  protected final String TEXT_203 = "(addrs_";
  protected final String TEXT_204 = ", mongoCredentialList_";
  protected final String TEXT_205 = ", clientOptions_";
  protected final String TEXT_206 = ");";
  protected final String TEXT_207 = NL + "                    com.mongodb.ServerAddress serverAddress_";
  protected final String TEXT_208 = " = new com.mongodb.ServerAddress(";
  protected final String TEXT_209 = ", ";
  protected final String TEXT_210 = ");" + NL + "                    mongo_";
  protected final String TEXT_211 = " = new ";
  protected final String TEXT_212 = "(serverAddress_";
  protected final String TEXT_213 = ", mongoCredentialList_";
  protected final String TEXT_214 = ", clientOptions_";
  protected final String TEXT_215 = ");";
  protected final String TEXT_216 = NL + "\t\t\t\tresourceMap.put(\"mongo_";
  protected final String TEXT_217 = "\", mongo_";
  protected final String TEXT_218 = ");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_219 = " = mongo_";
  protected final String TEXT_220 = ".getDB(";
  protected final String TEXT_221 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_222 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_223 = ".setWriteConcern(com.mongodb.WriteConcern.";
  protected final String TEXT_224 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_225 = NL + "\t\t        mongo_";
  protected final String TEXT_226 = ".addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);" + NL + "\t\t        ";
  protected final String TEXT_227 = NL + "\t\t\t";
  protected final String TEXT_228 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_229 = " - Connecting to \" + mongo_";
  protected final String TEXT_230 = ".getServerAddressList() + \".\");" + NL + "\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\tif(db_";
  protected final String TEXT_232 = ".collectionExists(";
  protected final String TEXT_233 = ")){" + NL + "\t\t\t\t\tdb_";
  protected final String TEXT_234 = ".getCollection(";
  protected final String TEXT_235 = ").drop();" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\tcom.mongodb.DBCollection coll_";
  protected final String TEXT_237 = " = db_";
  protected final String TEXT_238 = ".getCollection(";
  protected final String TEXT_239 = ");" + NL + "\t\t\t";
  protected final String TEXT_240 = NL + "\t\t\t\tcom.mongodb.BulkWriteOperation bulkWriteOperation_";
  protected final String TEXT_241 = " = coll_";
  protected final String TEXT_242 = ".initialize";
  protected final String TEXT_243 = "BulkOperation();" + NL + "\t\t\t\tint bulkWriteOperationCounter_";
  protected final String TEXT_244 = " = 1;" + NL + "\t\t\t\tint bulkWriteOperationSize_";
  protected final String TEXT_245 = " = Integer.parseInt(";
  protected final String TEXT_246 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_247 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_248 = " - Start to write data into database [\" + db_";
  protected final String TEXT_249 = ".getName() + \"].\");" + NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String dbversion;
	boolean queryOptionNoTimeOut;
	if(useExistingConnection){
	    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
        dbversion = ElementParameterParser.getValue(connectionNode, "__DB_VERSION__");
        queryOptionNoTimeOut = "true".equalsIgnoreCase(ElementParameterParser.getValue(connectionNode, "__QUERYOPTION_NOTIMEOUT__"));
    }else{
        dbversion = ElementParameterParser.getValue(node, "__DB_VERSION__");
        queryOptionNoTimeOut = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__QUERYOPTION_NOTIMEOUT__"));
    }

    stringBuffer.append(TEXT_1);
    if("MONGODB_3_5_X".equals(dbversion)) {
    stringBuffer.append(TEXT_2);
     

    String dbhost   = ElementParameterParser.getValue(node, "__HOST__");
    String dbname   = ElementParameterParser.getValue(node, "__DATABASE__");
    boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    String authenticationMechanism = ElementParameterParser.getValue(node, "__AUTHENTICATION_MECHANISM__");
    String krbUserPrincipal = ElementParameterParser.getValue(node, "__KRB_USER_PRINCIPAL__");
    String krbRealm = ElementParameterParser.getValue(node, "__KRB_REALM__");
    String krbKdc = ElementParameterParser.getValue(node, "__KRB_KDC__");
    String dbuser   = ElementParameterParser.getValue(node, "__USERNAME__");
    String dbpass   = ElementParameterParser.getValue(node, "__PASSWORD__");
    String mongoPort = ElementParameterParser.getValue(node, "__PORT__");
    String dbport = mongoPort.startsWith("context.") ? "Integer.valueOf(" + mongoPort + ").intValue()" : mongoPort.replace("\"", "");
    String collection=ElementParameterParser.getValue(node, "__COLLECTION__");
    boolean dropExistCollection="true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__DROP_COLLECTION_CREATE__"));
    
    List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
    boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));

    boolean setWriteConcern = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_WRITE_CONCERN__"));
    String writeConcern = ElementParameterParser.getValue(node, "__WRITE_CONCERN__");

    boolean bulkWrite = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_BULK_WRITE__"));
    String bulkWriteOperationSize = ElementParameterParser.getValue(node, "__BULK_WRITE_SIZE__");
    String bulkWriteType = ElementParameterParser.getValue(node, "__BULK_WRITE_TYPE__");
    boolean useAuthDB = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_AUTHENTICATION_DATABASE__"));
    String authDB = ElementParameterParser.getValue(node, "__AUTHENTICATION_DATABASE__");
    String usedAuthenticationDB = useAuthDB ? authDB : dbname;
    String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
    List<IMetadataTable> metadatas = node.getMetadataList();
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){
		
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
			for (int i=0;i<mapping.size();i++) {
				String path = mapping.get(i).get("PARENT_NODE_PATH");
				if(path==null || "".equals(path)){
					path="\"\"";
				}
				String schemaColumn=mapping.get(i).get("SCHEMA_COLUMN");

				
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(schemaColumn);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_19);
    
			}
      		if (useExistingConnection){
      			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_24);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_29);
    
				}
			}else{
	 			List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");
	 		    boolean useSSL = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_SSL__"));

	 		    String mongoDbDriver = "com.mongodb.MongoClient";

	 	  
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_30);
    }else{
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
                if (useSSL) {
                    
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
                }
                
                // Client Credentials
                
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
                // Authentication
                if (authentication){
                    
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
                    if((authenticationMechanism.equals("NEGOTIATE_MEC"))||(authenticationMechanism.equals("PLAIN_MEC"))||(authenticationMechanism.equals("SCRAMSHA1_MEC"))){
                        String passwordFieldName = "__PASSWORD__";
                        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_42);
    } else {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_45);
    }
    
                        if(authenticationMechanism.equals("NEGOTIATE_MEC")){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
                        } else if(authenticationMechanism.equals("PLAIN_MEC")){
                            
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
                        } else if(authenticationMechanism.equals("SCRAMSHA1_MEC")){
                            
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
                        }
                    } else { // GSSAPI SASL (KERBEROS)
                        
    stringBuffer.append(TEXT_60);
    stringBuffer.append(krbRealm);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(krbKdc);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(krbUserPrincipal);
    stringBuffer.append(TEXT_64);
    
                    }
                    
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
                }

                // the client
                if(useReplicaSet){
                    
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
                    for(Map<String,String> replicaAddr:replicaAddrs){
                    
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_73);
    
                    }
                    
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
                }else{
                    
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(mongoDbDriver);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_94);
    

			}

			if(setWriteConcern){
				
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(writeConcern);
    stringBuffer.append(TEXT_97);
    
			}

			
    stringBuffer.append(TEXT_98);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
			}
			if(dropExistCollection){
			
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_104);
    
			}
			
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_108);
    

			// BulkWrite
			if(bulkWrite){
			
			    if("INSERT".equalsIgnoreCase(dataAction)){
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    }else if("UPSERT".equalsIgnoreCase(dataAction)||"UPDATE".equalsIgnoreCase(dataAction)){
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    }else if("DELETE".equalsIgnoreCase(dataAction)){
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    }else { //update set upset_with_set
				
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(bulkWriteOperationSize);
    stringBuffer.append(TEXT_120);
    
			}

			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
			}
    	}
    }
	
    } else {
    stringBuffer.append(TEXT_124);
     

    String dbhost   = ElementParameterParser.getValue(node, "__HOST__");
    String dbname   = ElementParameterParser.getValue(node, "__DATABASE__");
    boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    String authenticationMechanism = ElementParameterParser.getValue(node, "__AUTHENTICATION_MECHANISM__");
    String krbUserPrincipal = ElementParameterParser.getValue(node, "__KRB_USER_PRINCIPAL__");
    String krbRealm = ElementParameterParser.getValue(node, "__KRB_REALM__");
    String krbKdc = ElementParameterParser.getValue(node, "__KRB_KDC__");
    String dbuser   = ElementParameterParser.getValue(node, "__USERNAME__");
    String dbpass   = ElementParameterParser.getValue(node, "__PASSWORD__");
    String mongoPort = ElementParameterParser.getValue(node, "__PORT__");
    String dbport = mongoPort.startsWith("context.") ? "Integer.valueOf(" + mongoPort + ").intValue()" : mongoPort.replace("\"", "");
    String collection=ElementParameterParser.getValue(node, "__COLLECTION__");
    boolean dropExistCollection="true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__DROP_COLLECTION_CREATE__"));
    
    List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
    boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));

    boolean setWriteConcern = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_WRITE_CONCERN__"));
    String writeConcern = ElementParameterParser.getValue(node, "__WRITE_CONCERN__");

    boolean setBulkWrite = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_BULK_WRITE__"));
    String bulkWriteOperationSize = ElementParameterParser.getValue(node, "__BULK_WRITE_SIZE__");
    String bulkWriteType = ElementParameterParser.getValue(node, "__BULK_WRITE_TYPE__");
    // BulkWrite is only supportted on Mongo 2.6+ drivers
    final boolean bulkWrite = setBulkWrite & (!"MONGODB_2_5_X".equalsIgnoreCase(dbversion));
    boolean useAuthDB = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_AUTHENTICATION_DATABASE__"));
    String authDB = ElementParameterParser.getValue(node, "__AUTHENTICATION_DATABASE__");
    String usedAuthenticationDB = useAuthDB ? authDB : dbname;

    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    
    List<IMetadataTable> metadatas = node.getMetadataList();
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){
		
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
    
			for (int i=0;i<mapping.size();i++) {
				String path = mapping.get(i).get("PARENT_NODE_PATH");
				if(path==null || "".equals(path)){
					path="\"\"";
				}
				String schemaColumn=mapping.get(i).get("SCHEMA_COLUMN");

				
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(schemaColumn);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_141);
    
			}
      		if (useExistingConnection){
      			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_146);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_151);
    
				}
			}else{
	 			List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");
	 		    boolean useSSL = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_SSL__"));

	 		    String mongoDbDriver = "com.mongodb.MongoClient";

	 		    
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_152);
    }else{
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
                if (useSSL) {
                    
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
                }
                
                // Client Credentials
                
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
                // Authentication
                if (authentication){
                    
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
                    if((authenticationMechanism.equals("NEGOTIATE_MEC"))||(authenticationMechanism.equals("PLAIN_MEC"))||(authenticationMechanism.equals("SCRAMSHA1_MEC"))){
                        String passwordFieldName = "__PASSWORD__";
                        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_164);
    } else {
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_167);
    }
    
                        if(authenticationMechanism.equals("NEGOTIATE_MEC")){
                			if(dbversion.equals("MONGODB_3_0_X") || dbversion.equals("MONGODB_3_2_X")) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
                        
                			} else {

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
                			}
                        } else if(authenticationMechanism.equals("PLAIN_MEC")){
                            
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
                        } else if(authenticationMechanism.equals("SCRAMSHA1_MEC")){
                            
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
                        }
                    } else { // GSSAPI SASL (KERBEROS)
                        
    stringBuffer.append(TEXT_187);
    stringBuffer.append(krbRealm);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(krbKdc);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(krbUserPrincipal);
    stringBuffer.append(TEXT_191);
    
                    }
                    
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
                }

                // the client
                if(useReplicaSet){
                    
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
                    for(Map<String,String> replicaAddr:replicaAddrs){
                    
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_200);
    
                    }
                    
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    
                }else{
                    
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
                }
                
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_221);
    

			}

			if(setWriteConcern){
				
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(writeConcern);
    stringBuffer.append(TEXT_224);
    
			}

			if(queryOptionNoTimeOut && !useExistingConnection){
		        
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
    		}

			
    stringBuffer.append(TEXT_227);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
			}
			if(dropExistCollection){
			
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_235);
    
			}
			
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_239);
    

			// BulkWrite
			if(bulkWrite){
			
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(bulkWriteOperationSize);
    stringBuffer.append(TEXT_246);
    
			}

			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
			}
    	}
    }
	
    }
    return stringBuffer.toString();
  }
}
