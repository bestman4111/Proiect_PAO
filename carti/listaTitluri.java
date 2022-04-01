package carti;

import java.util.HashMap;
import java.util.Scanner;

public class listaTitluri {

    public static HashMap<Integer, String> lista = new HashMap<Integer, String>();

    public static void initializeHashMap(listaTitluri l1){
        l1.lista.put(1, "Arta conversatiei");
        l1.lista.put(2, "Notre-Dame de Paris");
        l1.lista.put(3, "Padurea Spanzuratilor");
        l1.lista.put(4, "Amintiri din copilarie");
        l1.lista.put(5, "Balade vesele si triste");
        l1.lista.put(6, "Orizonturi rosii");
        l1.lista.put(7, "Istoria literaturii romane de la origini pana in prezent");
        l1.lista.put(8, "Scriitori romani din secolul XX");
        l1.lista.put(9, "Eminseciana");
        l1.lista.put(10, "A Farewell to Arms");
        l1.lista.put(11, "Hamlet");
        l1.lista.put(12, "The Portrait of a Lady");
        l1.lista.put(13, "Eugenie Grandet");
        l1.lista.put(14, "Fables");
        l1.lista.put(15, "La Peste");
        l1.lista.put(16, "Stupeur et tremblements");
        l1.lista.put(17, "Domnita Lacului");
    }

    protected static class carte extends listaTitluri {

        protected static int idCarte;
        protected final String numeCarte;

        {
            idCarte++;
        }

        protected carte(String nume){
            super();
            numeCarte = nume;
            listaTitluri.lista.put(idCarte, numeCarte);
        }

        public static void printInfo(listaTitluri.carte a){
            System.out.println(a.idCarte + ". " + a.numeCarte + "\n");
        }



        public static void main(String args[]) {

            listaTitluri l1 = new listaTitluri();
            Scanner scanCase = new Scanner(System.in);
            System.out.println("Cum doriti sa existe cartile?\n1. Predefinite\n2. Date de la tastatura");
            int nrCase = scanCase.nextInt();
            if(nrCase == 1){
                initializeHashMap(l1);
                System.out.println("\n" + l1.lista);
            }
            else if(nrCase == 2){
                Scanner scanNr1 = new Scanner(System.in);
                System.out.println("Dati numarul de carti pe care doriti sa le adaugati:");
                int nr1 = scanNr1.nextInt();
                for(int i = 0; i < nr1; i++){
                    Scanner scan1 = new Scanner(System.in);
                    System.out.println("Dati numele unei carti: ");
                    String text1 = scan1.nextLine();
                    carte c1 = new carte(text1);
                    printInfo(c1);
                }
                System.out.println("\n" + l1.lista);
            }
            else{
                System.out.println("Numarul dat nu se afla printre optiuni!");
                return;
            }
            Scanner scanCase2 = new Scanner(System.in);
            System.out.println("\nCe operatie doriti sa efectuati?\n1. Eliminati o carte dupa index\n2. Schimbati numele unei carti din lista dupa index");
            int nrCase2 = scanCase2.nextInt();
            if(nrCase2 == 1){
                Scanner scanIndexRemove = new Scanner(System.in);
                System.out.println("Dati indexul pentru elementul pe care doriti sa il eliminati!");
                int index1 = scanIndexRemove.nextInt();
                System.out.println("Lista inainte de eliminare: " + l1.lista);
                l1.lista.remove(index1);
                System.out.println("Lista dupa eliminare: " + l1.lista);
            }
            else if(nrCase2 == 2){
                Scanner scanIndexChange = new Scanner(System.in);
                System.out.println("Dati indexul pentru elementul pe care doriti sa il schimbati!");
                int index2 = scanIndexChange.nextInt();
                Scanner scanNumeCarte = new Scanner(System.in);
                System.out.println("Dati numele noii carti!");
                String numeCarte = scanNumeCarte.nextLine();
                l1.lista.replace(index2, numeCarte);
                System.out.println("Noua lista: " + l1.lista);
            }
            else{
                System.out.println("Numarul dat nu se afla printre optiuni!");
                return;
            }

        }
    }

}