/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.controls.stackPaneBasedMBRWizard;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author maine
 */
/**
 * This page thanks the user for taking the survey
 */
public class ThanksPage extends WizardPage {

    public ThanksPage() {
        super("Thanks");
    }

    Parent getContent() {
   // StackPane stack = StackPaneBuilder.create().children(new Label("Thanks!"))
        //    .build();
        StackPane stack = new StackPane();
        stack.getChildren().add(new Label("Thanks!"));
        VBox.setVgrow(stack, Priority.ALWAYS);
        return stack;
    }
}
