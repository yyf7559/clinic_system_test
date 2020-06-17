package cn.controller;

import cn.response.Response;
import cn.response.ResponseEnum;
import cn.entity.Patient;
import cn.entity.Type;
import cn.service.PatientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/come/patient")
public class PatientController {

    @Resource
    PatientService patientService;
    @GetMapping("/findPatient")
    public Response findPatient(@RequestParam(value = "id",required = false) Integer id){
        List<Patient> list = patientService.findPatient(id);
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询患者出错啦");
    }
    @GetMapping("/findType")
    public Response findType(){
        List<Type> list = patientService.findType();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询诊断类型出错啦");
    }
}
