package cititori;

import java.util.ArrayList;
import java.util.Scanner;

public class listaCititori {

    public static ArrayList<String> listaNume = new ArrayList<String>();
    public static ArrayList<String> listaTari = new ArrayList<String>();

    public static class cititor extends listaCititori{

        protected static int idCititor;
        public String numeCititor;
        public String taraCititor;

        {
            idCititor++;
        }

        public cititor(String nume, String tara){
            super();
            numeCititor = nume;
            taraCititor = tara;
            listaCititori.listaNume.add(nume);
            listaCititori.listaTari.add(tara);
        }

        public static void printInfo(cititor c){
            System.out.println(c.idCititor + ". " + c.numeCititor + " din " + c.taraCititor);
        }

        public static void initializeArrayListCititori(listaCititori l1){
            l1.listaNume.add("Alexandru Gherman");
            l1.listaTari.add("Romania");
            l1.listaNume.add("Zamfira Cristescu");
            l1.listaTari.add("Romania");
            l1.listaNume.add("Andrei Pop");
            l1.listaTari.add("Romania");
            l1.listaNume.add("Alec Jackson");
            l1.listaTari.add("Statele Unite ale Americii");
            l1.listaNume.add("George Grisham");
            l1.listaTari.add("Statele Unite ale Americii");
            l1.listaNume.add("Johann Kellner");
            l1.listaTari.add("Germania");
            l1.listaNume.add("Morgane Guellec");
            l1.listaTari.add("Franta");
            l1.listaNume.add("Alain Cayette");
            l1.listaTari.add("Franta");
        }

        public static void main(String[] args){

            listaCititori l1 = new listaCititori();
            Scanner scanCase1 = new Scanner(System.in);
            System.out.println("Cum doriti sa existe citiorii?\n1. Predefiniti\n2. Dati de la tastatura");
            int nrCase = scanCase1.nextInt();
            if(nrCase == 1){
                initializeArrayListCititori(l1);
                System.out.println("\nNume: " + l1.listaNume + "\nTari: " + l1.listaTari);
            }
            else if(nrCase == 2){
                Scanner scanNr1 = new Scanner(System.in);
                System.out.println("Dati numarul de cititori pe care doriti sa ii adaugati");
                int nr1 = scanNr1.nextInt();
                for(int i = 0; i < nr1; i++){
                    Scanner scan1 = new Scanner(System.in);
                    System.out.println("Dati numele unui cititor: ");
                    String nume1 = scan1.nextLine();
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("Dati tara de provenienta a citiorului: ");
                    String nume2 = scan2.nextLine();
                    cititor c1 = new cititor(nume1, nume2);
                    printInfo(c1);
                }
                System.out.println("\nNume: " + l1.listaNume + "\nTari: " + l1.listaTari);
            }
            else{
                System.out.println("Numarul dat nu se afla printre optiuni!");
                return;
            }

            Scanner scanCase2 = new Scanner(System.in);
            System.out.println("\nCe operatie doriti sa efectuati?\n1. Eliminati un citior dupa index\n2. Cautati un cititor dupa index\n3. Modificati numele unui citior dupa index\n4. Modificati tara de provenienta a unui cititor dupa index");
            int nrCase2 = scanCase2.nextInt();
            if(nrCase2 == 1){
                Scanner scanIndexRemove = new Scanner(System.in);
                System.out.println("Dati indexul pentru elementul pe care doriti sa il eliminati!\nATENTIE!!! Acesta nu poate fi mai mare de " + l1.listaNume.size() + " sau mai mic decat 0!");
                int index1 = scanIndexRemove.nextInt();
                System.out.println("\nListele inainte de eliminare: \nNume: " + l1.listaNume + "\nTari: " + l1.listaTari);
                l1.listaNume.remove(index1 - 1);
                l1.listaTari.remove(index1 - 1);
                System.out.println("\nListele dupa eliminare: \nNume: " + l1.listaNume + "\nTari: " + l1.listaTari);
            }
            else if(nrCase2 == 2){
                Scanner scanIndexSearch = new Scanner(System.in);
                System.out.println("Dati indexul pentru elementul pe care doriti sa il cautati!\nATENTIE!!! Acesta nu poate fi mai mare de " + l1.listaNume.size() + " sau mai mic decat 0!");
                int index2 = scanIndexSearch.nextInt();
                System.out.println("Cititorul de pe pozitia " + index2 + " este " + l1.listaNume.get(index2 - 1) + " si locuieste in " + l1.listaTari.get(index2 - 1) + "!");
            }
            else if(nrCase2 == 3){
                Scanner scanIndexChange1 = new Scanner(System.in);
                System.out.println("Dati indexul pentru elementul pe care doriti sa il schimbati!");
                int index3 = scanIndexChange1.nextInt();
                System.out.println("Persoana de pe pozitia " + index3 + " este " + l1.listaNume.get(index3) + "!\n");
                Scanner scanNume = new Scanner(System.in);
                System.out.println("Dati numele cu care vreti sa inlocuiti!");
                String numeOm = scanNume.nextLine();
                System.out.println("\nListele inainte de schimbare: \nNume: " + l1.listaNume + "\nTari: " + l1.listaTari);
                l1.listaNume.set(index3 - 1, numeOm);
                System.out.println("\nListele dupa schimbare: \nNume: " + l1.listaNume + "\nTari: " + l1.listaTari);
            }
            else if(nrCase2 == 4){
                Scanner scanIndexChange1 = new Scanner(System.in);
                System.out.println("Dati indexul pentru elementul pe care doriti sa il schimbati!");
                int index4 = scanIndexChange1.nextInt();
                System.out.println("Tara de pe pozitia " + index4 + " este " + l1.listaTari.get(index4) + "!\n");
                Scanner scanTara = new Scanner(System.in);
                System.out.println("Dati noua tara din care provine persoana!");
                String numeTara = scanTara.nextLine();
                System.out.println("\nListele inainte de schimbare: \nNume: " + l1.listaNume + "\nTari: " + l1.listaTari);
                l1.listaTari.set(index4 - 1, numeTara);
                System.out.println("\nListele dupa schimbare: \nNume: " + l1.listaNume + "\nTari: " + l1.listaTari);
            }
            else{
                System.out.println("Numarul dat nu se afla printre optiuni!");
                return;
            }

        }

    }

}
