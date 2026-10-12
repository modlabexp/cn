import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary data: ");
        String data = sc.next();

        System.out.print("Enter generator: ");
        String key = sc.next();

        String temp = data + "0".repeat(key.length() - 1);

        for (int i = 0; i < data.length(); i++) {
            if (temp.charAt(i) == '1') {
                for (int j = 0; j < key.length(); j++) {
                    char c = temp.charAt(i + j) == key.charAt(j) ? '0' : '1';
                    temp = temp.substring(0, i + j) + c + temp.substring(i + j + 1);
                }
            }
        }

        String r = temp.substring(temp.length() - key.length() + 1);

        System.out.println("CRC Remainder: " + r);
        System.out.println("Transmitted Data: " + data + r);

        int sum = 0;
        for (int i = 0; i < data.length(); i += 4) {
            String word = data.substring(i, Math.min(i + 4, data.length()));
            sum += Integer.parseInt(word, 2);
        }

        sum = (sum & 15) + (sum >> 4);
        System.out.println("Checksum: " + String.format("%4s",
            Integer.toBinaryString((~sum) & 15)).replace(' ', '0'));

        sc.close();
    }
}
