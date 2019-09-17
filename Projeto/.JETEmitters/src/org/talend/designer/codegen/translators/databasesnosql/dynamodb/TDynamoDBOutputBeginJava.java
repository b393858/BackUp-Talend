package org.talend.designer.codegen.translators.databasesnosql.dynamodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TDynamoDBOutputBeginJava
{
  protected static String nl;
  public static synchronized TDynamoDBOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDynamoDBOutputBeginJava result = new TDynamoDBOutputBeginJava();
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
  protected final String TEXT_29 = NL + NL + "int nb_line_";
  protected final String TEXT_30 = " = 0;" + NL + "" + NL + "com.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_31 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_32 = ",\t";
  protected final String TEXT_33 = ");\t\t" + NL + "com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient dynamoDBClient_";
  protected final String TEXT_34 = " = new com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient(" + NL + "    credentials_";
  protected final String TEXT_35 = ",\t\t" + NL + "    com.amazonaws.PredefinedClientConfigurations.dynamoDefault().withUserAgent(\"";
  protected final String TEXT_36 = "\")" + NL + "    );" + NL + "   ";
  protected final String TEXT_37 = NL + "\t\tdynamoDBClient_";
  protected final String TEXT_38 = " = dynamoDBClient_";
  protected final String TEXT_39 = ".withEndpoint(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = "\t\t" + NL;
  protected final String TEXT_42 = NL + "\t\tdynamoDBClient_";
  protected final String TEXT_43 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_44 = "));";
  protected final String TEXT_45 = NL + "\t\t\t\t\t" + NL + "com.amazonaws.services.dynamodbv2.document.DynamoDB dynamoDB_";
  protected final String TEXT_46 = " = new com.amazonaws.services.dynamodbv2.document.DynamoDB(dynamoDBClient_";
  protected final String TEXT_47 = ");" + NL + "com.amazonaws.services.dynamodbv2.document.Table table_";
  protected final String TEXT_48 = " = dynamoDB_";
  protected final String TEXT_49 = ".getTable(";
  protected final String TEXT_50 = ");" + NL;
  protected final String TEXT_51 = NL + NL + "\t\tList<com.amazonaws.services.dynamodbv2.model.AttributeDefinition> attributeDefinitions_";
  protected final String TEXT_52 = " = new java.util.ArrayList<com.amazonaws.services.dynamodbv2.model.AttributeDefinition>();" + NL + "\t\tList<com.amazonaws.services.dynamodbv2.model.KeySchemaElement> keySchemaElements_";
  protected final String TEXT_53 = " = new java.util.ArrayList<com.amazonaws.services.dynamodbv2.model.KeySchemaElement>();" + NL + "\t\t" + NL + "\t\tkeySchemaElements_";
  protected final String TEXT_54 = ".add(new com.amazonaws.services.dynamodbv2.model.KeySchemaElement(";
  protected final String TEXT_55 = ", com.amazonaws.services.dynamodbv2.model.KeyType.HASH));" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_56 = NL + "\t\t\tkeySchemaElements_";
  protected final String TEXT_57 = ".add(new com.amazonaws.services.dynamodbv2.model.KeySchemaElement(";
  protected final String TEXT_58 = ", com.amazonaws.services.dynamodbv2.model.KeyType.RANGE));" + NL + "\t\t";
  protected final String TEXT_59 = NL + "\t\t" + NL + "\t   ";
  protected final String TEXT_60 = "\t\t" + NL + "\t\t\t\t\tattributeDefinitions_";
  protected final String TEXT_61 = ".add(new com.amazonaws.services.dynamodbv2.model.AttributeDefinition(\"";
  protected final String TEXT_62 = "\", " + NL + "\t\t\t\t\tcom.amazonaws.services.dynamodbv2.model.ScalarAttributeType.S));" + NL + "\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\tattributeDefinitions_";
  protected final String TEXT_64 = ".add(new com.amazonaws.services.dynamodbv2.model.AttributeDefinition(\"";
  protected final String TEXT_65 = "\"," + NL + "\t\t\t\t\tcom.amazonaws.services.dynamodbv2.model.ScalarAttributeType.N));\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_66 = NL + NL + "\t";
  protected final String TEXT_67 = NL + "\t\ttry {" + NL + "\t";
  protected final String TEXT_68 = NL + "\t\t\t\ttable_";
  protected final String TEXT_69 = ".delete();" + NL + "\t\t\t\ttable_";
  protected final String TEXT_70 = ".waitForDelete();" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\tlog.info(";
  protected final String TEXT_72 = " + \" has been deleted.\");" + NL + "\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t" + NL + "\t";
  protected final String TEXT_74 = NL + "\t\t\t} catch(com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException ex) {\t" + NL + "\t\t\t\t";
  protected final String TEXT_75 = "\t" + NL + "\t\t\t\t\tlog.info(";
  protected final String TEXT_76 = " + \" doesn't exist.\");" + NL + "\t\t\t\t";
  protected final String TEXT_77 = "\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t";
  protected final String TEXT_78 = NL;
  protected final String TEXT_79 = NL + NL + "\t";
  protected final String TEXT_80 = NL + "\t\ttry {" + NL + "\t";
  protected final String TEXT_81 = NL + "\t" + NL + "\t\t\ttable_";
  protected final String TEXT_82 = " = dynamoDB_";
  protected final String TEXT_83 = ".createTable(" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_84 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tkeySchemaElements_";
  protected final String TEXT_85 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tattributeDefinitions_";
  protected final String TEXT_86 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnew com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput((long)";
  protected final String TEXT_87 = ", (long)";
  protected final String TEXT_88 = "));" + NL + "\t\t\ttable_";
  protected final String TEXT_89 = ".waitForActive();\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_90 = "\t" + NL + "\t\t\t\tlog.info(";
  protected final String TEXT_91 = " + \" has been created.\");" + NL + "\t\t\t";
  protected final String TEXT_92 = NL + "\t" + NL + "\t";
  protected final String TEXT_93 = NL + "\t\t} catch(com.amazonaws.services.dynamodbv2.model.ResourceInUseException ex) {" + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\tlog.info(";
  protected final String TEXT_95 = " + \" already exist.\");" + NL + "\t\t\t";
  protected final String TEXT_96 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_97 = NL + "\t";
  protected final String TEXT_98 = NL + NL;
  protected final String TEXT_99 = NL + "\t\tcom.amazonaws.services.dynamodbv2.document.Item item_";
  protected final String TEXT_100 = " = new com.amazonaws.services.dynamodbv2.document.Item(); " + NL + "\t\tcom.amazonaws.services.dynamodbv2.document.spec.PutItemSpec putItemSpec_";
  protected final String TEXT_101 = ";";
  protected final String TEXT_102 = NL + "\t\tcom.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec updateItemSpec_";
  protected final String TEXT_103 = " = new com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec();";
  protected final String TEXT_104 = NL + "\t\tcom.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec deleteItemSpec_";
  protected final String TEXT_105 = " = new com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec();";
  protected final String TEXT_106 = NL;

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
  	
	String accessKey   = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	String secretKey   = ElementParameterParser.getValue(node, "__SECRET_KEY__");
	
	String region = ElementParameterParser.getValue(node, "__REGION__");
	boolean useEndPoint = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_ENDPOINT__"));
    String endPoint   = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");
	String table   = ElementParameterParser.getValue(node, "__TABLE__");
	String partitionKey = ElementParameterParser.getValue(node, "__PARTITION_KEY__");
	String sortKey = ElementParameterParser.getValue(node, "__SORT_KEY__");
	long rcu = Long.parseLong(ElementParameterParser.getValue(node, "__RCU__"));
	long wcu = Long.parseLong(ElementParameterParser.getValue(node, "__WCU__"));
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	final String AWSTracker = org.talend.core.utils.TrackerUtil.getAWSTracker();
  	
  	List<IMetadataTable> outputMetadatas = node.getMetadataList();
  	if(outputMetadatas == null || outputMetadatas.size() == 0 || outputMetadatas.get(0) == null){
  		return "";
  	}
  	
	IMetadataTable metadata = outputMetadatas.get(0);
	List<IMetadataColumn> outPutColumns = metadata.getListColumns();

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(secretKey);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(AWSTracker);
    stringBuffer.append(TEXT_36);
    	if(useEndPoint)	{	
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(endPoint);
    stringBuffer.append(TEXT_40);
    	} 
    stringBuffer.append(TEXT_41);
     	if(!useEndPoint && region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region)) {	
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_44);
    	} 
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_50);
    	if(!"NONE".equalsIgnoreCase(tableAction))	{	
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(partitionKey);
    stringBuffer.append(TEXT_55);
     if(sortKey != null && !sortKey.isEmpty() && !sortKey.equals("\"\"")) { 
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(sortKey);
    stringBuffer.append(TEXT_58);
     } 
    stringBuffer.append(TEXT_59);
    
		for (int i = 0; i < outPutColumns.size(); i++) {
			IMetadataColumn column = outPutColumns.get(i);
			if(column.isKey()) {				
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				 // For the more details on the below type mapping
				 // see http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBMapper.DataTypes.html
				 //
				 // String and Date type are converted to ScalarAttributeType.S
				 // The Date values are stored as ISO-8601 formatted strings.
				 // We use the Talend Date pattern defined by the user to store the date
				 if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.DATE) {
		
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_62);
    
				// All number types are converted to ScalarAttributeType.N
				 } else if (javaType == JavaTypesManager.BIGDECIMAL
                            || javaType == JavaTypesManager.LONG
                            || javaType == JavaTypesManager.INTEGER
                            || javaType == JavaTypesManager.SHORT
                            || javaType == JavaTypesManager.DOUBLE
                            || javaType == JavaTypesManager.FLOAT
                            || javaType == JavaTypesManager.BOOLEAN) {
		
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_65);
    	
				}								
			}
		}
	   
} 

if ("DROP_CREATE".equalsIgnoreCase(tableAction) || "DROP_IF_EXISTS_AND_CREATE".equalsIgnoreCase(tableAction)) {	
    stringBuffer.append(TEXT_66);
     if("DROP_IF_EXISTS_AND_CREATE".equalsIgnoreCase(tableAction)) { 
    stringBuffer.append(TEXT_67);
     } 
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    	if(isLog4jEnabled){ 
    stringBuffer.append(TEXT_71);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_72);
    	} 
    stringBuffer.append(TEXT_73);
      //Handle error if table don't exist and option DROP_IF_EXISTS_AND_CREATE selected
		if("DROP_IF_EXISTS_AND_CREATE".equalsIgnoreCase(tableAction)) {  
    stringBuffer.append(TEXT_74);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_75);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_76);
     } 
    stringBuffer.append(TEXT_77);
     } 
    stringBuffer.append(TEXT_78);
     }

// Create the table if necessary
if(!"NONE".equalsIgnoreCase(tableAction))	{	
    stringBuffer.append(TEXT_79);
     if("CREATE_IF_NOT_EXISTS".equalsIgnoreCase(tableAction)) { 
    stringBuffer.append(TEXT_80);
     } 
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(rcu);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(wcu);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
     if(isLog4jEnabled){ 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_91);
    	} 
    stringBuffer.append(TEXT_92);
     
	//Handle error if table exist and option create if not exist selected
	if("CREATE_IF_NOT_EXISTS".equalsIgnoreCase(tableAction)) { 
    stringBuffer.append(TEXT_93);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_94);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_95);
    	} 
    stringBuffer.append(TEXT_96);
     } 
    stringBuffer.append(TEXT_97);
     } 
    stringBuffer.append(TEXT_98);
     if ("INSERT".equalsIgnoreCase(dataAction)) {  
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
     } else if ("UPDATE".equalsIgnoreCase(dataAction)) {	
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    	} else if ("DELETE".equalsIgnoreCase(dataAction)) { 
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    	} 
    stringBuffer.append(TEXT_106);
    return stringBuffer.toString();
  }
}
