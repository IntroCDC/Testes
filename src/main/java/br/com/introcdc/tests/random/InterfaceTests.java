package br.com.introcdc.tests.random;
/*
 * Written by IntroCDC, Bruno Coelho at 10/04/2021 - 04:56
 */

public class InterfaceTests {

    public static void main(String[] args) {
        wow5 wow5 = new wow5();
        System.out.println(wow5 instanceof wow5);
        System.out.println(wow5 instanceof wow1);
        System.out.println(wow5 instanceof wow2);
    }

    public interface wow1 extends wow2 {

    }

    public interface wow2 {

    }

    public interface wow3 extends wow2 {

    }

    public static class wow5 implements wow1, wow3 {

    }

}

