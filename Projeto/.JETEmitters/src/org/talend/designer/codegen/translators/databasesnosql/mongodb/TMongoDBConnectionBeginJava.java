package org.talend.designer.codegen.translators.databasesnosql.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TMongoDBConnectionBeginJava
{
  protected static String nl;
  public static synchronized TMongoDBConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBConnectionBeginJava result = new TMongoDBConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.OFF);" + NL + "\t\t\t";
  protected final String TEXT_2 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.SEVERE);";
  protected final String TEXT_3 = NL + "    // Empty client options" + NL + "    com.mongodb.MongoClientOptions clientOptions_";
  protected final String TEXT_4 = " = new com.mongodb.MongoClientOptions.Builder().build();" + NL;
  protected final String TEXT_5 = NL + "    // Empty client credentials list" + NL + "    java.util.List<com.mongodb.MongoCredential> mongoCredentialList_";
  protected final String TEXT_6 = " = new java.util.ArrayList<com.mongodb.MongoCredential>();" + NL;
  protected final String TEXT_7 = NL + "        clientOptions_";
  protected final String TEXT_8 = " = new com.mongodb.MongoClientOptions.Builder()" + NL + "        .socketFactory(javax.net.ssl.SSLSocketFactory.getDefault())" + NL + "        .build();";
  protected final String TEXT_9 = NL + "        com.mongodb.MongoCredential mongoCredential_";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = "; ";
  protected final String TEXT_17 = NL + "                    mongoCredential_";
  protected final String TEXT_18 = " = com.mongodb.MongoCredential.createCredential(";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ", new String(decryptedPassword_";
  protected final String TEXT_21 = ").toCharArray());";
  protected final String TEXT_22 = NL + "                    mongoCredential_";
  protected final String TEXT_23 = " = com.mongodb.MongoCredential.createMongoCRCredential(";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ", new String(decryptedPassword_";
  protected final String TEXT_26 = ").toCharArray());";
  protected final String TEXT_27 = NL + "                mongoCredential_";
  protected final String TEXT_28 = " = com.mongodb.MongoCredential.createPlainCredential(";
  protected final String TEXT_29 = ", \"$external\", new String(decryptedPassword_";
  protected final String TEXT_30 = ").toCharArray());";
  protected final String TEXT_31 = NL + "                mongoCredential_";
  protected final String TEXT_32 = " = com.mongodb.MongoCredential.createScramSha1Credential(";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = ", new String(decryptedPassword_";
  protected final String TEXT_35 = ").toCharArray());";
  protected final String TEXT_36 = NL + "            System.setProperty(\"java.security.krb5.realm\", ";
  protected final String TEXT_37 = ");" + NL + "            System.setProperty(\"java.security.krb5.kdc\", ";
  protected final String TEXT_38 = ");" + NL + "            System.setProperty(\"javax.security.auth.useSubjectCredsOnly\", \"false\");" + NL + "            mongoCredential_";
  protected final String TEXT_39 = " = com.mongodb.MongoCredential.createGSSAPICredential(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "        mongoCredentialList_";
  protected final String TEXT_42 = ".add(mongoCredential_";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "        List<com.mongodb.ServerAddress> serverAddressList_";
  protected final String TEXT_45 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();";
  protected final String TEXT_46 = NL + "            serverAddressList_";
  protected final String TEXT_47 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_48 = ",";
  protected final String TEXT_49 = "));";
  protected final String TEXT_50 = NL + "\t\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_51 = " = new ";
  protected final String TEXT_52 = "(serverAddressList_";
  protected final String TEXT_53 = ", mongoCredentialList_";
  protected final String TEXT_54 = ", clientOptions_";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "        com.mongodb.ServerAddress serverAddress_";
  protected final String TEXT_57 = " = new com.mongodb.ServerAddress(";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = ");" + NL + "\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_60 = " = new ";
  protected final String TEXT_61 = "(serverAddress_";
  protected final String TEXT_62 = ", mongoCredentialList_";
  protected final String TEXT_63 = ", clientOptions_";
  protected final String TEXT_64 = ");" + NL + "        ";
  protected final String TEXT_65 = NL + "    mongo_";
  protected final String TEXT_66 = ".getAddress() ;";
  protected final String TEXT_67 = NL + "\t\tcom.mongodb.client.MongoDatabase db_";
  protected final String TEXT_68 = " = ((";
  protected final String TEXT_69 = ")mongo_";
  protected final String TEXT_70 = ").getDatabase(";
  protected final String TEXT_71 = ");" + NL + "\t";
  protected final String TEXT_72 = NL + "\t\tcom.mongodb.DB db_";
  protected final String TEXT_73 = " = mongo_";
  protected final String TEXT_74 = ".getDB(";
  protected final String TEXT_75 = ");" + NL + "\t";
  protected final String TEXT_76 = NL + "    ";
  protected final String TEXT_77 = NL + "        log.info(\"";
  protected final String TEXT_78 = " - Connecting to \" + mongo_";
  protected final String TEXT_79 = ".getServerAddressList() + \".\");";
  protected final String TEXT_80 = NL + "            mongo_";
  protected final String TEXT_81 = ".addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);";
  protected final String TEXT_82 = NL + "    globalMap.put(\"mongo_";
  protected final String TEXT_83 = "\", mongo_";
  protected final String TEXT_84 = ");" + NL + "    globalMap.put(\"db_";
  protected final String TEXT_85 = "\", db_";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbname = ElementParameterParser.getValue(node, "__DATABASE__");
    String dbuser = ElementParameterParser.getValue(node, "__USERNAME__");
    String dbpass = ElementParameterParser.getValue(node, "__PASSWORD__");
    String dbversion = ElementParameterParser.getValue(node, "__DB_VERSION__");
    boolean authentication = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    String authenticationMechanism = ElementParameterParser.getValue(node, "__AUTHENTICATION_MECHANISM__");
    String krbUserPrincipal = ElementParameterParser.getValue(node, "__KRB_USER_PRINCIPAL__");
    String krbRealm = ElementParameterParser.getValue(node, "__KRB_REALM__");
    String krbKdc = ElementParameterParser.getValue(node, "__KRB_KDC__");
    boolean useReplicaSet = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
    boolean useSSL = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_SSL__"));
    String mongoPort = ElementParameterParser.getValue(node, "__PORT__");
    String dbport = mongoPort.startsWith("context.") ? "Integer.valueOf(" + mongoPort + ").intValue()" : mongoPort.replace("\"", "");
    List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");
    boolean setReadPreference = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_READ_PREFERENCE__"));
    String readPreference = ElementParameterParser.getValue(node, "__READ_PREFERENCE__");
    boolean useAuthDB = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_AUTHENTICATION_DATABASE__"));
    String authDB = ElementParameterParser.getValue(node, "__AUTHENTICATION_DATABASE__");
    String usedAuthenticationDB = useAuthDB ? authDB : dbname;
    boolean queryOptionNoTimeOut = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__QUERYOPTION_NOTIMEOUT__"));
    boolean version_3_5_X = "MONGODB_3_5_X".equals(dbversion);
    
    String mongoDbDriver = "com.mongodb.MongoClient";
    
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    
    
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_1);
    }else{
    stringBuffer.append(TEXT_2);
    
		    }
    // Client options
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    

    // Client Credentials
    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    

    // SSL
    if (useSSL) {
        
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
    }

    // Authentication
    if (authentication){
        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
        if((authenticationMechanism.equals("NEGOTIATE_MEC"))||(authenticationMechanism.equals("PLAIN_MEC"))||(authenticationMechanism.equals("SCRAMSHA1_MEC"))){
            String passwordFieldName = "__PASSWORD__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    }
    
            if(authenticationMechanism.equals("NEGOTIATE_MEC")){
                if(dbversion.equals("MONGODB_3_0_X") || dbversion.equals("MONGODB_3_2_X") || version_3_5_X) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
                        
                } else {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
                }
            } else if(authenticationMechanism.equals("PLAIN_MEC")){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
            } else if(authenticationMechanism.equals("SCRAMSHA1_MEC")){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
            }
        } else { // GSSAPI SASL (KERBEROS)

    stringBuffer.append(TEXT_36);
    stringBuffer.append(krbRealm);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(krbKdc);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(krbUserPrincipal);
    stringBuffer.append(TEXT_40);
    
        }
        
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
    }

    // The client
    if(useReplicaSet){
        
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
        for(Map<String,String> replicaAddr:replicaAddrs){
        
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_49);
    
        }
        
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
    }else{
        
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
    }

    
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_71);
    } else {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    
    if(isLog4jEnabled){
    
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
    }
    if(queryOptionNoTimeOut&&!version_3_5_X){
        
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
    }
    
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(TEXT_87);
    return stringBuffer.toString();
  }
}
