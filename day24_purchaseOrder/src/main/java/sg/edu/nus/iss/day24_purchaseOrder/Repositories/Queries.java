package sg.edu.nus.iss.day24_purchaseOrder.Repositories;

public interface Queries {

    public static final String SQL_SELECT_PROD_ID = "select * from sku where prod_id = ?";

    public static final String SQL_INSERT_LINEITEM = "insert into line_item (quantity, order_id, prod_id) values (?,?,?)";

    public static final String SQL_INSERT_PURCHASE_ORDER = "insert into purchase_order (order_id, name, order_date) values (?,?,?)";
    
}
