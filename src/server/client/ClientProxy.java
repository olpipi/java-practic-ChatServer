/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.client;

import java.net.Socket;

/*
  @author Oleg
 */

/**
 * This class is a proxy between Client and ClientThread
 * It contains clientTread which handle TCP connection to Client
 * It belongs to Client
 */
public class ClientProxy {
    
    private final ClientThread m_ClientThread;
    private final Client m_Client;

    ClientProxy(Client client) {
        m_Client = client;
        m_ClientThread = new ClientThread(this, client.getSocket());
    }
    
    public void startProxy(){
        startThread();
    }

    void stopProxy() {
        removeProxyHandler();
    }

    /**
     * Start ClientThread ho handle client events
     */
    private void startThread() {
        if (null != m_ClientThread){
            Thread threadOwner = new Thread(m_ClientThread);
            threadOwner.start();
        }
    }

    /**
     * Remove this ProxyHandler and client from ClientHanler
     */
    private void removeProxyHandler() {
        ProxyHandler.getInstance().deleteClient(m_Client);
    }
    
    
}
