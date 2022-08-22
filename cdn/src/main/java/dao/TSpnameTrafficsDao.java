package dao;


import entity.TSpnameTraffics;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.caches.redis.RedisCache;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (TSpnameTraffics)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-19 20:30:00
 */
@Repository
@CacheNamespace(size = 512,implementation = RedisCache.class)
public interface TSpnameTrafficsDao {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    TSpnameTraffics queryById( );

    /**
     * 查询指定行数据
     *
     * @param tSpnameTraffics 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TSpnameTraffics> queryAllByLimit(TSpnameTraffics tSpnameTraffics, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tSpnameTraffics 查询条件
     * @return 总行数
     */
    long count(TSpnameTraffics tSpnameTraffics);

    /**
     * 新增数据
     *
     * @param tSpnameTraffics 实例对象
     * @return 影响行数
     */
    int insert(TSpnameTraffics tSpnameTraffics);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TSpnameTraffics> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TSpnameTraffics> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TSpnameTraffics> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TSpnameTraffics> entities);

    /**
     * 修改数据
     *
     * @param tSpnameTraffics 实例对象
     * @return 影响行数
     */
    int update(TSpnameTraffics tSpnameTraffics);

    /**
     * 通过主键删除数据
     *
     * @return 影响行数
     */
    int deleteById( );
    /**
     * 查询不同的客户每天使⽤的流量
     */
    @Select("select spname,traffics from t_spname_traffics where createtime=#{createtime}")
            public List<TSpnameTraffics> find(@Param("createtime") String createtime);
    /**
     * 询不同的客户某个时间段使⽤的流量
     ** @param b 起始时间
     *  @param e 结束时间
     *  @return
     *  */
     @Select("select spname, sum(traffics) as traffics from t_spname_traffics where createtime between #{b} and #{e} group by spname")
     public List<TSpnameTraffics> findx(@Param("b") String b, @Param("e") String e);
}

