package cn.jsfund.devtools.service.impl;

import cn.jsfund.devtools.base.server.impl.BaseServiceImpl;
import cn.jsfund.devtools.mapper.dao.java.UserMapper;
import cn.jsfund.devtools.model.User;
import cn.jsfund.devtools.service.UserService;
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
