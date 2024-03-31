## Spell Checker using Levenshtein Distance

### Introduction
I was intrigued by the concept of spell checkers on editing platforms, which led me to explore the implementation of a spell checker. To achieve this, I downloaded a `words.txt` file from **dwyl** containing a comprehensive dictionary of words. The core idea was to utilize the Levenshtein distance algorithm to suggest corrections for misspelled words.

### Steps Taken
1. **Data Source**: I obtained a dictionary file (`words.txt`) from **dwyl** to serve as the reference for valid words.
2. **Algorithm Choice**: I decided to use the  Levenshtein distance algorithm to calculate the similarity between the input word and the words in the dictionary.
3. **Reading Relevant Papers**: In the process, I actually  had to read some papers including "On the Recognition of Information With a Digital Computer" by Herbert Glantz (1957) and "A Program for Correcting Spelling Errors" by Charles Blair (1960), to gain insights into spell-checking technique.

### Implementation Overview
- The program reads the dictionary file and takes user input for a potentially misspelled word.
- It checks for exact matches and calculates the Levenshtein distance between the input word and each word in the dictionary.
- A threshold is set to filter suggestions based on the calculated Levenshtein distance.
- Suggestions are presented to the user, sorted by increasing order of Levenshtein distance.

### Code Structure
- **Main Class**: The program is encapsulated in the `Main` class.
- **Levenshtein Distance Calculation**: The core spell-checking logic is implemented in the `calculateLevenshteinDistance` method.
- **Suggestions Handling**: Suggestions are stored in a `Map` based on Levenshtein distance and printed accordingly.

### Usage
1. Run the program.
2. Enter a potentially misspelled word when prompted.
3. Get suggestions based on Levenshtein distance.

Feel free to explore  the code for your specific use case. If you have any questions or suggestions for improvement, please let me know.

---

**References:**
- Herbert Glantz. "On the Recognition of Information With a Digital Computer" (1957).
- Charles Blair. "A Program for Correcting Spelling Errors" (1960).
- GitHub : **dwyl** - for the dictionary of words
