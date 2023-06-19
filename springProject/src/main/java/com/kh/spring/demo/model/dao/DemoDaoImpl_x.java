package com.kh.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Dev;

//@Repository //DB 연동할 때 쓰는 어노테이션(저장소라는 의미)
public class DemoDaoImpl_x {//implements DemoDao { //Dao가 DB와 연동하는 파일
/* 파일명 x로 변경 후 주석 처리
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertDev(Dev dev) {
		return session.insert("demo.insertDev", dev); 
		//demo.은 xml의 namespace의미, insertDev는 id를 의미
	}

	@Override
	public List<Dev> selectDevList() {
		return session.selectList("demo.selectDevList");
	}

	@Override
	public Dev selectOneDev(int no) {
		return session.selectOne("demo.selectOneDev", no);
	}

	@Override
	public int updateDev(Dev dev) {
		return session.update("demo.updateDev", dev);
	}
*/
}
