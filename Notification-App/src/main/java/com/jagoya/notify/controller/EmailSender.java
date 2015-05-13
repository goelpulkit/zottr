package com.jagoya.notify.controller;

import java.util.Date;
import java.util.List;

import com.jagoya.notify.data.maps.tables.Message;
import com.jagoya.notify.data.maps.tables.User;
import com.jagoya.notify.data.repositories.MessageRepository;
import com.jagoya.notify.data.repositories.UserRepository;
import com.jagoya.notify.utils.GmailUtil;

public class EmailSender {

	private MessageRepository messageRepository;
	private UserRepository userRepository;
	private GmailUtil gmailUtil;

	public void sendMessages() throws Exception {
		List<Message> messages = messageRepository
				.getMessagesToSend(new Date());

		for (Message message : messages) {
			List<User> users = userRepository.getUsersForMessage(message);
			gmailUtil.sendGmail(users, message);
		}

	}

}
