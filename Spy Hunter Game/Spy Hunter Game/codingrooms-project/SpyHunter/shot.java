import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** Gets all of the information for the bullet **/
public class shot extends Actor
{
    
    /** Constructor method to set up the size and image for the bullet **/
    public shot(){
        GreenfootImage img = new GreenfootImage("newBullet.jpg");
        img.scale(20, 20);
        setImage(img);
    }
    
    /** The main program that manages everything **/
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        Points point = new Points();
        //make sure the lives arent 0
        if(world.changeLives() != 0){
            Actor enemy = getOneIntersectingObject(evilCra.class);
            
            //checks if the bullet either hit an enemy or the edge of the map
            setLocation(getX(),getY() - 20);
            if(getY() <= 30 || enemy != null){
                MyWorld.toggleHasBullet();
                point.enemyDown();
                getWorld().removeObject(this);
                return;
            }
        }
    }
}
