package cn.mapper;


import cn.entity.AddPrice;
import cn.entity.PrescriptionModel;
import cn.entity.PrescriptionType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
//@CacheConfig(cacheNames = "c1")
public interface ModelMapper {
    //@Cacheable(key = "targetClass+':'+methodName+':'+ # typeId +':'+ # permissions +':'+ # number +':'+ # pageNum +':'+ # pageSize")
    public List<PrescriptionModel> findModel(@Param("typeId") Integer typeId, @Param("permissions") String permissions, @Param("number") String number);
    public List<AddPrice> findAddPrice();
    public List<PrescriptionType> findPrescriptionType();
}
