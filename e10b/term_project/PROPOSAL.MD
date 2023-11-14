[comment]: <> (@David, apologies that this is incomplete. I wanted to submit at least part of a proposal so you could get an idea of what I'd like to work on/provide any feedback. I will submit a completed posposal as soon as I can.)

# Term Project Proposal

## I. Overview

Class:      Computer Science E-10b: Introduction to Computer Science Using Java, II

Term:       Fall, 2023

Instructor: Dr. H. H. Leitner

Student:    Aaron Del Giudice

Date:       2023-11-13

## II. Introduction

### Project Title


### Objectives

- Educational Objectives:

    - Develop an intuitive application that demystifies game theory concepts through interactive experiences. Initially, game theory appeared daunting, but approachable elements, such as the Prisoner's Dilemma, present a simple yet profound problem. By simulating this dilemma, the application will enable newcomers to game theory to grasp foundational concepts and explore underlying strategies like tit-for-tat.

    - Analyze the effectiveness of various strategies across different game scenarios and player archetypes to understand strategic decision-making in game theory.

- Technical Objectives:

    - Create an interactive Java agent capable of responding to user inputs and executing diverse strategies, including tit-for-tat, random, and absolute (always cooperate/defect) approaches.

    - As a stretch goal, integrate a basic AI learning component that adapts to user interactions over time, enhancing the agent's responses based on historical gameplay.

    - Construct a user-friendly GUI that facilitates straightforward interactions, ensuring the application is accessible to users with varying levels of game theory knowledge.

    - Design the application's architecture to be modular, promoting scalability and the future incorporation of additional game theory scenarios or more sophisticated AI algorithms.

    - Deliver real-time feedback and comprehensive results analysis to aid users in understanding the implications of their strategic choices.

#### Notes on AI Implementation:

Implementing complex AI is likely beyond the scope of this project. Any integration of advanced AI would need to utilize existing Java libraries for reinforcement learning to remain feasible within the project’s constraints.

### Justification

- Game theory is a multifaceted discipline with broad applications across economics, political theory, psychology, business, finance, and computer science. Developing an accessible application to demonstrate game theory concepts could significantly enhance comprehension for those new to the subject.

- The interactive nature of the game theory agent will enable users to witness the immediate consequences of their decisions, effectively connecting tangible outcomes to abstract theories and strategies.

- This project presents an opportunity to delve into the realm of AI in Java, diverging from my professional background of developing AI applications in Python. It offers a chance to expand my technical expertise and adapt my AI development skills to a new programming environment.

## III. Inputs and Outputs

### Inputs

- User decisions:

    - At the core of game theory will be the decisions that users make each turn. These choices serve as the primary input for the game mechanics and demonstrate the consequences that follow from various strategic decisions.

    Examples:

    - In the Prisoner’s Dilemma, users will be presented with two options: “Cooperate” or “Defect.” The chosen action will directly influence the game’s outcome and the subsequent payoffs.

    - In the Stag Hunt, participants can decide whether to “Hunt Stag” or “Hunt Hare,” with each option affecting the potential rewards for collaborative or competitive strategies.

- Game settings:

    - While a single round can provide immediate feedback, extending the game over multiple rounds allows for observation of the effects of long-term strategy and pattern formation.

    - Users can configure the simulation to run for a set number of rounds, such as 10 or 20, to analyze the evolution of strategies over time.

    - Advanced options might include the ability to adjust the payoff matrix, offering users the chance to explore how different incentive structures influence strategic choices.

- Strategy selection:

    - Selecting the AI agent’s strategy enables users to engage with different types of opponents, ranging from predictable to complex and adaptive.

    Examples:

    - At the beginning of the game, users can choose an AI strategy, such as “Random” or “Tit-for-Tat,” for the Prisoner’s Dilemma, which will dictate the agent's behavior.

    - Users may also set the AI difficulty level, with options like easy (static strategy), medium (varied strategy), or hard (adaptive strategy), to match or challenge their own decision-making skills.

### Outputs

- Round results:

    - After each decision round in the game, the application will provide immediate feedback. The feedback will teach the user about the benefits or consequences of their actions within the game theory framework.

    Examples:

    - If a user chooses to "Defect" in the Prisoner's Dilemma and the agent "Cooperates," the output would show that the user has benefited at the AI's expense. This might be displayed as "You win 3 years of freedom, the agent gets 5 years in prison."

    - In the Stag Hunt, if both the player and the agent choose "Hunt Stag" and succeed, the output might read "Both players successfully hunt the stag and share the rewards," along with a visual representation of the payoff, such as an increased score or graphical payoff matrix update.

- Game summary:

    - At the end of a game or a series of rounds, users should be provided with a summary that encapsulates their overall performance.

    Examples:

    - A summary table could present the cumulative payoffs for the user and the AI across all rounds, highlighting the most and least successful rounds.

- All agent decisions and strategy:

    - Understanding the Agent’s decisions will help the user to learn about the different available strategies and their potential outcomes.

    Examples:

    - After each round, a brief explanation of the agent’s decision could be displayed, such as "AI chose to defect based on the tit-for-tat strategy, as you defected in the previous round.”

## IV. Core Functionality

### Algorithms and Data Structures
- Strategy Algorithms:

    - Simple Algorithms:

        - “Tit-for-Tat”: the agent will mimic the user’s previous move.

        - “Random”: the agent will randomly choose between all available options.

        - “Allways Cooperate” or “Always Compete”: the agent will choose the same option regardless of user input.

    - Complex Algorithms:

        - Heuristic Algorithm: the agent behavior will change depending on certain heuristics, such as the agent score crossing a given threshold.

        Example:

        - The agent will cooperate by default unless its score drops below a certain threshold, at which point it will switch to competing until its score recovers above that threshold.

- Data Structures:

    - Game State Representation:

        - Utilize a two-dimensional array (matrix) to represent the payoff matrix for each scenario within the games.

        - Potentially use tree data structures to map the decision process of the agent.

    - Data Storage:

        - Maintain a record of the user’s past decisions using arrays.

        - In the case of implementing a tit-for-tat strategy, employ a queue to keep a history of user actions for the agent to respond accordingly.

        Example:

        - If the user’s sequence of moves is [“cooperate,” “cooperate,” “compete,”] then the agent's subsequent responses would be [“cooperate,” “cooperate,” “compete,”] mirroring the user’s choices.

### Template Classes and Methods
