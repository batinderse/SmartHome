package devices;

public class Device {
    protected String name;
    protected int battery;
    protected boolean isOn;

    public Device(String name, int battery) {
        this.name = name;
        this.battery = battery;
        this.isOn = false;
    }

    public void turnOn() {
        if(isOn){
            System.out.println(name + " zaten acik");
        } else {
            isOn = true;
            System.out.println(name + " acildi.");
        }
    }

    public void turnOff() {
        if(!isOn){
            System.out.println(name + " zaten kapali");
        } else {
            isOn = false;
            System.out.println(name + " kapatildi");
        }
    }

    public String getStatus() {
        return name + " - Pil: " + battery + "%, Durum: " + (isOn ? "Acik" : "Kapali");
    }
    public String getName() {
    return name;
}

}
