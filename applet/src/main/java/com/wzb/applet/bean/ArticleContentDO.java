package com.wzb.applet.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文章
 */
@Data
public class ArticleContentDO {

    private Long id;
    /**
     * 文章标题
     */
    private String articleHeadline;
    /**
     * 文章内容
     */
    private String articleContent;
    /**
     * 文章标签
     */
    private Long articleLabelId;
    /**
     * 发布时间
     */
    private LocalDateTime articleIssueTime;
    /**
     * 发布人
     */
    private Long issueUserId;
    /**
     * 文章修改时间
     */
    private LocalDateTime articleAmendTime;
    /**
     * 修改人
     */
    private Long amendUserId;
    /**
     * 删除状态0：未删除，1:删除
     */
    private Integer delStatus;
    /**
     * 阅读数
     */
    private Long readNumber;
    /**
     * 是否公开 0：公开1：未公开
     */
    private Integer openOr;
}
