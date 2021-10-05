package co.com.sofka.example;
import java.text.BreakIterator;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class ExerciseFuncional {

        static IntBinaryOperator resta = (a, b) -> a - b;

        static IntBinaryOperator suma = (a, b) -> a + b;

        static IntBinaryOperator mult = (a, b) -> {
            if(b < 0) a = a*-1;
            int finalA = a;
            return IntStream.range(0, Math.abs(b) + 1)
                    .reduce((accumulator, number) ->
                            suma.applyAsInt(finalA, accumulator)).getAsInt();
        };

    static IntBinaryOperator div = (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return IntStream.range(0, Math.abs(a) + 1)
                .reduce((accumulator, number) ->
                        resta.applyAsInt(a, b) >= b*accumulator ?
                                suma.applyAsInt(accumulator,1) : accumulator).orElse(0);
    };


        public static void main(String[] args) {
          System.out.println(suma.applyAsInt(3, 2));
          System.out.println(resta.applyAsInt(3, 2));
          System.out.println(mult.applyAsInt(5, 11));
          System.out.println(div.applyAsInt(74, 6));
        }

}
