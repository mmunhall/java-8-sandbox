package com.mikemunhall.functional

import com.mikemunhall.functional.LexicalScoping;
import spock.lang.Specification

class LexicalScopingSpec extends Specification {

    def mikePeople

    def setup() {
        mikePeople = new LexicalScoping();
        mikePeople.friends = ["Dorrie", "Chris", "Alex", "Nate", "Chuck"]
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
}
