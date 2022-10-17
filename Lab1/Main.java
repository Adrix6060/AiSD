

public class Main {
    public static void main(String[] args) {
/*
        //Wyszukiwanie trójek pitagorejskich

        System.out.println("Wyszukiwanie trojek pitagorejskich");
        int a, b, c, counterA = 0, counterB = 0, counterC = 0, counter = 0;
        int par = 20;

        for (a = 1; a <= par; a++) {
            counterA++;
            for (b = a + 1; b <= par; b++) {        //Pytanie: po co jest a+1?
                counterB++;
                for (c = b + 1; c <= par; c++) {
                    counterC++;
                    if (a * a + b * b == c * c) {
                        counter++;
                        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
                    }
                }
            }
        }
        System.out.println("Ilosc trojek: " + counter);
        System.out.println("Wykonania pętli(kolejno): " + counterA + " " + counterB + " " + counterC);


        //Wypisywanie podzbiorow zbioru o mocy N
        //Metoda pierwsza
        System.out.println("\n\n\n\nWypisywanie podzbiorow zbioru o mocy N(metoda pierwsza)");

        int b1, b2, b3, b4, b5, b6;
        for (b1 = 0; b1 <= 1; b1++)
            for (b2 = 0; b2 <= 1; b2++)
                for (b3 = 0; b3 <= 1; b3++)
                    for (b4 = 0; b4 <= 1; b4++)
                        for (b5 = 0; b5 <= 1; b5++)
                            for (b6 = 0; b6 <= 1; b6++) {
                                System.out.print("{ ");
                                if (b1 == 1) System.out.print("1 ");
                                if (b2 == 1) System.out.print("2 ");
                                if (b3 == 1) System.out.print("3 ");
                                if (b4 == 1) System.out.print("4 ");
                                if (b5 == 1) System.out.print("5 ");
                                if (b6 == 1) System.out.print("6 ");
                                System.out.println("}");
                            }

        //Druga metoda
        System.out.println("\n\n\n\nDruga metoda");
        int N = 3; //moc zbioru
        int[] tab = new int[N + 1]; //Tablica o liczbie zawsze większej o 1 niż N
        int s = (int) Math.pow(2, N); // Przypisanie do zmiennej s 2 do potęgi n

        for (int l = 1; l <= s; l++) {
            System.out.print("{ ");
            for (int i = 1; i <= N; i++) {
                if (tab[i - 1] == 1) System.out.print(i + " ");
            }
            System.out.println("}");

            int i = 0;
            do {
                if (tab[i] == 1) {
                    tab[i] = 0;
                    i++;
                } else {
                    tab[i] = 1;
                    break;
                }
            } while (true);
        }

 */
        //Zadanie 1
        plecak();

        //Zadanie 4
        kosmos();
    }


    public static void plecak() {
        System.out.println("\nDecyzyjny problem plecakowy");
        int objetoscPlecaka = 10;  //Objętosc plecaka
        int[] objetosci = {6,2,3,2,3,1};  //Objętości przedmiotów
        int[] wartosci = {6,4,5,7,10,2};  //Wartości przedmiotów

        int N = 6; //Ilosc przedmiotów
        int[] tab = new int[N + 1];  //Tablica o liczbie zawsze większej o 1 niż N
        int s = (int) Math.pow(2, N);  // Przypisanie do zmiennej s 2 do potęgi n

        int[] najlepszyPlecak = new int[N];
        int najlepszaWartosc = 0;

        for (int l = 0; l < s; l++) {
            int objetosc = 0; //Objetosc startowa
            int wartosc = 0; //Wartosc  startowa
            for (int i = 0; i < N; i++) {
                if (tab[i] == 1) {
                    wartosc += wartosci[i];
                    objetosc += objetosci[i];
                }

            }

            if (wartosc <= objetoscPlecaka) {
                if (objetosc > najlepszaWartosc) {
                    najlepszaWartosc = wartosc;
                    System.arraycopy(tab, 0, najlepszyPlecak, 0, N);
                }
            }

            int i = 0;
            do {
                if (tab[i] == 1) {
                    tab[i] = 0;
                    i++;
                } else {
                    tab[i] = 1;
                    break;
                }
            } while (true);
        }

        System.out.println("Najbardziej oplacalne wypelnienie plecaka to przedmioty o indeksach:");
        System.out.print("{ ");
        for (int i = 0; i < N; i++) {
            if (najlepszyPlecak[i] == 1) System.out.print(i + " ");
        }
        System.out.println("}");
        System.out.println("Wartosc plecaka to: " + najlepszaWartosc);
    }

    public static void kosmos(){
        System.out.println("\nDobor zalogi statku kosmicznego");
        int[][] kosmonauci = {         //wiersze-kosmonauci; kolumny-dziedziny
                {1, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };

        int N = 5; //ilosc kosmonautow
        int U = 4; //ilosc umiejetnosci
        int[] tab = new int[N+1];
        int s = (int)Math.pow(2,N);

        int[] najlepszyStatek = new int[N];
        int najlepszyCounter = N;

        for (int l=0; l<s; l++) {
            int[] status = new int[U];
            int counter = 0;
            boolean wszystko = true;

            for (int i=0; i<N;i++) {
                if (tab[i]==1) {
                    counter++;
                    for (int j=0;j<U;j++) {
                        if (status[j]==0 && kosmonauci[i][j]==1) {
                            status[j]=1;
                        }
                    }
                }
            }


            for (int i = 0; i<U; i++) {
                if (status[i]==0) {
                    wszystko = false;
                    break;
                }
            }

            if (wszystko && (najlepszyCounter >= counter)) {
                System.arraycopy(tab,0,najlepszyStatek,0,N);
                najlepszyCounter = counter;
            }

            int i=0;
            do {
                if (tab[i] == 1) {
                    tab[i] = 0;
                    i++;
                } else {
                    tab[i] = 1;
                    break;
                }
            } while (true);


        }

        System.out.println("Najlepiej, aby polecieli: ");
        for (int i=0;i<N;i++) {
            if (najlepszyStatek[i]==1) System.out.println("Kosmonauta nr " + (i+1));
        }
    }
    }
