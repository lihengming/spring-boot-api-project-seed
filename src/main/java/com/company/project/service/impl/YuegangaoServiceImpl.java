package com.company.project.service.impl;

import com.company.project.dao.YuegangaoMapper;
import com.company.project.model.Yuegangao;
import com.company.project.service.YuegangaoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/07/30.
 */
@Service
@Transactional
public class YuegangaoServiceImpl extends AbstractService<Yuegangao> implements YuegangaoService {
    @Resource
    private YuegangaoMapper yuegangaoMapper;

}
