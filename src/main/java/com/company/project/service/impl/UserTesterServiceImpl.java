package com.company.project.service.impl;

import com.company.project.dao.UserTesterMapper;
import com.company.project.model.UserTester;
import com.company.project.service.UserTesterService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019-04-09 09:43:40.
 */
@Service
@Transactional
public class UserTesterServiceImpl extends AbstractService<UserTester> implements UserTesterService {
    @Resource
    private UserTesterMapper tUserTesterMapper;

}
