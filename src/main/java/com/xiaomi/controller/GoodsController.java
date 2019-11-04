package com.xiaomi.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaomi.configuration.web.UserThread;
import com.xiaomi.dao.GoodsMapper;
import com.xiaomi.dao.TypeMapper;
import com.xiaomi.pojo.Goods;
import com.xiaomi.pojo.Type;
import com.xiaomi.pojo.User;
import com.xiaomi.service.GoodsService;
import com.xiaomi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService = null;
    @Autowired
    TypeService typeService = null;

    @RequestMapping("/{id}")
    public ModelAndView getGoodsDetail(@PathVariable Integer id, HttpSession session){
        ModelAndView mv = new ModelAndView("xiangqing");
        Goods goods = goodsService.getGoodsById(id);
        User user = UserThread.get();
        mv.addObject("User",user);
        mv.addObject("goods",goods);
        mv.addObject("image",goods.getGoodsImage());
        mv.addObject("goods_version",goods.getGoodsVersion());
        mv.addObject("colors",goods.getGoodsColors());
        return mv;
    }

    @RequestMapping("/type/{id}")
    public String goods(@PathVariable("id")Integer id,
                        @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                        @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                        Model m, HttpSession session){
        PageHelper.startPage(pageNum,pageSize);
        Type type = typeService.getTypeById(id);
        List<Goods> goods = goodsService.getGoodsByTypeId(id);
        User user = UserThread.get();
        PageInfo<Goods> page = new PageInfo<>(goods);
        m.addAttribute("User",user);
        m.addAttribute("Goods",page);
        m.addAttribute("Type",type);

        return "liebiao";
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String getGoodsByName(@RequestParam("goods_name")String goods_name,
                                 @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 HttpSession session,Model m){
        PageHelper.startPage(pageNum,pageSize);
        //Integer userId = (Integer) session.getAttribute(session.getId());
        //User user = (User) session.getAttribute("user#"+userId);
        User user = UserThread.get();
        List<Goods> goods = goodsService.getGoodsByName(goods_name);
        PageInfo<Goods> page = new PageInfo<>(goods);
        m.addAttribute("User",user);
        m.addAttribute("Goods",page);
        m.addAttribute("Goods_name",goods_name);
        return "liebiao";
    }

}
