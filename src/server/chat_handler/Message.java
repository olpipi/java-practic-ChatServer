package server.chat_handler;

import server.client.Client;

public class Message {

    String messageText;
    Client owner;

    Message() {
        messageText = new String ();
    }

    Message(String initText) {
        messageText = new String (initText);
    }

    String getText (){
        return this.messageText;
    }

    void setText (String text) {
        this.messageText = text;
    }

}
