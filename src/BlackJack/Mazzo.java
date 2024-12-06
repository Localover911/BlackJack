package BlackJack;


public class Mazzo {
    public static final String[] nmr = {"asso", "2", "3", "4", "5", "6", "7", "8", "9", "10", "fante", "regina", "re"};
    public static final String[] sm = {"quadri", "cuori", "fiori", "picche"};
    Carta[] mazzo = new Carta[52];

    public Mazzo() {
        int i = 0;
        for (int s = 0; s < 4; s++) {
            for (int n = 0; n < 13; n++) {
                this.mazzo[i] = new Carta(nmr[n], sm[s]);
            }
        }
        this.mescola();
    }

    public void scambia(int i, int j) {
        Carta x;
        x = this.mazzo[i];
        this.mazzo[i] = this.mazzo[j];
        this.mazzo[j] = x;
    }

    public void mescola() {
        for (int i = this.mazzo.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            this.scambia(i, j);
        }

    }
}
