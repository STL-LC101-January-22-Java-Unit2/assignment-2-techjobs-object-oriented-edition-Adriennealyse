package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

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

    assertTrue(test_job.getId() != test_job2.getId() && test_job.getId()+1 == test_job2.getId() );
    }


    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(Integer.class.isInstance(test_job3.getId()));

        assertEquals(3, test_job3.getId());

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

        //assertEquals(1,test_job1.getId());
    }

}
