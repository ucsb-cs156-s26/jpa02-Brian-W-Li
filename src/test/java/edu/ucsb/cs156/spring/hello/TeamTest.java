package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assertEquals("test-team", team.getName());
    }

    @Test
    public void default_constructor_sets_empty_name_and_members() {
        Team defaultTeam = new Team();
        assertEquals("", defaultTeam.getName());
        assertEquals(new ArrayList<String>(), defaultTeam.getMembers());
    }

    @Test
    public void addMember_adds_member_to_members_list() {
        team.addMember("Alice");
        assertEquals(List.of("Alice"), team.getMembers());
    }

    @Test
    public void setName_and_setMembers_update_fields() {
        team.setName("new-team");
        assertEquals("new-team", team.getName());

        ArrayList<String> members = new ArrayList<>(List.of("A", "B"));
        team.setMembers(members);
        assertEquals(members, team.getMembers());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_non_team_object() {
        assertFalse(team.equals("not-a-team"));
    }

    @Test
    public void equals_returns_true_for_equivalent_teams() {
        Team t1 = new Team("same");
        t1.addMember("A");
        t1.addMember("B");

        Team t2 = new Team("same");
        t2.addMember("A");
        t2.addMember("B");

        assertTrue(t1.equals(t2));
    }

    @Test
    public void equals_returns_false_when_names_differ() {
        Team t1 = new Team("one");
        t1.addMember("A");

        Team t2 = new Team("two");
        t2.addMember("A");

        assertFalse(t1.equals(t2));
    }

    @Test
    public void equals_returns_false_when_members_differ() {
        Team t1 = new Team("same");
        t1.addMember("A");

        Team t2 = new Team("same");
        t2.addMember("B");

        assertFalse(t1.equals(t2));
    }

    @Test
    public void toString_returns_expected_value() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void hashCode_matches_expected_formula() {
        team.addMember("A");
        int expected = team.getName().hashCode() | team.getMembers().hashCode();
        assertEquals(expected, team.hashCode());
    }

}
