package com.kh.spring.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	//SqlSession생성을 위해서는 SqlSessionFactory필요
	//SqlSessionFactory 위해서는 SqlSessionFactoryBuilder 필요
	
	public static SqlSession getSqlSession() { //메소드 만들어서 try문 호출
		SqlSession sqlSession = null; // SqlSession :마이바티스에 들어있는 것임, ibatis는 구버전
		String resource = "/mybatis-config.xml";
		
	//외부(DB)에서 mybatis 접속하는 것이기 때문에 String으로 받아옴
	try {
	InputStream stream = Resources.getResourceAsStream(resource);
	sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
														//세션 오픈하여 공유할 수 있게 함
	} catch(IOException e) {
		e.printStackTrace();
	}
	return sqlSession;
	}
}
