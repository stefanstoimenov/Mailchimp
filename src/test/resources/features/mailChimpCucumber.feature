Feature: Mailchimp
  @mytag
  Scenario Outline: Log in
    Given I have entered "firefox" as a browser
    Given I have opened "https://login.mailchimp.com/signup/" as a webpage
    And I have entered <mail> as a mail
    And I have also entered <username> as an username
    And I have also entered <password> as a password
    When I press sign up
    Then I should get the correct <output>

    Examples:
    |mail     |username     |password | output |
    |"stefan.stoimenov@yahoo.com" |"hv23486em9"  | "vaporWAVE(93" | "Check your email" |
    |"stefan.stoimenov@yahoo.com" |"qwertyuiopasdfghjklzxcvbnm123456789qwertyuiopasdfghjklzxcvbnm123456789qwertyuiopasdfghjklzxcvbnm123456789"  | "vaporWAVE(93" | "Enter a value less than 100 characters long" |
    |"stefan.stoimenov@yahoo.com" |"stefan"  | "vaporWAVE(93" | "Another user with this username already exists. Maybe it's your evil twin. Spooky." |
    |""|"hv23486em9"  | "vaporWAVE(93" | "Please enter a value" |










