package entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (TPnameTraffics)实体类
 *
 * @author makejava
 * @since 2022-08-19 20:29:56
 */
@Component
public class TPnameTraffics implements Serializable {
    private static final long serialVersionUID = -31198238322227531L;
    
    private String pname;
    
    private String traffics;
    
    private String createtime;


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

    public TPnameTraffics(String pname, String traffics, String createtime) {
        this.pname = pname;
        this.traffics = traffics;
        this.createtime = createtime;
    }

    public TPnameTraffics() {
    }

    @Override
    public String toString() {
        return "TPnameTraffics{" +
                "pname='" + pname + '\'' +
                ", traffics='" + traffics + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }

}

