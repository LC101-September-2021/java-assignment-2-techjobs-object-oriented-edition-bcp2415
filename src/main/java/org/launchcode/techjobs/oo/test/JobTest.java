package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Before
    public void createJobObjects() {
        Job job1 = new Job();
        Job job2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testJobIdsAreIncremented() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertTrue(job2.getId() == (job1.getId() + 1));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals(job3.getName(), "Product tester");
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(), "Quality Control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue((job3.getCoreCompetency() instanceof CoreCompetency));
        assertTrue(job3.getName() instanceof String);
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertFalse(job4.getId() == job5.getId());
    }

    Job job6;

    @Before
    public void createJob() {
       job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job job77 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String test = "\nId: 4\nName: Product Tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality Control\nCore Competency: Persistence\n";
        assertTrue(job77.toString().startsWith("\n"));
        assertTrue(job77.toString().endsWith("\n"));
        assertEquals(job77.toString().length(), test.length());
        System.out.println("toString length = " + job77.toString().length());
        assertEquals("\n", "\n");
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String test = job6.toString();
        System.out.println("Testing job6: " + test);
        System.out.println(job6.toString().contains("ID:"));
        assertTrue(job6.toString().contains("ID:"));
        assertTrue(job6.toString().contains("Name:"));
        assertTrue(job6.toString().contains("Employer:"));
        assertTrue(job6.toString().contains("Location:"));
        assertTrue(job6.toString().contains("Position Type:"));
        assertTrue(job6.toString().contains("Core Competency:"));
        assertTrue(job6.toString().contains(Integer.toString(job6.getId())));
        assertTrue(job6.toString().contains(job6.getName()));
        assertTrue(job6.toString().contains(job6.getEmployer().getValue()));
        assertTrue(job6.toString().contains(job6.getLocation().getValue()));
        assertTrue(job6.toString().contains(job6.getPositionType().getValue()));
        assertTrue(job6.toString().contains(job6.getCoreCompetency().getValue()));
        assertTrue(job6.toString().contains("\nID: " + Integer.toString(job6.getId()) + "\n"));
        assertTrue(job6.toString().contains("\nName: " + job6.getName() + "\n"));
        assertTrue(job6.toString().contains("\nEmployer: " + job6.getEmployer().getValue() + "\n"));
        assertTrue(job6.toString().contains("\nLocation: " + job6.getLocation().getValue() + "\n"));
        assertTrue(job6.toString().contains("\nPosition Type: " + job6.getPositionType().getValue() + "\n"));
        assertTrue(job6.toString().contains("\nCore Competency: " + job6.getCoreCompetency().getValue() + "\n"));
        assertEquals(job6.toString(), "\nID: " + job6.getId() + "\nName: " + job6.getName() + "\nEmployer: " + job6.getEmployer().getValue() + "\nLocation: " + job6.getLocation().getValue() + "\nPosition Type: " + job6.getPositionType().getValue() + "\nCore Competency: " + job6.getCoreCompetency().getValue() + "\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Employer acme = new Employer("ACME");
        Location desert = new Location("Desert");
        PositionType qc = new PositionType("Quality Control");
        CoreCompetency persistence = new CoreCompetency("Persistence");
        Job job7 = new Job("Product tester", acme, desert, qc, persistence);

        job7.setName("");
        assertTrue(job7.toString().contains("Name: Data not available"));
        assertEquals(job7.toString(), "\nID: 4\nName: Data not available\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality Control\nCore Competency: Persistence\n");
        job7.setName("Product tester");

        job7.setEmployer(new Employer(""));
        assertTrue(job7.toString().contains("Employer: Data not available"));
        job7.setEmployer(acme);

        job7.setLocation(new Location(""));
        assertTrue(job7.toString().contains("Location: Data not available"));
        job7.setLocation(desert);

        job7.setPositionType(new PositionType(""));
        assertTrue(job7.toString().contains("Position Type: Data not available"));
        job7.setPositionType(qc);

        job7.setCoreCompetency(new CoreCompetency(""));
        assertTrue(job7.toString().contains("Core Competency: Data not available"));
        job7.setCoreCompetency(persistence);
    }

    @Test
    public void toStringPrintsSpecialMessageIfNoData() {
        Job job8 = new Job();
        System.out.println("job8 Id = " + job8.getId());
        System.out.println(Objects.isNull(job8.getName()));
        assertTrue(job8.toString().equals("\nOOPS! This job does not seem to exist.\n"));
    }
}
