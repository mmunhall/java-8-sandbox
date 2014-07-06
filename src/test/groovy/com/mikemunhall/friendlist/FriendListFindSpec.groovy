package com.mikemunhall.friendlist

import com.mikemunhall.friendlist.FriendList;
import spock.lang.Specification

class FriendListFindSpec extends Specification {

    def mikeFriends

    def setup() {
        mikeFriends = new FriendList(["Dorrie", "Chris", "Alex", "Nate", "Chuck"]);
    }

    def "findStartsWith() returns names that start with specified character"() {
        when:
            def names = mikeFriends.findStartsWith(c)

        then:
            names == n

        where:
            c   | n
            "D" | ["Dorrie"]
            "A" | ["Alex"]
            "C" | ["Chris", "Chuck"]
            "N" | ["Nate"]
            "X" | []
    }
}
