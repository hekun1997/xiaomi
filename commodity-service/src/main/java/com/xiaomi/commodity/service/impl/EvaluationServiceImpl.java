package com.xiaomi.commodity.service.impl;


import com.xiaomi.commodity.dao.EvaluationMapper;
import com.xiaomi.commodity.service.EvaluationService;
import com.xiaomi.common.bo.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private EvaluationMapper evaluationMapper;

    @Override
    public List<Evaluation> getAllEvaluation() {
        return evaluationMapper.getAllEvaluation();
    }

    @Override
    public Evaluation getEvaluationById(Integer id) {
        return evaluationMapper.getEvaluationById(id);
    }


    @Override
    public List<Evaluation> getEvaluationByUserId(Integer user_id) {
        return evaluationMapper.getEvaluationByUserId(user_id);
    }

    @Override
    public List<Evaluation> getEvaluationByGoodsId(Integer goods_id) {
        return evaluationMapper.getEvaluationByGoodsId(goods_id);
    }

    @CacheEvict(key = "'getEvaluationById'+#id")
    @Override
    public Integer delEvaluationById(Integer id) {
        return evaluationMapper.delEvaluationById(id);
    }
}
