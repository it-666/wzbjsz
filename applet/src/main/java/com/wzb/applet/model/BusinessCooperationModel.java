package com.wzb.applet.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 商务合作
 */
@Data
@ApiModel("商务合作")
public class BusinessCooperationModel {

    @ApiModelProperty("表ID")
    private Long id;
    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;
    /**
     * 发布时间
     */
    @ApiModelProperty("发布时间")
    private LocalDateTime issueTime;

}
