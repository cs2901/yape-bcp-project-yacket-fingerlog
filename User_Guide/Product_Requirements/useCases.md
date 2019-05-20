# Use Cases

- Business Register
	* **Software System:** Yape Negocios
	* **Actor:** Owner
	* **Use Case:** UC01 - Register a Business
		1. Owner opens the app.
		2. Owner choose to register a business.
		3. Yape Negocios display a register form.
		4. Owner enters the required info.
		5. Yape Negocios validates the received info.
		6. Yape Negocios creates the account.\
		Use Case ends.
	* **Extensions:**\
		5a Yape Negocios detects an error in the entered info.\
		5a1 Yape Negocios requests for correct info.\
		5a2 User enters data again.\
		Steps 5a1-5a2 are repeated until the data entered is correct. Use case resumes from step 6.

- Login
	* **Software System:** Yape Negocios
	* **Actor:** Seller/Owner
	* **Use Case:** UC02 - Log into Yape Negocios
	* **Preconditions:** UC01
		1. Seller/Owner opens the app.
		2. Seller/Owner fills credentials.
		3. Yape Negocios validate the credentials.
		4. Yape Negocios display the main menu screen.\
		Use Case ends.
	* **Extensions:**\
		3a Yape Negocios detects an error in the entered credentials.\
		3a1 Yape Negocios requests for correct credentials.\
		3a2 User enters credentials again.\
		Steps 3a1-3a2 are repeated until the credentials entered are correct. Use case resumes from step 4.

- Add a seller

- Remove a seller

- Create a new payment voucher

