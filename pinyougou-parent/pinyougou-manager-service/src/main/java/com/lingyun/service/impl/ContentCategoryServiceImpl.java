package com.lingyun.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.lingyun.entity.ResultListBean;
import com.lingyun.mapper.ContentCategoryBeanMapper;
import com.lingyun.pojo.ContentCategoryBean;
import com.lingyun.pojo.ContentCategoryBeanExample;
import com.lingyun.service.ContentCategoryService;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author 张俊荣 15835910851
 * @Description //TODO
 * @Date 2019/9/4 14:15
 * @Param
 * @return
 **/
@Service(timeout = 6000)
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private ContentCategoryBeanMapper contentCategoryBeanMapper;

    @Override
    public void delContentCategory(Long[] ids) {
        for (Long id : ids) {
            contentCategoryBeanMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public ContentCategoryBean findOne(Long id) {
        return contentCategoryBeanMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultListBean findAllWhere(Integer page, Integer rows, ContentCategoryBean contentCategoryBean) {
        PageHelper.startPage(page,rows);
        ContentCategoryBeanExample contentCategoryBeanExample = new ContentCategoryBeanExample();
        ContentCategoryBeanExample.Criteria criteria = contentCategoryBeanExample.createCriteria();
        if (contentCategoryBean!=null && StringUtils.isNotEmpty(contentCategoryBean.getName())) {
            criteria.andNameLike("%"+contentCategoryBean.getName()+"%");
        }
        List<ContentCategoryBean> contentCategoryBeans = contentCategoryBeanMapper.selectByExample(contentCategoryBeanExample);
        int sumCount = contentCategoryBeanMapper.countByExample(contentCategoryBeanExample);
        double s1 = (double) Math.ceil(sumCount/rows);
        return new ResultListBean(sumCount,contentCategoryBeans,page,rows,(int)s1);
    }

    @Override
    public void addOrUpdate(ContentCategoryBean contentCategoryBean) {
        if (contentCategoryBean!=null && contentCategoryBean.getId()!=null){
            contentCategoryBeanMapper.updateByPrimaryKey(contentCategoryBean);
        }else {
            contentCategoryBeanMapper.insert(contentCategoryBean);
        }
    }

    @Override
    public List<ContentCategoryBean> findAll() {
        return contentCategoryBeanMapper.selectByExample(null);
    }
}
