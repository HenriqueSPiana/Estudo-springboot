package HenriqueSPiana.com.github.Estudo_springboot.math;

import HenriqueSPiana.com.github.Estudo_springboot.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {


    public Double sum(Double num1, Double num2){
        return num1+ num2;
    };

    public Double sub(Double num1, Double num2)  {
        return num1 - num2;
    };



    public Double mult(Double num1, Double num2) {
        Double multNumber = num2 * num1;
        return multNumber;
    }


    public Double div(Double num1,Double num2){
        Double divNumber = num1 / num2;
        return divNumber;
    }


    public Double mean(Double num1,Double num2) {
        Double meanNumber = sum(num1,num2)/2;
        return meanNumber;


    }


    public Double square(Double num) {
        Double squareNumber = Math.sqrt(num);
        return squareNumber;
    }
}
