package it.fmelandri.fizzbuzz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class FizzBuzz {
    final Map<Integer, String> numberToWord;

    private FizzBuzz() {
        numberToWord = new LinkedHashMap<>();
    }

    public static FizzBuzz create() {
        return new FizzBuzz();
    }

    public FizzBuzz with(int number, String wordToOutput) {
        numberToWord.put(number, wordToOutput);
        return this;
    }

    public String emit(int number) {
        Predicate<Integer> numberDivisibleByKey = numberIsDivisibleByGivenDivisor(number);
        return numberToWord
                .keySet()
                .stream()
                .filter(numberDivisibleByKey)
                .map(numberToWord::get)
                .reduce(String::concat)
                .orElse(String.valueOf(number));
    }

    public Predicate<Integer> numberIsDivisibleByGivenDivisor(int number) {
        return divisor -> number % divisor == 0;
    }
}

