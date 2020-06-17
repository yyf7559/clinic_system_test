package cn.controller;

import cn.response.Response;
import cn.response.ResponseEnum;
import cn.entity.Check;
import cn.entity.CheckType;
import cn.service.CheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/come/check")
public class CheckController {
    @Resource
    CheckService checkService;
    @GetMapping("/findCheckByTypeId")
    public Response findCheckByTypeId(@RequestParam(value = "checkTypeId",required = false)Integer checkTypeId,
                                      @RequestParam(value = "checkCode",required = false)String checkCode,
                                      @RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "3")Integer limit){
        PageHelper.startPage(page,limit);
        List<Check> list = checkService.findCheckByTypeId(checkTypeId,checkCode);
        Map<String,Object> map=new HashMap<>();
            PageInfo<Check>pageInfo = new PageInfo<>(list);
            map.put("data",pageInfo.getList());
            map.put("code","0");
            map.put("count",pageInfo.getTotal());
            return new Response(ResponseEnum.SUCCESS).setResponseBody(map);
    }
    @GetMapping("/findCheck")
    public Response findCheck(){
        List<Check> list = checkService.findCheck();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody(list);
    }
    @GetMapping("/findCheckType")
    public Response findCheckType(){
        List<CheckType> list = checkService.findCheckType();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("根据检查项目类型出错啦");
    }
}
