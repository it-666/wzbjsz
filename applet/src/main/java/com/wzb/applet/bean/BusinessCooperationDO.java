package com.wzb.applet.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 商务合作
 */
@Data
public class BusinessCooperationDO {

    private Long id;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private LocalDateTime issueTime;

}
