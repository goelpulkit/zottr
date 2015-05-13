package com.jagoya.notify.data.repositories;

import java.util.List;

import com.jagoya.notify.data.maps.tables.Message;
import com.jagoya.notify.data.maps.tables.User;

public interface UserRepository {
	
	List<User> getUsersForMessage(Message message);

}
