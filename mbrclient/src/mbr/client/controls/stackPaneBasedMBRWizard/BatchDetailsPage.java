/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.controls.stackPaneBasedMBRWizard;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import mbr.client.controls.TextFieldWithSearch;
import mbr.client.entity.main.Container;
import mbr.client.entity.main.Product;
import mbr.client.entity.main.Unit;
import mbr.client.entity.mbr.PackSize;
import mbr.client.entity.mbr.ProductPackSize;
import mbr.client.service.main.ContainerService;
import mbr.client.service.main.UnitService;
import mbr.client.service.mbr.PackSizeService;
import mbr.client.service.mbr.ProductPackSizeService;

/**
 *
 * @author maine
 */
/**
 * This class determines if the user has complaints. If not, it jumps to the
 * last page of the wizard.
 */
public class BatchDetailsPage extends WizardPage {

    private RadioButton yes;
    private RadioButton no;
    private ToggleGroup options = new ToggleGroup();

    TextField batchQuantity;
    ChoiceBox batchUnits;
    TextField packSizeQty;
    ComboBox<Unit> packSizeUnits;
    ComboBox<Container> containers;
    DatePicker mfgDatePicker;
    Product selectedProduct;
    SimpleObjectProperty<Product> selectedProductProperty;
    TextFieldWithSearch<ProductPackSize> productSearchTextField;

    public BatchDetailsPage() {
        super("Batch Details");

        nextButton.setDisable(true);
        finishButton.setDisable(true);
        yes.setToggleGroup(options);
        no.setToggleGroup(options);
        options.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue,
                    Toggle oldToggle, Toggle newToggle) {
                //      nextButton.setDisable(false);
                //    finishButton.setDisable(false);
            }
        });
    }

    Parent getContent() {
        yes = new RadioButton("Yes");
        no = new RadioButton("No");
        MBRData.instance.hasComplaints.bind(yes.selectedProperty());
   
        //text field with product selection
        ProductPackSizeService productPackSizeService = new ProductPackSizeService();
        ObservableList<ProductPackSize> productPackSizeList = productPackSizeService.getProductPackSizeList();
        productSearchTextField = new TextFieldWithSearch(productPackSizeList);
        productSearchTextField.setAlignment(Pos.CENTER);
        // productSearchTextField.getListView().setPrefHeight(100);
        productSearchTextField.listViewSelectedItemProperty().addListener((ob, ov, nv) -> {
            if (nv != null) {
                ProductPackSize temp = (ProductPackSize) nv;
                selectedProduct = temp.getProductId();
                updateAddNewPackSizeFields(temp);
                nextButton.setDisable(false);
                finishButton.setDisable(false);
                MBRData.instance.setSelectedProduct(selectedProduct);
            }
        });

        //hbox for batch size unit
        HBox hbox1 = new HBox();
        hbox1.setSpacing(5);
        batchQuantity = new TextField();
        batchUnits = new ChoiceBox(new UnitService().getUnitList());
        hbox1.getChildren().addAll(batchQuantity, new Label("Unit"), batchUnits);

        //Hbox for pack size
        HBox hbox2 = new HBox();
        hbox2.setSpacing(5);
        packSizeQty = new TextField();
        packSizeUnits = new ComboBox(new UnitService().getUnitList());
        containers = new ComboBox(new ContainerService().getContainerList());
        hbox2.getChildren().addAll(packSizeQty, packSizeUnits, new Label("per"), containers);

        mfgDatePicker = new DatePicker();

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(new Label("Do you have complaints?"), yes, no);

        //this grid pane is use to layout mbr fields
        GridPane gridPane = new GridPane();
        //  gridPane.setGridLinesVisible(true);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        //first row
        gridPane.add(new Label("Product"), 0, 0);
        gridPane.add(productSearchTextField, 1, 0);

        //2nd row
        gridPane.add(new Label("Batch Size"), 0, 1);
        gridPane.add(hbox1, 1, 1);

        //3rd row
        gridPane.add(new Label("Pack Size"), 0, 2);
        gridPane.add(hbox2, 1, 2);

        //4th row
        gridPane.add(new Label("Manufacturing Date"), 0, 3);
        gridPane.add(mfgDatePicker, 1, 3);

        vbox.getChildren().add(gridPane);
        return vbox;
    }

    void nextPage() {
        
         ProductPackSize productPackSizeId = new ProductPackSizeService().createProductPackSize(selectedProduct, getPackSizeValue());
         MBRData.instance.setProductPackSize(productPackSizeId);
       
        // If they have complaints, go to the normal next page
        if (options.getSelectedToggle().equals(yes)) {
            super.nextPage();
        } else {
            // No complaints? Short-circuit the rest of the pages
            navTo("Thanks");
        }
    }

    private void updateAddNewPackSizeFields(ProductPackSize pp) {
        packSizeQty.setText(String.valueOf(pp.getPackSizeId().getQuantity()));
        containers.setValue(pp.getPackSizeId().getContainerId());
        packSizeUnits.setValue(pp.getPackSizeId().getUnitId());
    }
    
     public PackSize getPackSizeValue() {
        double packSizeQuantity = Double.parseDouble(packSizeQty.getText());
        Container packSizeContainerId = containers.getValue();
        Unit packSizeUnit = packSizeUnits.getValue();
        return new PackSizeService().createPackSize(packSizeQuantity, packSizeUnit, packSizeContainerId);
    }

}
