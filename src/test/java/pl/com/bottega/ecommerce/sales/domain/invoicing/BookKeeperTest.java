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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;


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
    public void TestFakturyZJednymPolem() {


        InvoiceFactory invoiceFactory = new InvoiceFactory();
        BookKeeper bookKeeper = new BookKeeper(invoiceFactory);
        Money money = new Money(0);
        ClientData clientData = mock(ClientData.class);
        Tax tax = new Tax(money, "wtf");
        InvoiceRequest invoiceRequest = mock(InvoiceRequest.class);
        TaxPolicy taxPolicy = mock(TaxPolicy.class);
        RequestItem item = mock(RequestItem.class);
        ArrayList<RequestItem> requestItems = new ArrayList<>();
        ProductData productData = mock(ProductData.class);
        InvoiceLine invoiceLine = mock(InvoiceLine.class);


        when(invoiceRequest.getItems()).thenReturn(requestItems);
        when(invoiceRequest.getClientData()).thenReturn(clientData);
        when(item.getProductData()).thenReturn(productData);
        when(item.getQuantity()).thenReturn(1);
        when(item.getTotalCost()).thenReturn(money);
        when(productData.getType()).thenReturn(ProductType.STANDARD);
        when(taxPolicy.calculateTax(productData.getType(), money)).thenReturn(tax);
        requestItems.add(item);
        Invoice result = bookKeeper.issuance(invoiceRequest, taxPolicy);
        assertThat(result.getItems().size(), is(1));
    }
}
