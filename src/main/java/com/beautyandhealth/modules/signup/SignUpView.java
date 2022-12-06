package com.beautyandhealth.modules.signup;

import com.beautyandhealth.mvputil.BaseView;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;

@UIScope
@SpringComponent
@Route("/signup")
public class SignUpView extends BaseView<SignUpPresenter> {

    @Override
    @PostConstruct
    protected void init() {
        H4 title = new H4("This is Sign Up Form");
        setContent(title);
    }
}
