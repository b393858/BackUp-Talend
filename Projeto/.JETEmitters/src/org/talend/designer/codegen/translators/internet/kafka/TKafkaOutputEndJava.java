package org.talend.designer.codegen.translators.internet.kafka;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TKafkaOutputEndJava
{
  protected static String nl;
  public static synchronized TKafkaOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaOutputEndJava result = new TKafkaOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "final long ";
  protected final String TEXT_3 = "_startCheckingTime = System.nanoTime();" + NL + "while (";
  protected final String TEXT_4 = "_counter_send > ";
  protected final String TEXT_5 = "_counter_rev.intValue() && java.util.concurrent.TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - ";
  protected final String TEXT_6 = "_startCheckingTime) < ";
  protected final String TEXT_7 = "_EXCEPTION_CATCH_TIMEOUT);" + NL + "if (";
  protected final String TEXT_8 = "_counter_send <= ";
  protected final String TEXT_9 = "_counter_rev.intValue()) {" + NL + "\tif (!";
  protected final String TEXT_10 = "_producerExceptions.isEmpty()) {" + NL + "\t\tException e = ";
  protected final String TEXT_11 = "_producerExceptions.iterator().next();" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t\t\tthrow e;" + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\t\tif (e instanceof org.apache.kafka.common.errors.AuthenticationException || e instanceof org.apache.kafka.common.errors.AuthorizationException || e instanceof org.apache.kafka.common.errors.UnknownServerException || e instanceof org.apache.kafka.common.errors.UnsupportedVersionException) {" + NL + "\t\t\t\tthrow e;" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_14 = "\t" + NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_15 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_17 = NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

final boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

//%cid%_kafkaProducer.close();

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		if (dieOnError) {
		
    stringBuffer.append(TEXT_12);
    
		} else {
		// if DIE_ON_ERROR unchecked, the process stops when there is AuthenticationException, AuthorizationException, UnknownServerException or UnsupportedVersionException
		
    stringBuffer.append(TEXT_13);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    
		}
		
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
