package com.shin.example;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class HomeValidator implements Validator {
	
	//Validator implement받고 밑의 두 메서드 작성

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(arg0); //검증할 객체의 클래스 타입 정보
	}

	@Override
	public void validate(Object obj, Errors error) {
		// TODO Auto-generated method stub
		System.out.println("Validate()");
		Student student = (Student)obj;
		
		String studentName = student.getId();
		if(studentName == null || studentName.trim().isEmpty()){ //null 값이거나 비어있을 경우
			System.out.println("studentName is null or Emtpy");
			error.rejectValue("id","trouble"); //에러가 있다고 추가 
		}
		
		String studentPwd = student.getPwd();
		if(studentPwd == null || studentPwd.trim().isEmpty()){ //null 값이거나 비어있을 경우
			System.out.println("studentName is null or Emtpy");
			error.rejectValue("pwd","trouble"); //에러가 있다고 추가 
		}
	}
}
