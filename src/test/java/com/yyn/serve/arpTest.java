package com.yyn.serve;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

public class arpTest {


    private static final Object o = new Object();

    long l = System.currentTimeMillis() * 1000;

    AtomicLong al = new AtomicLong(System.currentTimeMillis() * 1000);


    public synchronized long getL() {
        return l = Math.max(++l,System.currentTimeMillis()*1000);
    }

    public long getAl() {
       return al.getAndSet(Math.max(al.incrementAndGet(),System.currentTimeMillis()*1000));
    }

    public void setL(long l) {
        this.l = l;
    }



    @Test
    public  void alTest() {
        final arpTest arpTest = new arpTest();
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());
        System.out.println(arpTest.getAl());

    }




    @Test
    public  void lTest() {
        final arpTest arpTest = new arpTest();
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());
        System.out.println(arpTest.getL());



    }
}
