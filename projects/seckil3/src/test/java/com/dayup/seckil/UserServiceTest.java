package com.dayup.seckil;

import com.dayup.seckil.VO.UserVO;
import com.dayup.seckil.model.User;
import com.dayup.seckil.redis.UserRedis;
import com.dayup.seckil.service.UserService;
import com.dayup.seckil.util.MD5Util;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
  @Autowired
  public UserRedis userRedis;

  @Autowired
  public UserService userService;

  @Test
  public void testGetUser() {
    Assert.assertNotNull(userService.getUser("rrrr"));
  }

  @Test
  public void testPassword() {
    UserVO user = userService.getUser("rrrr");
    String password = MD5Util.inputToDb("1111", user.getDbflag());
    Assert.assertEquals(password, user.getPassword());
  }

  @Test
  public void testPutRedis() {
    User user = new User("alex", "123456");
    userRedis.put(user.getUsername(), user, -1);
  }
}
