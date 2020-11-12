package com.sanyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.sanyi.common.annotation.Excel;
import com.sanyi.common.core.domain.BaseEntity;

/**
 * 魅族对象 sys_mei_zu
 * 
 * @author ruoyi
 * @date 2020-11-05
 */
public class SysMeiZu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 魅族id */
    private Long id;

    /** 名字 */
    @Excel(name = "名字")
    private String name;

    /** 标签 */
    @Excel(name = "标签")
    private String title;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("title", getTitle())
            .append("createTime", getCreateTime())
            .toString();
    }
}
