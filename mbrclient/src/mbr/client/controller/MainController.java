/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mbr.client.ScreenNavigator;
import mbr.client.controls.stackPaneBasedMBRWizard.MBRWizard;
import mbr.client.controls.TextFieldWithSearch;
import mbr.client.entity.main.Container;
import mbr.client.entity.main.Unit;
import mbr.client.entity.mbr.ProductPackSize;
import mbr.client.service.main.ContainerService;
import mbr.client.service.main.UnitService;
import mbr.client.service.mbr.ProductPackSizeService;

/**
 *
 * @author maine
 */
public class MainController implements Initializable {

    @FXML
    StackPane _mainStackPane;
    @FXML
    ToggleButton _menuButtonMBR;
    @FXML
    ToggleButton _menuButtonEditor;

    final ToggleGroup menuToggleGroup = new ToggleGroup();
    ProductPackSizeService productPackSizeService = new ProductPackSizeService();
    // ObservableList<ProductPackSize> productPackSizeList = productPackSizeService.getProductPackSizeList();
    UnitService unitService = new UnitService();
    ContainerService containerService = new ContainerService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setMenuButtonToggleGroup();
        addToggleGroupListener();

        //    initTextFieldWithProductSearch();
    }

    private void addToggleGroupListener() {
        _menuButtonMBR.setUserData(ScreenNavigator.MBR_LIST_SCREEN);

        menuToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                    Toggle toggle, Toggle new_toggle) {
                if (new_toggle == null) {
                    ScreenNavigator.loadScreen(ScreenNavigator.WELCOME_SCREEN);
                } else {
                    ScreenNavigator.loadScreen((String) menuToggleGroup.getSelectedToggle().getUserData());
                }
            }
        });
    }

    private void setMenuButtonToggleGroup() {
        _menuButtonMBR.setToggleGroup(menuToggleGroup);
        //  _menuButtonMBREditor.setToggleGroup(menuToggleGroup);
    }

    TextFieldWithSearch<ProductPackSize> textFieldWithProductSearch;
    TextField batchSizeQuantityTextField = new TextField();
    ChoiceBox<Unit> batchSizeUnitChoiceBox = new ChoiceBox(unitService.getUnitList());
    ComboBox<Unit> packSizeUnitComboBox = new ComboBox(unitService.getUnitList());
    ComboBox<Container> packSizeContainerComboBox = new ComboBox(containerService.getContainerList());
    TextField packSizeQuantityTextField = new TextField();
    // Product selectedProduct;

    private void initTextFieldWithProductSearch() {
        ObservableList<ProductPackSize> productPackSizeList = productPackSizeService.getProductPackSizeList();

        textFieldWithProductSearch = new TextFieldWithSearch(productPackSizeList);
        textFieldWithProductSearch.setAlignment(Pos.CENTER);

        textFieldWithProductSearch.listViewSelectedItemProperty().addListener((ob, ov, nv) -> {
            if (nv != null) {
                ProductPackSize temp = (ProductPackSize) nv;
               // selectedProduct = temp.getProductId();

                // updateAddNewPackSizeFields(temp);
            }

        });
    }

    private void updateAddNewPackSizeFields(ProductPackSize pp) {
        packSizeQuantityTextField.setText(String.valueOf(pp.getPackSizeId().getQuantity()));
        packSizeContainerComboBox.setValue(pp.getPackSizeId().getContainerId());
        packSizeUnitComboBox.setValue(pp.getPackSizeId().getUnitId());
    }

    public void createNewMBR() {
        /*
         try {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mbr/client/view/mbr/new.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.initStyle(StageStyle.UNDECORATED);
         stage.setTitle("Create New MBR");
         stage.setScene(new Scene(root1));
         stage.show();
         } catch (IOException e) {
         e.printStackTrace();
         System.out.println("EXCEPTIONS: \n" + e.getMessage());
         }*/

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Create New MBR");
        stage.setScene(new Scene(new MBRWizard(stage), 600, 450));
        stage.show();

    }

    public void setScreen(Node node) {
        _mainStackPane.getChildren().setAll(node);
    }

    public void closeApp() {
        Stage stage = (Stage) _mainStackPane.getScene().getWindow();
        stage.close();

    }
}
