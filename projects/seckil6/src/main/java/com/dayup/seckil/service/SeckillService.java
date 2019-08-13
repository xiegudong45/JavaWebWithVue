package com.dayup.seckil.service;

import com.dayup.seckil.base.controller.BaseApiController;
import com.dayup.seckil.base.result.Result;
import com.dayup.seckil.model.Orders;
import com.dayup.seckil.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


public interface SeckillService {

  public Result<Orders> seckillFlow(User user, String courseNo);
}
