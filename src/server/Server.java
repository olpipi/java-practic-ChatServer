/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
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
class Server {

    private ServerSocket servSocket;


    Server (ServerSocket socket) {
        this.servSocket = socket;
    }

    void startServer() {

        System.out.println("MainLoop started");
        System.out.println("Start listen ServerSocket. Wainting for client");
        while (true) {
            
            try {
                Socket newClientSocket = this.servSocket.accept();
                
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
