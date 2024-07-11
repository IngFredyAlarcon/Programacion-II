import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Properties;
import com.google.gson.Gson;

public class BasicoTest {

    @Test
    public void test() {
        final String json = "{\"id\":46,\"first_name\":\"Denna\",\"last_name\":\"Crosio\"}";
        final Gson gson = new Gson();
        final Properties properties = gson.fromJson(json, Properties.class);
        assertEquals("46", properties.getProperty("id"));
        assertEquals("Denna", properties.getProperty("first_name"));
    }
}
