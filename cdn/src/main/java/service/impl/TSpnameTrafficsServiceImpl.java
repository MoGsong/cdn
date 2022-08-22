package service.impl;

import dao.TSpnameTrafficsDao;
import entity.TSpnameTraffics;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import service.TSpnameTrafficsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TSpnameTraffics)表服务实现类
 *
 * @author makejava
 * @since 2022-08-19 20:30:00
 */
@Service
public class TSpnameTrafficsServiceImpl implements TSpnameTrafficsService {
    @Resource
    private TSpnameTrafficsDao tSpnameTrafficsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id
     * @return 实例对象
     */
    @Override
    public TSpnameTraffics queryById(int id) {
        return this.tSpnameTrafficsDao.queryById();
    }

    /**
     * 分页查询
     *
     * @param tSpnameTraffics 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TSpnameTraffics> queryByPage(TSpnameTraffics tSpnameTraffics, PageRequest pageRequest) {
        long total = this.tSpnameTrafficsDao.count(tSpnameTraffics);
        return new PageImpl<>(this.tSpnameTrafficsDao.queryAllByLimit(tSpnameTraffics, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tSpnameTraffics 实例对象
     * @return 实例对象
     */
    @Override
    public TSpnameTraffics insert(TSpnameTraffics tSpnameTraffics) {
        this.tSpnameTrafficsDao.insert(tSpnameTraffics);
        return tSpnameTraffics;
    }

    /**
     * 修改数据
     *
     * @param tSpnameTraffics 实例对象
     * @return 实例对象
     */
    @Override
    public TSpnameTraffics update(TSpnameTraffics tSpnameTraffics) {
        this.tSpnameTrafficsDao.update(tSpnameTraffics);
        return tSpnameTraffics;
    }
    /**
     * 通过主键删除数据
     *
     * @param id
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.tSpnameTrafficsDao.deleteById() > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TSpnameTraffics> find(String createtime) {
        return tSpnameTrafficsDao.find(createtime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TSpnameTraffics> findx(String b, String e) {
        return tSpnameTrafficsDao.findx(b,e);
    }
}
