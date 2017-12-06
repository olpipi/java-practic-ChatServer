    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oleg
 */
public class ChatServer {
    
    
    private static int port = 45645;
    private static ServerSocket servSocket;
    
    
    public static void main(String[] args){
        
        
        initialize();
        System.out.println("Server socket was sucessfully openned");
        
        Server m_server = new Server(servSocket);
        m_server.startServer();
        System.out.println("Server stopped. Shutdown");
    }
    
    
    private static void initialize() {
        try {
             servSocket = new ServerSocket(port);
             System.out.println("Server socket created on port: " + port);
        } catch (IOException ex) {
            System.err.println("Can't create server socket: " + ex);
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ServerSocket getSocket(){
        return ChatServer.servSocket;
    }
    
    
    
}
