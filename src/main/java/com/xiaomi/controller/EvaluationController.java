package com.xiaomi.controller;

import com.xiaomi.pojo.Evaluation;
import com.xiaomi.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView getAllEvaluation(){
        List<Evaluation> evaluations = evaluationService.getAllEvaluation();
        return new ModelAndView("","Evaluations",evaluations);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public ModelAndView getEvaluationByUserId(@PathVariable("userId")Integer userId){
        List<Evaluation> evaluations = evaluationService.getEvaluationByUserId(userId);
        return new ModelAndView("","Evaluations",evaluations);
    }
}
