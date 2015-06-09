/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.controls.stackPaneBasedMBRWizard;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mbr.client.entity.main.Product;
import mbr.client.entity.mbr.ProductPackSize;

/**
 *
 * @author maine
 */
/**
 * Simple placeholder class for the customer entered survey response.
 */
public class MBRData {

    BooleanProperty hasComplaints = new SimpleBooleanProperty();
    StringProperty complaints = new SimpleStringProperty();
    static MBRData instance = new MBRData();
    
Product selectedProduct = new Product();
 ProductPackSize productPackSize = new ProductPackSize();
   
  //   Product selectedProduct;
 //  ProductPackSize productPackSize ;

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public ProductPackSize getProductPackSize() {
        return productPackSize;
    }

    public void setProductPackSize(ProductPackSize productPackSize) {
        this.productPackSize = productPackSize;
    }
   
   
}


