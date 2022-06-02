package zuul.world;

import zuul.items.Item;

public class Door {
    boolean isHidden;
    boolean isLocked;
    //Item key;
    Room currentRoom;
    Room nextRoom;

    public Door(Room currentRoom, Room nextRoom, boolean isHidden, boolean isLocked) {
        this.currentRoom = currentRoom;
        this.nextRoom = nextRoom;
        this.isHidden = isHidden;
        this.isLocked = isLocked;
        //this.key = key;
    }

    /*public boolean checkKey(Item item) {
        return item.getName().equals(key.getName());
    }*/

    public boolean isLocked() {
        return isLocked;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void unlock() {
        this.isLocked = false;
    }

    /*public boolean isBlocked() {
        return key == null;
    }*/
}

