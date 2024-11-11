package Prob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class MAIN
{
    private static List<ehipamente_electronice> echipamente = new ArrayList<>();

    private static void citireEchipamenteDinFisier(String fisier)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fisier)))
        {
            String linie;
            while ((linie = br.readLine()) != null)
            {
                String[] date = linie.split(";");
                String denumire = date[0];
                int nrInventar = Integer.parseInt(date[1]);
                float pret = Float.parseFloat(date[2]);
                String zonaMag = date[3];
                ehipamente_electronice.situatie situatie = ehipamente_electronice.situatie.valueOf(date[4]);
                ehipamente_electronice.tip tip = ehipamente_electronice.tip.valueOf(date[5].replace(" ", "_"));

                switch (tip)
                {
                    case imprimanta ->
                    {
                        int ppm = Integer.parseInt(date[6]);
                        String rezolutie = date[7];
                        int pCar = Integer.parseInt(date[8]);
                        imprimante.modul mod = imprimante.modul.valueOf(date[9].toLowerCase());
                        echipamente.add(new imprimante(denumire, nrInventar, pret, zonaMag, situatie, tip, ppm, rezolutie, pCar, mod));
                    }
                    case copiator ->
                    {
                        int pTon = Integer.parseInt(date[6]);
                        copiatoare.format format = copiatoare.format.valueOf(date[7]);
                        echipamente.add(new copiatoare(denumire, nrInventar, pret, zonaMag, situatie, tip, pTon, format));
                    }
                    case sistem_de_calcul ->
                    {
                        String tipMon = date[6];
                        float vitProc = Float.parseFloat(date[7]);
                        int cHdd = Integer.parseInt(date[8]);
                        Sisteme_calcul.sistem sistem = Sisteme_calcul.sistem.valueOf(date[9]);
                        echipamente.add(new Sisteme_calcul(denumire, nrInventar, pret, zonaMag, situatie, tip, tipMon, vitProc, cHdd, sistem));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        }
    }




    private static void afisareToateEchipamentele()
    {
        echipamente.forEach(System.out::println);
    }
    private static void afisareImprimante()
    {
        echipamente.stream().filter(e -> e instanceof imprimante).forEach(System.out::println);
    }
    private static void afsiareCopiatoare()
    {
        echipamente.stream().filter(e -> e instanceof copiatoare).forEach(System.out::println);
    }
    private static void afisareSistemeCalcul()
    {
        echipamente.stream().filter(e -> e instanceof Sisteme_calcul).forEach(System.out::println);
    }
    private static void modificareStareEchipament(Scanner scanner)
    {
        System.out.print("Dati numarul de inventar: ");
        int nrInventar = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Noua stare (achizitionat, expus, vandut): ");
        String nouaStare = scanner.nextLine();
        echipamente.stream()
                .filter(e -> e.getNr_inventar() == nrInventar)
                .findFirst()
                .ifPresent(e -> e.setSituatie(ehipamente_electronice.situatie.valueOf(nouaStare)));
    }
    private static void setareModScriereImprimanta(Scanner scanner)
    {
        System.out.print("Introduceți numărul de inventar: ");
        int nrInventar = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Noul mod de scriere (color, alb_negru): ");
        String modScriere = scanner.nextLine();
        echipamente.stream()
                .filter(e -> e instanceof imprimante && e.getNr_inventar() == nrInventar)
                .map(e -> (imprimante) e)
                .findFirst()
                .ifPresent(imp -> imp.setModul(imprimante.modul.valueOf(modScriere.toLowerCase())));
    }
    private static void setareFormatCopiereCopiator(Scanner scanner)
    {
        System.out.print("Introduceți numărul de inventar: ");
        int nrInventar = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Noul format de copiere (A3, A4): ");
        String format = scanner.nextLine();
        echipamente.stream()
                .filter(e -> e instanceof copiatoare && e.getNr_inventar() == nrInventar)
                .map(e -> (copiatoare) e)
                .findFirst()
                .ifPresent(cop -> cop.setFormat(copiatoare.format.valueOf(format)));
    }
    private static void instalareSistemOperareSistemCalcul(Scanner scanner)
    {
        System.out.print("Introduceți numărul de inventar: ");
        int nrInventar = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Noul sistem de operare (Windows, Linux): ");
        String sistem = scanner.nextLine();
        echipamente.stream()
                .filter(e -> e instanceof Sisteme_calcul && e.getNr_inventar() == nrInventar)
                .map(e -> (Sisteme_calcul) e)
                .findFirst()
                .ifPresent(sist -> sist.setSistem(Sisteme_calcul.sistem.valueOf(sistem)));
    }
    private static void afisareEchipamenteVandute()
    {
        echipamente.stream()
                .filter(e -> e.getSituatie() == ehipamente_electronice.situatie.vandut)
                .forEach(System.out::println);
    }




    public static void main(String[] args)
    {
        int opt;
        Scanner scanner = new Scanner(System.in);
        citireEchipamenteDinFisier("C:\\Users\\adigi\\IdeaProjects\\Lab4\\src\\Prob\\echipamente.txt");


        do
        {
            System.out.println("\n--- Meniu Principal ---");
            System.out.println("1. Afisarea tuturor echipamentelor");
            System.out.println("2. Afisarea imprimantelor");
            System.out.println("3. Afisarea copiatoarelor");
            System.out.println("4. Afisarea sistemelor de calcul");
            System.out.println("5. Modificarea starii unui echipament");
            System.out.println("6. Setarea modului de scriere pentru o imprimanta");
            System.out.println("7. Setarea formatului de copiere pentru copiatoare");
            System.out.println("8. Instalarea unui sistem de operare pe un sistem de calcul");
            System.out.println("9. Afisarea echipamentelor vandute");
            System.out.println("10. Salvare echipamente în echip.bin (serializare)");
            System.out.println("11. Citire echipamente din echip.bin (deserializare)");
            System.out.println("0. Iesire");
            System.out.print("Alegeti o opțiune: ");
            opt=scanner.nextInt();
            switch(opt)
            {
                case 1:afisareToateEchipamentele();break;
                case 2:afisareImprimante();break;
                case 3:afsiareCopiatoare();break;
                case 4:afisareSistemeCalcul();break;
                case 5:modificareStareEchipament(scanner);break;
                case 6:setareModScriereImprimanta(scanner);break;
                case 7:setareFormatCopiereCopiator(scanner);break;
                case 8:instalareSistemOperareSistemCalcul(scanner);break;
                case 9:afisareEchipamenteVandute();break;
                case 10:break;
                case 11:break;
                case 0:exit(0);break;

            }
        }
        while (opt!=0);
    }
}
