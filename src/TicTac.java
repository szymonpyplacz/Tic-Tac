import java.util.Scanner;

public class TicTac {
    public boolean printMove(boolean first, char[] arrayPlay, int position){
        if (first == true) {
            arrayPlay[position] = 'O';
            return false;
        } else {
            arrayPlay[position] = 'X';
            return true;
        }
    }

    public boolean ifWin(char[] arrayPlay){
    if((arrayPlay[0] == 'O' && arrayPlay[1] == 'O' && arrayPlay[2] == 'O')||(arrayPlay[3] == 'O' && arrayPlay[4] == 'O' && arrayPlay[5] == 'O') || (arrayPlay[6] == 'O' && arrayPlay[7] == 'O' && arrayPlay[8] == 'O')||
       (arrayPlay[0] == 'O' && arrayPlay[3] == 'O' && arrayPlay[6] == 'O')||(arrayPlay[1] == 'O' && arrayPlay[4] == 'O' && arrayPlay[7] == 'O') || (arrayPlay[2] == 'O' && arrayPlay[5] == 'O' && arrayPlay[8] == 'O')||
       (arrayPlay[0] == 'O' && arrayPlay[4] == 'O' && arrayPlay[8] == 'O')||(arrayPlay[2] == 'O' && arrayPlay[4] == 'O' && arrayPlay[6] == 'O')) {
        System.out.println("Wygrało kółko");
        return true;
    }
        else if
            ((arrayPlay[0] == 'X' && arrayPlay[1] == 'X' && arrayPlay[2] == 'X')||(arrayPlay[3] == 'X' && arrayPlay[4] == 'X' && arrayPlay[5] == 'X') || (arrayPlay[6] == 'X' && arrayPlay[7] == 'X' && arrayPlay[8] == 'X')||
             (arrayPlay[0] == 'X' && arrayPlay[3] == 'X' && arrayPlay[6] == 'X')||(arrayPlay[1] == 'X' && arrayPlay[4] == 'X' && arrayPlay[7] == 'X') || (arrayPlay[2] == 'X' && arrayPlay[5] == 'X' && arrayPlay[8] == 'X')||
             (arrayPlay[0] == 'X' && arrayPlay[4] == 'X' && arrayPlay[8] == 'X')||(arrayPlay[2] == 'X' && arrayPlay[4] == 'X' && arrayPlay[6] == 'X')) {
        System.out.println("Wygrał krzyżyk");
        return true;
    }
        else if
            (arrayPlay[0] != '"' && arrayPlay[1] != '"' && arrayPlay[2] != '"' && arrayPlay[3] != '"' && arrayPlay[4] != '"' && arrayPlay[5] != '"' && arrayPlay[6]  != '"' && arrayPlay[7] != '"' && arrayPlay[8] != '"') {
            System.out.println("Remisik :)");
            return true;
    }
        else
        return false;
    }

    public int decoder(int given){
        while (given > 9 || given < 1){
            System.out.println("Niewłaściwa liczna!, podaj raz jeszcze");
            Scanner read2 = new Scanner(System.in);
            given = read2.nextInt();
        }
        if (given == 7)
            return 0;
        else if (given == 8)
            return 1;
        else if (given == 9)
            return 2;
        else if (given == 4)
            return 3;
        else if (given == 5)
            return 4;
        else if (given == 6)
            return 5;
        else if (given == 1)
            return 6;
        else if (given == 2)
            return 7;
        else
            return 8;
        }

    public boolean move(boolean first, char[] arrayPlay) {
        if (first)
            System.out.println("Ruch wykonuje kółko");
        else
            System.out.println("Ruch wykonuje krzyżyk");

        System.out.println("Wpisz na której pozycji chcesz postawić znak");
        Scanner read = new Scanner(System.in);
        int position = decoder(read.nextInt());
        if (arrayPlay[position] == '"') {
            return printMove(first, arrayPlay, position);
        } else {
            boolean freePosition = false;
            while (freePosition == false){
                System.out.println("Ta pozycja jest zajęta, podaj inną");
                position = decoder(read.nextInt());
                if (arrayPlay[position] == '"') {
                freePosition = true;
                }
            }
            return printMove(first, arrayPlay, position);
         }
        }

    public void showArray(char[] gameArray){
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0)
                System.out.println("");
            System.out.print(gameArray[i]);
        }
        System.out.println("");
    }


    public void game() {
        char[] gameArray = new  char[9];
        boolean endgame = false;
        boolean firstPlayer = true;
        for (int i = 0; i<9; i++){
            gameArray[i]='"';
        }
        showArray(gameArray);
        while (!endgame) {
            firstPlayer = this.move(firstPlayer, gameArray);
            showArray(gameArray);
            endgame = this.ifWin(gameArray);
        }
    }
}