package com.base.dockerfiledemo.service.impl;

import com.base.dockerfiledemo.mapper.StepMapper;
import com.base.dockerfiledemo.model.Step;
import com.base.dockerfiledemo.service.StepService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class StepServiceImpl implements StepService {

    private final StepMapper stepMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return stepMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Step record) {
        return stepMapper.insert(record);
    }

    @Override
    public Step selectByPrimaryKey(Long id) {
        return stepMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Step> selectAll() {
        return stepMapper.selectAll() ;
    }

    @Override
    public int updateByPrimaryKey(Step record) {
        return stepMapper.updateByPrimaryKey(record);
    }
}
