Feature: Registration form 

	Scenario: User register successfully
	Given the user is on registration page
	When the user enters "dfdsssddgdfg@gmail.com" and click submit
	And the user enter "firstname" in the field "firstname"
	And the user enter "lastname" in the field "lastname"
	And the user enter "password" in the field "password"
	And the user enter "company" in the field "company"
	And the user enter "address" in the field "address"
	And the user enter "51838" in the field "postcode"
	And the user enter "city" in the field "city"
	And the user enter "99898989" in the field "mobile"
	And the user enter "alias" in the field "alias"
	And the user enter "lastname" in the field "lastname"
	And the user select "4" in the field "state"
	And the user select "United States" in the field "country"
	And the user select "4" in the field "day"
	And the user select "September" in the field "month"
	And the user select "1995" in the field "year"
	And the user select "male" in the field "title"
	And user submit regristration form
	Then your is successfully registered
	
	
	Scenario: Verify invalid email address
	Given the user is on registration page
	When the user enters "hello@gmail.com" and click submit
	Then user is dispayed with an invalid email error message
	
	Scenario: Verify error messages for mandatory fields
	Given the user is on registration page
	When the user enters "rwerfsdfsdfefs4@gmail.com" and click submit
	And user submit regristration form
	Then user is dispayed with a required error message
	
	
	Scenario: Verify error messages for entering incorrect values in fields
	Given the user is on registration page
	When the user enters "dasderwesdfwe4@gmail.com" and click submit
	And the user enter "333^&%" in the field "firstname"
	And the user enter "_^%%$" in the field "lastname"
	And the user enter "hi" in the field "password"
	And the user enter "%%%" in the field "address"
	And the user select "United States" in the field "country"
	And the user enter "%%%%" in the field "postcode"
	And the user select "4" in the field "state"
	And the user enter "*&&%$$" in the field "city"
	And the user enter "dfdfdg" in the field "mobile"
	And user submit regristration form
	Then user is displayed with a invalid error message