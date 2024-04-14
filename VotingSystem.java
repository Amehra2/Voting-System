/*
 * Name: Akash Mehra
 * Group work with Alex Kinnunen
 * My Student ID: 21435333
 * Name: Alex Kinnunen
 * Alex Kinnunen Student ID: 21442634
 * Instructor: DR Ikram Ur Rehman
 * Date: 11-12-2020
 * Course name: Computer Science
 * Module: Programming
 */

/* For this task, we were required to make an election simulator.
   The user inputs names for who they want to vote for, and they can vote for same person multiple times.
   To stop voting, the user must input a 0 to end the program.
   The program displays how many votes each person received and who won the election.
   In a scenario of a draw, the program will output the number of people there has been a draw between.

 */
package practical.task.pkg4;
import java.util.Scanner;
import java.util.ArrayList;

public class PracticalTask4 {

 
  public static void main(String[] args) {
  Scanner input = new Scanner (System.in);
  ArrayList<String> names= new ArrayList<>(); // Contains names of candidates.
  ArrayList<Integer> count= new ArrayList<>(); // Contains votes for candidates.
  boolean voting = true;
  
  System.out.println("Enter the name of the candidate you wish to vote for."
          + "\nEnter 0 to stop voting.");
        
        while(voting) {
            String candidateName = input.nextLine();
            if("0".equals(candidateName)){ // If user inputs 0.
                voting=false; // Ends the while loop.
                
            }
            else if(names.contains(candidateName)){ //If candidateName is in ArrayList names
                int position= names.indexOf(candidateName); // Finds index of candidateName.
                int voteCount = count.get(position); // Finds the number of votes for the selected candidate
                count.set(position, voteCount +1); // Increase the vote count by 1 for the selected candidate.
            }
            else if(!names.contains(candidateName)){ // If candidateName is not in ArrayList names.
                names.add(candidateName); // Adds candidateName to ArrayList names.
                count.add(1); // Adds a vote for the selected candidate.
                
            }
            
           }
           //Loop to find the largest number in ArrayList count.
        int highestVoteCount = count.get(0); // Sets highestVoteCount equal to the first number in count.
        for(int i= 0; i < count.size(); i++){ // Loops for each integer in count.
            if (count.get(i)> highestVoteCount) { // If next integer is larger than highestVoteCount.
                highestVoteCount = count.get(i); // Sets highestVoteCount equal to the next integer.
            } 
            
        }
        //* Displays the total votes for each candidate. 
        // Finds how many candidates have the highestVoteCount.
        int numberOfWinners = 0;
        System.out.println(" ");
        for(int i = 0; i<names.size(); i++) { // For each string in ArrayList names.
            String candidate = names.get(i); // Sets candidate equal to the string with index of 1 from names.
            int totalVotes = count.get(i); // Sets totalVotes to the int with an index of 1 from count.
            System.out.println(candidate +" received " + totalVotes + " votes ");
            
        if(totalVotes == highestVoteCount) { // If candidate has the highestVoteCount.
            numberOfWinners +=1; // Increases the number of winners by one.
        }
         
        
    }
        if(numberOfWinners > 1) { // If there is a draw.
            System.out.println("It's a draw between " + numberOfWinners +" Candidates" );
        }
        else{ // If there is only one winner 
        int positionOfWinner = count.indexOf(highestVoteCount); //  Finds the index of candidate with the most votes.
        String winner = names.get(positionOfWinner); // Finds the name of the candidate with the most votes.
        System.out.println("The winner is " + winner + " with " + highestVoteCount + " votes ");
        }
    }
    
}
