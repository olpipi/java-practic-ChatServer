/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.client.Client;
import server.client.ClientFactory;
import server.client.ClientProxy;
import server.client.ProxyHandler;

/**
 *
 * @author Oleg
 */
class Server implements Runnable {

    @Override
    public void run() {
        
        System.out.println("Start listen ServerSocket. Wainting for client");
        while (true) {
            
            try {
                Socket newClientSocket = ChatServer.getInstance().getSocket().accept();
                
                Client newClient = ClientFactory.getInstance().createClient(newClientSocket);
                ClientProxy m_clientProxy =  ProxyHandler.getInstance().addClient(newClient);
                if (null != m_clientProxy) {
                    m_clientProxy.startProxy();
                }
                
                
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
