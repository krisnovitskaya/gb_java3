package less08;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        int k = 1;
        int direction = 0;
        int iteration = 0;
        Scanner scanner = new Scanner(System.in);

        int SIZE_X = scanner.nextInt();
        int SIZE_Y = scanner.nextInt();

        int arr[][] = new int[SIZE_Y][SIZE_X];

        for(int n = 0; k <= SIZE_X * SIZE_Y; n++){
            direction = n % 4;
            iteration = n / 4;
            switch (direction){
                case 0:
                    for(int j = iteration; j < SIZE_X - iteration; j++, k++){
                        arr[iteration][j] = k;
                    }
                    break;
                case 1:
                    for (int j = iteration + 1; j < SIZE_Y - iteration; j++, k++){
                        arr[j][SIZE_X - 1 - iteration] = k;
                    }
                    break;
                case 2:
                    for(int j = SIZE_X - iteration - 2; j >= iteration; j --, k++ ){
                        arr[SIZE_Y - iteration -1][j] = k;
                    }
                    break;
                case 3:
                    for(int j = SIZE_Y - iteration - 2; j > iteration; j--, k++){
                        arr[j][iteration] = k;
                    }
                    break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }



}
