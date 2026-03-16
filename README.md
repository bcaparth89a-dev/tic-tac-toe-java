# 🎮 Tic Tac Toe Java Game

## 📌 Project Overview

This project is a **Tic Tac Toe game built using Java and Swing GUI**.
It is a desktop-based application where a player can play the classic Tic Tac Toe game against another player or against a computer AI.

The project demonstrates several important **core Java concepts**, including:

* Object-Oriented Programming (OOP)
* Java Swing GUI development
* Event handling
* Game logic implementation
* Artificial Intelligence (AI) using the **Minimax algorithm**
* Modular project structure

The goal of this project is to create a **user-friendly graphical interface** that allows players to enjoy the Tic Tac Toe game with a responsive and interactive experience.

---

# 🧠 Features

### 🎯 Core Game Features

* Classic **3x3 Tic Tac Toe board**
* Two gameplay modes:

  * **Player vs Player**
  * **Player vs Computer (AI)**
* Smart AI opponent
* Automatic **win detection**
* Automatic **draw detection**
* Game reset functionality

### 🖥️ GUI Features

* Built using **Java Swing**
* Interactive clickable buttons
* Real-time player turn display
* Clean and simple user interface
* Sound feedback on button clicks

### 🤖 AI System

The AI opponent uses a **Minimax-based decision algorithm** that evaluates possible moves and selects the optimal move. This allows the computer to:

* Block player winning moves
* Find its own winning opportunities
* Provide challenging gameplay

---

# 🛠 Technologies Used

| Technology    | Purpose                             |
| ------------- | ----------------------------------- |
| Java          | Core programming language           |
| Java Swing    | GUI interface                       |
| IntelliJ IDEA | Development environment             |
| GitHub        | Version control and project hosting |

---

# 📂 Project Structure

The project is organized into multiple files to maintain clean and modular code.

```
tic-tac-toe-java
│
├── Main.java
├── GameUI.java
├── GameLogic.java
├── AIPlayer.java
├── SoundUtil.java
│
└── TicTacToePro.jar
```

### File Description

**Main.java**
Entry point of the program that launches the GUI.

**GameUI.java**
Handles the graphical interface and user interactions.

**GameLogic.java**
Contains the core logic to detect wins, draws, and board state.

**AIPlayer.java**
Implements the computer AI logic for selecting moves.

**SoundUtil.java**
Provides sound feedback for button clicks.

---

# ▶️ How to Run the Game

## Option 1 — Run Using the JAR File

1. Download the file:

```
TicTacToePro.jar
```

2. Open a terminal or command prompt.

3. Run the command:

```
java -jar TicTacToePro.jar
```

The Tic Tac Toe game window will open.

---

## Option 2 — Run Using Source Code

1. Clone the repository

```
git clone https://github.com/yourusername/tic-tac-toe-java.git
```

2. Open the project in **IntelliJ IDEA** or any Java IDE.

3. Run:

```
Main.java
```

---

# 🧩 Game Rules

Tic Tac Toe is a two-player strategy game played on a **3x3 grid**.

Players take turns marking a square with:

```
X
or
O
```

The first player to get **three marks in a row** wins.

Winning combinations include:

* Horizontal
* Vertical
* Diagonal

If all squares are filled without a winner, the game results in a **draw**.

---

# 📸 Screenshots

*(Add screenshots of your game here)*

Example:

```
screenshots/gameplay.png
```

---

# 🎓 Learning Objectives

This project was created to practice and demonstrate:

* Java GUI development using Swing
* Object-Oriented Programming principles
* Game design logic
* Implementing AI decision algorithms
* Project structure organization
* GitHub project hosting

---

# 🚀 Future Improvements

Possible improvements for future versions include:

* Enhanced UI design
* Score tracking system
* Online multiplayer support
* Mobile version of the game
* Improved animations and sound effects

---

# 📜 License

This project is open-source and available for educational purposes.

---

# 👨‍💻 Author

Developed as part of a **Java learning project and internship assignment**.

If you like this project, feel free to ⭐ star the repository.
