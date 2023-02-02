#include <cs50.h>
#include <stdio.h>
#include <string.h>

// Max number of candidates
#define MAX 9

// Candidates have name and vote count
typedef struct
{
    string name;
    int votes;
}
candidate; //This is now a data type, like int or string

// Array of candidates
candidate candidates[MAX];

// Number of candidates
int candidate_count;

// Function prototypes
bool vote(string name);
void print_winner(void);

int main(int argc, string argv[])
{
    // Check for invalid usage
    if (argc < 2)
    {
        printf("Usage: plurality [candidate ...]\n");
        return 1;
    }

    // Populate array of candidates
    candidate_count = argc - 1;
    if (candidate_count > MAX)
    {
        printf("Maximum number of candidates is %i\n", MAX);
        return 2;
    }
    for (int i = 0; i < candidate_count; i++)
    {
        candidates[i].name = argv[i + 1];
        candidates[i].votes = 0;
    }

    int voter_count = get_int("Number of voters: ");

    // Loop over all voters
    for (int i = 0; i < voter_count; i++)
    {
        string name = get_string("Vote: ");

        // Check for invalid vote
        if (!vote(name))
        {
            printf("Invalid vote.\n");
        }
    }

    // Display winner of election
    print_winner();
}

// Update vote totals given a new vote
bool vote(string name)
{
    // TODO
    for (int j = 0; j < candidate_count; j++)
    {
        if (strcmp(candidates[j].name, name) == 0)
        {
            candidates[j].votes++;
            return true; //Needed to have a return of true (or false) because this is a bool expersion. Otherwise all return values were false.
        }
    }
    return false;
}

// Print the winner (or winners) of the election
void print_winner(void)
{
    // TODO
    int maxvotes = 0; // Two step problem - First need to create a new variable that keeps track of the max votes a candidate got.

    for (int i = 0; i < candidate_count; i++)
    {
        if (maxvotes < candidates[i].votes)
        {
            maxvotes = candidates[i].votes;
        }
    }
    for (int p = 0; p < candidate_count; p++) // Then I need to print out all candidates that have that number of votes.
    {
        if (maxvotes == candidates[p].votes)
        {
            printf("%s\n", candidates[p].name);
        }
    }
    return;
}
