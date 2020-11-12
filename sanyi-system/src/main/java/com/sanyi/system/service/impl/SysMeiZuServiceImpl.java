package com.sanyi.system.service.impl;

import java.util.List;
import com.sanyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sanyi.system.mapper.SysMeiZuMapper;
import com.sanyi.system.domain.SysMeiZu;
import com.sanyi.system.service.ISysMeiZuService;

/**
 * 魅族Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-11-05
 */
@Service
public class SysMeiZuServiceImpl implements ISysMeiZuService 
{
    @Autowired
    private SysMeiZuMapper sysMeiZuMapper;

    /**
     * 查询魅族
     * 
     * @param id 魅族ID
     * @return 魅族
     */
    @Override
    public SysMeiZu selectSysMeiZuById(Long id)
    {
        return sysMeiZuMapper.selectSysMeiZuById(id);
    }

    /**
     * 查询魅族列表
     * 
     * @param sysMeiZu 魅族
     * @return 魅族
     */
    @Override
    public List<SysMeiZu> selectSysMeiZuList(SysMeiZu sysMeiZu)
    {
        return sysMeiZuMapper.selectSysMeiZuList(sysMeiZu);
    }

    /**
     * 新增魅族
     * 
     * @param sysMeiZu 魅族
     * @return 结果
     */
    @Override
    public int insertSysMeiZu(SysMeiZu sysMeiZu)
    {
        sysMeiZu.setCreateTime(DateUtils.getNowDate());
        return sysMeiZuMapper.insertSysMeiZu(sysMeiZu);
    }

    /**
     * 修改魅族
     * 
     * @param sysMeiZu 魅族
     * @return 结果
     */
    @Override
    public int updateSysMeiZu(SysMeiZu sysMeiZu)
    {
        return sysMeiZuMapper.updateSysMeiZu(sysMeiZu);
    }

    /**
     * 批量删除魅族
     * 
     * @param ids 需要删除的魅族ID
     * @return 结果
     */
    @Override
    public int deleteSysMeiZuByIds(Long[] ids)
    {
        return sysMeiZuMapper.deleteSysMeiZuByIds(ids);
    }

    /**
     * 删除魅族信息
     * 
     * @param id 魅族ID
     * @return 结果
     */
    @Override
    public int deleteSysMeiZuById(Long id)
    {
        return sysMeiZuMapper.deleteSysMeiZuById(id);
    }
}
