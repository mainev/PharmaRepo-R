/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.controls.stackPaneBasedMBRWizard;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 *
 * @author maine
 */
/**
 * basic wizard page class
 */
public abstract class WizardPage extends VBox {

    Button priorButton = new Button("_Previous");
    Button nextButton = new Button("N_ext");
    Button cancelButton = new Button("Cancel");
    Button finishButton = new Button("_Finish");

    WizardPage(String title) {
        Label pageLabel = new Label(title);
        pageLabel.setStyle("-fx-font-weight: bold; -fx-padding: 0 0 5 0;");
        getChildren().add(pageLabel);
        setId(title);
        setSpacing(5);
        setStyle("-fx-padding:10; -fx-background-color: honeydew; -fx-border-color: derive(honeydew, -30%); -fx-border-width: 3;");

        Region spring = new Region();
        VBox.setVgrow(spring, Priority.ALWAYS);
        getChildren().addAll(getContent(), spring, getButtons());

        priorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                priorPage();
            }
        });
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                nextPage();
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getWizard().cancel();
            }
        });
        finishButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getWizard().finish();
            }
        });
    }

    HBox getButtons() {
        Region spring = new Region();
        HBox.setHgrow(spring, Priority.ALWAYS);
        HBox buttonBar = new HBox(5);
        cancelButton.setCancelButton(true);
        finishButton.setDefaultButton(true);
        buttonBar.getChildren().addAll(spring, priorButton, nextButton,
                cancelButton, finishButton);
        return buttonBar;
    }

    abstract Parent getContent();

    boolean hasNextPage() {
        return getWizard().hasNextPage();
    }

    boolean hasPriorPage() {
        return getWizard().hasPriorPage();
    }

    void nextPage() {
        getWizard().nextPage();
    }
    
    public WizardPage getNextPage(){
        return getWizard().getNextPage();
    }

    void priorPage() {
        getWizard().priorPage();
    }

    void navTo(String id) {
        getWizard().navTo(id);
    }

    Wizard getWizard() {
        return (Wizard) getParent();
    }

    public void manageButtons() {
        if (!hasPriorPage()) {
            priorButton.setDisable(true);
        }

        if (!hasNextPage()) {
            nextButton.setDisable(true);
        }
    }
}
