package cn.mapper;


import cn.entity.Advice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdviceMapper {
    public List<Advice> findAdvice();
}
