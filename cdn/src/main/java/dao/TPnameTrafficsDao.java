package dao;


import entity.TPnameTraffics;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.caches.redis.RedisCache;
import org.springframework.stereotype.Repository;

/**
 * (TPnameTraffics)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-19 20:29:55
 */
@Repository
@CacheNamespace(size = 512,implementation = RedisCache.class)
public interface TPnameTrafficsDao {

    /**
     * 通过ID查询单条数据
     * @return 实例对象
     */
    TPnameTraffics queryById();
    /**
     * 统计总⾏数
     * @param tPnameTraffics 查询条件
     * @return 总⾏数
     */
    long count(TPnameTraffics tPnameTraffics);
    /**
     * 新增数据
     * @param tPnameTraffics 实例对象
     * @return 影响⾏数
     */
    int insert(TPnameTraffics tPnameTraffics);
    /**
     * 批量新增数据（MyBatis原⽣foreach⽅法）
     * @param entities List<TPnameTraffics> 实例对象列表
     * @return 影响⾏数
     */
    int insertBatch(@Param("entities") List<TPnameTraffics> entities);
    /**
     * 批量新增或按主键更新数据（MyBatis原⽣foreach⽅法）
     * @param entities List<TPnameTraffics> 实例对象列表
     * @return 影响⾏数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会
    抛SQL语句错误的异常，请⾃⾏校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TPnameTraffics> entities);
    /**
     * 修改数据
     * @param tPnameTraffics 实例对象
     * @return 影响⾏数
     */
    int update(TPnameTraffics tPnameTraffics);
    /**
     * 通过主键删除数据
     * @return 影响⾏数
     */
    int deleteById( );
    /**
     * 查询不同产品每天使⽤的流量
     */
    @Select("select pname,traffics from t_pname_traffics where createtime=#{createtime}")
    public List<TPnameTraffics> find(@Param("createtime") String createtime);
    /**
     * 查询不同产品某个时间段的使⽤的流量
     * @param b 起始时间
     * @param e 结束时间
     * @return
     */
    @Select("select pname,sum(traffics) as traffics from t_pname_traffics where createtime between #{b} and #{e} group by pname")
    public List<TPnameTraffics> findx(@Param("b") String b, @Param("e") String e);

}

