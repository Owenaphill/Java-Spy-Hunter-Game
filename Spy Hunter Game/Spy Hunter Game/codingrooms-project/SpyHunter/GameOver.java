import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** Gets all of the information for displaying Game Over **/
public class GameOver extends Actor
{
    
    /** Constructor method used to set up the text **/
    public GameOver(){
        setImage(new GreenfootImage("", 80, Color.RED, new Color(0, 0, 0, 0)));
    }
    
    /** The main program that manages everything **/
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
            //check if the world exists
            if(world == null){
                return;
            }
            int updateLives = world.changeLives();
            
            //checks if lives are 0
            if(updateLives == 0){
                setImage(new GreenfootImage("GAME OVER", 80, Color.RED, new Color(0, 0, 0, 0)));
    
            }
    }
}
