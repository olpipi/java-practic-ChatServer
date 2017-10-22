/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.client;

import java.net.Socket;

/**
 *
 * @author Oleg
 */
public class ClientProxy {
    
    private final ClientThread m_ClientThread;
    private Thread threadOwner;
    
    ClientProxy(Socket socket) {
        m_ClientThread = new ClientThread(this, socket);
    }
    
    ClientProxy(Client client) {
        m_ClientThread = new ClientThread(this, client.getSocket());
    }
    
    public void startProxy(){
        startThread();
    }
    
    private void startThread() {
        if (null != m_ClientThread){
            threadOwner = new Thread(m_ClientThread);
            threadOwner.start();
        }
    }
    
    
}
