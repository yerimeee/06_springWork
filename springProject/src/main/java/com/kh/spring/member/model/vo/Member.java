package com.kh.spring.member.model.vo;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@ToString
public class Member {
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	//private LocalDate birthday;
	private Date birthday;
	private String phone;
	private LocalDateTime createDate;
	private boolean status;
}
//LocalDate와 Date의 차이점은 LocalDate는 월 시작이 0부터 나는 Date로 생년월일 자료형 해줌
