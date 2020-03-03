package org.saderfamily;

import java.text.NumberFormat;

public class Factorial {
    public static void main(String[] args) {
        try {
            if(args.length > 0) {
//                long cliInput = Long.parseLong(args[0]);
                for(int i = 0; i < 16; ++i) {
                    int recurFac = new Factorial().recursiveFactorial(i);
                    assert recurFac > 0 && recurFac < Integer.MAX_VALUE;
                    System.out.println(String.format("Fib of %d is: %s", i,
                            NumberFormat.getNumberInstance().format(recurFac)));
                }
                    System.out.println(String.format("Max int is %s",
                            NumberFormat.getNumberInstance().format(Integer.MAX_VALUE)));
                System.out.println(String.format("Max long is %s",
                        NumberFormat.getNumberInstance().format(Long.MAX_VALUE)));
            }
        } catch(NumberFormatException e) {
            System.err.println("Non parsable input" + args[0]);
        }
    }

    private int recursiveFactorial(int l) {
        if(l > 1) {
            return l * recursiveFactorial(l - 1);
        }
        if(l > -1) {
            return 1;
        }
        throw new IllegalArgumentException("This method must take a non-negative long");
    }
}
