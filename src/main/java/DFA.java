import java.util.*;

public class DFA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int state, trans;
        System.out.println("Gib Anzahl der States ein:");
        state = scanner.nextInt();
        System.out.println("Gib Anzahl der Transitoren ein");
        trans = scanner.nextInt();

        int dfa[][] = new int[state][trans];
        System.out.println("Transit-Tabelle eingeben");
        for (int i = 0; i < state; i++) {
            System.out.println("State: " + (i));
            for (int j = 0; j < trans; j++)
            {
                dfa[i][j] = scanner.nextInt();
            }
            System.out.println("");
        }
        System.out.println("String einfügen");
        String stateOne = scanner.next();
        String in [] = stateOne.split("");
        System.out.println("Übergangstabelle ");
        System.out.println("            0   1");
        for (int i = 0; i < state; i++) {
            System.out.println("State " + (i) + " ");
            for (int j = 0; j < trans; j++) {
                System.out.println("q" + dfa[i][j] + " ");
            }
            System.out.println("");
        }
        //input
        int input[] = new int[in.length];
        //splitten
        for (int i = 0; i < in.length; i++) {
            if (in[i].equals("a")){
                input[i]=0;
            }
            if(in[i].equals("b")){
                input[i]=1;
            }
        }
        System.out.println("________________________________________________________");
        int initialZustand = 0;
        int finalZustand = (state-1);
        int aktuellerZustand = initialZustand;
        int ip, nextState;
        for(int i = 0; i < in.length; i++){
            System.out.println("q" + aktuellerZustand + "--" + input[i] + "-->");
            ip = input[i];
            nextState = dfa[aktuellerZustand][ip];
            aktuellerZustand=nextState;
            if(i == (in.length - 1)) {
                System.out.println("q" + aktuellerZustand);
            }
        }
        if(aktuellerZustand==finalZustand){
            System.out.println("Akzeptiert");
        } else {
            System.out.println("Nicht akzeptiert");
        }
    }
}
