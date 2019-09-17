package org.talend.designer.codegen.translators.databasesnosql.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TMongoDBRowBeginJava
{
  protected static String nl;
  public static synchronized TMongoDBRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBRowBeginJava result = new TMongoDBRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_2 = "=null;" + NL + "\tcom.mongodb.DB db_";
  protected final String TEXT_3 = "=null;" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\tmongo_";
  protected final String TEXT_5 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_6 = "\");" + NL + "\t\tdb_";
  protected final String TEXT_7 = " = mongo_";
  protected final String TEXT_8 = ".getDB(";
  protected final String TEXT_9 = ");" + NL + "\t\t";
  protected final String TEXT_10 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Get an existing client from \" + \"";
  protected final String TEXT_12 = "\" + \".\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Get an existing DB from \" + \"";
  protected final String TEXT_14 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t    ";
  protected final String TEXT_16 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.OFF);" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.SEVERE);";
  protected final String TEXT_18 = NL + "        // Empty client options" + NL + "        com.mongodb.MongoClientOptions clientOptions_";
  protected final String TEXT_19 = " = new com.mongodb.MongoClientOptions.Builder().build();";
  protected final String TEXT_20 = NL + "            clientOptions_";
  protected final String TEXT_21 = " = new com.mongodb.MongoClientOptions.Builder()" + NL + "            .socketFactory(javax.net.ssl.SSLSocketFactory.getDefault())" + NL + "            .build();";
  protected final String TEXT_22 = NL + "        // Empty client credentials list" + NL + "        java.util.List<com.mongodb.MongoCredential> mongoCredentialList_";
  protected final String TEXT_23 = " = new java.util.ArrayList<com.mongodb.MongoCredential>();" + NL;
  protected final String TEXT_24 = NL + "            com.mongodb.MongoCredential mongoCredential_";
  protected final String TEXT_25 = ";";
  protected final String TEXT_26 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_27 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = "; ";
  protected final String TEXT_32 = NL + "                        mongoCredential_";
  protected final String TEXT_33 = " = com.mongodb.MongoCredential.createCredential(";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = ", new String(decryptedPassword_";
  protected final String TEXT_36 = ").toCharArray());";
  protected final String TEXT_37 = NL + "                        mongoCredential_";
  protected final String TEXT_38 = " = com.mongodb.MongoCredential.createMongoCRCredential(";
  protected final String TEXT_39 = ", ";
  protected final String TEXT_40 = ", new String(decryptedPassword_";
  protected final String TEXT_41 = ").toCharArray());";
  protected final String TEXT_42 = NL + "                    mongoCredential_";
  protected final String TEXT_43 = " = com.mongodb.MongoCredential.createPlainCredential(";
  protected final String TEXT_44 = ", \"$external\", new String(decryptedPassword_";
  protected final String TEXT_45 = ").toCharArray());";
  protected final String TEXT_46 = NL + "                    mongoCredential_";
  protected final String TEXT_47 = " = com.mongodb.MongoCredential.createScramSha1Credential(";
  protected final String TEXT_48 = ", ";
  protected final String TEXT_49 = ", new String(decryptedPassword_";
  protected final String TEXT_50 = ").toCharArray());";
  protected final String TEXT_51 = NL + "                System.setProperty(\"java.security.krb5.realm\", ";
  protected final String TEXT_52 = ");" + NL + "                System.setProperty(\"java.security.krb5.kdc\", ";
  protected final String TEXT_53 = ");" + NL + "                System.setProperty(\"javax.security.auth.useSubjectCredsOnly\", \"false\");" + NL + "                mongoCredential_";
  protected final String TEXT_54 = " = com.mongodb.MongoCredential.createGSSAPICredential(";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "            mongoCredentialList_";
  protected final String TEXT_57 = ".add(mongoCredential_";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "            List<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_60 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();";
  protected final String TEXT_61 = NL + "                addrs_";
  protected final String TEXT_62 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_63 = ",";
  protected final String TEXT_64 = "));";
  protected final String TEXT_65 = NL + "            mongo_";
  protected final String TEXT_66 = " = new ";
  protected final String TEXT_67 = "(addrs_";
  protected final String TEXT_68 = ", mongoCredentialList_";
  protected final String TEXT_69 = ", clientOptions_";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "            com.mongodb.ServerAddress serverAddress_";
  protected final String TEXT_72 = " = new com.mongodb.ServerAddress(";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ");" + NL + "            mongo_";
  protected final String TEXT_75 = " = new ";
  protected final String TEXT_76 = "(serverAddress_";
  protected final String TEXT_77 = ", mongoCredentialList_";
  protected final String TEXT_78 = ", clientOptions_";
  protected final String TEXT_79 = ");";
  protected final String TEXT_80 = NL + "\t\tdb_";
  protected final String TEXT_81 = " = mongo_";
  protected final String TEXT_82 = ".getDB(";
  protected final String TEXT_83 = ");" + NL + "\t\t";
  protected final String TEXT_84 = "\t" + NL + "\t\tlog.info(\"";
  protected final String TEXT_85 = " - Connecting to \" + mongo_";
  protected final String TEXT_86 = ".getServerAddressList() + \".\");" + NL + "\t";
  protected final String TEXT_87 = NL + "\tcom.mongodb.CommandResult result_";
  protected final String TEXT_88 = "=null;" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
  	boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
    boolean useAuthDB = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_AUTHENTICATION_DATABASE__"));
    String authDB = ElementParameterParser.getValue(node, "__AUTHENTICATION_DATABASE__");
    String usedAuthenticationDB = useAuthDB ? authDB : dbname;
  	
  	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if (useExistingConnection){
  		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
        String database = ElementParameterParser.getValue(connectionNode, "__DATABASE__");
		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_9);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_14);
    
		}
	}else{
		List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");
		boolean useSSL = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_SSL__"));
        String dbversion = ElementParameterParser.getValue(node, "__DB_VERSION__");

        String mongoDbDriver = "com.mongodb.MongoClient";

        
    stringBuffer.append(TEXT_15);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_16);
    }else{
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
        if (useSSL) {
            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
        }
        
        // Client Credentials
        
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
        // Authentication
        if (authentication){
            
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
            if((authenticationMechanism.equals("NEGOTIATE_MEC"))||(authenticationMechanism.equals("PLAIN_MEC"))||(authenticationMechanism.equals("SCRAMSHA1_MEC"))){
                String passwordFieldName = "__PASSWORD__";
                
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_28);
    } else {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_31);
    }
    
                if(authenticationMechanism.equals("NEGOTIATE_MEC")){
                    if(dbversion.equals("MONGODB_3_0_X") || dbversion.equals("MONGODB_3_2_X")|| dbversion.equals("MONGODB_3_5_X")) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
                        
                    } else {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
                    }
                } else if(authenticationMechanism.equals("PLAIN_MEC")){
                    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
                } else if(authenticationMechanism.equals("SCRAMSHA1_MEC")){
                    
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
                }
            } else { // GSSAPI SASL (KERBEROS)
                
    stringBuffer.append(TEXT_51);
    stringBuffer.append(krbRealm);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(krbKdc);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(krbUserPrincipal);
    stringBuffer.append(TEXT_55);
    
            }
            
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
        }

        // the client
        if(useReplicaSet){
            
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
            for(Map<String,String> replicaAddr:replicaAddrs){
            
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_64);
    
            }
            
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
        }else{
            
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(dbport);
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
    
        }
        
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_83);
    
	}
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
	}
	
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    return stringBuffer.toString();
  }
}
