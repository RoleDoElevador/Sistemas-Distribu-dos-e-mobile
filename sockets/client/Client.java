package client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
       
        Socket clientSocket = null;
        final int PORT = 1234;
        // final String IP = "127.0.0.1";
        final String IP = "10.159.122.91";
        // Scanner input  = null;       
        Scanner teclado = null;
        PrintStream output = null;

        //solicitar a conexão

        try {
            clientSocket = new Socket(IP, PORT); //criando e estanciando a conexão
        } catch (Exception e) {
            System.out.println("Não foi possível fazer a conexão...");
            System.out.println(e.getMessage());
            return;
        }

        //comunicação

        try {
            
            // input = new Scanner(clientSocket.getInputStream());
            teclado = new Scanner(System.in);
            output = new PrintStream(clientSocket.getOutputStream());

            // String recived;
            String message;

            do {
                // recived = input.nextLine();
                // System.out.println("Recebido: " + recived);
                System.out.println("Digite a mensagem para o Servidor: ");
                message = teclado.nextLine();
                output.println(message);
            } while (!message.equals("exit"));

        } catch (Exception e) {
            System.out.println("Erro na comunicação...");
            System.out.println(e.getMessage());
        }

        //encerrar a conexão
        try {
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
