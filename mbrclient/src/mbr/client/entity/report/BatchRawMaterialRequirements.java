/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.report;

import mbr.client.entity.main.RawMaterial;

/**
 *
 * @author maine
 */
public class BatchRawMaterialRequirements {

    private RawMaterial rawMaterial;
    private double oldQuantity;
    private String oldUnit;
    private double newQuantity;
    private String newUnit;

    public BatchRawMaterialRequirements(RawMaterial rawMaterial, double oldQuantity, String oldUnit, double newQuantity,
            String newUnit) {
        this.rawMaterial = rawMaterial;
        this.oldQuantity = oldQuantity;
        this.oldUnit = oldUnit;
        this.newQuantity = newQuantity;
        this.newUnit = newUnit;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public double getOldQuantity() {
        return oldQuantity;
    }

    public void setOldQuantity(double oldQuantity) {
        this.oldQuantity = oldQuantity;
    }

    public String getOldUnit() {
        return oldUnit;
    }

    public void setOldUnit(String oldUnit) {
        this.oldUnit = oldUnit;
    }

    public double getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(double newQuantity) {
        this.newQuantity = newQuantity;
    }

    public String getNewUnit() {
        return newUnit;
    }

    public void setNewUnit(String newUnit) {
        this.newUnit = newUnit;
    }

}
