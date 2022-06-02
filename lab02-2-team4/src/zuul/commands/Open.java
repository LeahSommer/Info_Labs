package zuul.commands;

import zuul.GameStatus;
import zuul.world.Door;
import zuul.world.Room;


public class Open extends Command
{
    public Open(String parameter){
        super(parameter);
    }

    @Override
    public String commandImplementation(GameStatus gameStatus){

        if(!hasParameter()) {
            // if there is no second word, we don't know where to go...
            return "zuul.commands.Open what?";
        }

        String direction = getParameter();

        // Get the door
        Door door = gameStatus.getLocation().getDoor(direction);

        if (!door.isLocked()) {
            return "The door is already open!";
        }
        else {
            boolean userHasKey = gameStatus.getInventory().get("key") != null;
            if (userHasKey) {
                door.unlock();
                return "You opened the door!";
            }
            return "You need a key!!";
        }
    }
}
