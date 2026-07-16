# Java-Spy-Hunter-Game
A Java Greenfoot program that tried to be 1983 Spy Hunter. I built this initially as a group Computer Science project, but my teammates didn't do anything so I had to create a game on my own. I focused on understanding Greenfoot and taking what I know and applying it to a different Java environment

## Technologies
* Java
* JavaFX
* GreenFoot

## Features
What the game program does is
  * **Drive to earn points**: You gain points over time or you can hold W and gain more points but you drive faster, making the game harder
  * **Shoot enemies to earn points**: You are equipped with guns to your car where you can shoot enemy vehicles trying to hit you
  * **Dodge obstacles**: Obstacles such as oil spills, cones, come your way and you got to dodge them and the enemies
  * **Respawn with the Weapons Truck**: If you lose a life the Weapons Van will come in and drop a new car off for you to control

## The Process
This is a list of all the classes in the game and what they do
  * **MyWorld**: The world and plane the player is in. Establish background image. Uses ticks to swap between 3 images of road, to give the illusion of the car moving. Also has set patterns for how the cones should be set up, and every few ticks will give a random number which will choose if it will summon comes and which pattern it will do.
  * **DriverMan**: The car that the player controls. Has movement controls to move left and right, can also press space bar to shoot a bullet. If collided with an enemy or cone it will explode and respawn.
  * **evilCra**: The enemy car that the player has to shoot or dodge. There are 2 at all times in the game. They start at the top off screen and move down to the bottom of the screen. Once they hit the bottom of the screen they disappear and reappear at the top of the screen. And if the player is holding up the cars will move down faster.
  * **GameOver**: Text that will cover the screen once the player has lost all 3 lives. It also pauses the whole game forcing you to reset to play again.
  * **Lives**: Text that displays how many lives the player has. Starts at 3 but any time the player explodes it results in 1 less live.
  * **oil**: Oil spill that the player must dodge. If the player lands in the oil it will slow down the player left and right movement for a brief amount of time.  And if the player is holding up the oil will move down faster.
  * **Points**: Text that will display how many points the player has gained. It also will increase if the player is holding up, meaning that while driving faster results in faster objects it also gives more points.
  * **shot**: Bullet shot from the car when space bar is pressed. If collided with an enemy car the enemy will blow up, bullet will disappear, and will add points to your score. If you miss you must wait a brief amount of time before shooting again. Rewarding the player for shooting at the right time and not constantly shooting.
  * **tree**: Originally a tree obstacle but in the final game became the cones. If the player collides with the cones their car will explode. These are mostly handled in MyWorld by spawning them in patterns.
  * **Truck**: This is the first truck that drops your car on the road. It is the inital spawn truck, and will defend the player for a brief amount of time.
  * **Truck2**: This is the respawn truck that drops your car on the road when you lose a life. It has the same properties as Truck.

## What I Learned
During this project, I learned some new skills and better improved on my own skills. I also learned how to crunch to get a project out in a short amount of time.

### Greenfoot and Game Design
  * **Creativity**: Creating a game taught me about all the steps from coming up with an idea, to planning what to do, to drafting a concept, to revising, polishing, and presenting
### Time Management
  * **Handle Pressure**: Being given a project that had to be done in half a week and having to work on my own. I learned how to manage making this game and juggle the other projects in my other classes. Having to balance all of them at once to get everything done.
### Decisions to Keep and Throw
  * **Critcal Thinking**: There was a lot that couldn't be included because of the time constrains. Spy Hunter is a big game and we had to remove a lof of features from it down to its barebones. Such a decision was removing different gun styles because there was very little time and I thought it wouldn't add much to the game and would make it too convoluted.
### Little Understanding Beforehand
  * **Problem Solving**: I had very little knowledge on how to use Greenfoot or making any games before this. I learned not only how to program it all, but I felt proud of what I had created. And in the end I got to have fun learning how to make a game, even if it's simple like this.

## Overall Growth
This project taught me not only about Java or Greenfoot, but also how to handle a project on my own. It gave me confidence that I can go and make what I want and don't need to rely on other people to get something done. That I can solve a problem myself and get something done.

## How can it be Improved?
* Code can be condensed better and cleaned up better
* Don't need 2 trucks, can just use 1 for both functions
* Want other gun styles by driving into a Weapons Truck such as shotgun
* Have paths and when the player goes off path its slower to move left and right
* Wanted the oil to move the player side to side, but wouldn't work
* Include more obstacle types that give different effects

## Running the Project
To run the project in your local environment, follow these steps:
1. Install the ZIP file
2. Go to https://www.greenfoot.org/download
3. Download the Greenfoot Desktop Application
4. Open Greenfoot.exe
5. Click 'Scenario' in the top left
6. Click 'Open'
7. Go through the file and chose to open SpyHunter in Spy Hunter Game\Spy Hunter Game\codingrooms-project
8. Scroll down and click Run
