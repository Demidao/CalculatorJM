package misc;

/*
* Класс создал, чтобы сделть калькулятор поинтереснее
* Тут просто загружаются слова и точки, имитируя загрузку больших данных
 */

public class Preloader extends Thread {

    private static final int NUM_OF_POINTS = 10;

    @Override
    public void run() {
        try {
            System.out.print("Magic calculator is loading..Please, wait");
            Thread.sleep(1000);
            for (int i = 0; i < NUM_OF_POINTS; i++){
                System.out.print(".");
                Thread.sleep(i > NUM_OF_POINTS /2? 500: 300);
            }
            System.out.println("We are ready to magic!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
