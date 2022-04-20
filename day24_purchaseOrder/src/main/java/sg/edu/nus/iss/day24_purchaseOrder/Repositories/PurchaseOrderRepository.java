package sg.edu.nus.iss.day24_purchaseOrder.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day24_purchaseOrder.Models.PurchaseOrderForm;
import static sg.edu.nus.iss.day24_purchaseOrder.Repositories.Queries.*;

@Repository
public class PurchaseOrderRepository {

    @Autowired
    private JdbcTemplate jTemplate;

    public void savePurchaseOrder(PurchaseOrderForm formToSave){
        
        jTemplate.update(SQL_INSERT_PURCHASE_ORDER, formToSave.getOrderId(), formToSave.getName(), formToSave.getDate());
    }
    
}
