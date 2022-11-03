package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberSecurityService implements UserDetailsService{
	
	@Autowired
	public MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		MemberVO memberVO = memberMapper.getLogin(username);
		log.info("MemberVO => {} ",memberVO);
		return memberVO;
	}
	
	
	

}
