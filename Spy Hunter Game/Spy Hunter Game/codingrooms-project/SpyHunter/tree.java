import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** Gets all of the information for the cones **/
public class tree extends Actor
{
    
    /** The main program that manages everything **/
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        //make sure the lives arent 0
        if(world.changeLives() != 0){
            
            //move down
            setLocation(getX(),getY() + MyWorld.getSpeed());
            
            //if at the bottom, be destroyed
            if (getY() >= getWorld().getHeight() - 10) {
                getWorld().removeObject(this);
            }
        }
    }
}
