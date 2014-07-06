package com.mikemunhall.functional

import com.mikemunhall.functional.LexicalScoping;
import spock.lang.Specification

class LexicalScopingSpec extends Specification {

    def mikePeople

    def setup() {
        mikePeople = new LexicalScoping();
        mikePeople.friends = ["Dorrie", "Chris", "Alex", "Nate", "Chuck"]
        mikePeople.pals = ["Bob", "Craig"]
        mikePeople.chums = ["Scott", "Marc"]
    }

    def "friendsStarWithNTheOldWay() returns names beginning N"() {
        expect:
            mikePeople.friendsStarWithNTheOldWay() == ["Nate"]
    }
}
