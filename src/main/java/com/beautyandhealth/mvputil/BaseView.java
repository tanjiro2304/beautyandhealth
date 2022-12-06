package com.beautyandhealth.mvputil;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class BaseView<P extends Presenter> extends AppLayout implements View<P> {

    @Autowired
    private P presenter;

    @PostConstruct
    private void postConstruct() {
        if (presenter != null) {
            presenter.setView(this);
            presenter.beforeViewInit();
            presenter.afterViewInit();
        }
    }

    protected abstract void init();
    @Override
    public P getPresenter() {
        return presenter;
    }
}
