/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mbr.client.entity.main.PackagingMaterial;
import mbr.client.entity.report.BatchPackagingMaterialRequirements;
import mbr.client.entity.report.BatchRawMaterialRequirements;
import mbr.client.entity.mbr.MBR;
import mbr.client.entity.main.Product;
import mbr.client.entity.main.RawMaterial;
import mbr.client.entity.mbr.PackagingMaterialRequirements;
import mbr.client.entity.mbr.RawMaterialRequirements;

public class UDFCalculator {

   double newQty;
   String newUnit;
/*
    public List<BatchRawMaterialRequirements> calculateBatchRawMaterialReq(MBR mbr) {
        List<BatchRawMaterialRequirements> resultList = new ArrayList();

        double multiplier = getUdfMultiplier(mbr);
        Product product = mbr.getProductPackSizeId().getProductId();
        Collection<RawMaterialRequirements> rmReqCollection = product.getActiveUdf().getRawMaterialRequirementsCollection();

        for (RawMaterialRequirements rmReq : rmReqCollection) {
            RawMaterial rawMaterial = rmReq.getRawMaterialId();
            double oldQty = rmReq.getQuantity();
            String oldUnit = rmReq.getUnitId().getName();
            
            double newQty = (oldQty * multiplier);
            String newUnit = oldUnit;
            rawMaterialQuantityAndUnitConverter();
            resultList.add(new BatchRawMaterialRequirements(rawMaterial, oldQty, oldUnit, roundThreeDecimals(newQty), newUnit));
        }
        return resultList;
    }
*/
    public RawMaterialRequirements calculateBatchRawMaterialReq(RawMaterialRequirements rmr, MBR mbr) {
        double multiplier = getUdfMultiplier(mbr);

        double oldQty = rmr.getQuantity();
        String oldUnit = rmr.getUnitId().getName();

        newQty = (oldQty * multiplier);
        newUnit = oldUnit;
        rawMaterialQuantityAndUnitConverter();
      //  System.out.println("calculated new quantity : " + newQty);
        rmr.setNewQuantity(roundThreeDecimals(newQty));
        
    //   System.out.println("rmr.getNewQuantity() : " + rmr.getNewQuantity());
        rmr.setNewUnit(newUnit);
        return rmr;
    }

    public PackagingMaterialRequirements calculateBatchPackMatReq(PackagingMaterialRequirements pmReq, MBR mbr) {
        double batchSize = mbr.getBatchSize();
        double quantity = pmReq.getQuantity() * batchSize;
        pmReq.setNewQuantity(quantity);

        return pmReq;
    }

    public List<BatchPackagingMaterialRequirements> calculateBatchPackMatReq(MBR mbr) {
        List<BatchPackagingMaterialRequirements> pList = new ArrayList();
        double batchSize = mbr.getBatchSize();
        Collection<PackagingMaterialRequirements> packagingMaterialReqCollection = mbr.getProductPackSizeId().getProductId().getActiveUdf().getPackagingMaterialRequirementsCollection();

        for (PackagingMaterialRequirements pmr : packagingMaterialReqCollection) {
            PackagingMaterial packMat = pmr.getPackagingMaterialId();
            double quantity = pmr.getQuantity() * batchSize;
            String unit = pmr.getUnitId().getName();

            pList.add(new BatchPackagingMaterialRequirements(packMat, unit, quantity));
        }
        return pList;
    }

    /**
     * *
     * This multiplier is only applicable for the following units:
     * <p>
     * @Batch size unit : kg, g, L, mL
     * <p>
     * Udf content unit : mcg, mg, g, mcL, mL
     *
     * @param mbr
     * @return <code>MBR</code>
     */
    public double getUdfMultiplier(MBR mbr) {
        Product product = mbr.getProductPackSizeId().getProductId();
        double batchSize = mbr.getBatchSize();
        String batchSizeUnit = mbr.getUnitId().getName();
        double udfContent = product.getActiveUdf().getContent();
        String udfContentUnit = product.getActiveUdf().getUnitId().getName();
        double multiplier = 1;

        if (!batchSizeUnit.equals(udfContentUnit)) {
            switch (batchSizeUnit) {
                case "kg":
                    if (udfContentUnit.equals("g")) {
                        multiplier = (MetricConverter.convertKilogramToGram(batchSize) / udfContent);
                    } else if (udfContentUnit.equals("mcg")) {
                        multiplier = (MetricConverter.convertKilogramToMicrogram(batchSize) / udfContent);
                    } else if (udfContentUnit.equals("mg")) {
                        multiplier = (MetricConverter.convertKilogramToMilligram(batchSize) / udfContent);
                    }
                    break;
                case "g":
                    if (udfContentUnit.equals("mg")) {
                        multiplier = (MetricConverter.convertGramToMilligram(batchSize) / udfContent);
                    } else if (udfContentUnit.equals("mcg")) {
                        multiplier = (MetricConverter.convertGramToMicrogram(batchSize) / udfContent);
                    }
                    break;
                //add another case here for weight unit

                case "L":
                    if (udfContentUnit.equals("mL")) {
                        multiplier = (MetricConverter.convertLitreToMillilitre(batchSize) / udfContent);
                    } else if (udfContentUnit.equals("mcL")) {
                        multiplier = (MetricConverter.convertLitreToMicrolitre(batchSize) / udfContent);
                    }
                    break;
                case "mL":
                    if (udfContentUnit.equals("mcL")) {
                        multiplier = (MetricConverter.convertMillilitreToMicrolitre(batchSize) / udfContent);
                    }

                default:
                    break;
            }
        } else {
            multiplier = batchSize / udfContent;
        }

        return multiplier;
    }

    public void rawMaterialQuantityAndUnitConverter() {
        if (newUnit != "L" || newUnit != "kg") {
            if (newQty >= 1e3 && newQty < 1e6) {
                switch (newUnit) {
                    case "mcL":
                        newQty = MetricConverter.convertMicrolitreToMillilitre(newQty);
                        newUnit = "mL";
                        break;
                    case "mL":
                        newQty = MetricConverter.convertMillilitreToLitre(newQty);
                        newUnit = "L";
                        break;
                    case "mcg":
                        newQty = MetricConverter.convertMicrogramToMilligram(newQty);
                        newUnit = "mg";
                        break;
                    case "mg":
                        newQty = MetricConverter.convertMilligramToGram(newQty);
                        newUnit = "g";
                        break;
                    case "g":
                        newQty = MetricConverter.convertGramToKilogram(newQty);
                        newUnit = "kg";
                        break;
                }
            } else if (newQty >= 1e6 && newQty < 1e9) {
                switch (newUnit) {
                    case "mcL":
                        newQty = MetricConverter.convertMicrolitreToLitre(newQty);
                        newUnit = "L";
                        break;
                    case "mL":
                        newQty = MetricConverter.convertMillilitreToLitre(newQty);
                        newUnit = "L";
                        break;
                    case "mcg":
                        newQty = MetricConverter.convertMicrogramToGram(newQty);
                        newUnit = "g";
                        break;
                    case "mg":
                        newQty = MetricConverter.convertMilligramToKilogram(newQty);
                        newUnit = "kg";
                        break;
                    case "g":
                        newQty = MetricConverter.convertGramToKilogram(newQty);
                        newUnit = "kg";
                        break;
                }
            } else if (newQty >= 1e9) {
                switch (newUnit) {
                    case "mcL":
                        newQty = MetricConverter.convertMicrolitreToLitre(newQty);
                        newUnit = "L";
                        break;
                    case "mL":
                        newQty = MetricConverter.convertMillilitreToLitre(newQty);
                        newUnit = "L";
                        break;
                    case "mcg":
                        newQty = MetricConverter.convertMicrogramToKilogram(newQty);
                        newUnit = "kg";
                        break;
                    case "mg":
                        newQty = MetricConverter.convertMilligramToKilogram(newQty);
                        newUnit = "kg";
                        break;
                    case "g":
                        newQty = MetricConverter.convertGramToKilogram(newQty);
                        newUnit = "kg";
                        break;
                }
            }

        }//

    }
//

    public static double roundThreeDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.###");
        return Double.valueOf(twoDForm.format(d));
    }

    public static double roundZeroDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#");
        return Double.valueOf(twoDForm.format(d));
    }
}
