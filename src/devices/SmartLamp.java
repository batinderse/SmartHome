package devices;

public class SmartLamp extends Device {
    private int brightness;

    public SmartLamp(String name, int battery, int brightness) {
        super(name, battery);
        this.brightness = brightness;
    }

    public void setBrightness(int value){
        if(value < 0 || value > 100){
            System.out.println("Parlaklik 0-100 arası olmali");
        } else {
            this.brightness = value;
        }
    }

    @Override
    public String getStatus() {
        return "[Lamba] " + name + " - Pil: " + battery +"%, Durum: " + (isOn ? "Acik" : "Kapali") +", Parlaklik: " + brightness;
    }
}
