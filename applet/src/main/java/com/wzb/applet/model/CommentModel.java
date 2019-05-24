package com.wzb.applet.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("评论")
public class CommentModel {

    @ApiModelProperty("表ID")
    private Long id;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("评论用户昵称")
    private String userNickname;

    @ApiModelProperty("用户头像地址")
    private String headUrl;

    @ApiModelProperty("级别（1:一级（就是第一次评价）2:回复）")
    private Long rank;

    @ApiModelProperty("父级ID")
    private Long replyId;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("评论时间")
    private LocalDateTime issueTime;

}
