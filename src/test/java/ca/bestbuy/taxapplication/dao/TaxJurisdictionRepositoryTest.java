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
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kashif Ahmed Khan
 */
public class TaxJurisdictionRepositoryTest {
    
    private static final String BC = "BC";
    private static final String AB = "AB";
    private final String configPath = "meta-inf/spring/taxapplication-context.xml";
    private TaxJurisdictionDao repository;
    private ClassPathXmlApplicationContext context;
    private Map<String, TaxJurisdiction> jurisdictions;
    private TaxType taxTypeGSTBC;
    private TaxType taxTypePSTBC;
    private TaxType taxTypeGSTAB;
    
    
    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext(configPath);
        repository = context.getBean(TaxJurisdictionDao.class);
        jurisdictions = repository.getJurisdictions();
        taxTypeGSTBC = context.getBean("taxTypeGSTBC", TaxType.class);
        taxTypePSTBC = context.getBean("taxTypePSTBC", TaxType.class);
        taxTypeGSTAB = context.getBean("taxTypeGSTAB", TaxType.class);
    }
    
    @After
    public void tearDown() {
        context = null;
        repository = null;
        jurisdictions = null;
        taxTypeGSTBC = null;
        taxTypePSTBC = null;
        taxTypeGSTAB = null;
    }

    /**
     * Test of getJurisdictions method, of class TaxJurisdictionRepository.
     */
    @Test
    public void testGetJurisdictions() {
        assertThat("Tax Jurisdictions Map contains enteries", jurisdictions, IsNull.notNullValue());
        assertThat("Tax Jurisdictions Map has 2 enteries", jurisdictions.size(), is(2));
    }

    /**
     * Test of getTaxTypesForJurisdiction method, of class TaxJurisdictionRepository.
     */
    @Test
    public void testGetTaxTypesForJurisdiction() {
        List<TaxType> jurisdictionBC = repository.getTaxTypesForJurisdiction(BC);
        assertThat("BC Jurisdiction contains 2 elements", jurisdictionBC.size(), is(2));
        assertThat("BC Jurisdiction contains GST taxtType", jurisdictionBC.get(0), IsEqual.equalTo(taxTypeGSTBC));
        assertThat("BC Jurisdiction contains PST taxtType", jurisdictionBC.get(1), IsEqual.equalTo(taxTypePSTBC));
        
        List<TaxType> jurisdictionAB = repository.getTaxTypesForJurisdiction(AB);
        assertThat("AB Jurisdiction contains 2 elements", jurisdictionAB.size(), is(1));
        assertThat("AB Jurisdiction contains GST taxtType", jurisdictionAB.get(0), IsEqual.equalTo(taxTypeGSTAB));
    }
    
}
