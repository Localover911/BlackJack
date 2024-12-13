package BlackJack;

public class Ludopatico extends Thread {
    private final String nome;
    private int mano;
    private boolean vincente;

    public Ludopatico(String nome ) {
        this.nome = nome;
        this.mano = 0;
        this.vincente=true;
    }

    @Override
    public void run() {

    }

    public String getNome() {
        return nome;
    }
    public int getMano(){
        return this.mano;
    }
    public void setMano(int mano){
        this.mano = mano;
    }
    public boolean getVincente(){
        return this.vincente;
    }
    public void setVincente(boolean Vincente){
        this.vincente = vincente;
    }




}