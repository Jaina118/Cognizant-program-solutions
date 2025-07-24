package mockitoExercise_2;

public class MyService {
    private ExternalAPI api;

    MyService(ExternalAPI api){
        this.api = api;
    }

    public String fetchData(){
        return api.getData();
    }
}
