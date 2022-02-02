Feature:

  Scenario Outline: Removing second element in list
    Given The deque contains <string> , <stringg> , <stringgg>, in that order
    And I remove the second element
    Then The deque should contain two elements, <string> and <stringgg>
    Examples:
      | string | stringg | stringgg |
      | 2 |3 | 4 |
      | 5 | 6 | 7 |
      | 8 | 9 | 10 |

  Scenario: Trying to remove second element that doesnt exist
    Given The deque has less than two items
    And I try to remove the second element
    Then The program should catch an exception
