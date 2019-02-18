package org.abhijith.keralastones.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.abhijith.keralastones.messenger.database.DatabaseClass;
import org.abhijith.keralastones.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		Message m1 = new Message(100, "Abhijith wrote this", "Abhijith");
		messages.put(m1.getId(), m1);
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}

