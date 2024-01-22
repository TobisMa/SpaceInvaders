import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int speed, health;
    
    public Enemy(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }
    
    public void attack(int damage, Player cause) {
        this.health = Math.max(0, health - damage);
        if (health <= 0) {
            getWorld().removeObject(this);
        }
        cause.increaseLevel();
    }
    
    public void act() {
        Player p = (Player) getOneIntersectingObject(Player.class);
        if (p != null) {
            getWorld().removeObject(this);
            p.attack(this.health);
        }
        else if (isAtEdge() && getY() > 100) {
            getWorld().removeObject(this);
        }
        else {
            setLocation(getX(), getY() + this.speed);
        }
    }
}
