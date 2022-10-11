package com.chen.sequence;

import com.chen.sequence.bean.SequenceBean;
import com.chen.sequence.generate.CycRedisGenerate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CycRedisGenerate cycRedisGenerate = new CycRedisGenerate();

        SequenceBean sequenceBean = new SequenceBean();
        sequenceBean.setSequenceType("CUSTOM");
        sequenceBean.setKeyPrefix("bb");
        sequenceBean.setDelTime(-1);
        sequenceBean.setBeginText(5);
        sequenceBean.setSeLength(3);

        System.out.println(cycRedisGenerate.getRedisSequence(sequenceBean));
    }
}
