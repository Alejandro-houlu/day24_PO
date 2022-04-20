package sg.edu.nus.iss.day24_purchaseOrder.Models;

public class lineItem {

    private Integer sku;
    private Integer qty;
    
    @Override
    public String toString() {
        return "lineItem [qty=" + qty + ", sku=" + sku + "]";
    }
    public Integer getSku() {
        return sku;
    }
    public void setSku(Integer sku) {
        this.sku = sku;
    }
    public Integer getQty() {
        return qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
}
