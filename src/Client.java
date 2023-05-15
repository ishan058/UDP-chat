import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte[] buffer;
        DatagramPacket packet;
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort = 12345;

        while (true) {
            String message = System.console().readLine();
            buffer = message.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);
            socket.send(packet);

            buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Server: " + message);
        }
    }
}
