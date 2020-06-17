package cn.config;

import cn.response.Response;
import cn.response.ResponseEnum;
import org.springframework.stereotype.Component;

@Component
public class DataCallBck implements FeignDataApi {
    @Override
    public Response getAdvice() {
        return new Response(ResponseEnum.ERROR).setResponseBody("getAdvice 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response getDisease() {
        return new Response(ResponseEnum.ERROR).setResponseBody("getDisease 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findEmployee(Integer departmentId) {
        return new Response(ResponseEnum.ERROR).setResponseBody("findEmployee 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findDepartment() {
        return new Response(ResponseEnum.ERROR).setResponseBody("findDepartment 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findModel(Integer typeId, String permissions, String number, Integer pageNum, Integer pageSize) {
        return new Response(ResponseEnum.ERROR).setResponseBody("findModel 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findAddPrice() {
        return new Response(ResponseEnum.ERROR).setResponseBody("findAddPrice 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findPrescriptionType() {
        return new Response(ResponseEnum.ERROR).setResponseBody("findPrescriptionType 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findPatient(Integer id) {
        return new Response(ResponseEnum.ERROR).setResponseBody("findPatient 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findType() {
        return new Response(ResponseEnum.ERROR).setResponseBody("findType 服务暂时不可访问,请稍后再试！");
    }
}
