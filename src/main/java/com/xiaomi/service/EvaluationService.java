package com.xiaomi.service;

import com.xiaomi.pojo.Evaluation;

import java.util.List;

public interface EvaluationService {
    List<Evaluation> getAllEvaluation();

    Evaluation getEvaluationById(Integer id);

    List<Evaluation> getEvaluationByUserId(Integer user_id);

    List<Evaluation> getEvaluationByGoodsId(Integer goods_id);

    Integer delEvaluationById(Integer id);
}
