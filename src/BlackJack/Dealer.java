package BlackJack;

import java.util.ArrayList;

public class Dealer extends Ludopatico{
    private static int indiceNome;
    public static int indice;
    private ArrayList <Ludopatico> tavolo;


    public Dealer(String nome) {
        super(nome);
        indice = 0;
        tavolo = new ArrayList<>(5);
    }

    public void run() {
        for (int i = 0; i < 5; i ++){
            this.aggiungiGiocatore();
        }
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 5; j ++){
                this.estraiCarta(Mazzo.getMazzo(), indice);
            }
        }

    }

    public void estraiCarta(Mazzo m, int i){
         tavolo.get(i).setMano(getMano() + m.getValoreCarta(indice));
         System.out.println(m.toString(indice));
         indice ++;
    }

    public void aggiungiGiocatore(){
        Ludopatico l = new Ludopatico("giocatore" + indiceNome);
        tavolo.add(l);
        l.start();
    }


// mettere i semafori sul controllo della vittoria del ludopatico
}

