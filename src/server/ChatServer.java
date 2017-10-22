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
    
    
    public static class ServerHolder {
	public static final ChatServer HOLDER_INSTANCE = new ChatServer();
    }
		
    public static ChatServer getInstance() {
    return ServerHolder.HOLDER_INSTANCE;
    }
    
    
    
    public static void main(String[] args){
        
        
        ChatServer.getInstance().initialize();
        System.out.println("Server socket was sucessfully openned");
        
        Server serverThread = new Server();
        Thread t = new Thread(serverThread);
        t.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        return ChatServer.getInstance().servSocket;
    };
    
    
    
}
