package threads;

public class myThread  extends Thread {

    public myThread(String nome) {
        super(nome);

    }

        @Override
        public void run() {
            System.out.println("Thread " + getName() + " iniciou");

            try {
                sleep(2000); //dorme por 2 seg
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Thread " + getName() + " finalizou");
    }

}