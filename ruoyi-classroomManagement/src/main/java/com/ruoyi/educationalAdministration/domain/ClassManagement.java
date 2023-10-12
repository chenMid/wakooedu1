package com.ruoyi.educationalAdministration.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教室管理对象 class_management
 * 
 * @author wakoo
 * @date 2023-10-12
 */
public class ClassManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 班级ID */
    @Excel(name = "班级ID")
    private Long id;

    /** 校区ID */
    @Excel(name = "校区ID")
    private Long campusId;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String gradeName;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCampusId(Long campusId) 
    {
        this.campusId = campusId;
    }

    public Long getCampusId() 
    {
        return campusId;
    }
    public void setGradeName(String gradeName) 
    {
        this.gradeName = gradeName;
    }

    public String getGradeName() 
    {
        return gradeName;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("campusId", getCampusId())
            .append("gradeName", getGradeName())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .toString();
    }
}
