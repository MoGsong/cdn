package controller;

import entity.TPnameTraffics;
import org.springframework.stereotype.Controller;
import service.TPnameTrafficsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (TPnameTraffics)表控制层
 *
 * @author makejava
 * @since 2022-08-19 21:07:12
 */
@Controller
public class TPnameTrafficsController {
    /**
     * 服务对象
     */
    @Resource
    private TPnameTrafficsService tPnameTrafficsService;


    @RequestMapping(value = "/tpnametraffics",method = RequestMethod.GET)
    //该注解⽤于配合jackson-databind使⽤
    @ResponseBody
    public Map<String,Object> list(HttpServletRequest request){
        String b = request.getParameter("b");
        String e = request.getParameter("e");
        List<TPnameTraffics> pnts = new ArrayList<>();
        if(e!=null && !e.equals("") && !e.equals("null")){
            pnts = tPnameTrafficsService.findx(b, e);
        }else{
            pnts = tPnameTrafficsService.find(b);
        }
        Map<String,Object> msg = new HashMap<>();
        msg.put("code",20000);
        msg.put("data",pnts);
        return msg;
    }

}

