package pro.sky.calculator.service;

import org.springframework.stereotype.Service;
import pro.sky.calculator.CalculatorServiceInterface;

@Service
public class CalculatorService implements CalculatorServiceInterface {
    public int plus(int num1, int num2) {
        return num1 + num2;
    }
    public int minus(int num1, int num2) {
        return num1 - num2;
    }
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
    public double divide(int num1, int num2) {
        return num1 / (double) num2;
    }
}
