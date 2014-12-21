/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bestbuy.taxapplication.dao;

import ca.bestbuy.taxapplication.entities.TaxJurisdiction;
import ca.bestbuy.taxapplication.entities.TaxType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kashif Ahmed Khan
 */
public class TaxJurisdictionRepository implements TaxJurisdictionDao{
    
    private Map<String, TaxJurisdiction> jurisdictions;
    
    @Override
    public void setJurisdictions(final Map<String, TaxJurisdiction> jurisdictions) {
        this.jurisdictions = jurisdictions;
    }
    
    @Override
    public Map<String, TaxJurisdiction> getJurisdictions() {
        return this.jurisdictions;
    }
    
    @Override
    public List<TaxType> getTaxTypesForJurisdiction(final String name) {
        return populateTaxTypes(name);
    }
    
    private List<TaxType> populateTaxTypes(final String name) {
        List<TaxType> taxTypes = new ArrayList<>();
        if(null != name && !"".equals(name) ) {
            TaxJurisdiction jurisdiction = this.getJurisdictions().get(name);
            if(null != jurisdiction) {
                List<TaxType> types = jurisdiction.getTaxTypes();
                if(null != types && !types.isEmpty())
                    for(TaxType type : types) {
                        taxTypes.add(type);
                    }
            }
        }
        return taxTypes;
    }
}
