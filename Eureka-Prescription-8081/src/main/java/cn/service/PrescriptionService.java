package cn.service;

import cn.entity.Prescription;
import cn.entity.PrescriptionDetail;

import java.util.List;

public interface PrescriptionService {
    public int addPrescription(Prescription prescription);//添加处方(诊断表)
    public int addPreDetail(PrescriptionDetail prescriptionDetail);//添加处方详情
    List<PrescriptionDetail> getAllPrescriptionMedicineXById(int id);

}
