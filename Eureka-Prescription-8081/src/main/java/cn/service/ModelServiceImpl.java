package cn.service;

import cn.entity.PrescriptionAddPrice;
import cn.mapper.AddPrice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ModelServiceImpl implements ModelService {
    @Resource
    AddPrice addPrice;
    @Override
    public int addPrice(PrescriptionAddPrice prescriptionAddPrice) {
        return addPrice.addPrice(prescriptionAddPrice);
    }
}
