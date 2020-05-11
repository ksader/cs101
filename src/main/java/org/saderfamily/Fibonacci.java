package org.saderfamily;

import java.util.ArrayList;

public class Fibonacci {
    public static void main(String [] args) {
        if(args.length < 1) {
            System.out.println("Must pass in a positive fibonacci number index");
            return;
        }

        System.out.println("nth Fibonacci number is: "
                + new Fibonacci().fibonacci(Integer.parseInt(args[0])));
    }

    int fibonacci(int fibIndex) {
        // Shortcut to not deal with -1 indexing
        return fibonacci(fibIndex, new ArrayList<Integer>(){{add(0); add(1); add(1);}});
    }

    int fibonacci(int fibIndex, ArrayList<Integer> memoedFibs) {
        if(fibIndex < memoedFibs.size()) {
            return memoedFibs.get(fibIndex);
        }

        if(fibIndex == 1 || fibIndex == 2) {
            return memoedFibs.get(fibIndex);
        }

        memoedFibs.add(fibIndex,
                fibonacci(fibIndex - 1, memoedFibs) + fibonacci(fibIndex - 2, memoedFibs));
        return memoedFibs.get(fibIndex);
    }
}
