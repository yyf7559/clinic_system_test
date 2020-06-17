package controller;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import entity.vo.InMedicineVo;
import service.MedicineService;
import service.MedicineServiceImpl;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicineAction extends ActionSupport{
    private static final long serialVersionUID = 1L;
    @Resource
    private MedicineService medicineService;
    private List<Medicine> medicineList;
    private InMedicineVo medicineVO;

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public InMedicineVo getMedicineVO() {
        return medicineVO;
    }

    public void setMedicineVO(InMedicineVo medicineVO) {
        this.medicineVO = medicineVO;
    }


    public void setMedicineService(MedicineServiceImpl medicineService) {
        this.medicineService = medicineService;
    }

    //获取所有药品信息
    public String list(){
        Map<String,Object> map = new HashMap<String, Object>(){{
            put("prescriptionTypeId",medicineVO.getPrescriptionTypeId());
            put("name",medicineVO.getName());
        }};
        medicineList = medicineService.getAllMedicineByMap(map);
        return Action.SUCCESS;
    }


}
