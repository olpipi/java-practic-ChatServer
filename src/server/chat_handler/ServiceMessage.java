package server.chat_handler;

import server.client.Client;
import sun.misc.Cleaner;

public class ServiceMessage extends AbstractMessage {

    public void setClientIdMessage (Client m_client) {
        //this.messageText =
    }

    ServiceMessage(Client owner) {
        super(owner);
    }

    ServiceMessage(String initText, Client owner) {
        super(initText, owner);
    }
}
