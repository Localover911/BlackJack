package BlackJack;

public class MainDiProva {
    public static void main(String[] args) {
        Mazzo mazzo = new Mazzo();
        for (int i = 0; i < 312; i++){
            System.out.println(mazzo.toString(i));
        }
    }
}
