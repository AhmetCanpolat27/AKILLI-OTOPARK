package OTOPARK;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        parkinglot p = new parkinglot(10);
        int secim = -1;

        while(secim != 0) {

            System.out.println("\n1-arac girisi");
            System.out.println("2-arac cikisi");
            System.out.println("3-plaka ara");
            System.out.println("4-otopark durumu");
            System.out.println("5-icerdeki araclar");
            System.out.println("6-gun sonu raporu");
            System.out.println("0-cikis");
            System.out.print("secim: ");

            secim = input.nextInt();
            input.nextLine();

            if(secim == 1) {
                String plate,type;
                System.out.print("plaka: ");
                plate = input.nextLine();
                System.out.print("tur: ");
                type = input.nextLine();
                p.addvehicle(plate, type);
            }

            else if(secim == 2) {
                String plate;
                System.out.print("plaka: ");
                plate = input.nextLine();
                p.removevehicle(plate);
            }

            else if(secim == 3) {
                String plate;
                System.out.print("aranacak plaka: ");
                plate = input.nextLine();

                vehicle v = p.findvehicle(plate);

                if(v != null) {
                    System.out.println("arac bulundu");
                    System.out.println(v.tostring());
                }
                else {
                    System.out.println("arac yok");
                }
            }

            else if(secim == 4) {
                p.showstatus();
            }

            else if(secim == 5) {
                p.listvehicles();
            }

            else if(secim == 6) {
                p.report();
            }

            else if(secim == 0) {
                System.out.println("program kapandi");
            }

            else {
                System.out.println("hatali secim");
            }
        }

        input.close();
    }
}