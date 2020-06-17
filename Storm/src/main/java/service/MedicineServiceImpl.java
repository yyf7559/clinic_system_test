package service;

import dao.MedicineDao;
import dao.MedicineDaoImpl;
import entity.Medicine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class MedicineServiceImpl implements MedicineService{
    @Resource
    private MedicineDao medicineDao;
    @Override
    public List<Medicine> getAllMedicineByMap(Map<String,Object> map){
        return medicineDao.getAllMedicineByMap(map);
    }
}
