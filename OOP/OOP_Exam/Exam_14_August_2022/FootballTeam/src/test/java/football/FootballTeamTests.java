package football;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FootballTeamTests {

    private FootballTeam footballTeam;
    private Footballer footballer;

    @Before
    public void setUp() {
        footballTeam = new FootballTeam("Barcelona", 3);
        footballer = new Footballer("Lionel Messi");
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ThrowExceptionIf_AsNameArgument_Null() {
        FootballTeam ft = new FootballTeam(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ThrowExceptionIf_AsNameArgument_WhiteSpaces() {
        FootballTeam ft = new FootballTeam("                ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ThrowExceptionIf_AsVacantPositionsArgument_IsLessThan0() {
        FootballTeam ft = new FootballTeam("Manchester", -1);
    }

    @Test
    public void test_Constructor_ValidCase() {
        String expectedName = "Manchester";
        int expectedVacantPositions = 1;
        FootballTeam ft = new FootballTeam(expectedName, expectedVacantPositions);

        assertEquals(expectedName, ft.getName());
        assertEquals(expectedVacantPositions, ft.getVacantPositions());

    }

    @Test
    public void test_GetCount_ShouldReturnSize() {
        int actualCount = footballTeam.getCount();
        assertEquals(0, actualCount);

        footballTeam.addFootballer(footballer);
        int actualCountTwo = footballTeam.getCount();
        assertEquals(1, actualCountTwo);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddFootballer_ShouldReturnException_When_No_VacantPositions_Available() {
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(new Footballer("Ronaldo"));
        footballTeam.addFootballer(new Footballer("Zlatan Ibrahimovic"));
        footballTeam.addFootballer(new Footballer("Kylian Mbappe"));
    }

    @Test
    public void test_AddFootballer_ValidCase_FootballerAddedSuccessfully() {
        footballTeam.addFootballer(footballer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveFootballer_ReturnException_When_NoSuchFootballerIn_Team() {
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("Kylian Mbappe");
    }

    @Test
    public void test_RemoveFootballer_ValidCase_ReturnVoid_When_RemovedFootballer() {
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("Lionel Messi");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FootballerForSale_ShouldReturn_Exception_NoSuchFootballerFound() {
        footballTeam.footballerForSale("Kylian Mbappe");
    }

    @Test
    public void test_FootballerForSale_ShouldReturn_FootballerWith_Active_SetToFalse() {
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale(footballer.getName());
        assertFalse(footballer.isActive());
    }

    @Test
    public void test_GetStatistics_ShouldReturn_RightString_WhenTwoFootballers_InTeam(){
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(new Footballer("Zlatan Ibrahimovic"));

        String expectedResult = "The footballer Lionel Messi, Zlatan Ibrahimovic is in the team Barcelona.";
        assertEquals(expectedResult,footballTeam.getStatistics());
    }

    @Test
    public void test_GetStatistics_ShouldReturn_RightString_WhenZeroFootballers_InTeam(){
        String expectedResult = "The footballer  is in the team Barcelona.";
        assertEquals(expectedResult,footballTeam.getStatistics());
    }


}
