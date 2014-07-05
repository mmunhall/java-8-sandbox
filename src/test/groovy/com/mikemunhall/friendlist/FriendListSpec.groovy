package com.mikemunhall.friendlist

import com.mikemunhall.friendlist.FriendList;
import spock.lang.Specification

class FriendListSpec extends Specification {

    def "iterateOldSchool() works, but is no longer the best way."() {
        given:
            def mikeFriends = new FriendList(["Dorrie", "Chris", "Alex", "Nate"]);

        expect:
            mikeFriends.iterateOldSchool() == ["Dorrie", "Chris", "Alex", "Nate"];
    }

    def "iterateOldSchoolALittleBetter() is better, but is still imperative."() {
        given:
            def mikeFriends = new FriendList(["Dorrie", "Chris", "Alex", "Nate"]);

        expect:
            mikeFriends.iterateOldSchoolALittleBetter() == ["Dorrie", "Chris", "Alex", "Nate"];
    }

    def "toUpperCase() returns a list with each name capitalized."() {
        given:
            def mikeFriends = new FriendList(["Dorrie", "Chris", "Alex", "Nate"]);

        expect:
            mikeFriends.toUpperCase() == ["DORRIE", "CHRIS", "ALEX", "NATE"]
    }
}
