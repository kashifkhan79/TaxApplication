/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bestbuy.taxapplication.dao;

import ca.bestbuy.taxapplication.entities.TaxJurisdiction;
import ca.bestbuy.taxapplication.entities.TaxType;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kashif Ahmed Khan
 */
public interface TaxJurisdictionDao {
    void setJurisdictions(final Map<String, TaxJurisdiction> jurisdictions);
    Map<String, TaxJurisdiction> getJurisdictions();
    List<TaxType> getTaxTypesForJurisdiction(final String name);
}
