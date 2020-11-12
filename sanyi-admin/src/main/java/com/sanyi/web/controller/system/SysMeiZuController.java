package com.sanyi.web.controller.system;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sanyi.common.annotation.Log;
import com.sanyi.common.core.controller.BaseController;
import com.sanyi.common.core.domain.AjaxResult;
import com.sanyi.common.enums.BusinessType;
import com.sanyi.system.domain.SysMeiZu;
import com.sanyi.system.service.ISysMeiZuService;
import com.sanyi.common.utils.poi.ExcelUtil;
import com.sanyi.common.core.page.TableDataInfo;

/**
 * 魅族Controller
 * 
 * @author ruoyi
 * @date 2020-11-05
 */
@RestController
@RequestMapping("/system/zu")
public class SysMeiZuController extends BaseController
{
    @Autowired
    private ISysMeiZuService sysMeiZuService;

    /**
     * 查询魅族列表
     */
    @PreAuthorize("@ss.hasPermi('system:zu:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysMeiZu sysMeiZu)
    {
        startPage();
        List<SysMeiZu> list = sysMeiZuService.selectSysMeiZuList(sysMeiZu);
        return getDataTable(list);
    }

    /**
     * 导出魅族列表
     */
    @PreAuthorize("@ss.hasPermi('system:zu:export')")
    @Log(title = "魅族", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysMeiZu sysMeiZu)
    {
        List<SysMeiZu> list = sysMeiZuService.selectSysMeiZuList(sysMeiZu);
        ExcelUtil<SysMeiZu> util = new ExcelUtil<SysMeiZu>(SysMeiZu.class);
        return util.exportExcel(list, "zu");
    }

    /**
     * 获取魅族详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:zu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysMeiZuService.selectSysMeiZuById(id));
    }

    /**
     * 新增魅族
     */
    @PreAuthorize("@ss.hasPermi('system:zu:add')")
    @Log(title = "魅族", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysMeiZu sysMeiZu)
    {
        return toAjax(sysMeiZuService.insertSysMeiZu(sysMeiZu));
    }

    /**
     * 修改魅族
     */
    @PreAuthorize("@ss.hasPermi('system:zu:edit')")
    @Log(title = "魅族", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysMeiZu sysMeiZu)
    {
        return toAjax(sysMeiZuService.updateSysMeiZu(sysMeiZu));
    }

    /**
     * 删除魅族
     */
    @PreAuthorize("@ss.hasPermi('system:zu:remove')")
    @Log(title = "魅族", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysMeiZuService.deleteSysMeiZuByIds(ids));
    }
}
