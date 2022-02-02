Feature: Deque

  Scenario Outline: Adding to front of empty deque
    Given The deque contains <zero> elements
    And I add <element> to the front
    Then I should see the <element> as the first element
    Examples:
      | zero | element | element |
      | 0 | 3 | 3 |
      | 0 | 5 | 5 |
      | 0 | 13 | 13 |

  Scenario Outline: Adding to end of empty deque
    Given The deque contains <zero> elements
    And I add <int1> to the end
    Then I should see the <int1> as the first element
    Examples:
      | zero | int1 | int1 |
      | 0 | 4 | 4 |
      | 0 | 5 | 5 |
      | 0 | 13 | 13 |

  Scenario Outline: Removing element from front
    Given The deque contains <string> , <stringg> , <stringgg>, in that order
    And I remove the first element
    Then I should see the <stringg> as the new first
    Examples:
      | string | stringg | stringgg |
      | 2 |3 | 4 |
      | 5 | 6 | 7 |
      | 8 | 9 | 10 |

  Scenario Outline: Removing element from end
    Given The deque contains <string> , <stringg> , <stringgg>, in that order
    And I remove the last element
    Then I should see the <stringg> as the new end
    Examples:
      | string | stringg | stringgg |
      | 2 |3 | 4 |
      | 5 | 6 | 7 |
      | 8 | 9 | 10 |

