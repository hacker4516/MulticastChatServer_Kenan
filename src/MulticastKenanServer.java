import java.net.*;

public class MulticastKenanServer {
    public static void main(String args []) throws Exception {

            int portnumba = 56;
            if (args.length >= 1) {
                portnumba = Integer.parseInt(args[0]);
            }

            MulticastSocket serverMulticastSocket = new MulticastSocket(portnumba);
            System.out.println("MulticastSocket is created at port " + portnumba);

            InetAddress group = InetAddress.getByName("225.4.5.6");

            serverMulticastSocket.joinGroup(group);
            System.out.println("joinGroup method is called...");

            boolean infinite = true;

            while (infinite) {
                byte buf[] = new byte[1024];
                DatagramPacket data = new DatagramPacket(buf, buf.length);
                serverMulticastSocket.receive(data);
                String msg = new String(data.getData()).trim();
                System.out.println("Message received from client = " + msg);
            }
            serverMulticastSocket.close();
        }
}
