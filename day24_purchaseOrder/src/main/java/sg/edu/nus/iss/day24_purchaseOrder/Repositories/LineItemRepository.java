package sg.edu.nus.iss.day24_purchaseOrder.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day24_purchaseOrder.Models.PurchaseOrderForm;
import sg.edu.nus.iss.day24_purchaseOrder.Models.lineItem;

import static sg.edu.nus.iss.day24_purchaseOrder.Repositories.Queries.*;

import java.util.List;

@Repository
public class LineItemRepository {

    @Autowired
    private JdbcTemplate jTemplate;

    public void saveLineItem(PurchaseOrderForm formToSave){

        List<lineItem> items = formToSave.getItems();

        for(lineItem item : items){

        jTemplate.update(SQL_INSERT_LINEITEM, item.getQty(), formToSave.getOrderId(), item.getSku());

        }
    }
    
}
