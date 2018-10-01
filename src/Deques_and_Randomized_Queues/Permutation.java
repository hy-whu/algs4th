package Deques_and_Randomized_Queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {

        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> q = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            q.enqueue(item);
        }

        for (String s : q) {
            if (k == 0) {
                break;
               }
             StdOut.println(s);
             k--;
        }


    }
}
