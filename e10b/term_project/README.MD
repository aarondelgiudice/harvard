# Term Project

## I. Overview

Class:      Computer Science E-10b: Introduction to Computer Science Using Java, II

Term:       Fall, 2023

Instructor: Dr. H. H. Leitner

Student:    Aaron Del Giudice

Date:       2023-12-18

This Java program is a game theory simulator that allows players to engage in two game theory scenarios: Prisoner's Dilemma and Stag Hunt. The player selects a game, chooses a strategy, and plays against a computer opponent through multiple rounds.

### Prisoner's Dilemma

In the Prisoner's Dilemma, you and another prisoner are suspected of committing a crime together. You are interrogated separately and cannot communicate with each other. You have two options: cooperate with your partner by staying silent or compete by betraying them. If you both cooperate, you get a minor sentence due to lack of evidence. If one cooperates\ and the other competes, the cooperator receives a heavy sentence while the competitor goes free. If both compete, you both get a moderate sentence. Your decisions impact both your fate and your partner's.

### Stag Hunt

In the Stag Hunt, you and another hunter must decide whether to cooperate or compete while hunting. You can either jointly hunt a stag (cooperate) or individually hunt a rabbit (compete). Successfully hunting a stag requires cooperation and brings greater rewards, but if one hunter defects to chase a rabbit, they guarantee themselves a smaller reward while leaving the other with nothing. Cooperation leads to the best mutual outcome, but the temptation to secure an individual reward is ever-present.

## Files

1. Game.java

2. GameBackend.java

3. GameView.java

## How to Run

- Compile all files: `javac -d . *.java`

- Run Game.java: `java Game`

- Play the game.

## Game Mechanics

### Overview
This game theory simulator allows players to experience two classic dilemmas: the Prisoner's Dilemma and the Stag Hunt. Each game has distinct rules, payoff matrices, and strategies. The player competes against a computer opponent and can choose between various strategies.

### Scoring and Payoff Matrix
- Scoring: Players accumulate points based on their choices and the corresponding outcomes as defined by the payoff matrix.
- Payoff Matrix: Each game has a 2x2 matrix representing the outcomes of different combinations of choices (Cooperate or Compete) made by the player and the computer.

#### Prisoner's Dilemma Payoff Matrix
- Both Cooperate: Minor penalty for both.
- Player Cooperates/Computer Competes: Player receives a heavy penalty, the computer gets minimal or no penalty.
- Player Competes/Computer Cooperates: Player gets minimal or no penalty, the computer receives a heavy penalty.
- Both Compete: Moderate penalty for both.

#### Stag Hunt Payoff Matrix
- Both Cooperate (Hunt Stag): High reward for both.
- Player Cooperates/Computer Competes (Hunts Rabbit): Player gets no reward, the computer gets a small reward.
- Player Competes/Computer Cooperates: Player gets a small reward, the computer gets no reward.
- Both Compete (Hunt Rabbit): Small reward for both.

### Player Strategies
Players choose between two options each round:
- Cooperate: Working together with the opponent, aiming for a mutually beneficial outcome.
- Compete: Acting in self-interest, potentially at the expense of the opponent.

### Opponent Strategies
The computer opponent can adopt one of the following strategies:
- Random: Chooses between Cooperate and Compete randomly.
- Always Cooperate: Always chooses to Cooperate.
- Always Compete: Always chooses to Compete.
- Tit-for-Tat (specific to Prisoner's Dilemma): Mimics the player's previous choice. It starts with a random choice in the first round and then follows the player's last choice in subsequent rounds.

### Game Play
1. Select Game: Choose between Prisoner's Dilemma and Stag Hunt.
2. Choose Strategy: Select a strategy for the computer opponent.
3. Play Rounds: Enter the number of rounds to play. In each round, choose to Cooperate or Compete. After each round, the results are displayed based on the payoff matrix.
4. Scoring: Scores are tallied after each round. In the Prisoner's Dilemma, the goal is to minimize penalties (lower scores are better). In the Stag Hunt, the goal is to maximize rewards (higher scores are better).
5. End Game: The game ends after the set number of rounds, and the winner is declared based on the cumulative score.
