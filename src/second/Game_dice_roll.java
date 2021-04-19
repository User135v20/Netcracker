package second;
import java.util.Random;
import java.util.Scanner;

public class Game_dice_roll{
    public static void main(String[] args) {

        class Round{
            class Dice_roll{
                public int dice_roll(int K) {
                    Random r = new Random();
                    int sum=0;
                    for (int attempt = 0; attempt<K;attempt++) sum = sum + r.nextInt(6) + 1;
                    return sum;
                }
            }

            public int find_winner(int index,int K, int N){
                int winner = -1,player,max = 0;
                boolean equal_value = false;
                int [] players = new int [N];
                Dice_roll dr = new Dice_roll();
                for (int i=0; i<N;i++) {
                    if (index + i >= N) {
                        player = index + i - N ;
                    } else {
                        player = index + i;
                    }
                    players[player] = dr.dice_roll(K);
                    System.out.println("user_"+(player+1)+" |"+players[player]+"| ");

                    if (players[player] == max) {
                        equal_value = true;
                    }
                    if (players[player] > max) {
                        winner = player;
                        max = players[player];
                        equal_value = false;
                    }
                }
                if (equal_value){
                    return -1;}
                else {
                    return winner;
                }
            }
        }
        Scanner console = new Scanner(System.in);
        int winner = 0, result_round;
        int K = console.nextInt();
        int N = console.nextInt();
        int [] user_wins = new int[N];

        for (;;){
            System.out.println("||new round|| ");
            Round i = new Round();
            result_round = i.find_winner(winner,K,N);
            if (result_round == -1){
                continue;
            }
            else {
                winner = result_round;
                user_wins[winner] = user_wins[winner] + 1;
                if (user_wins[winner] == 4){
                    break;
                }
            }
        }

        System.out.println("\n|WINNER| " + (winner+1));
    }
}
