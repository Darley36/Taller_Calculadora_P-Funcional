package co.com.sofka.example;

public class Exercise {

    public static int sumNumbers(int valueOne, int valueTwo){
        return (valueOne + valueTwo);
    }

    public static int subtractNumbers(int valueOne, int valueTwo){
        return (valueOne - valueTwo);
    }

    public static int multiplyNumbers(int valueOne, int valueTwo){
        if (valueTwo > 0) {
            return sumNumbers(valueOne, multiplyNumbers(valueOne,valueTwo-1));
        }
        return 0;
    }

    public static int divisionNumbers(int valueOne, int valueTwo){
        if (valueTwo == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        if (valueTwo <= valueOne) {
            return 1 + divisionNumbers(subtractNumbers(valueOne,valueTwo), valueTwo);
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println("La suma de 3 + 4 es: "+sumNumbers(3,4));
        System.out.println("La resta de 8 - 6 es: "+subtractNumbers(8,6));
        System.out.println("La multiplicacion de 6 * 6 es: "+multiplyNumbers(6,6));
        System.out.println("La division de 110 * 5 es: "+divisionNumbers(110,5));
    }
}
