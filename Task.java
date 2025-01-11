/**
 * Methods to sort tasks and implement the Priority interface.
 *
 * @Tien Nghiem
 * @1/8/25
 */
public class Task implements Priority, Comparable
{
    private String task;
    private double priority;
    private boolean done;
    
    /*
     * Constructor to update instance variables
     * @param double priority, String task
     */
    public Task(double priority, String task){
        this.priority = priority;
        this.task = task;
    }
    /*
     * Overloaded constructor to update instance variables and whether the task is done or not
     * @param double priority, String task, boolean done
     */
    public Task(double priority, String task, boolean done){
        this.priority = priority;
        this.task = task;
        this.done = done;
    }
    /*
     * Uses comparable interface to compare objects based primarily on priority level
     * @param Object obj
     */
    public int compareTo(Object obj){
        Task other = (Task) obj;
        
        double otherPriority = other.priority;
        int comparison = 0;
        String otherTask = other.task;
        
        if(this.done == true){
            setPriority(10000);
        }
        if(this.priority < otherPriority){
            comparison = -1;
            return comparison;
        }
        else if(this.priority == otherPriority){
            return this.task.compareTo(otherTask);
        }
        else{
            comparison = 1;
            return comparison;
        }
    }
    /*
     * A getter to return priority level.
     * @param Task t
     */
    public double getPriority(Task t){
        return priority;
    }
    /*
     * A setter to set a priority level if task is done
     * @param double p
     */
    public double setPriority (double p){
        this.priority = p;
        return this.priority;
    }
    /*
     * A method to output the data.
     */
    public String toString(){
    String result = "";
    if(this.done == false)
        result = this.priority + "   " + this.task;
    else
        result = "(Done)  "+  this.task;
    return result; 
    
}

}
    
  