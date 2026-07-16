import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** Gets all of the information for the player **/
public class DriverMan extends Actor
{
    MyWorld world = (MyWorld) getWorld();
    private int speed;
    private int baseMovement = 5;
    private int counts = 0;
    private boolean driverDown = false;
    
    /** The main program that manages everything **/
    public void act() {
        int worldCount = world.getActCount();
        MyWorld world = (MyWorld) getWorld();
        if(world.changeLives() != 0){
            if(counts > 0){
                //move left
                if(Greenfoot.isKeyDown("Left")){
                    move(-(baseMovement));
                }
        
                //move right
                if(Greenfoot.isKeyDown("Right")){
                    move(baseMovement);
                }
    
                //shoot
                if (!MyWorld.getHasBullet() && Greenfoot.isKeyDown("space")) {
                    getWorld().addObject(new shot(), getX(), getY()-35);
                    MyWorld.toggleHasBullet();
                }
                
                //detect collision with enemy
                Actor enemy = getOneIntersectingObject(evilCra.class);
                if(enemy != null){
                    getWorld().removeObject(enemy);
                    MyWorld.toggleHasCar();
                    hitSomething();
                    return;
                }
            
                //detect collision with cone
                Actor tre = getOneIntersectingObject(tree.class);
                if(tre != null){
                    hitSomething();
                    return;
                }
                
                //detect collision with oil
                Actor slip = getOneIntersectingObject(oil.class);
                if(slip != null && !driverDown){
                    baseMovement = 1;
                }
                
                
                //reset movement after going on oil
                if(counts % 180 == 0 && !driverDown){
                    baseMovement = 5;
                }
            
                //delete object after 20 acts and if they died
                if(counts%20 == 0 && driverDown){
                    getWorld().removeObject(this);
                    return;
                }
            }
            counts += 1;
            
            //move car down if its too far up
            if(getY() <= 1430 && this != null){
                GreenfootImage img = new GreenfootImage("car02-n.png");
                setImage(img);
                setLocation(getX(),getY() + 1);
                counts = 0;
            }
        }
    }
    
    /** method that handles what happens if the player were to get hit **/
    public void hitSomething(){
        MyWorld world = (MyWorld) getWorld();
        GreenfootImage img = new GreenfootImage("codingrooms-project/images/someoneSayBoom.jpg");
        img.scale(50, 50);
        setImage(img);
        baseMovement = 0;
        driverDown = !driverDown;
        world.respawn();
        counts = 0;
    }
}
