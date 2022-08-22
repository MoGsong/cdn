package entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (TProvinceTraffics)实体类
 *
 * @author makejava
 * @since 2022-08-19 20:30:00
 */
@Component
public class TProvinceTraffics implements Serializable {
    private static final long serialVersionUID = -54814832718709774L;
    
    private String province;
    
    private String traffics;
    
    private String createtime;


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTraffics() {
        return traffics;
    }

    public void setTraffics(String traffics) {
        this.traffics = traffics;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public TProvinceTraffics() {
    }

    public TProvinceTraffics(String province, String traffics, String createtime) {
        this.province = province;
        this.traffics = traffics;
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "TProvinceTraffics{" +
                "province='" + province + '\'' +
                ", traffics='" + traffics + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}

