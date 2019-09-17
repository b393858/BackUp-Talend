package org.talend.designer.codegen.translators.bigdata.googlebigquery;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;

public class TBigQueryBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TBigQueryBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBigQueryBulkExecBeginJava result = new TBigQueryBulkExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t/* ----START-CREATING-CLIENT (OAuth 2.0)---- */" + NL + "" + NL + "\t\tfinal String CLIENT_ID_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "\t    ";
  protected final String TEXT_5 = NL + "\t    " + NL + "\t    ";
  protected final String TEXT_6 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = "; ";
  protected final String TEXT_12 = NL + "\t" + NL + "\t\t" + NL + "\t\tfinal String CLIENT_SECRET_";
  protected final String TEXT_13 = " = \"{\\\"web\\\": {\\\"client_id\\\": \\\"\"+";
  protected final String TEXT_14 = "+\"\\\",\\\"client_secret\\\": \\\"\" +decryptedPassword_";
  protected final String TEXT_15 = "+ \"\\\",\\\"auth_uri\\\": \\\"https://accounts.google.com/o/oauth2/auth\\\",\\\"token_uri\\\": \\\"https://accounts.google.com/o/oauth2/token\\\"}}\";" + NL + "\t\tfinal String PROJECT_ID_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ";" + NL + "\t" + NL + "\t\t// Static variables for API scope, callback URI, and HTTP/JSON functions" + NL + "\t\tfinal List<String> SCOPES_";
  protected final String TEXT_18 = " = java.util.Arrays.asList(\"https://www.googleapis.com/auth/bigquery\");" + NL + "\t\tfinal String REDIRECT_URI_";
  protected final String TEXT_19 = " = \"urn:ietf:wg:oauth:2.0:oob\";" + NL + "\t\tfinal com.google.api.client.http.HttpTransport TRANSPORT_";
  protected final String TEXT_20 = " = new com.google.api.client.http.javanet.NetHttpTransport();" + NL + "\t\tfinal com.google.api.client.json.JsonFactory JSON_FACTORY_";
  protected final String TEXT_21 = " = new com.google.api.client.json.jackson2.JacksonFactory();" + NL + "\t" + NL + "\t\tcom.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets clientSecrets_";
  protected final String TEXT_22 = " = com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.load(" + NL + "\t\t\t\t\t\tnew com.google.api.client.json.jackson2.JacksonFactory(), new java.io.InputStreamReader(new java.io.ByteArrayInputStream(" + NL + "\t\t\t\t\t\t\t\tCLIENT_SECRET_";
  protected final String TEXT_23 = ".getBytes())));" + NL + "\t" + NL + "\t\tcom.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow flow_";
  protected final String TEXT_24 = " = null;" + NL + "\t\tcom.google.api.services.bigquery.Bigquery bigqueryclient_";
  protected final String TEXT_25 = " = null;" + NL + "\t\tlong nb_line_";
  protected final String TEXT_26 = " = 0;" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Service Account Scopes [https://www.googleapis.com/auth/bigquery]\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_29 = " - Redirect uris [urn:ietf:wg:oauth:2.0:oob]\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_30 = " - Attempt to load existing refresh token\");" + NL + "\t\t";
  protected final String TEXT_31 = NL + "\t\t// Attempt to load existing refresh token" + NL + "\t\tString tokenFile_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ";" + NL + "\t\tjava.util.Properties properties_";
  protected final String TEXT_34 = " = new java.util.Properties();" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_35 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_36 = ");" + NL + "\t\t\tproperties_";
  protected final String TEXT_37 = ".load(inputStream_";
  protected final String TEXT_38 = ");" + NL + "\t\t\tinputStream_";
  protected final String TEXT_39 = ".close();" + NL + "\t\t} catch (java.io.FileNotFoundException e_";
  protected final String TEXT_40 = ") {" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\tlog.warn(\"";
  protected final String TEXT_42 = " - \"+e_";
  protected final String TEXT_43 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t} catch (java.io.IOException ee_";
  protected final String TEXT_45 = ") {" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\tlog.warn(\"";
  protected final String TEXT_47 = " - \"+ee_";
  protected final String TEXT_48 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t}" + NL + "\t\tString storedRefreshToken_";
  protected final String TEXT_50 = " = (String) properties_";
  protected final String TEXT_51 = ".get(\"refreshtoken\");" + NL + "\t" + NL + "\t\t// Check to see if the an existing refresh token was loaded." + NL + "\t\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t\t// access token." + NL + "\t\tif (storedRefreshToken_";
  protected final String TEXT_52 = " != null) {" + NL + "\t\t\t// Request a new Access token using the refresh token." + NL + "\t\t\tcom.google.api.client.googleapis.auth.oauth2.GoogleCredential credential_";
  protected final String TEXT_53 = " = new com.google.api.client.googleapis.auth.oauth2. GoogleCredential.Builder().setTransport(TRANSPORT_";
  protected final String TEXT_54 = ")" + NL + "\t\t\t\t\t.setJsonFactory(JSON_FACTORY_";
  protected final String TEXT_55 = ").setClientSecrets(clientSecrets_";
  protected final String TEXT_56 = ")" + NL + "\t\t\t\t\t.build().setFromTokenResponse(new com.google.api.client.auth.oauth2.TokenResponse().setRefreshToken(storedRefreshToken_";
  protected final String TEXT_57 = "));" + NL + "\t\t\t" + NL + "\t\t\tcredential_";
  protected final String TEXT_58 = ".refreshToken();" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_60 = " - An existing refresh token was loaded.\");" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\tbigqueryclient_";
  protected final String TEXT_62 = " = new com.google.api.services.bigquery.Bigquery.Builder(new com.google.api.client.http.javanet.NetHttpTransport(),new com.google.api.client.json.jackson2.JacksonFactory(),credential_";
  protected final String TEXT_63 = ").setApplicationName(\"Talend\").build();" + NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_65 = " - The refresh token does not exist.\");" + NL + "\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\tString authorizationCode_";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ";" + NL + "\t\t\tif(authorizationCode_";
  protected final String TEXT_69 = " == null || \"\".equals(authorizationCode_";
  protected final String TEXT_70 = ") || \"\\\"\\\"\".equals(authorizationCode_";
  protected final String TEXT_71 = ")) {" + NL + "\t\t\t\tString authorizeUrl_";
  protected final String TEXT_72 = " = new com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl(" + NL + "\t\t\t\t\t\tclientSecrets_";
  protected final String TEXT_73 = ", REDIRECT_URI_";
  protected final String TEXT_74 = ", SCOPES_";
  protected final String TEXT_75 = ").setState(\"\").build();" + NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_77 = " - Paste this URL into a web browser to authorize BigQuery Access:\\n\"" + NL + "\t\t\t\t\t\t\t\t\t+ authorizeUrl_";
  protected final String TEXT_78 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\tSystem.out" + NL + "\t\t\t\t\t\t.println(\"Paste this URL into a web browser to authorize BigQuery Access:\\n\"" + NL + "\t\t\t\t\t\t\t\t+ authorizeUrl_";
  protected final String TEXT_80 = ");" + NL + "\t\t\t\tthrow new java.lang.Exception(\"Authorization Code error\");" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_82 = " - Exchange the auth code for an access token and refesh token.\");" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t// Exchange the auth code for an access token and refesh token" + NL + "\t\t\t\tif (flow_";
  protected final String TEXT_84 = " == null) {" + NL + "\t\t\t\t\tflow_";
  protected final String TEXT_85 = " = new com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow.Builder(new com.google.api.client.http.javanet.NetHttpTransport()," + NL + "\t\t\t\t\t\t\tnew com.google.api.client.json.jackson2.JacksonFactory(), clientSecrets_";
  protected final String TEXT_86 = ", SCOPES_";
  protected final String TEXT_87 = ")" + NL + "\t\t\t\t\t\t\t.setAccessType(\"offline\").setApprovalPrompt(\"force\")" + NL + "\t\t\t\t\t\t\t.build();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tcom.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse response_";
  protected final String TEXT_88 = " = flow_";
  protected final String TEXT_89 = ".newTokenRequest(authorizationCode_";
  protected final String TEXT_90 = ").setRedirectUri(REDIRECT_URI_";
  protected final String TEXT_91 = ").execute();" + NL + "\t\t\t\tcom.google.api.client.auth.oauth2.Credential credential_";
  protected final String TEXT_92 = " = flow_";
  protected final String TEXT_93 = ".createAndStoreCredential(response_";
  protected final String TEXT_94 = ", null);" + NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_96 = " - Store the refresh token for future use.\");" + NL + "\t\t\t\t";
  protected final String TEXT_97 = NL + "\t\t\t\t// Store the refresh token for future use." + NL + "\t\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_98 = " = new java.util.Properties();" + NL + "\t\t\t\tstoreProperties_";
  protected final String TEXT_99 = ".setProperty(\"refreshtoken\", credential_";
  protected final String TEXT_100 = ".getRefreshToken());" + NL + "\t\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_101 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_102 = ");" + NL + "\t\t\t\tstoreProperties_";
  protected final String TEXT_103 = ".store(outputStream_";
  protected final String TEXT_104 = ",null);" + NL + "\t\t\t\tif (outputStream_";
  protected final String TEXT_105 = " != null) {" + NL + "\t\t\t\t    outputStream_";
  protected final String TEXT_106 = ".close();" + NL + "\t\t\t\t}" + NL + "\t" + NL + "\t\t\t\tbigqueryclient_";
  protected final String TEXT_107 = " = new com.google.api.services.bigquery.Bigquery.Builder(new com.google.api.client.http.javanet.NetHttpTransport(),new com.google.api.client.json.jackson2.JacksonFactory(),credential_";
  protected final String TEXT_108 = ").build();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/* ----END-CREATING-CLIENT (OAuth 2.0)---- */" + NL + "\t" + NL + "\t";
  protected final String TEXT_109 = NL + "\t\t/* ----START-CREATING-CLIENT (Cloud API)---- */" + NL + "" + NL + "\t\tcom.google.auth.oauth2.GoogleCredentials credentials_";
  protected final String TEXT_110 = ";" + NL + "\t\tjava.io.File credentialsFile_";
  protected final String TEXT_111 = " = new java.io.File(";
  protected final String TEXT_112 = ");" + NL + "\t\ttry(java.io.FileInputStream credentialsStream_";
  protected final String TEXT_113 = " = new java.io.FileInputStream(credentialsFile_";
  protected final String TEXT_114 = ")) {" + NL + "\t\t    credentials_";
  protected final String TEXT_115 = " = com.google.auth.oauth2.ServiceAccountCredentials.fromStream(credentialsStream_";
  protected final String TEXT_116 = ");" + NL + "\t\t}" + NL + "" + NL + "\t\tcom.google.cloud.bigquery.BigQuery bigquery_";
  protected final String TEXT_117 = " = com.google.cloud.bigquery.BigQueryOptions.newBuilder()" + NL + "\t\t\t\t.setCredentials(credentials_";
  protected final String TEXT_118 = ")" + NL + "\t\t\t\t.setProjectId(";
  protected final String TEXT_119 = ")" + NL + "\t\t\t\t.build()" + NL + "\t\t\t\t.getService();" + NL + "" + NL + "\t\t/* ----END-CREATING-CLIENT (Cloud API)---- */" + NL + "" + NL + "\t\tlong nb_line_";
  protected final String TEXT_120 = " = 0;" + NL + "\t";
  protected final String TEXT_121 = NL + "\t\t/* ----START-UPLOADING-FILE---- */";
  protected final String TEXT_122 = NL + "        ";
  protected final String TEXT_123 = " " + NL + "        \tfinal String decryptedPwd_";
  protected final String TEXT_124 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "        \tfinal String decryptedPwd_";
  protected final String TEXT_127 = " = ";
  protected final String TEXT_128 = "; ";
  protected final String TEXT_129 = NL + NL + NL + "\t\torg.jets3t.service.security.GSCredentials gsCredentials_";
  protected final String TEXT_130 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_131 = ", decryptedPwd_";
  protected final String TEXT_132 = ");" + NL + "\t\t";
  protected final String TEXT_133 = NL + "\t\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService gsService_";
  protected final String TEXT_134 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(gsCredentials_";
  protected final String TEXT_135 = ",\" ";
  protected final String TEXT_136 = "\",null);" + NL + "" + NL + "\t\tjava.io.File fileData_";
  protected final String TEXT_137 = " = new java.io.File(";
  protected final String TEXT_138 = ");" + NL + "\t\torg.jets3t.service.model.GSObject fileObject_";
  protected final String TEXT_139 = " = new org.jets3t.service.model.GSObject(fileData_";
  protected final String TEXT_140 = ");" + NL + "\t\t";
  protected final String TEXT_141 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_142 = " - Upload \"+";
  protected final String TEXT_143 = " + \" to Google Service Bucket: \"+";
  protected final String TEXT_144 = ");" + NL + "\t\t";
  protected final String TEXT_145 = NL + "\t\tgsService_";
  protected final String TEXT_146 = ".putObject(";
  protected final String TEXT_147 = ", fileObject_";
  protected final String TEXT_148 = ");" + NL + "\t\t";
  protected final String TEXT_149 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_150 = " - Upload Done.\");" + NL + "\t\t";
  protected final String TEXT_151 = NL + "\t/* ----END-UPLOADING-FILE---- */" + NL + "" + NL + "\t";
  protected final String TEXT_152 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_153 = " - Starting build a job.\");" + NL + "\t\t";
  protected final String TEXT_154 = NL + "\t\t/* ----START-CREATING-JOB (OAuth 2.0)---- */" + NL + "\t\tcom.google.api.services.bigquery.model.Job job_";
  protected final String TEXT_155 = " = new com.google.api.services.bigquery.model.Job();" + NL + "\t\tjob_";
  protected final String TEXT_156 = ".setJobReference(new com.google.api.services.bigquery.model.JobReference().setProjectId(PROJECT_ID_";
  protected final String TEXT_157 = "));" + NL + "\t" + NL + "\t\tcom.google.api.services.bigquery.model.JobConfiguration config_";
  protected final String TEXT_158 = " = new com.google.api.services.bigquery.model.JobConfiguration();" + NL + "\t\tcom.google.api.services.bigquery.model.JobConfigurationLoad queryLoad_";
  protected final String TEXT_159 = " = new com.google.api.services.bigquery.model.JobConfigurationLoad();" + NL + "\t\tcom.google.api.services.bigquery.model.TableSchema schema_";
  protected final String TEXT_160 = " = new com.google.api.services.bigquery.model.TableSchema();" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_161 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_162 = " - Table field schema:\");" + NL + "\t\t";
  protected final String TEXT_163 = NL + "\t\tjava.util.List<com.google.api.services.bigquery.model.TableFieldSchema> fields_";
  protected final String TEXT_164 = " = new java.util.ArrayList<com.google.api.services.bigquery.model.TableFieldSchema>();" + NL + "\t\t";
  protected final String TEXT_165 = NL + "\t\t\t\t\tcom.google.api.services.bigquery.model.TableFieldSchema ";
  protected final String TEXT_166 = "_";
  protected final String TEXT_167 = " = new com.google.api.services.bigquery.model.TableFieldSchema();" + NL + "\t\t\t\t\t";
  protected final String TEXT_168 = "_";
  protected final String TEXT_169 = ".setName(\"";
  protected final String TEXT_170 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_171 = "_";
  protected final String TEXT_172 = ".setType(\"";
  protected final String TEXT_173 = "\");" + NL + "\t\t\t\t\tfields_";
  protected final String TEXT_174 = ".add(";
  protected final String TEXT_175 = "_";
  protected final String TEXT_176 = ");\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_178 = " - Field index[";
  protected final String TEXT_179 = "] {\\\"name\\\":\\\"";
  protected final String TEXT_180 = "\\\",\\\"type\\\":\\\"";
  protected final String TEXT_181 = "\\\"}\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t" + NL + "\t" + NL + "\t\tschema_";
  protected final String TEXT_183 = ".setFields(fields_";
  protected final String TEXT_184 = ");" + NL + "\t" + NL + "\t\tqueryLoad_";
  protected final String TEXT_185 = ".setSchema(schema_";
  protected final String TEXT_186 = ");" + NL + "\t\t";
  protected final String TEXT_187 = NL + "\t\t\tqueryLoad_";
  protected final String TEXT_188 = ".setCreateDisposition(\"CREATE_IF_NEEDED\");" + NL + "\t\t";
  protected final String TEXT_189 = NL + "\t\t\tqueryLoad_";
  protected final String TEXT_190 = ".setCreateDisposition(\"CREATE_NEVER\");" + NL + "\t\t";
  protected final String TEXT_191 = NL + "\t\t\tqueryLoad_";
  protected final String TEXT_192 = ".setFieldDelimiter(";
  protected final String TEXT_193 = ");" + NL + "\t\t";
  protected final String TEXT_194 = NL + "\t\tqueryLoad_";
  protected final String TEXT_195 = ".setAllowQuotedNewlines(true);" + NL + "\t" + NL + "\t\tqueryLoad_";
  protected final String TEXT_196 = ".setWriteDisposition(\"WRITE_";
  protected final String TEXT_197 = "\");" + NL + "\t\tcom.google.api.services.bigquery.model.TableReference destinationTable_";
  protected final String TEXT_198 = " = new com.google.api.services.bigquery.model.TableReference();" + NL + "\t\tdestinationTable_";
  protected final String TEXT_199 = ".setProjectId(PROJECT_ID_";
  protected final String TEXT_200 = ");" + NL + "\t\tdestinationTable_";
  protected final String TEXT_201 = ".setDatasetId(";
  protected final String TEXT_202 = ");" + NL + "\t\tdestinationTable_";
  protected final String TEXT_203 = ".setTableId(";
  protected final String TEXT_204 = ");" + NL + "\t" + NL + "\t\tqueryLoad_";
  protected final String TEXT_205 = ".setDestinationTable(destinationTable_";
  protected final String TEXT_206 = ");" + NL + "\t\tqueryLoad_";
  protected final String TEXT_207 = ".setSourceUris(java.util.Arrays.asList(";
  protected final String TEXT_208 = "));" + NL + "\t\tqueryLoad_";
  protected final String TEXT_209 = ".setSkipLeadingRows(";
  protected final String TEXT_210 = ");" + NL + "\t" + NL + "\t\tconfig_";
  protected final String TEXT_211 = ".setLoad(queryLoad_";
  protected final String TEXT_212 = ");" + NL + "\t\t" + NL + "\t\tjob_";
  protected final String TEXT_213 = ".setConfiguration(config_";
  protected final String TEXT_214 = ");" + NL + "\t" + NL + "\t\tcom.google.api.services.bigquery.Bigquery.Jobs.Insert insertReq_";
  protected final String TEXT_215 = " = bigqueryclient_";
  protected final String TEXT_216 = ".jobs().insert(\"\", job_";
  protected final String TEXT_217 = ");" + NL + "\t\tinsertReq_";
  protected final String TEXT_218 = ".setProjectId(PROJECT_ID_";
  protected final String TEXT_219 = ");" + NL + "\t\t";
  protected final String TEXT_220 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_221 = " - Build a job successfully.\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_222 = " - Starting load the job.\");" + NL + "\t\t";
  protected final String TEXT_223 = NL + "\t\tSystem.out.println(\"Starting load job.\");" + NL + "\t\tcom.google.api.services.bigquery.model.Job jobExec_";
  protected final String TEXT_224 = " = null;" + NL + "\t\ttry {" + NL + "\t\t\tjobExec_";
  protected final String TEXT_225 = " = insertReq_";
  protected final String TEXT_226 = ".execute();" + NL + "\t\t} catch (Exception ee_";
  protected final String TEXT_227 = ") {" + NL + "\t\t\t";
  protected final String TEXT_228 = NL + "\t\t\t\tthrow ee_";
  protected final String TEXT_229 = ";" + NL + "\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_231 = " - \"+ ee_";
  protected final String TEXT_232 = ".getMessage() + \"\\n\" + ee_";
  protected final String TEXT_233 = ".getCause());" + NL + "\t\t\t\t";
  protected final String TEXT_234 = NL + "\t\t\t\tSystem.err.println(ee_";
  protected final String TEXT_235 = ".getMessage() + \"\\n\" + ee_";
  protected final String TEXT_236 = ".getCause());" + NL + "\t\t\t";
  protected final String TEXT_237 = NL + "\t\t}" + NL + "\t\tif (jobExec_";
  protected final String TEXT_238 = ".getStatus().getState().equals(\"RUNNING\")" + NL + "\t\t\t\t|| jobExec_";
  protected final String TEXT_239 = ".getStatus().getState().equals(\"PENDING\")) {" + NL + "\t\t\tcom.google.api.services.bigquery.model.Job pollJob_";
  protected final String TEXT_240 = " = bigqueryclient_";
  protected final String TEXT_241 = ".jobs().get(PROJECT_ID_";
  protected final String TEXT_242 = ",jobExec_";
  protected final String TEXT_243 = ".getJobReference().getJobId()).execute();" + NL + "\t\t\twhile (pollJob_";
  protected final String TEXT_244 = ".getStatus().getState().equals(\"RUNNING\") || pollJob_";
  protected final String TEXT_245 = ".getStatus().getState().equals(\"PENDING\")) {" + NL + "\t\t\t\tThread.sleep(1000);" + NL + "\t\t\t\tpollJob_";
  protected final String TEXT_246 = " = bigqueryclient_";
  protected final String TEXT_247 = ".jobs().get(PROJECT_ID_";
  protected final String TEXT_248 = ",jobExec_";
  protected final String TEXT_249 = ".getJobReference().getJobId()).execute();" + NL + "\t\t\t\tSystem.out.println(String.format(" + NL + "\t\t\t\t\t\t\"Waiting on job %s ... Current status: %s\", jobExec_";
  protected final String TEXT_250 = NL + "\t\t\t\t\t\t\t\t.getJobReference().getJobId(), pollJob_";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\t\t\t.getStatus().getState()));" + NL + "\t\t\t\t";
  protected final String TEXT_252 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_253 = " - \"+String.format(\"Waiting on job %s ... Current status: %s\", jobExec_";
  protected final String TEXT_254 = ".getJobReference().getJobId(), pollJob_";
  protected final String TEXT_255 = ".getStatus().getState()));" + NL + "\t\t\t\t";
  protected final String TEXT_256 = NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\tcom.google.api.services.bigquery.model.Job doneJob_";
  protected final String TEXT_257 = " = pollJob_";
  protected final String TEXT_258 = ";" + NL + "\t" + NL + "\t\t\tif ((doneJob_";
  protected final String TEXT_259 = ".getStatus() != null) && (doneJob_";
  protected final String TEXT_260 = ".getStatus().getErrors() != null)) {" + NL + "\t\t\t\tstatus = \"failure\";" + NL + "\t\t\t\tthrow new Exception(doneJob_";
  protected final String TEXT_261 = ".getStatus().getErrors().toString());" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\tSystem.out.println(\"Done: \" + doneJob_";
  protected final String TEXT_262 = ".toString());" + NL + "\t\t\tcom.google.api.services.bigquery.model.JobStatistics jobStatistics_";
  protected final String TEXT_263 = "= doneJob_";
  protected final String TEXT_264 = ".getStatistics();" + NL + "\t\t\tif(jobStatistics_";
  protected final String TEXT_265 = "!=null && jobStatistics_";
  protected final String TEXT_266 = ".getLoad() != null){" + NL + "\t\t\t\tcom.google.api.services.bigquery.model.JobStatistics3 loadObject_";
  protected final String TEXT_267 = " = jobStatistics_";
  protected final String TEXT_268 = ".getLoad();" + NL + "\t\t\t\tif(loadObject_";
  protected final String TEXT_269 = "!= null){" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_270 = " = loadObject_";
  protected final String TEXT_271 = ".getOutputRows();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_272 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_273 = " - Load Done: \" + doneJob_";
  protected final String TEXT_274 = ".toString());" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_275 = " - \" + nb_line_";
  protected final String TEXT_276 = " + \" records load successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_277 = NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_278 = NL + "\t\t\t\tthrow new Exception(jobExec_";
  protected final String TEXT_279 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_280 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_281 = " - Error: \" + jobExec_";
  protected final String TEXT_282 = ".toString());" + NL + "\t\t\t\t";
  protected final String TEXT_283 = NL + "\t\t\t\tSystem.err.println(\"Error: \" + jobExec_";
  protected final String TEXT_284 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_285 = NL + "\t\t}" + NL + "\t\t/* ----END-CREATING-JOB (OAuth 2.0)---- */" + NL + "\t";
  protected final String TEXT_286 = NL + "\t\t/* ----START-CREATING-JOB (Cloud API)---- */" + NL + "\t\tcom.google.cloud.bigquery.TableId tableId_";
  protected final String TEXT_287 = " = com.google.cloud.bigquery.TableId.of(";
  protected final String TEXT_288 = ", ";
  protected final String TEXT_289 = ", ";
  protected final String TEXT_290 = ");" + NL + "\t\tcom.google.cloud.bigquery.Table table_";
  protected final String TEXT_291 = " = bigquery_";
  protected final String TEXT_292 = ".getTable(tableId_";
  protected final String TEXT_293 = ");" + NL + "\t\tif (";
  protected final String TEXT_294 = " && table_";
  protected final String TEXT_295 = " != null) {" + NL + "\t\t\tboolean deleted = bigquery_";
  protected final String TEXT_296 = ".delete(tableId_";
  protected final String TEXT_297 = ");\t" + NL + "\t\t\tif (deleted) {" + NL + "\t\t\t\t";
  protected final String TEXT_298 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_299 = " - table \" + tableId_";
  protected final String TEXT_300 = " + \" deleted\");" + NL + "\t\t\t\t";
  protected final String TEXT_301 = NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow new RuntimeException(\"Unable to delete table \" + tableId_";
  protected final String TEXT_302 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tboolean tableNotExist = table_";
  protected final String TEXT_303 = " == null;" + NL + "\t\tif (";
  protected final String TEXT_304 = " || tableNotExist) {" + NL + "\t\t\tboolean typeSupported = true;" + NL + "\t\t\tjava.util.List<com.google.cloud.bigquery.Field> fields_";
  protected final String TEXT_305 = " = new java.util.ArrayList<>();" + NL + "\t\t\t";
  protected final String TEXT_306 = NL + "\t\t\t\t\t\t\ttypeSupported = false;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_307 = NL + "\t\t\t\t\t\tif (!typeSupported) {" + NL + "\t\t\t\t\t\t\tthrow new IllegalArgumentException(\"unsupported type for column [";
  protected final String TEXT_308 = "]: \" + \"";
  protected final String TEXT_309 = "\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tcom.google.cloud.bigquery.Field field_";
  protected final String TEXT_310 = " = com.google.cloud.bigquery.Field.of(\"";
  protected final String TEXT_311 = "\", ";
  protected final String TEXT_312 = ");" + NL + "\t\t\t\t\t\tfields_";
  protected final String TEXT_313 = ".add(field_";
  protected final String TEXT_314 = ");\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_315 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_316 = " - Field index[";
  protected final String TEXT_317 = "] {\\\"name\\\":\\\"";
  protected final String TEXT_318 = "\\\",\\\"type\\\":\\\"";
  protected final String TEXT_319 = "\\\"}\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_320 = NL + "\t\t\tcom.google.cloud.bigquery.Schema schema_";
  protected final String TEXT_321 = " = com.google.cloud.bigquery.Schema.of(fields_";
  protected final String TEXT_322 = ");" + NL + "\t\t\tcom.google.cloud.bigquery.TableInfo tableInfo_";
  protected final String TEXT_323 = " = com.google.cloud.bigquery.TableInfo.newBuilder(tableId_";
  protected final String TEXT_324 = ", com.google.cloud.bigquery.StandardTableDefinition.of(schema_";
  protected final String TEXT_325 = ")).build();" + NL + "\t\t\ttable_";
  protected final String TEXT_326 = " = bigquery_";
  protected final String TEXT_327 = ".create(tableInfo_";
  protected final String TEXT_328 = ");" + NL + "\t\t}" + NL + "\t\tcom.google.cloud.bigquery.Job job_";
  protected final String TEXT_329 = " = table_";
  protected final String TEXT_330 = ".load(com.google.cloud.bigquery.FormatOptions.csv(), ";
  protected final String TEXT_331 = ");" + NL + "\t\tjob_";
  protected final String TEXT_332 = " = job_";
  protected final String TEXT_333 = ".waitFor(com.google.cloud.RetryOption.initialRetryDelay(org.threeten.bp.Duration.ofSeconds(1)), com.google.cloud.RetryOption.totalTimeout(org.threeten.bp.Duration.ofSeconds(30)));" + NL + "\t\tif (job_";
  protected final String TEXT_334 = " != null && job_";
  protected final String TEXT_335 = ".getStatus().getError() == null) {" + NL + "\t\t\t";
  protected final String TEXT_336 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_337 = " - Job execution status: \" + job_";
  protected final String TEXT_338 = ".getStatus());" + NL + "\t\t\t";
  protected final String TEXT_339 = NL + "\t\t} else {" + NL + "\t\t\tthrow new RuntimeException(\"Job failed: \" + job_";
  protected final String TEXT_340 = ".getStatus().getError());" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/* ----END-CREATING-JOB (Cloud API)---- */" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

	INode node = (INode)codeGenArgument.getArgument();

	String cid = node.getUniqueName();

	String authMode = ElementParameterParser.getValue(node,"__AUTH_MODE__");
	String credentialsFile = ElementParameterParser.getValue(node, "__SERVICE_ACCOUNT_CREDENTIALS_FILE__");
	String clientId = ElementParameterParser.getValue(node,"__CLIENT_ID__");
	String clientSecret = ElementParameterParser.getValue(node,"__CLIENT_SECRET__");
	String projectId = ElementParameterParser.getValue(node,"__PROJECT_ID__");
	String authorizationCode = ElementParameterParser.getValue(node,"__AUTHORIZATION_CODE__");
	String dataset = ElementParameterParser.getValue(node, "__DATASET__");
	String table = ElementParameterParser.getValue(node, "__TABLE__");
	String gsFile = ElementParameterParser.getValue(node, "__GS_FILE__");

	String actionOnData = ElementParameterParser.getValue(node, "__ACTION_ON_DATA__");
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    String tokenFile = ElementParameterParser.getValue(node,"__TOKEN_NAME__");
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String passwordFieldName = "";
	
    if (authMode.equals("OAUTH")) {
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(clientId );
    stringBuffer.append(TEXT_4);
    
	    passwordFieldName = "__CLIENT_SECRET__";
	    
    stringBuffer.append(TEXT_5);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(clientId);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(projectId );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
		}
		
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
			}
			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
			}
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
			}
			
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
			}
			
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(authorizationCode);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
		    	if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
				}
		    	
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
				}
				
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
				}
				
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
	} else if (authMode.equals("SERVICEACCOUNT")) {
	
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(credentialsFile);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(projectId);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
	} else {
		throw new IllegalArgumentException("authentication mode should be either \"SERVICEACCOUNT\" or \"OAUTH\", but it is " + authMode);
	}
	boolean bulkFileAlreadyExists = "true".equals(ElementParameterParser.getValue(node, "__BULK_FILE_ALREADY_EXIST__"));
	String accessKey = ElementParameterParser.getValue(node, "__GS_ACCESS_KEY__");
	String secretKey = ElementParameterParser.getValue(node, "__GS_SECRET_KEY__");
	String localFilename = ElementParameterParser.getValue(node, "__GS_LOCAL_FILE__");
	String bucketName = ElementParameterParser.getValue(node, "__BUCKET_NAME__");
	if(!bulkFileAlreadyExists) {
	
    stringBuffer.append(TEXT_121);
    
        passwordFieldName = "__GS_SECRET_KEY__";
        
    stringBuffer.append(TEXT_122);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_125);
    } else {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    final String GoogleTracker = org.talend.core.utils.TrackerUtil.getGoogleTracker();
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(GoogleTracker);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(localFilename);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(localFilename);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_144);
    
		}
		
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
		}
	}
	
    stringBuffer.append(TEXT_151);
    
    if (authMode.equals("OAUTH")) {
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
		}
		
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
		}
		
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
		List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null) && (metadatas.size() > 0)) {
			IMetadataTable metadata = metadatas.get(0);
			if (metadata != null) {
				List<IMetadataColumn> columns = metadata.getListColumns();
				int nbColumns = columns.size();
				for (int i = 0; i < nbColumns; i++ ) {
					IMetadataColumn column = columns.get(i);
					String columnName = column.getLabel();
					String typeToGenerate = "string";
					if("id_Float".equals(column.getTalendType())) {
						typeToGenerate = "float";
					} else if("id_Integer".equals(column.getTalendType())) {
						typeToGenerate = "integer";
					} else if("id_Boolean".equals(column.getTalendType())) {
						typeToGenerate = "boolean";
					} else if("id_Date".equals(column.getTalendType())) {
						typeToGenerate = "timestamp";
					}
					
    stringBuffer.append(TEXT_165);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_181);
    
					}
				}
			}
		}
		
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
		if("true".equals(ElementParameterParser.getValue(node, "__CREATE_TABLE_IF_NOT_EXIST__"))) {
		
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
		} else {
		
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
		}
	
		if("true".equals(ElementParameterParser.getValue(node, "__SET_FIELD_DELIMITER__"))) {
		
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELD_DELIMITER__"));
    stringBuffer.append(TEXT_193);
    
		}
		
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(actionOnData);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(dataset);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GS_FILE__"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GS_FILE_HEADER__"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
		}
		
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    
			if(dieOnError) {
			
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    
			} else {
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    
				}
				
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    
			}
			
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
				}
				
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    
			}
			
    stringBuffer.append(TEXT_277);
    
			if(dieOnError) {
			
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
			} else {
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
				}
				
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
			}
			
    stringBuffer.append(TEXT_285);
    
	} else if (authMode.equals("SERVICEACCOUNT")) {
	
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(projectId);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(dataset);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(ElementParameterParser.getBooleanValue(node, "__DROP__"));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    
				}
				
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(ElementParameterParser.getBooleanValue(node, "__DROP__"));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    
			List<IMetadataTable> metadatas = node.getMetadataList();
			if ((metadatas!=null) && (metadatas.size() > 0)) {
				IMetadataTable metadata = metadatas.get(0);
				if (metadata != null) {
					List<IMetadataColumn> columns = metadata.getListColumns();
					int nbColumns = columns.size();
					for (int i = 0; i < nbColumns; i++ ) {
						IMetadataColumn column = columns.get(i);
						String columnName = column.getLabel();
						String typeToGenerate = null;
						if("id_String".equals(column.getTalendType())) {
							typeToGenerate = "com.google.cloud.bigquery.LegacySQLTypeName.STRING";
						} else if ("id_Float".equals(column.getTalendType()) || "id_Double".equals(column.getTalendType())) {
							typeToGenerate = "com.google.cloud.bigquery.LegacySQLTypeName.FLOAT";
						} else if ("id_Short".equals(column.getTalendType()) || "id_Integer".equals(column.getTalendType()) || "id_Long".equals(column.getTalendType())) {
							typeToGenerate = "com.google.cloud.bigquery.LegacySQLTypeName.INTEGER";
						} else if ("id_Boolean".equals(column.getTalendType())) {
							typeToGenerate = "com.google.cloud.bigquery.LegacySQLTypeName.BOOLEAN";
						} else if ("id_Date".equals(column.getTalendType())) {
							typeToGenerate = "com.google.cloud.bigquery.LegacySQLTypeName.TIMESTAMP";
						} else {
						
    stringBuffer.append(TEXT_306);
    
						}
						
    stringBuffer.append(TEXT_307);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(column.getTalendType());
    stringBuffer.append(TEXT_309);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_314);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_319);
    
						}
					}
				}
			}
			
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gsFile);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    
			}
			
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    
	} else {
		throw new IllegalArgumentException("authentication mode should be either \"SERVICEACCOUNT\" or \"OAUTH\", but it is " + authMode);
	}
	
    return stringBuffer.toString();
  }
}
