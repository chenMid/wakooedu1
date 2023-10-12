package com.ruoyi.educationalAdministration.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.educationalAdministration.mapper.ClassManagementMapper;
import com.ruoyi.educationalAdministration.domain.ClassManagement;
import com.ruoyi.educationalAdministration.service.IClassManagementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 教室管理Service业务层处理
 * 
 * @author wakoo
 * @date 2023-10-12
 */
@Service
public class ClassManagementServiceImpl implements IClassManagementService 
{
    @Autowired
    private ClassManagementMapper classManagementMapper;

    /**
     * 查询教室管理
     * 
     * @param id 教室管理主键
     * @return 教室管理
     */
    @Override
    public ClassManagement selectClassManagementById(Long id)
    {
        return classManagementMapper.selectClassManagementById(id);
    }

    /**
     * 查询教室管理列表
     * 
     * @param classManagement 教室管理
     * @return 教室管理
     */
    @Override
    public List<ClassManagement> selectClassManagementList(ClassManagement classManagement)
    {
        return classManagementMapper.selectClassManagementList(classManagement);
    }

    /**
     * 新增教室管理
     * 
     * @param classManagement 教室管理
     * @return 结果
     */
    @Override
    public int insertClassManagement(ClassManagement classManagement)
    {
        classManagement.setCreateTime(DateUtils.getNowDate());
        return classManagementMapper.insertClassManagement(classManagement);
    }

    /**
     * 修改教室管理
     * 
     * @param classManagement 教室管理
     * @return 结果
     */
    @Override
    public int updateClassManagement(ClassManagement classManagement)
    {
        classManagement.setUpdateTime(DateUtils.getNowDate());
        return classManagementMapper.updateClassManagement(classManagement);
    }

    /**
     * 批量删除教室管理
     * 
     * @param ids 需要删除的教室管理主键
     * @return 结果
     */
    @Override
    public int deleteClassManagementByIds(String ids)
    {
        return classManagementMapper.deleteClassManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教室管理信息
     * 
     * @param id 教室管理主键
     * @return 结果
     */
    @Override
    public int deleteClassManagementById(Long id)
    {
        return classManagementMapper.deleteClassManagementById(id);
    }
}
