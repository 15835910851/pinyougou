package com.lingyun.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lingyun.entity.ResultListBean;
import com.lingyun.pojo.ContentCategoryBean;
import com.lingyun.service.ContentCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 张俊荣 15835910851
 * @Description //TODO
 * @Date 2019/9/4 14:44
 * @Param
 * @return
 **/
@RequestMapping("contentCategory")
@RestController
public class ContentCategoryController {
    @Reference(timeout = 6000)
    private ContentCategoryService contentCategoryService;
    @RequestMapping("findAll")
    public List<ContentCategoryBean> findAll(){
        return contentCategoryService.findAll();
    }

    @RequestMapping("findAllWhere")
    public ResultListBean findAllWhere(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer rows, ContentCategoryBean contentCategoryBean){
        return contentCategoryService.findAllWhere(page,rows,contentCategoryBean);
    }
    @RequestMapping("findOne")
    public ContentCategoryBean findOne(Long id){
        return contentCategoryService.findOne(id);
    }
    @RequestMapping("delete")
    public ResultListBean delete(Long[] ids){
        try {
            contentCategoryService.delContentCategory(ids);
            return new ResultListBean("删除成功",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultListBean("删除失败",false);
    }

    @RequestMapping("addOrUpdate")
    public  ResultListBean addOrUpdate(ContentCategoryBean contentCategoryBean){
        try {
            contentCategoryService.addOrUpdate(contentCategoryBean);
            return new ResultListBean("执行成功",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultListBean("执行失败",false);
    }

}
