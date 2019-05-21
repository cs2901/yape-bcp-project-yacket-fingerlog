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
		2. Seller/Owner enters credentials.
		3. Yape Negocios validate the credentials.
		4. Yape Negocios display the main menu screen.\
		Use Case ends.
	* **Extensions:**\
		3a Yape Negocios detects an error in the entered credentials.\
			3a1 Yape Negocios requests for correct credentials.\
			3a2 User enters credentials again.\
			Steps 3a1-3a2 are repeated until the credentials entered are correct. Use case resumes from step 4.

- Add a seller
	* **Software System:** Yape Negocios
	* **Actor:** Owner, Seller
	* **Use Case:** UC03 - Add a seller
	* **Preconditions:** UC02
		1. Owner goes to Menu.
		2. Owner select the collaborators option.
		3. Yape Negocios display the collaborators section.
		4. Owner enters the required data about the new seller.
		5. Yape Negocios send a invitation to the seller.
		6. Seller accept the invitation.
		7. Seller is added to the business.
		Use Case ends.
	* **Extensions:**\
		4a Yape Negocios detects an error in the entered data.\
			4a1 Yape Negocios requests for correct data.\
			4a2 User enters data again.\
			Steps 4a1-4a2 are repeated until the data entered are correct. Use case resumes from step 4.\
		6a Seller reject the invitation.\
			6a1 Seller is not added to the business. Use case ends.
 
- Remove a seller
	* **Software System:** Yape Negocios
	* **Actor:** Owner, Seller
	* **Use Case:** UC04 - Remove a Seller
	* **Preconditions:** UC02, UC03
		1. Owner goes to Menu.
		2. Owner select the collaborators option.
		3. Owner choose the remove option.
		4. Yape Negocios display a confirmation popup.
		5. Owner choose accept.
		6. Seller is removed from the business.\
		Use Case ends.
	* **Extensions:**
		4a Owner choose cancel.\
			7a1 Seller is not removed from the business. Use case ends. 

- Generate a new payment voucher
	* **Software System:** Yape Negocios
	* **Actor:** Owner/Seller, Customer
	* **Use Case:** UC05 - Generate a payment voucher
	* **Preconditions:** UC02
		1. Owner/seller goes to the generate payment voucher section.
		2. Owner/seller enters the items to sell.
		3. Owner/seller choose the receive payment button.
		4. Yape Negocios display a QR code.
		5. Customer scans the QR code showed by Owner/Seller.
		6. Yape Negocios send the generated payment voucher in PDF format to both, owner and customer, and to SUNAT.\
		Use Case ends.
	* **Extensions:**
		5a Customer don't scan the QR code in the next 5 minutes.
			5a1. The QR code expires. Use case resumes from step 1.
