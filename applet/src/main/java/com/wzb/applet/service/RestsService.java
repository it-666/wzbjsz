package com.wzb.applet.service;

import com.wzb.applet.bean.BusinessCooperationDO;
import com.wzb.applet.bean.OpinionFeedbackDO;
import com.wzb.applet.id.IdGenerator;
import com.wzb.applet.mapper.RestsMapper;
import com.wzb.applet.model.BusinessCooperationModel;
import com.wzb.applet.model.FeedbackModel;
import com.wzb.applet.tools.DateTimeTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 商务合作
 */
@Service
public class RestsService {
    @Autowired
    private RestsMapper restsMapper;
    @Autowired
    private IdGenerator idGenerator;
    /**
     * 商务合作
     * @return
     */
    public BusinessCooperationModel getBusinessCooperation(){
        return restsMapper.getBusinessCooperation();
    }

    /**
     * 反馈
     * @param feedbackModel
     */
    public int coupleBack(FeedbackModel feedbackModel){
        if (Objects.isNull(feedbackModel)){
            return 0;
        }
        OpinionFeedbackDO feedbackDO = new OpinionFeedbackDO();
        Long id = idGenerator.getNextId();
        feedbackDO.setId(id);
        feedbackDO.setUserId(feedbackModel.getUserId());
        feedbackDO.setContent(feedbackModel.getContent());
        feedbackDO.setIssueTime(DateTimeTool.millisToLocalDateTime(System.currentTimeMillis()));
        return restsMapper.insertOpinionFeedback(feedbackDO);
    }

}
