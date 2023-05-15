import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(12345);
        byte[] buffer;
        DatagramPacket packet;
        InetAddress clientAddress;
        int clientPort;

        while (true) {
            buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            clientAddress = packet.getAddress();
            clientPort = packet.getPort();
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Client: " + message);

            message = System.console().readLine();
            buffer = message.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
            socket.send(packet);
        }
    }
}
