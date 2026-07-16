import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** Runs the world **/
public class MyWorld extends World
{
    private static int worldSpeed = 0;
    private int lives = 3;
    private int score = 0; //global speed
    private static int actCount = 0; //global timer
    private static boolean hasCar = true; //if there is currently a car in the world
    private static boolean hasOil = false; //if there is currently a oil puddle in the world
    private static boolean hasBullet = false;
    private Lives theLives;
    private Points thePoints;
    private Truck theTruck;
    private GameOver GaOv;
    /** Constructor method to create the world **/
    public MyWorld() {    
        super(400, 1500, 1); 
        setBackground(new GreenfootImage("road.png"));
        setPaintOrder(GameOver.class, Lives.class, Points.class, tree.class, Truck.class,Truck2.class, DriverMan.class, evilCra.class, shot.class, oil.class);
        prepare();
    }
    
    /** Prepare the world for the start of the program **/
    private void prepare() {
        DriverMan driverMan = new DriverMan();
        theLives = new Lives();
        thePoints = new Points();
        theTruck = new Truck();
        GaOv = new GameOver();
        addObject(driverMan,350,1250);
        evilCra evilCra = new evilCra();
        addObject(evilCra,172,110);
        addObject(theLives, 40, 1450);
        addObject(thePoints, 50, 875);
        addObject(GaOv, 210, 1162);
        addObject(theTruck, 350, 1250);
    }
    
    /** static void method to toggle hasCar **/
    public static void toggleHasCar() {
        hasCar = !hasCar;
    }
    
    public static void toggleHasBullet() {
        hasBullet = !hasBullet;
    }
    
    public static boolean getHasBullet() {
        return hasBullet;
    }

    /** static void method to toggle hasOil **/
    public static void toggleHasOil() {
        hasOil = !hasOil;
    }
    
    /** Getter method that returns the global counter
    *@return returns the value actCount   
    */
    public static int getActCount() {
        return actCount;
    }
    
    /** Getter method that returns the speed
    *@return returns the value speed   
    */
    public static int getSpeed() {
        return worldSpeed;
    }
    
    /** Getter method that returns the lives
    *@return returns the value lives   
    */
    public int changeLives(){
        return lives;
    }
    
    /** Sets the speed of the moving objects **/
    public static void setSpeed() {
        //movement speed increased if you hold up
        if(Greenfoot.isKeyDown("Up")){
           worldSpeed = 15;
        }
        else if(Greenfoot.isKeyDown("Down")){
            worldSpeed = 5;
        }
        else{
            worldSpeed = 10;
        }
        
    }
    
    /** Respawns the Driver car **/
    public void respawn(){
        lives--;
        Truck2 rebootVan = new Truck2();
        addObject(rebootVan, 350, 1500);
    }
    
    /** Randomise the background **/
    private static int bgNum = 1;
    public void toggleBG() {
        
        //moves the background
        if (bgNum == 1) {
            do {
                bgNum = Greenfoot.getRandomNumber(3);
            } while (bgNum == 1);
            setBackground(new GreenfootImage("road.png"));
        } else if (bgNum == 2) {
            do {
                bgNum = Greenfoot.getRandomNumber(3);
            } while (bgNum == 2);
            setBackground(new GreenfootImage("road2.png"));
        } else {
            do {
                bgNum = Greenfoot.getRandomNumber(3);
            } while (bgNum == 0);
            setBackground(new GreenfootImage("road3.png"));
        }
    }

    /** The main program that manages everything **/
    public void act() {
        if(changeLives() != 0){
            DriverMan driverMan = new DriverMan();
            //increment global timer
            actCount += 1;
            //waits 300 acts
            if(actCount > 300){
                setSpeed();
                //if there is no evil car, spawn an evil car
                if(!hasCar) {
                    int spawnCarY = Greenfoot.getRandomNumber(getHeight() - 600);
                    int spawnCarX = Greenfoot.getRandomNumber(getWidth());
                    evilCra car = new evilCra();
                    if(spawnCarX < 20){
                        spawnCarX += 20;
                    }
                    else if(spawnCarX > 380){
                        spawnCarX -= 20;
                    }
                    addObject(car,spawnCarX,spawnCarY);
                    toggleHasCar(); //update variable
                }
                
                //if there is no oil puddle, spawn an oil puddle
                if(!hasOil) {
                    int spawnOilY = Greenfoot.getRandomNumber(getHeight() - 500);
                    int spawnOilX = Greenfoot.getRandomNumber(getWidth());
                    oil slick = new oil();
                    if(spawnOilX < 20){
                        spawnOilX += 20;
                    }
                    else if(spawnOilX > 380){
                        spawnOilX -= 20;
                    }
                    addObject(slick,spawnOilX,spawnOilY);
                    toggleHasOil(); //update variable
                }
        
                //change the background after 50 acts
                if (actCount % 50 == 0) {
                    toggleBG();
                }
        
                    int spawnInt = Greenfoot.getRandomNumber(5);
                    
                    //add a random pattern of cones after 1500 acts
                    if (actCount % 1500 == 0) {
                        if (spawnInt == 1) {
                            tree tree = new tree();
                            addObject(tree,192,20);
                            tree tree2 = new tree();
                            addObject(tree2,191,71);
                            tree tree3 = new tree();
                            addObject(tree3,191,122);
                            tree tree4 = new tree();
                            addObject(tree4,189,176);
                            tree tree5 = new tree();
                            addObject(tree5,189,226);
                            tree tree6 = new tree();
                            addObject(tree6,190,278);
                            tree tree7 = new tree();
                            addObject(tree7,191,333);
                            tree tree8 = new tree();
                            addObject(tree8,191,383);
                            tree tree9 = new tree();
                            addObject(tree9,189,431);
                    }else if (spawnInt == 2) {
                        tree tree = new tree();
                        addObject(tree,20,47);
                        tree tree2 = new tree();
                        addObject(tree2,102,48);
                        tree tree3 = new tree();
                        addObject(tree3,199,49);
                        tree tree4 = new tree();
                        addObject(tree4,311,48);
                        tree tree5 = new tree();
                        addObject(tree5,389,52);
                    }else if (spawnInt == 3) {
                        tree tree = new tree();
                        addObject(tree,13,86);
                        tree tree2 = new tree();
                        addObject(tree2,38,109);
                        tree tree3 = new tree();
                        addObject(tree3,64,138);
                        tree tree4 = new tree();
                        addObject(tree4,85,166);
                        tree tree5 = new tree();
                        addObject(tree5,107,194);
                        tree tree6 = new tree();
                        addObject(tree6,126,219);
                        tree tree7 = new tree();
                        addObject(tree7,116,248);
                        tree tree8 = new tree();
                        addObject(tree8,102,274);
                        tree tree9 = new tree();
                        addObject(tree9,86,295);
                        tree tree10 = new tree();
                        addObject(tree10,66,318);
                        tree tree11 = new tree();
                        addObject(tree11,45,342);
                        tree tree12 = new tree();
                        addObject(tree12,24,361);
                        tree12.setLocation(6,376);
                        tree tree13 = new tree();
                        addObject(tree13,6,376);
                        tree12.setLocation(6,352);
                        tree tree14 = new tree();
                        addObject(tree14,6,352);
                        tree tree15 = new tree();
                        addObject(tree15,8,331);
                        tree tree16 = new tree();
                        addObject(tree16,8,310);
                        tree tree17 = new tree();
                        addObject(tree17,8,284);
                        tree tree18 = new tree();
                        addObject(tree18,7,258);
                        tree tree19 = new tree();
                        addObject(tree19,9,223);
                        tree tree20 = new tree();
                        addObject(tree20,6,194);
                        tree tree21 = new tree();
                        addObject(tree21,6,172);
                        tree tree22 = new tree();
                        addObject(tree22,9,144);
                        tree tree23 = new tree();
                        addObject(tree23,9,115);
                        tree tree24 = new tree();
                        addObject(tree24,28,136);
                        tree tree25 = new tree();
                        addObject(tree25,28,161);
                        tree tree26 = new tree();
                        addObject(tree26,33,192);
                        tree tree27 = new tree();
                        addObject(tree27,29,220);
                        tree27.setLocation(30,239);
                        tree tree28 = new tree();
                        addObject(tree28,30,239);
                        tree tree29 = new tree();
                        addObject(tree29,31,267);
                        tree tree30 = new tree();
                        addObject(tree30,32,294);
                        tree11.setLocation(31,326);
                        tree tree31 = new tree();
                        addObject(tree31,31,326);
                        tree tree32 = new tree();
                        addObject(tree32,56,294);
                        tree tree33 = new tree();
                        addObject(tree33,56,235);
                        tree tree34 = new tree();
                        addObject(tree34,58,262);
                        tree tree35 = new tree();
                        addObject(tree35,57,192);
                        tree3.setLocation(54,156);
                        tree tree36 = new tree();
                        addObject(tree36,54,156);
                        tree tree37 = new tree();
                        addObject(tree37,78,210);
                        tree tree38 = new tree();
                        addObject(tree38,78,234);
                        tree tree39 = new tree();
                        addObject(tree39,78,270);
                        tree tree40 = new tree();
                        addObject(tree40,105,224);
                    }else if (spawnInt == 4) {
                        tree tree = new tree();
                        addObject(tree,186,7);
                        tree tree2 = new tree();
                        addObject(tree2,188,36);
                        tree tree3 = new tree();
                        addObject(tree3,189,62);
                        tree tree4 = new tree();
                        addObject(tree4,191,85);
                        tree tree5 = new tree();
                        addObject(tree5,189,119);
                        tree4.setLocation(191,99);
                        tree tree6 = new tree();
                        addObject(tree6,191,99);
                        tree tree7 = new tree();
                        addObject(tree7,190,144);
                        tree tree8 = new tree();
                        addObject(tree8,191,174);
                        tree8.setLocation(193,196);
                        tree tree9 = new tree();
                        addObject(tree9,191,165);
                        tree tree10 = new tree();
                        addObject(tree10,195,222);
                        tree tree11 = new tree();
                        addObject(tree11,195,250);
                        tree tree12 = new tree();
                        addObject(tree12,196,271);
                        tree tree13 = new tree();
                        addObject(tree13,198,296);
                        tree13.setLocation(198,316);
                        tree tree14 = new tree();
                        addObject(tree14,198,316);
                        tree tree15 = new tree();
                        addObject(tree15,199,343);
                        tree tree16 = new tree();
                        addObject(tree16,201,372);
                        tree tree17 = new tree();
                        addObject(tree17,201,404);
                        tree tree18 = new tree();
                        addObject(tree18,201,436);
                        tree tree19 = new tree();
                        addObject(tree19,200,470);
                        tree tree20 = new tree();
                        addObject(tree20,201,499);
                        tree tree21 = new tree();
                        addObject(tree21,203,521);
                        tree tree22 = new tree();
                        addObject(tree22,204,547);
                        tree tree23 = new tree();
                        addObject(tree23,205,576);
                        tree tree24 = new tree();
                        addObject(tree24,206,604);
                        tree tree25 = new tree();
                        addObject(tree25,207,630);
                        tree tree26 = new tree();
                        addObject(tree26,187,631);
                        tree tree27 = new tree();
                        addObject(tree27,164,631);
                        tree tree28 = new tree();
                        addObject(tree28,145,631);
                        tree tree29 = new tree();
                        addObject(tree29,126,630);
                        tree29.setLocation(110,630);
                        tree tree30 = new tree();
                        addObject(tree30,110,630);
                        tree tree31 = new tree();
                        addObject(tree31,88,630);
                        tree31.setLocation(70,630);
                        tree tree32 = new tree();
                        addObject(tree32,70,630);
                        tree32.setLocation(54,630);
                        tree tree33 = new tree();
                        addObject(tree33,54,630);
                        tree33.setLocation(36,630);
                        tree tree34 = new tree();
                        addObject(tree34,36,630);
                        tree tree35 = new tree();
                        addObject(tree35,14,630);
                        tree35.setLocation(5,629);
                        tree tree36 = new tree();
                        addObject(tree36,5,629);
                    }else {
                        tree tree = new tree();
                        addObject(tree,199,12);
                        tree tree2 = new tree();
                        addObject(tree2,199,38);
                        tree tree3 = new tree();
                        addObject(tree3,199,64);
                        tree tree4 = new tree();
                        addObject(tree4,200,90);
                        tree tree5 = new tree();
                        addObject(tree5,200,117);
                        tree tree6 = new tree();
                        addObject(tree6,200,143);
                        tree tree7 = new tree();
                        addObject(tree7,201,168);
                        tree tree8 = new tree();
                        addObject(tree8,201,193);
                        tree tree9 = new tree();
                        addObject(tree9,203,215);
                        tree tree10 = new tree();
                        addObject(tree10,203,239);
                        tree tree11 = new tree();
                        addObject(tree11,204,266);
                        tree tree12 = new tree();
                        addObject(tree12,204,297);
                        tree tree13 = new tree();
                        addObject(tree13,205,324);
                        tree tree14 = new tree();
                        addObject(tree14,205,352);
                        tree tree15 = new tree();
                        addObject(tree15,205,379);
                        tree tree16 = new tree();
                        addObject(tree16,207,403);
                        tree tree17 = new tree();
                        addObject(tree17,207,434);
                        tree tree18 = new tree();
                        addObject(tree18,209,460);
                        tree tree19 = new tree();
                        addObject(tree19,209,488);
                        tree tree20 = new tree();
                        addObject(tree20,210,519);
                        tree tree21 = new tree();
                        addObject(tree21,210,548);
                        tree tree22 = new tree();
                        addObject(tree22,215,572);
                        tree tree23 = new tree();
                        addObject(tree23,215,601);
                        tree tree24 = new tree();
                        addObject(tree24,216,627);
                        tree tree25 = new tree();
                        addObject(tree25,237,627);
                        tree tree26 = new tree();
                        addObject(tree26,256,628);
                        tree tree27 = new tree();
                        addObject(tree27,276,628);
                        tree tree28 = new tree();
                        addObject(tree28,301,627);
                        tree tree29 = new tree();
                        addObject(tree29,324,627);
                        tree tree30 = new tree();
                        addObject(tree30,347,630);
                        tree tree31 = new tree();
                        addObject(tree31,371,629);
                        tree tree32 = new tree();
                        addObject(tree32,395,629);
                    }
                }
            }
        }
        
}
    }
