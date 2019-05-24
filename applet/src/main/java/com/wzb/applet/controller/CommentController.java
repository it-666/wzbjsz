package com.wzb.applet.controller;

import com.wzb.applet.errorcode.ExceptionEnum;
import com.wzb.applet.model.CommentRequestModel;
import com.wzb.applet.restfulapi.ApiVersion;
import com.wzb.applet.service.CommentServer;
import com.wzb.tools.exception.ResultBO;
import com.wzb.tools.exception.ResultTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 评论
 */
@RestController
@ApiVersion(1)
@Api(description = "评论",produces = "application/json",consumes = "application/json")
@RequestMapping("/{vpi_version}")
public class CommentController {
    @Autowired
    private CommentServer commentServer;
    /**
     * 评论
     * @param commentRequestModel
     * @return
     */
    @RequestMapping(path = "/comment" , method = RequestMethod.POST)
    @ApiOperation(value = "进行评论", notes = "评论")
    public ResultBO insertComment(@PathVariable String vpi_version,@RequestBody CommentRequestModel commentRequestModel){
        commentServer.insertComment(commentRequestModel);
        return ResultTool.success();
    }
}
