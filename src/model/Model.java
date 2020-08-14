package model;

import misc.IllegalInputDataException;
import misc.Util;

/*
Model в MVC. Класс, отвечающий за логику работы калькулятора.
Тут происходит обработка валидных данных и формируется ответ в нужном виде.
 */

public class Model {

    private String answer; // результат вычислений хранится тут

    //основной метод калькуляции переданных данных
    public void doMagic(String input) throws IllegalInputDataException {
        if (isValid(input)){
            String[] data = input.split(" ");
            boolean isArabian = Util.ARABIAN_VALID_DIGITS.contains(data[0]);

            if (!isArabian){
                data = convertToArabian(data);
            }
            float res = Float.parseFloat(data[0]);

            for (int i = 1; i < data.length - 1; i = i + 2){
                switch (data[i]){
                    case "+":{
                        res = res + Float.parseFloat(data[i + 1]);
                        break;
                    }
                    case "-":{
                        res = res - Float.parseFloat(data[i + 1]);
                        break;
                    }
                    case "*":{
                        res = res * Float.parseFloat(data[i + 1]);
                        break;
                    }
                    case  "/":{
                        res = res / Float.parseFloat(data[i + 1]);
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }

            if (isArabian){
                answer = String.valueOf((int) res);
            } else {
                answer = getRomanAnswer((int) res);
            }
        }
    }

    public String getAnswer() {
        return answer;
    }

    //вспомогательный метод для проверки на валидность введных пользователем данных
    private boolean isValid(String input) throws IllegalInputDataException {
        String[] data = input.split(" ");
        boolean isArabian = Util.ARABIAN_VALID_DIGITS.contains(data[0]);

        //если введено больше или меньше количества обязательных элементов, то НЕ валидно
        if (data.length != Util.NUM_ELEMENTS_IN_INPUT){
            throw new IllegalInputDataException();
        }

        // в цикле через элемент проверяем, все ли введенные цифры или арабские, или римские
        for (int i = 0; i < data.length; i = i + 2){
            if(isArabian){
                if (!Util.ARABIAN_VALID_DIGITS.contains(data[i])){
                    throw new IllegalInputDataException();
                }
            } else{
                if (!Util.ROMA_VALID_DIGITS.contains(data[i])){
                    throw new IllegalInputDataException();
                }
            }
        }
        // в цикле через элемент проверяем, все ли математические операции валидны
        for (int i = 1; i < data.length; i = i + 2){
            if (!Util.VALID_OPS.contains(data[i])){
                throw new IllegalInputDataException();
            }
        }
        return true;
    }

    //вспомогательный метод для подготовки ответа в римском формате
    private String getRomanAnswer(int num){
        if (Util.ROMA_DIGITS.containsKey(Math.abs(num))){
            return num >= 0? Util.ROMA_DIGITS.get(Math.abs(num)) : "-" + Util.ROMA_DIGITS.get(Math.abs(num));
        }

        int decimal = (Math.abs(num) / 10) * 10;
        int ones = Math.abs(num) - decimal;
        String out = Util.ROMA_DIGITS.get(decimal) + Util.ROMA_DIGITS.get(ones);

        return num >= 0? out: "-" + out;
    }

    //вспомогательный метод для конвертации входных данных в римском формате в арабский формат
    private String[] convertToArabian(String[] romanData){

        String[] convertedData = new String[romanData.length];
        for(int i = 0; i < romanData.length; i++){
            if(i % 2 == 0){
                convertedData[i] = String.valueOf(Util.ROMA_VALID_DIGITS.indexOf(romanData[i]) + 1);
            }else {
                convertedData[i] = romanData[i];
            }
        }
        return convertedData;
    }
}
