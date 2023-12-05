import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        int nota = 0;
        int media = 0;

        for(int i = 0; i<3; i++){
            nota = ler.nextInt();
            media += nota ;
        }

        System.out.println(media/5);
    }
}
