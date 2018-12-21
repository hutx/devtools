package com.iquantex.devtools.service.impl;

import com.iquantex.devtools.base.server.impl.BaseServiceImpl;
import com.iquantex.devtools.mapper.dao.java.UserMapper;
import com.iquantex.devtools.model.User;
import com.iquantex.devtools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by hutx on 10:21 2018/11/26
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper mapper;

    public Mapper<User> getMapper() {
        return mapper;
    }
}
