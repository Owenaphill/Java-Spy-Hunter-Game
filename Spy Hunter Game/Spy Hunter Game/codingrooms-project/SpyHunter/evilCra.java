import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** Gets all of the information for the enemy **/
public class evilCra extends Actor
{
    Points point = new Points();
    MyWorld world = (MyWorld) getWorld();
    DriverMan driver = new DriverMan();
    private int speed;
    private int hits = 0;
    private int counts = 0;
    
    /** The main program that manages everything **/
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        //make sure the lives arent 0
        if(world.changeLives() != 0){
            counts += 1;
            //checks if the world exists yet
            if(getWorld() == null){
                return;
            }
            //move down
            speed = ((MyWorld)getWorld()).getSpeed();
            setLocation(getX(),getY() + speed);
    
            //if at the bottom, be destroyed
            if(getY() >= getWorld().getHeight() - 30){
                MyWorld.toggleHasCar();
                getWorld().removeObject(this);
                return;
            }
            
            Actor bullet = getOneIntersectingObject(shot.class);
            Actor rebootVan = getOneIntersectingObject(Truck2.class);
            
            //if bullet collided with the enemy
            if(bullet != null){
                hits += 1;
                point.enemyDown();
            }
            
            //if bullet collided with the enemy or the respawn truck
            if (hits >= 1 || rebootVan != null){
                GreenfootImage img = new GreenfootImage("someoneSayBoom.jpg");
                img.scale(50, 50);
                setImage(img);
            }
            
            //if bullet collided with the enemy or the respawn truck and 20 acts have passed
            if((counts%20 == 0 && hits >= 1) || (rebootVan != null && counts%20 == 0)){
                    MyWorld.toggleHasCar();
                    getWorld().removeObject(this);
                    return;
            }
        }
    }
}
