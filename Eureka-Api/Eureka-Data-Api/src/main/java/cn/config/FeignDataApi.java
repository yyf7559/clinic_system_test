package cn.config;


import cn.response.Response;
import cn.response.ResponseEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.util.List;

@FeignClient(value = "eureka-data-8083",fallback = DataCallBck.class)
public interface FeignDataApi {
    @GetMapping("/come/advice/getAdvice")
    public Response getAdvice();

    @GetMapping("/come/disease/getDisease")
    public Response getDisease();

    @GetMapping("/come/employee/findEmployee")
    public Response findEmployee(@RequestParam(value = "departmentId",required = false) Integer departmentId);
    @GetMapping("/come/employee/findDepartment")
    public Response findDepartment();

    @GetMapping("/come/getModel")
    public Response findModel(
            @RequestParam(value = "typeId",required = false) Integer typeId,
            @RequestParam(value = "permissions",required = false)String permissions,
            @RequestParam(value = "number",required = false)String number,
            @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize);
    @GetMapping("/come/findAddPrice")
    public Response findAddPrice();
    @GetMapping("/come/findPrescriptionType")
    public Response findPrescriptionType();


    @GetMapping("/come/patient/findPatient")
    public Response findPatient(@RequestParam(value = "id",required = false)Integer id);
    @GetMapping("/come/patient/findType")
    public Response findType();
}
