package BlackJack;

public class Ludopatico extends Thread {
    private final String nome;
    private int mano;
    private boolean vincente;

    public Ludopatico(String nome) {
        this.nome = nome;
        this.mano = 0;
        this.vincente=true;
    }


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
    public void setVincente(boolean vincente){
        this.vincente = vincente;
    }
    public boolean controllaMano(){
            if (this.mano < 16){
                return true;
            }
            return false;
        }

    public String cartaoStai (boolean carta, int i){
        if (carta){
            return this.getNome() + ": ha chiesto carta";

        }else{
            return this.getNome() + ": decide di stare";
        }
    }
}