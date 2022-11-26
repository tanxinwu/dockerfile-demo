package com.base.dockerfiledemo.service.impl;

import com.base.dockerfiledemo.mapper.StepMapper;
import com.base.dockerfiledemo.model.Step;
import com.base.dockerfiledemo.service.StepService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.transaction.annotation.ShardingSphereTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class StepServiceImpl implements StepService {

    private final StepMapper stepMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    @ShardingSphereTransactionType(value = TransactionType.XA)
    public int deleteByPrimaryKey(Long id) {
        return stepMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    @ShardingSphereTransactionType(value = TransactionType.XA)
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
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    @ShardingSphereTransactionType(value = TransactionType.XA)
    public int updateByPrimaryKey(Step record) {
        int result = stepMapper.updateByPrimaryKey(record);
        int i = 9/0;
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @ShardingSphereTransactionType(value = TransactionType.XA)
    public String trans(Step record) {
        //REQUIRED
        // outer transaction
        Step insert = new Step();
        BeanUtils.copyProperties(record,insert);
        insert.setId(19L);
        int result = insert(insert);
        log.info("插入结果：{}",result);
        // inner transaction throw Exception will be affect outer transaction
        updateByPrimaryKey(record);
        return "success";
    }
}
