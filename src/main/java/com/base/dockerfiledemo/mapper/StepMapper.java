package com.base.dockerfiledemo.mapper;

import com.base.dockerfiledemo.model.Step;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StepMapper {
    int deleteByPrimaryKey(Long id);

    int insert(@Param("record") Step record);

    Step selectByPrimaryKey(Long id);

    List<Step> selectAll();

    int updateByPrimaryKey(Step record);
}