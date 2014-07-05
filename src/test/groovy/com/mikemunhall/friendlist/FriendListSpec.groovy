package com.mikemunhall.friendlist

import com.mikemunhall.friendlist.FriendList;
import spock.lang.Specification

class FriendListSpec extends Specification {

    def mikeFriends

    def setup() {
        mikeFriends = new FriendList(["Dorrie", "Chris", "Alex", "Nate"]);
    }

    def "iterateOldSchool() works, but is no longer the best way."() {
        expect:
            mikeFriends.iterateOldSchool() == ["Dorrie", "Chris", "Alex", "Nate"];
    }

    def "iterateOldSchoolALittleBetter() is better, but is still imperative."() {
        expect:
            mikeFriends.iterateOldSchoolALittleBetter() == ["Dorrie", "Chris", "Alex", "Nate"];
    }

    def "Foreach with anonymous inner class of type Consumer (new in Java 8)"() {
        expect:
            mikeFriends.iterateOldSchoolALittleBetter() == ["Dorrie", "Chris", "Alex", "Nate"];
    }

    def "forEachWithLambda() uses a lambda expression instead of the previous anonyomous inner class"() {
        expect:
            mikeFriends.forEachWithLambda() == ["Dorrie", "Chris", "Alex", "Nate"];
    }

    def "forEachWithLambdaTypeInference() removes the parens and the type on the arguments to the lambda expression"() {
        expect:
            mikeFriends.forEachWithLambdaTypeInference() == ["Dorrie", "Chris", "Alex", "Nate"];
    }

    def "forEachWithLambdaMethodReference() uses a method reference"() {
        expect:
            mikeFriends.forEachWithLambdaMethodReference() == ["Dorrie", "Chris", "Alex", "Nate"];
    }

    def "toUpperCase() returns a list with each name capitalized."() {
        expect:
            mikeFriends.toUpperCase() == ["DORRIE", "CHRIS", "ALEX", "NATE"]
    }
}
