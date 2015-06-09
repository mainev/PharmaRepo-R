/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.controls.stackPaneBasedMBRWizard;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author maine
 */
/**
 * This page gathers more information about the complaint
 */
public class PackagingProcedurePage extends WizardPage {

    public PackagingProcedurePage() {
        super("Configure Packaging Procedure");
    }

    ListView listView1;
    Parent getContent() {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        // TextArea textArea = TextAreaBuilder.create().wrapText(true).build();
        nextButton.setDisable(true);
        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue,
                    String oldValue, String newValue) {
                nextButton.setDisable(newValue.isEmpty());
            }
        });
        MBRData.instance.complaints.bind(textArea.textProperty());

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(new Label("Edit packaging procedure here:"), textArea);

        listView1 = new ListView();
      //  if(MBRData.instance.getProductPackSize()!=null)
     //     Bindings.bindContent(MBRData.instance.getProductPackSize().packagingProcedureListProperty(), listView1.getSelectionModel().getSelectedItems());  
        BorderPane mainBorderPane = new BorderPane();
        mainBorderPane.setLeft(listView1);
        vbox.getChildren().add(mainBorderPane);
        return vbox;
        //return VBoxBuilder.create().spacing(5)
        //   .children(new Label("Please enter your complaints."), textArea).build();
    }
}
