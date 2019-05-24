package com.wzb.applet.controller;

import com.wzb.applet.bean.BusinessCooperationDO;
import com.wzb.applet.errorcode.ExceptionEnum;
import com.wzb.applet.model.BusinessCooperationModel;
import com.wzb.applet.model.FeedbackModel;
import com.wzb.applet.restfulapi.ApiVersion;
import com.wzb.applet.service.RestsService;
import com.wzb.tools.exception.ResultBO;
import com.wzb.tools.exception.ResultTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * 反馈与商务合作
 */
@RestController
@ApiVersion(1)
@Api(description = "反馈与商务合作",produces = "application/json",consumes = "application/json")
@RequestMapping("/{vpi_version}/rests")
public class RestsController {
    @Autowired
    private RestsService restsService;
    /**
     * 商务合作
     * @return
     */
    @RequestMapping(path = "/businessCooperation",method = RequestMethod.GET)
    @ApiOperation(value = "商务合作", notes = "商务合作")
    public ResultBO getBusinessCooperation(@PathVariable String vpi_version){
        BusinessCooperationModel businessCooperationModel =  restsService.getBusinessCooperation();
        if(Objects.isNull(businessCooperationModel)){
            return ResultTool.error(ExceptionEnum.EXCEPTION_ERR);
        }
        return ResultTool.success(businessCooperationModel);
    }

    /**
     * 反馈
     * @param feedbackModel
     */
    @RequestMapping(path = "/coupleBack",method = RequestMethod.POST)
    @ApiOperation(value = "反馈", notes = "反馈")
    public ResultBO coupleBack(@PathVariable String vpi_version,@RequestBody FeedbackModel feedbackModel){
        restsService.coupleBack(feedbackModel);
        return ResultTool.success();
    }
}
