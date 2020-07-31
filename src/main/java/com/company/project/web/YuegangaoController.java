package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Auxiliaries;
import com.company.project.model.Yuegangao;
import com.company.project.service.YuegangaoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2020/07/30.
*/
@RestController
@RequestMapping("/yuegangao")
public class YuegangaoController {
    @Resource
    private YuegangaoService yuegangaoService;

    @PostMapping("/add")
    public Result add(Yuegangao yuegangao) {
        yuegangaoService.save(yuegangao);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        yuegangaoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Yuegangao yuegangao) {
        yuegangaoService.update(yuegangao);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Yuegangao yuegangao = yuegangaoService.findById(id);
        return ResultGenerator.genSuccessResult(yuegangao);
    }
    
    
    @PostMapping("/findByDate")
    public Result findByDate(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam String date) {

	    Condition c=new Condition(Yuegangao.class);
	    Criteria cri=c.createCriteria();
	    cri.andLike("finishtime","%"+ date+"%");
	    List<Yuegangao> list = (List<Yuegangao>) yuegangaoService.findByCondition(c);
	    PageInfo pageInfo = new PageInfo(list);
	    return ResultGenerator.genSuccessResult(pageInfo);
    }
    
    
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Yuegangao> list = yuegangaoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
