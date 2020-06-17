package cn.service;


import cn.entity.AddPrice;
import cn.entity.PrescriptionModel;
import cn.entity.PrescriptionType;
import cn.mapper.ModelMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
//@CacheConfig(cacheNames = "ModelServiceImpl")
public class ModelServiceImpl implements ModelService {
    @Resource
    ModelMapper modelMapper;

    @Override
    //@Cacheable(key = "targetClass+':'+methodName+':'+ # typeId +':'+ # permissions +':'+ # number +':'+ # pageNum +':'+ # pageSize")
    public List<PrescriptionModel> findModel(Integer typeId, String permissions, String number, Integer pageNum, Integer pageSize) {
        return modelMapper.findModel(typeId,permissions,number);
    }

    @Override
    public List<AddPrice> findAddPrice() {
        return modelMapper.findAddPrice();
    }

    @Override
    public List<PrescriptionType> findPrescriptionType() {
        return modelMapper.findPrescriptionType();
    }
}
