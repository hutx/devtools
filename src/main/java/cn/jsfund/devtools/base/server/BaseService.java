//package cn.jsfund.devtools.base.server;
//
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageInfo;
//
//import java.util.List;
//
///**
// * Created by hutx on 16:47 2018/11/21
// */
//public interface BaseService<T> {
//
//    /**
//     * 通用存储方法
//     *
//     * @param entity
//     * @return
//     * @throws Exception
//     */
//    T insert(T entity) throws Exception;
//
//    /**
//     * @param entity
//     * @return
//     * @throws Exception
//     */
//    T insertSelective(T entity) throws Exception;
//
//    List<T> insertSelectiveBacth(List<T> entity) throws Exception;
//
//    /**
//     * 通用修改方法
//     *
//     * @param entity
//     * @return
//     * @throws Exception
//     */
//    T updateByPrimaryKey(T entity) throws Exception;
//
//    T updateByPrimaryKeySelective(T entity) throws Exception;
//
//    T delete(T entity) throws Exception;
//
//    int bacthDelete(List<T> entity) throws Exception;
//
//
//    /**
//     * 通用查询方法
//     *
//     * @param entity
//     * @return
//     * @throws Exception
//     */
//    PageInfo<T> queryByPage(Page<T> page, T entity) throws Exception;
//
//    /**
//     * 通用list方法
//     *
//     * @param entity
//     * @return
//     * @throws Exception
//     */
//    List list(T entity) throws Exception;
//
//    /**
//     * 通用list方法
//     * 只返回一条数据
//     *
//     * @param entity
//     * @return
//     * @throws Exception
//     */
//    T listOne(T entity) throws Exception;
//
//}
