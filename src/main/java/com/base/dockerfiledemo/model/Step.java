package com.base.dockerfiledemo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Step implements Serializable {
    private Long id;

    private String code;

    private Date creatTime;

    private Long creatUser;

    private Date modifyTime;

    private Long modifyUser;

    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", code='" + code +
                ", creatTime=" + creatTime +
                ", creatUser=" + creatUser +
                ", modifyTime=" + modifyTime +
                ", modifyUser=" + modifyUser +
                '}';
    }
}