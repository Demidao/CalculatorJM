package controller;

import misc.IllegalInputDataException;
import misc.Util;
import model.Model;
import view.View;

/*
Controller в MVC. Используем для управления view и model.
Также в этом классе мы проверяем данные на валидность.
 */

public class Controller {

    private Model model;
    private View view;

    // метод запуска обработки полученных от пользователя данных
    public void processingData(String input) throws IllegalInputDataException {
        model.doMagic(input);
        view.refresh(model.getAnswer());
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }
}
