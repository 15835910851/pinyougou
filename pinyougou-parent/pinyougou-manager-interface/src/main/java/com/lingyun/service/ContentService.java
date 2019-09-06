package com.lingyun.service;

import com.lingyun.entity.ResultListBean;
import com.lingyun.pojo.ContentBean;
import com.lingyun.pojo.ContentCategoryBean;

import java.util.List;

/**
 * @Author 张俊荣 15835910851
 * @Description //TODO
 * @Date 2019/9/4 14:08
 * @Param
 * @return
 **/
public interface ContentService {
    ResultListBean findAllWhere(Integer page, Integer rows, ContentBean contentBean);

    List<ContentBean> findAll();

    void delContent(Long[] ids);

    ContentBean findOne(Long id);

    void addOrUpdate(ContentBean contentBean);

}
