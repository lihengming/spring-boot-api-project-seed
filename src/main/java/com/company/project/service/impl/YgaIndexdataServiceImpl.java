package com.company.project.service.impl;

import com.company.project.dao.YgaIndexdataMapper;
import com.company.project.model.YgaIndexdata;
import com.company.project.service.YgaIndexdataService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/07/27.
 */
@Service
@Transactional
public class YgaIndexdataServiceImpl extends AbstractService<YgaIndexdata> implements YgaIndexdataService {
    @Resource
    private YgaIndexdataMapper ygaIndexdataMapper;

}
