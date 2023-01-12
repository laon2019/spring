package com.keduit.domain;

import java.util.Date;

import lombok.Data;

@Data
public class listVO {
	private Long bno;
	private String content;
	private Date regdate;
	private Date updatedate;
	private String success;
}
