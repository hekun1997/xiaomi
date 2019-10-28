package com.xiaomi.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.xiaomi.configuration.web.UserThread;
import com.xiaomi.dao.*;
import com.xiaomi.pojo.*;
import com.xiaomi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    DefaultKaptcha defaultKaptcha ;
    @Autowired
    TypeService typeService ;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    GoodsMapper goodsMapper;

    @RequestMapping("/index")
    public ModelAndView index(HttpSession session){
        List<Type> types = typeService.getTypeForIndex();
        Integer userId = (Integer) session.getAttribute(session.getId());
        User user = (User) session.getAttribute("user#"+userId);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("Types",types);
        mv.addObject("User",user);
        return mv;
    }

    @RequestMapping(value = "/verification",method = RequestMethod.POST)
    @ResponseBody
    public boolean tytest(@RequestParam("check") String check,HttpSession session){
        String vrifyCode = (String) session.getAttribute("vrifyCode#"+session.getId());
        if (!check.equalsIgnoreCase(vrifyCode)) {
            return false;
        }
        return true;
    }

    @RequestMapping("/pageHelper")
    @ResponseBody
    public Object pageHelper(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<Goods> page = goodsMapper.getGoodsByName2("小米");
        return page;
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println("最后的测试方法 "+UserThread.get());
        return "";
    }

    /**
     * 获取验证码
     * @param session
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpSession session,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode#"+session.getId(), createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
