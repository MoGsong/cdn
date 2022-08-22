package service;

import entity.TPnameTraffics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TPnameTraffics)表服务接口
 *
 * @author makejava
 * @since 2022-08-19 20:29:57
 */
public interface TPnameTrafficsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id
     * @return 实例对象
     */
    TPnameTraffics queryById(int id);

    /**
     * 分页查询
     *
     * @param tPnameTraffics 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TPnameTraffics> queryByPage(TPnameTraffics tPnameTraffics, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tPnameTraffics 实例对象
     * @return 实例对象
     */
    TPnameTraffics insert(TPnameTraffics tPnameTraffics);

    /**
     * 修改数据
     *
     * @param tPnameTraffics 实例对象
     * @return 实例对象
     */
    TPnameTraffics update(TPnameTraffics tPnameTraffics);

    /**
     * 通过主键删除数据
     *
     * @param id
     * @return 是否成功
     */
    boolean deleteById(int id);

    public List<TPnameTraffics> find(String createtime);

    public List<TPnameTraffics> findx(String b, String e);

}
