package com.mikemunhall.friendlist

import com.mikemunhall.friendlist.FriendList;
import spock.lang.Specification

class FriendListTransformSpec extends Specification {

    def mikeFriends

    def setup() {
        mikeFriends = new FriendList(["Dorrie", "Chris", "Alex", "Nate"]);
    }

    def "imperative toUpperCase() returns a list with each name capitalized."() {
        expect:
            mikeFriends.toUpperCase() == ["DORRIE", "CHRIS", "ALEX", "NATE"]
    }

    def "toUpperCaseLambda() uses a lambda, but it still mostly imperitive."() {
        expect:
            mikeFriends.toUpperCase() == ["DORRIE", "CHRIS", "ALEX", "NATE"]
    }

    def "toUpperCaseFunctional is the functional style we want"() {
        expect:
            mikeFriends.toUpperCaseFunctional() == ["DORRIE", "CHRIS", "ALEX", "NATE"]
    }

    def "toUpperCaseFunctionalWithMethodReference is the preferred"() {
        expect:
            mikeFriends.toUpperCaseFunctionalWithMethodReference() == ["DORRIE", "CHRIS", "ALEX", "NATE"]
    }
}
