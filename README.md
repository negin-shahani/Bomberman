# Bomberman
The final project of advanced programming (Java)
## description:
In the final project of the advanced programming lesson, we implemented this game with minor changes.
For example, our game is not perfect. This means that the game screen is updated every 5.0 seconds. (2FPS (
This means that the server sends game page information to clients every half second so that they can update their page.
Any change the player wants to make (move, drop a bomb, etc.) must be within 5.0 seconds.

### Offline section:
In this part, your opponents are alien creatures that move randomly on the game screen.
Before the game, the player must enter the dimensions of the screen and the number of alien creatures in the input system.
The game ends in two ways, either the bomber man encounters the space creatures twice, or he destroys them all.
A timer calculates the game time and after the end of the game, calculates the score.
### Profile:
Everyone is required to have a username and password to enter the game, and if they do not have one, they can register.
They must be distinct.
After entering the profile, the player must see all his game records.
There is a ranking option that can be clicked to see the highest scores of the offline and online sections.
The player must view the information (name, photo, etc.) on this page and be able to edit it.
In addition to the previous points, the player should see the option of playing offline or online on this page.
### Objects in the game:
1 - The bomber man:
The bomber man is the main character of the game and his characteristics are the number of bombs and his life.
2 -Alien creatures:
There are a number of alien creatures on the game screen, they randomly choose their path and on
If there is no obstacle in their way, they may go anywhere. They are destroyed if they hit the player
But reduce the player's life by half.
3 -Bomb:
Our main character can bomb anywhere on the screen.
The main feature of bombs is that they explode 3 seconds after they are made, and if the metal walls in
If they are not around, they will destroy everything in their houses up, down, left and right, but half of the player's life
Reduce.
4 - Stone walls:
This type of wall is randomly generated on the screen at the beginning of the game and is destroyed by a bomb blast in a nearby house.
Be.
5 -Metal walls:
The metal walls are in the middle of the game from the beginning and also around the screen as shown below
have taken.
### Auxiliary items:
1 -Heart: Appears randomly on the screen every 40 seconds and remains for 20 seconds. If the characters
Reach your original to complete his life.
2 - Star: appears randomly on the screen every 10 to 90 seconds. If your main character
To reach it, the bomb radius of its bombs will double in 40 seconds.
If a player eats a star in a situation where the previous star's time has not expired, the radius of his bomb blast
It doubles again, but in most cases it should never exceed 8.

