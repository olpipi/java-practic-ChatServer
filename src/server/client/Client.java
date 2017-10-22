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
public class Client implements AbstractClient {
    
    final String name;
    final Socket clientSocket;
        
    Client(String name, Socket socket){
        this.name = name;
        this.clientSocket = socket;
    }

    @Override
    public String getName() {
        return this.name;
    } 

    @Override
    public Socket getSocket() {
        return this.clientSocket;
    }
    
    
}
