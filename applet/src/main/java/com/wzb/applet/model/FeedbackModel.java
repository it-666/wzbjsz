package com.wzb.applet.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("反馈")
public class FeedbackModel {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("反馈内容")
    private String content;
}
