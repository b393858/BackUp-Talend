package org.talend.designer.codegen.translators.internet.maprstreams;

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

public class TMapRStreamsOutputEndJava
{
  protected static String nl;
  public static synchronized TMapRStreamsOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMapRStreamsOutputEndJava result = new TMapRStreamsOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "long ";
  protected final String TEXT_3 = "_startCheckingTime = System.nanoTime();" + NL + "" + NL + "while (tos_count_";
  protected final String TEXT_4 = " > rev_cnt_";
  protected final String TEXT_5 = ".get() &&" + NL + "\tjava.util.concurrent.TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - ";
  protected final String TEXT_6 = "_startCheckingTime) < EXCEPTION_CATCH_TIMEOUT_";
  protected final String TEXT_7 = ");" + NL + "\t" + NL + "for (Exception e : exceptions_";
  protected final String TEXT_8 = ") {" + NL + "\tthrow e;" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

//%cid%_kafkaProducer.close();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
