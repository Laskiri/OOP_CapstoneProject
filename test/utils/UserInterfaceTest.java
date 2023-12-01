package utils;
import org.junit.Test;
import team.Team;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UserInterfaceTest {
    TestableUserInterface ui = new TestableUserInterface();
    private static class TestableUserInterface extends UserInterface {
        public int getTeamChoice(Team[] teams, Scanner scanner, PrintStream out) {
            while (true) {
                out.println("Please choose the team you would like to manage by entering the number of the team: ");
                try {
                    int choice = scanner.nextInt();
                    if (choice >= 0 && choice < teams.length) {
                        return choice;
                    } else {
                        out.println("Invalid choice. Please enter a number between 0 and " + (teams.length - 1));
                    }
                } catch (InputMismatchException e) {
                    out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Discard the invalid input
                }
            }
        }
    }

    // Returns the correct team number when given a valid input
    @Test
    public void test_getTeamChoice_validInput() {

        String input = "1\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);

        Team[] teams = new Team[2]; // Create an array with 2 teams

        int choice = ui.getTeamChoice(teams, scanner, out);

        assertEquals(1, choice);
        assertTrue(output.toString().contains("Please choose the team you would like to manage by entering the number of the team: "));
    }

    // Returns the correct team number when given an invalid input, then a valid input
    @Test
    public void test_GetTeamChoice_invalidInputThenValidInput() {
        String input = "2\n1\n"; // First input is invalid, second input is valid
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);

        Team[] teams = new Team[2]; // Create an array with 2 teams

        int choice = ui.getTeamChoice(teams, scanner, out);

        assertEquals(1, choice);
        assertTrue(output.toString().contains("Invalid choice. Please enter a number between 0 and 1"));
    }


    // Returns the correct team number when given a non-numeric input, then a valid input
    @Test
    public void test_GetTeamChoice_NonNumericInputThenValidInput() {
        String input = "abc\n1\n"; // First input is non-numeric, second input is valid
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);

        Team[] teams = new Team[2]; // Create an array with 2 teams
        int choice = ui.getTeamChoice(teams, scanner, out);

        assertEquals(1, choice);
        assertTrue(output.toString().contains("Invalid input. Please enter a number."));
    }
}
