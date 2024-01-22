import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AlienShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlienShip extends Enemy
{
    public AlienShip() {
        super(2, 3);
        GreenfootImage image = getImage();
        image.clear();
        image.scale(20, 20);
        image.setColor(new Color(0, 150, 0));
        image.fillRect(0, 0, 30, 30);
    }
    public void act()
    {
        super.act();
    }
}
