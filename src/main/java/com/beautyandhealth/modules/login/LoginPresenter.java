package com.beautyandhealth.modules.login;

import com.beautyandhealth.entity.Customer;
import com.beautyandhealth.mvputil.BasePresenter;
import com.beautyandhealth.mvputil.Presenter;
import com.beautyandhealth.service.CustomerService;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@UIScope
@SpringComponent
public class LoginPresenter extends BasePresenter<LoginView> {
    @Autowired
    private CustomerService customerServiceImpl;

    @Autowired
    @Lazy
    private LoginView loginView;
    public void validateUser(String userName, String password) {
        Boolean val=customerServiceImpl.ifUserExists(userName,password);
if(val==true){
    Notification.show("Logged In Successfully!");
}
else{
    Notification.show("Please Sign Up");
}
    }
}
