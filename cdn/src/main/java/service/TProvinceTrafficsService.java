package service;

import entity.TProvinceTraffics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TProvinceTraffics)表服务接口
 *
 * @author makejava
 * @since 2022-08-19 20:30:00
 */
public interface TProvinceTrafficsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id
     * @return 实例对象
     */
    TProvinceTraffics queryById(int id);

    /**
     * 分页查询
     *
     * @param tProvinceTraffics 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TProvinceTraffics> queryByPage(TProvinceTraffics tProvinceTraffics, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tProvinceTraffics 实例对象
     * @return 实例对象
     */
    TProvinceTraffics insert(TProvinceTraffics tProvinceTraffics);

    /**
     * 修改数据
     *
     * @param tProvinceTraffics 实例对象
     * @return 实例对象
     */
    TProvinceTraffics update(TProvinceTraffics tProvinceTraffics);

    /**
     * 通过主键删除数据
     *
     * @param id
     * @return 是否成功
     */
    boolean deleteById(int id);

    public List<TProvinceTraffics> find(String createtime);

    public List<TProvinceTraffics> findx(String b, String e);
}
