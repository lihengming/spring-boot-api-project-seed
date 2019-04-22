package com.company.project.web;
import com.company.project.core.CustomObjectMapper;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.UserTester;
import com.company.project.service.UserTesterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019-04-09 09:43:40.
*/
@RestController
@RequestMapping("/user/tester")
public class UserTesterController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserTesterController.class);
    @Resource
    private UserTesterService userTesterService;
    @Resource
    private CustomObjectMapper objectMapper;

    @PostMapping("/add")
    public Result add(UserTester userTester) {
        userTesterService.save(userTester);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userTesterService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UserTester userTester) {
        userTesterService.update(userTester);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserTester userTester = userTesterService.findById(id);
        return ResultGenerator.genSuccessResult(userTester);
    }

    @RequestMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserTester> list = userTesterService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        LOGGER.info("返回到前端的数据=[{}]", objectMapper.toJSONString(pageInfo));
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
