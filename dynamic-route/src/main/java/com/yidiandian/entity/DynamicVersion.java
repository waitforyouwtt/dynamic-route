package com.yidiandian.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (DynamicVersion)实体类
 *
 * @author makejava
 * @since 2020-11-02 16:36:11
 */
@Data
public class DynamicVersion implements Serializable {
    private static final long serialVersionUID = -74349986045468026L;
    /**
    * 主键、自动增长、版本号
    */
    private Long id;
    
    private Date createTime;

}