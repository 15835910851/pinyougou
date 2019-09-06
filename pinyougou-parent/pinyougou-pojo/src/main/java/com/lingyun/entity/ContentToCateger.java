package com.lingyun.entity;

import com.lingyun.pojo.ContentBean;
import com.lingyun.pojo.ContentCategoryBean;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 张俊荣 15835910851
 * @Description //TODO
 * @Date 2019/9/3 19:14
 * @Param
 * @return
 **/
@Data
public class ContentToCateger implements Serializable {
    private ContentBean contentBean;
    private ContentCategoryBean contentCategoryBean;
}
