package com.wzb.applet.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户收藏")
public class UserCollectModel {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("文章ID")
    private Long articleId;

}
