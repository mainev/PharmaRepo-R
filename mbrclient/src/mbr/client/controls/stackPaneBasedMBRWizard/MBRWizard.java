/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.controls.stackPaneBasedMBRWizard;

import javafx.stage.Stage;

/**
 *
 * @author maine
 */
/** This class shows a satisfaction survey */
public class MBRWizard extends Wizard {
  Stage owner;

  public MBRWizard(Stage owner) {
//      BatchDetailsPage batchDetailsPage = new BatchDetailsPage();
//      PackagingProcedurePage packProcPage = new PackagingProcedurePage();
//      ThanksPage thanksPage = new ThanksPage();
    super(new BatchDetailsPage(), new PackagingProcedurePage(), new ThanksPage());
    this.owner = owner;
  }

  public void finish() {
    System.out.println("Had complaint? "
        + MBRData.instance.hasComplaints.get());
    if (MBRData.instance.hasComplaints.get()) {
      System.out.println("Complaints: "
          + (MBRData.instance.complaints.get().isEmpty() ? "No Details"
              : "\n" + MBRData.instance.complaints.get()));
    }
    
    System.out.println("you have selected "+MBRData.instance.selectedProduct);
    System.out.println("product pack size: "+MBRData.instance.getProductPackSize());
     System.out.println("pack procedure collection:"+MBRData.instance.productPackSize.getPackagingProcedureCollection());
       
    owner.close();
  }

  public void cancel() {
    System.out.println("Cancelled");
    owner.close();
  }
}