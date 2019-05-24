package com.wzb.applet.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("评论")
public class CommentRequestModel {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("文章ID")
    private Long articleId;

    @ApiModelProperty("级别（1:一级（就是第一次评价）2:回复）")
    private Integer rank;

    @ApiModelProperty("父级ID")
    private Long replyId;

    @ApiModelProperty("评论内容")
    private String content;
}
