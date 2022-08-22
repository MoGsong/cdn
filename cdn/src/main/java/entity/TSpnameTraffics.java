package entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (TSpnameTraffics)实体类
 *
 * @author makejava
 * @since 2022-08-19 20:30:00
 */
@Component
public class TSpnameTraffics implements Serializable {
    private static final long serialVersionUID = -78095788653086691L;
    
    private String spname;
    
    private String traffics;
    
    private String createtime;


    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
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

    public TSpnameTraffics() {
    }

    public TSpnameTraffics(String spname, String traffics, String createtime) {
        this.spname = spname;
        this.traffics = traffics;
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "TSpnameTraffics{" +
                "spname='" + spname + '\'' +
                ", traffics='" + traffics + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }

}

