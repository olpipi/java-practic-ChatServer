/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.Tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oleg
 */
public class TcpConnectionTest {
    
    public TcpConnectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of createSocket method, of class TcpConnection.
     */
    @Test
    public void testCreateSocket() {
        System.out.println("createSocket");
        InetAddress address = null;
        int port = 0;
        Socket expResult = null;
            Socket result = TcpSocket.createSocket(address, port);
            assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendDataToSocket method, of class TcpConnection.
     */
    @Test
    public void testSendDataToSocket() {
        System.out.println("sendDataToSocket");
        Socket soc = null;
        String data = "";
        TcpSocket.sendDataToSocket(soc, data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of receiveDataFromSocket method, of class TcpConnection.
     */
    @Test
    public void testReceiveDataFromSocket() {
        System.out.println("receiveDataFromSocket");
        Socket soc = null;
        String expResult = "";
        String result = TcpSocket.receiveDataFromSocket(soc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSocket method, of class TcpConnection.
     */
    @Test
    public void testRemoveSocket() {
        System.out.println("removeSocket");
        Socket soc = null;
        TcpSocket.removeSocket(soc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
