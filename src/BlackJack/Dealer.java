package BlackJack;

import java.util.ArrayList;

public class Dealer extends Ludopatico{
    private int indice;

    public Dealer(String nome) {
        super(nome);
    }

    public void run() {

    }

    public void estraiCarta(Ludopatico x, Mazzo m){
         x.setMano(getMano() + m.getValoreCarta(indice));
         System.out.println(m.toString(indice));
         this.indice ++;
    }
    public void controllaVittoria(Ludopatico x){
    }

}

