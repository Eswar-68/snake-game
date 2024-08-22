# Snake Game

This is a simple command-line implementation of the classic Snake game in Java. The player controls a snake to collect food, which makes the snake grow longer. The game ends when the snake collides with itself or the boundaries of the board.

## Features

- Text-based, command-line interface (CLI)
- Simple 2D grid representation of the game board
- Snake grows longer as it eats food
- Game ends when the snake collides with itself or the wall

## How to Play

- The snake starts with a length of 3 segments in the middle of the board.
- The player can control the snake's direction using the following keys:
  - `W` - Move Up
  - `A` - Move Left
  - `S` - Move Down
  - `D` - Move Right
- The goal is to eat the food (`*`) that randomly appears on the board. Each time the snake eats the food, it grows longer.
- The game continues until the snake collides with itself or the boundaries of the board.

## How to Run

### Prerequisites

- Java Development Kit (JDK) installed on your system.
- A terminal or command-line interface.

### Running the Game

1. Clone the repository or download the source code.

2. Compile the Java file:

   ```bash
   javac SnakeGame.java
   ```

3. Run the compiled class:

   ```bash
   java SnakeGame
   ```

4. Use the keyboard controls (`W`, `A`, `S`, `D`) to play the game.

## Code Structure

- **`SnakeGame.java`**: The main game logic is implemented in this file. The class `SnakeGame` contains methods for initializing the game, processing input, updating the game state, and printing the game board.

### Key Methods

- **`initGame()`**: Initializes the snake and places the food on the board.
- **`placeFood()`**: Randomly places food on the board ensuring it doesn't overlap with the snake.
- **`printBoard()`**: Prints the current state of the board.
- **`updateGame()`**: Updates the snake's position and checks for collisions.
- **`processInput(char input)`**: Processes the player's input to control the snake's direction.
- **`start()`**: Starts the game loop.

## Example

Here is an example of what the game might look like during play:

```
     --------------
     -            -
     -    ###     -
     -            -
     -            -
     -     *      -
     -            -
     --------------
```

## Contributing

Contributions are welcome! If you have any improvements or bug fixes, feel free to submit a pull request.

## License

This project is open-source and available under the MIT License.
