/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.controller.mbr;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mbr.client.entity.main.PackagingMaterial;
import mbr.client.entity.mbr.CompoundingProcedure;
import mbr.client.entity.mbr.DosageInProcedure;
import mbr.client.entity.mbr.MBR;
import mbr.client.entity.mbr.PackagingMaterialRequirements;
import mbr.client.entity.mbr.RawMaterialRequirements;
import mbr.client.service.mbr.MBRService;
import mbr.client.service.main.ProductService;
import mbr.client.utils.DateConverter;
import mbr.client.utils.UDFCalculator;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author maine
 */
public class ListController implements Initializable {
    
    @FXML
    HBox _headerHBox;
    
    @FXML
    TableView<MBR> _tableViewMBRList;
    @FXML
    TableColumn<MBR, String> _colProductCode;
    @FXML
    TableColumn<MBR, String> _colProductBrandName;
    @FXML
    TableColumn<MBR, String> _colBatchNo;
    @FXML
    TableColumn<MBR, String> _colBatchSize;
    @FXML
    TableColumn<MBR, Short> _colShelfLife;
    @FXML
    TableColumn<MBR, LocalDate> _colMfgDate;
    @FXML
    TableColumn<MBR, LocalDate> _colExpDate;
    @FXML
    TableColumn<MBR, String> _colPoNo;
    @FXML
    TableColumn<MBR, String> _colPackSize;
    @FXML
    TableColumn<MBR, String> _colVrNo;
    
    MBRService mbrService = new MBRService();
    ProductService productService = new ProductService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initMBRListTableView();
    }
    
    private void initMBRListTableView() {
        _colProductCode.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getProductPackSizeId().getProductId().getCode()));
        _colProductBrandName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getProductPackSizeId().getProductId().getBrandName()));
        _colBatchNo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getBatchNo()));
        _colBatchSize.setCellValueFactory(c -> new SimpleStringProperty("" + c.getValue().getBatchSize() + " " + c.getValue().getUnitId().getName()));
        _colShelfLife.setCellValueFactory(c -> new SimpleObjectProperty("" + c.getValue().getProductPackSizeId().getProductId().getShelfLife()));
        _colMfgDate.setCellValueFactory(c -> new SimpleObjectProperty(DateConverter.convertDateToLocalDate(c.getValue().getMfgDate())));
        _colExpDate.setCellValueFactory(c -> new SimpleObjectProperty(DateConverter.convertDateToLocalDate(c.getValue().getExpDate())));
        _colPoNo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPoNo()));
        _colPackSize
                .setCellValueFactory(
                        c -> new SimpleStringProperty("" + c.getValue().getProductPackSizeId().getPackSizeId().getQuantity() + " "
                                + c.getValue().getProductPackSizeId().getPackSizeId().getUnitId().getName() + " per "
                                + c.getValue().getProductPackSizeId().getPackSizeId().getContainerId().getName())
                );
        _colVrNo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getProductPackSizeId().getProductId().getVrNo()));
        
        ObservableList<MBR> mbrList = mbrService.getMBRList();
        _tableViewMBRList.setItems(mbrList);
    }
    
    @FXML
    public void handleNewButton() {
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
        }
    }
    
    @FXML
    public void handlePrintButton() throws JRException {
        UDFCalculator udfCalculator = new UDFCalculator();
        MBR mbr = _tableViewMBRList.getSelectionModel().getSelectedItem();
        Collection<RawMaterialRequirements> rmReqCollection = mbr.getProductPackSizeId().getProductId().getActiveUdf().getRawMaterialRequirementsCollection();
        Collection<PackagingMaterialRequirements> pmReqCollection = mbr.getProductPackSizeId().getProductId().getActiveUdf().getPackagingMaterialRequirementsCollection();
        for (RawMaterialRequirements rmReq : rmReqCollection) {
            udfCalculator.calculateBatchRawMaterialReq(rmReq, mbr);  //  System.out.println("rmReq.getNewQuantity === " + rmReq.getNewQuantity());
        }
        for (CompoundingProcedure cp : mbr.getProductPackSizeId().getProductId().getActiveManufacturingProcedure().getCompoundingProcedureCollection()) {
            for (DosageInProcedure dip : cp.getDosageInProcedureCollection()) {
                for (RawMaterialRequirements rmr : rmReqCollection) {
                    if (rmr.getId().equals(dip.getRawMaterialRequirementsId().getId())) {
                        dip.setQuantity(rmr.getNewQuantity());
                        dip.setUnit(rmr.getNewUnit());
                    }
                }
            }
        }
        
        for (PackagingMaterialRequirements pmReq : pmReqCollection) {
            pmReq = udfCalculator.calculateBatchPackMatReq(pmReq, mbr);
        }

        //this part gets the bottle and cbox used in the product to be displayed in report
        PackagingMaterial bottleContainer = productService.getBottleContainer(mbr.getProductPackSizeId().getProductId());
        PackagingMaterial cBoxContainer = productService.getCBoxContainer(mbr.getProductPackSizeId().getProductId());
        double noOfBottles = mbrService.getNoOfBottlesInBatch(pmReqCollection, bottleContainer.getId());
        int noOfCBox = mbrService.getNoOfCBox(pmReqCollection, cBoxContainer.getId());
        Integer[] bottleRows = new Integer[getNumberOfReportRows(noOfBottles / 1.02)];
        Integer[] cboxRows = new Integer[noOfCBox];

        //
        Map<String, Object> params = new HashMap();
        params.put("mbr", mbr);
        params.put("bottles", noOfBottles);
        params.put("rows", bottleRows);
        params.put("cbox_rows", cboxRows);
        JasperPrint jasperPrint = JasperFillManager.fillReport("reports/mbr/TABLET HUMAN/mbr_template.jasper",
                params, new JREmptyDataSource());
        JasperViewer.viewReport(jasperPrint, false);
    }
    
    private int getNumberOfReportRows(double size) {
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
    
}
