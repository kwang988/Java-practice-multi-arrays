import java.util.Random;

public class MultiArrays {
    public static void displayArray(int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                //print each value
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
    public static int findSumOfMatrix (int[][] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                sum += array[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        //declare variables
        int numRows = 5;
        int numCols = 5;
        int[][] numArray = new int[numRows][numCols];

        //loop through numArray, set value 1
        for (int i = 0; i < numArray.length; i++){
            for (int j = 0; j < numArray[i].length; j++){
                numArray[i][j]= 1;
            }
        }
        //printout original array
        System.out.println("original array: ");
        displayArray(numArray);
        System.out.println("sum of matrix: "+ findSumOfMatrix(numArray));

        //0. loop through numArray, set value to random number
        Random randNum = new Random();
        for (int i = 0; i < numArray.length; i++){
            for (int j = 0; j < numArray[i].length; j++){
                numArray[i][j]= randNum.nextInt(10);
            }
        }
        System.out.println("0. print out random number Array: ");
        displayArray(numArray);
        System.out.println("sum of matrix: "+ findSumOfMatrix(numArray));

        //1. how do you set the diagonal?
        for (int i = 0; i < numArray.length; i++){
            for (int j = 0; j < numArray[i].length; j++){
                //check if i==j, set value to 2
                if (i==j){
                    numArray[i][j]=2;
                }
            }
        }
        //printout array
        System.out.println("1. change main diagonal to 2: ");
        displayArray(numArray);
        System.out.println("sum of matrix: "+ findSumOfMatrix(numArray));

        //2. walk down the diagonal faster way
        int j=0;
        for (int i = 0; i < numArray.length; i++){
            numArray[i][j]=3;
            j++;
        }
        System.out.println("2. change main diagonal to 3-faster way: ");
        displayArray(numArray);
        System.out.println("sum of matrix: "+ findSumOfMatrix(numArray));

        //3. walk down the secondary diagonal
        for (int i = 0; i < numArray.length; i++){
            j = numArray.length-1-i;
            numArray[i][j]=3;
        }
        System.out.println("3. change second diagonal array to 3: ");
        displayArray(numArray);
        System.out.println("sum of matrix: "+ findSumOfMatrix(numArray));

        //4. set both diagonals at once, set value to 4
        for (int i = 0; i < numArray.length; i++){
            j = numArray.length-1-i;
            numArray[i][i]= 4;//main diagonal, because i==j
            numArray[i][j]= 4; //second diagonal
        }
        System.out.println("4. change both diagonal to 4 at once: ");
        displayArray(numArray);
        System.out.println("sum of matrix: "+ findSumOfMatrix(numArray));

        //5. challenge: can you do the same thing as above in half the time?
        for (int i = 0; i <= numArray.length/2; i++){
            j = numArray.length-1-i;
            numArray[i][i]= 5;//main diagonal
            numArray[j][j]=numArray[i][i];//bottom part of main diagonal
            numArray[i][j]= numArray[i][i]; //second diagonal
            numArray[j][i]= numArray[i][i]; //bottom part of second diagonal
        }
        System.out.println("5. faster way to change both diagonals: ");
        displayArray(numArray);
        System.out.println("sum of matrix: "+ findSumOfMatrix(numArray));

    }
}
