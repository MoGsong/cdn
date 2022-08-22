package controller;


import entity.TSpnameTraffics;
import org.springframework.stereotype.Controller;
import service.TSpnameTrafficsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (TSpnameTraffics)表控制层
 *
 * @author makejava
 * @since 2022-08-19 20:30:00
 */
@Controller
public class TSpnameTrafficsController {
    /**
     * 服务对象
     */
    @Resource
    private TSpnameTrafficsService tSpnameTrafficsService;

    @RequestMapping(value = "/tspnametraffics",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list(HttpServletRequest request){
        String b = request.getParameter("b");
        String e = request.getParameter("e");
        List<TSpnameTraffics> spnts = new ArrayList<>();
        if(e!=null && !e.equals("") && !e.equals("null")){
            spnts = tSpnameTrafficsService.findx(b,e);
        }else{
            spnts = tSpnameTrafficsService.find(b);
        }
        Map<String,Object> msg = new HashMap<>();
        msg.put("code",20000);
        msg.put("data",spnts);
        return msg;
    }


}

