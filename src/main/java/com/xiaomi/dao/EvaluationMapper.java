package com.xiaomi.dao;

import com.xiaomi.pojo.Evaluation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EvaluationMapper {
    @Select("select * from evaluation")
    List<Evaluation> getAllEvaluation();

    @Select("select * from evaluation where id =#{id}")
    Evaluation getEvaluationById(@Param("id") Integer id);

    @Select("select * from evaluation where user_id =#{user_id}")
    List<Evaluation> getEvaluationByUserId(@Param("user_id") Integer user_id);

    @Select("select * from evaluation where goods_id =#{goods_id}")
    List<Evaluation> getEvaluationByGoodsId(@Param("goods_id") Integer goods_id);

    @Delete("delete from evaluation where id =#{id}")
    Integer delEvaluationById(@Param("id") Integer id);
}
