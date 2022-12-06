package com.beautyandhealth.modules.maindetails;

import com.beautyandhealth.entity.Customer;
import com.beautyandhealth.exception.CustomerNotFoundException;
import com.beautyandhealth.mvputil.BasePresenter;
import com.beautyandhealth.service.CustomerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@SpringComponent
@UIScope
public class MainPresenter extends BasePresenter<MainView> {

    @Autowired
    private CustomerService customerServiceImpl;
    @Lazy
    @Autowired
    private MainView mainView;

    public void changeView(String contactValue) throws CustomerNotFoundException {

        Customer cust=customerServiceImpl.getContact(contactValue);
        if (cust != null) {
            mainView.getNext().getUI().ifPresent(ui -> ui.navigate("login"));
        }
        else {
            mainView.getNext().getUI().ifPresent(ui -> ui.navigate("signup"));
        }
    }
}
