package com.dayup.seckil.controller.api;

import com.dayup.seckil.VO.UserVO;
import com.dayup.seckil.base.controller.BaseApiController;
import com.dayup.seckil.base.result.Result;
import com.dayup.seckil.base.result.ResultCode;
import com.dayup.seckil.model.User;
import com.dayup.seckil.service.UserService;
import com.dayup.seckil.util.MD5Util;
import com.dayup.seckil.util.UUIDUtil;
import com.dayup.seckil.util.ValidateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class LoginApiController extends BaseApiController {

  private static Logger log = LoggerFactory.getLogger(LoginApiController.class);

  @Autowired
  public UserService userService;

  @RequestMapping(value="/login")
  public Result<Object> login(@ModelAttribute(value="user") @Valid User user,
                      BindingResult bindingResult,
                      HttpSession session, String code, Model model,
                      HttpServletResponse response) {

    if (bindingResult.hasErrors()) {
      log.info("bindingResult error");
      return Result.failure(); // "500", "error"
    }


    // String sessionCode = (String) session.getAttribute("code");
    // if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {
    //   model.addAttribute("message", "Validation code not correct.");
    //   return "login";
    // }

    UserVO dbUser = userService.getUser(user.getUsername());

    if (dbUser != null) {
      String dbUserPass = dbUser.getPassword();
      String pass = MD5Util.inputToDb(user.getPassword(), dbUser.getDbflag());
      if (dbUserPass.equals(pass)) {
        log.info("success!");

        String token = UUIDUtil.getUUID();
        userService.saveUserToRedisByToken(dbUser, token);

        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        response.addCookie(cookie);

        return Result.success(); // Result.success; 200, "success";
      } else {
        log.info("incorrect pass");
        return Result.failure(ResultCode.USER_LOGIN_ERROR);
      }
    } else {
      log.info("pass is null");
      return Result.failure(ResultCode.USER_LOGIN_ERROR);
    }
  }

}
