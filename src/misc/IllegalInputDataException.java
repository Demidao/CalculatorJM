package misc;


/*
* Класс, отвечающий за обработку исключений. Ничего не делает, только сообщает в консоль
* о неправильно введенных данных.
 */

public class IllegalInputDataException extends Exception {

    public IllegalInputDataException(){
        System.out.println("You input invalid data");
        System.out.println("Please, check the instruction and try again later. Buy, buy... ");
    }

    public IllegalInputDataException(String input){
        System.out.println("You input invalid data -> " + input);
        System.out.println("Please, check the instruction and try again later. Buy, buy... ");
    }

}
