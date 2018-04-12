package com.modianli.mybatis.mapper;

import com.modianli.mybatis.bean.Author;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//@Mapper
public interface AuthorMapper {

	@Insert("insert into author(author_name) value(#{name})")
	void insert(Author author);

	default void test(){
		System.out.println("a method with body in interface class");
	}

	@Select("select * from author where aid = #{id}")
	@Results(
			@Result(property = "name", column = "author_name")
	)
	Author getAuthor(@Param("id") long id);

	@Update("update author set author_name = #{name} where aid = 1")
	void updateAuth(@Param("name") String name);
}
