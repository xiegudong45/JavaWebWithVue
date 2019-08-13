package com.dayup.seckil.controller.api;

import com.dayup.seckil.VO.CourseVO;
import com.dayup.seckil.base.controller.BaseApiController;
import com.dayup.seckil.base.result.Result;
import com.dayup.seckil.model.Course;
import com.dayup.seckil.service.CourseService;
import com.dayup.seckil.util.CourseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CourseApiController extends BaseApiController {

  @Autowired
  public CourseService courseService;

  @RequestMapping(value="courseList", method= RequestMethod.GET)
  public Result<List<Course>> courseList() {

    return Result.success(courseService.findAllCourse());
  }

  @RequestMapping(value="courseDetail/{courseNo}", method=RequestMethod.GET)
  public Result<CourseVO> courseDetail(@PathVariable String courseNo) {
    Course course = courseService.findCourseByCourseNo(courseNo);
    CourseVO courseVO = CourseUtil.courseToCourseVO(course);


    // course -> courseVO
    return Result.success(courseVO);
  }

}
