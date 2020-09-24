package com.xiaomi.commodity.dao;

import com.xiaomi.common.bo.Evaluation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hekun
 */
@Mapper
public interface EvaluationMapper {
    @Select("select * from evaluation")
    List<Evaluation> getAllEvaluation();

    @Select("select * from evaluation where id =#{id}")
    Evaluation getEvaluationById(@Param("id") Integer id);

    @Select("select * from evaluation where userId =#{userId}")
    List<Evaluation> getEvaluationByUserId(@Param("userId") Integer userId);

    @Select("select * from evaluation where goodsId =#{goodsId}")
    List<Evaluation> getEvaluationByGoodsId(@Param("goodsId") Integer goodsId);

    @Delete("delete from evaluation where id =#{id}")
    Integer delEvaluationById(@Param("id") Integer id);
}
