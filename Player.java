import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed, level, delay, health;
    private int coolDown = 10;
    
    public Player(int speed, int level) {
        this.speed = speed;
        this.level = level;
        this.health = 1;
        
        GreenfootImage image = getImage();
        image.clear();
        image.scale(30, 30);
        image.setColor(new Color(0, 0, 255));
        image.fillRect(0, 0, 30, 30);
    }
    
    public void act()
    {
        getWorld().showText(null, getX(), getY());
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());
        }
        if (Greenfoot.isKeyDown("w") && delay > coolDown) {
            getWorld().addObject(new Laser(this, this.speed, this.level), getX(), getY() - getImage().getHeight());
            delay = 0;
        }
        getWorld().showText("" + health, getX(), getY());
        delay++;
    }
    
    public void increaseLevel() {
        this.level++;
        if (this.level % 2 == 0) {
            this.health += 2;
        }
    }
    
    public void attack(int damage) {
        health = Math.max(0, health - damage);
        if (health <= 0) {
            ((MainWorld)getWorld()).done();
        }
    }
}
