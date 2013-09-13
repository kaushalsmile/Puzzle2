import java.text.NumberFormat;
import java.util.Scanner;

public class Puzzle2 {
    public void print() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(0);
        Scanner input = new Scanner(System.in);
        int level = input.nextInt();
        int cnt = 0;
        double[] cups = new double[(level * (level + 1)) / 2];

        for (int i = 0; i < cups.length; i++) {
            cups[i] = input.nextDouble();
        }
        double extraWater = input.nextDouble();
        double tmp = 0;
        for (int i = 0; i < level - 1; i++) {
            tmp = extraWater / (i + 1);
            extraWater = 0;
            for (int j = 0; j <= i; j++) {
                if (cups[cnt] < tmp) {
                    extraWater += tmp - cups[cnt];
                } else {
                    cups[cnt] = tmp;
                }
                System.out.print(nf.format(cups[cnt]) + " ");
                cnt ++;
            }System.out.println();
        }
        tmp = extraWater / level;
        for ( ; cnt < cups.length; cnt++) {
            if (cups[cnt] < tmp) {
                System.out.print( nf.format(cups[cnt])+ " ");
            } else {
                System.out.print( nf.format(tmp)+ " ");
            }
            
        }
    }

    public static void main(String[] args) {
        new Puzzle2().print();
    }

}
