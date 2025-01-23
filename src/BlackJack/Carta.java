package BlackJack;

public class Carta {

    private String numero;
    private String seme;
    private int valore;


    public Carta(String numero, String seme, int valore) {
        this.numero = numero;
        this.seme = seme;
        this.valore = valore;
    }

    public String getNumero() {
        return numero;
    }

    public String getSeme() {
        return seme;
    }

    public int getValore(){
        return valore;
    }




    public String toString() {
        return  this.numero + " di " + this.seme;
    }

}

