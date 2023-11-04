package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks=new ArrayList<>();
    public ToDoList(){
        tasks=new ArrayList<>();
    }

    public void addTask(String task){
        tasks.add(task);
    }

    public void removeTask(int taskNo){
        if(taskNo>=1 && taskNo<=tasks.size()){
            tasks.remove(taskNo-1);
        }else{
            System.out.println("invalid task no.");
        }
//        tasks.remove(taskNo);
    }
    public void displayTasks(){
        if(tasks.isEmpty()){
            System.out.println("no tasks added");
        } else{
            for(int i=0;i<tasks.size();i++){
                System.out.println((i+1)+". "+tasks.get(i));
            }
        }
    }


}

 class ToDoListManager{
     public static void main(String[] args) {
         ToDoList toDoList=new ToDoList();
         Scanner sc=new Scanner(System.in);

         while(true){
             System.out.println("Your Todo list manager");
             System.out.println("1. add tasks");
             System.out.println("2. remove tasks");
             System.out.println("3. Display tasks");
             System.out.println("4. Exit todo list manager");
             System.out.println("enter your choice");

             String choice=sc.nextLine();
             switch(choice){
                 case "1":
                     System.out.println("enter new task to add");
                     String task=sc.nextLine();
                     toDoList.addTask(task);
                     break;
                 case "2":
                     System.out.println("Enter the task number to remove: ");
                     toDoList.displayTasks();
                     int taskNumberToRemove;
                     try {
                         taskNumberToRemove = Integer.parseInt(sc.nextLine());
                         toDoList.removeTask(taskNumberToRemove);
                         System.out.println("task deleted");
                         System.out.println("available tasks");
                         System.out.println("--------------------------------");
                         toDoList.displayTasks();
                     } catch (NumberFormatException e) {
                         System.out.println("Invalid input. Please enter a valid task number.");
                     }
                     break;
                 case "3":
                     System.out.println("your tasks");
                     System.out.println("----------------------------------");
                     toDoList.displayTasks();
                     System.out.println("----------------------------------");
                     break;
                 case "4":
                     System.out.println("thanks for visiting");
                     sc.close();
                     System.exit(0);
                 default:
                     System.out.println("invalid operation please enter valid operations");
             }
         }


     }


}
