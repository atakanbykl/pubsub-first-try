import io.nats.client.Connection;
import io.nats.client.Nats;

public class Publisher {
    public static void main(String[] args) throws Exception {
        // NATS sunucusuna bağlan
        Connection nc = Nats.connect("nats://localhost:4222");

        // "updates" kanalına mesaj gönder
        nc.publish("updates", "naber".getBytes());

        // Bağlantıyı kapat
        nc.close();

        System.out.println("Mesaj gönderildi.");
    }
}