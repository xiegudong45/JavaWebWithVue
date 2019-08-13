package com.dayup.seckil.redis;

import com.dayup.seckil.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRedis extends BaseRedis<User> {
  private static final String REDIS_KEY = "com.dayup.seckil.redis.UserRedis";

  @Override
  protected String getRedisKey() {
    return REDIS_KEY;
  }


}
