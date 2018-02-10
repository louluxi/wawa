package com.irandoo.xhep.base.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.irandoo.xhep.base.mapper.MemberMapper;
import com.irandoo.xhep.base.model.Member;
import com.irandoo.xhep.base.service.MemberService;

@Service("memberService")
public class MemberServiceImpl extends BaseServiceImpl<Member> implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	@Resource
	public void setSuperBaseMapper(MemberMapper memberMapper) {
		// TODO Auto-generated method stub
		super.setBaseMapper(memberMapper);
		this.memberMapper = memberMapper;
	}
}
