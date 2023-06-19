package com.kh.spring.demo.model.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor //변수없는 생성자
@AllArgsConstructor //모두 다 들어가있는 생성자
@ToString
public class Dev {
	private int no;
	private String name;
	private int career;
	private String email;
	private String gender;
	private String[] lang;
	private LocalDateTime createDate;
	
}