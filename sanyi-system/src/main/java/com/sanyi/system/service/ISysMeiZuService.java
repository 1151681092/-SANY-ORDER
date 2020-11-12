package com.sanyi.system.service;

import java.util.List;
import com.sanyi.system.domain.SysMeiZu;

/**
 * 魅族Service接口
 * 
 * @author ruoyi
 * @date 2020-11-05
 */
public interface ISysMeiZuService 
{
    /**
     * 查询魅族
     * 
     * @param id 魅族ID
     * @return 魅族
     */
    public SysMeiZu selectSysMeiZuById(Long id);

    /**
     * 查询魅族列表
     * 
     * @param sysMeiZu 魅族
     * @return 魅族集合
     */
    public List<SysMeiZu> selectSysMeiZuList(SysMeiZu sysMeiZu);

    /**
     * 新增魅族
     * 
     * @param sysMeiZu 魅族
     * @return 结果
     */
    public int insertSysMeiZu(SysMeiZu sysMeiZu);

    /**
     * 修改魅族
     * 
     * @param sysMeiZu 魅族
     * @return 结果
     */
    public int updateSysMeiZu(SysMeiZu sysMeiZu);

    /**
     * 批量删除魅族
     * 
     * @param ids 需要删除的魅族ID
     * @return 结果
     */
    public int deleteSysMeiZuByIds(Long[] ids);

    /**
     * 删除魅族信息
     * 
     * @param id 魅族ID
     * @return 结果
     */
    public int deleteSysMeiZuById(Long id);
}
