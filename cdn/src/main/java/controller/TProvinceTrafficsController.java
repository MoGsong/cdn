package controller;

import entity.TProvinceTraffics;
import org.springframework.stereotype.Controller;
import service.TProvinceTrafficsService;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (TProvinceTraffics)表控制层
 *
 * @author makejava
 * @since 2022-08-19 20:30:00
 */
@Controller
public class TProvinceTrafficsController {

    @Resource
    private TProvinceTrafficsService tProvinceTrafficsService;

    @RequestMapping(value = "/tprovincetraffics",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list(HttpServletRequest request){
        String b = request.getParameter("b");
        String e = request.getParameter("e");
        List<TProvinceTraffics> pts = new ArrayList<>();
        if(e!=null && !e.equals("") && !e.equals("null")){
            pts = tProvinceTrafficsService.findx(b,e);
        }else{
            pts = tProvinceTrafficsService.find(b);
        }
        Map<String,Object> msg = new HashMap<>();
        msg.put("code",20000);
        msg.put("data",pts);
        return msg;
    }

}

