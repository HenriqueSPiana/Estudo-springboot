package HenriqueSPiana.com.github.Estudo_springboot.controllers;

import HenriqueSPiana.com.github.Estudo_springboot.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{num1}/{num2}")
    public Double Sum(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws UnsupportedMathOperationException {
        if(!isNumeric(num1) || !isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return convertToDouble(num1)+ convertToDouble(num2);


    };

    private Double convertToDouble(String strNumber) throws UnsupportedMathOperationException{
        if(strNumber == null ||  strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);

    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null ||  strNumber.isEmpty()) return false;

        String number = strNumber.replace(",",".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    };




    //https://localhost:8080/math/sub/3/5
    @RequestMapping("/sub/{num1}/{num2}")
    public Double sub(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws UnsupportedMathOperationException {
        if(!isNumeric(num1) || !isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return convertToDouble(num1) - convertToDouble(num2);


    };

    //https://localhost:8080/math/mult/3/5
    @RequestMapping("/mult/{num1}/{num2}")
    public Double mult(@PathVariable("num1") String num1, @PathVariable("num2") String num2)throws UnsupportedMathOperationException{
        if(!isNumeric(num1) || !isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value");
        Double multNumber = convertToDouble(num2) * convertToDouble(num1);
        return multNumber;
    }


    //https://localhost:8080/math/div/3/5
    @RequestMapping("/div/{num1}/{num2}")
    public Double div(@PathVariable("num1") String num1,@PathVariable("num2") String num2)throws UnsupportedMathOperationException{
        if(!isNumeric(num1)||!isNumeric(num2) )  throw new UnsupportedMathOperationException("Please set a numeric value");
        if(num2.equals("0")) throw new UnsupportedMathOperationException("enter a non-zero denominator");
        Double divNumber = convertToDouble(num1) / convertToDouble(num2);
        return divNumber;

    }




    //https://localhost:8080/math/mean/3/5


    //https://localhost:8080/math/square/3/5

}
