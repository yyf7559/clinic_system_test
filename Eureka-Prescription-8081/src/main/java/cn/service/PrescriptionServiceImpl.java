package cn.service;

import cn.entity.Prescription;
import cn.entity.PrescriptionDetail;
import cn.mapper.PrescriptionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    @Resource
    PrescriptionMapper prescriptionMapper;
    @Override
    public int addPrescription(Prescription prescription) {
        return prescriptionMapper.addPrescription(prescription);
    }
    @Override
    public int addPreDetail(PrescriptionDetail prescriptionDetail) {
        return prescriptionMapper.addPreDetail(prescriptionDetail);
    }

    @Override
    public List<PrescriptionDetail> getAllPrescriptionMedicineXById(int id) {
        return prescriptionMapper.getAllPrescriptionMedicineXById(id);
    }
}
