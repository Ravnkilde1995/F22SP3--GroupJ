package Tournament;

import java.util.ArrayList;

public interface FileIO <T>  {

    //methods
    //******************
    public  void saveData(ArrayList<T> arrayList);

    public ArrayList<T> loadData();

}
