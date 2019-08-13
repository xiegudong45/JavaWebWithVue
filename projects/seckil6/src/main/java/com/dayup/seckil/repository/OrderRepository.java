package com.dayup.seckil.repository;

import com.dayup.seckil.model.Course;
import com.dayup.seckil.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, String> {

  public Orders findByUsernameAndCourseNo(String username, String courseNo);

}
