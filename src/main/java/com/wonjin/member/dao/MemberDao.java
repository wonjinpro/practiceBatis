package com.wonjin.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonjin.memberVo.Member;

@Repository
public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public Member getOneMember(Member m) {
		
		Member member = sqlSession.selectOne("member.selectOneMember",m);
		return member;
	}

	public int signUpMember(Member m) {
		
		int result = sqlSession.insert("member.signUpMember",m);
		return result;
	}

	public int updateMember(Member m) {
		
		int result = sqlSession.update("member.updateMember",m);
		return result;
	}

	public int deleteMember(Member m) {
		
		int result =sqlSession.delete("member.deleteMember",m);
		return result;
	}
}
