Feature: PDF File Utility

  Scenario: Verify Extraction of unencrypted pdf file
    Given I have a uncrypted pdf file
    Then I should extract the file

  Scenario: Verify Encryption type of unencrypted pdf file
    Given I have a uncrypted pdf file
    Then pdf file should be unencrypted

  Scenario: Verify Searching through unexcrypted pdf file
    Given I have a uncrypted pdf file
    When I should extract the file
    Then I should be able to search some text from the pdf file

  Scenario: Verify Searching through unexcrypted pdf file
    Given I have a uncrypted pdf file
    Then PDF document should contain number of pages
