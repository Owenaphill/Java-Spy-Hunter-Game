import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** Gets all of the information for displaying and calculating Points **/
public class Points extends Actor
{
    private int pointCount = 0;
    private int count = 0;
    private static boolean enemyDown = false;
    
    /** Constructor method used to set up the text **/
    public Points(){
        setImage(new GreenfootImage("Points: " + pointCount, 30, Color.RED, new Color(0, 0, 0, 0)));
    }
    
    /** The main program that manages everything **/
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        //make sure the lives arent 0
        if(world.changeLives() != 0){
            int worldCount = world.getActCount();
            
            //wait 190 acts
            if(worldCount > 190){
                count += 1;
                
                //adds points every 10 acts
                if(count%10 == 0){
                    
                    //if youre faster, you get more points
                    if(Greenfoot.isKeyDown("Up")){
                        pointCount += 3;
                    }
                    else if(Greenfoot.isKeyDown("Down")){
                        pointCount += 1;
                    }
                    else{
                        pointCount += 2;
                    }
                    
                    //if you shoot an enemy, earn points
                    if(enemyDown){
                        pointCount += 30;
                        enemyDown();
                    }
                }
                setImage(new GreenfootImage("Points: " + pointCount, 30, Color.RED, new Color(0, 0, 0, 0)));
            }
        }
    }
    
    /** method to toggle that the enemy was killed **/
    public static void enemyDown(){
        enemyDown = !enemyDown;
    }
}
