package com.wzb.applet.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wzb.applet.errorcode.ExceptionEnum;
import com.wzb.applet.model.ArticleByIdModel;
import com.wzb.applet.model.ArticleContentModel;
import com.wzb.applet.restfulapi.ApiVersion;
import com.wzb.applet.service.ArticleContentService;
import com.wzb.tools.exception.PageBO;
import com.wzb.tools.exception.PageTool;
import com.wzb.tools.exception.ResultBO;
import com.wzb.tools.exception.ResultTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 文章
 */
@RestController
@ApiVersion(1)
@RequestMapping("/{vpi_version}")
@Api(description = "文章",produces = "application/json",consumes = "application/json")
public class ArticleContentController {
    @Autowired
    private ArticleContentService articleContentService;
    @RequestMapping(path = "/article/{page}/{size}",method = RequestMethod.GET)
    @ApiOperation(value = "分页查询文章", notes = "查询文章")
    public PageBO listArticleContent(@PathVariable String vpi_version, @PathVariable Integer page, @PathVariable Integer size, @RequestParam(required = false)String searchContent){
        Page<ArticleContentModel> maps = PageHelper.startPage(page,size);
        List<ArticleContentModel> list = articleContentService.listArticleContent(searchContent);
        if (Objects.isNull(list)){
            return PageTool.error(ExceptionEnum.EXCEPTION_ERR);
        }
        return PageTool.success((int)maps.getTotal(),list);
    }
    @RequestMapping(path = "/article/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "查看单个文章", notes = "查看单个文章")
    public ResultBO getArticle(@PathVariable String vpi_version, @PathVariable Long id){
        ArticleByIdModel articleByIdModel = articleContentService.getArticle(id);
        if (Objects.isNull(articleByIdModel)){
            return ResultTool.error(ExceptionEnum.EXCEPTION_ERR);
        }
        return ResultTool.success(articleByIdModel);
    }

}
