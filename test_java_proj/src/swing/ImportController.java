package swing;
import java.util.*;

public class ImportController 
{
    private static FileManager file_manager;
    //private static ExitManager exit_manager;

    public Map<Integer, Person> importUserData(String filePath) 
    {
        if (file_manager == null) file_manager = new FileManager();
        //if(exit_manager==null) exit_manager=new ExitManager();
        
        file_manager.importFile(filePath);
        
        return UserManager.getAllUsers();
    }
}

