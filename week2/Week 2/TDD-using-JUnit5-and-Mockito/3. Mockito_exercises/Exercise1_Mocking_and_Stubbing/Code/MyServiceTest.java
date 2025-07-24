package mockitoExercise_1;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class MyServiceTest {
    @Test
    public void testExternalAPI(){
        ExternalAPI mockAPI = Mockito.mock(ExternalAPI.class);

        when(mockAPI.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockAPI);

        String res = service.fetchData();

        assertEquals("Mock Data",res);
    }
}
