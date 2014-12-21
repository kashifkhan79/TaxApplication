/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bestbuy.taxapplication.entities;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Kashif Ahmed Khan
 */
public class TaxJurisdictionImpl implements TaxJurisdiction {
    
    private String name;
    private List<TaxType> taxTypes;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public List<TaxType> getTaxTypes() {
        return this.taxTypes;
    }

    @Override
    public void setTaxTypes(final List<TaxType> taxTypes) {
        this.taxTypes = taxTypes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.taxTypes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaxJurisdictionImpl other = (TaxJurisdictionImpl) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.taxTypes, other.taxTypes)) {
            return false;
        }
        return true;
    }
    
}
