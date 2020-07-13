package com.cos.viewresolver;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //IOC
public class IndexController {
	
	@GetMapping({"","/"})
	public String Index(Model model) { // RequestDispatcher 을 모델이라는 클래스로 미리 만들어놓음
		
		String name = "cos";
		int num = 10;
		String password = "1234";
		model.addAttribute("name", name);
		model.addAttribute("num", num);
		model.addAttribute("password", password);
		
		
		// => /viewresolver/src/main/resources/templates/index.mustache  viewresolver 프리픽스 templates 까지  1 파일을 찾는다 2
		return "index";
	}
	
	@GetMapping("/model/data")
	public String modelData(Model model) { //DI 하기 
		Member member = Member.builder()
				.id(1)
				.username("ssar")
				.phone("01012349876")
				.build();
		
		model.addAttribute("member", member);
		
		return "modelData";
	}
	
	@GetMapping("/model/array")
	public String modelArray(Model model) { //DI 하기 
		Member member1 = Member.builder()
				.id(1)
				.username("ssar")
				.phone("01012349876")
				.build();
		Member member2 = Member.builder()
				.id(2)
				.username("cos")
				.phone("01012349876")
				.build();
		List<Member> members = new ArrayList<>();
		members.add(member1);
		members.add(member2);
		
		model.addAttribute("members", members);
		model.addAttribute("user", true);
		
		return "modelArray";
	}
	
	@GetMapping("/layout")
	public String layout() { //DI 하기 
		return "layout";
	}
}
