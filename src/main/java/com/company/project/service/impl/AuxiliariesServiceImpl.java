package com.company.project.service.impl;

import com.company.project.dao.AuxiliariesMapper;
import com.company.project.model.Auxiliaries;
import com.company.project.service.AuxiliariesService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/07/27.
 */
@Service
@Transactional
public class AuxiliariesServiceImpl extends AbstractService<Auxiliaries> implements AuxiliariesService {
    @Resource
    private AuxiliariesMapper auxiliariesMapper;

    
}

