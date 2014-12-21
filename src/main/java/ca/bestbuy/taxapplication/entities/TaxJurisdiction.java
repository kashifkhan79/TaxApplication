/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bestbuy.taxapplication.entities;

import java.util.List;

/**
 *
 * @author Kashif Ahmed Khan
 */
public interface TaxJurisdiction {
    String getName();
    void setName(final String name);
    List<TaxType> getTaxTypes();
    void setTaxTypes(final List<TaxType> taxTypes);
}
