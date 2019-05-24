package com.wzb.applet.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 评论
 */
@Data
public class CommentDO {

    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 文章id
     */
    private Long articleId;
    /**
     * 级别（1:一级（就是第一次评价）2:回复）
     */
    private Integer rank;
    /**
     * 回复id（填写评论的id，如果是第一次则为0)
     */
    private Long replyId;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private LocalDateTime issueTime;
}
