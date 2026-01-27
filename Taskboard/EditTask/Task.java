public class Task{
    private int id;
    private String subject;
    private String body;
    public Task(String subject, String body, int id){
        this.subject = subject;
        this.body = body;
        this.id = id;
    }

    @Override
    public String toString(){
        return id + ":" + subject + ":" + body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}