/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.Tcp;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.IOUtils;
/**
 *
 * @author Oleg
 */
public class TcpSocket {
    
    private Socket m_socket;
    private InetAddress address;
    private int port;
    
    DataOutputStream out = null;
    DataInputStream  in  = null;
    
    private boolean connected = false;
    
    public TcpSocket() {
    }
    
    public TcpSocket(String address, int port) {
        createSocket(address, port);
    }
    
    public void setAddress (String address) {
        try { 
            if (("localhost" == address) || ("127.0.0.1" == address)){
                this.address = InetAddress.getLocalHost();
            } else {
                this.address = InetAddress.getByName(address);
            }
        } catch (UnknownHostException ex) {
        		System.out.println(ex);
                Logger.getLogger(TcpSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getAddress() {
        if (null != this.address) {
            return this.address.getHostAddress();
        } else {
            return "";
        }
    }
    
    public void setPort(int port) {
        this.port = port;
    }
    
    public int getPort() {
        return this.port;
    }
    
    public void createSocket(String address, int port) {
        setAddress(address);
        setPort(port);
        createSocket();
    }
    
    
    
    public void createSocket() {
        if (null == m_socket) {
            try
            {
                Socket tmpSocket = new Socket(this.address, this.port);
                tmpSocket.setSoTimeout(30);            
                m_socket = tmpSocket;
                if (tmpSocket.isConnected()) {
                	setConnected();
                	System.out.println("Connected");
                        out = new DataOutputStream(m_socket.getOutputStream());
                        in = new DataInputStream(m_socket.getInputStream());
                } else {
                	System.out.println("Not Connected");
                }
            }
            catch (IOException ex) {
            	System.out.println(ex);
                Logger.getLogger(TcpSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void sendDataToSocket(String data) {
        try
        {
            out.writeUTF(data);
        }
        catch (IOException ex) {
        	System.out.println(ex);
            Logger.getLogger(TcpSocket.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public String receiveDataFromSocket () {
        String entry = "";        
        try { 
            entry = in.readUTF();
        } catch (IOException ex) {
        	System.out.println(ex);
            Logger.getLogger(TcpSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entry;
    }
    
    public void removeSocket () {
        try { 
            this.m_socket.close();
            this.m_socket = null;
            setUnConnected();
        } catch (IOException ex) {
        	System.out.println(ex);
            Logger.getLogger(TcpSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void setConnected() {
        this.connected = true;
    }
    
    private void setUnConnected() {
        this.connected = false;
    }
    
    public boolean isConnected() {
        return this.connected;
    }
   
    protected void finalize()
                 throws Throwable {
        removeSocket();
    }
    
    
}
