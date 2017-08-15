import java.sql.Date;

/**
 * @author Alberto Fernandez Saucedo
 */
public class Assignment implements Comparable<Assignment> {

    private int course;  // the course code
    private String task; // a description of the assignment
    private Date date;   // the due date

    /**
     * Create an assignment
     * @param task a description of the assignment
     * @param course the course number
     * @param date the due date of assignment, given in the form yyyy-mm-dd
     */
    public Assignment(int course, String task, String date)
    {
       this.task = task;
       this.course = course;
       this.date = Date.valueOf(date);
    }

    public int getCourseCode()
    {
        return course;
    }

    public String getTask()
    {
        return task;
    }

    public Date getDueDate()
    {
        return date;
    }

    public int compareTo(Assignment other)
    {
        return -date.compareTo(other.date);
    }
}
