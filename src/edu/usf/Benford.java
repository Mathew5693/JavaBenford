package edu.usf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Benford {


    public static int[] countDigits(Scanner in) {

        //reads file for count array
        int[] count = new int[10];
        while (in.hasNext()) {
            int n = firstDigit(in.next());
            count[firstNum(n)]++;
        }
        return count;
    }


    public static int firstNum(int n) {
        //gets first digit of number
        int firsT = Math.abs(n);
        while (firsT >= 10) {
            firsT = firsT / 10;
        }
        return firsT;
    }

    public static int firstDigit(String numbeR) {
        //find first number, filters out zero
        for (char ch : numbeR.toCharArray()) {
            if (ch >= '1' && ch <= '9') {
                return ch - '0';
            }
        }
        return 0;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter filename: ");
        String filename = stdin.nextLine();
        Scanner in = new Scanner(new File(filename));

        int[] count = countDigits(in);


            reportResults(count);       //calls results


        }


    public static int totaL(int[] data) {
        int totaL = 0;
        for (int n : data) {
            totaL += n;
        }
        // returns the sum of the integers
        return totaL;
    }

    public static void reportResults(int[] count) {

        //calculates results of digit count freq
        if (count[0] > 0) {
            System.out.println("excluding " + count[0] + " tokens");
        }
        int total = totaL(count) - count[0];
        System.out.println("Digit Count Frequency");
        for (int i = 1; i < count.length; i++) {
            double pct = count[i] * 100.0 / total;
            System.out.printf("%5d %5d %6.2f\n", i, count[i], pct);
        }

    }

}



