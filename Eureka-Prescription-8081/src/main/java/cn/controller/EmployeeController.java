package cn.controller;

import cn.config.FeignDataApi;
import cn.http.HttpClientHelper;
import cn.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "员工查询")
@RequestMapping("/call/employee")
public class EmployeeController {
    @Resource
    FeignDataApi feignDataApi;
    String employeeUrl="http://localhost:8083/come/employee/";
    @GetMapping("/findEmployee")
    @ApiOperation(value = "根据科室查询员工信息",notes = "")
    public Response findEmployee(@RequestParam(value = "departmentId",required = false) Integer departmentId){
        return  feignDataApi.findEmployee(departmentId);
    }
    @GetMapping("/findDepartment")
    @ApiOperation(value = "查询所有科室",notes = "")
    public Response findDepartment(){
        return feignDataApi.findDepartment();
    }

}
