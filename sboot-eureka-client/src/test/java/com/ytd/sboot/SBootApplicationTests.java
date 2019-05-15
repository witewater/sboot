package com.ytd.sboot;

import com.ytd.sboot.dao.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.ytd.sboot.dao")
public class SBootApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Resource
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void contextLoads() {
		System.out.println(userMapper);
	}

}

