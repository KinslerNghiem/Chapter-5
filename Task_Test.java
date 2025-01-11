/**
 * Prints the organized list of tasks
 *
 * Tien Nghiem
 * 1/8/25
 */
public class Task_Test
{
    public static void main(String[] args){
        Task task = new Task(3, "Christmas gift for Brother", true);
        Task task2 = new Task(6, "Christmas gifts for Friends", true);
        Task task3 = new Task(5.1, "Decorate the Christmas tree");
        Task task4 = new Task(5.4, "Take notes for bio");
        Task task5 = new Task(2.1, "Tile my room");
        Task task6 = new Task(4, "Print Vinyl decal for Advent of Code");
        Task task7 = new Task(4, "Print Vinyl decal Wall downstairs");
        Task task8 = new Task(1.1, "Drive my lego car");
        Task task9 = new Task(1, "Beat Tai in ping-pong");
        Task task10 = new Task(10, "Grade");
        
        
        Task[] myTasks = {task, task2, task3, task4, task5, task6, task7, task8, task9, task10};
        System.out.println("My Sorted Tasks");
        System.out.println("__________________________________");
        System.out.println();
        System.out.println();
        Sorts.insertionSort(myTasks);
        for(Task t: myTasks){
            System.out.println(t);
        }
    }
}