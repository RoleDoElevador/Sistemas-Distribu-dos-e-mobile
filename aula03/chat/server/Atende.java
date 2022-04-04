package chat.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Atende  extends Thread {
    private Socket client;
    private Scanner input = null;
    private PrintStream output = null;
    private ArrayList<Atende> clientList;

    public Atende(Socket client, ArrayList<Atende> clientList){
        this.client = client;
        this.clientList = clientList;
    }

    @Override
    public void run() {


    //comunicação
    try {
        input = new Scanner(client.getInputStream());
        output = new PrintStream(client.getOutputStream());

        String recived;

        do {
            recived = input.nextLine();
            System.out.println("Recebido do Cliente: " + recived);
            for (Atende atende : clientList){
                atende.enviarMensagem(recived);
            }
            //output.println("Boa noite, cliente =D");
        } while (!recived.equals("exit"));

    } catch (Exception e) {
        System.out.println("Erro na comunicação...");
        System.out.println(e.getMessage());
    }
        
        //esperar a conexão
        try {
        input.close();
        output.close();
        client.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    }
    

    public void enviarMensagem(String msg) {
        output.println(msg);
    }
}