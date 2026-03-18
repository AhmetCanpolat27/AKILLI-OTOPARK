package OTOPARK;


import java.time.LocalDateTime;

public class vehicle {

    private String plate;
    private String type;
    private LocalDateTime entrytime;
    private LocalDateTime exittime;
    private boolean inside;

    public vehicle(String plate, String type) {
        this.plate = plate;
        this.type = type;
        entrytime = LocalDateTime.now();
        inside = true;
    }

    public String getplate() {
        return plate;
    }

    public String gettype() {
        return type;
    }

    public LocalDateTime getentrytime() {
        return entrytime;
    }

    public LocalDateTime getexittime() {
        return exittime;
    }

    public boolean isinside() {
        return inside;
    }

    public void exitvehicle() {
        exittime = LocalDateTime.now();
        inside = false;
    }

    public String tostring() {
        return "plaka: " + plate + " tur: " + type + " giris: " + entrytime + " durum: " + (inside ? "icerde" : "cikti");
    }
}


