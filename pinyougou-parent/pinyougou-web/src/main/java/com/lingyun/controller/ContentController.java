package com.lingyun.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lingyun.entity.ResultListBean;
import com.lingyun.pojo.ContentBean;
import com.lingyun.service.ContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 张俊荣 15835910851
 * @Description //TODO
 * @Date 2019/9/4 14:38
 * @Param
 * @return
 **/
@RequestMapping("content")
@RestController
public class ContentController {
    @Reference
    private ContentService contentService;

    @RequestMapping("findAllWhere")
    public ResultListBean findAllWhere(Integer page, Integer rows, ContentBean contentBean){
        return contentService.findAllWhere(page,rows,contentBean);
    }
    @RequestMapping("findOne")
    public ContentBean findOne(Long id){
        return contentService.findOne(id);
    }
    @RequestMapping("findAll")
    public List<ContentBean> findAll(){
        return contentService.findAll();
    }

    @RequestMapping("delete")
    public ResultListBean delete(Long[] ids){
        try {
            contentService.delContent(ids);
            return new ResultListBean("删除成功",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultListBean("删除失败",false);
    }

    @RequestMapping("addOrUpdate")
    public  ResultListBean addOrUpdate(ContentBean contentBean){
        try {
            if (contentBean!=null&&contentBean.getStatus()!=null&&contentBean.getStatus().equals("true")) {
                contentBean.setStatus("1");
            }else {
                contentBean.setStatus("0");
            }
            contentService.addOrUpdate(contentBean);
            return new ResultListBean("执行成功",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultListBean("执行失败",false);
    }
}
