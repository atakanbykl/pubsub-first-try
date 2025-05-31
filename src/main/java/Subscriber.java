import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;

public class Subscriber {
    public static void main(String[] args) throws Exception {
        Connection nc = Nats.connect("nats://localhost:4222");

        Dispatcher d = nc.createDispatcher((msg) -> {
            String mesaj = new String(msg.getData());
            System.out.println("Gelen mesaj: " + mesaj);
        });

        d.subscribe("updates");

        // Sonsuza kadar dinle
        Thread.currentThread().join();
    }
}