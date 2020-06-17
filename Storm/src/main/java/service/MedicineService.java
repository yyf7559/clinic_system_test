package service;


import entity.Medicine;
import entity.vo.InMedicineVo;

import java.util.List;
import java.util.Map;

public interface MedicineService {
    List<Medicine> getAllMedicineByMap(Map<String, Object> map);

}
