package app.controllers;

import app.models.AppModel;
import app.utils.Constants;
import app.views.AppView;

import static java.lang.String.format;

public class AppController {
    private AppView view = new AppView();
    public void handleData() {
        int option = view.getOption();
        switch (option) {
            case 1 -> {
                executeFileCreatingWriting();
                handleData();
            }
            case 2 -> {
                executeFileReading();
                handleData();
            }
            case 0 -> view.getOutput(Constants.APP_CLOSED_MSG);
        }
    }

    private void executeFileReading() {
        AppModel model = new AppModel(
                view.getText(format(Constants.ENTER_FILE_NAME_MSG, "read")));
        view.getOutput(model.getFileReadService().readFile());
    }

    private void executeFileCreatingWriting() {
        AppModel model = new AppModel(
                view.getText(format(Constants.ENTER_FILE_NAME_MSG, "created")),
                view.getText(Constants.ENTER_TXT_MSG));
        view.getOutput(model.getFileWriteService().createFile());
        view.getOutput(model.getFileWriteService().writeFile());
    }
}
