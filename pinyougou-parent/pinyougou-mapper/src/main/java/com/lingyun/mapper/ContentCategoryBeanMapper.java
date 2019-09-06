package com.lingyun.mapper;

import com.lingyun.pojo.ContentCategoryBean;
import com.lingyun.pojo.ContentCategoryBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentCategoryBeanMapper {
    int countByExample(ContentCategoryBeanExample example);

    int deleteByExample(ContentCategoryBeanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContentCategoryBean record);

    int insertSelective(ContentCategoryBean record);

    List<ContentCategoryBean> selectByExample(ContentCategoryBeanExample example);

    ContentCategoryBean selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContentCategoryBean record, @Param("example") ContentCategoryBeanExample example);

    int updateByExample(@Param("record") ContentCategoryBean record, @Param("example") ContentCategoryBeanExample example);

    int updateByPrimaryKeySelective(ContentCategoryBean record);

    int updateByPrimaryKey(ContentCategoryBean record);
}