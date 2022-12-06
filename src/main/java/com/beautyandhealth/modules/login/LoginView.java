package com.beautyandhealth.modules.login;

import com.beautyandhealth.mvputil.BaseView;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Route("/login")
public class LoginView extends BaseView<LoginPresenter> {
    private LoginForm loginForm;
    @Autowired
    private LoginPresenter loginPresenter;

    @Override
    @PostConstruct
    protected void init() {
        initializeLoginForm();
        setContent(loginForm);
    }

    private void initializeLoginForm() {
        loginForm=new LoginForm();
        loginForm.getElement().getStyle().set("margin-top", "10%");
        loginForm.getElement().getStyle().set("margin-left", "35%");


        loginForm.addLoginListener(loginEvent -> {
            loginPresenter.validateUser(loginEvent.getUsername(),loginEvent.getPassword());
        });
    }
}
