package tests;

import models.Contact;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @Test
    public void addNewContactSuccess(){
        Contact contact = Contact.builder()
                .name("Yaniv")
                .lastName("Gavri")
                .phone("0521230007")
                .email("yaniv@gmail.com")
                .address("Tel Aviv, Israel")
                .description("Work in Apple")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm();
        app.getHelperContact().saveContactForm();


    }
}
