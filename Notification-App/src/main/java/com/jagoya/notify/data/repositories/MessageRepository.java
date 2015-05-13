package com.jagoya.notify.data.repositories;

import java.util.Date;
import java.util.List;

import com.jagoya.notify.data.maps.tables.Message;

public interface MessageRepository {
	
	List<Message> getMessagesToSend(Date date);

}
