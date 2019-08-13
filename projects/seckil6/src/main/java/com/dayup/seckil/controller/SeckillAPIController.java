package com.dayup.seckil.controller;

import com.dayup.seckil.VO.CourseVO;
import com.dayup.seckil.base.controller.BaseApiController;
import com.dayup.seckil.base.result.Result;

import com.dayup.seckil.model.Orders;
import com.dayup.seckil.model.User;

import com.dayup.seckil.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeckillAPIController extends BaseApiController {

  @Autowired
  public SeckillService seckillService;

  @RequestMapping(value="seckill/{courseNo}", method= RequestMethod.GET)
  public Result<Orders> seckill(User user, @PathVariable String courseNo) {
    if (user == null) {
      System.out.println("user is null");
      return Result.failure();
    }
    System.out.println("yes!!!!");
    return seckillService.seckillFlow(user, courseNo);
  }
}
