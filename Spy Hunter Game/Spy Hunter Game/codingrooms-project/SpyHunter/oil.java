import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** Gets all of the information for the oil puddles **/
public class oil extends Actor
{
    private int speed;
    MyWorld world = (MyWorld) getWorld();
    
    /** Constructor method to set up the size and image for the oil **/
    public oil(){
        GreenfootImage img = new GreenfootImage("newOil.jpg");
        img.scale(50, 50);
        setImage(img);
    }
    
    /** The main program that manages everything **/
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        //make sure the lives arent 0
        if(world.changeLives() != 0){
            
            //checks if the world exists yet
            if(getWorld() == null){
                return;
            }
            
            //move down
            speed = ((MyWorld)getWorld()).getSpeed();
            setLocation(getX(),getY() + speed);
            
            //if at the bottom, be destroyed
            if(getY() >= getWorld().getHeight() - 30){
                getWorld().removeObject(this);
                MyWorld.toggleHasOil();
                return;
            }
        }
    }
}
