package com.wzb.applet.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 查看单个文章
 */
@Data
@ApiModel("查看单个文章及所有评论")
public class ArticleByIdModel {
    /**
     * 对应的评论
     */
    @ApiModelProperty("所有评论")
    private List<CommentModel> listComment;
    /**
     * 文章内容
     */
    @ApiModelProperty("文章")
    private ArticleContentModel articleContent;

}
