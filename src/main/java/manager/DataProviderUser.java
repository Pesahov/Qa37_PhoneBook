package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"shilol@gmail.com","Shilol12345$"});
        list.add(new Object[]{"shilol@gmail.com","Shilol12345$"});
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> loginModels(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("shilol@gmail.com").withPassword("Shilol12345$")});
        list.add(new Object[]{new User().withEmail("shilol@gmail.com").withPassword("Shilol12345$")});

        return list.iterator();
    }
}
