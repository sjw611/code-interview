package ood.chatserver.service;

import ood.chatserver.entity.ChatHistory;
import ood.chatserver.entity.User;

public class ChatService {
	public boolean registerUser(User user) {
		return false;
	}

	public boolean deregisterUser(User user) {
		return false;
	}

	public boolean initChat(User a, User b) {
		return true;
	}

	public ChatHistory searchHistory(User a, User b) {
		return null;
	}
}
