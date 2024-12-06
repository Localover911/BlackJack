package BlackJack;

public class Ludopatico extends Thread {
    private final String nome;

    public Ludopatico(String nome ) {
        this.nome = nome;
    }

    @Override
    public void run() {

    }

    public String getNome() {
        return nome;
    }




}