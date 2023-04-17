package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("shilol@gmail.com").withPassword("Shilol12345$"));
        }
       app.getHelperContact().provideContacts(); /// if list <3 ==> add 3 contacts

    }


    @Test
    public void removeFirstContact() {
        // Assert size list less when one
        Assert.assertEquals(app.getHelperContact().removeOneContact(),1);

    }

    @Test
    public void removeAllContacts() {
        // "No contacts Here"
        app.getHelperContact().removeAllContacts();
        Assert.assertEquals(app.getHelperUser().getMessage(),"No Contacts here!");

    }

}
