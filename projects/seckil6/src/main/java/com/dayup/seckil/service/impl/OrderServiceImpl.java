package com.dayup.seckil.service.impl;

import com.dayup.seckil.model.Orders;
import com.dayup.seckil.repository.OrderRepository;
import com.dayup.seckil.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Override
  public Orders getOrderByUsernameAndCourseNo(String username, String courseNo) {
    return orderRepository.findByUsernameAndCourseNo(username, courseNo);
  }

  @Override
  public Orders saveAndFlush(Orders orders) {
    return orderRepository.saveAndFlush(orders);
  }


}
