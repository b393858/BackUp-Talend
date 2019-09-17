package org.talend.designer.codegen.translators.databases.dbspecifics.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TTeradataFastExportMainJava
{
  protected static String nl;
  public static synchronized TTeradataFastExportMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastExportMainJava result = new TTeradataFastExportMainJava();
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
  protected final String TEXT_29 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_30 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_31 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_33 = " - Uses an existing connection ";
  protected final String TEXT_34 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_36 = " - Uses an existing connection. Connection URL: \" + conn_";
  protected final String TEXT_37 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_39 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_40 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_41 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\tconn_";
  protected final String TEXT_44 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_45 = ", dbUser_";
  protected final String TEXT_46 = ", dbPwd_";
  protected final String TEXT_47 = ");" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\tconn_";
  protected final String TEXT_49 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_50 = ");" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\tconn_";
  protected final String TEXT_52 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\tconn_";
  protected final String TEXT_54 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\tconn_";
  protected final String TEXT_56 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\tconn_";
  protected final String TEXT_58 = ".setAutoCommit(";
  protected final String TEXT_59 = ");" + NL + "\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\tlog.";
  protected final String TEXT_61 = "(\"";
  protected final String TEXT_62 = " - \" + ";
  protected final String TEXT_63 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t    \t\tlog.";
  protected final String TEXT_65 = "(\"";
  protected final String TEXT_66 = "\");" + NL + "\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_68 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_70 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_71 = ": pstmt_";
  protected final String TEXT_72 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_73 = " += (countEach_";
  protected final String TEXT_74 = " < 0 ? 0 : ";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "   String runtimeFileSep_";
  protected final String TEXT_77 = " = System.getProperty(\"file.separator\");" + NL + "   String runtimeLineSep_";
  protected final String TEXT_78 = " = System.getProperty(\"line.separator\");" + NL + "   boolean runOnWindows_";
  protected final String TEXT_79 = " = \"\\\\\".equals(runtimeFileSep_";
  protected final String TEXT_80 = ");" + NL + "" + NL + "   java.util.Map<String,String> fileSeparatorMapping_";
  protected final String TEXT_81 = " = new java.util.HashMap<>();" + NL + "   fileSeparatorMapping_";
  protected final String TEXT_82 = ".put(\"\\\\\", \"/\");" + NL + "   fileSeparatorMapping_";
  protected final String TEXT_83 = ".put(\"/\", \"\\\\\");" + NL + "" + NL + "   String scriptPath_";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = ";" + NL + "   String exportedFile_";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ";" + NL + "   String errorFile_";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = ";" + NL + "   if(!(scriptPath_";
  protected final String TEXT_90 = ".endsWith(\"\\\\\") || scriptPath_";
  protected final String TEXT_91 = ".endsWith(\"/\"))){" + NL + "       scriptPath_";
  protected final String TEXT_92 = " = scriptPath_";
  protected final String TEXT_93 = " + java.io.File.separator;" + NL + "   }" + NL + "   scriptPath_";
  protected final String TEXT_94 = " = scriptPath_";
  protected final String TEXT_95 = ".replace(" + NL + "                                                         fileSeparatorMapping_";
  protected final String TEXT_96 = ".get(runtimeFileSep_";
  protected final String TEXT_97 = ")" + NL + "                                                         , runtimeFileSep_";
  protected final String TEXT_98 = ");" + NL + "   exportedFile_";
  protected final String TEXT_99 = " = exportedFile_";
  protected final String TEXT_100 = ".replace(" + NL + "                                                         fileSeparatorMapping_";
  protected final String TEXT_101 = ".get(runtimeFileSep_";
  protected final String TEXT_102 = ")" + NL + "                                                         , runtimeFileSep_";
  protected final String TEXT_103 = ");" + NL + "   errorFile_";
  protected final String TEXT_104 = " = errorFile_";
  protected final String TEXT_105 = ".replace(" + NL + "                                                         fileSeparatorMapping_";
  protected final String TEXT_106 = ".get(runtimeFileSep_";
  protected final String TEXT_107 = ")" + NL + "                                                         , runtimeFileSep_";
  protected final String TEXT_108 = ");";
  protected final String TEXT_109 = NL + "         java.nio.file.Path pathScriptDir_";
  protected final String TEXT_110 = " = java.nio.file.FileSystems.getDefault().getPath(scriptPath_";
  protected final String TEXT_111 = ");" + NL + "         if(!java.nio.file.Files.exists(pathScriptDir_";
  protected final String TEXT_112 = ", java.nio.file.LinkOption.NOFOLLOW_LINKS)){" + NL + "            java.nio.file.Files.createDirectories(pathScriptDir_";
  protected final String TEXT_113 = ");" + NL + "         }" + NL + "" + NL + "         java.nio.file.Path pathExportedFile_";
  protected final String TEXT_114 = " = java.nio.file.FileSystems.getDefault().getPath(exportedFile_";
  protected final String TEXT_115 = ");" + NL + "         if(!java.nio.file.Files.exists(pathExportedFile_";
  protected final String TEXT_116 = ", java.nio.file.LinkOption.NOFOLLOW_LINKS)){" + NL + "            java.nio.file.Files.createDirectories(pathExportedFile_";
  protected final String TEXT_117 = ".getParent());" + NL + "         }" + NL + "" + NL + "         java.nio.file.Path pathErrorFile_";
  protected final String TEXT_118 = " = java.nio.file.FileSystems.getDefault().getPath(errorFile_";
  protected final String TEXT_119 = ");" + NL + "         if(!java.nio.file.Files.exists(pathErrorFile_";
  protected final String TEXT_120 = ", java.nio.file.LinkOption.NOFOLLOW_LINKS)){" + NL + "            java.nio.file.Files.createDirectories(pathErrorFile_";
  protected final String TEXT_121 = ".getParent());" + NL + "         }";
  protected final String TEXT_122 = NL;
  protected final String TEXT_123 = NL + "    String tableFullName_";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = " + \".\" + ";
  protected final String TEXT_126 = ";" + NL + "    String generatedScriptPath_";
  protected final String TEXT_127 = " = scriptPath_";
  protected final String TEXT_128 = " + ";
  protected final String TEXT_129 = " +\".script\";" + NL + "    java.io.File file_";
  protected final String TEXT_130 = " = new java.io.File(generatedScriptPath_";
  protected final String TEXT_131 = ");" + NL + "try{" + NL + "    java.io.FileWriter fw_";
  protected final String TEXT_132 = " = new java.io.FileWriter(file_";
  protected final String TEXT_133 = ");" + NL + "    StringBuilder script_";
  protected final String TEXT_134 = " = new StringBuilder();" + NL + "    fw_";
  protected final String TEXT_135 = ".write(\".LOGTABLE \"+";
  protected final String TEXT_136 = "+\".\"+";
  protected final String TEXT_137 = "+\";\" + runtimeLineSep_";
  protected final String TEXT_138 = ");" + NL;
  protected final String TEXT_139 = NL;
  protected final String TEXT_140 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_141 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_142 = ");";
  protected final String TEXT_143 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_144 = " = ";
  protected final String TEXT_145 = "; ";
  protected final String TEXT_146 = NL + NL + "    fw_";
  protected final String TEXT_147 = ".write(\".LOGON \"+";
  protected final String TEXT_148 = "+\"/\"";
  protected final String TEXT_149 = " \"\" ";
  protected final String TEXT_150 = "+";
  protected final String TEXT_151 = "+\",\"+decryptedPassword_";
  protected final String TEXT_152 = "+\";\"+ runtimeLineSep_";
  protected final String TEXT_153 = ");" + NL;
  protected final String TEXT_154 = NL + "    fw_";
  protected final String TEXT_155 = ".write(\".BEGIN EXPORT SESSIONS 8;\"+runtimeLineSep_";
  protected final String TEXT_156 = ");";
  protected final String TEXT_157 = NL + "        fw_";
  protected final String TEXT_158 = ".write(\"SELECT ";
  protected final String TEXT_159 = "CAST(('' ||";
  protected final String TEXT_160 = "\"+runtimeLineSep_";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "                    fw_";
  protected final String TEXT_163 = ".write(\"TRIM(COALESCE(CAST(";
  protected final String TEXT_164 = " AS CHAR(";
  protected final String TEXT_165 = ")),'')) || '\"+";
  protected final String TEXT_166 = "+\"' ||\"+runtimeLineSep_";
  protected final String TEXT_167 = ");";
  protected final String TEXT_168 = NL + "                    fw_";
  protected final String TEXT_169 = ".write(\"cast( ";
  protected final String TEXT_170 = " as CHAR(";
  protected final String TEXT_171 = ")),\"+runtimeLineSep_";
  protected final String TEXT_172 = ");";
  protected final String TEXT_173 = NL + "                    fw_";
  protected final String TEXT_174 = ".write(\"TRIM(COALESCE(CAST(";
  protected final String TEXT_175 = " AS VARCHAR(";
  protected final String TEXT_176 = ")),''))) AS CHAR(";
  protected final String TEXT_177 = "))\"+runtimeLineSep_";
  protected final String TEXT_178 = ");";
  protected final String TEXT_179 = NL + "                    fw_";
  protected final String TEXT_180 = ".write(\"cast( ";
  protected final String TEXT_181 = " as CHAR(";
  protected final String TEXT_182 = "))\"+runtimeLineSep_";
  protected final String TEXT_183 = ");";
  protected final String TEXT_184 = NL + NL + "        fw_";
  protected final String TEXT_185 = ".write(\"FROM \"+ ";
  protected final String TEXT_186 = " + \".\" + ";
  protected final String TEXT_187 = "+\";\"+runtimeLineSep_";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL + "        fw_";
  protected final String TEXT_190 = ".write(";
  protected final String TEXT_191 = " +\";\"+runtimeLineSep_";
  protected final String TEXT_192 = ");";
  protected final String TEXT_193 = NL;
  protected final String TEXT_194 = NL + "    fw_";
  protected final String TEXT_195 = ".write(\".EXPORT OUTFILE \\\"\"+ exportedFile_";
  protected final String TEXT_196 = " +\"\\\" FORMAT TEXT mode record;\"+runtimeLineSep_";
  protected final String TEXT_197 = ");" + NL + "    fw_";
  protected final String TEXT_198 = ".write(\".END EXPORT;\"+runtimeLineSep_";
  protected final String TEXT_199 = ");" + NL + "    fw_";
  protected final String TEXT_200 = ".write(\".LOGOFF;\"+runtimeLineSep_";
  protected final String TEXT_201 = ");" + NL;
  protected final String TEXT_202 = NL + "    fw_";
  protected final String TEXT_203 = ".close();" + NL;
  protected final String TEXT_204 = NL + "    String[] strArr_";
  protected final String TEXT_205 = " = new String[3];" + NL + "    String expCmd_";
  protected final String TEXT_206 = " = null;" + NL + "    if(runOnWindows_";
  protected final String TEXT_207 = "){" + NL + "        expCmd_";
  protected final String TEXT_208 = " = \"fexp < \\\"\"+ generatedScriptPath_";
  protected final String TEXT_209 = " + \"\\\" > \\\"\"+errorFile_";
  protected final String TEXT_210 = "+\"\\\" 2>&1\";" + NL + "        strArr_";
  protected final String TEXT_211 = "[0] = \"cmd\";" + NL + "        strArr_";
  protected final String TEXT_212 = "[1] = \"/c\";" + NL + "    }else{" + NL + "        expCmd_";
  protected final String TEXT_213 = " = \"fexp < \"+ generatedScriptPath_";
  protected final String TEXT_214 = " + \" > \\\"\"+errorFile_";
  protected final String TEXT_215 = "+\"\\\" 2>&1\";" + NL + "        strArr_";
  protected final String TEXT_216 = "[0] = \"sh\";" + NL + "        strArr_";
  protected final String TEXT_217 = "[1] = \"-c\";" + NL + "    }" + NL + "        strArr_";
  protected final String TEXT_218 = "[2] = expCmd_";
  protected final String TEXT_219 = ";" + NL;
  protected final String TEXT_220 = NL + "        log.info(\"";
  protected final String TEXT_221 = " - Executing command '\" + expCmd_";
  protected final String TEXT_222 = " + \"'.\");";
  protected final String TEXT_223 = NL + "    final Process process_";
  protected final String TEXT_224 = " = Runtime.getRuntime().exec(strArr_";
  protected final String TEXT_225 = ");" + NL + "" + NL + "    Thread normal_";
  protected final String TEXT_226 = " = new Thread() {" + NL + "        public void run() {" + NL + "            try {" + NL + "                java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_227 = ".getInputStream()));" + NL + "                String line = \"\";" + NL + "" + NL + "                try {" + NL + "                    while((line = reader.readLine()) != null) {" + NL + "                        System.out.println(line);" + NL + "                    }" + NL + "                } finally {" + NL + "                     reader.close();" + NL + "                }" + NL + "            }catch(java.io.IOException ioe) {";
  protected final String TEXT_228 = NL + "                ioe.printStackTrace();" + NL + "            }" + NL + "        }" + NL + "    };" + NL + "    normal_";
  protected final String TEXT_229 = ".start();" + NL + "" + NL + "    Thread error_";
  protected final String TEXT_230 = " = new Thread() {" + NL + "        public void run() {" + NL + "            try {" + NL + "                java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_231 = ".getErrorStream()));" + NL + "                String line = \"\";" + NL + "                try {" + NL + "                    while((line = reader.readLine()) != null) {" + NL + "                        System.err.println(line);" + NL + "                    }" + NL + "                } finally {" + NL + "                    reader.close();" + NL + "                }" + NL + "            } catch(java.io.IOException ioe) {";
  protected final String TEXT_232 = NL + "               ioe.printStackTrace();" + NL + "            }" + NL + "        }" + NL + "    };" + NL + "    error_";
  protected final String TEXT_233 = ".start();" + NL + "    process_";
  protected final String TEXT_234 = ".waitFor();" + NL + "    normal_";
  protected final String TEXT_235 = ".interrupt();" + NL + "    error_";
  protected final String TEXT_236 = ".interrupt();" + NL;
  protected final String TEXT_237 = NL + "           if(process_";
  protected final String TEXT_238 = ".exitValue() != 0){" + NL + "                throw new RuntimeException(\"The subprocess terminated unnormally.\");" + NL + "           }";
  protected final String TEXT_239 = NL;
  protected final String TEXT_240 = NL + "        log.info(\"";
  protected final String TEXT_241 = " - Excute '\" + expCmd_";
  protected final String TEXT_242 = " + \"' has finished.\");";
  protected final String TEXT_243 = NL + "}finally{" + NL + "    file_";
  protected final String TEXT_244 = ".delete();" + NL + "}";
  protected final String TEXT_245 = NL;

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
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			useExistConnection(node, true);
		}

		public void useExistConnection(INode node, boolean needUserAndPassword){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_34);
    } else if (!needUserAndPassword){
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			if ("SSO".equals(ElementParameterParser.getValue(node, "__JDBC_URL__"))){
				connectWithSSO();
			} else {
				connect();
			}
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
			connect_end();
		}
		
		public void connectWithSSO(){
			connect_begin_noUser();
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_59);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_60);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_63);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_64);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_66);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_75);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String host = ElementParameterParser.getValue(node, "__HOST__");
String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");

String table= ElementParameterParser.getValue(node, "__TABLE__");
String logDB = ElementParameterParser.getValue(node, "__LOG_DB__");
String logTable = ElementParameterParser.getValue(node, "__LOG_TABLE__");

boolean needHost = ("".equals(host) || "\"\"".equals(host)) ? false : true;
        logDB = ("".equals(logDB) || "\"\"".equals(logDB)) ? dbname : logDB;
        logTable = ("".equals(logTable) || "\"\"".equals(logTable)) ? table + "+\"_lt\"" : logTable;

boolean useQuery = "true".equals(ElementParameterParser.getValue(node, "__USE_QUERY__"));
String query = ElementParameterParser.getValue(node, "__QUERY__");
       query = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(query);

String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String exportedFile= ElementParameterParser.getValue(node, "__EXPORTED_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");

boolean createDirsWhenNeeded = "true".equals(ElementParameterParser.getValue(node, "__CREATE_DIRECTORIES_WHEN_NEEDED__"));
boolean dieWhenUnnormalTerminated = "true".equals(ElementParameterParser.getValue(node, "__DIE_WHEN_UNNORMAL_TERMINATED__"));


    stringBuffer.append(TEXT_76);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( scriptPath );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( exportedFile );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( errorFile );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_108);
    
      if(createDirsWhenNeeded){
      
    stringBuffer.append(TEXT_109);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_121);
    
      }
      
    stringBuffer.append(TEXT_122);
    
List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        columnList = metadata.getListColumns();
    }
}
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_126);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(logDB);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(logTable);
    stringBuffer.append(TEXT_137);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_138);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_139);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_142);
    } else {
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_145);
    }
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    if(needHost) {
    stringBuffer.append(host);
    stringBuffer.append(TEXT_148);
    } else {
    stringBuffer.append(TEXT_149);
    }
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_153);
    //Layout---------------------------------------------------------------
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_156);
    if(!useQuery) {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    if(separator.length()>0 && !"\"\"".equals(separator)){
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_161);
    
        if(columnList!=null){
            int counter = 1;
            int columnsLength = 0;
            for(IMetadataColumn column:columnList){
                if( columnList.size() != counter){
                    if(separator.length()>0 && !"\"\"".equals(separator)){
                        columnsLength+=(column.getLength()==null?0:column.getLength())+separator.length();
                
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_166);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_167);
    }else{
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_171);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_172);
    }
    
                } else {
                    if(separator.length()>0 && !"\"\"".equals(separator)){
                        columnsLength+=(column.getLength()==null?0:column.getLength())+1;
            
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(columnsLength);
    stringBuffer.append(TEXT_177);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_178);
    }else{
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_182);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_183);
    }
     }
                counter++;
            }
        }
        
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_187);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_188);
    } else {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_191);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    //Export file----------------------------------------------------------
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_201);
    //write script to file-------------------------------------------------
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    //run fexp command----------------------------------------------------
    stringBuffer.append(TEXT_204);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_219);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_222);
    }
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    
        if(dieWhenUnnormalTerminated){
        
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    
        }
     
    stringBuffer.append(TEXT_239);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_242);
    }
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(TEXT_245);
    return stringBuffer.toString();
  }
}
