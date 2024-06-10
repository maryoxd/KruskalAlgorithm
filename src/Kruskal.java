import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
    int v;
    int h;
    int[][] H;
    int[] k;

    public Kruskal(int pocetVrcholov, int pocetHran) {
        this.v = pocetVrcholov;
        this.h = pocetHran;
        this.H = new int[this.h + 1][3];
        this.k = new int[v + 1];
    }

    public static Kruskal nacitanieSuboru(String nazovSuboru) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(nazovSuboru));

        int pocetVrcholov = 0;
        int pocetHran = 0;
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            pocetHran++;
            if (pocetVrcholov < a) {
                pocetVrcholov = a;
            }
            if (pocetVrcholov < b) {
                pocetVrcholov = b;
            }

        }
        sc.close();
        Kruskal g = new Kruskal(pocetVrcholov, pocetHran);
        sc = new Scanner(new FileInputStream(nazovSuboru));

        for (int i = 1; i < pocetHran; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            g.H[i][0] = a;
            g.H[i][1] = b;
            g.H[i][2] = c;
        }
        return g;
    }

    public void printInfo() {
        System.out.println("POČET VRCHOLOV: " + v);
        System.out.println("POČET HRÁN: " + h);
    }

    public Integer[] kruskal() {
        int[] ceny = new int[h + 1];

        for (int i = 1; i <= h; i++) {
            ceny[i] = H[i][2];
        }
        for (int i = 1; i <= v; i++) {
            k[i] = i;
        }
        Integer[] hrany = new Integer[h]; 
        for (int i = 0; i < h; i++) {
            hrany[i] = i;
        }
        Arrays.sort(hrany, Comparator.comparingInt(a -> ceny[a]));
        return hrany;
    }

    public void cenaKostry(Integer[] hrany) {
        int finalnaCena = 0;
        int pocetHranVkostre = 0;
        int[] kostra = new int[v - 1];

        Scanner sc = new Scanner(System.in);
        System.out.println("1. - Výpočet minimálnej ceny." + "\n2. - Výpočet maximálnej ceny.");
        int vyber = sc.nextInt();

        if (vyber == 1 || vyber == 2) {
            if (vyber == 1) {

                for (int i = 0; i < this.h; i++) {
                    pocetHranVkostre = getPocetHranVkostre(hrany, pocetHranVkostre, kostra, i);
                }
                if (pocetHranVkostre != this.v - 1) {
                    System.out.println("NEFUNGUJE");
                    return;
                }
                System.out.println("Kostra minimálnej hodnoty:");
                for (int i = 0; i < this.v - 1; i++) {
                    finalnaCena = getFinalnaCena(finalnaCena, kostra, i);
                }
                System.out.println();
                System.out.println("FINÁLNA CENA JE: " + finalnaCena);
            }
            if (vyber == 2) {
                for (int i = this.h - 1; i >= 0; i--) {
                    pocetHranVkostre = getPocetHranVkostre(hrany, pocetHranVkostre, kostra, i);
                }
                if (pocetHranVkostre != this.v - 1) {
                    System.out.println("NEFUNGUJE");
                    return;
                }
                System.out.println("Kostra maximálnej hodnoty:");
                int i = 0;
                while (i < this.v - 1) {
                    finalnaCena = getFinalnaCena(finalnaCena, kostra, i);
                    i++;
                }
                System.out.println();
                System.out.println("FINÁLNA CENA JE: " + finalnaCena);


            }
        }
    }

    private int getFinalnaCena(int finalnaCena, int[] kostra, int i) {
        int index = kostra[i];
        int u = H[index][0];
        int v = H[index][1];
        int cena = H[index][2];
        finalnaCena += cena;
        System.out.println("U: " + u + " V: " + v + " CENA: " + cena);
        return finalnaCena;
    }

    private int getPocetHranVkostre(Integer[] hrany, int pocetHranVkostre, int[] kostra, int i) {
        int hrana;
        hrana = hrany[i];

        int u = H[hrana][0];
        int v = H[hrana][1];
        int pu = najdi(u, k);
        int pv = najdi(v, k);

        if (pu != pv) {
            spoj(pu, pv, k);
            kostra[pocetHranVkostre++] = hrana;
        }
        return pocetHranVkostre;
    }

    public int najdi(int u, int[] k) {
        while (u != k[u]) {
            k[u] = k[k[u]];
            u = k[u];
        }
        return u;
    }

    public void spoj(int u, int v, int[] k) {
        k[u] = v;
    }

}
