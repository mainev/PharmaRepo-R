/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.controller.mbr;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import mbr.client.ScreenNavigator;
import mbr.client.controls.TextFieldWithSearch;
import mbr.client.entity.main.Container;
import mbr.client.entity.mbr.MBR;
import mbr.client.entity.mbr.PackSize;
import mbr.client.entity.main.Product;
import mbr.client.entity.mbr.ProductPackSize;
import mbr.client.entity.main.Unit;
import mbr.client.service.main.ContainerService;
import mbr.client.service.mbr.MBRService;
import mbr.client.service.mbr.PackSizeService;
import mbr.client.service.mbr.ProductPackSizeService;
import mbr.client.service.main.ProductService;
import mbr.client.service.main.UnitService;
import mbr.client.utils.DateConverter;
import mbr.client.utils.UDFCalculator;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.dialog.Wizard;
import org.controlsfx.dialog.Wizard.LinearFlow;
import org.controlsfx.dialog.Wizard.WizardPane;

/**
 * FXML Controller class
 *
 * @author maine
 */
public class NewController implements Initializable {

    @FXML
    GridPane _gridPaneInput;
    @FXML
    Label _cancelLabel;
    @FXML
    Label _perLabel;

    @FXML
    ChoiceBox<Container> _newPackSizeContainerChoiceBox;
    @FXML
    TextField _newPackSizeQtyTextField;

    @FXML
    TextField _textFieldBatchNo;
    @FXML
    TextField _textFieldBatchSize;
    @FXML
    ChoiceBox<Unit> _choiceBoxBatchSizeUnit;
    @FXML
    ChoiceBox _packSizeCollectionChoiceBox;
    @FXML
    ChoiceBox<Unit> _packSizeUnitChoiceBox;
    @FXML
    DatePicker _datePickerMfgDate;
    @FXML
    DatePicker _datePickerExpDate;
    @FXML
    TextField _textFieldPoNo;

    @FXML
    VBox _vBoxProductSelection;
    TextFieldWithSearch<Product> textFieldWithProductSearch;
    ProductService productService = new ProductService();
    MBRService mbrService = new MBRService();
    UnitService unitService = new UnitService();
    ContainerService containerService = new ContainerService();
    ProductPackSizeService productPackSizeService = new ProductPackSizeService();
    PackSizeService packSizeService = new PackSizeService();
    Product selectedProduct;
    String ADD_PACK_SIZE_OPTION = "Add new pack size...";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTextFieldWithProductSearch();
        initBatchSizeUnitChoiceBox();
        initContainerChoiceBox();
        initPackSizeUnitChoiceBox();
        initPackSizeCollectionChoiceBox();

        enableAddNewPackSize(false);
    }

    public void enablePackSizeCollectionChoiceBox() {
        _packSizeCollectionChoiceBox.setDisable(false);

    }

    public void enableAddNewPackSize(boolean value) {
        _newPackSizeQtyTextField.setVisible(value);
        _newPackSizeContainerChoiceBox.setVisible(value);
        _packSizeUnitChoiceBox.setVisible(value);
        _cancelLabel.setVisible(value);
        _perLabel.setVisible(value);
    }

    private void initPackSizeCollectionChoiceBox() {

        _packSizeCollectionChoiceBox.getSelectionModel().selectedItemProperty().addListener((ob, ov, nv) -> {
            if (nv != null) {
                if (nv.equals(ADD_PACK_SIZE_OPTION)) {
                    _cancelLabel.setVisible(true);
                    _packSizeCollectionChoiceBox.setDisable(true);
                }

            } else {
                _cancelLabel.setVisible(false);
                _packSizeCollectionChoiceBox.setDisable(false);
            }

        });

        _packSizeCollectionChoiceBox.disableProperty().addListener((ob, ov, nv) -> {

            if (nv) {
                enableAddNewPackSize(true);
                _newPackSizeQtyTextField.requestFocus();
                showPackSizeWizard();
            } else {
                enableAddNewPackSize(false);
                _packSizeCollectionChoiceBox.getSelectionModel().selectFirst();
                _packSizeCollectionChoiceBox.requestFocus();
            }
        });

    }

    private void initPackSizeUnitChoiceBox() {
        _packSizeUnitChoiceBox.setItems(unitService.getUnitList());
    }

    private void initContainerChoiceBox() {
        _newPackSizeContainerChoiceBox.setItems(containerService.getContainerList());
    }

    private void initBatchSizeUnitChoiceBox() {
        _choiceBoxBatchSizeUnit.setItems(unitService.getUnitList());
    }

    /**
     * *
     * Assign product items that is searchable in the text field.
     */
    private void initTextFieldWithProductSearch() {
        ObservableList<Product> productList = productService.getProductList();
        textFieldWithProductSearch = new TextFieldWithSearch(productList);
        textFieldWithProductSearch.setAlignment(Pos.CENTER);
        _gridPaneInput.add(textFieldWithProductSearch, 1, 0);

        textFieldWithProductSearch.listViewSelectedItemProperty().addListener((ob, ov, nv) -> {
            if (nv != null) {
                selectedProduct = (Product) nv;

                //   _packSizeCollectionChoiceBox.getItems().addAll(selectedProduct.packSizeCollectionProperty());
                //   _packSizeCollectionChoiceBox.getItems().add(new Separator());
                _packSizeCollectionChoiceBox.getItems().addAll(packSizeService.getPackSizeList());
                _packSizeCollectionChoiceBox.getItems().add(new Separator());
                _packSizeCollectionChoiceBox.getItems().add(ADD_PACK_SIZE_OPTION);
            }

        });
    }

    @FXML
    private void handleAddButton() {
        //createMBRInstance();
        createMBRJasperReport(createMBRInstance());

        Stage stage = (Stage) _gridPaneInput.getScene().getWindow();
        stage.close();
        ScreenNavigator.loadScreen(ScreenNavigator.MBR_LIST_SCREEN);
    }

    private void createMBRJasperReport(MBR mbr) {
        UDFCalculator udfCalculator = new UDFCalculator();

        // ********** SET RERORT PARAMETERS ***********
        int bottles = 500;
        Integer[] rows = new Integer[getNumberOfReportRows(bottles)];
        Map<String, Object> params = new HashMap();
        params.put("mbr", mbr);
        //   params.put("batch_rm_requirements", udfCalculator.calculateBatchRawMaterialReq(mbr));
        params.put("bottles", bottles);
        params.put("rows", rows);
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport("reports/mbr/TABLET HUMAN/mbr_template.jasper",
                    params, new JREmptyDataSource());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            System.out.println("REPORT EXCEPTIONS: " + e.getMessage());
        }

    }

    private int getNumberOfReportRows(int size) {
        int rows = 0;
        int item = 0;
        int counter = 0;
        while (item < size) {
            counter += 200;
            rows = counter / 5;
            item = item + 200;
        }
        return rows;
    }

//    private MBR calculateRequiredBatchRawMaterialRequirements(MBR mbr){
//        
//    }
    private MBR createMBRInstance() {
        String batchNo = _textFieldBatchNo.getText();
        Double batchSize = Double.parseDouble(_textFieldBatchSize.getText());
        Unit unitId = _choiceBoxBatchSizeUnit.getValue();
        Date mfgDate = DateConverter.convertLocalDateToDate(_datePickerMfgDate.getValue());
        Date expDate = DateConverter.convertLocalDateToDate(_datePickerExpDate.getValue());
        String poNo = _textFieldPoNo.getText();

        ProductPackSize productPackSizeId;
        if (!_packSizeCollectionChoiceBox.disableProperty().getValue()) {
            PackSize packSizeId = (PackSize) _packSizeCollectionChoiceBox.getValue();
            productPackSizeId = productPackSizeService.getProductPackSize(selectedProduct, packSizeId);
        } else {
            productPackSizeId = productPackSizeService.createProductPackSize(selectedProduct, getNewPackSizeValue());

        }

        return mbrService.createMBR(productPackSizeId, batchSize, batchNo, mfgDate, expDate,
                poNo, unitId);
    }

    public PackSize getNewPackSizeValue() {
        double packSizeQuantity = Double.parseDouble(_newPackSizeQtyTextField.getText());
        Container packSizeContainerId = _newPackSizeContainerChoiceBox.getValue();
        Unit packSizeUnit = _packSizeUnitChoiceBox.getValue();

        return packSizeService.createPackSize(packSizeQuantity, packSizeUnit, packSizeContainerId);
    }

    @FXML
    private void handleCancelButton() {
        Stage stage = (Stage) _gridPaneInput.getScene().getWindow();
        stage.close();
    }

    private void showPackSizeWizard() {
        // define pages to show
        Wizard wizard = new Wizard();
        wizard.setTitle("Pack Size Wizard");

        // --- page 1
        int row = 0;

        GridPane page1Grid = new GridPane();
        page1Grid.setVgap(10);
        page1Grid.setHgap(10);

        //packaging procedure template
        page1Grid.add(new Label("Select packaging procedure template:"), 0, row);
        ChoiceBox packSizeChoiceBox = new ChoiceBox();
        packSizeChoiceBox.setId("_packSizeChoiceBox");
        packSizeChoiceBox.setItems(selectedProduct.packSizeCollectionProperty());
        page1Grid.add(packSizeChoiceBox, 1, row++);

        //new pack size
        page1Grid.add(new Label("New pack size:"), 0, row);
        HBox newPackSizeHBox = new HBox();

        //quantity textfield
        TextField newPackSizeQuantityTextField = new TextField();
        newPackSizeQuantityTextField.setId("_quantityTextField");
        newPackSizeQuantityTextField.setPromptText("quantity");

        //pack size unit choice box
        ChoiceBox newPackSizeUnitChoiceBox = new ChoiceBox(unitService.getUnitList());
        newPackSizeUnitChoiceBox.setId("_unitChoiceBox");

        //pack size container choice box
        ChoiceBox newPackSizeContainerChoiceBox = new ChoiceBox(containerService.getContainerList());
        newPackSizeContainerChoiceBox.setId("_containerChoiceBox");

        Label packSizeLabel = new Label("per");
        newPackSizeHBox.setSpacing(10);
        newPackSizeHBox.getChildren().addAll(newPackSizeQuantityTextField, newPackSizeUnitChoiceBox, packSizeLabel, newPackSizeContainerChoiceBox);
        page1Grid.add(newPackSizeHBox, 1, row);

        WizardPane page1 = new WizardPane();
        page1.setHeaderText("Please enter product pack size details");
        page1.setContent(page1Grid);

        // --- page 2
       // PackSize packSizeTemplate = (PackSize) packSizeChoiceBox.getValue();
      //  ProductPackSize selectedProductPackSize = productPackSizeService.getProductPackSize(selectedProduct, packSizeTemplate);
        final WizardPane page2 = new WizardPane() {
            @Override
            public void onEnteringPage(Wizard wizard) {
                    PackSize packSizeTemplate = (PackSize) wizard.getSettings().get("_packSizeChoiceBox");
                //     String lastName = (String) wizard.getSettings().get("lastName");
              //      selectedProductPackSize = productPackSizeService.getProductPackSize(selectedProduct, packSizeTemplate);
                //    setContentText("Product : " +packSizeTemplate);
                //     setContentText("Welcome, " + firstName + " " + lastName + "! Let's add some newlines!\n\n\n\n\n\n\nHello World!");
              
            }
        };
        page2.setHeaderText("Configure In-Filling Packaging Procedure");

        BorderPane page2BorderPane = new BorderPane();

        //packaging procedure steps (list view)
        VBox stepNumbers = new VBox();
        stepNumbers.setPrefSize(200, 300);
        ListView stepNumberListView = new ListView();
        Label stepsLabel = new Label("STEPS");
        stepNumbers.getChildren().addAll(stepsLabel, stepNumberListView);
        page2BorderPane.setLeft(stepNumbers);
        stepNumbers.setAlignment(Pos.CENTER);

        //packaging procedure (filling) editor
        HTMLEditor packagingProcedureEditor = new HTMLEditor();
                
        packagingProcedureEditor.setPrefSize(500, 300);
        page2BorderPane.setCenter(packagingProcedureEditor);
        page2.setContent(page2BorderPane);
        // --- page 3
        WizardPane page3 = new WizardPane();
        page3.setHeaderText("Goodbye!");
        page3.setContentText("Page 3, with extra 'help' button!");

        ButtonType helpDialogButton = new ButtonType("Help", ButtonData.HELP_2);
        page3.getButtonTypes().add(helpDialogButton);
        Button helpButton = (Button) page3.lookupButton(helpDialogButton);
        helpButton.addEventFilter(ActionEvent.ACTION, actionEvent -> {
            actionEvent.consume(); // stop hello.dialog from closing
            System.out.println("Help clicked!");
        });

        // create wizard
        wizard.setFlow(new LinearFlow(page1, page2, page3));

        System.out.println("page1: " + page1);
        System.out.println("page2: " + page2);
        System.out.println("page3: " + page3);

        // show wizard and wait for response
        wizard.showAndWait().ifPresent(result -> {
            if (result == ButtonType.FINISH) {
                System.out.println("Wizard finished, settings: " + wizard.getSettings());
            }
        });
    }

    private TextField createTextField(String id) {
        TextField textField = new TextField();
        textField.setId(id);
        GridPane.setHgrow(textField, Priority.ALWAYS);
        return textField;
    }

}
