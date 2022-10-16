package com.chen.sequence;

import com.chen.sequence.bean.SequenceBean;
import com.chen.sequence.generate.CycRedisGenerate;
import com.chen.sequence.utils.CommonUtils;
import com.chen.sequence.utils.TemplateUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    static SequenceBean sequenceBean = new SequenceBean();

    static {
        try {
            Properties properties = new Properties();
            // 读取 sequence.properties 中的内容
            InputStream in = CommonUtils.readResourceFile("sequence.properties");
            // 将所读取的内容加载到配置中
            properties.load(in);
            sequenceBean.setSequenceEngine(properties.getProperty("sequenceEngine"));
            sequenceBean.setSequenceType(properties.getProperty("sequenceType"));
            sequenceBean.setKeyName(properties.getProperty("keyName"));
            sequenceBean.setSeLength(Integer.parseInt(properties.getProperty("seLength")));
            sequenceBean.setDelTime(Long.parseLong(properties.getProperty("delTime")));
            sequenceBean.setKeyPrefix(properties.getProperty("keyPrefix"));
            sequenceBean.setEndText(Long.valueOf(properties.getProperty("endText")));
            sequenceBean.setBeginText(Long.valueOf(properties.getProperty("beginText")));
            sequenceBean.setTemplate(properties.getProperty("template"));
            sequenceBean.setFillText(Integer.parseInt(properties.getProperty("fillText")));
            sequenceBean.setIntervalNum(Integer.parseInt(properties.getProperty("intervalNum")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main( String[] args )
    {
        CycRedisGenerate cycRedisGenerate = new CycRedisGenerate();
        TemplateUtils templateUtils = new TemplateUtils();
        System.out.println(templateUtils.setTemplate(sequenceBean));


        // System.out.println(cycRedisGenerate.getRedisSequence(sequenceBean));

    }
}
