package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase{

    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("shilol@gmail.com").withPassword("Shilol12345$"));
    }

    @Test
    public void addContactSuccessAllFields(){
            int i = new Random().nextInt(1000)+1000;
            Contact contact = Contact.builder()
                    .name("Yaniv")
                    .lastName("Gavri")
                    .phone("34343434"+i)
                    .email("yaniv"+i+"@gmail.com")
                    .address("Tel Aviv, Israel")
                    .description("Work in Apple")
                    .build();
            app.getHelperContact().openContactForm();
            app.getHelperContact().fillContactForm(contact);
            app.getHelperContact().saveContact();
            Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
            Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));


        }

    }

    @Test
    public void addContactSuccessRequiredFields(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Yaniv")
                .lastName("Gavri")
                .phone("34343434"+i)
                .email("yaniv"+i+"@gmail.com")
                .address("Tel Aviv, Israel")
                .description("Work in Apple")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }


    public void  addContactSuccessRequiredFields(){
        int i= new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Tony"+i)
                .lastName("Stark")
                .address("NY")
                .phone("34343434"+i)
                .email("stark"+i+"@gmail.com")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void addNewContactWrongName(){

    }
    @Test
    public void  addNewContactWrongAddress(){

    }

    @Test
    public void addNewContactWrongLastName(){

    }
    @Test
    public void addNewContactWrongPhone(){

    }
    @Test
    public void addNewContactWrongEmail(){

    }



}
