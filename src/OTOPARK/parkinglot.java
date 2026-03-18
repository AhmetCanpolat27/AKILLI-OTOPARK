

package OTOPARK;

import java.time.Duration;
import java.util.ArrayList;

public class parkinglot {

    private int capacity;
    private ArrayList<vehicle> vehicles = new ArrayList<>();
    private double totalearn = 0;

    public parkinglot(int capacity) {
        this.capacity = capacity;
    }

    public void addvehicle(String plate, String type) {

        if(getinsidecount() >= capacity) {
            System.out.println("otopark dolu");
            return;
        }

        vehicle v = findvehicle(plate);

        if(v != null && v.isinside()) {
            System.out.println("bu arac zaten var");
            return;
        }

        vehicles.add(new vehicle(plate,type));
        System.out.println("arac girisi yapildi");
    }

    public void removevehicle(String plate) {

        vehicle v = findvehicle(plate);

        if(v == null || !v.isinside()) {
            System.out.println("arac bulunamadi");
            return;
        }

        v.exitvehicle();
        double ucret = calculatefee(v);
        totalearn += ucret;

        System.out.println("arac cikisi yapildi");
        System.out.println("ucret: " + ucret + " tl");
    }

    public vehicle findvehicle(String plate) {
        for(int i=0;i<vehicles.size();i++) {
            if(vehicles.get(i).getplate().equalsIgnoreCase(plate)) {
                return vehicles.get(i);
            }
        }
        return null;
    }

    public int getinsidecount() {
        int sayi = 0;
        for(int i=0;i<vehicles.size();i++) {
            if(vehicles.get(i).isinside()) {
                sayi++;
            }
        }
        return sayi;
    }

    public int emptyplaces() {
        return capacity - getinsidecount();
    }

    public void showstatus() {
        System.out.println("toplam kapasite: " + capacity);
        System.out.println("icerde arac sayisi: " + getinsidecount());
        System.out.println("bos yer sayisi: " + emptyplaces());
    }

    public void listvehicles() {
        boolean durum = false;
        System.out.println("---- araclar ----");
        for(int i=0;i<vehicles.size();i++) {
            if(vehicles.get(i).isinside()) {
                System.out.println(vehicles.get(i).tostring());
                durum = true;
            }
        }

        if(durum == false) {
            System.out.println("otoparkta arac yok");
        }
    }

    public double calculatefee(vehicle v) {
        if(v.getexittime() == null) {
            return 0;
        }

        long dakika = Duration.between(v.getentrytime(), v.getexittime()).toMinutes();
        long saat = dakika / 60;

        if(dakika % 60 != 0) {
            saat++;
        }

        if(saat == 0) {
            saat = 1;
        }

        return saat * 50;
    }

    public void report() {
        System.out.println("---- gun sonu raporu ----");
        System.out.println("toplam kayit: " + vehicles.size());
        System.out.println("icerde kalan arac: " + getinsidecount());
        System.out.println("toplam kazanc: " + totalearn + " tl");
    }
}


