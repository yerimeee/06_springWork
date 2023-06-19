package com.kh.spring.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.spring.member.model.vo.Member;

@Mapper 
/*
 * 1. mapper.xml로 자동으로 연결시켜줌
 * 2. 추상메소드에 @Insert @Update @Delete @Select를 통해 간단한!(조인,서브쿼리 불가) 쿼리만을 직접 작성 가능
 * 		분기처리(if-else), 반복처리와 같은 복잡한 쿼리들은 어노테이션으로 해결 불가
 * 		따라서 mapper.xml이 없어도 되는 것이 아님
 */
public interface MemberDao {

	int insertMember(Member member); 
	//Impl파일 삭제하고 인터페이스를 생성하면 insertMember가 id가 되어서 mapper의 id로 됨

	Member selectOneMember(String userId);

	int updateMember(Member member);

}
