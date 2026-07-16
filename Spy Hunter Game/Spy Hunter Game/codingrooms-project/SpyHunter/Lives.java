import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** Gets all of the information for displaying Lives **/
public class Lives extends Actor
{
    /** Constructor method used to set up the text **/
    public Lives(){
        setImage(new GreenfootImage("Lives: 3", 25, Color.RED, new Color(0, 0, 0, 0)));
    }
    
    /** The main program that manages everything **/
    public void act(){
        MyWorld world = (MyWorld) getWorld();
        
        //check if the world exists
        if(world == null){
            return;
        }
        int updateLives = world.changeLives();
        setImage(new GreenfootImage("Lives: " + updateLives, 25, Color.RED, new Color(0, 0, 0, 0)));
    }
}
