package BlackJack;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Dealer extends Ludopatico{
    private static int indiceNome;
    public static int indice;
    private ArrayList <Ludopatico> tavolo;


    public Dealer(String nome) {
        super(nome);
        indice = 0;
        indiceNome = 1;
        tavolo = new ArrayList<>(5);
    }

    public void run() {
        Mazzo mazzo = new Mazzo();
        Semaphore postidisponibili = new Semaphore (5);
        // aggiunta giocatori al tavolo
        while(true) {
            int pos = postidisponibili.availablePermits();
            for (int i = 0; i < pos; i++) {
                try {
                    this.aggiungiGiocatore();
                    postidisponibili.acquire();
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
            // primo giro di carte
            for (int i = 0; i < 2; i++) {
                try {
                    this.estraiCarta(mazzo);
                    TimeUnit.SECONDS.sleep(3);
                }catch (Exception e) {
                    System.out.println(e);
                }
                for (int j = 0; j < 5; j++) {
                    try {
                        this.estraiCarta(mazzo, j);
                        TimeUnit.SECONDS.sleep(3);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
            // pesca carte
            for (int i = 0; i < tavolo.size(); i++) {
                while (tavolo.get(i).controllaMano()) {
                    try {
                        this.estraiCarta(mazzo, i);
                        TimeUnit.SECONDS.sleep(3);
                    }catch (Exception e) {
                        System.out.println(e);
                    }
                }
                if (tavolo.get(i).getMano() > 21) {
                    try {
                        tavolo.get(i).setVincente(false);
                        System.out.println(tavolo.get(i).getNome() + " ha sforato: " + tavolo.get(i).getMano());
                        TimeUnit.SECONDS.sleep(3);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
            // pesca carte banco
            while (this.controllaMano()) {
                this.estraiCarta(mazzo);
            }
            if (this.getMano() > 21) {
                try {
                    this.setVincente(false);
                    System.out.println("il banco ha sforato: " + this.getMano());
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            //controllo vittoria
            for (int i = 0; i < tavolo.size(); i++) {
                if (this.getVincente() && tavolo.get(i).getVincente()) {
                    if (tavolo.get(i).getMano() > this.getMano()) {
                        try {
                            System.out.println(tavolo.get(i).getNome() + ": ha vinto");
                            TimeUnit.SECONDS.sleep(3);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        try {
                            System.out.println(tavolo.get(i).getNome() + ": ha perso e abbandonato la partita");
                            tavolo.remove(i);
                            postidisponibili.release();
                            TimeUnit.SECONDS.sleep(3);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else if (this.getVincente() == false) {
                    if (tavolo.get(i).getVincente()) {
                        try {
                            System.out.println(tavolo.get(i).getNome() + ": ha vinto");
                            TimeUnit.SECONDS.sleep(3);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        try {
                            System.out.println(tavolo.get(i).getNome() + ": ha perso e abbandonato la partita");
                            tavolo.remove(i);
                            postidisponibili.release();
                            TimeUnit.SECONDS.sleep(3);
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                    }
                }

            }
            //resetta carte
            for(int i = 0; i < tavolo.size(); i++){
                tavolo.get(i).setMano(0);
            }
            this.setMano(0);
        }

    }

    public void estraiCarta(Mazzo m, int i){
         tavolo.get(i).setMano(tavolo.get(i).getMano() + m.getValoreCarta(indice));
         System.out.println(tavolo.get(i).getNome() + ": " + m.toString(indice) + " la sua mano: " + tavolo.get(i).getMano());
         indice ++;
    }
    public void estraiCarta(Mazzo m){
        this.setMano(this.getMano() + m.getValoreCarta(indice));
        System.out.println("il banco ha pescato: " + m.toString(indice) + " la sua mano: " + this.getMano());
        indice ++;
    }


    public void aggiungiGiocatore(){
        Ludopatico l = new Ludopatico("giocatore " + indiceNome);
        System.out.println(l.getNome() + " si è unito al tavolo");
        indiceNome ++;
        tavolo.add(l);
        l.start();

    }
}

