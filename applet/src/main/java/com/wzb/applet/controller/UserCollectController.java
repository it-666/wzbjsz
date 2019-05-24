package com.wzb.applet.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wzb.applet.errorcode.ExceptionEnum;
import com.wzb.applet.model.ArticleByIdModel;
import com.wzb.applet.model.ArticleContentModel;
import com.wzb.applet.model.UserCollectModel;
import com.wzb.applet.restfulapi.ApiVersion;
import com.wzb.applet.service.UserCollectService;
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
 * 用户收藏
 */
@RestController
@ApiVersion(1)
@RequestMapping("/{vpi_version}/user")
@Api(description = "用户收藏",produces = "application/json",consumes = "application/json")
public class UserCollectController {
    @Autowired
    private UserCollectService userCollectService;

    /**
     * 收藏
     * @param userCollectModel
     */
    @RequestMapping(path = "/collect",method = RequestMethod.POST)
    @ApiOperation(value = "用户收藏", notes = "收藏")
    public ResultBO insertUserCollect(@PathVariable String vpi_version,@RequestBody UserCollectModel userCollectModel){
        userCollectService.insertUserCollect(userCollectModel);
        return ResultTool.success();
    }

    /**
     * 查看收藏
     * @param userId
     * @param page
     * @param size
     * @param searchContent
     * @return
     */
    @RequestMapping(path = "/collects/{userId}/{page}/{size}",method = RequestMethod.GET)
    @ApiOperation(value = "分页查询收藏文章", notes = "查询收藏文章")
    public PageBO listArticleContent(@PathVariable String vpi_version, @PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer size, @RequestParam(required = false)String searchContent){
        Page<ArticleContentModel> maps = PageHelper.startPage(page,size);
        List<ArticleContentModel> articleModel = userCollectService.listArticleContent(userId,searchContent);
        if (Objects.isNull(articleModel)){
            return PageTool.error(ExceptionEnum.EXCEPTION_ERR);
        }
        return PageTool.success((int)maps.getTotal(),articleModel);
    }

    /**
     * 查看单个收藏文章
     * @param userId
     * @param id
     * @return
     */
    @RequestMapping(path = "/collect/{userId}/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "查看单个收藏文章", notes = "查看单个收藏文章")
    public ResultBO getArticle(@PathVariable String vpi_version, @PathVariable Long userId, @PathVariable Long id){
        ArticleByIdModel articleByIdModel = userCollectService.getArticle(userId,id);
        if(Objects.isNull(articleByIdModel)){
            return ResultTool.error(ExceptionEnum.EXCEPTION_ERR);
        }
        return ResultTool.success(articleByIdModel);
    }

}
