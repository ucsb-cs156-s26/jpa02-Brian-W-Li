package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Brian L.";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "Brian-W-Li";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("s26-03");
        team.addMember(getName());
        team.addMember("Alexandru");
        team.addMember("Kalyan");
        team.addMember("Raymond X.");
        team.addMember("Wyatt");
        team.addMember("Alex L.");
        return team;
    }
}
