# flashcards
A Java command-line flashcard quiz that tracks the terms I miss and lets me re-quiz only those.

## The Problem
When I study sociology from my notes, I feel like I know the terms, but then I blank when I
have to recall them on an exam. I waste time rereading what I already know instead of
practicing what I don't.

## Project goal
A Java program that quizzes me on vocab terms from a file and tracks the ones I miss, so I can re-quiz only those.

## How It Works
The program reads `term | definition` lines from `terms.txt` into an ArrayList. It shows me each
term, I type my answer, it shows the real definition, and I tell it whether I got it right.
Terms I miss go into a second ArrayList and get a second round, then the score is shown.

![Flowchart](docs/tools%20final%20project.drawio%20%281%29.png)

## MVP scope
- Load terms and definitions from `terms.txt`
- Quiz me one term at a time
- Track the terms I get wrong
- Re-quiz only the missed terms
- Show my score at the end

## Future plans
- Save missed terms between sessions
- Shuffle the questions
- Support decks for other classes

## Tech stack
- Java (standard library only like Scanner, File, ArrayList)
- Plain text file for the terms
- No external tools, API, or database
- Run in the Windows PowerShell terminal

## Setup
1. Install the JDK (version 17 or newer) and Git.
2. Open PowerShell and clone the repo: `git clone https://github.com/HarshiniT123/flashcards`
3. Go into the folder: `cd flashcards`
4. Compile: `javac src/Main.java`
5. Run: `java -cp src Main`

To use your own terms, edit `terms.txt`. Put one card per line in this format, with only one `|` per line:
`term | definition`

### Example run
Example `terms.txt`:
```
Sociology | The scientific study of human society, social behavior, and social relationships
Sociological imagination | The ability to see how personal experiences are connected to larger social forces and history
Culture | The shared beliefs, values, norms, language, and material objects of a group of people
```

Example terminal output (shortened; a full run goes through every card in `terms.txt`):
```
PS C:\Users\hersh\Documents\flashcards> java -cp src Main

Term: Sociology
Your answer: the study of people
Definition: The scientific study of human society, social behavior, and social relationships
Did you get it right? (y/n): y

Term: Sociological imagination
Your answer: imagination
Definition: The ability to see how personal experiences are connected to larger social forces and history
Did you get it right? (y/n): n

...
Score: 15/20
Re-quizzing 5 missed terms...

Term: Sociological imagination
Your answer: seeing personal issues as social issues
Definition: The ability to see how personal experiences are connected to larger social forces and history
Did you get it right? (y/n): y

...
Score: 5/5
```

## Roadmap
- [x ] Set up repo and sample terms
- [x ] Read the file and split terms from definitions
- [x ] Ask questions and keep a score
- [x ] Track missed terms and re-quiz them
- [x ] Polish, Javadoc header, and README

## Demo
