package dao;

import entity.TProvinceTraffics;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.caches.redis.RedisCache;
import org.springframework.stereotype.Repository;

/**
 * (TProvinceTraffics)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-19 20:30:00
 */
@Repository
@CacheNamespace(size = 512,implementation = RedisCache.class)
public interface TProvinceTrafficsDao {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    TProvinceTraffics queryById( );
    /**
     * 统计总⾏数
     *
     * @param tProvinceTraffics 查询条件
     * @return 总⾏数
     */
    long count(TProvinceTraffics tProvinceTraffics);
    /**
     * 新增数据
     *
     * @param tProvinceTraffics 实例对象
     * @return 影响⾏数
     */
    int insert(TProvinceTraffics tProvinceTraffics);
    /**
     * 批量新增数据（MyBatis原⽣foreach⽅法）
     *
     * @param entities List<TProvinceTraffics> 实例对象列表
     * @return 影响⾏数
     */
    int insertBatch(@Param("entities") List<TProvinceTraffics> entities);
    /**
     * 批量新增或按主键更新数据（MyBatis原⽣foreach⽅法）
     *
     * @param entities List<TProvinceTraffics> 实例对象列表
     * @return 影响⾏数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会
    抛SQL语句错误的异常，请⾃⾏校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TProvinceTraffics> entities);
    /**
     * 修改数据
     *
     * @param tProvinceTraffics 实例对象
     * @return 影响⾏数
     */
    int update(TProvinceTraffics tProvinceTraffics);
    /**
     * 通过主键删除数据
     *
     * @return 影响⾏数
     */
    int deleteById( );
    @Select("select province,traffics from t_province_traffics where createtime=#{createtime}")
            public List<TProvinceTraffics> find(@Param("createtime") String createtime);
    /**
     * 查询不同的省份某个时间段使⽤的流量
     * @param b 起始时间
     * @param e 结束时间
     * @return
     */
    @Select("select province,sum(traffics) as traffics from t_province_traffics where createtime between #{b} and #{e} group by province")
            public List<TProvinceTraffics> findx(@Param("b") String b, @Param("e") String e);

}

