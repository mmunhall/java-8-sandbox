package com.mikemunhall.friendlist

import com.mikemunhall.friendlist.FriendList;
import spock.lang.Specification

class FriendListSpec extends Specification {

    def mikeFriends = new FriendList(["Dorrie", "Chris", "Alex", "Nate"]);

    def "iterateOldSchool() works, but is no longer the best way."() {
        expect:
            mikeFriends.iterateOldSchool() == ["Dorrie", "Chris", "Alex", "Nate"];
    }

    def "toUpperCase() returns a list with each name capitalized."() {
        expect:
            mikeFriends.toUpperCase() == ["DORRIE", "CHRIS", "ALEX", "NATE"]
    }
}
