import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class TicTacToe {
    public static void displayArray(String[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                //print each value
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        //declare variables
        int numRows = 3;
        int numCols = 3;
        String[][] board = new String[numRows][numCols];
        Path filePath = Path.of("save_game.txt");
        int counter = 0;
        String[] lineArray;
        //read in from file
        String tempData = Files.readString(filePath);
        System.out.println(tempData);

        //split the file
        lineArray = tempData.split("\r\n");
        System.out.println(Arrays.toString(lineArray));

        //load lineArray into board
        for (int i=0; i< numRows; i++){
            for (int j=0; j< numCols; j++){
                board[i][j]=lineArray[counter];
                if (counter < lineArray.length-1){
                    counter++;
                }
            }
        }
        displayArray(board);

    }
}
