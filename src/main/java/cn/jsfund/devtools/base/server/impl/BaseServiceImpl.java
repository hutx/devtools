package cn.jsfund.devtools.base.server.impl;

import cn.jsfund.devtools.base.server.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by hutx on 15:24 2018/11/21
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {


    public T insert(T entity) throws Exception {
        getRealMapper().insert(entity);
        return entity;
    }

    public T insertSelective(T entity) throws Exception {
        getRealMapper().insertSelective(entity);
        return entity;
    }

    public T delete(T entity) throws Exception {
        getRealMapper().deleteByPrimaryKey(entity);
        return entity;
    }

    public int delete(Integer [] ids) throws Exception {
        int i=0;
        for (Integer id : ids) {
            i= getRealMapper().deleteByPrimaryKey(id);
        }
        return i;
    }

    public T updateByPrimaryKey(T entity) throws Exception {
        getRealMapper().updateByPrimaryKey(entity);
        return entity;
    }

    public T updateByPrimaryKeySelective(T entity) throws Exception {
        getRealMapper().updateByPrimaryKeySelective(entity);
        return entity;
    }

    /**
     * @param page
     * @param entity
     * @return
     * @throws Exception
     */
    public PageInfo<T> queryByPage(Page<T> page, T entity) throws Exception {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<T> list = getRealMapper().select(entity);
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public List<T> list(T entity) throws Exception {
        return getRealMapper().select(entity);
    }

    public T listOne(T entity) throws Exception {
        return getRealMapper().selectOne(entity);
    }

    private Mapper<T> getRealMapper() throws Exception {
        Mapper<T> mapper = getMapper();
        if (null == mapper) {
            throw new Exception("mapper未定义");
        } else {
            return mapper;
        }
    }

    protected Mapper<T> getMapper() {
        return null;
    }
}
