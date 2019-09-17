package org.talend.designer.codegen.translators.data_quality;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;

public class TSchemaComplianceCheckBeginJava
{
  protected static String nl;
  public static synchronized TSchemaComplianceCheckBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSchemaComplianceCheckBeginJava result = new TSchemaComplianceCheckBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    try {" + NL + "        if(";
  protected final String TEXT_2 = NL + "        ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " != null";
  protected final String TEXT_5 = NL + "        && (!\"\".equals(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = "))";
  protected final String TEXT_8 = NL + "        ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " != null";
  protected final String TEXT_11 = NL + "        true";
  protected final String TEXT_12 = NL + "        ) {";
  protected final String TEXT_13 = NL + "            if(!(\"true\".equals(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ") || \"false\".equals(";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = "))){" + NL + "                throw new java.lang.Exception(\"Wrong Boolean type!\");" + NL + "            }";
  protected final String TEXT_18 = NL + "            if(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ".toCharArray().length != 1){" + NL + "                throw new java.lang.Exception(\"Wrong Character type!\");" + NL + "            }";
  protected final String TEXT_21 = NL + "            ";
  protected final String TEXT_22 = " tester_";
  protected final String TEXT_23 = " = new ";
  protected final String TEXT_24 = "(";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "            ";
  protected final String TEXT_28 = " tester_";
  protected final String TEXT_29 = " = new ";
  protected final String TEXT_30 = "();";
  protected final String TEXT_31 = NL + "            ";
  protected final String TEXT_32 = " tester_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = ".valueOf(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "        }" + NL + "    } catch(java.lang.Exception e) {" + NL + "        ifPassedThrough = false;" + NL + "        errorCodeThrough += 2;" + NL + "        errorMessageThrough += \"|wrong type\";" + NL + "    }";
  protected final String TEXT_38 = NL + "    if (";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " != null){";
  protected final String TEXT_41 = NL + "        handleBigdecimalPrecision((";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ").toPlainString(), ";
  protected final String TEXT_44 = ", ";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL + "        handleBigdecimalPrecision(String.valueOf(";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = "), ";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "        ifPassedThrough = ifPassedThrough?ifPassed:false;" + NL + "        errorCodeThrough += errorCode;" + NL + "        errorMessageThrough += errorMessage;" + NL + "    }";
  protected final String TEXT_52 = NL + "    if (";
  protected final String TEXT_53 = NL + "    ";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = " != null";
  protected final String TEXT_56 = NL + "    && (!\"\".equals(";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = "))";
  protected final String TEXT_59 = NL + "    ";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = " != null";
  protected final String TEXT_62 = NL + "    true";
  protected final String TEXT_63 = NL + "    ) {";
  protected final String TEXT_64 = NL + "        if( ";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = ".length() > ";
  protected final String TEXT_67 = " )";
  protected final String TEXT_68 = NL + "            ";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = " = ";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = ".substring(0, ";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "        tmpContentThrough = String.valueOf(";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "        tmpContentThrough = ";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = ".toString();";
  protected final String TEXT_80 = NL + "        if (tmpContentThrough.length() > ";
  protected final String TEXT_81 = ")";
  protected final String TEXT_82 = NL + "            ";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = ".substring(0, ";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "        if (";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = ".length() > ";
  protected final String TEXT_91 = ") {" + NL + "            ifPassedThrough = false;" + NL + "            errorCodeThrough += 8;" + NL + "            errorMessageThrough += \"|exceed max length\";" + NL + "        }";
  protected final String TEXT_92 = NL + "        tmpContentThrough = String.valueOf(";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "        tmpContentThrough = ";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = ".toString();";
  protected final String TEXT_98 = NL + NL + "        if (tmpContentThrough.length() > ";
  protected final String TEXT_99 = ") {" + NL + "            ifPassedThrough = false;" + NL + "            errorCodeThrough += 8;" + NL + "            errorMessageThrough += \"|exceed max length\";" + NL + "        }";
  protected final String TEXT_100 = NL + "    }";
  protected final String TEXT_101 = NL + "    ifPassedThrough = false;" + NL + "    errorCodeThrough += 2;" + NL + "    errorMessageThrough += \"|Date format not defined\";";
  protected final String TEXT_102 = NL + "    try{" + NL + "        if (";
  protected final String TEXT_103 = NL + "        ";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " != null";
  protected final String TEXT_106 = NL + "        && (!\"\".equals(";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = "))";
  protected final String TEXT_109 = NL + "        ";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = " != null";
  protected final String TEXT_112 = NL + "        true";
  protected final String TEXT_113 = NL + "        ){";
  protected final String TEXT_114 = NL + "                        if (!TalendDate.isDate((";
  protected final String TEXT_115 = ".";
  protected final String TEXT_116 = ").toString(), ";
  protected final String TEXT_117 = ",";
  protected final String TEXT_118 = "true";
  protected final String TEXT_119 = "false";
  protected final String TEXT_120 = "))" + NL + "                            throw new IllegalArgumentException(\"Data format not matches\");";
  protected final String TEXT_121 = NL + "                        FastDateParser.getInstance(";
  protected final String TEXT_122 = ", false).parse(";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = ");";
  protected final String TEXT_125 = NL + "                        if(!TalendDate.isDateStrict((";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = ").toString(), ";
  protected final String TEXT_128 = "))" + NL + "                            throw new IllegalArgumentException(\"Data format not matches\");";
  protected final String TEXT_129 = NL + "        }" + NL + "    } catch(java.lang.Exception e){" + NL + "        ifPassedThrough = false;" + NL + "        errorCodeThrough += 2;" + NL + "        errorMessageThrough += \"|wrong DATE pattern or wrong DATE data\";" + NL + "    }";
  protected final String TEXT_130 = NL + "    ifPassedThrough = false;" + NL + "    errorCodeThrough += 2;" + NL + "    errorMessageThrough += \"|wrong DATE pattern or wrong DATE data\";";
  protected final String TEXT_131 = NL + "    ifPassedThrough = false;" + NL + "    errorCodeThrough += 2;" + NL + "    errorMessageThrough += \"|The TYPE of inputting data is error. (one of OBJECT, STRING, DATE)\";";
  protected final String TEXT_132 = NL + "    // validate nullable (empty as null)" + NL + "    if ((";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " == null) || (\"\".equals(";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = "))) {";
  protected final String TEXT_137 = NL + "    // validate nullable" + NL + "    if (";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " == null) {";
  protected final String TEXT_140 = NL + "    // validate nullable (empty as null)" + NL + "    if ((";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " == null) || (\"\".equals(";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = "))) {";
  protected final String TEXT_145 = NL + "    // validate nullable (empty as null)" + NL + "    if ((";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = " == null) || (\"\".equals(";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = "))) {";
  protected final String TEXT_150 = NL + "    // validate nullable" + NL + "    if (";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = " == null) {";
  protected final String TEXT_153 = NL + "        ifPassedThrough = false;" + NL + "        errorCodeThrough += 4;" + NL + "        errorMessageThrough += \"|empty or null\";" + NL + "    }";
  protected final String TEXT_154 = NL + "    class RowSetValueUtil_";
  protected final String TEXT_155 = " {" + NL + "" + NL + "        boolean ifPassedThrough = true;" + NL + "        int errorCodeThrough = 0;" + NL + "        String errorMessageThrough = \"\";" + NL + "        int resultErrorCodeThrough = 0;" + NL + "        String resultErrorMessageThrough = \"\";" + NL + "        String tmpContentThrough = null;" + NL + "" + NL + "        boolean ifPassed = true;" + NL + "        int errorCode = 0;" + NL + "        String errorMessage = \"\";" + NL + "" + NL + "        void handleBigdecimalPrecision(String data, int iPrecision, int maxLength){" + NL + "            //number of digits before the decimal point(ignoring frontend zeroes)" + NL + "            int len1 = 0;" + NL + "            int len2 = 0;" + NL + "            ifPassed = true;" + NL + "            errorCode = 0;" + NL + "            errorMessage = \"\";" + NL + "            if(data.startsWith(\"-\")){" + NL + "                data = data.substring(1);" + NL + "            }" + NL + "            data = org.apache.commons.lang.StringUtils.stripStart(data, \"0\");" + NL + "" + NL + "            if(data.indexOf(\".\") >= 0){" + NL + "                len1 = data.indexOf(\".\");" + NL + "                data = org.apache.commons.lang.StringUtils.stripEnd(data, \"0\");" + NL + "                len2 = data.length() - (len1 + 1);" + NL + "            }else{" + NL + "                len1 = data.length();" + NL + "            }" + NL + "" + NL + "            if (iPrecision < len2) {" + NL + "                ifPassed = false;" + NL + "                errorCode += 8;" + NL + "                errorMessage += \"|precision Non-matches\";" + NL + "            } else if (maxLength < len1 + iPrecision) {" + NL + "                ifPassed = false;" + NL + "                errorCode += 8;" + NL + "                errorMessage += \"|invalid Length setting is unsuitable for Precision\";" + NL + "            }" + NL + "        }" + NL + "" + NL + "        int handleErrorCode(int errorCode, int resultErrorCode){" + NL + "            if (errorCode > 0) {" + NL + "                if (resultErrorCode > 0) {" + NL + "                    resultErrorCode = 16;" + NL + "                } else {" + NL + "                    resultErrorCode = errorCode;" + NL + "                }" + NL + "            }" + NL + "            return resultErrorCode;" + NL + "        }" + NL + "" + NL + "        String handleErrorMessage(String errorMessage, String resultErrorMessage, String columnLabel){" + NL + "            if (errorMessage.length() > 0) {" + NL + "                if (resultErrorMessage.length() > 0) {" + NL + "                    resultErrorMessage += \";\"+ errorMessage.replaceFirst(\"\\\\|\", columnLabel);" + NL + "                } else {" + NL + "                    resultErrorMessage = errorMessage.replaceFirst(\"\\\\|\", columnLabel);" + NL + "                }" + NL + "            }" + NL + "            return resultErrorMessage;" + NL + "        }" + NL + "" + NL + "        void reset(){" + NL + "            ifPassedThrough = true;" + NL + "            errorCodeThrough = 0;" + NL + "            errorMessageThrough = \"\";" + NL + "            resultErrorCodeThrough = 0;" + NL + "            resultErrorMessageThrough = \"\";" + NL + "            tmpContentThrough = null;" + NL + "" + NL + "            ifPassed = true;" + NL + "            errorCode = 0;" + NL + "            errorMessage = \"\";" + NL + "        }" + NL;
  protected final String TEXT_156 = NL + "        void setRowValue_";
  protected final String TEXT_157 = "(";
  protected final String TEXT_158 = "Struct ";
  protected final String TEXT_159 = ") {";
  protected final String TEXT_160 = NL + "            resultErrorCodeThrough = handleErrorCode(errorCodeThrough,resultErrorCodeThrough);" + NL + "            errorCodeThrough = 0;" + NL + "            resultErrorMessageThrough = handleErrorMessage(errorMessageThrough,resultErrorMessageThrough,\"";
  protected final String TEXT_161 = ":\");" + NL + "            errorMessageThrough = \"\";";
  protected final String TEXT_162 = NL + "        }";
  protected final String TEXT_163 = NL + "        }";
  protected final String TEXT_164 = NL + "    }" + NL + "    RowSetValueUtil_";
  protected final String TEXT_165 = " rsvUtil_";
  protected final String TEXT_166 = " = new RowSetValueUtil_";
  protected final String TEXT_167 = "();";
  protected final String TEXT_168 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    final INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    /*in shema:*/
    List<? extends IConnection> listInConns = node.getIncomingConnections();
    String sInConnName = null;
    IConnection inConn = null;
    List<IMetadataColumn> listInColumns = null;

    if (listInConns != null && listInConns.size() > 0) {
        IConnection inConnTemp = listInConns.get(0);
        sInConnName = inConnTemp.getName();
        if(inConnTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
            inConn = inConnTemp;
            listInColumns = inConnTemp.getMetadataTable().getListColumns();
        }
    }


    /* get the schema of itself (maybe no output flow)*/
    List<IMetadataColumn> listColumsToTest = node.getMetadataList().get(0).getListColumns();

    String anotherChecked = ElementParameterParser.getValue(node, "__CHECK_ANOTHER__");
    String checkAll = ElementParameterParser.getValue(node, "__CHECK_ALL__");
    final boolean bIsTrim = "true".equals(ElementParameterParser.getValue(node, "__SUB_STRING__"));
    final boolean useFasteDateChecker = "true".equals(ElementParameterParser.getValue(node, "__FAST_DATE_CHECK__"));
    final boolean useStrictDateChecker = "true".equals(ElementParameterParser.getValue(node, "__STRICT_DATE_CHECK__"));
    final boolean emptyIsNull = "true".equals(ElementParameterParser.getValue(node, "__EMPTY_IS_NULL__"));
    final boolean allEmptyAreNull = "true".equals(ElementParameterParser.getValue(node, "__ALL_EMPTY_ARE_NULL__"));

    List<Map<String, String>> list = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__EMPTY_NULL_TABLE__");
    final List<String> listEmptyAsNull = new ArrayList<String>();
    for(Map<String, String> map : list){
        if("true".equals(map.get("EMPTY_NULL"))){
            listEmptyAsNull.add(map.get("SCHEMA_COLUMN"));
        }
    }

    class SchemaChecker { //CLASS SCHEMACHECKER START
        boolean anotherChecked = "true".equals(ElementParameterParser.getValue(node, "__CHECK_ANOTHER__"));
        boolean ignoreTimeZone = "true".equals(ElementParameterParser.getValue(node, "__IGNORE_TIMEZONE__"));

        public void  testDataType(boolean _bNullable, String _sInConnName, IMetadataColumn metadataColumn, String typeSelected, String cid) { //METHOD_TESTDATATYPE START
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, metadataColumn.isNullable());
            String colName = metadataColumn.getLabel();

            if (javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.STRING) { //CONDITION_00100 START

    stringBuffer.append(TEXT_1);
    
                if (_bNullable){ //CONDITION_00110 START

    stringBuffer.append(TEXT_2);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_4);
    
                    if(allEmptyAreNull || listEmptyAsNull.contains(metadataColumn.getLabel())) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_7);
    
                    }
                }else if(!isPrimitive){ //CONDITION_00110 ELSE IF

    stringBuffer.append(TEXT_8);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_10);
    
                }else{ //CONDITION_00110 ELSE

    stringBuffer.append(TEXT_11);
    
                } //CONDITION_00110 STOP

    stringBuffer.append(TEXT_12);
    
                if(typeSelected.equals("Boolean") ) { //CONDITION_00120 START

    stringBuffer.append(TEXT_13);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_17);
    
                } else if(typeSelected.equals("Character")) { //CONDITION_00120 ELSE IF

    stringBuffer.append(TEXT_18);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_20);
    
                } else if(typeSelected.equals("BigDecimal")) { //CONDITION_00120 ELSE IF

    stringBuffer.append(TEXT_21);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_26);
    
                } else if(typeSelected.equals("Object")){ //CONDITION_00120 ELSE IF

    stringBuffer.append(TEXT_27);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_30);
    
                } else { //CONDITION_00120 ELSE

    stringBuffer.append(TEXT_31);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_36);
    
                } //CONDITION_00120 STOP

    stringBuffer.append(TEXT_37);
    
            } //CONDITION_00100 STOP
        } //METHOD_TESTDATATYPE STOP

        public void testPrecision(int _maxLength, int iPrecision, String _sInConnName, IMetadataColumn metadataColumn, String typeSelected, String cid) { //METHOD_TESTPRECISION START
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
            String colName = metadataColumn.getLabel();
            boolean needCheck = false;
            if(anotherChecked) {
                if("BigDecimal".equalsIgnoreCase(typeSelected)) {
                    needCheck = true;
                }
            } else if (javaType == JavaTypesManager.BIGDECIMAL) {
                /* NULLable, in case input value is Null, do nothing...
                Non-NULLable,
                    (1) in case input value is Non-null, go into...;
                    (2) in case input value is Null, do nothing and warning by NULL-CHECKER.
                */
                /*
                    if precision value is not empty or Null, checking "Precision" at first, if passed then checking "Length"
                */
                needCheck = true;
            }
            if(needCheck) { //CONDITION_00130 START

    stringBuffer.append(TEXT_38);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_40);
    
                if(javaType == JavaTypesManager.BIGDECIMAL) { //CONDITION_00131 START

    stringBuffer.append(TEXT_41);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(iPrecision);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(_maxLength);
    stringBuffer.append(TEXT_45);
    
                } else {  //CONDITION_00131 ELSE

    stringBuffer.append(TEXT_46);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(iPrecision);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(_maxLength);
    stringBuffer.append(TEXT_50);
    
                }  //CONDITION_00131 STOP

    stringBuffer.append(TEXT_51);
    
            } //CONDITION_00130 STOP
        } //METHOD_TESTPRECISION STOP

        public void testDataLength(boolean _bNullable, String _sInConnName,IMetadataColumn inColumn, IMetadataColumn metadataColumn, int maxLength, String cid) { //METHOD_TESTDATALENGTH START
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, metadataColumn.isNullable());
            boolean bIsStringType = (javaType == JavaTypesManager.STRING), bIsIntegerType = (javaType == JavaTypesManager.INTEGER);
            String colName = inColumn.getLabel();

            if (maxLength > 0 && ( bIsStringType || bIsIntegerType )){ //CONDITION_00140 START

    stringBuffer.append(TEXT_52);
    
                if (_bNullable){ //CONDITION_00141 START

    stringBuffer.append(TEXT_53);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_55);
    
                    if(allEmptyAreNull || listEmptyAsNull.contains(metadataColumn.getLabel())) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_58);
    
                    }
                }else if (!isPrimitive){ //CONDITION_00141 ELSE IF

    stringBuffer.append(TEXT_59);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_61);
    
                }else { //CONDITION_00141 ELSE

    stringBuffer.append(TEXT_62);
    
                } //CONDITION_00141 STOP

    stringBuffer.append(TEXT_63);
    
                if ( bIsTrim ){ //CONDITION_00142 START
                    if (bIsStringType) { //CONDITION_001421 START

    stringBuffer.append(TEXT_64);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_73);
    
                    } else if ( bIsIntegerType ){//CONDITION_001421 ELSE IF
                        String generatedType = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
                        if ("int".equals(generatedType)) { //CONDITION_0014211 START

    stringBuffer.append(TEXT_74);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_76);
    
                        } else{ //CONDITION_0014211 ELSE

    stringBuffer.append(TEXT_77);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_79);
    
                        } //CONDITION_0014211 STOP

    stringBuffer.append(TEXT_80);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_87);
    
                    } //CONDITION_001421 STOP
                } else{ //CONDITION_00142 ELSE
                    if (bIsStringType) { //CONDITION_001422 START

    stringBuffer.append(TEXT_88);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_91);
    
                    } else if (bIsIntegerType) { //CONDITION_001422 ELSE IF
                        String generatedType = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
                        if ("int".equals(generatedType)) { //CONDITION_0014221 START

    stringBuffer.append(TEXT_92);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_94);
    
                        } else { //CONDITION_0014221 ELSE

    stringBuffer.append(TEXT_95);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_97);
    
                        } //CONDITION_0014221 STOP

    stringBuffer.append(TEXT_98);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_99);
    
                    }//CONDITION_001422 STOP
                } //CONDITION_00142 STOP

    stringBuffer.append(TEXT_100);
    
            } //CONDITION_00140 STOP
        } //METHOD_TESTDATALENGTH STOP

        public void testDate(boolean _bNullable, String _sInConnName, IMetadataColumn metadataColumn, String pattern, String cid) { //METHOD_TESTDATE START
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, metadataColumn.isNullable());
            String colName = metadataColumn.getLabel();

            if ("".equals(pattern)){ //CONDITION_00150 START

    stringBuffer.append(TEXT_101);
    
            } else { //CONDITION_00150 ELSE
                if (javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.STRING) { //CONDITION_00151 START

    stringBuffer.append(TEXT_102);
    
                    if (_bNullable){ //CONDITION_001511 START

    stringBuffer.append(TEXT_103);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_105);
    
                        if(allEmptyAreNull || listEmptyAsNull.contains(metadataColumn.getLabel())) {

    stringBuffer.append(TEXT_106);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_108);
    
                        }
                    }else if (!isPrimitive){ //CONDITION_001511 ELSE IF

    stringBuffer.append(TEXT_109);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_111);
    
                    }else { //CONDITION_001511 ELSE

    stringBuffer.append(TEXT_112);
    
                    } //CONDITION_001511 STOP

    stringBuffer.append(TEXT_113);
    
                    if (!useFasteDateChecker && !useStrictDateChecker) { //CONDITION_001512 START

    stringBuffer.append(TEXT_114);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_117);
    if(ignoreTimeZone){
    stringBuffer.append(TEXT_118);
    }else{
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    
                    } else if (useFasteDateChecker){ //CONDITION_001512 ELSE

    stringBuffer.append(TEXT_121);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_124);
    
                    } else {//CONDITION_001512 STOP

    stringBuffer.append(TEXT_125);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_128);
    
                    }

    stringBuffer.append(TEXT_129);
    
                // date type need check also (some inputting data not legal, beacause original data is not suite with pattern and has be converted)
                } else if (javaType == JavaTypesManager.DATE){ //CONDITION_00151 ELSE IF
                    if (!metadataColumn.getPattern().equals(pattern)){ //CONDITION_001513 START

    stringBuffer.append(TEXT_130);
    
                    } //CONDITION_001513 STOP
                } else{ //CONDITION_00151 ELSE

    stringBuffer.append(TEXT_131);
    
                } //CONDITION_00151 STOP
            } //CONDITION_00150 STOP
        } //METHOD_TESTDATE STOP

        public void testNull(String _sInConnName, IMetadataColumn metadataColumn, String cid){ //METHOD_TESTNULL START
            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(metadataColumn.getTalendType(), metadataColumn.isNullable());
            if (!isPrimitive){ //CONDITION_00160 START
                if(emptyIsNull && !allEmptyAreNull){ //CONDITION_001601 START - for the migration task
                    if(listEmptyAsNull.contains(metadataColumn.getLabel())){ //CONDITION_0016011 START

    stringBuffer.append(TEXT_132);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_136);
    
                    }else{ //CONDITION_0016011 ELSE

    stringBuffer.append(TEXT_137);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_139);
    
                    } //CONDITION_0016011 STOP
                }else{ //CONDITION_001601 ELSE
                    if(allEmptyAreNull){ //CONDITION_0016012 START

    stringBuffer.append(TEXT_140);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_144);
    
                    }else if(listEmptyAsNull.contains(metadataColumn.getLabel())){ //CONDITION_0016012 ELSE IF

    stringBuffer.append(TEXT_145);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_149);
    
                    }else{ //CONDITION_0016012 ELSE

    stringBuffer.append(TEXT_150);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_152);
    
                    } //CONDITION_0016012 STOP
                } //CONDITION_001601 STOP

    stringBuffer.append(TEXT_153);
    
            } //CONDITION_00160 STOP
        } //METHOD_TESTNULL STOP
    } //CLASS SCHEMACHECKER STOP

    SchemaChecker checker = new SchemaChecker();
    List<Map<String, String>> listCheckedColumns = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__CHECKCOLS__");
    boolean bNeedReferSchema = false;

    if ("true".equals(anotherChecked)){
        if (node.getMetadataFromConnector("OTHER") != null)
            listColumsToTest = node.getMetadataFromConnector("OTHER").getListColumns();
    } else if ("true".equals(checkAll)){
        ;
    } else{
        bNeedReferSchema = true;
    }


    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    
    for (IMetadataColumn inColumn : listInColumns) { //LOOP_00100 START
        int iInColIndex = listInColumns.indexOf(inColumn);
        if(iInColIndex % 100 == 0){ //CONDITION_00170 START

    stringBuffer.append(TEXT_156);
    stringBuffer.append((iInColIndex/100) );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn) );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(sInConnName );
    stringBuffer.append(TEXT_159);
    
        } //CONDITION_00170 STOP
        // when using another schema, it's size may less than listInColumns
        if (iInColIndex >= listColumsToTest.size()){
            break;
        }

        Object pre_iPrecision = null;
        String sInColumnName = inColumn.getLabel(), sTestColName = null, sTestColType = null, sTestColPattern = null;
        boolean bNullable = true, bMaxLenLimited = true;
        /* use setting of tSchemaComplianceCheck schema (it is synchronize with inputting schema, but length value can be different) */
        Object pre_maxLength = listColumsToTest.get(iInColIndex).getLength();
        int maxLength = (pre_maxLength == null) ? 0 : Integer.parseInt(pre_maxLength.toString());
        IMetadataColumn schemaColumn = null;

        if (bNeedReferSchema) {
            Map<String, String> checkedColumn = listCheckedColumns.get(iInColIndex);
            sTestColName = checkedColumn.get("SCHEMA_COLUMN");
            sTestColType = checkedColumn.get("SELECTED_TYPE");
            sTestColPattern = checkedColumn.get("DATEPATTERN");
            bNullable = "true".equals(checkedColumn.get("NULLABLE"));
            bMaxLenLimited = "true".equals(checkedColumn.get("MAX_LENGTH"));
        } else{
            schemaColumn = listColumsToTest.get(iInColIndex);
            sTestColName = schemaColumn.getLabel();
            sTestColType = JavaTypesManager.getTypeToGenerate(schemaColumn.getTalendType(), true);
            sTestColPattern = schemaColumn.getPattern();
            bNullable = schemaColumn.isNullable();
            pre_iPrecision = schemaColumn.getPrecision();
        }

        // NULL checking
        if (!bNullable){
            checker.testNull(sInConnName, inColumn, cid);
        }

        // type checking
        if (sTestColType != null){
            if (sTestColType.indexOf("Date") >= 0){
                checker.testDate(bNullable, sInConnName, inColumn, sTestColPattern, cid);
            } else{
                checker.testDataType(bNullable, sInConnName, inColumn, sTestColType, cid);
            }
        }

        // length checking
        if (bMaxLenLimited){
            checker.testDataLength(bNullable, sInConnName,inColumn, "true".equals(anotherChecked)?schemaColumn:inColumn, maxLength, cid);
        }

        // precision checking
        if (pre_iPrecision != null){
            checker.testPrecision(maxLength, Integer.parseInt(pre_iPrecision.toString()), sInConnName, inColumn, sTestColType, cid);
        }

    stringBuffer.append(TEXT_160);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_161);
    
        if((iInColIndex + 1) % 100 == 0){ //CONDITION_00171 START

    stringBuffer.append(TEXT_162);
    
        } //CONDITION_00171 STOP
    } //LOOP_00100 STOP
    if(listInColumns.size() > 0 && listInColumns.size() % 100 > 0){ //CONDITION_00180 START

    stringBuffer.append(TEXT_163);
    
    } //CONDITION_00180 STOP

    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(TEXT_168);
    return stringBuffer.toString();
  }
}
