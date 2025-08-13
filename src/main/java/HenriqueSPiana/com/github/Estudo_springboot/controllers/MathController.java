package HenriqueSPiana.com.github.Estudo_springboot.controllers;

import HenriqueSPiana.com.github.Estudo_springboot.exception.UnsupportedMathOperationException;
import HenriqueSPiana.com.github.Estudo_springboot.math.SimpleMath;
import HenriqueSPiana.com.github.Estudo_springboot.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();


    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{num1}/{num2}")
    public Double sum(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws UnsupportedMathOperationException {
        if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.sum(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));


    };



    //https://localhost:8080/math/sub/3/5
    @RequestMapping("/sub/{num1}/{num2}")
    public Double sub(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws UnsupportedMathOperationException {
        if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.sub(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));

    };

    //https://localhost:8080/math/mult/3/5
    @RequestMapping("/mult/{num1}/{num2}")
    public Double mult(@PathVariable("num1") String num1, @PathVariable("num2") String num2)throws UnsupportedMathOperationException{
        if(!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value");
        Double multNumber = math.mult(NumberConverter.convertToDouble(num2), NumberConverter.convertToDouble(num1));
        return multNumber;
    }


    //https://localhost:8080/math/div/3/5
    @RequestMapping("/div/{num1}/{num2}")
    public Double div(@PathVariable("num1") String num1,@PathVariable("num2") String num2)throws UnsupportedMathOperationException{
        if(!NumberConverter.isNumeric(num1)||!NumberConverter.isNumeric(num2) )  throw new UnsupportedMathOperationException("Please set a numeric value");
        if(num2.equals("0")) throw new UnsupportedMathOperationException("enter a non-zero denominator");
        Double divNumber = math.div(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
        return divNumber;

    }




    //https://localhost:8080/math/mean/3/5

    @RequestMapping("/mean/{num1}/{num2}")
    public Double mean(@PathVariable("num1") String num1,@PathVariable("num2") String num2)throws UnsupportedMathOperationException{
        if(!NumberConverter.isNumeric(num1)||!NumberConverter.isNumeric(num2) )  throw new UnsupportedMathOperationException("Please set a numeric value");
        if(sum(num1, num2)==0) throw new UnsupportedMathOperationException("enter a non-zero division");
        if(num1.equals("0") & num1.equals("0") ) return 0D;

        Double meanNumber = math.mean(NumberConverter.convertToDouble (num1),NumberConverter.convertToDouble(num2));
        return meanNumber;


    }



    //https://localhost:8080/math/square/3
    @RequestMapping("/square/{num}")
    public Double square(@PathVariable("num") String num) throws UnsupportedMathOperationException{
        if(!NumberConverter.isNumeric(num)) throw new UnsupportedMathOperationException("Please set a numeric value");
        if(num.equals("0")) throw new UnsupportedMathOperationException("enter a non-zero number");

        Double squareNumber = math.square(NumberConverter.convertToDouble(num));
        return squareNumber;
    }



}
