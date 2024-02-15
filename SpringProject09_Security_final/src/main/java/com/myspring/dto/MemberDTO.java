package com.myspring.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {
	private String userid;
	private String username;
	private String userpw;
	private String regdate;
	private String updateDate;
	private boolean enabled;
	private List<AuthDTO> authList;

}
