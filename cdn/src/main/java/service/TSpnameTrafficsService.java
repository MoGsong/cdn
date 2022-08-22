package service;


import entity.TSpnameTraffics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TSpnameTraffics)表服务接口
 *
 * @author makejava
 * @since 2022-08-19 20:30:00
 */
public interface TSpnameTrafficsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id
     * @return 实例对象
     */
    TSpnameTraffics queryById(int id);

    /**
     * 分页查询
     *
     * @param tSpnameTraffics 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TSpnameTraffics> queryByPage(TSpnameTraffics tSpnameTraffics, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tSpnameTraffics 实例对象
     * @return 实例对象
     */
    TSpnameTraffics insert(TSpnameTraffics tSpnameTraffics);

    /**
     * 修改数据
     *
     * @param tSpnameTraffics 实例对象
     * @return 实例对象
     */
    TSpnameTraffics update(TSpnameTraffics tSpnameTraffics);

    /**
     * 通过主键删除数据
     *
     * @param id
     * @return 是否成功
     */
    boolean deleteById(int id);

    public List<TSpnameTraffics> find(String createtime);
    public List<TSpnameTraffics> findx(String b, String e);
}
