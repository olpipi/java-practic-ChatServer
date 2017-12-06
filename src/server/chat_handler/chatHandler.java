package server.chat_handler;

import java.util.ArrayDeque;

public class chatHandler {

    final int queueCapacity = 10;

    ArrayDeque<Message> messageQueue;

    chatHandler () {
        messageQueue =  new ArrayDeque<Message>(queueCapacity);
    }

    void pushQueue(Message newMessage){
        while (messageQueue.size() > queueCapacity) {
            messageQueue.removeFirst();
        }
        messageQueue.add(newMessage);
    }

    Message popQueue () {
        if (messageQueue.size() == 0){
            return null;
        }
        return messageQueue.getFirst();
    }





}
