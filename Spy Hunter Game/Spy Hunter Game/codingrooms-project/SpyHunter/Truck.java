import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** Gets all of the information for the spawning truck **/
public class Truck extends Actor
{
    DriverMan driver = new DriverMan();
    int truckCount = 0;
    private int speed;
    
    /** Constructor method to set up the size and image of the truck **/
    public Truck(){
        GreenfootImage img = new GreenfootImage("newTruck.png");
        img.scale(75, 175);
        setImage(img);
    }
    
    /** The main program that manages everything **/
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        //make sure the lives arent 0
        if(world.changeLives() != 0){
            truckCount++;
            
            //wait for the car to roll out
            if(truckCount > 250){
                
                //make sure the world exists
                if(getWorld() == null){
                    return;
                }  
                
                //move truck up
                setLocation(getX(), getY()-10);
                
                //if at the top, be destroyed
                if(getY() <= 100){
                    getWorld().removeObject(this);
                    return;
                }
            }
        }
    }
}
