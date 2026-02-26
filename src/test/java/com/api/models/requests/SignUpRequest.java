package com.api.models.requests;

public class SignUpRequest {

	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "SignUpRequest [username=" + username + ", password=" + password + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}

	public SignUpRequest(String username, String password, String email, String firstName, String lastName,
			String mobileNumber) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}

	public static class Builder { // inner static class created for builder design pattern.
		private String username;
		private String password;
		private String email;
		private String firstName;
		private String lastName;
		private String mobileNumber;

		public Builder username(String username) {
			this.username = username; // setter method
			Builder x = this; // (new Builder() --> I don't want new object, want only current object)
			return x; // returns the current object of the class
		}

		public Builder password(String password) {

			this.password = password;
			return this; // returns current object
		}

		public Builder email(String email) {
			this.email = email;
			return this; // returns current object
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this; // returns current object
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this; // returns current object
		}

		public Builder mobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this; // returns current object
		}

		public SignUpRequest build() {
			SignUpRequest signUpRequest = new SignUpRequest(username, password, email, firstName, lastName,
					mobileNumber);
			return signUpRequest;
		}

	}
}
