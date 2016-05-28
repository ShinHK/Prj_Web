package com.shin.example;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	                                       //@Valid annotation 사용 유효성 검사를 할거 앞에 
	public String index(@ModelAttribute("id")@Valid String id,BindingResult result){
		String page = "ok";
		
		//직접 호출
		//HomeValidator validator = new HomeValidator();
		//validator.validate(id, result);
		
		//result에 에러가 있으면
		if(result.hasErrors()){
			page = "notok";
		}
		
		return page;
	}
	
	//@InitBinder annotation 사용 / 메서드 생성 / validator메서들 호출 하지 않아도 스프링이 자동적으로 
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new HomeValidator());
	}
}
