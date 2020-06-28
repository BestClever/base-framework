package com.halfsummer.sys.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.halfsummer.baseframework.annotation.Log;
import com.halfsummer.baseframework.config.RequestHolder;
import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultDataUtil;
import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.baseframework.util.ActiveUser;
import com.halfsummer.baseframework.util.Audience;
import com.halfsummer.baseframework.util.JwtTokenUtil;
import com.halfsummer.sys.entity.User;
import com.halfsummer.sys.pojo.UserVo;
import com.halfsummer.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author BestClever
 * @title: LoginController
 * @projectName base-framework
 * @description: TODO
 * @date 2020-06-07 17:26
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultInfo login(HttpServletRequest request, UserVo userVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userVo.getUserId());
        User user = userService.getOne(queryWrapper);
        if (ObjectUtil.isEmpty(user)) {
            ResultDataUtil.createFail(CommonEnum.NOT_EXIST_USER);
        }
        if (!StrUtil.equals(userVo.getPassword(), user.getPassword())) {
            ResultDataUtil.createFail(CommonEnum.PASSWORD_ERROR);
        }
        if (StrUtil.equals("2", user.getStatus())) {
            ResultDataUtil.createFail(CommonEnum.USER_FORBIDDEN);
        }
        if (StrUtil.equals("3", user.getStatus())) {
            ResultDataUtil.createFail(CommonEnum.USER_DELETE);
        }
        String token = JwtTokenUtil.createJWT(user.getUserId(), user.getUserName(), Audience.getAudience());
        ActiveUser activeUser = new ActiveUser();
        BeanUtil.copyProperties(user, activeUser);
        RequestHolder.add(activeUser);
        RequestHolder.add(request);
        return ResultDataUtil.createSuccess(CommonEnum.LOGIN_SUCCESS).setData(token);
    }

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public ResultInfo getUser() {
        QueryWrapper queryWrapper = new QueryWrapper();
        User user = userService.getOne(queryWrapper);
        return ResultDataUtil.createSuccess(CommonEnum.SUCCESS).setData(user);
    }
}
