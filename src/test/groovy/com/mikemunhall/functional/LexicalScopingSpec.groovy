package com.mikemunhall.functional

import com.mikemunhall.functional.LexicalScoping;
import spock.lang.Specification

class LexicalScopingSpec extends Specification {

    def mikePeople

    def setup() {
        mikePeople = new LexicalScoping();
        mikePeople.friends = ["Dorrie", "Chris", "Alex", "Nate", "Chuck", "Bart"]
        mikePeople.pals = ["Bob", "Craig"]
        mikePeople.chums = ["Scott", "Marc", "Neil"]
    }

    def "friendsStarWithNTheOldWay() returns friends beginning N"() {
        expect:
            mikePeople.friendsStarWithNTheOldWay() == ["Nate"]
    }

    def "friendsStarWithNUsingFilter() returns friends beginning N"() {
        expect:
            mikePeople.friendsStarWithNUsingFilter() == ["Nate"]
    }

    def "findAllStartingWithNNaiveApproach() returns friends, pals and chums beginning with N"() {
        expect:
            mikePeople.findAllStartingWithNNaiveApproach() == ["Nate", "Neil"]
    }

    def "findAllStartingWithNReusingPredicate() returns friends, pals and chums beginning with N"() {
        expect:
            mikePeople.findAllStartingWithNReusingPredicate() == ["Nate", "Neil"]
    }

    def "findFriendsStartingWithNorBNaiveApproach() returns friends, pals and chums beginning with N or B"() {
        expect:
            mikePeople.findFriendsStartingWithNorBNaiveApproach() == ["Nate", "Bart"]
    }

    def "friendsStartsWith() returns friends friends beginning with provided letter"() {
        expect:
            mikePeople.friendsStartsWith("D") == ["Dorrie"]
            mikePeople.friendsStartsWith("C") == ["Chris", "Chuck"]
            mikePeople.friendsStartsWith("A") == ["Alex"]
            mikePeople.friendsStartsWith("N") == ["Nate"]
            mikePeople.friendsStartsWith("B") == ["Bart"]
            mikePeople.friendsStartsWith("X") == []
    }
}
