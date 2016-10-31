package com.seek.soft.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by baixiaobin on 16/8/4.
 */
@Controller
@RequestMapping("/api")
@Api(value = "地址管理", description = "地址管理", tags = "platform云服务")
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);


    @ResponseBody
    @RequestMapping("/v1/getList")
    @ApiOperation(value = "获取省份", notes = "获取省份", httpMethod = "GET", response = Object.class)
    public List<Object> getList() {
        LOGGER.debug("开始获取省份信息");
        return null;
    }


    @ResponseBody
    @RequestMapping("/update")
    @ApiOperation(value = "修改省份", notes = "修改省份", httpMethod = "POST")
    public void update() {

    }

}
