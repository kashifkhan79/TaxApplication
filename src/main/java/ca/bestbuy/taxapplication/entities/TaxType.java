/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bestbuy.taxapplication.entities;

/**
 *
 * @author Kashif Ahmed Khan
 */
public interface TaxType {
    String getName();
    void setName(final String type);
    double getValue();
    void setValue(final double value);
}
