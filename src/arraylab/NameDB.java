/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylab;

/**
 *
 * @author ektasharma
 */
public class NameDB {

    private String[] nameList;
    private int count;
    private final int capacity;
//    private int indexNumber;

    public NameDB(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        nameList = new String[capacity];
    }

    public NameDB() {
        this(10);
    }

    public boolean addName(String name) {
        boolean added = false;
        if (count < capacity) {
            nameList[count++] = name;
            added = true;
        }
        return added;
    }

    public void printName() {
        System.out.println("************** List of names ***************");
        for (int index = 0; index < count; index++) {
            System.out.println("Name is :" + nameList[index]);

        }
    }

    public int findName(String name) {
        int loc = -1;
        for (int index = 0; index < count; index++) {
            if (name.equalsIgnoreCase(nameList[index])) {
                loc = index;
                break;
            }
        }
        return loc;
    }

    public boolean updateName(String name, String updatedName) {
        boolean updated = false;
        int indexForUpdatingName = findName(name);

        if (indexForUpdatingName >= 0) {
            nameList[indexForUpdatingName] = updatedName;
            updated = true;
//            System.out.println("Name is updated successfully");
        }
        return updated;
    }

    public boolean deleteName(String name) {
        boolean deleteStatus = false;
        int indexForDeletingName = findName(name);

        if (indexForDeletingName >= 0) {
            nameList[indexForDeletingName] = nameList[indexForDeletingName + 1];
            deleteStatus = true;
        }
        return deleteStatus;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.count;
    }
}
