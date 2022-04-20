package sg.edu.nus.iss.day24_purchaseOrder.Models;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class PurchaseOrderForm {

    private String name;
    private Date date;
    private List<lineItem> items;
    private String orderId;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }


    public String getOrderId(){
        return orderId;
    }

    public String setOrderId(){
        String newOrderId = UUID.randomUUID().toString();
        return newOrderId.substring(0,8);
    }

    public PurchaseOrderForm(String name, Date date, List<lineItem> items){
        this.name = name;
        this.date = date;
        this.items = items;
        this.orderId = setOrderId();
    }

    public List<lineItem> getItems() {
        return items;
    }
    public void setItems(List<lineItem> items) {
        this.items = items;
    }
    public PurchaseOrderForm(){}
    
    @Override
    public String toString() {
        return "PurchaseOrderForm [date=" + date + ", items=" + items + ", name=" + name + ", orderId=" + orderId + "]";
    }

    

    
    
}
