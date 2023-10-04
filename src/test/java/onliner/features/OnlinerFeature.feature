Feature: Onliner products search test

  Scenario Outline: I search products by parameters

    Given I'm not signed in user on the main page and navigate to the Catalogue page
    When I click on the catalog menu option 'Электроника', electronic aside list 'Телевидение и видео' and select 'Телевизоры'
    And I select manufacturer as <brand>
    And I set max price as <priceMax>
    And I set min <diagonalMin> diagonal
    And I set max <diagonalMax> diagonal
    And I select screen resolution as <diagonalResolution>
    Then I see the list of products that match by <priceMax>, <brand>, <diagonalMin> and <diagonalMax> diagonal, <diagonalResolution>

    Examples:
      | brand   | priceMax | diagonalMin | diagonalMax | diagonalResolution  |
      | Samsung | 1500     | 40"         | 50"         | 1920x1080 (Full HD) |