import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    private int speed, damage;
    private Player spawner;
    
    public Laser(Player spawner, int speed, int damage) {
        this.speed = speed;
        this.damage = damage;
        this.spawner = spawner;
        
        GreenfootImage image = getImage();
        image.clear();
        image.scale(6, 30);
        image.setColor(new Color(255, 0, 0));
        image.fillRect(0, 0, 30, 30);
    }
    public void act()
    {
        Enemy e = (Enemy) getOneIntersectingObject(Enemy.class);
        if (e != null) {
            e.attack(this.damage, spawner);
            this.spawner.increaseLevel();
            getWorld().removeObject(this);
        }
        else if (isAtEdge()) {
            getWorld().removeObject(this);
        }
        else {
            setLocation(getX(), getY() - speed);
        }
    }
}
