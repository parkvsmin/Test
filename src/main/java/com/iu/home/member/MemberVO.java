package com.iu.home.member;


import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MemberVO {

	private String id;
	@NotBlank(message = "중복된 ID")
	private String idCheck;
	private String password;
	@NotBlank(message = "비밀번호를 재입력")
	private String passwordCheck;
	private String name;
	private String email;
	private boolean enabled;

	private List<RoleVO> roleVOs;

}
