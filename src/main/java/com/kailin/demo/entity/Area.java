package com.kailin.demo.entity;

import javax.validation.constraints.NotBlank;

public class Area extends BasicVo {
    private static final long serialVersionUID = 1L;

    private Integer areaId;
    @NotBlank
    private String areaName;
    private Integer priority;
    private java.util.Date createTime;
    private java.util.Date lastEditTime;


    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(java.util.Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

}

/*List columns as follows:
"area_id", "area_name", "priority", "create_time", "last_edit_time"
*/