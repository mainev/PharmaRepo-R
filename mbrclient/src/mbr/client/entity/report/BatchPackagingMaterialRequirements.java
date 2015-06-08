/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.report;

import mbr.client.entity.main.PackagingMaterial;

/**
 *
 * @author maine
 */
public class BatchPackagingMaterialRequirements {
   PackagingMaterial packagingMaterial;
   String unit;
   double quantity;
   
   public BatchPackagingMaterialRequirements(PackagingMaterial packagingMaterial, String unit, double quantity){
       this.packagingMaterial = packagingMaterial;
       this.unit = unit;
       this.quantity = quantity;
   }

    public PackagingMaterial getPackagingMaterial() {
        return packagingMaterial;
    }

    public void setPackagingMaterial(PackagingMaterial packagingMaterial) {
        this.packagingMaterial = packagingMaterial;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
   
   
}
