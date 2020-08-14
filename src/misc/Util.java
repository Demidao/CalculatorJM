package misc;

import java.util.ArrayList;
import java.util.HashMap;


/*
Вспомогательный класс, в котором хранится справочная информация для использования
и проверки на валидность.
 */


public class Util {

    public static final int NUM_ELEMENTS_IN_INPUT = 3; // тут храним количество введенных
                                                        // пользователем элементов в формуле. Если, допустим, нужно
                                                        //будет вводить a + b + c, то элементов уже будет 5 и т.д.
    private static final int MAX_DIGIT = 10; // ограничение для количество цифр от 1 до 10
    public static final ArrayList<String> ARABIAN_VALID_DIGITS = new ArrayList<>(); // разрешенные арабские цифры
    public static final ArrayList<String> ROMA_VALID_DIGITS = new ArrayList<>(); // разрешенные римские цифры
    public static final ArrayList<String> VALID_OPS = new ArrayList<>(); // разрешенные мат.операции
    public static final HashMap<Integer, String> ROMA_DIGITS = new HashMap<>(); // таблица соответствия римских и арабских цифр


    static {
        for (int i = 1; i < MAX_DIGIT + 1; i++){
            ARABIAN_VALID_DIGITS.add(String.valueOf(i));
        }

        ROMA_VALID_DIGITS.add("I");
        ROMA_VALID_DIGITS.add("II");
        ROMA_VALID_DIGITS.add("III");
        ROMA_VALID_DIGITS.add("IV");
        ROMA_VALID_DIGITS.add("V");
        ROMA_VALID_DIGITS.add("VI");
        ROMA_VALID_DIGITS.add("VII");
        ROMA_VALID_DIGITS.add("VIII");
        ROMA_VALID_DIGITS.add("IX");
        ROMA_VALID_DIGITS.add("X");

        VALID_OPS.add("+");
        VALID_OPS.add("-");
        VALID_OPS.add("*");
        VALID_OPS.add("/");

        ROMA_DIGITS.put(0,"0");
        ROMA_DIGITS.put(1,"I");
        ROMA_DIGITS.put(2,"II");
        ROMA_DIGITS.put(3,"III");
        ROMA_DIGITS.put(4,"IV");
        ROMA_DIGITS.put(5,"V");
        ROMA_DIGITS.put(6,"VI");
        ROMA_DIGITS.put(7,"VII");
        ROMA_DIGITS.put(8,"VIII");
        ROMA_DIGITS.put(9,"IX");
        ROMA_DIGITS.put(10,"X");
        ROMA_DIGITS.put(11,"XI");
        ROMA_DIGITS.put(20,"XX");
        ROMA_DIGITS.put(30,"XXX");
        ROMA_DIGITS.put(40,"XL");
        ROMA_DIGITS.put(50,"L");
        ROMA_DIGITS.put(60,"LX");
        ROMA_DIGITS.put(70,"LXX");
        ROMA_DIGITS.put(80,"LXXX");
        ROMA_DIGITS.put(90,"XC");
        ROMA_DIGITS.put(100,"C");
        ROMA_DIGITS.put(200,"CC");
        ROMA_DIGITS.put(300,"CCC");
        ROMA_DIGITS.put(400,"CD");
    }


}
