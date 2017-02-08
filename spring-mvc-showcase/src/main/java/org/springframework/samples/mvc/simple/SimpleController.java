package org.springframework.samples.mvc.simple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

	@RequestMapping("/simple")
	public @ResponseBody List simple() {
		
		List list = new ArrayList<>();
		
		boolean flag = true;
		int no = 1;
		

		list.add(50);
		
		while (flag) {
			Person p = new Person();
			p.setSabun(no);
			p.setName("osstem" + no);
			p.setGrade("manager" + no);
			p.setPhone("010-0000-0000");
			p.setContent("Hello World!");
			no++;
			list.add(p);
			if (no > 50) {
				flag = false;
			}
		}
		
		return list;
	}

}
class Person {
	
	private int sabun;
	private String name;
	private String grade;
	private String phone;
	private String content;
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}

class Count {
	
	private int cnt;	
}
