package br.com.introcdc.tests.random;
/*
 * Written by IntroCDC, Bruno Co�lho at 17/04/2020 - 04:21
 */

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro n�mero: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Digite a opera��o (1 = +, 2 = -, 3 = *, 4= /):");
        int operation = scanner.nextInt();

        System.out.print("Digite o segundo n�mero: ");
        int secondNumber = scanner.nextInt();

        switch (operation) {
            case 1:
                System.out.println("Resultado: " + (firstNumber + secondNumber));
                break;
            case 2:
                System.out.println("Resultado: " + (firstNumber - secondNumber));
                break;
            case 3:
                System.out.println("Resultado: " + (firstNumber * secondNumber));
                break;
            case 4:
                System.out.println("Resultado: " + (firstNumber / secondNumber));
                break;
            default:
                System.out.println("Opera��o inv�lida!");
                break;
        }

    }

}
