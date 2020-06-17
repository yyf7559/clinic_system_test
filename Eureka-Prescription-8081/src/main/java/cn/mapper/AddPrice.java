package cn.mapper;


import cn.entity.PrescriptionAddPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddPrice {
    public int addPrice(@Param("prescriptionAddPrice") PrescriptionAddPrice prescriptionAddPrice);
}
