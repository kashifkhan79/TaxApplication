/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bestbuy.taxapplication.service;

import ca.bestbuy.taxapplication.dao.TaxJurisdictionDao;
import ca.bestbuy.taxapplication.entities.TaxJurisdiction;

/**
 *
 * @author Kashif Ahmed Khan
 */
public interface TaxCalculationService {
    TaxJurisdictionDao getTaxJurisdictionDao();
    void setTaxJurisdictionDao(final TaxJurisdictionDao taxJurisdictionDao);
    double applyTax(final TaxJurisdiction taxJurisdiction, final double itemValue);
}
