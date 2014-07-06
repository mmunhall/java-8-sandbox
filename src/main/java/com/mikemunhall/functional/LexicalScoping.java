package com.mikemunhall.functional;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LexicalScoping {

    private List<String> friends;
    private List<String> pals;
    private List<String> chums;

    public LexicalScoping() {}

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public void setPals(List<String> pals) {
        this.pals = pals;
    }

    public void setChums(List<String> chums) {
        this.chums = chums;
    }

    /*
        Return the names that begin with the letter N (the old, imperative way)
    */
    public List<String> friendsStarWithNTheOldWay() {
        List<String> out = new ArrayList();
        for(String name : friends) {
            if (name.startsWith("N")) {
                out.add(name);
            }
        }
        return out;
    }

    /*
        Returns the names that begin with the letter N (using the filter() method)
    */
    public List<String> friendsStarWithNUsingFilter() {
        return friends.stream()
            .filter(name -> name.startsWith("N"))
            .collect(Collectors.toList());
    }

    /*
        A naive approach at filtering multiple collections by copy/pasting lambda expressions
    */
    public List<String> findAllStartingWithNNaiveApproach() {
        List<String> all = new ArrayList<String>();
        all.addAll(friends);
        all.addAll(pals);
        all.addAll(chums);
        return all.stream()
            .filter(name -> name.startsWith("N"))
            .collect(Collectors.toList());
    }

    // /*
    //     Illustrating the problem of reuse
    // */
    // public List<String> allThatStartWithN() {
    //
    // }
    //
    // /*
    //     Reuse a lambda by storing it in a variable
    // */
    // public List<String> allThatStartWithLambaVariable() {
    //
    // }
    //
    // /*
    //     Duplicate lambda expressions
    // */
    // public List<String> allThatStartWithNorB() {
    //
    // }
    //
    // /*
    //     Use a static predicate for lambda reuse
    // */
    // public List<String> checkIfStartsWith() {
    //
    // }
    //
    // /*
    //     Use a Function interface to narrow the scope and avoid static variables
    // */
    // public List<String> startsWithLetter() {
    //
    // }
}
