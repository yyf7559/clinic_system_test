package cn.service;

import cn.entity.Advice;
import cn.mapper.AdviceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdviceServiceImpl implements AdviceService {
    @Resource
    AdviceMapper adviceMapper;
    @Override
    public List<Advice> findAdvice() {
        return adviceMapper.findAdvice();
    }

}
