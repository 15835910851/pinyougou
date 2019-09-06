package com.lingyun.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.lingyun.entity.ContentToCateger;
import com.lingyun.entity.ResultListBean;
import com.lingyun.mapper.ContentBeanMapper;
import com.lingyun.mapper.ContentCategoryBeanMapper;
import com.lingyun.pojo.ContentBean;
import com.lingyun.pojo.ContentBeanExample;
import com.lingyun.pojo.ContentCategoryBean;
import com.lingyun.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 张俊荣 15835910851
 * @Description //TODO
 * @Date 2019/9/3 16:21
 * @Param
 * @return
 **/
@Service(timeout = 6000)
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentBeanMapper contentBeanMapper;
    @Autowired
    private ContentCategoryBeanMapper contentCategoryBeanMapper;


    @Override
    public ResultListBean findAllWhere(Integer page, Integer rows, ContentBean contentBean) {
        ArrayList<ContentToCateger> list = new ArrayList<>();
        PageHelper.startPage(page,rows);
        ContentBeanExample contentBeanExample = new ContentBeanExample();
        ContentBeanExample.Criteria criteria = contentBeanExample.createCriteria();
        if(contentBean!=null){
            if (contentBean.getCategoryId()!=null){
                criteria.andCategoryIdEqualTo(contentBean.getCategoryId());
            }
            if (StringUtils.isNotEmpty(contentBean.getTitle())){
                criteria.andTitleLike("%"+contentBean.getTitle()+"%");
            }
            if (StringUtils.isNotEmpty(contentBean.getUrl())){
                criteria.andUrlEqualTo(contentBean.getUrl());
            }
            if (StringUtils.isNotEmpty(contentBean.getStatus())){
                criteria.andPicEqualTo(contentBean.getStatus());
            }
        }
        List<ContentBean> contentBeans = contentBeanMapper.selectByExample(contentBeanExample);
        for (ContentBean bean : contentBeans) {
            ContentCategoryBean contentCategoryBean = contentCategoryBeanMapper.selectByPrimaryKey(bean.getCategoryId());
            ContentToCateger contentToCateger = new ContentToCateger();
            contentToCateger.setContentBean(bean);
            contentToCateger.setContentCategoryBean(contentCategoryBean);
            list.add(contentToCateger);
        }
        ResultListBean resultListBean = new ResultListBean();
        Integer sumCount = contentBeanMapper.countByExample(contentBeanExample);
        double s1 = (double)sumCount/rows;
        return new ResultListBean(sumCount,list,page,rows,(int)s1);
    }

    @Override
    public List<ContentBean> findAll() {
        return contentBeanMapper.selectByExample(null);
    }

    @Override
    public void delContent(Long[] ids) {
        for (Long id : ids) {
            contentBeanMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void addOrUpdate(ContentBean contentBean) {
        if (contentBean!=null && contentBean.getId()!=null){
            contentBeanMapper.updateByPrimaryKey(contentBean);
        }else {
            contentBeanMapper.insert(contentBean);
        }
    }

    @Override
    public ContentBean findOne(Long id) {
        return contentBeanMapper.selectByPrimaryKey(id);
    }



}
