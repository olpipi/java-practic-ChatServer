package server.chat_handler;

import server.client.Client;

public interface Message {

    public String getText ();

    public void setText (String text);

    public Client getOwner();

}
