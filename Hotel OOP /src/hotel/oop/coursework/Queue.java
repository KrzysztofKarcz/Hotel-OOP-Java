/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.oop.coursework;



/**
 *
 * @author hadielmekawi
 */
public class Queue {

    // be careful - this queue can go over the end of the array
    //the array should be used in a circular way
    String qitems[] = new String[7];
    int front = 0, end = 0;
    int numberInQueue = 0;

    public void addqueue(String roomName1) {

     //  if end - front = 7 or -1 then queue is full
        if (end - front == qitems.length || end - front == -1) {

            System.out.println("The Queue is full");
            System.out.println("the oldest custemer is : " + qitems[front]);
            front++;
            end = end % qitems.length;
        }
        qitems[end] = roomName1;
        numberInQueue++;
        end++;
    }

    public void takequeue() {
        if (numberInQueue > 0) {
            System.out.println("Item taken :" + qitems[front]);
            numberInQueue--;

            front = (++front) % qitems.length;
           
        } else {
            System.out.println("Empty queue");
        }
    }

    public void displayqueue() {
        System.out.println("Queue display: ");
        for (int look = front; look < end; look++) {
            System.out.print(" " + qitems[look]);
        }
        System.out.println("");
    }

}
