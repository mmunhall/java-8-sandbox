package com.mikemunhall.functional;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class FindElements {

    private List<String> friends;

    public FindElements(List<String> friends) {
        this.friends = friends;
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
