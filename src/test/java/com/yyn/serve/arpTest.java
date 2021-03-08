package com.yyn.serve;

import org.junit.Test;

import java.util.Arrays;

public class arpTest {


    @Test
    public static void main(String[] args) {

       String s = "java.library.path";
        final String[] split = s.split("\\.");
        System.out.println(split[0]);
    }
}
