package com.mikemunhall.functional

import com.mikemunhall.functional.FindElements;
import spock.lang.Specification

class FindElementsSpec extends Specification {

    def mikeFriends

    def setup() {
        mikeFriends = new FindElements(["Dorrie", "Chris", "Alex", "Nate", "Chuck"]);
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
