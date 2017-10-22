package client.Tcp;

import java.util.Scanner;

/**
 *
 * @author Oleg
 */
public class TcpClient {    
	
	public static void main(String str[]){
	
		System.out.println("Creating client socket: localhost:23777");
		TcpSocket socket = new TcpSocket("localhost",45645);
		System.out.println("Socket was connected successfully");
		
                
                
                
                
		while (true) {
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter a number: ");
			String input = reader.next();
			if (input.equalsIgnoreCase("quit")) {
				break;
			}
			socket.sendDataToSocket(input);
			input = socket.receiveDataFromSocket();
			System.out.println("Got from server: " + input);
		}
		socket.removeSocket();
		socket = null;
	}
}