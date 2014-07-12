package com.mikemunhall.functional;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;

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

    /*
        Predicates can be stored in a variable.
    */
    public List<String> friendsStartsWithStaticMethod(final String letter) {
        return friends.stream()
            .filter(checkStartsWith(letter)) // checkStartsWith is a static method
            .collect(Collectors.toList());
    }

    /*
        This version narrows the scope of the Predicate.
    */
    public List<String> friendsStartsWithNarrowedScope(final String letter) {
        final Function<String, Predicate<String>> startsWithLetter =
            (String l) -> {
                Predicate<String> checkStarts = (String name) -> name.startsWith(l);
                return checkStarts;
            };

        return friends.stream()
            .filter(startsWithLetter.apply(letter)) // startsWithLetter is locally scoped
            .collect(Collectors.toList());
    }

    /*
        Reduce the clutter: This version replaces the previous narrow-scoped function with one that
        returns a lambda.
    */
    public List<String> friendsStartsWithNarrowedScopeLambda(final String letter) {
        final Function<String, Predicate<String>> startsWithLetter =
            (String l) -> (String name) -> name.startsWith(l);

        return friends.stream()
            .filter(startsWithLetter.apply(letter)) // startsWithLetter is locally scoped
            .collect(Collectors.toList());
    }

    /*
        Further reduce the clutter by allowing the compiler to infer the types
    */
    public List<String> friendsStartsWithNarrowedScopeLambdaConsise(final String letter) {
        final Function<String, Predicate<String>> startsWithLetter =
            l -> name -> name.startsWith(l);

        return friends.stream()
            .filter(startsWithLetter.apply(letter)) // startsWithLetter is locally scoped
            .collect(Collectors.toList());
    }

}
