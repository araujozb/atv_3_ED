import java.util.Scanner;
import java.util.Stack;

public class Servidores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("número de servidores: ");
        int n = sc.nextInt();

        int[] cargas = new int[n];

        System.out.println("cargas dos servidores:");
        for (int i = 0; i < n; i++) {
            cargas[i] = sc.nextInt();
        }

        int dias = 0;

        boolean shutdown = true;

        while (shutdown) {
            Stack<Integer> pilha = new Stack<>();
            pilha.push(cargas[0]); 

            shutdown = false;


            for (int i = 1; i < cargas.length; i++) {
                if (cargas[i] <= cargas[i - 1]) {
                    
                    pilha.push(cargas[i]);
                } else {
  
                    shutdown = true;
                }
            }

            if (shutdown) {
                dias++;

                cargas = new int[pilha.size()];
                for (int i = pilha.size() - 1; i >= 0; i--) {
                    cargas[i] = pilha.pop();
                }
            }
        }

        System.out.println("Número de dias até que nenhum servidor mais seja desligado: " + dias);

        sc.close();
    }
}
