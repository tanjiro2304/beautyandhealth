package com.beautyandhealth.modules.maindetails;

import com.beautyandhealth.exception.CustomerNotFoundException;
import com.beautyandhealth.mvputil.BaseView;
import com.vaadin.componentfactory.addons.splide.ImageSlide;
import com.vaadin.componentfactory.addons.splide.Splide;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;
@Getter
@Setter
@UIScope
@SpringComponent
@Route("")
public class MainView extends BaseView<MainPresenter> {

    private Button signIn;
    private Dialog phoneDialog;
    private TextField contactField;
    private Button close;
    private Button next;
    private VerticalLayout dialogLayout;
    private   H1 title;
    private  Tabs tabs;

    @Autowired
    private MainPresenter mainPresenter;

    @Override
    @PostConstruct
    protected void init() {

        initializeLayout();
        initializeButton();


        initializeDialog();
        addToNavbar(true, title, tabs,signIn);
        addSplide();

    }


    private void initializeLayout() {
      title = new H1("BeautyAndHealth");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("color", " #349edb ")
                .set("left", "var(--lumo-space-l)")
                .set("margin", "0")
                .set("position", "absolute");
       tabs = getTabs();
        tabs.getStyle().set("cusrsor", "pointer").set("padding", "20px");

        getElement().getStyle().set("background-image", "url('images/background2.jpg')").set("background-repeat", "no-repeat")
                .set("background-size", "contain").set("background-size", "100% 100%");

    }

    private void addSplide() {
        ImageSlide image1 = new ImageSlide("images/beautysale.webp");
        ImageSlide image2 = new ImageSlide("images/cosmeticsale.jpg");
        Splide slide = new Splide(Arrays.asList(image1, image2));
        slide.setHeight(70, Unit.PERCENTAGE);
        slide.setWidth(100, Unit.PERCENTAGE);
        setContent(slide);
    }

    private Tabs getTabs() {
        Tabs tabs1 = new Tabs();
        tabs1.getStyle().set("margin", "auto");
        tabs1.add(createTab("Category"),
                createTab("Beauty Brands"),
                createTab("Health Brands")
        );
        return tabs1;
    }

    private Tab createTab(String viewName) {
        RouterLink routerLink = new RouterLink();
        routerLink.add(viewName);
        routerLink.setTabIndex(-1);
        return new Tab(routerLink);
    }


    private void initializeButton() {
        signIn = new Button("SignIn");
        signIn.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        signIn.setAutofocus(true);
        signIn.getStyle().set("margin", "auto");
        close = new Button(VaadinIcon.CLOSE.create());
        close.getStyle().set("padding-left", "0 px");
        next = new Button("Next");
        next.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        signIn.addClickListener(buttonFocusEvent -> {
            phoneDialog.open();

        });

        close.addClickListener(buttonClickEvent -> {
            phoneDialog.close();
        });

        next.addClickListener(buttonClickEvent -> {
            phoneDialog.close();
           String contactValue= contactField.getValue();
            try {
              mainPresenter.changeView(contactValue);
            } catch (CustomerNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void initializeDialog() {
        dialogLayout = new VerticalLayout();
        phoneDialog = new Dialog();
        contactField = new TextField("Enter Contact");
        dialogLayout.add(close, contactField, next);
        phoneDialog.add(dialogLayout);
    }
}
