package com.keduit.controller;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.keduit.domain.SampleDTO;
import com.keduit.domain.SampleDTOList;
import com.keduit.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic---------");
	}
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get.....");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("dto..."+dto);
		return "ex01";
	}
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : "+name);
		log.info("age : "+age);
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		for(String s : ids) {
			log.info("ids : "+s);
		}
		return "ex02List";
	}
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids : "+Arrays.toString(ids));
		return "ex02Array";
	}
	
	
	
	//===============2023-01-05=================
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("====list dtos : " + list);
		return "ex02Bean";  
		// ex) localhost:8090/sample/ex02Bean?list%5B0%5D.name=hong&list%5B1%5D.name=kim
		//?list[0].name=aaa => 원래는 이렇게 작성하지만 구글에 쳐보면 list%5B1%5D.name=aaa이런식으로 변환
	}
	
//2번
//	@InitBinder//ex03작성 -> ex03실행 -> InintBinder작성
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	
//1번
	@GetMapping("/ex03") //@InitBinder를 안쓰면 date = error 
	public String ex03(TodoDTO todo) {
		log.info("todo========"+todo);
		return "ex03";   //ex) localhost:8090/sample/ex03?title=test&dueDate=2022-11-01
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page")int page) {
		log.info("dto : "+dto);
		log.info("page : " + page);
		return "/sample/ex04";
	}
	
	@GetMapping("/rel")   //ex) http://localhost:8090/sample/rel
	public String rel() {
		log.info("...rel....");
		return "redirect:/sample/re2";// re2.jsp 반환
	}
	
	@GetMapping("/re2")  //re2는 re2.jsp를 가지고 있음
	public void re2() {
		log.info(".....re2....");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06.......");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto;   //maven -> jackson Databind 2.14.1추가
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07......");
		String msg="{\"name\" : \"홍길동\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, headers, HttpStatus.OK);
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload....");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file-> {
			log.info("-----------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
			log.info("contentType : " + file.getContentType()); //이미지 type
		});
	}
}
