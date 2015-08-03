package pawc.webapp;

public class EntryModel {

    private String author;
    private String message;
    
    public EntryModel(String author, String message){
        this.author=author;
        this.message=message;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public String getMessage(){
        return message;
    }
    
}
