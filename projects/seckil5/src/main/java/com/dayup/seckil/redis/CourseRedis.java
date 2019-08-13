package com.dayup.seckil.redis;

import org.springframework.stereotype.Repository;

@Repository
public class CourseRedis extends BaseRedis<CourseRedis> {

  private static final String REDIS_KEY = "com.dayup.seckil.redis.CourseRedis";

  @Override
  protected String getRedisKey() {
    return REDIS_KEY;
  }
}
