package com.ReSIT.websocket.user;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document

public class User {

	private String nickName;
	private String fullName;
	private Status status;
	
}
