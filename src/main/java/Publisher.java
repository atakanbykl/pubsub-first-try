import io.nats.client.Connection;
import io.nats.client.Nats;
import java.nio.charset.StandardCharsets;

public class Publisher {
    public static void main(String[] args) throws Exception {
        // NATS sunucusuna bağlan
        Connection nc = Nats.connect("nats://localhost:4222");

        // "updates" kanalına mesaj gönder
        String jsonMessage = "{ \"id\": \"robot1\", \"battery\": 87, \"mode\": \"idle\" }";


        // nc.publish("updates", "naber".getBytes());
        nc.publish("updates", jsonMessage.getBytes(StandardCharsets.UTF_8));

        // Bağlantıyı kapat
        nc.close();

        System.out.println("Mesaj gönderildi.");
    }
}