package com.wonjin.memberVo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {

private String memberId;
private String memberPw;
private int memberNo;
private String memberName;
private String email;
private String phone;
}
