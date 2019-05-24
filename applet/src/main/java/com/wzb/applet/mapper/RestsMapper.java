package com.wzb.applet.mapper;

import com.wzb.applet.bean.OpinionFeedbackDO;
import com.wzb.applet.model.BusinessCooperationModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

/**
 * 反馈与商务合作
 */
@Mapper
public interface RestsMapper {
    /**
     * 商务合作
     * @return
     */
    BusinessCooperationModel getBusinessCooperation();
    /**
     * 反馈
     * @param userId
     * @param content
     * @param issueTime
     * @return
     */
    int insertOpinionFeedback(OpinionFeedbackDO opinionFeedbackDO);
}
