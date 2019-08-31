package com.xiaomi.ServiceImpl;

import com.xiaomi.dao.EvaluationMapper;
import com.xiaomi.pojo.Evaluation;
import com.xiaomi.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    EvaluationMapper evaluationMapper = null;

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

    @Override
    public Integer delEvaluationById(Integer id) {
        return evaluationMapper.delEvaluationById(id);
    }
}
