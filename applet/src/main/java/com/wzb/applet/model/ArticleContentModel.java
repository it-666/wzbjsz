package com.wzb.applet.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("文章")
public class ArticleContentModel {
    @ApiModelProperty("表id")
    private Long id;

    @ApiModelProperty("标题")
    private String articleHeadline;

    @ApiModelProperty("内容")
    private String articleContent;

    @ApiModelProperty("文章 标签名称")
    private String lableName;

    @ApiModelProperty("标签id")
    private Long articleLabelId;

    @ApiModelProperty("发布时间")
    private LocalDateTime articleIssueTime;

    @ApiModelProperty("发布人昵称")
    private String issueNickname;

    @ApiModelProperty("发布人id")
    private Long issueUserId;

    @ApiModelProperty("浏览数")
    private Long readNumber;

    @ApiModelProperty("评论数")
    private Integer evaluateNumber;

}
