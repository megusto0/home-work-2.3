package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.CalculatorServiceInterface;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorServiceInterface calculatorService;

    public CalculatorController(CalculatorServiceInterface calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(Integer num1, Integer num2) {
        if(Objects.isNull(num1) || Objects.isNull(num2)) {return "Передайте оба числа!";}
        return buildResult(num1, num2, calculatorService.plus(num1, num2), "+");
    }
    @GetMapping("/minus")
    public String minus(Integer num1, Integer num2) {
        if(Objects.isNull(num1) || Objects.isNull(num2)) {return "Передайте оба числа!";}
        return buildResult(num1, num2, calculatorService.minus(num1, num2), "-");
    }
    @GetMapping("/multiply")
    public String multiply(Integer num1, Integer num2) {
        if(Objects.isNull(num1) || Objects.isNull(num2)) {return "Передайте оба числа!";}
        return buildResult(num1, num2, calculatorService.multiply(num1, num2), "*");
    }
    @GetMapping("/divide")
    public String divide(Integer num1, Integer num2) {
        if(Objects.isNull(num1) || Objects.isNull(num2)) {return "Передайте оба числа!";}
        if (num2 == 0) {
            return "На ноль делить нельзя!";
        }
        else {
            return buildResult(num1, num2, calculatorService.divide(num1, num2), "/");
        }
    }

    private String buildResult(int num1, int num2, Number result, String operation) {
        return String.format("%d %s %d = %s", num1, operation, num2, result);
    }
}
