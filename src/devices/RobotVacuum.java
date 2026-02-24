package devices;

public class RobotVacuum extends Device {
    private String mode;

    public RobotVacuum(String name, int battery, String mode) {
        super(name, battery);
        this.mode = mode;
    }

    public void setMode(String mode){
        this.mode = mode;
    }

    @Override
    public void turnOn() {
        if(battery < 20){
            System.out.println(name + " pil seviyesi dusuk oldugu icin acilamadi");
            return;
        }

        if(mode.equalsIgnoreCase("turbo")){
            battery -= 10;
            if(battery < 0) battery = 0;
        }

        if(battery == 0){
            System.out.println(name + ": Pil bitti.. Cihaz kapaniyor..");
            isOn = false;
            return;
        }

        super.turnOn();
    }

    @Override
    public String getStatus(){
        return "[Süpürge] " + name +" - Pil: " + battery +"%, Durum: " + (isOn ? "Açık" : "Kapalı") +", Mod: " + mode;
    }
}
