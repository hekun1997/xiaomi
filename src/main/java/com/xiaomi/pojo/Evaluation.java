package com.xiaomi.pojo;

import java.io.Serializable;

//评价
public class Evaluation implements Serializable {
    private Integer evaluation_id;
    private Integer user_id;
    private Integer goods_id;
    private String evaluation_detail;
    private Integer evaluation_star;

    public Evaluation() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(Integer evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public String getEvaluation_detail() {
        return evaluation_detail;
    }

    public void setEvaluation_detail(String evaluation_detail) {
        this.evaluation_detail = evaluation_detail;
    }

    public Integer getEvaluation_star() {
        return evaluation_star;
    }

    public void setEvaluation_star(Integer evaluation_star) {
        this.evaluation_star = evaluation_star;
    }
}