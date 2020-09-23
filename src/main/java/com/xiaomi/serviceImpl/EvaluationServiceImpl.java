package com.xiaomi.serviceImpl;

import com.xiaomi.dao.EvaluationMapper;
import com.xiaomi.pojo.Evaluation;
import com.xiaomi.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "evaluationService", cacheManager = "cacheManager")
@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private EvaluationMapper evaluationMapper;

    @Cacheable(key = "'getAllEvaluation'")
    @Override
    public List<Evaluation> getAllEvaluation() {
        return evaluationMapper.getAllEvaluation();
    }

    @Cacheable(key = "'getEvaluationById'+#id")
    @Override
    public Evaluation getEvaluationById(Integer id) {
        return evaluationMapper.getEvaluationById(id);
    }

    @Cacheable(key = "'getEvaluationByUserId'+#user_id")
    @Override
    public List<Evaluation> getEvaluationByUserId(Integer user_id) {
        return evaluationMapper.getEvaluationByUserId(user_id);
    }

    @Cacheable(key = "'getEvaluationByGoodsId'+#goods_id")
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
