package com.lingyun.service;

import com.lingyun.entity.ResultListBean;
import com.lingyun.pojo.ContentCategoryBean;

import java.util.List;

/**
 * @Author 张俊荣 15835910851
 * @Description //TODO
 * @Date 2019/9/4 14:09
 * @Param
 * @return
 **/
public interface ContentCategoryService {

    void delContentCategory(Long[] ids);

    void addOrUpdate(ContentCategoryBean contentCategoryBean);

    ContentCategoryBean findOne(Long id);

    ResultListBean findAllWhere(Integer page, Integer rows, ContentCategoryBean contentCategoryBean);

    List<ContentCategoryBean> findAll();
}
