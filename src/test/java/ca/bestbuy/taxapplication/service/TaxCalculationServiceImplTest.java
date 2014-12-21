/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bestbuy.taxapplication.service;

import ca.bestbuy.taxapplication.dao.TaxJurisdictionDao;
import ca.bestbuy.taxapplication.entities.TaxJurisdiction;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kashif Ahmed Khan
 */
public class TaxCalculationServiceImplTest {
    
    private ClassPathXmlApplicationContext context;
    private TaxCalculationService taxCalculationService;
    private TaxJurisdictionDao taxJurisdictionDao;
    private TaxJurisdiction taxJurisdictionBC;
    private TaxJurisdiction taxJurisdictionAB;
    
    private final String configPath = "meta-inf/spring/taxapplication-context.xml";
     
    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext(configPath);
        taxJurisdictionBC = (TaxJurisdiction)context.getBean("taxJurisdictionBC");
        taxJurisdictionAB = (TaxJurisdiction)context.getBean("taxJurisdictionAB");
        taxCalculationService = context.getBean(TaxCalculationService.class);
    }
    
    @After
    public void tearDown() {
        context = null;
        taxJurisdictionBC = null;
        taxJurisdictionAB = null;
        taxCalculationService = null;
    }

    /**
     * Test of getTaxJurisdictionDao method, of class TaxCalculationServiceImpl.
     */
    @Test
    public void testGetTaxJurisdictionDao() {
        taxJurisdictionDao = taxCalculationService.getTaxJurisdictionDao();
        assertNotNull(taxJurisdictionDao);
    }

    /**
     * Test of applyTax method, of class TaxCalculationServiceImpl.
     */
    @Test
    public void testApplyTax() {
        double taxForBC = taxCalculationService.applyTax(taxJurisdictionBC, 100.00);
        assertThat("Tax for BC for item with value 100.00 is", taxForBC, is(12.0));
        
        double taxForAB = taxCalculationService.applyTax(taxJurisdictionAB, 50.0);
        assertThat("Tax for AV for item with value 50.0 is", taxForAB, is(2.5));
    }
}
