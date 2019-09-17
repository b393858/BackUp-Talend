package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPigLoadEndJava
{
  protected static String nl;
  public static synchronized TPigLoadEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigLoadEndJava result = new TPigLoadEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tbw_";
  protected final String TEXT_2 = ".close();" + NL + "\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_3 = ".setLibJars(libjars_";
  protected final String TEXT_4 = ".toString().substring(0, libjars_";
  protected final String TEXT_5 = ".length()-1));" + NL + "\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_6 = ".callWS(instance_";
  protected final String TEXT_7 = ".sendFiles());" + NL + "\t\tint exitCode_";
  protected final String TEXT_8 = " = instance_";
  protected final String TEXT_9 = ".execute();" + NL + "\t\tif(exitCode_";
  protected final String TEXT_10 = " > 0) {" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tthrow new Exception(\"The Pig job failed. Please read the logs for more details\");";
  protected final String TEXT_12 = NL + "\t\t\t\tSystem.err.println(\"The Pig job failed. Please read the logs for more details\");";
  protected final String TEXT_13 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_14 = " - The Pig job failed. Please read the logs for more details\");";
  protected final String TEXT_15 = NL + "\t\t}";
  protected final String TEXT_16 = NL + "\t\torg.talend.bigdata.launcher.qubole.QubolePigClient.Job job_";
  protected final String TEXT_17 = " =" + NL + "\t\t\tnew org.talend.bigdata.launcher.qubole.QubolePigClient.Job(statements_";
  protected final String TEXT_18 = ".toString());" + NL + "\t\tjob_";
  protected final String TEXT_19 = ".setJobName(\"";
  protected final String TEXT_20 = "\");" + NL + "\t\tjob_";
  protected final String TEXT_21 = ".setUserAgent(routines.system.Constant.getUserAgent(\"";
  protected final String TEXT_22 = "\"));" + NL + "\t\t";
  protected final String TEXT_23 = NL + "\t\t\tjob_";
  protected final String TEXT_24 = ".setClusterLabel(";
  protected final String TEXT_25 = ");" + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\tString execution_result_";
  protected final String TEXT_27 = " = quboleClient_";
  protected final String TEXT_28 = ".execute(job_";
  protected final String TEXT_29 = ");" + NL + "\t\t";
  protected final String TEXT_30 = NL + "\t} catch (Exception e) {";
  protected final String TEXT_31 = NL + "\t\t\tSystem.err.println(e.getMessage() +\"\\nCaused by: \\n\\t\"+ e.getCause());";
  protected final String TEXT_32 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_33 = " - \" + e.getMessage());";
  protected final String TEXT_34 = NL + "\t\t\tthrow(e);";
  protected final String TEXT_35 = NL + "\t}" + NL;
  protected final String TEXT_36 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	String pigVersion = ElementParameterParser.getValue(node, "__PIG_VERSION__");
	
	final String studioVersion = org.talend.commons.utils.VersionUtils.getDisplayVersion();

    boolean isLocal = "true".equals(ElementParameterParser.getValue(node, "__LOCAL__"));

	org.talend.hadoop.distribution.component.PigComponent pigDistrib = null;
	if(!isLocal) {
    	try {
    		pigDistrib = (org.talend.hadoop.distribution.component.PigComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, pigVersion);
    	} catch (java.lang.Exception e) {
    		e.printStackTrace();
    		return "";
    	}
    }
	
	boolean isExecutedThroughWebHCat = !isLocal && pigDistrib != null && pigDistrib.isExecutedThroughWebHCat();
	boolean isQuboleDistribution = !isLocal && pigDistrib != null && pigDistrib.isQuboleDistribution();
	String quboleClusterLabel = "";
	if (isQuboleDistribution && ElementParameterParser.getBooleanValue(node, "__QUBOLE_CLUSTER__")) {
		quboleClusterLabel = ElementParameterParser.getValue(node, "__QUBOLE_CLUSTER_LABEL__");
	}

	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	boolean inMain = true;

	if(node.getIncomingConnections()!=null && node.getIncomingConnections().size()>0) {
		INode loadNode = node.getDesignSubjobStartNode();
		inMain = loadNode.isSubtreeStart();
	}
	
	
	if(inMain && isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			if(dieOnError) {

    stringBuffer.append(TEXT_11);
    
			} else {

    stringBuffer.append(TEXT_12);
    
				if(isLog4jEnabled) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
				}
			}

    stringBuffer.append(TEXT_15);
    
	}
	
	if (inMain && isQuboleDistribution) {
	
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(studioVersion);
    stringBuffer.append(TEXT_22);
     if (quboleClusterLabel != null) { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(quboleClusterLabel);
    stringBuffer.append(TEXT_25);
     } 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
	}

    stringBuffer.append(TEXT_30);
    
		if(!dieOnError) {

    stringBuffer.append(TEXT_31);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
			}
		} else {

    stringBuffer.append(TEXT_34);
    
		}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
