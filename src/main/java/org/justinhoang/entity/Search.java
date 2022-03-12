package org.justinhoang.entity;

import java.util.*;

public class Search {

    private String enteredSearchType;

    private String enteredSearchTerm;

    private ArrayList<User> databaseQueryResults;

    private boolean isUserFound;

    public Search() {
        databaseQueryResults = new ArrayList<User>();
    }

    public void addFoundUser(User user) {
        databaseQueryResults.add(user);
    }

    public void setEnteredSearchType(String enteredSearchType) {
        this.enteredSearchType = enteredSearchType;
    }

    public String getEnteredSearchType() {
        return enteredSearchType;
    }

    public void setEnteredSearchTerm(String enteredSearchTerm) {
        this.enteredSearchTerm = enteredSearchTerm;
    }

    public String getEnteredSearchTerm() {
        return enteredSearchTerm;
    }

    public void setDatabaseQueryResults(ArrayList<User> databaseQueryResults) {
        this.databaseQueryResults = databaseQueryResults;
    }

    public ArrayList<User> getDatabaseQueryResults() {
        return databaseQueryResults;
    }

    public void setIsUserFound(boolean isUserFound) {
        this.isUserFound = isUserFound;
    }

    public boolean getIsUserFound() {
        return isUserFound;
    }
}
