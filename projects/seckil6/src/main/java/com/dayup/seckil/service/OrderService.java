package com.dayup.seckil.service;

import com.dayup.seckil.model.Orders;



public interface OrderService {
  Orders getOrderByUsernameAndCourseNo(String username, String courseNo);

  Orders saveAndFlush(Orders newOrder);
}
