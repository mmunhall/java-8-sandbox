package com.mikemunhall.functional;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LexicalScoping {

    private List<String> friends;
    private List<String> pals;
    private List<String> chums;

    public static Predicate<String> checkStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

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
        A naive approach at filtering multiple collections by copy/pasting lambda expressions.
        The lambda expression makes it conscise, but it's duplicated.
    */
    public List<String> findAllStartingWithNNaiveApproach() {
        List<String> nFriends = friends.stream()
            .filter(name -> name.startsWith("N"))
            .collect(Collectors.toList());

        List<String> nPals = pals.stream()
            .filter(name -> name.startsWith("N"))
            .collect(Collectors.toList());

        List<String> nChums = chums.stream()
            .filter(name -> name.startsWith("N"))
            .collect(Collectors.toList());

        List<String> all = new ArrayList<String>();
        all.addAll(nFriends);
        all.addAll(nPals);
        all.addAll(nChums);

        return all;
    }

    /*
        The filter method takes a reference to a Predicate functional interface.
        Create one to use as a reusable argument to filter(). Only slightly better
        than the previous method.
    */
    public List<String> findAllStartingWithNReusingPredicate() {
        final Predicate<String> startsWithN = name -> name.startsWith("N");

        List<String> nFriends = friends.stream()
            .filter(startsWithN)
            .collect(Collectors.toList());

        List<String> nPals = pals.stream()
            .filter(startsWithN)
            .collect(Collectors.toList());

        List<String> nChums = chums.stream()
            .filter(startsWithN)
            .collect(Collectors.toList());

        List<String> all = new ArrayList<String>();
        all.addAll(nFriends);
        all.addAll(nPals);
        all.addAll(nChums);

        return all;
    }

    /*
        Duplication is reintroduced when we decide to return names beginning with different letters.
    */
    public List<String> findFriendsStartingWithNorBNaiveApproach() {
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        final Predicate<String> startsWithB = name -> name.startsWith("B");

        List<String> nFriends = friends.stream()
            .filter(startsWithN)
            .collect(Collectors.toList());

        List<String> bFriends = friends.stream()
            .filter(startsWithB)
            .collect(Collectors.toList());

        List<String> all = new ArrayList<String>();
        all.addAll(nFriends);
        all.addAll(bFriends);

        return all;
    }

    public List<String> friendsStartsWith(final String letter) {
        return friends.stream()
            .filter(checkStartsWith(letter))
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
