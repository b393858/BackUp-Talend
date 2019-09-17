package org.talend.designer.codegen.translators.databasesnosql.dynamodb;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TDynamoDBOutputMainJava
{
  protected static String nl;
  public static synchronized TDynamoDBOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDynamoDBOutputMainJava result = new TDynamoDBOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "Object partitionKeyValue_";
  protected final String TEXT_2 = "\t= null;" + NL + "Object sortKeyValue_";
  protected final String TEXT_3 = "\t= null;" + NL + "java.util.Map<String, Object> mapValues_";
  protected final String TEXT_4 = " = new java.util.HashMap<>();" + NL + "java.util.Map<String, Boolean> dbTypeJSONMap_";
  protected final String TEXT_5 = " = new java.util.HashMap<>();" + NL;
  protected final String TEXT_6 = NL + "\t\t \t\t\tpartitionKeyValue_";
  protected final String TEXT_7 = " = FormatterUtils.format_DateInUTC(";
  protected final String TEXT_8 = ",  ";
  protected final String TEXT_9 = ");" + NL + "\t\t\t ";
  protected final String TEXT_10 = NL + "\t\t\t\t \tpartitionKeyValue_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ";" + NL + "\t\t\t ";
  protected final String TEXT_13 = NL + "\t\t \t\t\tsortKeyValue_";
  protected final String TEXT_14 = " = FormatterUtils.format_DateInUTC(";
  protected final String TEXT_15 = ",  ";
  protected final String TEXT_16 = ");" + NL + "\t\t\t ";
  protected final String TEXT_17 = NL + "\t\t\t\t \tsortKeyValue_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ";" + NL + "\t\t\t ";
  protected final String TEXT_20 = NL + "\t\t\t   " + NL + "\t\t\t   \t\tif(null == ";
  protected final String TEXT_21 = " ";
  protected final String TEXT_22 = " || ";
  protected final String TEXT_23 = ".isEmpty() ";
  protected final String TEXT_24 = " ";
  protected final String TEXT_25 = " || ";
  protected final String TEXT_26 = ".length == 0 ";
  protected final String TEXT_27 = ") {" + NL + "\t\t\t   \t\t\tmapValues_";
  protected final String TEXT_28 = ".put(";
  protected final String TEXT_29 = ", null);" + NL + "\t\t\t   \t\t}else {" + NL + "\t\t\t   \t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t \t\t\tmapValues_";
  protected final String TEXT_31 = ".put(";
  protected final String TEXT_32 = ", FormatterUtils.format_DateInUTC(";
  protected final String TEXT_33 = ",  ";
  protected final String TEXT_34 = "));" + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\t \tmapValues_";
  protected final String TEXT_36 = ".put(";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ");" + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_39 = " " + NL + "\t\t\t   \t\t}" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t   " + NL + "\t\t\t\t   if(null != ";
  protected final String TEXT_41 = " ";
  protected final String TEXT_42 = " && !";
  protected final String TEXT_43 = ".isEmpty() ";
  protected final String TEXT_44 = " ";
  protected final String TEXT_45 = " && ";
  protected final String TEXT_46 = ".length != 0 ";
  protected final String TEXT_47 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t \t\tmapValues_";
  protected final String TEXT_49 = ".put(";
  protected final String TEXT_50 = ", FormatterUtils.format_DateInUTC(";
  protected final String TEXT_51 = ",  ";
  protected final String TEXT_52 = "));" + NL + "\t\t\t\t \t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t \t\tmapValues_";
  protected final String TEXT_54 = ".put(";
  protected final String TEXT_55 = ", ";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t   }" + NL + "\t\t\t\t   " + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "        dbTypeJSONMap_";
  protected final String TEXT_59 = ".put(";
  protected final String TEXT_60 = ", ";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL;
  protected final String TEXT_63 = "\t" + NL + "\t\t\t\titem_";
  protected final String TEXT_64 = " = item_";
  protected final String TEXT_65 = ".withPrimaryKey(";
  protected final String TEXT_66 = ", partitionKeyValue_";
  protected final String TEXT_67 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
  protected final String TEXT_68 = ", sortKeyValue_";
  protected final String TEXT_69 = ");\t" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\titem_";
  protected final String TEXT_71 = " = item_";
  protected final String TEXT_72 = ".withPrimaryKey(";
  protected final String TEXT_73 = ", partitionKeyValue_";
  protected final String TEXT_74 = ");" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t\t" + NL + "\t\tfor (java.util.Map.Entry<String, Object> entry : mapValues_";
  protected final String TEXT_76 = ".entrySet()) {" + NL + "\t\t\tif(entry.getValue() == null){" + NL + "\t\t\t\titem_";
  protected final String TEXT_77 = " = item_";
  protected final String TEXT_78 = ".withNull(entry.getKey());" + NL + "\t\t\t}else{" + NL + "\t\t\t    if(dbTypeJSONMap_";
  protected final String TEXT_79 = ".get(entry.getKey())){" + NL + "\t\t\t        String json_value_";
  protected final String TEXT_80 = " = entry.getValue().toString().trim();" + NL + "\t\t\t        json_value_";
  protected final String TEXT_81 = " = (json_value_";
  protected final String TEXT_82 = ".isEmpty()) ? \"{}\" : json_value_";
  protected final String TEXT_83 = ";" + NL + "\t\t\t        item_";
  protected final String TEXT_84 = " = item_";
  protected final String TEXT_85 = ".withJSON(entry.getKey(), json_value_";
  protected final String TEXT_86 = ");" + NL + "\t\t\t    }" + NL + "\t\t\t    else{" + NL + "\t\t\t\t    item_";
  protected final String TEXT_87 = " = item_";
  protected final String TEXT_88 = ".with(entry.getKey(), entry.getValue());" + NL + "\t\t\t    }" + NL + "\t\t\t}" + NL + "\t\t}\t" + NL + "\t\tputItemSpec_";
  protected final String TEXT_89 = " = new com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec().withItem(item_";
  protected final String TEXT_90 = ");" + NL + "\t\ttable_";
  protected final String TEXT_91 = ".putItem(putItemSpec_";
  protected final String TEXT_92 = ");" + NL + "        " + NL + "\t\t";
  protected final String TEXT_93 = NL + NL + "\t\t";
  protected final String TEXT_94 = "\t\t\t\t" + NL + "\t\t\tupdateItemSpec_";
  protected final String TEXT_95 = " = updateItemSpec_";
  protected final String TEXT_96 = ".withPrimaryKey(";
  protected final String TEXT_97 = ", partitionKeyValue_";
  protected final String TEXT_98 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
  protected final String TEXT_99 = ", sortKeyValue_";
  protected final String TEXT_100 = ");\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_101 = NL + "\t\t\tupdateItemSpec_";
  protected final String TEXT_102 = " = updateItemSpec_";
  protected final String TEXT_103 = ".withPrimaryKey(";
  protected final String TEXT_104 = ", partitionKeyValue_";
  protected final String TEXT_105 = ");" + NL + "\t\t";
  protected final String TEXT_106 = NL + "\t\t" + NL + "\t\tjava.util.HashMap<String, Object> valueMap_";
  protected final String TEXT_107 = " = new java.util.HashMap<String, Object>();\t" + NL + "\t\tjava.util.HashMap<String,String> nameMap_";
  protected final String TEXT_108 = " = new java.util.HashMap<String,String>();\t" + NL + "\t\tjava.util.HashMap<String,String> nameMapRevert_";
  protected final String TEXT_109 = " = new java.util.HashMap<String,String>();\t\t\t\t\t\t" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_110 = NL + "\t\t\tnameMap_";
  protected final String TEXT_111 = ".put(\"";
  protected final String TEXT_112 = "\", \"";
  protected final String TEXT_113 = "\");" + NL + "\t\t\tnameMapRevert_";
  protected final String TEXT_114 = ".put(\"";
  protected final String TEXT_115 = "\",\"";
  protected final String TEXT_116 = "\");" + NL + "\t";
  protected final String TEXT_117 = NL + "\t\t" + NL + "\t\tStringBuilder updateExpression_";
  protected final String TEXT_118 = " = new StringBuilder();" + NL + "\t\tupdateExpression_";
  protected final String TEXT_119 = ".append(\"set \");" + NL + "\t\tint countValue_";
  protected final String TEXT_120 = "=0;" + NL + "\t\tfor (java.util.Map.Entry<String, Object> entry : mapValues_";
  protected final String TEXT_121 = ".entrySet()) {" + NL + "\t\t\tif(countValue_";
  protected final String TEXT_122 = " > 0)\t{" + NL + "\t\t\t\t\tupdateExpression_";
  protected final String TEXT_123 = ".append(\", \");" + NL + "\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\tif(nameMapRevert_";
  protected final String TEXT_124 = ".containsKey(entry.getKey())){" + NL + "\t\t\t\t\tupdateExpression_";
  protected final String TEXT_125 = ".append(nameMapRevert_";
  protected final String TEXT_126 = ".get(entry.getKey()));" + NL + "\t\t\t\t\tupdateExpression_";
  protected final String TEXT_127 = ".append(\" =:\"+entry.getKey());" + NL + "\t\t\t}else{" + NL + "\t\t\t\t\tupdateExpression_";
  protected final String TEXT_128 = ".append(entry.getKey()+\"  =:\"+entry.getKey());" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tvalueMap_";
  protected final String TEXT_129 = ".put(\":\"+entry.getKey(), entry.getValue());" + NL + "\t\t\tcountValue_";
  protected final String TEXT_130 = "++;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_131 = "\t" + NL + "\t\t\tlog.debug(\"update expression: \"+updateExpression_";
  protected final String TEXT_132 = ".toString());" + NL + "\t\t\tlog.debug(\"value map: \"+nameMap_";
  protected final String TEXT_133 = ".toString());" + NL + "\t\t\tlog.debug(\"value map: \"+valueMap_";
  protected final String TEXT_134 = ".toString());" + NL + "\t\t";
  protected final String TEXT_135 = NL + "\t\t" + NL + "\t\tupdateItemSpec_";
  protected final String TEXT_136 = " = updateItemSpec_";
  protected final String TEXT_137 = ".withUpdateExpression(updateExpression_";
  protected final String TEXT_138 = ".toString())" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t .withValueMap(valueMap_";
  protected final String TEXT_139 = ");\t" + NL + "\t\tif(nameMap_";
  protected final String TEXT_140 = ".size()>0) {" + NL + "\t\t\tupdateItemSpec_";
  protected final String TEXT_141 = " = updateItemSpec_";
  protected final String TEXT_142 = ".withNameMap(nameMap_";
  protected final String TEXT_143 = ");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\ttable_";
  protected final String TEXT_144 = ".updateItem(updateItemSpec_";
  protected final String TEXT_145 = ");" + NL + "\t\t" + NL;
  protected final String TEXT_146 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_147 = "\t\t\t\t" + NL + "\t\t\tdeleteItemSpec_";
  protected final String TEXT_148 = " = deleteItemSpec_";
  protected final String TEXT_149 = ".withPrimaryKey(";
  protected final String TEXT_150 = ", partitionKeyValue_";
  protected final String TEXT_151 = ", " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
  protected final String TEXT_152 = ", sortKeyValue_";
  protected final String TEXT_153 = ");\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_154 = NL + "\t\t\tdeleteItemSpec_";
  protected final String TEXT_155 = " = deleteItemSpec_";
  protected final String TEXT_156 = ".withPrimaryKey(";
  protected final String TEXT_157 = ", partitionKeyValue_";
  protected final String TEXT_158 = ");" + NL + "\t\t";
  protected final String TEXT_159 = NL + "\t\t" + NL + "\t\ttable_";
  protected final String TEXT_160 = ".deleteItem(deleteItemSpec_";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "\t " + NL + "nb_line_";
  protected final String TEXT_163 = " ++;" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	
	String dataAction 	= ElementParameterParser.getValue(node,"__DATA_ACTION__");
	String partitionKey = ElementParameterParser.getValue(node, "__PARTITION_KEY__");
	String sortKey 		= ElementParameterParser.getValue(node, "__SORT_KEY__");
	List<Map<String, String>> nameMappingTable = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAME_MAPPING__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	List< ? extends IConnection> connections = node.getIncomingConnections();
	if (connections == null || connections.size() == 0 || metadatas == null || metadatas.size() == 0){
	    return "";
	}
	
	List<IMetadataColumn> outPutColumns =  metadatas.get(0).getListColumns();
	if (outPutColumns == null || outPutColumns.isEmpty()) {
		return "";
	}
	
	IConnection conn = connections.get(0);
	if (!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		return "";
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
      List<String[]> isJSONList = new java.util.ArrayList();
    for (int i = 0; i < outPutColumns.size(); i++) {
		IMetadataColumn column = outPutColumns.get(i);
		JavaType javaType   = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String isJSON       = ("JSON".equals(column.getType())) ? "Boolean.TRUE" : "Boolean.FALSE";
		String name 		= "\""+column.getOriginalDbColumnName()+"\"";
		String columnNode	= conn.getName() + "." + column.getLabel();
		boolean isDate		= (javaType == JavaTypesManager.DATE);
		boolean isString	= (javaType == JavaTypesManager.STRING);
		boolean isByteArray	= (javaType == JavaTypesManager.BYTE_ARRAY);

        isJSONList.add(new String[]{name, isJSON});

		// This is the Hash Key
		if(column.isKey() &&  name.equals(partitionKey)){ 
	
			 if(isDate){ 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_9);
     } else { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_12);
     } 
		
		// This is the Range Key
 		}else if(column.isKey() &&  name.equals(sortKey)){
 			
 			if(isDate){ 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_16);
     } else { 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_19);
     }
		
 		// Other row items 
		}else {
			   // Handle Nullable Items (also if String is empty we submitted as null)
			   if(column.isNullable()) {  
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_21);
    if(isString) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    if(isByteArray) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_29);
     if(isDate){ 
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_34);
     } else { 
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_38);
     } 
    stringBuffer.append(TEXT_39);
     }
				// Handle the mandatory column (if columns are null or string empty we ignore them)  
			   else { 
    stringBuffer.append(TEXT_40);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_41);
    if(isString) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    if(isByteArray) {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
     if(isDate){ 
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_52);
     } else { 
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(columnNode);
    stringBuffer.append(TEXT_56);
     } 
    stringBuffer.append(TEXT_57);
       }
		}
 }

for(String[] isJSonEntry: isJSONList){

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(isJSonEntry[0]);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(isJSonEntry[1]);
    stringBuffer.append(TEXT_61);
    
}

    stringBuffer.append(TEXT_62);
    
	
if ("INSERT".equalsIgnoreCase(dataAction)) {

		// Add resolved Primary keys to the Item
		if(sortKey !=null && !sortKey.isEmpty() && !sortKey.equals("\"\"")) { 
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(partitionKey);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(sortKey);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
     } else { 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(partitionKey);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
     } 
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
     } else if ("UPDATE".equalsIgnoreCase(dataAction)) {	
    stringBuffer.append(TEXT_93);
     if(sortKey !=null && !sortKey.isEmpty() && !sortKey.equals("\"\"")){	
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(partitionKey);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(sortKey);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
     } else { 
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(partitionKey);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
     } 
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    	for(Map<String,String> mapping : nameMappingTable) {
			String placeholder = mapping.get("PLACEHOLDER");
			String name = mapping.get("NAME");
	
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(placeholder);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(placeholder);
    stringBuffer.append(TEXT_116);
     	} 
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    	if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    	} 
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
     } else if ("DELETE".equalsIgnoreCase(dataAction)) { 	
    stringBuffer.append(TEXT_146);
     if(sortKey !=null && !sortKey.isEmpty() && !sortKey.equals("\"\"")){	
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(partitionKey);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(sortKey);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
     }else { 
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(partitionKey);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
     } 
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
     } 
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    return stringBuffer.toString();
  }
}
