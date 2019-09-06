package com.lingyun.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 张俊荣 15835910851
 * @Description //TODO
 * @Date 2019/9/3 19:05
 * @Param
 * @return
 **/
@Data
public class ResultListBean implements Serializable {
    private Integer total;
    private List rows;
    private String message;
    private Boolean success;
    private Integer dangPage;
    private Integer meiPageCount;
    private Integer sumPage;

    public ResultListBean() {
    }


    public ResultListBean(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }

    public ResultListBean(Integer total, List rows, Integer dangPage, Integer meiPageCount, Integer sumPage) {
        this.total = total;
        this.rows = rows;
        this.dangPage = dangPage;
        this.meiPageCount = meiPageCount;
        this.sumPage = sumPage;
    }
}
