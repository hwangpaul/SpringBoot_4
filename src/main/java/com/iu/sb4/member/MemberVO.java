package com.iu.sb4.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotEmpty
	private String id;
	
	
	@Length(min = 4, max = 8)
	private String pw;
	
	private String pw2;
	
	@Size(min = 3)
	private String name;
	
	@Range(min = 1, max = 200)
	private int age;
	
	@Email
	private String email;
	
	private List<MemberRoleVO> roles;

}
