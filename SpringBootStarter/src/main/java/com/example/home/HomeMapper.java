package com.example.home;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.bean.Home;

@Mapper
public interface HomeMapper { 
	@Select("SELECT admin_name name FROM tb_admin WHERE admin_id = #{name}")
	public Home readHome(@Param("name") String name);
}
