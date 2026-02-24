import devices.*;
import java.util.Scanner;

public class SmartHome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Kac cihaz ekleyeceksiniz :  ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Device[] devices = new Device[n];

        for (int i = 0; i < n; i++) {

            int type;

            
            while (true) {
                System.out.println((i + 1) + ". Cihaz turu (1-Lamba, 2-Akilli Supurge): ");

                if (sc.hasNextInt()) {
                    type = sc.nextInt();
                    sc.nextLine(); 

                    if (type == 1 || type == 2) {
                        break; 
                    } else {
                        System.out.println("Hatali giris! Lutfen 1 veya 2 giriniz.");
                    }
                } else {
                    System.out.println("Hatali giris! Lutfen sayi giriniz.");
                    sc.nextLine(); 
                }
            }

            System.out.print("Cihaz adi: ");
            String name = sc.nextLine();

            System.out.print("Pil seviyesi: ");
            int battery = sc.nextInt();
            sc.nextLine();

            if (type == 1) {
                System.out.print("Parlaklik degeri: ");
                int bright = sc.nextInt();
                sc.nextLine();
                devices[i] = new SmartLamp(name, battery, bright);
            } else {
                System.out.print("Baslangic modu(eco/turbo/silent): ");
                String mode = sc.nextLine();
                devices[i] = new RobotVacuum(name, battery, mode);
            }
        }

        System.out.println("\n CİHAZLAR ACİLİYOR ");
        for (Device d : devices) {
            d.turnOn();
        }

        System.out.println("\n CİHAZ DURUMLARI ");
        for (Device d : devices) {
            System.out.println(d.getStatus());
        }

        
        while (true) {
            System.out.println("\n ANA MENÜ");
            System.out.println("1- Cihaz Arama");
            System.out.println("2- Cihaz Ac");
            System.out.println("3- Cihaz Kapat");
            System.out.println("4- Tum Cihaz Durumlarini Goster");
            System.out.println("5- Cikis");
            System.out.print("Seciminiz: ");

            int secim = sc.nextInt();
            sc.nextLine(); // buffer temizleme

            if (secim == 5) {
                System.out.println("Programdan cikiliyor...");
                break;
            }

            if (secim == 4) {
                System.out.println("\n===== TUM CIHAZ DURUMLARI =====");
                for (Device d : devices) {
                    System.out.println(d.getStatus());
                }
                continue;
            }

            System.out.print("Cihaz adi gir: ");
            String isim = sc.nextLine();

            Device hedef = null;

            
            for (Device d : devices) {
                if (d.getName().toLowerCase().equals(isim.toLowerCase())) {
                    hedef = d;
                    break;
                }
            }

            if (hedef == null) {
                System.out.println("Bu isimde cihaz bulunamadi!");
                continue;
            }

            
            if (secim == 1) {
                System.out.println(hedef.getStatus());
            } else if (secim == 2) {
                hedef.turnOn();
            } else if (secim == 3) {
                hedef.turnOff();
            } else {
                System.out.println("Gecersiz secim..");
            }
        }

        sc.close();
    }
}
