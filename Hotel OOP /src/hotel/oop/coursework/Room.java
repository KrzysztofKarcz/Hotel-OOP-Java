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
public class Room {

      // String mainName;
    private String mainName;
    int guestsInRoom;

    public Room() {
        mainName = "empty";
        System.out.println("made a room ");
    }

    public void setName(String aName) {
        System.out.println("add name class method ");
        mainName = aName;

    }

    public String getName() {
        return mainName;
    }

}
