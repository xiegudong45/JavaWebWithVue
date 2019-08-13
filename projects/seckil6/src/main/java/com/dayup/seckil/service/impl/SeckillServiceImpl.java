package com.dayup.seckil.service.impl;

import com.dayup.seckil.base.result.Result;
import com.dayup.seckil.base.result.ResultCode;
import com.dayup.seckil.model.Course;
import com.dayup.seckil.model.Orders;
import com.dayup.seckil.model.User;
import com.dayup.seckil.service.CourseService;
import com.dayup.seckil.service.OrderService;
import com.dayup.seckil.service.SeckillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class SeckillServiceImpl implements SeckillService {

  @Autowired
  public CourseService courseService;

  @Autowired
  public OrderService orderService;

  public Orders seckill(User user, Course course) {
    // decrease stock
    int success = courseService.reduceStockByCourseNo(course.getCourseNo());
    if (success > 0) {
      Orders newOrder = new Orders();
      BeanUtils.copyProperties(course, newOrder);
      newOrder.setUsername(user.getUsername());
      newOrder.setCreatBy(user.getUsername());
      newOrder.setCreateDate(new Date());
      newOrder.setPayPrice(course.getCourcePrice());
      newOrder.setPayStatus("0");
      return orderService.saveAndFlush(newOrder);
    }
    // make order

    return null;
  }

  @Override
  public Result<Orders> seckillFlow(User user, String courseNo) {
    // check stock
    Course course = courseService.findCourseByCourseNo(courseNo);

    int stock = course.getStockQuantity();

    if (stock <= 0) {
      return Result.failure(ResultCode.SECKILL_NO_QUOTE);
    }

    // check whether already bought
    Orders order = orderService.getOrderByUsernameAndCourseNo(user.getUsername(), courseNo);
    if (order != null) {
      return Result.failure(ResultCode.SECKILL_BOUGHT);
    }

    // decrease stock, make order
    Orders newOrder = seckill(user, course);
    return Result.success(newOrder);
  }
}
