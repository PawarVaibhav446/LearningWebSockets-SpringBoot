package com.ReSIT.websocket.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private UserRepository repository;

	public UserService(UserRepository repository) {
		super();
		this.repository = repository;
	}

	public void saveUser(User user) {
		user.setStatus(Status.ONLINE);
		repository.save(user);
	}
	
	public void disconnectUser(User user) {
		var storedUser = repository.findById(user.getNickName()).orElse(null);
		if(storedUser != null) {
			storedUser.setStatus(Status.OFFLINE);
			repository.save(storedUser);
		}
	}
	
	public List<User> findConnectedUser(){
		return repository.findAllByStatus(Status.ONLINE);
	}
}
