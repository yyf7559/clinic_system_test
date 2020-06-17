package cn.service;

import cn.entity.PrescriptionCheck;
import cn.mapper.CheckMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CheckServiceImpl implements CheckService {
    @Resource
    CheckMapper checkMapper;
    @Override
    public int addPreCheck(PrescriptionCheck prescriptionCheck) {
        return checkMapper.addPreCheck(prescriptionCheck);
    }
}
