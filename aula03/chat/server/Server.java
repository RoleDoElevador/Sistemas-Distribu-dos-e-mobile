package chat.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {

    private static ArrayList<Atende> clients;
 public static void main(String[] args) {
    
    ServerSocket serverSocket;
    Socket clientSocket = null;
 

    //criar o socket e esperar a conexão
    final int PORT = 1234;

    try {
        serverSocket = new ServerSocket(PORT);
        clients = new ArrayList<>();
    } catch (Exception e) {
        System.out.println("Porta em uso...");
        System.out.println(e.getMessage());
        return;
    }

    //esperar a conexão
    try {
        while(true) {
        System.out.println("Aguardando conexão...");
        clientSocket = serverSocket.accept();
        Atende a = new Atende(clientSocket, clients);
        clients.add(a);
        a.start();
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }


    //encerrar conexão
    try {
        clientSocket.close();
        serverSocket.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

 }   

}