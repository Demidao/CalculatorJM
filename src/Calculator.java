import controller.Controller;
import misc.Preloader;
import model.Model;
import view.View;

public class Calculator {

    /*
    Класс загрузки калькулятора.
    Сам калькулятор постарался реализовать, используя MVC
     */
    public static void init() throws InterruptedException {
        Controller controller = new Controller();
        View view = new View();
        Model model = new Model();

        controller.setModel(model);
        controller.setView(view);

        view.setController(controller);

        Preloader preloader = new Preloader();
        preloader.start();
        preloader.join();

        view.readConsoleData();
    }

    public static void main(String[] args) throws InterruptedException {
        init();
    }

}
