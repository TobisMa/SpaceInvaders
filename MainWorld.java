import greenfoot.*;
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWorld extends World
{

    private int totalSpawned = 0, delay = 0;
    private static Random r = new Random();
    private boolean done = false;
    
    public MainWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1);
        Player p = new Player(10, 1);
        addObject(p, getWidth() / 2 - p.getImage().getWidth() / 2, (int) (getHeight() / 3f * 2));
    }
    
    public void done() {
        done = true;
        for (Actor a : getObjects(Actor.class)) {
            removeObject(a);
        }
        showText("You lost", getWidth() / 2 - 100, getHeight() / 3);
    }
    
    public void act() {
        if (done) {
            return;
        }
        if (delay <= 0 && getObjects(Enemy.class).size() <= 15) {
            addObject(new AlienShip(), r.nextInt(getWidth()), 0);
            totalSpawned++;
            delay = 10;
        }
        delay--;
    }
}
