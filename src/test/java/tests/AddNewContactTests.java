package tests;

import manager.DataProviderContact;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase{

    @BeforeClass
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("shilol@gmail.com").withPassword("Shilol12345$"));
        }
    }

    @Test(dataProvider = "contactSuccess",dataProviderClass = DataProviderContact.class)
    public void  addContactSuccessAllFields(Contact contact){

        logger.info("Tests run with data: --->"+contact.toString());
            app.getHelperContact().openContactForm();
            app.getHelperContact().fillContactForm(contact);
            app.getHelperContact().saveContact();
            Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
            Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

        }

    @Test
    public void addContactSuccessRequiredFields(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Yaniv"+i)
                .lastName("Gavri")
                .phone("34343434"+i)
                .email("yaniv"+i+"@gmail.com")
                .address("Tel Aviv, Israel")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }


    @Test
    public void addNewContactWrongName(){
        Contact contact = Contact.builder()
                .name("")
                .lastName("Gavri")
                .phone("3434343409")
                .email("yaniv@gmail.com")
                .address("Tel Aviv, Israel")
                .description("empty name")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }
    @Test
    public void  addNewContactWrongAddress(){
        Contact contact = Contact.builder()
                .name("Yaniv")
                .lastName("Gavri")
                .phone("3434343498")
                .email("yaniv@gmail.com")
                .address("")
                .description("empty address")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongLastName(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Yaniv")
                .lastName("")
                .phone("3434343409")
                .email("yaniv@gmail.com")
                .address("Tel Aviv, Israel")
                .description("empty last name")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }
    @Test
    public void addNewContactWrongPhone(){
        Contact contact = Contact.builder()
                .name("Yaniv")
                .lastName("Gavri")
                .phone("")
                .email("yaniv@gmail.com")
                .address("Tel Aviv, Israel")
                .description("empty phone")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }
    @Test
    public void addNewContactWrongEmail(){
        Contact contact = Contact.builder()
                .name("Yaniv")
                .lastName("Gavri")
                .phone("3434343434")
                .email("yanivgmail.com")
                .address("Tel Aviv, Israel")
                .description("wrong email")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid: must be a well-formed email address"));

    }

}
