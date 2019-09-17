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

public class TMongoDBGridFSPropertiesBeginJava
{
  protected static String nl;
  public static synchronized TMongoDBGridFSPropertiesBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBGridFSPropertiesBeginJava result = new TMongoDBGridFSPropertiesBeginJava();
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
  protected final String TEXT_29 = NL + "\t    ";
  protected final String TEXT_30 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.OFF);" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.SEVERE);";
  protected final String TEXT_32 = NL + "    int nb_line_";
  protected final String TEXT_33 = " = 0;";
  protected final String TEXT_34 = NL + "\t\t";
  protected final String TEXT_35 = NL + "\t\t\tcom.mongodb.MongoClient mongo_";
  protected final String TEXT_36 = "=null;" + NL + "\t\t\tcom.mongodb.client.MongoDatabase db_";
  protected final String TEXT_37 = "=null;" + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_39 = "=null;" + NL + "\t\t\tcom.mongodb.DB db_";
  protected final String TEXT_40 = "=null;" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_43 = "=(com.mongodb.MongoClient)globalMap.get(\"mongo_";
  protected final String TEXT_44 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_45 = " = (com.mongodb.client.MongoDatabase) globalMap.get(\"db_";
  protected final String TEXT_46 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_48 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_49 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_50 = " = (com.mongodb.DB) globalMap.get(\"db_";
  protected final String TEXT_51 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t";
  protected final String TEXT_53 = "  " + NL + "                    log.info(\"";
  protected final String TEXT_54 = " - Get an existing client from \" + \"";
  protected final String TEXT_55 = "\" + \".\");" + NL + "                    log.info(\"";
  protected final String TEXT_56 = " - Get an existing DB from \" + \"";
  protected final String TEXT_57 = "\" + \".\");";
  protected final String TEXT_58 = NL + "            try{ // link with the \"finally\" on the \"finally.javajet\"";
  protected final String TEXT_59 = NL + NL + "                // Empty client options" + NL + "                com.mongodb.MongoClientOptions clientOptions_";
  protected final String TEXT_60 = " = new com.mongodb.MongoClientOptions.Builder().build();";
  protected final String TEXT_61 = NL + "                    clientOptions_";
  protected final String TEXT_62 = " = new com.mongodb.MongoClientOptions.Builder()" + NL + "                    .socketFactory(javax.net.ssl.SSLSocketFactory.getDefault())" + NL + "                    .build();";
  protected final String TEXT_63 = NL + "                // Empty client credentials list" + NL + "                java.util.List<com.mongodb.MongoCredential> mongoCredentialList_";
  protected final String TEXT_64 = " = new java.util.ArrayList<com.mongodb.MongoCredential>();" + NL;
  protected final String TEXT_65 = NL + "                    com.mongodb.MongoCredential mongoCredential_";
  protected final String TEXT_66 = ";";
  protected final String TEXT_67 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_68 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = "; ";
  protected final String TEXT_73 = NL + "                                mongoCredential_";
  protected final String TEXT_74 = " = com.mongodb.MongoCredential.createCredential(";
  protected final String TEXT_75 = ", ";
  protected final String TEXT_76 = ", new String(decryptedPassword_";
  protected final String TEXT_77 = ").toCharArray());";
  protected final String TEXT_78 = NL + "                                mongoCredential_";
  protected final String TEXT_79 = " = com.mongodb.MongoCredential.createMongoCRCredential(";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ", new String(decryptedPassword_";
  protected final String TEXT_82 = ").toCharArray());";
  protected final String TEXT_83 = NL + "                            mongoCredential_";
  protected final String TEXT_84 = " = com.mongodb.MongoCredential.createPlainCredential(";
  protected final String TEXT_85 = ", \"$external\", new String(decryptedPassword_";
  protected final String TEXT_86 = ").toCharArray());";
  protected final String TEXT_87 = NL + "                            mongoCredential_";
  protected final String TEXT_88 = " = com.mongodb.MongoCredential.createScramSha1Credential(";
  protected final String TEXT_89 = ", ";
  protected final String TEXT_90 = ", new String(decryptedPassword_";
  protected final String TEXT_91 = ").toCharArray());";
  protected final String TEXT_92 = NL + "                        System.setProperty(\"java.security.krb5.realm\", ";
  protected final String TEXT_93 = ");" + NL + "                        System.setProperty(\"java.security.krb5.kdc\", ";
  protected final String TEXT_94 = ");" + NL + "                        System.setProperty(\"javax.security.auth.useSubjectCredsOnly\", \"false\");" + NL + "                        mongoCredential_";
  protected final String TEXT_95 = " = com.mongodb.MongoCredential.createGSSAPICredential(";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL + "                    mongoCredentialList_";
  protected final String TEXT_98 = ".add(mongoCredential_";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\t\tmongo_";
  protected final String TEXT_101 = ".addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);";
  protected final String TEXT_102 = NL + "                    List<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_103 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();";
  protected final String TEXT_104 = NL + "                        addrs_";
  protected final String TEXT_105 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_106 = ",";
  protected final String TEXT_107 = "));";
  protected final String TEXT_108 = NL + "                    mongo_";
  protected final String TEXT_109 = " = new com.mongodb.MongoClient(addrs_";
  protected final String TEXT_110 = ", mongoCredentialList_";
  protected final String TEXT_111 = ", clientOptions_";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "                    com.mongodb.ServerAddress serverAddress_";
  protected final String TEXT_114 = " = new com.mongodb.ServerAddress(";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = ");" + NL + "                    mongo_";
  protected final String TEXT_117 = " = new com.mongodb.MongoClient(serverAddress_";
  protected final String TEXT_118 = ", mongoCredentialList_";
  protected final String TEXT_119 = ", clientOptions_";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL;
  protected final String TEXT_122 = NL + "\t\t\t\t\tdb_";
  protected final String TEXT_123 = " = mongo_";
  protected final String TEXT_124 = ".getDatabase(";
  protected final String TEXT_125 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\tdb_";
  protected final String TEXT_127 = " = mongo_";
  protected final String TEXT_128 = ".getDB(";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\t";
  protected final String TEXT_131 = NL + "                        mongo_";
  protected final String TEXT_132 = ".setReadPreference(com.mongodb.ReadPreference.primary());";
  protected final String TEXT_133 = NL + "                        mongo_";
  protected final String TEXT_134 = ".setReadPreference(com.mongodb.ReadPreference.primaryPreferred());";
  protected final String TEXT_135 = NL + "                        mongo_";
  protected final String TEXT_136 = ".setReadPreference(com.mongodb.ReadPreference.secondary());";
  protected final String TEXT_137 = NL + "                        mongo_";
  protected final String TEXT_138 = ".setReadPreference(com.mongodb.ReadPreference.secondaryPreferred());";
  protected final String TEXT_139 = NL + "                        mongo_";
  protected final String TEXT_140 = ".setReadPreference(com.mongodb.ReadPreference.nearest());";
  protected final String TEXT_141 = NL + "                        // Unhandled";
  protected final String TEXT_142 = "  " + NL + "                log.info(\"";
  protected final String TEXT_143 = " - Connecting to \" + mongo_";
  protected final String TEXT_144 = ".getServerAddressList() + \".\");";
  protected final String TEXT_145 = NL + NL;
  protected final String TEXT_146 = NL + "\t\t\t" + NL + "\t";
  protected final String TEXT_147 = NL + "\t\t\tcom.mongodb.client.gridfs.GridFSBucket gridfs_";
  protected final String TEXT_148 = " = com.mongodb.client.gridfs.GridFSBuckets.create(db_";
  protected final String TEXT_149 = ", ";
  protected final String TEXT_150 = ");" + NL + "\t    \t";
  protected final String TEXT_151 = NL + "\t    \t\torg.bson.Document gridFSQuery_";
  protected final String TEXT_152 = " = new org.bson.Document(\"filename\",";
  protected final String TEXT_153 = ");" + NL + "\t\t\t ";
  protected final String TEXT_154 = NL + "\t\t\t \torg.bson.Document gridFSQuery_";
  protected final String TEXT_155 = " = org.bson.Document.parse(";
  protected final String TEXT_156 = ");" + NL + "\t\t\t ";
  protected final String TEXT_157 = NL + "\t\t\t com.mongodb.client.gridfs.GridFSFindIterable gridfsFiles_";
  protected final String TEXT_158 = " = gridfs_";
  protected final String TEXT_159 = ".find(gridFSQuery_";
  protected final String TEXT_160 = ");";
  protected final String TEXT_161 = NL + "    \t\tcom.mongodb.gridfs.GridFS gridfs_";
  protected final String TEXT_162 = " = new com.mongodb.gridfs.GridFS(db_";
  protected final String TEXT_163 = ", ";
  protected final String TEXT_164 = ");" + NL + "\t\t\tjava.util.List<";
  protected final String TEXT_165 = "> gridfsFiles_";
  protected final String TEXT_166 = ";" + NL + "\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\t" + NL + "\t\t\t\tgridfsFiles_";
  protected final String TEXT_168 = " = gridfs_";
  protected final String TEXT_169 = ".find(";
  protected final String TEXT_170 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\tcom.mongodb.DBObject gridFSQuery_";
  protected final String TEXT_172 = " = com.mongodb.BasicDBObject.parse(";
  protected final String TEXT_173 = ");" + NL + "\t\t\t\tgridfsFiles_";
  protected final String TEXT_174 = " = gridfs_";
  protected final String TEXT_175 = ".find(gridFSQuery_";
  protected final String TEXT_176 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_177 = NL + NL + "\t\t\tfor(";
  protected final String TEXT_178 = " file : gridfsFiles_";
  protected final String TEXT_179 = "){" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_180 = "++;" + NL + "\t\t\t\tObject valueObj_";
  protected final String TEXT_181 = "=null;" + NL + "\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\t\tvalueObj_";
  protected final String TEXT_183 = " = file.getObjectId();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t\tvalueObj_";
  protected final String TEXT_185 = " = file.getFilename();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t\t\t\t\tvalueObj_";
  protected final String TEXT_187 = " = file.getChunkSize();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\t\t\t\tvalueObj_";
  protected final String TEXT_189 = " = file.getUploadDate();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_190 = NL + "\t\t\t\t\t\t\tvalueObj_";
  protected final String TEXT_191 = " = file.getLength();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t\tvalueObj_";
  protected final String TEXT_193 = " = file.getContentType();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t\t\t\tvalueObj_";
  protected final String TEXT_195 = " = file.getMD5();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t\t\t\t\tvalueObj_";
  protected final String TEXT_197 = " = file.getMetadata();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\t\tvalueObj_";
  protected final String TEXT_199 = " = null;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t\t\tvalueObj_";
  protected final String TEXT_202 = " = file.get(\"";
  protected final String TEXT_203 = "\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_205 = ".";
  protected final String TEXT_206 = " = valueObj_";
  protected final String TEXT_207 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_208 = NL + "\t\t\t\t\t\t\tif(valueObj_";
  protected final String TEXT_209 = "!=null && valueObj_";
  protected final String TEXT_210 = ".toString().length() > 0) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_211 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = " = ParserUtils.parseTo_Date((java.util.Date)valueObj_";
  protected final String TEXT_214 = ", ";
  protected final String TEXT_215 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_216 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = " = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap((byte[])valueObj_";
  protected final String TEXT_219 = ")).toString().getBytes(utf8Charset);" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = " = valueObj_";
  protected final String TEXT_223 = ".toString();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_224 = NL + "\t\t\t\t\t\t\t\t\tif (valueObj_";
  protected final String TEXT_225 = ".getClass().equals(Double.class)) {" + NL + "\t\t                                ";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_228 = ".toString()).intValue();" + NL + "\t\t                            } else {" + NL + "\t\t                                ";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = " = ParserUtils.parseTo_";
  protected final String TEXT_231 = "(valueObj_";
  protected final String TEXT_232 = ".toString());" + NL + "\t\t                            }" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_233 = NL + "\t\t\t\t\t\t\t\t\tif (valueObj_";
  protected final String TEXT_234 = ".getClass().equals(Double.class)) {" + NL + "\t\t                                ";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_237 = ".toString()).longValue();" + NL + "\t\t                            } else {" + NL + "\t\t                                ";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = " = ParserUtils.parseTo_";
  protected final String TEXT_240 = "(valueObj_";
  protected final String TEXT_241 = ".toString());" + NL + "\t\t                            }" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\t\t\t\t\t\t\tif (valueObj_";
  protected final String TEXT_243 = ".getClass().equals(Double.class)) {" + NL + "\t\t                                ";
  protected final String TEXT_244 = ".";
  protected final String TEXT_245 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_246 = ".toString()).shortValue();" + NL + "\t\t                            } else {" + NL + "\t\t                                ";
  protected final String TEXT_247 = ".";
  protected final String TEXT_248 = " = ParserUtils.parseTo_";
  protected final String TEXT_249 = "(valueObj_";
  protected final String TEXT_250 = ".toString());" + NL + "\t\t                            }" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = " = ParserUtils.parseTo_";
  protected final String TEXT_254 = "(valueObj_";
  protected final String TEXT_255 = ".toString());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_256 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_257 = NL;
  protected final String TEXT_258 = NL;
  protected final String TEXT_259 = NL;

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
    
    String limit = ElementParameterParser.getValue(node,"__LIMIT__");

    List<Map<String, String>> sorts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SORT__");
    boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
    boolean setReadPreference = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_READ_PREFERENCE__"));
    String readPreference = ElementParameterParser.getValue(node, "__READ_PREFERENCE__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    boolean useAuthDB = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_AUTHENTICATION_DATABASE__"));
    String authDB = ElementParameterParser.getValue(node, "__AUTHENTICATION_DATABASE__");
    String usedAuthenticationDB = useAuthDB ? authDB : dbname;
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
    
            if(isLog4jEnabled){
    stringBuffer.append(TEXT_30);
    }else{
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
    if(metadatas != null && metadatas.size() > 0){
        IMetadataTable metadata = metadatas.get(0);
        if(metadata != null){
        
    stringBuffer.append(TEXT_34);
    if(version_3_5_X) {
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
    }
    
            if (useExistingConnection){
                String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
                
    stringBuffer.append(TEXT_41);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_46);
    } else {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    
                if(isLog4jEnabled){
                
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_57);
    
                }
            }else{
            
    stringBuffer.append(TEXT_58);
    
                List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");

                boolean useSSL = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_SSL__"));
                
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
                if (useSSL) {
                    
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
                }
                
                // Client Credentials
                
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
                // Authentication
                if (authentication){
                    
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
                    if((authenticationMechanism.equals("NEGOTIATE_MEC"))||(authenticationMechanism.equals("PLAIN_MEC"))||(authenticationMechanism.equals("SCRAMSHA1_MEC"))){
                        String passwordFieldName = "__PASSWORD__";
                        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_69);
    } else {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_72);
    }
    
                        if(authenticationMechanism.equals("NEGOTIATE_MEC")){
                            if(dbversion.equals("MONGODB_3_0_X") || dbversion.equals("MONGODB_3_2_X") || version_3_5_X) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
                        
                            } else {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
                            }
                        } else if(authenticationMechanism.equals("PLAIN_MEC")){
                            
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
                        } else if(authenticationMechanism.equals("SCRAMSHA1_MEC")){
                            
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
                        }
                    } else { // GSSAPI SASL (KERBEROS)
                        
    stringBuffer.append(TEXT_92);
    stringBuffer.append(krbRealm);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(krbKdc);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(krbUserPrincipal);
    stringBuffer.append(TEXT_96);
    
                    }
                    
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
                }

                if(queryOptionNoTimeOut){
                    
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
                }

                // the client
                if(useReplicaSet){
                    
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
                    for(Map<String,String> replicaAddr:replicaAddrs){
                    
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_107);
    
                    }
                    
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
                }
                
    stringBuffer.append(TEXT_121);
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

            if(isLog4jEnabled){
                
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
            }
            log4jFileUtil.startRetriveDataInfo();

    //} Missing }; must be added by importing component
//} Missing } ; must be added by importing component

    stringBuffer.append(TEXT_145);
    
	boolean givenStringFileName = "STRING_FILENAME".equalsIgnoreCase(ElementParameterParser.getValue(node, "__QUERY_TYPE__"));
    String stringFileName = ElementParameterParser.getValue(node, "__FILENAME__");
    String query = ElementParameterParser.getValue(node,"__QUERY__");
    query = query.replaceAll("\n","");
    query = query.replaceAll("\r","");
    String bucketName = ElementParameterParser.getValue(node, "__BUCKET__");
    String fileType = version_3_5_X?"com.mongodb.client.gridfs.model.GridFSFile":"com.mongodb.gridfs.GridFSDBFile";

    stringBuffer.append(TEXT_146);
    if(version_3_5_X){
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_150);
    if(givenStringFileName){
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(stringFileName);
    stringBuffer.append(TEXT_153);
    }else{
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    }else{
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(fileType);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    // FIND files with given filename
			if(givenStringFileName){
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(stringFileName);
    stringBuffer.append(TEXT_170);
    }
			// FIND files from a given Mongo Query 
			else {
				
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
			}
			
    }
    stringBuffer.append(TEXT_177);
    stringBuffer.append(fileType);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
				if(firstConnName.length()>0){
					columnList = metadata.getListColumns();
					int sizeColumns = columnList.size();
					for (int i = 0; i < sizeColumns; i++) {
						IMetadataColumn column = columnList.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(version_3_5_X){
						  String columnName = column.getOriginalDbColumnName();
						    if("_id".equalsIgnoreCase(columnName)){
						
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    } else if ("filename".equalsIgnoreCase(columnName)){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    } else if ("chunkSize".equalsIgnoreCase(columnName)){
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    } else if ("uploadDate".equalsIgnoreCase(columnName)){
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    } else if ("length".equalsIgnoreCase(columnName)){
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    } else if ("contentType".equalsIgnoreCase(columnName)){
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    } else if ("md5".equalsIgnoreCase(columnName)){
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    } else if ("Metadata".equalsIgnoreCase(columnName)){
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    }else{
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    }
    stringBuffer.append(TEXT_200);
    
						}else{
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_203);
    }

						if(javaType == JavaTypesManager.OBJECT) {
							
    stringBuffer.append(TEXT_204);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    
						} else {
							
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
    
								} else if(javaType == JavaTypesManager.BYTE_ARRAY) {
									
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
    
								} else if(javaType == JavaTypesManager.INTEGER){
									
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
    
								} else if(javaType == JavaTypesManager.LONG){
									
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
    
								} else if(javaType == JavaTypesManager.SHORT){
									
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
    
						}


					}
				}
				
    stringBuffer.append(TEXT_257);
    
		} // Close first { from GetMongoDBConnectionWithMainFlow.javajet
	} // Close second { from GetMongoDBConnectionWithMainFlow.javajet

    stringBuffer.append(TEXT_258);
    stringBuffer.append(TEXT_259);
    return stringBuffer.toString();
  }
}
