package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isWhitespace;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {


    @Test
    public void testSettingJobId() {
    Job test_job = new Job();
    Job test_job2 = new Job();

    assertTrue(test_job.getId()+1 == test_job2.getId() );
    }


    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(Integer.class.isInstance(test_job3.getId()));

        assertTrue(test_job3.getId() >= 1);

        assertTrue(test_job3.getName() instanceof String);

        assertEquals("Product tester", test_job3.getName());

        assertTrue(test_job3.getEmployer() instanceof Employer);

        assertEquals("ACME", test_job3.getEmployer().toString());

        assertTrue(test_job3.getLocation() instanceof Location);

        assertEquals("Desert", test_job3.getLocation().toString());

        assertTrue(test_job3.getPositionType() instanceof PositionType);

        assertEquals("Quality control", test_job3.getPositionType().toString());

        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Persistence", test_job3.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        Job test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(test_job4.getId() == test_job5.getId());

        //assertEquals(2,test_job5.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test_job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = test_job6.toString();
        boolean firstChar = (jobString.startsWith("\n") == true);
        boolean lastChar = (jobString.endsWith("\n") == true);
        assertEquals(firstChar,lastChar);
        // assertEquals(lastChar,true);

        assertTrue(jobString.startsWith("\n") && jobString.endsWith("\n"));
        //assertEquals(isWhitespace(jobString.charAt(0)), jobString.charAt(0));
        //assertEquals(jobString.startsWith("\n"), jobString.charAt(0));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job j7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        /*String testString = "ID:" + test_job7.getId() + "\n" +
                            "Name:" + "Application" + "\n" +
                            "Employee:" + "GM";*/

        String patternString = "\nID: " + j7.getId() +
                               "\nName: " + j7.getName() +
                               "\nEmployer: " + j7.getEmployer() +
                               "\nLocation: " + j7.getLocation() +
                               "\nPosition Type: " + j7.getPositionType() +
                               "\nCore Competency: " + j7.getCoreCompetency() + "\n";
        //System.out.println("J7 : " + j7.toString());
        //System.out.println("PT : " + patternString);
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(j7.toString());
        boolean matches = matcher.matches();
        //System.out.println("Matcher Result : "+ matches);
        assertEquals(matches,true);

        //String[] labels = {"ID", "Name", "Employer", "Location", "Position Type", "Core Competency"};
        //String[] jobArray = test_job7.toString().split("\n");
        //for (int x = 0; x <= jobArray.length; x++) {
           // System.out.println(labels[x] + " :: " + jobArray[x]);

        //}
        //assertTrue(test_job7.toString().contains("ID" + test_job7.getId()  ));
        //assertTrue(test_job7.toString().contains());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job test_job8 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));


    }


}
