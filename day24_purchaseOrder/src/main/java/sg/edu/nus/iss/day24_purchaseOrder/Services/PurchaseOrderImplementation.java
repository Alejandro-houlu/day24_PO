package sg.edu.nus.iss.day24_purchaseOrder.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day24_purchaseOrder.Models.PurchaseOrderForm;
import sg.edu.nus.iss.day24_purchaseOrder.Models.lineItem;
import sg.edu.nus.iss.day24_purchaseOrder.Repositories.LineItemRepository;
import sg.edu.nus.iss.day24_purchaseOrder.Repositories.PurchaseOrderRepository;
import sg.edu.nus.iss.day24_purchaseOrder.Repositories.SkuRepository;

@Service
public class PurchaseOrderImplementation implements PurchaseOrderInterface {

    @Autowired
    SkuRepository skuRepo;

    @Autowired
    LineItemRepository lineItemSvc;

    @Autowired
    PurchaseOrderRepository poSvc;

    @Override
    public Boolean validateLineItems(PurchaseOrderForm poForm) {

        for(lineItem item : poForm.getItems()){
            if(!(skuRepo.getByProdId(item.getSku()))){
                return false;
            }
        }
        return true;
    }

    @Override
    public PurchaseOrderForm cleanLineItems(PurchaseOrderForm poForm) {

       List<lineItem> cleanItems = poForm.getItems().stream().filter(p->p.getSku()!=null).toList();
       poForm.setItems(cleanItems);
        
        return poForm;
    }

    @Override
    public void savePurchaseOrder(PurchaseOrderForm formToSave) {
        
        poSvc.savePurchaseOrder(formToSave);
        lineItemSvc.saveLineItem(formToSave);
    }
    
}
