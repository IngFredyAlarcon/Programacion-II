import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.Gson;

public class PersonTest {
    @Test
    public void test() {
        final String json = "{\"id\":46,\"first_name\":\"Denna\",\"last_name\":\"Crosio\"}";
        final Gson gson = new Gson();
        final Person person = gson.fromJson(json, Person.class);
        assertEquals(46, person.getId());
        assertEquals("Denna", person.getFirst_name());
        assertEquals("Crosio", person.getLast_name());

    }

}
