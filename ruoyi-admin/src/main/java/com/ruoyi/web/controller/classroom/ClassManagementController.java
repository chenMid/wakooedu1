package com.ruoyi.web.controller.classroom;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.educationalAdministration.domain.ClassManagement;
import com.ruoyi.educationalAdministration.service.IClassManagementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教室管理Controller
 * 
 * @author wakoo
 * @date 2023-10-12
 */
@Controller
@RequestMapping("/educationalAdministration/classroom")
public class ClassManagementController extends BaseController
{
    private String prefix = "educationalAdministration/classroom";

    @Autowired
    private IClassManagementService classManagementService;

    @RequiresPermissions("educationalAdministration:classroom:view")
    @GetMapping()
    public String classroom()
    {
        return prefix + "/classroom";
    }

    /**
     * 查询教室管理列表
     */
    @RequiresPermissions("educationalAdministration:classroom:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ClassManagement classManagement)
    {
        startPage();
        List<ClassManagement> list = classManagementService.selectClassManagementList(classManagement);
        return getDataTable(list);
    }

    /**
     * 导出教室管理列表
     */
    @RequiresPermissions("educationalAdministration:classroom:export")
    @Log(title = "教室管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClassManagement classManagement)
    {
        List<ClassManagement> list = classManagementService.selectClassManagementList(classManagement);
        ExcelUtil<ClassManagement> util = new ExcelUtil<ClassManagement>(ClassManagement.class);
        return util.exportExcel(list, "教室管理数据");
    }

    /**
     * 新增教室管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教室管理
     */
    @RequiresPermissions("educationalAdministration:classroom:add")
    @Log(title = "教室管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ClassManagement classManagement)
    {
        return toAjax(classManagementService.insertClassManagement(classManagement));
    }

    /**
     * 修改教室管理
     */
    @RequiresPermissions("educationalAdministration:classroom:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ClassManagement classManagement = classManagementService.selectClassManagementById(id);
        mmap.put("classManagement", classManagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存教室管理
     */
    @RequiresPermissions("educationalAdministration:classroom:edit")
    @Log(title = "教室管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ClassManagement classManagement)
    {
        return toAjax(classManagementService.updateClassManagement(classManagement));
    }

    /**
     * 删除教室管理
     */
    @RequiresPermissions("educationalAdministration:classroom:remove")
    @Log(title = "教室管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(classManagementService.deleteClassManagementByIds(ids));
    }
}
