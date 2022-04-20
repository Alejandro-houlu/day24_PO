package sg.edu.nus.iss.day24_purchaseOrder.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.day24_purchaseOrder.Models.PurchaseOrderForm;
import sg.edu.nus.iss.day24_purchaseOrder.Models.lineItem;
import sg.edu.nus.iss.day24_purchaseOrder.Services.PurchaseOrderInterface;

@Controller
@RequestMapping("/")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderInterface poSvc;

    @GetMapping("/")
    public String setForm(Model model){

        PurchaseOrderForm purchaseOrderForm = new PurchaseOrderForm();

        List<lineItem> items = new ArrayList<>();
        do {    
          items.add(new lineItem());  
        } while (items.size()<4);

        purchaseOrderForm.setItems(items);

        model.addAttribute("purchaseOrderForm", purchaseOrderForm);

        return "index";
    }

    @PostMapping("purchase_order")
    public String savePo(@ModelAttribute("purchaseOrderForm") PurchaseOrderForm poForm){

        PurchaseOrderForm cleanedForm = poSvc.cleanLineItems(poForm);
        
        if(!poSvc.validateLineItems(cleanedForm)){
            return "error";
        }
        PurchaseOrderForm formToSave = new PurchaseOrderForm(poForm.getName(), poForm.getDate(), poForm.getItems());

        poSvc.savePurchaseOrder(formToSave);

        return "success";
    }
    
}
