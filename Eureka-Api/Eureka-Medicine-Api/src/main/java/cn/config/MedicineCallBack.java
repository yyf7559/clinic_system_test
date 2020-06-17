package cn.config;

import cn.response.Response;
import cn.response.ResponseEnum;
import org.springframework.stereotype.Component;

@Component
public class MedicineCallBack implements FeignMedicineApi {

    @Override
    public Response findMedicineType(Integer pid) {
        return new Response(ResponseEnum.ERROR).setResponseBody("findMedicineType 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findMedicine(Integer typeId, String code, Integer page, Integer limit) {
        return new Response(ResponseEnum.ERROR).setResponseBody("findMedicine 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findMedicineByPid(Integer pid, Integer pageNo, Integer pageSize) {
        return new Response(ResponseEnum.ERROR).setResponseBody("findMedicineByPid 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findCheckByTypeId(Integer checkTypeId, String checkCode, Integer page, Integer limit) {
        return new Response(ResponseEnum.ERROR).setResponseBody("findCheckByTypeId 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findCheck() {
        return new Response(ResponseEnum.ERROR).setResponseBody("findCheck 服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response findCheckType() {
        return new Response(ResponseEnum.ERROR).setResponseBody("findCheckType服务暂时不可访问,请稍后再试！");
    }

    @Override
    public Response updateMedicineStock(int id, int stock) {
        return new Response(ResponseEnum.ERROR).setResponseBody("findCheckType服务暂时不可访问,请稍后再试！");
    }
}
