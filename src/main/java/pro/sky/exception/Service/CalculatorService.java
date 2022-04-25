package pro.sky.exception.Service;

import pro.sky.exception.exceptions.ZeroDividerException;

public interface CalculatorService {

    int plus(int num1, int num2);

    int minus (int num1, int num2);
    int divide (int num1, int num2) throws ZeroDividerException;
    int multiply (int num1, int num2);
}