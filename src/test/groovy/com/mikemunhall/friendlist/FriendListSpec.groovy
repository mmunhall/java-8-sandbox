package com.mikemunhall.friendlist

import com.mikemunhall.friendlist.FriendList;
import spock.lang.Specification

class FriendListSpec extends Specification {

    def mikeFriends = new FriendList(["Dorrie", "Chris", "Alex", "Nate"]);

    def "sample"() {
        expect:
            mikeFriends.toUpperCase() == ["DORRIE", "CHRIS", "ALEX", "NATE"]
    }
}
