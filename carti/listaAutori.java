package carti;

import java.util.ArrayList;
import java.util.Scanner;

public class listaAutori{

    public static ArrayList<String> lista = new ArrayList<String>();

    public static void intializeArrayList(listaAutori l1){
        l1.lista.add("Ileana Vulpescu");
        l1.lista.add("Victor Hugo");
        l1.lista.add("Liviu Rebreanu");
        l1.lista.add("Ion Creanga");
        l1.lista.add("George Topirceanu");
        l1.lista.add("Ion Mihai Pacepa");
        l1.lista.add("George Calinescu");
        l1.lista.add("Tudor Vianu");
        l1.lista.add("Perpessicius");
        l1.lista.add("Ernest Hemingway");
        l1.lista.add("William Shakespeare");
        l1.lista.add("Henry James");
        l1.lista.add("Honore de Balzac");
        l1.lista.add("Jean de la Fontaine");
        l1.lista.add("Albert Camus");
        l1.lista.add("Amelie Nothomb");
        l1.lista.add("Andrzej Sapkowski");
    }

    private static class autor extends listaAutori {

        protected static int idAutor;
        protected final String numeAutor;

        {
            idAutor++;
        }

        protected autor(String nume){
            super();
            numeAutor = nume;
            listaAutori.lista.add(nume);
        }

        public static void printInfo(autor a){
            System.out.println(a.idAutor + ". " + a.numeAutor + "\n");
        }



        public static void main(String[] args){

            listaAutori l1 = new listaAutori();
            Scanner scanCase1 = new Scanner(System.in);
            System.out.println("Cum doriti sa existe autorii?\n1. Predefiniti\n2. Dati de la tastatura");
            int nrCase = scanCase1.nextInt();
            if(nrCase == 1){
                intializeArrayList(l1);
                System.out.println("\n" + l1.lista);
            }
            else if(nrCase == 2){

                Scanner scanNr1 = new Scanner(System.in);
                System.out.println("Dati numarul de autori pe care doriti sa ii adaugati:");
                int nr1 = scanNr1.nextInt();
                for(int i = 0; i < nr1; i++){
                    Scanner scan1 = new Scanner(System.in);
                    System.out.println("Dati numele unui autor: ");
                    String text1 = scan1.nextLine();
                    autor a1 = new autor(text1);
                    printInfo(a1);
                }
                System.out.println("\n" + l1.lista);
            }
            else{
                System.out.println("Numarul dat nu se afla printre optiuni!");
                return;
            }

            Scanner scanCase2 = new Scanner(System.in);
            System.out.println("\nCe operatie doriti sa efectuati?\n1. Eliminati un autor dupa index\n2. Cautati un autor dupa index");
            int nrCase2 = scanCase2.nextInt();
            if(nrCase2 == 1){
                Scanner scanIndexRemove = new Scanner(System.in);
                System.out.println("Dati indexul pentru elementul pe care doriti sa il eliminati!\nATENTIE!!! Acesta nu poate fi mai mare de " + l1.lista.size() + " sau mai mic decat 0!");
                int index1 = scanIndexRemove.nextInt();
                System.out.println("Lista inainte de eliminare: " + l1.lista);
                l1.lista.remove(index1 - 1);
                System.out.println("Lista dupa eliminare: " + l1.lista);
            }
            else if(nrCase2 == 2){
                Scanner scanIndexSearch = new Scanner(System.in);
                System.out.println("Dati indexul pentru elementul pe care doriti sa il cautati!\nATENTIE!!! Acesta nu poate fi mai mare de " + l1.lista.size() + " sau mai mic decat 0!");
                int index2 = scanIndexSearch.nextInt();
                System.out.println("Autorul de pe pozitia " + index2 + " este " + l1.lista.get(index2 - 1) + "!");
            }
            else{
                System.out.println("Numarul dat nu se afla printre optiuni!");
                return;
            }

        }

    }

}