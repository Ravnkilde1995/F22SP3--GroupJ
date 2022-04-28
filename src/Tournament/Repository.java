package Tournament;

import java.util.ArrayList;
import java.util.List;

// William

public interface Repository <T>{

    public ArrayList<T> readAll();

    public void create(T t);

    public void delete(int id);

}
