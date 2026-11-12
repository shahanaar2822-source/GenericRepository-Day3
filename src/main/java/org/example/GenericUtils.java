
package org.example;

import java.util.List;

public class GenericUtils {

    // Bounded Generics
    public static <N extends Number> double sumNumbers(
            List<N> numbers) {

        double total = 0;

        for (N number : numbers) {
            total += number.doubleValue();
        }

        return total;
    }

    // PECS Wildcards
    public static <T> void copyItems(
            List<? extends T> source,
            List<? super T> destination) {

        destination.addAll(source);
    }
}
