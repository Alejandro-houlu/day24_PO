package sg.edu.nus.iss.day24_purchaseOrder.Services;

import java.util.List;

import sg.edu.nus.iss.day24_purchaseOrder.Models.PurchaseOrderForm;

public interface PurchaseOrderInterface {

    public Boolean validateLineItems(PurchaseOrderForm poForm);

    public PurchaseOrderForm cleanLineItems(PurchaseOrderForm poForm);

    public void savePurchaseOrder(PurchaseOrderForm formToSave);


    
}
