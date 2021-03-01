package com.yyn.serve;

import org.junit.Test;

public class arpTest {


    @Test
    public static void main(String[] args) {

        final String property = System.getProperty("java.library.path");
        System.out.println(property);

    }
}
