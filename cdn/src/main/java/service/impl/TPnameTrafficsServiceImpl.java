package service.impl;

import dao.TPnameTrafficsDao;
import entity.TPnameTraffics;
import org.apache.ibatis.annotations.Options;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.TPnameTrafficsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TPnameTraffics)表服务实现类
 *
 * @author makejava
 * @since 2022-08-19 20:29:58
 */
@Service
@Transactional
public class TPnameTrafficsServiceImpl implements TPnameTrafficsService {
    @Resource
    private TPnameTrafficsDao tPnameTrafficsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id
     * @return 实例对象
     */
    @Override
    public TPnameTraffics queryById(int id) {
        return this.tPnameTrafficsDao.queryById();
    }

    @Override
    public Page<TPnameTraffics> queryByPage(TPnameTraffics tPnameTraffics, PageRequest pageRequest) {
        return null;
    }


    /**
     * 新增数据
     *
     * @param tPnameTraffics 实例对象
     * @return 实例对象
     */
    @Override
    public TPnameTraffics insert(TPnameTraffics tPnameTraffics) {
        this.tPnameTrafficsDao.insert(tPnameTraffics);
        return tPnameTraffics;
    }

    /**
     * 修改数据
     *
     * @param tPnameTraffics 实例对象
     * @return 实例对象
     */
    @Override
    public TPnameTraffics update(TPnameTraffics tPnameTraffics) {
        this.tPnameTrafficsDao.update(tPnameTraffics);
        return tPnameTraffics;
    }

    /**
     * 通过主键删除数据
     *
     * @param id
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.tPnameTrafficsDao.deleteById() > 0;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TPnameTraffics> find(String createtime) {
        return tPnameTrafficsDao.find(createtime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TPnameTraffics> findx(String b, String e) {
        return tPnameTrafficsDao.findx(b, e);
    }
}
