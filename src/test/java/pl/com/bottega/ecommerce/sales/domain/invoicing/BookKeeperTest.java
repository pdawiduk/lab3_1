/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import  org.mockito.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;


/**
 *
 * @author student
 */
public class BookKeeperTest {
    
    public BookKeeperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of issuance method, of class BookKeeper.
     */
    @org.junit.Test
    public void testIssuance() {
        
        System.out.println("issuance");
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        BookKeeper bookKeeper = new BookKeeper(invoiceFactory);
        
        InvoiceRequest invoiceRequest = Mockito.mock(InvoiceRequest.class);
        TaxPolicy taxPolicy = Mockito.mock(TaxPolicy.class);
        BookKeeper instance = Mockito.mock(BookKeeper.class);
        Invoice expResult = Mockito.mock(Invoice.class);
        ClientData clientData = Mockito.mock(ClientData.class);
        ProductData productData = Mockito.mock(ProductData.class);
        List<RequestItem> requestItemList = new ArrayList<>(); 
        Invoice result = instance.issuance(invoiceRequest, taxPolicy);
        when(invoiceRequest.getItems());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
