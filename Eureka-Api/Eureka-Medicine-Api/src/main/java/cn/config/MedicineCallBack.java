package cn.config;

import cn.response.Response;
import cn.response.ResponseEnum;
import org.springframework.stereotype.Component;

@Component
public class MedicineCallBack implements FeignMedicineApi {

    @Override
    public Response findMedicineType(Integer pid) {
        return createError("findMedicineType");
    }

    @Override
    public Response findMedicine(Integer typeId, String code, Integer page, Integer limit) {
        return createError("findMedicine");
    }

    @Override
    public Response findMedicineByPid(Integer pid, Integer pageNo, Integer pageSize) {
        return createError("findMedicineByPid");
    }

    @Override
    public Response findCheckByTypeId(Integer checkTypeId, String checkCode, Integer page, Integer limit) {
        return createError("findCheckByTypeId");
    }

    @Override
    public Response findCheck() {
        return createError("findCheck");
    }

    @Override
    public Response findCheckType() {
        return createError("findCheckType");
    }

    @Override
    public Response updateMedicineStock(int id, int stock) {
        return createError("updateMedicineStock");
    }

    static Response createError(String api) {
        return new Response(ResponseEnum.ERROR).setResponseBody(api + "服务暂时不可访问,请稍后再试！");
    }
}
