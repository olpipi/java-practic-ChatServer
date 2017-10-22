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
public interface AbstractClient {

    
    String getName();
    
    Socket getSocket();
}
