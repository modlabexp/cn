import java.util.*;

class Flight {
    String title;
    String code;

    Flight(String t, String c) {
        title = t;
        code = c;
    }

    public String toString() {
        return title + " " + code;
    }
}

class Indigo {
    ArrayList list = new ArrayList();

    Indigo() {
        list.add(new Flight("IndiGo SkyJet", "IG110"));
        list.add(new Flight("IndiGo AirConnect", "IG203"));
        list.add(new Flight("IndiGo MetroLine", "IG187"));
        list.add(new Flight("IndiGo Swift", "IG119"));
        list.add(new Flight("IndiGo Voyager", "IG140"));
    }

    public String toString() {
        String result = "";
        for (Object f : list) {
            result += f + "\n";
        }
        return result;
    }
}

public class MakeMyTrip {
    public static void main(String[] args) {
        Indigo flights = new Indigo();
        System.out.print(flights);
    }
}
