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
            3) Verbose, violates \"Tell, don't ask.\" principle.
    */
    public List<String> iterateOldSchool() {
        List<String> out = new ArrayList<String>();
        for (int i=0; i<friends.size(); i++) {
            out.add(friends.get(i));
        }
        return out;
    }

    public List<String> toUpperCase() {
        return friends.stream()
            .map(name -> name.toUpperCase())
            .collect(Collectors.toList());
    }

    /*public static void main(String[] args) {
        System.out.println("Old School, imperative:");
        System.out.println("Why it's not optimal:");
        System.out.println("    1) Sequential, difficult to parellelize,");
        System.out.println("    2) Non-polymorphic, you get what you ask for,");
        System.out.println("    3) Verbose, violates \"Tell, don't ask.\" principle.");
        for (int i=0; i<friends.size(); i++) {
            System.out.println(friends.get(i));
        }
        System.out.println("");

        System.out.println("Old School, slightly less imperative:");
        for(String friend : friends) {
            System.out.println(friend);
        }
        System.out.println("");

        System.out.println("Foreach, with anonymous inner class (new in Java 8):");
        friends.forEach(new Consumer<String>() {
            public void accept(final String name) {
                System.out.println(name);
            }
        });
        System.out.println("");

        System.out.println("Introducting Java 8 lambdas:");
        friends.forEach((final String name) -> System.out.println(name));
        System.out.println("");

        System.out.println("Types can be inferred (but you cannot declare as final):");
        friends.forEach(name -> System.out.println(name));
        System.out.println("");

        System.out.println("Methods can be referenced:");
        friends.forEach(System.out::println);
        System.out.println("");

        System.out.println("Imperative transformation:");
        for(String friend : friends) {
            uppercaseNames.add(friend.toUpperCase());
        }

        System.out.println("Slightly better, but still mostly imperative transformation:");
        uppercaseNames.clear();
        friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
        System.out.println(uppercaseNames);

        System.out.println("Real functional programming, using Java 8's stream() and map():");
        uppercaseNames.clear();
        friends.stream()
            .map(name -> name.toUpperCase())
            .forEach(name -> System.out.print(name + " "));
        System.out.println();
    }
    */
}
