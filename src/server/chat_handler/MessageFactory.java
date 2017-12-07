/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.chat_handler;

import server.client.Client;

import java.net.Socket;

/**
 *
 * @author Oleg
 */
public class MessageFactory {

    public static class FactoryHolder {
        static final MessageFactory HOLDER_INSTANCE = new MessageFactory();
    }

    public static MessageFactory getInstance() {
        return FactoryHolder.HOLDER_INSTANCE;
    }

    public Message createMessage(String messageText, Client from){
        return new UserMessage(messageText, from);
    }

    public Message createMessage(Client from){
        return new UserMessage(from);
    }
}
