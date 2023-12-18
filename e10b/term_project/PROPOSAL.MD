# Term Project Proposal

## I. Overview

Class:      Computer Science E-10b: Introduction to Computer Science Using Java, II

Term:       Fall, 2023

Instructor: Dr. H. H. Leitner

Student:    Aaron Del Giudice

Date:       2023-11-13

## II. Introduction

### Project Title
**Game Theory Simulator: Understanding Strategies and Outcomes**

### Objectives

#### Educational Objectives:
- Develop an intuitive application that demystifies game theory concepts through interactive experiences. The focus will be on the Prisoner's Dilemma and the Stag Hunt, showcasing simple yet profound problems in game theory.
- Analyze the effectiveness of various strategies across different game scenarios to understand strategic decision-making in game theory.

#### Technical Objectives:
- Create an interactive Java application with diverse strategies like tit-for-tat, random, and absolute (always cooperate/defect).
- Implement a user-friendly GUI for accessibility and ease of use.
- Design a modular architecture for scalability and future enhancements.
- Provide real-time feedback and comprehensive results analysis.

#### Notes on AI Implementation:
- Implement basic AI elements within the scope of Java capabilities, focusing on predefined strategies rather than advanced AI algorithms.

### Justification
- Making game theory concepts accessible can significantly benefit learners across various fields.
- The interactive nature of the application will bridge the gap between theory and practical outcomes.
- This project provides an opportunity to explore AI and game theory within the Java ecosystem.

## III. Inputs and Outputs

### Inputs
- User decisions like "Cooperate" or "Defect" in the Prisoner’s Dilemma and "Hunt Stag" or "Hunt Hare" in the Stag Hunt.
- Game settings including the number of rounds and potential modification of the payoff matrix.
- Strategy selection for the AI opponent, with options like “Random” or “Tit-for-Tat.”

### Outputs
- Immediate round results showing the outcome of each decision.
- Cumulative game summary providing an overview of performance across all rounds.
- Insights into AI decisions and strategies employed during the game.

## IV. Core Functionality

### Algorithms and Data Structures
- Implement simple and complex strategy algorithms, like “Tit-for-Tat” and heuristic-based strategies.
- Use data structures like arrays and matrices to represent game states and user decision history.

### Template Classes and Methods
- `Game`: Main class to initialize and run the game.
- `GameBackend`: Handles game logic, scoring, and AI strategies.
- `GameView`: Manages the GUI, user inputs, and displays game results.
- Strategy Classes: Separate classes or methods for each AI strategy.
- `PayoffMatrix`: Class to manage and display the payoff matrix for each game.

### User Interface and Interaction
- A clear and intuitive GUI allowing users to choose games, set rounds, and select strategies.
- Visual representations of the payoff matrix and real-time updates of scores and decisions.
- End-of-game summary with detailed insights into strategies and decision outcomes.

### Potential Challenges and Solutions
- Balancing simplicity and depth in AI strategies to maintain educational value while ensuring engaging gameplay.
- Ensuring the GUI remains user-friendly and intuitive as new features are added.
- Potential scalability issues, addressed by modular design and careful planning of class responsibilities.

## V. Conclusion
This project aims to deliver an engaging and educational experience in game theory, blending technical Java programming with strategic thinking and AI elements. It's intended to be a valuable tool for learners to visualize and understand the dynamic nature of game theory.
