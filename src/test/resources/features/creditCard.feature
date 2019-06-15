Feature: CreaditCard

  @single
  Scenario Outline: Failed booking on wrong credit card
    Given Open browser
    When Login under test user with credentials "<login>" "<password>"
    And Select flight from "<from>" to "<to>" in <amount> days from today
    And Fill all needed flight information
    And Fill passenger info with "<title>" "<name>" "<surname>"
    And Add card data "<number>" "<month>" "<year>" "<cvv>" "<cardholder>"
    And Add billing address "<country>" "<city>" "<address>" "<code>"
    Then Error message

    Examples:
      | login                    | password       | from | to | amount | title | name    |surname| number           | month | year | cvv | cardholder    | country | city | address | code |
      | ievgenatesting@gmail.com | Ryanairtest1ng |  DUB | SXF | 25    | MR    | Isabell |Maggio | 4024007159720878 |  6    | 2022 | 123 | Isabell Maggio| Portugal|Porta |ulica    | 12345|