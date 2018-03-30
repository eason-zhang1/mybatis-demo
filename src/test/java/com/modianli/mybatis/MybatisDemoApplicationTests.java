package com.modianli.mybatis;

import com.modianli.mybatis.bean.Author;
import com.modianli.mybatis.mapper.AuthorMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private AuthorMapper authorMapper;

	@Test
	public void insert(){
		Author author = new Author();
		author.setName("test" + new Random().nextInt(100));
		authorMapper.insert(author);
	}

	@Test
	public void test(){
		authorMapper.test();
	}

	@Test
	public void get(){
		Author author = authorMapper.getAuthor(1L);
		//Assert.assertEquals(author.getName(), "author1");
		System.out.println(author);
	}

	@Test
	public void update(){
		authorMapper.updateAuth("test");
	}
}
