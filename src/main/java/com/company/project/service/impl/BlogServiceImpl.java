package com.company.project.service.impl;

import com.company.project.dao.BlogMapper;
import com.company.project.model.Blog;
import com.company.project.service.BlogService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/03/13.
 */
@Service
@Transactional
public class BlogServiceImpl extends AbstractService<Blog> implements BlogService {
    @Resource
    private BlogMapper blogMapper;

}
