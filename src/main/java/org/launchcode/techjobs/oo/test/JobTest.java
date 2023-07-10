package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
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
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");
        assertEquals(job3.getName(), "Product tester");

        assertTrue(job3 instanceof Job);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job3.getPositionType() instanceof PositionType);
    }

    @Test
    public void testJobsForEquality(){

        Job job4 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        System.out.println(job4);
        System.out.println(job5);
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job6 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String test = job6.toString();
        Assert.assertEquals(test.charAt(0) , '\n');
        int end = test.length();
        Assert.assertEquals(test.charAt(end - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job7 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String expected = "\nID: 1\nName: Product tester\nEmployer: ACME\n" +
                "Location: Desert\nPosition Type: Quality control\n" +
                "Core Competency: Persistence\n";
        String actual = job7.toString();
        assertEquals(expected , actual);
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job job8 = new Job("Product tester", new Employer(""),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String expected = "\nID: 1\nName: Product tester\nEmployer: Data not available\n" +
                "Location: Desert\nPosition Type: Quality control\n" +
                "Core Competency: Persistence\n";
        String actual = job8.toString();
        System.out.println(expected + actual);
        assertEquals(expected , actual);
    }
}
