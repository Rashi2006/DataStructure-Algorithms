// Chef likes to work with arrays a lot. Today he has an array A of length N consisting of positive integers. Chef's little brother likes to follow his elder brother, so he thought of creating an array B of length N. The little brother is too small to think of new numbers himself, so he decided to use all the elements of array A to create the array B. In other words, array B is obtained by shuffling the elements of array A.

// The little brother doesn't want Chef to know that he has copied the elements of his array A. Therefore, he wants to create the array B in such a way that the Hamming distance between the two arrays A and B is maximized. The Hamming distance between A and B is the number of indices i (1 ≤ i ≤ N) such that Ai ≠ Bi.

// The brother needs your help in finding any such array B. Can you please find one such array for him?

// Note that it's guaranteed that no element in A appears more than twice, i.e. frequency of each element is at most 2.
import java.util.*;
import java.lang.*;
import java.io.*;

public class HammingDistance
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
      
        
            System.out.println("Enter N:");
            int N = scanner.nextInt();
            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                System.out.println("Enter A[" + i + "]:");
                A[i] = scanner.nextInt();
            }

            int[] B = maximizeHammingDistance(N, A);
            int hammingDistance = calculateHammingDistance(A, B);

            System.out.println(hammingDistance);
            for (int i = 0; i < N; i++) {
                System.out.print(B[i] + (i < N - 1 ? " " : "\n"));
            }
        
    }

    private static int[] maximizeHammingDistance(int N, int[] A) {
        int[] B = A.clone();
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            if (B[i] == A[i]) {
                if (i + 1 < N) {
                    swap(B, i, i + 1);
                } else {
                    swap(B, i, 0);
                }
            }
        }

        return B;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int calculateHammingDistance(int[] A, int[] B) {
        int hammingDistance = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                hammingDistance += 1;
            }
        }
        return hammingDistance;
    }
}

