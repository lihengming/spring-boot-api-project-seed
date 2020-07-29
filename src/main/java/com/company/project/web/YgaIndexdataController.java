package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.YgaIndexdata;
import com.company.project.service.YgaIndexdataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2020/07/27.
*/
@RestController
@RequestMapping("/ygaIndexdata")
public class YgaIndexdataController {
    @Resource
    private YgaIndexdataService ygaIndexdataService;

    @PostMapping("/add")
    public Result add(YgaIndexdata ygaIndexdata) {
        ygaIndexdataService.save(ygaIndexdata);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        ygaIndexdataService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(YgaIndexdata ygaIndexdata) {
        ygaIndexdataService.update(ygaIndexdata);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        YgaIndexdata ygaIndexdata = ygaIndexdataService.findById(id);
        return ResultGenerator.genSuccessResult(ygaIndexdata);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<YgaIndexdata> list = ygaIndexdataService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
