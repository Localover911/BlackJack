package BlackJack;

public class MainDiProva {
    public static void main(String[] args) {
        Mazzo mazzo = new Mazzo();
        Thread dealer = new Dealer ("dealer");
        dealer.start();


    }
}

