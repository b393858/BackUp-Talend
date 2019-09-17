package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class TPigFilterColumnsMainJava
{
  protected static String nl;
  public static synchronized TPigFilterColumnsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigFilterColumnsMainJava result = new TPigFilterColumnsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_8 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_11 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_16 = " - Written records count: \" + nb_line_";
  protected final String TEXT_17 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_19 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_22 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Writing the record \" + nb_line_";
  protected final String TEXT_25 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processing the record \" + nb_line_";
  protected final String TEXT_28 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_30 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_31 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_32 = "\t" + NL + "\t" + NL + "\troutines.system.PigHelper helper_";
  protected final String TEXT_33 = " = new routines.system.PigHelper();" + NL + "\t" + NL + "\tStringBuilder sb_";
  protected final String TEXT_34 = " = new StringBuilder();" + NL + "\tsb_";
  protected final String TEXT_35 = ".append(\"";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = "_RESULT = FOREACH ";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = "_RESULT GENERATE \");";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_41 = ".append(\"";
  protected final String TEXT_42 = "\");\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_44 = ".append(\", ";
  protected final String TEXT_45 = "\");";
  protected final String TEXT_46 = NL + "\tsb_";
  protected final String TEXT_47 = ".append(\";\");" + NL + "\t" + NL + "\thelper_";
  protected final String TEXT_48 = ".add(\"query\",sb_";
  protected final String TEXT_49 = ".toString());" + NL + "\t" + NL + "\t";
  protected final String TEXT_50 = NL + "\tjava.util.List<String[]> pigLatins_";
  protected final String TEXT_51 = " = helper_";
  protected final String TEXT_52 = ".getPigLatins();";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = NL + "        \tjava.util.List<com.amazonaws.services.s3.model.S3ObjectSummary> s3Objects_";
  protected final String TEXT_55 = " = s3Client_";
  protected final String TEXT_56 = ".listObjectsV2(";
  protected final String TEXT_57 = ").getObjectSummaries();" + NL + "        \tjava.util.Set<String> s3Keys_";
  protected final String TEXT_58 = " = s3Objects_";
  protected final String TEXT_59 = ".stream().map(obj -> obj.getKey()).collect(java.util.stream.Collectors.toSet());";
  protected final String TEXT_60 = NL + NL + "\t\tfor(String[] pigLatin_";
  protected final String TEXT_61 = " : pigLatins_";
  protected final String TEXT_62 = ") {" + NL + "\t\t\tString type_";
  protected final String TEXT_63 = " = pigLatin_";
  protected final String TEXT_64 = "[0];" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_66 = " - register \" + type_";
  protected final String TEXT_67 = " + \": \" + pigLatin_";
  protected final String TEXT_68 = "[1]);" + NL + "\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\tif(\"query\".equals(type_";
  protected final String TEXT_70 = ")) {";
  protected final String TEXT_71 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_72 = ".write(pigLatin_";
  protected final String TEXT_73 = "[1]);";
  protected final String TEXT_74 = NL + "\t\t\t\t\tstatements_";
  protected final String TEXT_75 = ".append(pigLatin_";
  protected final String TEXT_76 = "[1]);" + NL + "\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_78 = ".registerQuery(pigLatin_";
  protected final String TEXT_79 = "[1]);";
  protected final String TEXT_80 = NL + "\t\t\t} else if (\"jar\".equals(type_";
  protected final String TEXT_81 = ")) {";
  protected final String TEXT_82 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_83 = ".write(\"REGISTER \" + wasbPath_";
  protected final String TEXT_84 = " + new java.io.File(pigLatin_";
  protected final String TEXT_85 = "[1]).getName() + \";\");" + NL + "\t\t\t\t\tlibjars_";
  protected final String TEXT_86 = ".append(pigLatin_";
  protected final String TEXT_87 = "[1] + \",\");";
  protected final String TEXT_88 = NL + "\t\t\t\t\tString jarName_";
  protected final String TEXT_89 = " = new String();" + NL + "\t\t\t\t\tString[] pathSplit = pigLatin_";
  protected final String TEXT_90 = "[1].split(\"/\");" + NL + "            \t\tjarName_";
  protected final String TEXT_91 = " = pathSplit[pathSplit.length - 1];" + NL + "            \t\tjava.util.regex.Pattern jarPattern = java.util.regex.Pattern.compile(\".*\\\\.jar\");" + NL + "\t\t\t\t\tif (!jarPattern.matcher(jarName_";
  protected final String TEXT_92 = ").matches()) {" + NL + "            \t\t\tthrow new IllegalArgumentException(\"";
  protected final String TEXT_93 = " - Incorrect jar path: \" + pigLatin_";
  protected final String TEXT_94 = "[1]);" + NL + "        \t\t\t}" + NL + "        \t\t\tboolean exist = s3Keys_";
  protected final String TEXT_95 = ".contains(";
  protected final String TEXT_96 = ".replaceAll(\"^/+|/+$\", \"\") + \"/\" + jarName_";
  protected final String TEXT_97 = ");" + NL + "        \t\t\tif (!exist) {" + NL + "\t\t\t\t\t\ts3Client_";
  protected final String TEXT_98 = ".putObject(";
  protected final String TEXT_99 = ", ";
  protected final String TEXT_100 = ".replaceAll(\"^/+|/+$\", \"\") + \"/\" + jarName_";
  protected final String TEXT_101 = ", new java.io.File(pigLatin_";
  protected final String TEXT_102 = "[1]));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tstatements_";
  protected final String TEXT_103 = ".append(\"REGISTER s3a://\" + ";
  protected final String TEXT_104 = " + \":\" + routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_105 = ") + \"@\" + ";
  protected final String TEXT_106 = " + \"/\" + ";
  protected final String TEXT_107 = ".replaceAll(\"^/+|/+$\", \"\") + \"/\" + jarName_";
  protected final String TEXT_108 = " + \";\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_110 = " - upload jar to S3: \" + pigLatin_";
  protected final String TEXT_111 = "[1] + \" --> s3a://\" + ";
  protected final String TEXT_112 = " + \"/\" + ";
  protected final String TEXT_113 = ".replaceAll(\"^/+|/+$\", \"\") + \"/\" + jarName_";
  protected final String TEXT_114 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_116 = ".registerJar(pigLatin_";
  protected final String TEXT_117 = "[1]);";
  protected final String TEXT_118 = NL + "\t\t\t} else if (\"script\".equals(type_";
  protected final String TEXT_119 = ")) {";
  protected final String TEXT_120 = NL + "\t\t\t\t\t\tbw_";
  protected final String TEXT_121 = ".write(pigLatin_";
  protected final String TEXT_122 = "[1]);";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\t// Script is not supported on qubole.";
  protected final String TEXT_124 = NL + "\t\t\t\t\t\tpigServer_";
  protected final String TEXT_125 = ".registerScript(new java.io.ByteArrayInputStream(pigLatin_";
  protected final String TEXT_126 = "[1].getBytes()));";
  protected final String TEXT_127 = NL + "\t\t\t} else if (\"function\".equals(type_";
  protected final String TEXT_128 = ")) {";
  protected final String TEXT_129 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_130 = ".write(\"DEFINE \" + pigLatin_";
  protected final String TEXT_131 = "[1] + \" \" + pigLatin_";
  protected final String TEXT_132 = "[2] + \";\");";
  protected final String TEXT_133 = NL + "\t\t\t\t\t\t// DEFINE is not supported on qubole.";
  protected final String TEXT_134 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_135 = ".registerFunction(pigLatin_";
  protected final String TEXT_136 = "[1], new org.apache.pig.FuncSpec(pigLatin_";
  protected final String TEXT_137 = "[2]));";
  protected final String TEXT_138 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_139 = NL + "    \tpigScript_";
  protected final String TEXT_140 = ".addAll(pigLatins_";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL + "\tpigLatins_";
  protected final String TEXT_143 = ".clear();" + NL;
  protected final String TEXT_144 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String previous_node="";
	String start_node="";

	boolean inMain = true;
	boolean isExecutedThroughWebHCat = false;
	
	boolean isQuboleDistribution = false;
	boolean isCloudDistribution = false;
	boolean isQuboleS3Resource = false;
	String quboleS3ResourceAccessKey = "";
	String quboleS3ResourceSecretKey = "";
	String quboleS3ResourceBucketName = "";
	String quboleS3ResourceBucketKey = "";

	String previousOutputConnectionName = "";
	
	if(node.getIncomingConnections()!=null && node.getIncomingConnections().size()>0) {
		IConnection connection = node.getIncomingConnections().get(0);
		previous_node = connection.getSource().getUniqueName();
		INode loadNode = node.getDesignSubjobStartNode();
		start_node = loadNode.getUniqueName();
		
		boolean isLocal = "true".equals(ElementParameterParser.getValue(loadNode, "__LOCAL__"));

        if(!isLocal) {
            String loadDistribution = ElementParameterParser.getValue(loadNode, "__DISTRIBUTION__");
            String loadPigVersion = ElementParameterParser.getValue(loadNode, "__PIG_VERSION__");
            org.talend.hadoop.distribution.component.PigComponent pigDistrib = null;
            try {
                pigDistrib = (org.talend.hadoop.distribution.component.PigComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(loadDistribution, loadPigVersion);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return "";
            }

            boolean isCustom = pigDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
            isExecutedThroughWebHCat = !isCustom && pigDistrib != null && pigDistrib.isExecutedThroughWebHCat();
            isQuboleDistribution = pigDistrib != null && pigDistrib.isQuboleDistribution();
            isCloudDistribution = pigDistrib != null && pigDistrib.isCloudDistribution();
            if (isQuboleDistribution && ElementParameterParser.getBooleanValue(loadNode, "__QUBOLE_S3__")) {
            	quboleS3ResourceAccessKey = ElementParameterParser.getValue(loadNode, "__QUBOLE_S3_ACCESS_KEY__");
            	quboleS3ResourceSecretKey = ElementParameterParser.getPasswordValue(loadNode, "__QUBOLE_S3_SECRET_KEY__");
            	quboleS3ResourceBucketName = ElementParameterParser.getValue(loadNode, "__QUBOLE_S3_BUCKET_NAME__");
            	quboleS3ResourceBucketKey = ElementParameterParser.getValue(loadNode, "__QUBOLE_S3_BUCKET_KEY__");
            }
        }
		
		inMain = loadNode.isSubtreeStart();
		previousOutputConnectionName = connection.getName();
	}
	
	String outputConnectionName = "";
	List<IConnection> outputConnections = (List<IConnection>)node.getOutgoingConnections();
	if(outputConnections!=null && outputConnections.size()>0) {
		outputConnectionName = outputConnections.get(0).getName();
	}


    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
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
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	log4jFileUtil.componentStartInfo(node);
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_39);
    
	Set<String> inputCols = new HashSet<String>();
 
 	
	if (node.getIncomingConnections()!=null) {
		for (IConnection incomingConn : node.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					inputCols.add(inputCol.getLabel());
				}
				break;
			}
		}
	}
	
	boolean isFirst = true;
	for (IConnection conn : node.getOutgoingConnections()) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			IMetadataTable outputMetadataTable = conn.getMetadataTable();
			if (outputMetadataTable!=null) {
				for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) { 
					if (inputCols.contains(outputCol.getLabel())) {
						if(isFirst) {
							isFirst=false;
					

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_42);
    
						} else {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_45);
    
						}
					}
				}
			}
			break;
		}
	}

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
	if(inMain) {

    stringBuffer.append(TEXT_53);
    if (isQuboleDistribution && isQuboleS3Resource) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(quboleS3ResourceBucketName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    if(isLog4jEnabled && !isQuboleDistribution) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    					
				} else if (isQuboleDistribution) {
				
    stringBuffer.append(TEXT_74);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
				} else {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
				}

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    					
				} else if (isQuboleDistribution) {
					if (isQuboleS3Resource) {
				
    stringBuffer.append(TEXT_88);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(quboleS3ResourceBucketKey);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(quboleS3ResourceBucketName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(quboleS3ResourceBucketKey);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(quboleS3ResourceAccessKey);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(quboleS3ResourceSecretKey);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(quboleS3ResourceBucketName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(quboleS3ResourceBucketKey);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_108);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(quboleS3ResourceBucketName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(quboleS3ResourceBucketKey);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_114);
    }
					}
				} else {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
				}

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
					if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    					
					} else if (isQuboleDistribution) {

    stringBuffer.append(TEXT_123);
    
					} else {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
					}

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
					if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    					
					} else if (isQuboleDistribution) {

    stringBuffer.append(TEXT_133);
    
					} else {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
					}

    stringBuffer.append(TEXT_138);
    
	} else {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
	}

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(TEXT_144);
    return stringBuffer.toString();
  }
}
