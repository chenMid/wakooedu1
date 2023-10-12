package com.ruoyi.educationalAdministration.service;

import java.util.List;
import com.ruoyi.educationalAdministration.domain.ClassManagement;

/**
 * 教室管理Service接口
 * 
 * @author wakoo
 * @date 2023-10-12
 */
public interface IClassManagementService 
{
    /**
     * 查询教室管理
     * 
     * @param id 教室管理主键
     * @return 教室管理
     */
    public ClassManagement selectClassManagementById(Long id);

    /**
     * 查询教室管理列表
     * 
     * @param classManagement 教室管理
     * @return 教室管理集合
     */
    public List<ClassManagement> selectClassManagementList(ClassManagement classManagement);

    /**
     * 新增教室管理
     * 
     * @param classManagement 教室管理
     * @return 结果
     */
    public int insertClassManagement(ClassManagement classManagement);

    /**
     * 修改教室管理
     * 
     * @param classManagement 教室管理
     * @return 结果
     */
    public int updateClassManagement(ClassManagement classManagement);

    /**
     * 批量删除教室管理
     * 
     * @param ids 需要删除的教室管理主键集合
     * @return 结果
     */
    public int deleteClassManagementByIds(String ids);

    /**
     * 删除教室管理信息
     * 
     * @param id 教室管理主键
     * @return 结果
     */
    public int deleteClassManagementById(Long id);
}
