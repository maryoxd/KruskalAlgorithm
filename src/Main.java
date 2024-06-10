import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Kruskal k = Kruskal.nacitanieSuboru("src\\Strakonice.hrn");
        k.printInfo();
        Integer[] pole = k.kruskal();
        k.cenaKostry(pole);
    }
}