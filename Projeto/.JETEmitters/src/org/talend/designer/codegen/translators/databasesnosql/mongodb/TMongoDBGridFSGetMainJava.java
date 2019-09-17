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

public class TMongoDBGridFSGetMainJava
{
  protected static String nl;
  public static synchronized TMongoDBGridFSGetMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBGridFSGetMainJava result = new TMongoDBGridFSGetMainJava();
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
  protected final String TEXT_29 = NL + "\t\t\t    ";
  protected final String TEXT_30 = NL + "\t\t\t\t\tString outputFileName_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = " + \"/\" + gridFSfile.getObjectId();" + NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\tString outputFileName_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = " + \"/\" + gridFSfile.getId();" + NL + "\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\tString outputFileName_";
  protected final String TEXT_38 = " = ";
  protected final String TEXT_39 = " + \"/\" + gridFSfile.getFilename();";
  protected final String TEXT_40 = NL + "\tjava.io.File outputFile_";
  protected final String TEXT_41 = " = new java.io.File(outputFileName_";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\t\tif(outputFile_";
  protected final String TEXT_44 = ".exists()){" + NL + "\t\t\tSystem.err.println(outputFileName_";
  protected final String TEXT_45 = " + \" exists, will not be overwritten.\");" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_47 = " - file : \" + outputFileName_";
  protected final String TEXT_48 = " + \" exists, will not be overwritten.\");" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t}else{" + NL + "\t\t\t    ";
  protected final String TEXT_50 = NL + "\t\t\t    try(java.io.FileOutputStream fos_";
  protected final String TEXT_51 = "=new java.io.FileOutputStream(outputFile_";
  protected final String TEXT_52 = ")){" + NL + "\t\t\t\t\t    gridfs_";
  protected final String TEXT_53 = ".downloadToStream(gridFSfile.getId(),fos_";
  protected final String TEXT_54 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\t\tgridFSfile.writeTo(outputFile_";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\tnb_line_";
  protected final String TEXT_58 = "++;" + NL + "\t\t}";
  protected final String TEXT_59 = NL + "\t\t" + NL + "\t\t\ttry(java.io.FileOutputStream fos_";
  protected final String TEXT_60 = " = new java.io.FileOutputStream(outputFile_";
  protected final String TEXT_61 = ")){" + NL + "\t\t\t\t gridfs_";
  protected final String TEXT_62 = ".downloadToStream(gridFSfile.getId(),fos_";
  protected final String TEXT_63 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_64 = NL + "\t\tgridFSfile.writeTo(outputFile_";
  protected final String TEXT_65 = ");" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\tnb_line_";
  protected final String TEXT_67 = "++;";

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
  	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
  	String outputLocalPath = ElementParameterParser.getValue(node, "__OUTPUT_LOCAL_PATH__");
    boolean overWriteLocalFiles = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__OVERWRITE_LOCAL_FILES__"));
    boolean idAsFilename = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__ID_AS_FILENAME__"));
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String dbversion;
	if(useExistingConnection){
	    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
        dbversion = ElementParameterParser.getValue(connectionNode, "__DB_VERSION__");
    }else{
        dbversion = ElementParameterParser.getValue(node, "__DB_VERSION__");
    }
    boolean version_3_5_X = "MONGODB_3_5_X".equals(dbversion);

    // Generate output filename
    if(idAsFilename){

    stringBuffer.append(TEXT_29);
    if(version_3_5_X){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(outputLocalPath);
    stringBuffer.append(TEXT_32);
    } else {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(outputLocalPath);
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    
	}else{

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outputLocalPath);
    stringBuffer.append(TEXT_39);
    
	}


    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    

	// When overwrite is not chosen, print an error message and skip the file
	if(!overWriteLocalFiles){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    if(version_3_5_X){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    } else {
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
	} else {

    if(version_3_5_X){
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    } else {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    
	}

    return stringBuffer.toString();
  }
}
