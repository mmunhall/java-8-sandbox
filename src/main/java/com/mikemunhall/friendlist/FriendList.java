package com.mikemunhall.friendlist;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class FriendList {

    private List<String> friends;

    public FriendList(List<String> friends) {
        this.friends = friends;
    }

    public List<String> getFriends() {
        return friends;
    }

    /*
        The old school, imperative way. Why it's not optimal:
            1) Sequential, difficult to parellelize,
            2) Non-polymorphic, you get what you ask for,
            3) Verbose, violates "Tell, don't ask." principle.
    */
    public List<String> iterateOldSchool() {
        List<String> out = new ArrayList<String>();
        for (int i=0; i<friends.size(); i++) {
            out.add(friends.get(i));
        }
        return out;
    }

    /*
        Still old school, slightly less imperative:
    */
    public List<String> iterateOldSchoolALittleBetter() {
        List<String> out = new ArrayList<String>();
        for(String name : friends) {
            out.add(name);
        }
        return out;
    }

    /*
        Foreach with anonymous inner class of type Consumer (new in Java 8)
    */
    public List<String> forEachWithAnonymousInnerClass() {
        List<String> out = new ArrayList<String>();
        friends.forEach(new Consumer<String>() {
            public void accept(final String name) {
                out.add(name);
            }
        });
        return out;
    }

    /*
        Introducing Java 8 Lambdas. Replace the verbose anonyomous inner class
        with a lambda. Ahhh... Getting better.
    */
    public List<String> forEachWithLambda() {
        List<String> out = new ArrayList<String>();
        friends.forEach((final String name) -> out.add(name));
        return out;
    }

    /*
        Types can be inferred (but you cannot declare as final), and you can
        remove the parentheses
    */
    public List<String> forEachWithLambdaTypeInference() {
        List<String> out = new ArrayList<String>();
        friends.forEach(name -> out.add(name));
        return out;
    }

    /*
        Methods can be referenced in a lambda expression. This is possible only
        for cases when the argument and the result need no modification.
    */
    public List<String> forEachWithLambdaMethodReference() {
        List<String> out = new ArrayList<String>();
        friends.forEach(out::add);
        return out;
    }

    /*
        Old school, imperative tranformation
    */
    public List<String> toUpperCase() {
        List<String> out = new ArrayList<String>();
        for(String friend : friends) {
            out.add(friend.toUpperCase());
        }
        return out;
    }

    /*
        Sligthly better with the use of a lambda, but still imperative style.
    */
    public List<String> toUpperCaseLambda() {
        List<String> out = new ArrayList<String>();
        friends.forEach(name -> out.add(name.toUpperCase()));
        return out;
    }

    /*
        Real functional programming, using Java 8's stream() and map()
    */
    public List<String> toUpperCaseFunctional() {
        return friends.stream()
            .map(name -> name.toUpperCase())
            .collect(Collectors.toList());
    }

    /*
        Real functional programming, using Java 8's stream() and map() and a method reference
    */
    public List<String> toUpperCaseFunctionalWithMethodReference() {
        return friends.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }

    /*
        Returns a list of names beginning with specified character
    */
    public List<String> findStartsWith(String c) {
        return friends.stream()
            .filter(name -> name.startsWith(c))
            .collect(Collectors.toList());
    }
}
