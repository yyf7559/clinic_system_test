package cn.config;


import cn.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "eureka-medicine-8084",fallback = MedicineCallBack.class)
public interface FeignMedicineApi {
    @GetMapping("/come/medicine/findMedicineType")
    public Response findMedicineType(@RequestParam(value = "pid",required = false)Integer pid);
    @GetMapping("/come/medicine/findMedicine")
    public Response findMedicine(@RequestParam(value = "typeId",required = false)Integer typeId,
                                 @RequestParam(value = "code",required = false)String code,
                                 @RequestParam(value = "page",defaultValue = "1")Integer page,
                                 @RequestParam(value = "limit",defaultValue = "3")Integer limit);
    @GetMapping("/come/medicine/findMedicineByPid")
    public Response findMedicineByPid(@RequestParam(value = "pid",required = false)Integer pid,
                                      @RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo,
                                      @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize);

    @GetMapping("/come/check/findCheckByTypeId")
    public Response findCheckByTypeId(@RequestParam(value = "checkTypeId",required = false)Integer checkTypeId,
                                      @RequestParam(value = "checkCode",required = false)String checkCode,
                                      @RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "3")Integer limit);
    @GetMapping("/come/check/findCheck")
    public Response findCheck();
    @GetMapping("/come/check/findCheckType")
    public Response findCheckType();
    @GetMapping("/come/medicine/updateMedicineStock")
    public Response updateMedicineStock(@RequestParam(value = "id",required = false) int id,
                                        @RequestParam(value = "stock",required = false) int stock);

}
