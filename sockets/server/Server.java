package server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

 public static void main(String[] args) {
    
    ServerSocket serverSocket;
    Socket clientSocket = null;
    Scanner input = null;
    PrintStream output = null;

    //criar o socket e esperar a conexão
    final int PORT = 1234;

    try {
        serverSocket = new ServerSocket(PORT);
    } catch (Exception e) {
        System.out.println("Porta em uso...");
        System.out.println(e.getMessage());
        return;
    }

    //esperar a conexão
    try {
        System.out.println("Aguardando conexão...");
        clientSocket = serverSocket.accept();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    //comunicação

    try {
        input = new Scanner(clientSocket.getInputStream());
        output = new PrintStream(clientSocket.getOutputStream());

        String recived;

        do {
            recived = input.nextLine();
            System.out.println("Recebido do Cliente: " + recived);
            output.println("Boa noite, cliente =D");
        } while (!recived.equals("exit"));

    } catch (Exception e) {
        System.out.println("Erro na comunicação...");
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