package com.wzb.applet.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 反馈
 */
@Data
public class OpinionFeedbackDO {

    private Long id;
    /**
     * 反馈用户id
     */
    private Long userId;
    /**
     * 反馈内容
     */
    private String content;
    /**
     * 发布时间
     */
    private LocalDateTime issueTime;

}
