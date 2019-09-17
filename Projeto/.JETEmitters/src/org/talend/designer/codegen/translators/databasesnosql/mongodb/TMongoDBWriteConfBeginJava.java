package org.talend.designer.codegen.translators.databasesnosql.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TMongoDBWriteConfBeginJava
{
  protected static String nl;
  public static synchronized TMongoDBWriteConfBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBWriteConfBeginJava result = new TMongoDBWriteConfBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t\tcom.mongodb.MongoClient mongo_";
  protected final String TEXT_6 = "=null;" + NL + "\t\t\tcom.mongodb.client.MongoDatabase db_";
  protected final String TEXT_7 = "=null;" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_9 = "=null;" + NL + "\t\t\tcom.mongodb.DB db_";
  protected final String TEXT_10 = "=null;" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_14 = "=(com.mongodb.MongoClient)globalMap.get(\"mongo_";
  protected final String TEXT_15 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_16 = " = (com.mongodb.client.MongoDatabase) globalMap.get(\"db_";
  protected final String TEXT_17 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_19 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_20 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_21 = " = (com.mongodb.DB) globalMap.get(\"db_";
  protected final String TEXT_22 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_24 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_25 = " - Get an existing client from \" + \"";
  protected final String TEXT_26 = "\" + \".\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Get an existing DB from \" + \"";
  protected final String TEXT_28 = "\" + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.OFF);" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.SEVERE);";
  protected final String TEXT_32 = NL + "                // Empty client options" + NL + "                com.mongodb.MongoClientOptions clientOptions_";
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
  protected final String TEXT_50 = ").toCharArray());";
  protected final String TEXT_51 = NL + "                    \t\t\tmongoCredential_";
  protected final String TEXT_52 = " = com.mongodb.MongoCredential.createMongoCRCredential(";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ", new String(decryptedPassword_";
  protected final String TEXT_55 = ").toCharArray());";
  protected final String TEXT_56 = NL + "                            mongoCredential_";
  protected final String TEXT_57 = " = com.mongodb.MongoCredential.createPlainCredential(";
  protected final String TEXT_58 = ", \"$external\", new String(decryptedPassword_";
  protected final String TEXT_59 = ").toCharArray());";
  protected final String TEXT_60 = NL + "                            mongoCredential_";
  protected final String TEXT_61 = " = com.mongodb.MongoCredential.createScramSha1Credential(";
  protected final String TEXT_62 = ", ";
  protected final String TEXT_63 = ", new String(decryptedPassword_";
  protected final String TEXT_64 = ").toCharArray());";
  protected final String TEXT_65 = NL + "                        System.setProperty(\"java.security.krb5.realm\", ";
  protected final String TEXT_66 = ");" + NL + "                        System.setProperty(\"java.security.krb5.kdc\", ";
  protected final String TEXT_67 = ");" + NL + "                        System.setProperty(\"javax.security.auth.useSubjectCredsOnly\", \"false\");" + NL + "                        mongoCredential_";
  protected final String TEXT_68 = " = com.mongodb.MongoCredential.createGSSAPICredential(";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "                    mongoCredentialList_";
  protected final String TEXT_71 = ".add(mongoCredential_";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "                    List<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_74 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();";
  protected final String TEXT_75 = NL + "                        addrs_";
  protected final String TEXT_76 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_77 = ",";
  protected final String TEXT_78 = "));";
  protected final String TEXT_79 = NL + "                    mongo_";
  protected final String TEXT_80 = " = new ";
  protected final String TEXT_81 = "(addrs_";
  protected final String TEXT_82 = ", mongoCredentialList_";
  protected final String TEXT_83 = ", clientOptions_";
  protected final String TEXT_84 = ");";
  protected final String TEXT_85 = NL + "                    com.mongodb.ServerAddress serverAddress_";
  protected final String TEXT_86 = " = new com.mongodb.ServerAddress(";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ");" + NL + "                    mongo_";
  protected final String TEXT_89 = " = new ";
  protected final String TEXT_90 = "(serverAddress_";
  protected final String TEXT_91 = ", mongoCredentialList_";
  protected final String TEXT_92 = ", clientOptions_";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = NL + "\t\t\t\tresourceMap.put(\"mongo_";
  protected final String TEXT_95 = "\", mongo_";
  protected final String TEXT_96 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_97 = NL + "\t\t\t\t\tdb_";
  protected final String TEXT_98 = " = mongo_";
  protected final String TEXT_99 = ".getDatabase(";
  protected final String TEXT_100 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\tdb_";
  protected final String TEXT_102 = " = mongo_";
  protected final String TEXT_103 = ".getDB(";
  protected final String TEXT_104 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t        mongo_";
  protected final String TEXT_107 = ".addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);" + NL + "\t\t        ";
  protected final String TEXT_108 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_109 = ".setWriteConcern(com.mongodb.WriteConcern.";
  protected final String TEXT_110 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_111 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_112 = " - Connecting to \" + mongo_";
  protected final String TEXT_113 = ".getServerAddressList() + \".\");" + NL + "\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\tdb_";
  protected final String TEXT_116 = ".getCollection(";
  protected final String TEXT_117 = ").drop();" + NL + "\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\tif(db_";
  protected final String TEXT_119 = ".collectionExists(";
  protected final String TEXT_120 = ")){" + NL + "\t\t\t\t\tdb_";
  protected final String TEXT_121 = ".getCollection(";
  protected final String TEXT_122 = ").drop();" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_123 = NL + NL + "\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\tcom.mongodb.client.MongoCollection<org.bson.Document> coll_";
  protected final String TEXT_126 = " = db_";
  protected final String TEXT_127 = ".getCollection(";
  protected final String TEXT_128 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_129 = NL + "\t\t\t\t\tcom.mongodb.DBCollection coll_";
  protected final String TEXT_130 = " = db_";
  protected final String TEXT_131 = ".getCollection(";
  protected final String TEXT_132 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_133 = NL + NL + "\t\t\t";
  protected final String TEXT_134 = NL + "\t\t\tint bulkWriteOperationCounter_";
  protected final String TEXT_135 = " = 1;" + NL + "\t\t\tint bulkWriteOperationSize_";
  protected final String TEXT_136 = " = Integer.parseInt(";
  protected final String TEXT_137 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\t\t\tList<com.mongodb.client.model.InsertOneModel<org.bson.Document>> bulkWriteOperation_";
  protected final String TEXT_139 = " = new java.util.ArrayList<com.mongodb.client.model.InsertOneModel<org.bson.Document>>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\tList<com.mongodb.client.model.ReplaceOneModel<org.bson.Document>> bulkWriteOperation_";
  protected final String TEXT_141 = " = new java.util.ArrayList<com.mongodb.client.model.ReplaceOneModel<org.bson.Document>>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\tList<com.mongodb.client.model.DeleteOneModel<org.bson.Document>> bulkWriteOperation_";
  protected final String TEXT_143 = " = new java.util.ArrayList<com.mongodb.client.model.DeleteOneModel<org.bson.Document>>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\t\tList<com.mongodb.client.model.UpdateOneModel<org.bson.Document>> bulkWriteOperation_";
  protected final String TEXT_145 = " = new java.util.ArrayList<com.mongodb.client.model.UpdateOneModel<org.bson.Document>>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_147 = NL + "\t\t\t\t\tcom.mongodb.BulkWriteOperation bulkWriteOperation_";
  protected final String TEXT_148 = " = coll_";
  protected final String TEXT_149 = ".initialize";
  protected final String TEXT_150 = "BulkOperation();" + NL + "\t\t\t\t";
  protected final String TEXT_151 = NL + NL + "\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\t" + NL + "\t\t\tnet.sf.json.xml.XMLSerializer xmlSerializer_";
  protected final String TEXT_153 = " = new net.sf.json.xml.XMLSerializer(); " + NL + "\t\t    xmlSerializer_";
  protected final String TEXT_154 = ".clearNamespaces();" + NL + "\t\t    xmlSerializer_";
  protected final String TEXT_155 = ".setSkipNamespaces(true);" + NL + "\t\t    xmlSerializer_";
  protected final String TEXT_156 = ".setForceTopLevelObject(";
  protected final String TEXT_157 = ");" + NL + "\t\t    xmlSerializer_";
  protected final String TEXT_158 = ".setUseLongDecimals(true);" + NL + "\t\t    ";
  protected final String TEXT_159 = NL + "\t\t\t\tjava.util.Queue<String> queue_";
  protected final String TEXT_160 = " = new java.util.concurrent.ConcurrentLinkedQueue<String>();" + NL + "\t\t\t\t" + NL + "\t\t\t\tclass ThreadXMLField_";
  protected final String TEXT_161 = " extends Thread {" + NL + "\t\t\t\t\tjava.util.Queue<String> queue;" + NL + "\t\t\t\t\tjava.util.List<java.util.Map<String,String>> flows;" + NL + "\t\t\t\t\tjava.lang.Exception lastException;" + NL + "\t\t\t\t\tString currentComponent;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_162 = "(java.util.Queue q) {" + NL + "\t\t\t\t\t\tthis.queue = q;" + NL + "\t\t\t\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_163 = "\", queue);" + NL + "\t\t\t\t\t\tlastException = null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_164 = "(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {" + NL + "\t\t\t\t\t\tthis.queue = q;" + NL + "\t\t\t\t\t\tthis.flows = l;" + NL + "\t\t\t\t\t\tlastException = null;" + NL + "\t\t\t\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_165 = "\", queue);" + NL + "\t\t\t\t\t\tglobalMap.put(\"flows_";
  protected final String TEXT_166 = "\", flows);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tpublic java.lang.Exception getLastException() {" + NL + "\t\t\t\t\t\treturn this.lastException;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic String getCurrentComponent() {" + NL + "\t\t\t\t\t\treturn this.currentComponent;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\t\t@Override" + NL + "\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_167 = "Process(globalMap);" + NL + "\t\t\t\t\t\t} catch (TalendException te) {" + NL + "\t\t\t\t\t\t\tthis.lastException = te.getException();" + NL + "\t\t\t\t\t\t\tthis.currentComponent = te.getCurrentComponent();" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_168 = "_FINISH\" + (this.queue==null?\"\":this.queue.hashCode()), \"true\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tThreadXMLField_";
  protected final String TEXT_169 = " txf_";
  protected final String TEXT_170 = " = new ThreadXMLField_";
  protected final String TEXT_171 = "(queue_";
  protected final String TEXT_172 = ");" + NL + "\t\t\t\ttxf_";
  protected final String TEXT_173 = ".start();" + NL + "\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\t\tjava.util.Queue<String> queue_";
  protected final String TEXT_175 = " = (java.util.Queue<String>) globalMap.get(\"queue_";
  protected final String TEXT_176 = "\");" + NL + "\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\tString readFinishMarkWithPipeId_";
  protected final String TEXT_178 = " = \"";
  protected final String TEXT_179 = "_FINISH\"+(queue_";
  protected final String TEXT_180 = "==null?\"\":queue_";
  protected final String TEXT_181 = ".hashCode());" + NL + "\t\t\tString str_";
  protected final String TEXT_182 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_184 = " - Start to write data into database [\"+db_";
  protected final String TEXT_185 = ".getName()+\"], data is generated by [";
  protected final String TEXT_186 = "].\");" + NL + "\t\t\t";
  protected final String TEXT_187 = NL + "\t         /**" + NL + "             * Convert Date and Byte array in mongo DB format" + NL + "             *" + NL + "             */" + NL + "            class MongoDBTreeConverter_";
  protected final String TEXT_188 = " {" + NL + "" + NL + "                /**" + NL + "                 * header method to ease javajet implementation." + NL + "                 **/" + NL + "                public void processTree(Object currentElement, String[] path, String pattern) {" + NL + "                    if (currentElement instanceof ";
  protected final String TEXT_189 = ") {" + NL + "                        // Start index at 1, in order to remove the first unwanted or empty string." + NL + "                        processTree((";
  protected final String TEXT_190 = ")currentElement, path, 1, pattern);" + NL + "                   } else if (currentElement instanceof com.mongodb.BasicDBList) {" + NL + "                       // Start index at 1, in order to remove the first unwanted or empty string." + NL + "                       processTree((com.mongodb.BasicDBList) currentElement, path, 1, pattern);" + NL + "                   }" + NL + "                }" + NL + "" + NL + "                public void processTree(";
  protected final String TEXT_191 = " currentElement, String[] path, int index, String pattern) {" + NL + "                    if (index  < path.length - 1) {" + NL + "                        Object nextElement = currentElement.get(path[index]);" + NL + "                        if (nextElement instanceof ";
  protected final String TEXT_192 = ") {" + NL + "                             processTree((";
  protected final String TEXT_193 = ")nextElement, path, index + 1, pattern);" + NL + "                        } else if (nextElement instanceof com.mongodb.BasicDBList) {" + NL + "                            processTree((com.mongodb.BasicDBList) nextElement, path, index + 1, pattern);" + NL + "                        } else if (nextElement == null && index > 0) {" + NL + "                            // some loop are not reported by the XML tree" + NL + "                            nextElement = currentElement.get(path[index - 1]);" + NL + "                            if (nextElement != null) {" + NL + "                                if (nextElement instanceof ";
  protected final String TEXT_194 = ") {" + NL + "                                    processTree((";
  protected final String TEXT_195 = ")nextElement, path, index, pattern);" + NL + "                               } else if (nextElement instanceof com.mongodb.BasicDBList) {" + NL + "                                   processTree((com.mongodb.BasicDBList) nextElement, path, index, pattern);" + NL + "                               }" + NL + "                            }" + NL + "                        }" + NL + "                    } else {" + NL + "                        // process leaf" + NL + "                        if (currentElement.get(path[path.length - 1]) instanceof com.mongodb.BasicDBList) {" + NL + "                            // if the leaf is a list" + NL + "                            com.mongodb.BasicDBList finalObjects = (com.mongodb.BasicDBList) currentElement.get(path[path.length - 1]);" + NL + "                            com.mongodb.BasicDBList convertedElements = new com.mongodb.BasicDBList();" + NL + "                            for (Object finalObject: finalObjects) {" + NL + "                                if (pattern == null) {" + NL + "                                    // no pattern, we want to parse to a byte array." + NL + "                                    if (finalObject != null) {" + NL + "\t\t\t\t\t\t\t\t                                convertedElements.add(" + NL + "\t\t\t\t\t\t\t\t                                        ((String)finalObject).getBytes());" + NL + "                                    }" + NL + "                                } else {" + NL + "                                    if (finalObject != null) {" + NL + "                                        convertedElements.add(" + NL + "                                                ParserUtils.parseTo_Date((String)finalObject," + NL + "                                                        pattern));" + NL + "                                    }" + NL + "                                }" + NL + "                            }" + NL + "                            finalObjects.clear();" + NL + "                            finalObjects.addAll(convertedElements);" + NL + "                        } else {" + NL + "                            if (pattern == null) {" + NL + "                                // no pattern, we want to parse to a byte array." + NL + "                                if (currentElement.get(path[path.length - 1]) != null) {" + NL + "\t\t\t\t\t\t\t\t                            currentElement.put(path[path.length - 1]," + NL + "\t\t\t\t\t\t\t\t                                    ((String)currentElement.get(path[path.length - 1])).getBytes());" + NL + "                                }" + NL + "                            } else {" + NL + "                                if (currentElement.get(path[path.length - 1]) != null) {" + NL + "                                    currentElement.put(path[path.length - 1]," + NL + "                                            ParserUtils.parseTo_Date((String)(currentElement).get(path[path.length - 1])," + NL + "                                                    pattern));" + NL + "                                }" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                public void processTree(com.mongodb.BasicDBList currentElements, String[] path, int index, String pattern) {" + NL + "                    if (index  < path.length - 1) {" + NL + "                        for (Object currentElement: currentElements) {" + NL + "                            if (currentElement instanceof ";
  protected final String TEXT_196 = ") {" + NL + "                                processTree((";
  protected final String TEXT_197 = ")currentElement, path, index + 1, pattern);" + NL + "                            } else if (currentElement instanceof com.mongodb.BasicDBList) {" + NL + "                                processTree((com.mongodb.BasicDBList) currentElement, path, index + 1, pattern);" + NL + "                            }" + NL + "                        }" + NL + "                    } else {" + NL + "                        // process leaf" + NL + "                        com.mongodb.BasicDBList convertedElements = new com.mongodb.BasicDBList();" + NL + "                        for (Object finalObject: currentElements) {" + NL + "                            if (finalObject instanceof ";
  protected final String TEXT_198 = ") {";
  protected final String TEXT_199 = NL + "                                ";
  protected final String TEXT_200 = " currentElement = (";
  protected final String TEXT_201 = ") finalObject;" + NL + "                                if (pattern == null) {" + NL + "                                    // no pattern, we want to parse to a byte array." + NL + "                                    if (currentElement.get(path[path.length - 1]) != null) {" + NL + "\t\t\t\t\t\t\t\t                                currentElement.put(path[path.length - 1]," + NL + "\t\t\t\t\t\t\t\t                                        ((String)currentElement.get(path[path.length - 1])).getBytes());" + NL + "                                    }" + NL + "                                } else {" + NL + "                                    if (currentElement.get(path[path.length - 1]) != null) {" + NL + "                                        currentElement.put(path[path.length - 1]," + NL + "                                                ParserUtils.parseTo_Date((String)(currentElement).get(path[path.length - 1])," + NL + "                                                        pattern));" + NL + "                                    }" + NL + "                                }" + NL + "                            } else { // loop with raw types" + NL + "                                if (pattern == null) {" + NL + "                                    // no pattern, we want to parse to a byte array." + NL + "                                    if (finalObject != null) {" + NL + "\t\t\t\t\t\t\t\t                                convertedElements.add(" + NL + "\t\t\t\t\t\t\t\t                                        ((String)finalObject).getBytes());" + NL + "                                    }" + NL + "                                } else {" + NL + "                                    if (finalObject != null) {" + NL + "                                        convertedElements.add(" + NL + "                                                ParserUtils.parseTo_Date((String)finalObject," + NL + "                                                        pattern));" + NL + "                                    }" + NL + "                                }" + NL + "                            }" + NL + "                        }" + NL + "                        if (convertedElements.size() > 0) {" + NL + "                            currentElements.clear();" + NL + "                            currentElements.addAll(convertedElements);" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                }" + NL + "            }" + NL + "            MongoDBTreeConverter_";
  protected final String TEXT_202 = " mongoDBTreeConverter_";
  protected final String TEXT_203 = " = new MongoDBTreeConverter_";
  protected final String TEXT_204 = "();" + NL + "\t\t\twhile(!globalMap.containsKey(readFinishMarkWithPipeId_";
  protected final String TEXT_205 = ") || !queue_";
  protected final String TEXT_206 = ".isEmpty()) {" + NL + "\t\t\t\tif (!queue_";
  protected final String TEXT_207 = ".isEmpty()) {" + NL + "\t\t\t\t\tstr_";
  protected final String TEXT_208 = " = queue_";
  protected final String TEXT_209 = ".poll();" + NL + "\t\t\t\t\t//Convert XML to JSON" + NL + "\t\t\t        net.sf.json.JSON json_";
  protected final String TEXT_210 = " = xmlSerializer_";
  protected final String TEXT_211 = ".read(str_";
  protected final String TEXT_212 = ");" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_213 = "++;" + NL + "" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
  	String cid = node.getUniqueName();

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
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
    boolean removeRoot="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOVE_ROOT__"));

    boolean setWriteConcern = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_WRITE_CONCERN__"));
    String writeConcern = ElementParameterParser.getValue(node, "__WRITE_CONCERN__");

    boolean setBulkWrite = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_BULK_WRITE__"));
    String bulkWriteOperationSize = ElementParameterParser.getValue(node, "__BULK_WRITE_SIZE__");
    String bulkWriteType = ElementParameterParser.getValue(node, "__BULK_WRITE_TYPE__");
    boolean useAuthDB = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_AUTHENTICATION_DATABASE__"));
    String authDB = ElementParameterParser.getValue(node, "__AUTHENTICATION_DATABASE__");
    String usedAuthenticationDB = useAuthDB ? authDB : dbname;
    String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
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
        // BulkWrite is only supportted on Mongo 2.6+
    final boolean bulkWrite = setBulkWrite & (!"MONGODB_2_5_X".equalsIgnoreCase(dbversion));

    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
    List<IMetadataTable> metadatas = node.getMetadataList();
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){
		
    stringBuffer.append(TEXT_4);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    } else {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    
      		if (useExistingConnection){
      			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				
    stringBuffer.append(TEXT_12);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_17);
    } else {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_28);
    
				}
			}else{
			
    stringBuffer.append(TEXT_29);
    
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
                			if(dbversion.equals("MONGODB_3_0_X") || dbversion.equals("MONGODB_3_2_X") || version_3_5_X) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
                        
                			} else {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
			                }
                        } else if(authenticationMechanism.equals("PLAIN_MEC")){
                            
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
                        } else if(authenticationMechanism.equals("SCRAMSHA1_MEC")){
                            
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
                        }
                    } else { // GSSAPI SASL (KERBEROS)
                        
    stringBuffer.append(TEXT_65);
    stringBuffer.append(krbRealm);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(krbKdc);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(krbUserPrincipal);
    stringBuffer.append(TEXT_69);
    
                    }
                    
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
                }

                // the client
                if(useReplicaSet){
                    
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
                    for(Map<String,String> replicaAddr:replicaAddrs){
                    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_78);
    
                    }
                    
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
                }else{
                    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
                }
                
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_100);
    } else {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    
			}

			if(queryOptionNoTimeOut){
		        
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
    		}

			if(setWriteConcern){
				
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(writeConcern);
    stringBuffer.append(TEXT_110);
    
			}

			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
			}
			if(dropExistCollection){
			
    stringBuffer.append(TEXT_114);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_117);
    } else {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_123);
    
			}
			
    stringBuffer.append(TEXT_124);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_128);
    } else {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    
			// BulkWrite
			if(bulkWrite){
			
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(bulkWriteOperationSize);
    stringBuffer.append(TEXT_137);
    if(version_3_5_X) {
					if("INSERT".equalsIgnoreCase(dataAction)){
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    }else if("UPSERT".equalsIgnoreCase(dataAction)||"UPDATE".equalsIgnoreCase(dataAction)){
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    }else if("DELETE".equalsIgnoreCase(dataAction)){
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    }else { //update set upset_with_set
					
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    }
    stringBuffer.append(TEXT_146);
    } else {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_150);
    }
    stringBuffer.append(TEXT_151);
    
			}

			
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append((removeRoot?false:true));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
		    INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
			String virtualSourceCid = sourceNode.getUniqueName();
			INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
			String startNodeCid = null; 
			if(startNode != null){
				startNodeCid = startNode.getUniqueName();
			} 
			IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
			if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){
			
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
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
    
			}else{
			
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
			}
		    
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_186);
    
			}
			
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(objectType);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
    	}
    }
	
    return stringBuffer.toString();
  }
}
