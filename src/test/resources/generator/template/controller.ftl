package ${basePackage}.web;

import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.common.result.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with ${createBy}
 * Description:
 * @author  ${author}
 * Date: ${date}
 * Time: ${time}
 */
@ResponseResult
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public ${modelNameUpperCamel} add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ${modelNameLowerCamel};
    }

    @PostMapping("/delete")
    public void delete(@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
    }

    @PostMapping("/update")
    public ${modelNameUpperCamel} update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ${modelNameLowerCamel};
    }

    @PostMapping("/detail")
    public  ${modelNameUpperCamel} detail(@RequestParam Integer id) {
        return ${modelNameLowerCamel}Service.findById(id);
    }

    @PostMapping("/list")
    public PageInfo list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        return new PageInfo(list);
    }
}
