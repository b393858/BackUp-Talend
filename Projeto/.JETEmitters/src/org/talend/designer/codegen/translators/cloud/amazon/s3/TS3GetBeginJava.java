package org.talend.designer.codegen.translators.cloud.amazon.s3;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TS3GetBeginJava
{
  protected static String nl;
  public static synchronized TS3GetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3GetBeginJava result = new TS3GetBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_4 = " = (com.amazonaws.services.s3.AmazonS3Client)globalMap.get(\"";
  protected final String TEXT_5 = "\");" + NL + "\t\t";
  protected final String TEXT_6 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Get an free connection from \" + \"";
  protected final String TEXT_8 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t    ";
  protected final String TEXT_10 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Creating new connection.\");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "    " + NL + "    \t\t";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + NL + "\t\t\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_20 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_21 = ",decryptedPassword_";
  protected final String TEXT_22 = ");" + NL + "\t\t\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_23 = " = new com.amazonaws.internal.StaticCredentialsProvider(credentials_";
  protected final String TEXT_24 = ");" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_26 = " = new com.amazonaws.auth.InstanceProfileCredentialsProvider();" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tString masterKey_";
  protected final String TEXT_28 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "\t\t\t\tString masterKey_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = "; ";
  protected final String TEXT_33 = NL + "\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_34 = " = new javax.crypto.spec.SecretKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(masterKey_";
  protected final String TEXT_35 = ".getBytes(\"UTF-8\")), \"AES\");" + NL + "\t\t\tcom.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_36 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_37 = ");" + NL + "\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_38 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_39 = ");" + NL + "\t\t";
  protected final String TEXT_40 = NL + "\t\t\t";
  protected final String TEXT_41 = " " + NL + "\t\t\tfinal String kms_cmk_";
  protected final String TEXT_42 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_43 = ");" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\tfinal String kms_cmk_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = "; " + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t" + NL + "\t\t\tcom.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_48 = " = new com.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider(kms_cmk_";
  protected final String TEXT_49 = ");" + NL + "\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t";
  protected final String TEXT_51 = " " + NL + "\t\t\t\tfinal String smk_";
  protected final String TEXT_52 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_53 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\tfinal String smk_";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = "; " + NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_58 = " = new javax.crypto.spec.SecretKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(smk_";
  protected final String TEXT_59 = ".getBytes(\"UTF-8\")), \"AES\");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_60 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_61 = ");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_62 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_63 = ");" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\tjava.io.File keyFile_";
  protected final String TEXT_65 = " = new java.io.File(";
  protected final String TEXT_66 = ");" + NL + "\t\t\t\tjava.io.FileInputStream keyfis_";
  protected final String TEXT_67 = " = null;" + NL + "\t\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_68 = " = null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t        keyfis_";
  protected final String TEXT_69 = " = new java.io.FileInputStream(keyFile_";
  protected final String TEXT_70 = ");" + NL + "\t\t\t        byte[] encodedPrivateKey_";
  protected final String TEXT_71 = " = new byte[(int)keyFile_";
  protected final String TEXT_72 = ".length()];" + NL + "\t\t\t        keyfis_";
  protected final String TEXT_73 = ".read(encodedPrivateKey_";
  protected final String TEXT_74 = ");" + NL + "\t\t\t        symmetricKey_";
  protected final String TEXT_75 = " = new javax.crypto.spec.SecretKeySpec(encodedPrivateKey_";
  protected final String TEXT_76 = ", \"AES\");" + NL + "\t\t        } finally {" + NL + "\t\t        \tif(keyfis_";
  protected final String TEXT_77 = "!=null) {" + NL + "\t\t        \t\tkeyfis_";
  protected final String TEXT_78 = ".close();" + NL + "\t\t        \t}" + NL + "\t\t        }" + NL + "\t\t        " + NL + "\t\t        com.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_79 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_80 = ");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_81 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_82 = ");" + NL + "\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\tjava.io.File filePublicKey_";
  protected final String TEXT_84 = " = new java.io.File(";
  protected final String TEXT_85 = ");" + NL + "\t\t\tjava.io.FileInputStream fis_";
  protected final String TEXT_86 = " = null;" + NL + "\t\t\tbyte[] encodedPublicKey_";
  protected final String TEXT_87 = " = null;" + NL + "\t\t\ttry {" + NL + "\t\t        fis_";
  protected final String TEXT_88 = " = new java.io.FileInputStream(filePublicKey_";
  protected final String TEXT_89 = ");" + NL + "\t\t        encodedPublicKey_";
  protected final String TEXT_90 = " = new byte[(int) filePublicKey_";
  protected final String TEXT_91 = ".length()];" + NL + "\t\t        fis_";
  protected final String TEXT_92 = ".read(encodedPublicKey_";
  protected final String TEXT_93 = ");" + NL + "\t        } finally {" + NL + "\t        \tif(fis_";
  protected final String TEXT_94 = "!=null) {" + NL + "\t        \t\tfis_";
  protected final String TEXT_95 = ".close();" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t" + NL + "\t        java.io.File filePrivateKey_";
  protected final String TEXT_96 = " = new java.io.File(";
  protected final String TEXT_97 = ");" + NL + "\t        byte[] encodedPrivateKey_";
  protected final String TEXT_98 = " = null;" + NL + "\t        try {" + NL + "\t\t        fis_";
  protected final String TEXT_99 = " = new java.io.FileInputStream(filePrivateKey_";
  protected final String TEXT_100 = ");" + NL + "\t\t        encodedPrivateKey_";
  protected final String TEXT_101 = " = new byte[(int) filePrivateKey_";
  protected final String TEXT_102 = ".length()];" + NL + "\t\t        fis_";
  protected final String TEXT_103 = ".read(encodedPrivateKey_";
  protected final String TEXT_104 = ");" + NL + "\t        } finally {" + NL + "\t        \tif(fis_";
  protected final String TEXT_105 = "!=null) {" + NL + "\t        \t\tfis_";
  protected final String TEXT_106 = ".close();" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t" + NL + "\t        java.security.KeyFactory keyFactory_";
  protected final String TEXT_107 = " = java.security.KeyFactory.getInstance(\"";
  protected final String TEXT_108 = "\");" + NL + "\t        " + NL + "\t        java.security.spec.X509EncodedKeySpec publicKeySpec_";
  protected final String TEXT_109 = " = new java.security.spec.X509EncodedKeySpec(" + NL + "\t                encodedPublicKey_";
  protected final String TEXT_110 = ");" + NL + "\t        java.security.PublicKey publicKey_";
  protected final String TEXT_111 = " = keyFactory_";
  protected final String TEXT_112 = ".generatePublic(publicKeySpec_";
  protected final String TEXT_113 = ");" + NL + "\t" + NL + "\t        java.security.spec.PKCS8EncodedKeySpec privateKeySpec_";
  protected final String TEXT_114 = " = new java.security.spec.PKCS8EncodedKeySpec(" + NL + "\t                encodedPrivateKey_";
  protected final String TEXT_115 = ");" + NL + "\t        java.security.PrivateKey privateKey_";
  protected final String TEXT_116 = " = keyFactory_";
  protected final String TEXT_117 = ".generatePrivate(privateKeySpec_";
  protected final String TEXT_118 = ");" + NL + "\t" + NL + "\t        java.security.KeyPair asymmetricKey_";
  protected final String TEXT_119 = " = new java.security.KeyPair(publicKey_";
  protected final String TEXT_120 = ", privateKey_";
  protected final String TEXT_121 = ");" + NL + "\t        " + NL + "\t        com.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_122 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(asymmetricKey_";
  protected final String TEXT_123 = ");" + NL + "\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_124 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_125 = ");" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t\tcom.amazonaws.ClientConfiguration cc_";
  protected final String TEXT_127 = " = new com.amazonaws.ClientConfiguration();" + NL + "\t\tcc_";
  protected final String TEXT_128 = ".setUserAgent(\"";
  protected final String TEXT_129 = "\");" + NL + "\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\t\tint scketSendBufferSizeHints_";
  protected final String TEXT_131 = " = 0;" + NL + "\t\t\t\t\tint socketReceiveBufferSizeHints_";
  protected final String TEXT_132 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_133 = NL + "\t\t\t\t\tscketSendBufferSizeHints_";
  protected final String TEXT_134 = " = ";
  protected final String TEXT_135 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\t\t\tsocketReceiveBufferSizeHints_";
  protected final String TEXT_137 = " = ";
  protected final String TEXT_138 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_140 = ".setProtocol(com.amazonaws.Protocol.";
  protected final String TEXT_141 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_143 = ".set";
  protected final String TEXT_144 = "(";
  protected final String TEXT_145 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\tcc_";
  protected final String TEXT_147 = ".setSocketBufferSizeHints(scketSendBufferSizeHints_";
  protected final String TEXT_148 = ",socketReceiveBufferSizeHints_";
  protected final String TEXT_149 = ");" + NL + "\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\tint sessionDurationSeconds_";
  protected final String TEXT_151 = " = ";
  protected final String TEXT_152 = " * 60;" + NL + "\t\t\tcom.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder stsBuilder_";
  protected final String TEXT_153 = " = " + NL + "\t\t\t\t\tnew com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder(";
  protected final String TEXT_154 = ", ";
  protected final String TEXT_155 = ").withLongLivedCredentialsProvider(credentialsProvider_";
  protected final String TEXT_156 = ")" + NL + "\t\t\t\t\t.withRoleSessionDurationSeconds(sessionDurationSeconds_";
  protected final String TEXT_157 = ");" + NL + "\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\tstsBuilder_";
  protected final String TEXT_159 = ".withServiceEndpoint(";
  protected final String TEXT_160 = ");" + NL + "\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\tstsBuilder_";
  protected final String TEXT_162 = ".withClientConfiguration(cc_";
  protected final String TEXT_163 = ");" + NL + "\t\t\t" + NL + "\t\t\tcredentialsProvider_";
  protected final String TEXT_164 = " = stsBuilder_";
  protected final String TEXT_165 = ".build();" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3 conn_";
  protected final String TEXT_167 = " = com.amazonaws.services.s3.AmazonS3EncryptionClientBuilder.standard()" + NL + "\t\t\t\t\t";
  protected final String TEXT_168 = NL + "\t\t\t        " + NL + "\t\t\t            ";
  protected final String TEXT_169 = NL + "\t\t\t            .withEndpointConfiguration(new com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration(";
  protected final String TEXT_170 = ",null))" + NL + "\t\t\t            .withForceGlobalBucketAccessEnabled(true)" + NL + "\t\t\t            ";
  protected final String TEXT_171 = NL + "\t\t\t            .withEndpointConfiguration(new com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration(";
  protected final String TEXT_172 = ",";
  protected final String TEXT_173 = "))" + NL + "\t\t\t            ";
  protected final String TEXT_174 = NL + "\t\t\t        " + NL + "\t\t            ";
  protected final String TEXT_175 = NL + "\t\t            " + NL + "\t\t            \t";
  protected final String TEXT_176 = NL + "\t\t\t\t        .withRegion(\"us-east-1\") // The first region to try your request against" + NL + "                        .withForceGlobalBucketAccessEnabled(true) // If a bucket is in a different region, try again in the correct region";
  protected final String TEXT_177 = NL + "                        .withRegion(";
  protected final String TEXT_178 = ")";
  protected final String TEXT_179 = NL + "\t\t            " + NL + "\t\t            ";
  protected final String TEXT_180 = NL + "                    .withAccelerateModeEnabled(true)";
  protected final String TEXT_181 = NL + "                    .withCredentials(credentialsProvider_";
  protected final String TEXT_182 = ")" + NL + "                    .withClientConfiguration(cc_";
  protected final String TEXT_183 = ")" + NL + "                    .withEncryptionMaterials(encryptionMaterialsProvider_";
  protected final String TEXT_184 = ")";
  protected final String TEXT_185 = NL + "                    .withCryptoConfiguration(new com.amazonaws.services.s3.model.CryptoConfiguration().withAwsKmsRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_186 = ")))" + NL + "\t\t\t\t\t";
  protected final String TEXT_187 = NL + "                    .build();" + NL + "\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3 conn_";
  protected final String TEXT_189 = " = com.amazonaws.services.s3.AmazonS3ClientBuilder.standard()" + NL + "\t\t\t\t\t";
  protected final String TEXT_190 = NL + "\t\t\t        " + NL + "\t\t\t            ";
  protected final String TEXT_191 = NL + "\t\t\t            .withEndpointConfiguration(new com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration(";
  protected final String TEXT_192 = ",null))" + NL + "\t\t\t            .withForceGlobalBucketAccessEnabled(true)" + NL + "\t\t\t            ";
  protected final String TEXT_193 = NL + "\t\t\t            .withEndpointConfiguration(new com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration(";
  protected final String TEXT_194 = ",";
  protected final String TEXT_195 = "))" + NL + "\t\t\t            ";
  protected final String TEXT_196 = NL + "\t\t\t        " + NL + "\t\t            ";
  protected final String TEXT_197 = NL + "\t\t            " + NL + "\t\t            \t";
  protected final String TEXT_198 = NL + "\t\t\t\t        .withRegion(\"us-east-1\") // The first region to try your request against" + NL + "                        .withForceGlobalBucketAccessEnabled(true) // If a bucket is in a different region, try again in the correct region";
  protected final String TEXT_199 = NL + "                        .withRegion(";
  protected final String TEXT_200 = ")";
  protected final String TEXT_201 = NL + "\t\t            " + NL + "\t\t            ";
  protected final String TEXT_202 = NL;
  protected final String TEXT_203 = NL + "                    .withAccelerateModeEnabled(true)";
  protected final String TEXT_204 = NL + "                    .withCredentials(credentialsProvider_";
  protected final String TEXT_205 = ")" + NL + "                    .withClientConfiguration(cc_";
  protected final String TEXT_206 = ")" + NL + "                    .build();" + NL + "\t\t\t";
  protected final String TEXT_207 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_208 = " - Creating new connection successfully.\");" + NL + "\t\t";
  protected final String TEXT_209 = NL + "\t";
  protected final String TEXT_210 = NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_211 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_212 = " - Getting an object with key:\" + ";
  protected final String TEXT_213 = ");" + NL + "\t\t";
  protected final String TEXT_214 = NL + "\t\t" + NL + "\t\tcom.amazonaws.services.s3.transfer.TransferManager tm_";
  protected final String TEXT_215 = " = com.amazonaws.services.s3.transfer.TransferManagerBuilder" + NL + "    \t\t\t.standard()" + NL + "    \t\t\t.withS3Client(conn_";
  protected final String TEXT_216 = ")" + NL + "    \t\t\t.build();" + NL + "    \t\t\t" + NL + "    com.amazonaws.services.s3.model.GetObjectRequest getObjectRequest_";
  protected final String TEXT_217 = " = new com.amazonaws.services.s3.model.GetObjectRequest(";
  protected final String TEXT_218 = ", ";
  protected final String TEXT_219 = ");" + NL + "    " + NL + "\t\tcom.amazonaws.services.s3.transfer.Download download_";
  protected final String TEXT_220 = " = tm_";
  protected final String TEXT_221 = ".download(" + NL + "\t\t\tgetObjectRequest_";
  protected final String TEXT_222 = ", " + NL + "\t\t\tnew java.io.File(";
  protected final String TEXT_223 = "), " + NL + "\t\t\tnull, " + NL + "\t\t\t0l, " + NL + "\t\t\ttrue);" + NL + "\t\t\t" + NL + "\t\tdownload_";
  protected final String TEXT_224 = ".waitForCompletion();" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_225 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_226 = " - Get the object successfully.\");" + NL + "\t\t";
  protected final String TEXT_227 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_228 = "){" + NL + "\t\t";
  protected final String TEXT_229 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_230 = ");" + NL + "\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_232 = " - \" + e_";
  protected final String TEXT_233 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_234 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_235 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_236 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_237 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_238 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_239 = NL + "\t}" + NL + "\t";
  protected final String TEXT_240 = NL + "\t" + NL + "\t    com.amazonaws.services.s3.model.SelectObjectContentRequest request_";
  protected final String TEXT_241 = " = new com.amazonaws.services.s3.model.SelectObjectContentRequest();" + NL + "\t    request_";
  protected final String TEXT_242 = ".setBucketName(";
  protected final String TEXT_243 = ");" + NL + "        request_";
  protected final String TEXT_244 = ".setKey(";
  protected final String TEXT_245 = ");" + NL + "        request_";
  protected final String TEXT_246 = ".setExpression(";
  protected final String TEXT_247 = ");" + NL + "        request_";
  protected final String TEXT_248 = ".setExpressionType(com.amazonaws.services.s3.model.ExpressionType.SQL);" + NL + "        com.amazonaws.services.s3.model.InputSerialization inputSerialization_";
  protected final String TEXT_249 = " = new com.amazonaws.services.s3.model.InputSerialization();";
  protected final String TEXT_250 = NL + "        com.amazonaws.services.s3.model.CSVInput csvInput_";
  protected final String TEXT_251 = " = new com.amazonaws.services.s3.model.CSVInput()" + NL + "             .withFieldDelimiter(";
  protected final String TEXT_252 = ")";
  protected final String TEXT_253 = NL + "\t\t\t\t    .with";
  protected final String TEXT_254 = "(";
  protected final String TEXT_255 = ")" + NL + "\t\t\t\t";
  protected final String TEXT_256 = NL + "             " + NL + "            .withFileHeaderInfo(\"";
  protected final String TEXT_257 = "\");" + NL + "            inputSerialization_";
  protected final String TEXT_258 = ".setCsv(csvInput_";
  protected final String TEXT_259 = ");";
  protected final String TEXT_260 = NL + "            com.amazonaws.services.s3.model.JSONInput json_";
  protected final String TEXT_261 = " = new com.amazonaws.services.s3.model.JSONInput().withType(\"";
  protected final String TEXT_262 = "\");" + NL + "            inputSerialization_";
  protected final String TEXT_263 = ".setJson(json_";
  protected final String TEXT_264 = ");";
  protected final String TEXT_265 = NL + "            inputSerialization_";
  protected final String TEXT_266 = ".setParquet(new com.amazonaws.services.s3.model.ParquetInput());";
  protected final String TEXT_267 = NL + "        inputSerialization_";
  protected final String TEXT_268 = ".setCompressionType(com.amazonaws.services.s3.model.CompressionType.";
  protected final String TEXT_269 = ");" + NL + "        request_";
  protected final String TEXT_270 = ".setInputSerialization(inputSerialization_";
  protected final String TEXT_271 = ");" + NL + "        com.amazonaws.services.s3.model.OutputSerialization outputSerialization_";
  protected final String TEXT_272 = " = new com.amazonaws.services.s3.model.OutputSerialization();";
  protected final String TEXT_273 = NL + "            com.amazonaws.services.s3.model.CSVOutput csvOutput_";
  protected final String TEXT_274 = " = new com.amazonaws.services.s3.model.CSVOutput()";
  protected final String TEXT_275 = NL + "\t\t\t\t    .with";
  protected final String TEXT_276 = "(";
  protected final String TEXT_277 = ")" + NL + "\t\t\t\t    ";
  protected final String TEXT_278 = ";" + NL + "            outputSerialization_";
  protected final String TEXT_279 = ".setCsv(csvOutput_";
  protected final String TEXT_280 = ");" + NL + "            ";
  protected final String TEXT_281 = NL + "            outputSerialization_";
  protected final String TEXT_282 = ".setJson(new com.amazonaws.services.s3.model.JSONOutput().withRecordDelimiter(";
  protected final String TEXT_283 = "));";
  protected final String TEXT_284 = NL + "            outputSerialization_";
  protected final String TEXT_285 = ".setJson(new com.amazonaws.services.s3.model.JSONOutput());";
  protected final String TEXT_286 = NL + "            outputSerialization_";
  protected final String TEXT_287 = ".setCsv(new com.amazonaws.services.s3.model.CSVOutput());";
  protected final String TEXT_288 = NL + "        request_";
  protected final String TEXT_289 = ".setOutputSerialization(outputSerialization_";
  protected final String TEXT_290 = ");" + NL + "        " + NL + "\t  \t";
  protected final String TEXT_291 = NL + "\t\ttry{" + NL + "\t\tcom.amazonaws.services.s3.model.SelectObjectContentResult result_";
  protected final String TEXT_292 = " = conn_";
  protected final String TEXT_293 = ".selectObjectContent(request_";
  protected final String TEXT_294 = ");" + NL + "\t\t";
  protected final String TEXT_295 = NL + "\t\ttry (java.io.OutputStream fos_";
  protected final String TEXT_296 = " = new java.io.FileOutputStream(new java.io.File (";
  protected final String TEXT_297 = "));" + NL + "\t\tcom.amazonaws.services.s3.model.SelectObjectContentResult result_";
  protected final String TEXT_298 = " = conn_";
  protected final String TEXT_299 = ".selectObjectContent(request_";
  protected final String TEXT_300 = ")){" + NL + "\t\t";
  protected final String TEXT_301 = NL + "\t\t";
  protected final String TEXT_302 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_303 = " - Getting an object with key:\" + ";
  protected final String TEXT_304 = ");" + NL + "\t\t";
  protected final String TEXT_305 = NL + "\t\t            java.io.InputStream ris_";
  protected final String TEXT_306 = " = result_";
  protected final String TEXT_307 = ".getPayload().getRecordsInputStream(" + NL + "\t\t            \t\t";
  protected final String TEXT_308 = "\t" + NL + "                    new com.amazonaws.services.s3.model.SelectObjectContentEventVisitor() {" + NL + "                        @Override" + NL + "                        public void visit(com.amazonaws.services.s3.model.SelectObjectContentEvent.StatsEvent event)" + NL + "                        {" + NL + "                            log.info(" + NL + "                                    \"Received Stats, Bytes Scanned: \" + event.getDetails().getBytesScanned()" + NL + "                                            +  \" Bytes Processed: \" + event.getDetails().getBytesProcessed());" + NL + "                        }" + NL + "" + NL + "                        @Override" + NL + "                        public void visit(com.amazonaws.services.s3.model.SelectObjectContentEvent.EndEvent event)" + NL + "                        {" + NL + "                            log.info(\"Received End Event. Result is complete.\");" + NL + "                        }" + NL + "                    }" + NL + "                    \t\t";
  protected final String TEXT_309 = NL + "            );" + NL + "            ";
  protected final String TEXT_310 = NL + "            globalMap.put(\"";
  protected final String TEXT_311 = "_RECORDS_INPUTSTREAM\",ris_";
  protected final String TEXT_312 = ");";
  protected final String TEXT_313 = NL + "             com.amazonaws.util.IOUtils.copy(ris_";
  protected final String TEXT_314 = ",fos_";
  protected final String TEXT_315 = ");" + NL + "\t\t";
  protected final String TEXT_316 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_317 = " - Get the object successfully.\");" + NL + "\t\t";
  protected final String TEXT_318 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_319 = "){" + NL + "\t\t";
  protected final String TEXT_320 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_321 = ");" + NL + "\t\t";
  protected final String TEXT_322 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_323 = " - \" + e_";
  protected final String TEXT_324 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_325 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_326 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_327 = NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String bucket = ElementParameterParser.getValue(node,"__BUCKET__");
    String key = ElementParameterParser.getValue(node,"__KEY__");
    String file = ElementParameterParser.getValue(node,"__FILE__");
    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
    boolean use_select = "true".equals(ElementParameterParser.getValue(node,"__USE_SELECT__"));
    String header_type = ElementParameterParser.getValue(node,"__HEADER_TYPE__");
    boolean advance_csv = "true".equals(ElementParameterParser.getValue(node,"__ADVANCE_CSV__"));
    boolean globalmap_inputstream = "true".equals(ElementParameterParser.getValue(node,"__GLOBALMAP_INPUTSTREAM__"));
    String file_type = ElementParameterParser.getValue(node,"__FILE_TYPE__");
    String compressed_type = ElementParameterParser.getValue(node,"__COMPRESSED_TYPE__");
    String json_type = ElementParameterParser.getValue(node,"__JSON_TYPE__");
    String field_separator = ElementParameterParser.getValue(node,"__FIELD_SEPARATOR__");
    String query = ElementParameterParser.getValue(node,"__QUERY__");
    boolean config_output = "true".equals(ElementParameterParser.getValue(node,"__CONFIG_OUTPUT__"));
    String output_type = ElementParameterParser.getValue(node,"__OUTPUT_TYPE__");
    String json_recorddelimiter = ElementParameterParser.getValue(node,"__JSON_RECORDDELIMITER__");
    
    List<Map<String,String>> output_csv_config = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__OUTPUT_CSV_CONFIG__");
    List<Map<String,String>> csv_configuration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CSV_CONFIGURATION__");
	
    stringBuffer.append(TEXT_2);
    
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	boolean configClient = "true".equals(ElementParameterParser.getValue(node, "__CONFIG_CLIENT__"));
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	List<Map<String,String>> clientConfiguration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CLIENT_CONFIGURATION__");
	String region = ElementParameterParser.getValue(node,"__REGION__");
	
	boolean useRegionEndpoint 	= "true".equals(ElementParameterParser.getValue(node, "__USE_REGION_ENDPOINT__"));
	String regionEndpoint 		= ElementParameterParser.getValue(node,"__REGION_ENDPOINT__");
	
	boolean assumeRole = "true".equals(ElementParameterParser.getValue(node, "__ASSUME_ROLE__"));
	String arn = ElementParameterParser.getValue(node,"__ARN__");
	String roleSessionName = ElementParameterParser.getValue(node,"__ROLE_SESSION_NAME__");
	
	boolean setStsEndpoint = "true".equals(ElementParameterParser.getValue(node,"__SET_STS_ENDPOINT__"));
	String stsEndpoint = ElementParameterParser.getValue(node,"__STS_ENDPOINT__");
	
	boolean enableAccelerateMode = "true".equals(ElementParameterParser.getValue(node,"__ENABLE_ACCELERATE__"));
	
	String sessionDuration = ElementParameterParser.getValue(node,"__SESSION_DURATION__");
	if(sessionDuration == null || sessionDuration.isEmpty()) {
		sessionDuration = "15";
	}
	
	boolean set_region = (region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region));
	final String AWSTracker = org.talend.core.utils.TrackerUtil.getAWSTracker();
	
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;;
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_5);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
		}
	}else{
	
    stringBuffer.append(TEXT_9);
    
	    if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		}
		
		boolean inherit_credentials = "true".equals(ElementParameterParser.getValue(node, "__INHERIT_CREDENTIALS__"));
		if(!inherit_credentials) {
	    	String passwordFieldName = "__SECRET_KEY__";
	    	
    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
		} else {
		
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		}
		
		boolean encrypt = "true".equals(ElementParameterParser.getValue(node,"__ENCRYPT__"));
		
		//work for tRedshiftOutputBulk
		String encryptionKeyPropertyName = "__ENCRYPTED_KEY__";
		
		//work for s3 components
		String key_type = ElementParameterParser.getValue(node,"__KEY_TYPE__");
		String algorithm_symmetric_master_key = ElementParameterParser.getValue(node,"__ALGORITHM_SYMMETRIC_MASTER_KEY__");
		String algorithm_asymmetric_master_key = ElementParameterParser.getValue(node,"__ALGORITHM_ASYMMETRIC_MASTER_KEY__");
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		
		String encrypted_key_x509 = ElementParameterParser.getValue(node,"__ENCRYPTED_KEY_X509__");
		String public_key = ElementParameterParser.getValue(node,"__PUBLIC_KEY__");
		String private_key = ElementParameterParser.getValue(node,"__PRIVATE_KEY__");
		
		if(encrypt && node.getComponent().getName().startsWith("tRedshift")) {
			if (ElementParameterParser.canEncrypt(node, encryptionKeyPropertyName)) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, encryptionKeyPropertyName));
    stringBuffer.append(TEXT_29);
    
			} else {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(ElementParameterParser.getValue(node, encryptionKeyPropertyName) );
    stringBuffer.append(TEXT_32);
    
			}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
		} else if(encrypt && "KMS_CMK".equals(key_type)) {//KMS
		
    stringBuffer.append(TEXT_40);
    if (ElementParameterParser.canEncrypt(node, "__ENCRYPTED_KEY_CMK__")) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__ENCRYPTED_KEY_CMK__"));
    stringBuffer.append(TEXT_43);
    } else {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ENCRYPTED_KEY_CMK__"));
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
		} else if(encrypt && "SYMMETRIC_MASTER_KEY".equals(key_type)) {//symmetric master key
			if("AES".equals(algorithm_symmetric_master_key) && "BASE64".equals(encoding)) {
			
    stringBuffer.append(TEXT_50);
    if (ElementParameterParser.canEncrypt(node, "__ENCRYPTED_KEY_BASE64__")) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__ENCRYPTED_KEY_BASE64__"));
    stringBuffer.append(TEXT_53);
    } else {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ENCRYPTED_KEY_BASE64__"));
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
			} else if("AES".equals(algorithm_symmetric_master_key) && "X509".equals(encoding)) {
			
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(encrypted_key_x509);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
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
    
			}
		} else if(encrypt && "ASYMMETRIC_MASTER_KEY".equals(key_type)) {//asymmetric master key
		
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(public_key);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(private_key);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
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
    stringBuffer.append(algorithm_asymmetric_master_key);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
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
    
		}
		
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(AWSTracker);
    stringBuffer.append(TEXT_129);
    
		if(configClient && clientConfiguration.size()>0){
			boolean setBuffer = false;
			for(Map<String,String> map :clientConfiguration){
				String client_parameter = map.get("CLIENT_PARAMETER");
				String value = map.get("VALUE");
				if(!setBuffer && ("SocketSendBufferSizeHints".equals(client_parameter) || "SocketReceiveBufferSizeHints".equals(client_parameter))){
					setBuffer=true;
					
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
				}
				if("SocketSendBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_135);
    
				}else if("SocketReceiveBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_138);
    
				}else if("Protocol".equals(client_parameter)){
				
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(value.toUpperCase().replaceAll("\"",""));
    stringBuffer.append(TEXT_141);
    
				}else{
				
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(client_parameter);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_145);
    
				}
			}
			if(setBuffer){
			
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
			}
			
		}
		
		if(assumeRole) {
		
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(sessionDuration);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(arn);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(roleSessionName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
			if(setStsEndpoint) {
			
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(stsEndpoint);
    stringBuffer.append(TEXT_160);
    
			}
			
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
		}
			if(encrypt) {
			
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    if(useRegionEndpoint && regionEndpoint != null && !regionEndpoint.isEmpty()){
    stringBuffer.append(TEXT_168);
    if(!set_region){
    stringBuffer.append(TEXT_169);
    stringBuffer.append(regionEndpoint);
    stringBuffer.append(TEXT_170);
    }else{
    stringBuffer.append(TEXT_171);
    stringBuffer.append(regionEndpoint);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    }else{
    stringBuffer.append(TEXT_175);
    if(!set_region){
    stringBuffer.append(TEXT_176);
    }else{
    stringBuffer.append(TEXT_177);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    }
    if(enableAccelerateMode){
    stringBuffer.append(TEXT_180);
    }
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    if("KMS_CMK".equals(key_type) && set_region) {
    stringBuffer.append(TEXT_185);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    
			} else {
			
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    if(useRegionEndpoint && regionEndpoint != null && !regionEndpoint.isEmpty()){
    stringBuffer.append(TEXT_190);
    if(!set_region){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(regionEndpoint);
    stringBuffer.append(TEXT_192);
    }else{
    stringBuffer.append(TEXT_193);
    stringBuffer.append(regionEndpoint);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_195);
    }
    stringBuffer.append(TEXT_196);
    }else{
    stringBuffer.append(TEXT_197);
    if(!set_region){
    stringBuffer.append(TEXT_198);
    }else{
    stringBuffer.append(TEXT_199);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_200);
    }
    stringBuffer.append(TEXT_201);
    }
    stringBuffer.append(TEXT_202);
    if(enableAccelerateMode){
    stringBuffer.append(TEXT_203);
    }
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    
			}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    
		}
	}
	
    stringBuffer.append(TEXT_209);
    if(!use_select){
    stringBuffer.append(TEXT_210);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_213);
    
		}
		
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
		}
		
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
		if (dieOnError) {
		
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    
			}
			
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    
		}
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    
		}
		
    stringBuffer.append(TEXT_239);
    }else{
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    if("CSV".equals(file_type)){
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(field_separator);
    stringBuffer.append(TEXT_252);
    if(advance_csv && csv_configuration.size()>0){
                 for(Map<String,String> map :csv_configuration){
				    String csv_parameter = map.get("CSV_PARAMETER");
				    String value = map.get("VALUE");
    stringBuffer.append(TEXT_253);
    stringBuffer.append(csv_parameter);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_255);
    }
             }
    stringBuffer.append(TEXT_256);
    stringBuffer.append(header_type);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    }else if("JSON".equals(file_type)){
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(json_type);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    }else{//APACHE_PARQUET
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    }
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(compressed_type);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    if(config_output){
    if("CSV".equals(output_type)){
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    if(output_csv_config.size()>0){
                     for(Map<String,String> map :output_csv_config){
				        String csv_parameter = map.get("CSV_PARAMETER");
				        String value = map.get("VALUE");
    stringBuffer.append(TEXT_275);
    stringBuffer.append(csv_parameter);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_277);
    }
                 }
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    }else if("JSON".equals(output_type)){
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(json_recorddelimiter);
    stringBuffer.append(TEXT_283);
    }
    }else{
    if("JSON".equals(file_type)){
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    }else{//CSV Parquet
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    }
    }
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    if(globalmap_inputstream){
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    }else{
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    }
    stringBuffer.append(TEXT_301);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_304);
    
		}
		
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_308);
    
		}
		
    stringBuffer.append(TEXT_309);
    if(globalmap_inputstream){
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    }else{
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    
		    }
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    
		}
		
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    
		if (dieOnError) {
		
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    
			}
			
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    
		}
    stringBuffer.append(TEXT_327);
    }
    return stringBuffer.toString();
  }
}
