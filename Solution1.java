import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int formingMagicSquare(int[][] s) {
        int rowSum = 0;
        int colSum = 0;
        int diagSum = 0;
        int max = 3;
        int i_45_degDiag = 0;
        int j_45_degDiag = 0;
        int i_135_degDiag = 0;
        int j_135_degDiag = max -1;
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.println("index: "+i+","+j);
                rowSum = getRowSum(i, max, s);
                colSum = getColSum(j, max, s);
                if(abs(i-i_45_degDiag) == abs(j-j_45_degDiag))
                {
                    diagSum = get45DegreeDiagonal(max,s);
                }
                else(abs(i-i_135_degDiag) == abs(j-j_135_degDiag))
                {
                    diagSum = get135DegreeDiagonal(max,s);
                }
                            
                
            }   
        }
        // Complete this function
    }
    
    
    
    static int getRowSum(int i,int max,int[][] s) {
        int sum = 0;
        for(int j=0; j<max; j++) {
            sum = sum + s[i][j];
        }        
        return sum;        
    }
    
    static int getColSum(int j,int max,int[][] s) {
        int sum = 0;
        for(int i=0; i<max; i++) {
            sum = sum + s[i][j];
        }        
        return sum;
    }
    
    static int get45DegreeDiagonal(int max,int[][] s) {
        int sumDiagonal = 0;
        int i = 0;
        int j = 0;
        for(int k=0; k<max; k++) {
            sum = sum + s[i++][j++];
        }        
        return sum;
    }
    
    static int get135DegreeDiagonal(int max,int[][] s) {
        int sumDiagonal = 0;
        int i=0;
        int j=max-1;
        for(int k=0; k<max; k++) {
            sum = sum + s[i++][j--];
        }        
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }
}




import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    int i_45_degDiag = 0;
    int j_45_degDiag = 0;
    int i_135_degDiag = 0;
    int j_135_degDiag = max -1;
    int pivotSum = 15;
    
    static int formingMagicSquare(int[][] s) {
        int rowSum = 0;
        int colSum = 0;
        int diagSum = 0;
        int max = 3;
        
        
        process(i,j,max);
        // Complete this function
    }
    
    process(int i,int j,int max) {
        //i,j
        int rowSum = getRowSum(i, max, s);
        int colSum = getColSum(j, max, s);
        int diagSum = 0; 
        if(abs(i-i_45_degDiag) == abs(j-j_45_degDiag))
        {
           diagSum = get45DegreeDiagonal(max,s);
        }
        else(abs(i-i_135_degDiag) == abs(j-j_135_degDiag))
        {
           diagSum = get135DegreeDiagonal(max,s);
        }
        
        if(rowSum == pivotSum || colSum == pivotSum || diagSum == pivotSum) {
            if(i==max-1 || j==max-1) {
                return;
            }
            else () {
                
            }
            
        }
        else {
            
        }
        
    }
    
    for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.println("index: "+i+","+j);
                rowSum = getRowSum(i, max, s);
                colSum = getColSum(j, max, s);
                if(abs(i-i_45_degDiag) == abs(j-j_45_degDiag))
                {
                    diagSum = get45DegreeDiagonal(max,s);
                }
                else(abs(i-i_135_degDiag) == abs(j-j_135_degDiag))
                {
                    diagSum = get135DegreeDiagonal(max,s);
                }
                            
                
            }   
        }
    
    
    static int getRowSum(int i,int max,int[][] s) {
        int sum = 0;
        for(int j=0; j<max; j++) {
            sum = sum + s[i][j];
        }        
        return sum;        
    }
    
    static int getColSum(int j,int max,int[][] s) {
        int sum = 0;
        for(int i=0; i<max; i++) {
            sum = sum + s[i][j];
        }        
        return sum;
    }
    
    static int get45DegreeDiagonal(int max,int[][] s) {
        int sumDiagonal = 0;
        int i = 0;
        int j = 0;
        for(int k=0; k<max; k++) {
            sum = sum + s[i++][j++];
        }        
        return sum;
    }
    
    static int get135DegreeDiagonal(int max,int[][] s) {
        int sumDiagonal = 0;
        int i=0;
        int j=max-1;
        for(int k=0; k<max; k++) {
            sum = sum + s[i++][j--];
        }        
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }
}
