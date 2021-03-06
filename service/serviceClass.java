package service;

import carti.*;
import cititori.listaCititori;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static carti.listaAutori.intializeArrayList;
import static carti.listaTitluri.initializeHashMap;
import static cititori.listaCititori.cititor.initializeArrayListCititori;

public class serviceClass {
    public static void main(String[] args){
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Introduceti numele dumneavoastra!");
        String nume = scan1.nextLine();
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Introduceti tara de provenienta!");
        String tara = scan2.nextLine();
        listaCititori.cititor c1 = new listaCititori.cititor(nume, tara);
        System.out.println("Numele dumneavoastra este " + c1.numeCititor + " si locuiti in " + c1.taraCititor + "!\n\nCe ati dori sa faceti acum?\n1. Afiseaza cartile din inventar\n2. Afiseaza autorii din inventar\n3. Salveaza lista cu cartile si autorii lor pe disc\n4. Salveaza lista cu cititorii pe disc");
        Scanner scan3 = new Scanner(System.in);
        int nrAlegere1 = scan3.nextInt();
        if(nrAlegere1 == 1){
            listaTitluri l1 = new listaTitluri();
            initializeHashMap(l1);
            System.out.println(l1.lista);
            Scanner scan4 = new Scanner(System.in);
            System.out.println("Doriti sa imprumutati o carte?\n1. Da\n2. Nu");
            int nrAlegere2 = scan4.nextInt();
            if(nrAlegere2 == 1){
                Scanner scanIndexRemove = new Scanner(System.in);
                System.out.println("Dati indexul pentru cartea pe care doriti sa o imprumutati!");
                int index1 = scanIndexRemove.nextInt();
                System.out.println("Ati imprumutat cartea " + l1.lista.get(index1) + "!");
                l1.lista.remove(index1);
                System.out.println("Cartile ramase in inventar:\n" + l1.lista);
            }
            else if(nrAlegere2 == 2){
                System.out.println("Ne pare rau!\nO zi buna, " + c1.numeCititor + "!");
                return;
            }
            else{
                System.out.println("Optiunea aceasta nu exista!");
            }
        }
        else if(nrAlegere1 == 2){
            listaAutori l2 = new listaAutori();
            intializeArrayList(l2);
            System.out.println(l2.lista);
            Scanner scan4 = new Scanner(System.in);
            System.out.println("Doriti sa imprumutati de la un autor anume?\n1. Da\n2. Nu");
            int nrAlegere2 = scan4.nextInt();
            if(nrAlegere2 == 1){
                Scanner scanIndexRemove = new Scanner(System.in);
                System.out.println("Dati indexul autorului al carei carti doriti sa o imprumutati!\nATENTIE!!! Acesta nu poate fi mai mare de " + l2.lista.size() + " sau mai mic decat 0!");
                int index1 = scanIndexRemove.nextInt();
                System.out.println("Ati imprumutat cartea scrisa de " + l2.lista.get(index1) + "!");
                l2.lista.remove(index1);
                System.out.println("Autorii ramasi in inventar:\n" + l2.lista);
            }
            else if(nrAlegere2 == 2){
                System.out.println("Ne pare rau!\nO zi buna, " + c1.numeCititor + "!");
                return;
            }
            else {
                System.out.println("Optiunea aceasta nu exista!");
            }
        }
        else if(nrAlegere1 == 3){
            try (PrintWriter writer = new PrintWriter("carti_autori.csv")){
                StringBuilder sb = new StringBuilder();
                sb.append("ID carte");
                sb.append(",");
                sb.append("Nume carte");
                sb.append(",");
                sb.append("Nume autor");
                sb.append("\n");

                listaTitluri l1 = new listaTitluri();
                initializeHashMap(l1);
                listaAutori l2 = new listaAutori();
                intializeArrayList(l2);
                int len = l1.lista.size();

                for(int i = 0; i < len; i++){
                    sb.append(i+1);
                    sb.append(",");
                    sb.append(l1.lista.get(i+1));
                    sb.append(",");
                    sb.append(l2.lista.get(i));
                    sb.append("\n");
                }

                writer.write(sb.toString());

                System.out.println("Lista cu titlurile din stoc si autorii lor a fost salvata pe disc!\n");
            }
            catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        else if(nrAlegere1 == 4){
            try (PrintWriter writer = new PrintWriter("cititori.csv")){
                StringBuilder sb = new StringBuilder();
                sb.append("ID cititor");
                sb.append(",");
                sb.append("Nume cititor");
                sb.append(",");
                sb.append("Tara cititor");
                sb.append("\n");

                listaCititori l3 = new listaCititori();
                initializeArrayListCititori(l3);
                int len = l3.listaNume.size();

                for(int i = 0; i < len; i++){
                    sb.append(i+1);
                    sb.append(",");
                    sb.append(l3.listaNume.get(i));
                    sb.append(",");
                    sb.append(l3.listaTari.get(i));
                    sb.append("\n");
                }

                writer.write(sb.toString());

                System.out.println("Lista cu cititorii a fost salvata pe disc!\n");
            }
            catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("Optiunea aceasta nu exista!");
        }

        System.out.println("\nO zi buna, " + c1.numeCititor + "!");

    }

}
