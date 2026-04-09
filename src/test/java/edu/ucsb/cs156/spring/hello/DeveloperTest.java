package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Brian L.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("Brian-W-Li", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s26-03", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Brian L."),"Team should contain Brian L.");
        assertTrue(t.getMembers().contains("Alexandru"),"Team should contain Alexandru");
        assertTrue(t.getMembers().contains("Kalyan"),"Team should contain Kalyan");
        assertTrue(t.getMembers().contains("Raymond X."),"Team should contain Raymond X.");
        assertTrue(t.getMembers().contains("Wyatt"),"Team should contain Wyatt");
        assertTrue(t.getMembers().contains("Alex L."),"Team should contain Alex L.");       
        // ... etc
    }

    /**@Test
    public void getTeam_returns_correct_team_and_members() {
        Team expected = new Team("s26-03");
        expected.addMember("Brian L.");
        expected.addMember("Alexandru");
        expected.addMember("Kalyan");
        expected.addMember("Raymond X.");
        expected.addMember("Wyatt");
        expected.addMember("Alex L.");
        assertEquals(expected, Developer.getTeam());
    }**/

}
