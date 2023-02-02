#include <cs50.h>
#include <stdio.h>
#include <string.h>

// Max voters and candidates
#define MAX_VOTERS 100
#define MAX_CANDIDATES 9

// preferences[i][j] is jth preference for voter i
int preferences[MAX_VOTERS][MAX_CANDIDATES];

// Candidates have name, vote count, eliminated status
typedef struct
{
    string name;
    int votes;
    bool eliminated;
}
candidate;

// Array of candidates
candidate candidates[MAX_CANDIDATES];

// Numbers of voters and candidates
int voter_count;
int candidate_count;

// Function prototypes
bool vote(int voter, int rank, string name);
void tabulate(void);
bool print_winner(void);
int find_min(void);
bool is_tie(int min);
void eliminate(int min);

int main(int argc, string argv[])
{
    // Check for invalid usage
    if (argc < 2)
    {
        printf("Usage: runoff [candidate ...]\n");
        return 1;
    }

    // Populate array of candidates
    candidate_count = argc - 1;
    if (candidate_count > MAX_CANDIDATES)
    {
        printf("Maximum number of candidates is %i\n", MAX_CANDIDATES);
        return 2;
    }
    for (int i = 0; i < candidate_count; i++)
    {
        candidates[i].name = argv[i + 1];
        candidates[i].votes = 0;
        candidates[i].eliminated = false;
    }

    voter_count = get_int("Number of voters: ");
    if (voter_count > MAX_VOTERS)
    {
        printf("Maximum number of voters is %i\n", MAX_VOTERS);
        return 3;
    }

    // Keep querying for votes
    for (int i = 0; i < voter_count; i++)
    {

        // Query for each rank
        for (int j = 0; j < candidate_count; j++)
        {
            string name = get_string("Rank %i: ", j + 1);

            // Record vote, unless it's invalid
            if (!vote(i, j, name))
            {
                printf("Invalid vote.\n");
                return 4;
            }
        }

        printf("\n");
    }

    // Keep holding runoffs until winner exists
    while (true)
    {
        // Calculate votes given remaining candidates
        tabulate();

        // Check if election has been won
        bool won = print_winner();
        if (won)
        {
            break;
        }

        // Eliminate last-place candidates
        int min = find_min();
        bool tie = is_tie(min);

        // If tie, everyone wins
        if (tie)
        {
            for (int i = 0; i < candidate_count; i++)
            {
                if (!candidates[i].eliminated)
                {
                    printf("%s\n", candidates[i].name);
                }
            }
            break;
        }

        // Eliminate anyone with minimum number of votes
        eliminate(min);

        // Reset vote counts back to zero
        for (int i = 0; i < candidate_count; i++)
        {
            candidates[i].votes = 0;
        }
    }
    return 0;
}

//preference[voters][rank]


// Record preference if vote is valid
bool vote(int voter, int rank, string name)
{
    // Count all voters preference for each candidate.
    for (int i = 0; i < candidate_count; i++)
        if (strcmp(candidates[i].name, name) == 0)
        {
            preferences[voter][rank] = i;  //USED VARIABLES FROM FUNCTION IN THE DOUBLE ARRAY!
            return true;
        }
    return false;
}

// Tabulate votes for non-eliminated candidates
void tabulate(void)

{
    for (int i = 0; i < voter_count; i++) // Loop through every voter we have participating. This means we need a loop that goes through the rows and columns. Every candidate (row) for every voter (column)
    {
        for (int j = 0; j < candidate_count; j++)
        {
            if (candidates[preferences[i][j]].eliminated == false) //Using candidates matrix, looking at preferences[i][j] (number of the candidate and preferred person) check if they are not eliminated
            {
                candidates[preferences[i][j]].votes++; //If we pass, update the candidates table to increase their vote.
                break; //break so we dont go through nonpreferred candidates.
            }
         }
    }
    return;
}

// Print the winner of the election, if there is one
bool print_winner(void)
{
    int winning_votes = ((voter_count / 2) +1); //declaring a variable INT for rounding
    for (int i = 0; i < candidate_count; i++) //looping through candidate_count because we want to go through the candidate array.
    {
        if (candidates[i].votes >= winning_votes) //Want to look only at the candidates array with the total number of votes (not the individual votes in preferences) greater OR EQUAL TO the majority.
        {
            printf("%s\n", candidates[i].name);
            return true;
        }
    }
    return false;
}

// Return the minimum number of votes any remaining candidate has
int find_min(void)
{
    // TODO
    int min = INT_MAX;
    for (int i = 0; i < candidate_count; i++)
    {
        if (candidates[i].eliminated == false && min > candidates[i].votes) //if candidate is not eliminated and the candidate has less votes than the variable min,
        {
            min = candidates[i].votes; //update min to the number of votes the candidate has.
        }
    }
    return min; //PROBLEM - RETURN MIN NOT 0, OTHERWISE MIN IS LOST AND NOTHING CHANGES WITH 0
}

// Return true if the election is tied between all candidates, false otherwise
bool is_tie(int min)
{
    // TODO
    int remaining_candidates = 0;
    int candidates_at_min = 0;

    for (int i = 0; i < candidate_count; i++)
    {
        if (candidates[i].eliminated == false)
        {
            remaining_candidates++;
            if (candidates[i].votes == min)
            {
                candidates_at_min++;
            }
        }
    }
    if (remaining_candidates == candidates_at_min)
    {
        return true;
    }
    return false;
}

// Eliminate the candidate (or candidates) in last place
void eliminate(int min)
{
    // Idea: Loop through the candidates and set all candidates with that number of votes to true.
    for (int i = 0; i < candidate_count; i++)
    {
        if (candidates[i].votes == min && candidates[i].eliminated == false) // Can use min because its an argument we are receiving in the function header
        {
            candidates[i].eliminated = true;
        }
    }
    return;
}