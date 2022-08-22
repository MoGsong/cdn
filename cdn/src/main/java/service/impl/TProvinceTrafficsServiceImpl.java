package service.impl;


import dao.TProvinceTrafficsDao;
import entity.TProvinceTraffics;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import service.TProvinceTrafficsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TProvinceTraffics)表服务实现类
 *
 * @author makejava
 * @since 2022-08-19 20:30:00
 */
@Service
@Transactional
public class TProvinceTrafficsServiceImpl implements TProvinceTrafficsService {
    @Resource
    private TProvinceTrafficsDao tProvinceTrafficsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id
     * @return 实例对象
     */
    @Override
    public TProvinceTraffics queryById(int id) {
        return this.tProvinceTrafficsDao.queryById();
    }

    @Override
    public Page<TProvinceTraffics> queryByPage(TProvinceTraffics tProvinceTraffics, PageRequest pageRequest) {
        return null;
    }


    /**
     * 新增数据
     *
     * @param tProvinceTraffics 实例对象
     * @return 实例对象
     */
    @Override
    public TProvinceTraffics insert(TProvinceTraffics tProvinceTraffics) {
        this.tProvinceTrafficsDao.insert(tProvinceTraffics);
        return tProvinceTraffics;
    }

    /**
     * 修改数据
     *
     * @param tProvinceTraffics 实例对象
     * @return 实例对象
     */
    @Override
    public TProvinceTraffics update(TProvinceTraffics tProvinceTraffics) {
        this.tProvinceTrafficsDao.update(tProvinceTraffics);
        return tProvinceTraffics;
    }

    /**
     * 通过主键删除数据
     *
     * @param id
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.tProvinceTrafficsDao.deleteById() > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TProvinceTraffics> find(String createtime) {
        return tProvinceTrafficsDao.find(createtime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TProvinceTraffics> findx(String b, String e) {
        return tProvinceTrafficsDao.findx(b,e);
    }
}
