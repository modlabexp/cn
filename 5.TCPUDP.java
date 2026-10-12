import java.net.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> tcpServer()).start();
        new Thread(() -> udpServer()).start();
    }

    static void tcpServer() {
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("TCP Server waiting...");

            Socket s = ss.accept();
            System.out.println("TCP Client connected");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("TCP Client: " + msg);
                System.out.print("TCP Server: ");
                out.println(sc.nextLine());
            }

            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void udpServer() {
        try {
            DatagramSocket ds = new DatagramSocket(5001);
            Scanner sc = new Scanner(System.in);
            byte[] buf = new byte[1024];

            System.out.println("UDP Server waiting...");

            while (true) {
                DatagramPacket p = new DatagramPacket(buf, buf.length);
                ds.receive(p);

                String msg = new String(p.getData(), 0, p.getLength());
                System.out.println("UDP Client: " + msg);

                System.out.print("UDP Server: ");
                byte[] reply = sc.nextLine().getBytes();

                DatagramPacket r = new DatagramPacket(
                    reply, reply.length, p.getAddress(), p.getPort());
                ds.send(r);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
