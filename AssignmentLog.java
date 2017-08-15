import java.sql.Date;

/**
 * @author Alberto Fernandez Saucedo
 */
public class AssignmentLog
{
    private PriorityQueueInterface<Assignment> log;

    public AssignmentLog()
    {
        log = new PriorityQueue<>();
    }

    public void addProject(Assignment newAssignment)
    {
        log.add(newAssignment);
    }

    public void addProject(int courseCode, String task, String dueDate)
    {
        Assignment newAssignment = new Assignment(courseCode, task, dueDate);
        addProject(newAssignment);
    }

    public Assignment getNextProject()
    {
        return log.peek();
    }

    public Assignment removeNextProject()
    {
        return log.remove();
    }

} // end AssignmentLog
