package server.chat_handler;

import server.client.Client;

public abstract class AbstractMessage implements Message {
    protected String messageText;
    protected Client owner;

    AbstractMessage(Client owner) {
        messageText = new String ();
        this.owner = owner;
    }

    AbstractMessage(String initText, Client owner) {
        messageText = new String (initText);
        this.owner = owner;
    }

    @Override
    public String getText (){
        return this.messageText;
    }

    @Override
    public void setText (String text) {
        this.messageText = text;
    }

    @Override
    public Client getOwner(){ return this.owner; }

}
