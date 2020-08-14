package view;

import controller.Controller;
import misc.IllegalInputDataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
View в MVC. Используем для имитации пользовательского интерфейса.
Класс ждет ввод от пользователя и обновляет данные в консоле.
 */

public class View {

    private Controller controller;

    public void readConsoleData() {
        System.out.print("Please, input variables: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            while (input != null) {
                controller.processingData(input);
                System.out.print("Please, input variables: ");
                input = reader.readLine();
            }
        }catch (IllegalInputDataException e){
            //do nothing
        }
        catch (IOException e) {
            System.out.println("System is down. It's not you fault... Try again later");
        }


    }

    //обновляем экран пользователя в зависимости от ответа
    public void refresh(String answer){
        System.out.println("Answer is: " + answer);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

}
