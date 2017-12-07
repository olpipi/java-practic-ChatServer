package server.chat_handler;

import server.client.Client;

public class UserMessage extends AbstractMessage {

    UserMessage(Client owner) {
        super(owner);
    }

    UserMessage(String initText, Client owner) {
        super(initText, owner);
    }
}
