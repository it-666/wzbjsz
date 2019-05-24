package com.wzb.applet.id;

import com.wzb.tools.sequence.SequenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * 程序ID生成
 */
@Configuration
public class IdGenerator {

    private static final String SEQUENCE_NAME = "USER_SET";
    @Autowired
    private SequenceManager sequenceManager;
    public long getNextId(){
        return sequenceManager.nextId(SEQUENCE_NAME);
    }
    public String getNextStringId(){
        return sequenceManager.nextStringId(SEQUENCE_NAME);
    }
}
