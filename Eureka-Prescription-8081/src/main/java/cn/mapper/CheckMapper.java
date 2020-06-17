package cn.mapper;

import cn.entity.PrescriptionCheck;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CheckMapper {
    public int addPreCheck(@Param("prescriptionCheck") PrescriptionCheck prescriptionCheck);

}
