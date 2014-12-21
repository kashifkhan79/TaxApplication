/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bestbuy.taxapplication.service;

import ca.bestbuy.taxapplication.dao.TaxJurisdictionDao;
import ca.bestbuy.taxapplication.entities.TaxJurisdiction;
import ca.bestbuy.taxapplication.entities.TaxType;
import java.util.List;

/**
 *
 * @author Kashif Ahmed Khan
 */

public class TaxCalculationServiceImpl implements TaxCalculationService {
    private TaxJurisdictionDao taxJurisdictionDao;
    
    @Override
    public TaxJurisdictionDao getTaxJurisdictionDao() {
        return this.taxJurisdictionDao;
    }

    @Override
    public void setTaxJurisdictionDao(final TaxJurisdictionDao taxJurisdictionDao) {
        this.taxJurisdictionDao = taxJurisdictionDao;
    }
    
    @Override
    public double applyTax(final TaxJurisdiction taxJurisdiction, final double itemValue) {
        double tax = 0.0;
        List<TaxType> taxTypes = this.getTaxJurisdictionDao().getTaxTypesForJurisdiction(taxJurisdiction.getName());
        
        if(null != taxTypes && !taxTypes.isEmpty()) {
            for(TaxType type : taxTypes) {
                tax += itemValue * type.getValue()/100.00;
            }
        }        
        return tax;
    }
}
