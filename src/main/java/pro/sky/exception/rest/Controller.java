package pro.sky.exception.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.exception.Service.CalculatorService;
import pro.sky.exception.rest.Controller;

@RequestMapping("/calculator")
public class Controller {

    private final CalculatorService calculatorService;


    public Controller(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping("/greeting")
    public String greeting() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus (@RequestParam(name = "num1", required = false) Integer num1,
                        @RequestParam(name = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Добавь параметры";
        }
        return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus (@RequestParam(name = "num1", required = false) Integer num1,
                         @RequestParam(name = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Добавь параметры";
        }
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }

    @GetMapping("/divide")
    public String divide (@RequestParam(name = "num1", required = false) Integer num1,
                          @RequestParam(name = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Добавь параметры";
        }
        if (num2 == 0){
            return "Ошибка в делении";

        }
        return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply (@RequestParam(name = "num1", required = false) Integer num1,
                            @RequestParam(name = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Добавь параметры";
        }
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
    }
}