package sg.edu.nus.iss.day24_purchaseOrder.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import static sg.edu.nus.iss.day24_purchaseOrder.Repositories.Queries.*;

@Repository
public class SkuRepository {

    @Autowired
    private JdbcTemplate jTemplate;

    public Boolean getByProdId(Integer prodId){

    SqlRowSet rs =  jTemplate.queryForRowSet(SQL_SELECT_PROD_ID,prodId);
    return rs.next();
        
    }
    
}
