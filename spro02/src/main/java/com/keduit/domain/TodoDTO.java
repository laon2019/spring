package com.keduit.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
//3번
	@DateTimeFormat(pattern="yyyy-MM-dd")// Initbinder는 출력이 너무 길다.
	private Date dueDate;
	
}
