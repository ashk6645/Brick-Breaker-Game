# Brick-Breaker-Game
# Created by Ashutosh Pratap Singh #
# Copyright 2023 #
# Brick Breaker Game (Java)

## Description
This is a simple implementation of the classic Brick Breaker game using Java. The objective of the game is to break all the bricks on the screen by bouncing a ball off a paddle. The player controls the paddle using the left and right arrow keys to prevent the ball from falling off the bottom of the screen. The game ends when all the bricks are destroyed or the ball falls off the screen.

## Features
- A paddle controlled by the player to bounce the ball.
- Bricks arranged in different patterns and colors.
- A ball that bounces off the walls, paddle, and bricks.
- Scoring system to keep track of the player's score.
- Lives counter to show the remaining lives.
- Levels with increasing difficulty as the player progresses.
- Sound effects for ball collisions and brick destruction.

## Installation
To run the Brick Breaker game, make sure you have Java Development Kit (JDK) installed on your system. Then follow these steps:

1. Clone the repository or download the source code files.
2. Open a command prompt or terminal window.
3. Navigate to the directory where the files are located.
4. Compile the Java source files by running the following command:
   ```
   javac *.java
   ```
5. Start the game by running the following command:
   ```
   java BrickBreaker
   ```

## How to Play
1. Use the left and right arrow keys to move the paddle horizontally.
2. Launch the ball by pressing the spacebar.
3. Bounce the ball off the paddle to hit the bricks.
4. Break all the bricks to advance to the next level.
5. If the ball falls off the bottom of the screen, you lose a life.
6. The game ends when all lives are lost or all bricks are destroyed.

## Customization
You can customize certain aspects of the game by modifying the following variables in the `Constants.java` file:

- `SCREEN_WIDTH`: The width of the game screen in pixels.
- `SCREEN_HEIGHT`: The height of the game screen in pixels.
- `PADDLE_WIDTH`: The width of the paddle in pixels.
- `PADDLE_HEIGHT`: The height of the paddle in pixels.
- `BALL_RADIUS`: The radius of the ball in pixels.
- `BALL_SPEED`: The initial speed of the ball.
- `PADDLE_SPEED`: The speed at which the paddle moves horizontally.
- `BRICK_ROWS`: The number of rows of bricks.
- `BRICK_COLUMNS`: The number of columns of bricks.
- `BRICK_WIDTH`: The width of each brick in pixels.
- `BRICK_HEIGHT`: The height of each brick in pixels.
- `BRICK_GAP`: The gap between bricks in pixels.
- `MAX_LIVES`: The maximum number of lives the player starts with.

Feel free to modify these values to adjust the game's difficulty or appearance according to your preferences.

## Dependencies
This Brick Breaker game does not have any external dependencies.

## Contributions
Contributions to the project are welcome. If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License
The game is released under the [MIT License](LICENSE). You are free to use, modify, and distribute the code for personal and commercial purposes.
