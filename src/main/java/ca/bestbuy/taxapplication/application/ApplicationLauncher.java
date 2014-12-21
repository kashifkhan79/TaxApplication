/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bestbuy.taxapplication.application;

import ca.bestbuy.taxapplication.entities.TaxJurisdiction;
import ca.bestbuy.taxapplication.service.TaxCalculationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kashif Ahmed Khan
 */
public class ApplicationLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("meta-inf/spring/taxapplication-context.xml");
        final TaxCalculationService taxCalculationService = (TaxCalculationService) context.getBean("taxCalculationService");

        TaxJurisdiction taxJurisdictionBC = (TaxJurisdiction)context.getBean("taxJurisdictionBC");
        TaxJurisdiction taxJurisdictionAB = (TaxJurisdiction)context.getBean("taxJurisdictionAB");
        
        double valueForBC = taxCalculationService.applyTax(taxJurisdictionBC, 100.0);
        System.out.println("value is " + valueForBC);
        
        double valueForAB = taxCalculationService.applyTax(taxJurisdictionAB, 50.0);
        System.out.println("value is " + valueForAB);
    }
    
}
