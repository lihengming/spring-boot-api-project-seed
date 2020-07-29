package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Auxiliaries;
import com.company.project.service.AuxiliariesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/auxiliaries")
public class AuxiliariesController {
    @Resource
    private AuxiliariesService auxiliariesService;

    @PostMapping("/add")
    public Result add(Auxiliaries auxiliaries) {
        auxiliariesService.save(auxiliaries);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        auxiliariesService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Auxiliaries auxiliaries) {
        auxiliariesService.update(auxiliaries);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Auxiliaries auxiliaries = auxiliariesService.findById(id);
        return ResultGenerator.genSuccessResult(auxiliaries);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Auxiliaries> list = auxiliariesService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    
    @GetMapping("/findByCon")
    public Result findByCon(@RequestParam(defaultValue = "0") Integer page,@RequestParam String con, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        
        Condition c=new Condition(Auxiliaries.class);
        Criteria cri=c.createCriteria();
        cri.andLike("sort", con);
        List<Auxiliaries> list = (List<Auxiliaries>) auxiliariesService.findByCondition(c);
        
        
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
