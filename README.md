# SmartHome

Java ile yazılmış, akıllı ev cihazlarını terminal menüsü üzerinden yöneten örnek uygulama.

## Özellikler

- Lamba ve robot süpürge nesneleri oluşturma
- Cihaz adıyla arama
- Cihazı açma ve kapatma
- Cihazların durumunu listeleme
- Pil seviyesi, lamba parlaklığı ve süpürge modu bilgilerini kullanma

Cihaz sınıfları `src/devices` altında, uygulamanın giriş noktası `src/SmartHome.java` dosyasındadır.

## Gereksinimler

- JDK (Java Development Kit)

## Derleme ve çalıştırma

Proje kök dizininde:

```bash
javac -d out src/devices/*.java src/SmartHome.java
java -cp out SmartHome
```

Program açıldığında cihaz sayısını ve her cihazın türüne göre istenen bilgileri girin. Daha sonra ana menüden cihazları arayıp yönetebilirsiniz.
