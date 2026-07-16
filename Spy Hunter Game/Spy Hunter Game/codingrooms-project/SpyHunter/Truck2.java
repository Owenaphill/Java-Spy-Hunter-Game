import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** Gets all of the information for the respawning truck **/
public class Truck2 extends Actor
{
    MyWorld world = (MyWorld) getWorld();
    DriverMan rebootCar = new DriverMan();
    int truckCount = 0;
    private int speed;
    
    /** Constructor method to set up the size and image of the truck **/
    public Truck2(){
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
            
            //makes the truck move up at the start
            if(getY() > 1250){
                setLocation(getX(), getY()-1);
            }
            
            //once it reaches position
            else if(getY() == 1250){
                getWorld().addObject(rebootCar,getX(), getY());
                truckCount++;
                //drive away
                if (truckCount > 200){
                    setLocation(getX(), getY()-10);
                }
            }
            //drive away
            else{
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
