/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.oop.coursework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author hadielmekawi
 */
public class HotelOOPCoursework {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        Queue mq = new Queue();

        //create rooms
        Room[] myHotel = new Room[10];
        for (int i = 0; i < myHotel.length; i++) {

            myHotel[i] = new Room();

        }

        initialise(myHotel);

        String choice = "";//choice string is equal to nothing

        while (!choice.equals("x")) {//menu for selection

            // Display the menu
            System.out.println("|=============================================|");
            System.out.println("|                  Hotel                      |");
            System.out.println("|=============================================|");
            System.out.println("v\t View all rooms");
            System.out.println("a\t Add a customer");
            System.out.println("d\t Delete customer from room");
            System.out.println("s\t Store program array data into plain text file");
            System.out.println("l\t Load Program data back from the file into the array");
            System.out.println("3\t Display the names of the first 3 customers who have been allocated to a room.");
            System.out.println("x\t Exit program");
            System.out.println("Please enter your choice:");

            choice = in.next();//Get user's choice
            choice = choice.toLowerCase();//lower case sensitive

            //Display the title
            switch (choice) {
                case "v":
                    System.out.println("You choose to  view all rooms");
                    ViewOccupied(myHotel);
                    break;
                case "a":
                    System.out.println("You choose to enter a new customer");
                    bookRoom(myHotel, mq);
                    break;
                case "e":
                    System.out.println("You choose diplay empty rooms");
                    viewRoomEmpty(myHotel);
                    break;
                case "d":
                    System.out.println("You choose delete rooms");
                    DeleteCustomerFromRoom(myHotel);
                    break;
                case "s":
                    System.out.println("You choose to store data into file");
                    StoreInfoIntoFile(myHotel);
                    break;
                case "l":
                    System.out.println("YOu Choose to load data from a text file");
                    ImportDataFromTextFile(myHotel);
                    break;
                case "3":
                    System.out.println("Display the names of the first 3 customers who have been allocated to a room. ");
                    mq.takequeue();
                    mq.takequeue();
                    mq.takequeue();
                    break;
                case "x":
                    System.out.println("exiting program");
                    break;

            }
        }
    }

    private static void initialise(Room hotelRef45[]) {
        for (int x = 0; x < hotelRef45.length; x++) {
            hotelRef45[x].setName("empty");
        }
        System.out.println("initilise");
    }

    //view only empty rooms
    private static void viewRoomEmpty(Room hotelRef1[]) {
        boolean customer = false;
        for (int x = 0; x < hotelRef1.length; x++) {
            if (hotelRef1[x].getName().equals("empty")) {
                System.out.println("room  " + x + " is empty");
                customer = true;
            }

        }

        if (customer == false) {
            System.out.println("Hotel is fully booked!!!");
            System.out.println("Delete customer to make a new booking ");
        }
    }

    //add a customer to a room 
    private static void bookRoom(Room hotelRef1[], Queue q) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (0-9):");
        int roomNum = input.nextInt();//get user room

        if (roomNum >= hotelRef1.length || roomNum < 0) {
            System.out.println("Sorry we don't have this room");
        } else {

            System.out.println("Enter name for room" + roomNum + ":");
            String roomName1 = input.next();
            if (hotelRef1[roomNum].getName().equals("empty")) {
                hotelRef1[roomNum].setName(roomName1);
                q.addqueue(roomName1);

                System.out.println("Your customer is been added successfully to the hotel");

            } else {

                System.out.println("You can't add customer. Delete customer first then add new customer");

            }

        }

    }

    //if 8 
    //Delete customer by selecting room number
    private static void DeleteCustomerFromRoom(Room hotelRef1[]) {

        String roomName1;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (0-9) that you want to empty:");
        int roomNum = input.nextInt();
        if (roomNum > hotelRef1.length || roomNum < 0) {
            System.out.println("Sorry we don't have this room");
        } else if (hotelRef1[roomNum].getName().equals("empty")) {

            System.out.println("You can't delete customer, no one is inside room: " + roomNum);

        } else {
            System.out.println("You just deleted customer from  room: " + roomNum);
            //  hotelRef1[roomNum].getName().equals("empty");
            hotelRef1[roomNum].setName("empty");
        }

    }

    //view occupied 
    private static void ViewOccupied(Room hotelRef1[]) {

        for (int x = 0; x < hotelRef1.length; x++) {
            System.out.println("room " + x + " occupied by  " + hotelRef1[x].getName());
        }

    }

    //Store customer names into a txt file in Desktop
    private static void StoreInfoIntoFile(Room hotel[]) throws IOException {

        int roomNum1;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("/Users/hadielmekawi/Desktop/Hotel.txt"));
            for (int i = 0; i < hotel.length; i++) {

                out.write(hotel[i].getName() + "\n");
            }
            System.out.println("succesfully added on text file");
            out.close();
        } catch (IOException e) {
        }
    }

    //get information from a text file 
    private static void ImportDataFromTextFile(Room hotel[]) throws IOException {
        FileReader reader = new FileReader("/Users/hadielmekawi/Desktop/Hotel.txt");//read from the text file
        BufferedReader bufferedReader = new BufferedReader(reader); // declare a new buffer reader
        int i = 0;// 0 because rooms start at 0 
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();

            hotel[i].setName(line);//put all strings in variable line into hotel array

            i++;// implement i by 1, so every name has a room starting from 0 
        }
        reader.close();
    }

}
