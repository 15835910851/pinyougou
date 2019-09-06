package com.lingyun.mapper;

import com.lingyun.pojo.ContentBean;
import com.lingyun.pojo.ContentBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentBeanMapper {
    int countByExample(ContentBeanExample example);

    int deleteByExample(ContentBeanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContentBean record);

    int insertSelective(ContentBean record);

    List<ContentBean> selectByExample(ContentBeanExample example);

    ContentBean selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContentBean record, @Param("example") ContentBeanExample example);

    int updateByExample(@Param("record") ContentBean record, @Param("example") ContentBeanExample example);

    int updateByPrimaryKeySelective(ContentBean record);

    int updateByPrimaryKey(ContentBean record);
}