# Introduction

Since the evolution of the internet and the creation of smart phones, mobile applications have become increasingly necessary to facilitate us in our daily lives. In banking issues this facility is not alien, since the way to transfer money has changed radically. One of the applications that most sound and have changed the way we do transactions is Yape, this is an application for smarthphones launched by the BCP that facilitates the transfer of money.
In the course of Software Engineering a professional environment has been recreated with real costumers, in this case Yape is the costumer to whom we have to advise so that the number of users that he has increases rapidly, for which he will have to present an idea for then validate it and, followed by the metrics taught in the course, implement them. In the present report, Yacket will be presented which will add the feature of issuing an electronic invoice to the Yape application, in this way we intend to increase the amount of Yaperos.
For this, two potential costumers have been defined. The first one is the yape costumer that usually goes to mypes and pymes. The second is a possible owner and owner of the mypes and pymes. Both like technology and constantly seek new ways to digitize the entire sales process, taking advantage of these tools that speed up, ensure and facilitate buying and selling.
The purpose of this project will be to implement the functionality of electronic tickets and invoices through Yape.

# Features

## Antonio Toche/Jose Chavez/Fernando Socualaya: UI design

### Antonio Toche: Yape UI Login

This section will try to recreate the Yape UI as close as possible, Yape Negocios will be a different application to the already known Yape, but will preserve some of the existing designs.

- v1.1 Add login UI from Yape.
- v1.2 Add DNI Input.
- v1.3 Create authentication function.

### Antonio Toche: Register section UI

In this section the UI will be made for the part of the registry that the owner will have to do. The owner must be registered to be able to access an account and that his collaborators have access.

- v1.1 Add forms.
- v1.2 Add register button.

### José Chávez: Entity picker

In this section you can select if it is a collaborator or an owner. You must enter as a collaborator or owner to upload the information of each company respectively. It was implemented in this way since you can own one company and collaborate with another.

- v1.1 Add button component.
- v1.2 Add pickers.
- v1.3 Plot data in UI from the databse.
- v1.4 Show data dynamically 

### José Chávez: Collaborator UI feature.

The section of the UI in which the collaborator can generate charges. Collaborators can choose between ticket and invoice depending on what is required, and will proceed in a different way depending on what has been selected.

- v1.1 Add picker Ticket/invoice.
- v1.2 Add inputs.
- v1.3 Add get back/pay button.

### Antonio Toche: Menú UI feature.

The section of the UI in wich the Owner only can manage and get data from her Collaborators.

- v1.1 Add buttons.
- v1.2 Add Implements next activity.

### Antonio Toche: Owner managemente UI feature.

The section of the UI in wicht the Owner only can manage collaborators, add and remove data.

- v1.1 Add data dinamically from database.
- v1.2 remove data dinamically from database.
- v1.3 Add new collaborator.
- v1.4 Remove collaborator.


### Antonio Toche: Movements UI feature.

The section of the UI in wich the Owner only can check the Collaborator transactions.

- v1.1 add Data dinamically from database.
- v1.2 update data from database dinamically.

### José Chávez: Owner UI feature.

Similar to collaborator feature the owner can generate charges, and manage session. Here the owner can create and remove a new collaborator, the owner will be able to see the last entry of each one of his collaborators thanks to the section of notifications and also he will be able to see what contributed by each collaborator.

- v1.1 Add picker Ticket/invoice.
- v1.2 Add inputs.
- v1.3 Add pay/get back/ Notifications/ Collaborators/ Movements/ Settings/ Profile/ Log Out buttons.
- v1.4 Add display Qr.

### Fernando Socualaya: Qr code UI feature

Once the items are placed, you will need to generate the Qr code so that the payment can be made effectively.

- v1.1 Extract the data about the purchase and store it. 
- v1.2 Display the QR code based previously generated.

## Antonio Toche/Fernando Socualaya/Sergio Carbone/José Chávez/Jeffrey Orihuela: Implementation

### Jeffrey Orihuela/Sergio Carbone: Ticket 

The ticket generator will be the feature that sends the generated ticket to the respective emails. For this feature, you need the yape owner's email and the customer's email these had to be filled in previously.

- v1.1 Implement SendGrid API into our application and sends a testing fixed mail.
- v1.2 The users can place their own data so he can receive the ticket in his mailbox.
- v1.3 Parse the data received by scanning the QR code.
- v1.4 Fill the ticket with all the corresponding data.
- v2.0 Style mail in plain text format.

### Jeffrey Orihuela/Sergio Carbone: Invoice

The selling generator will be the component that sends the generated selling to the respective emails. For this function, you need the email from the Yape owner and the customer's email, in addition you will need the RUC, adress and business name all these had to be filled in previously.

- v1.1 Implement SendGrid API into our application and sends a testing fixed mail.
- v1.2 The users can place their own data so he can receive the ticket in his mailbox.
- v1.3 Parse the data received by scanning the QR code.
- v1.4 Fill the ticket with all the corresponding data.
- v2.0 Style mail in plain text format.

### Fernando Socualaya: Qr generator

Once the items are placed, you will need to generate the Qr code so that the payment can be made effectively. The qr is needed to make the payment effective, this way you avoid having a contact section and the transfer is faster. In that way, the QR code needs to have all the data about the transaction. This is data from the business, data from the customer and about the items purchased.

- v1.1 Get data about the purchase and store it. 
- v1.2 Set Qr with the stored data.
- v1.3 Display de generated code.

### José Chávez/ Antonio Toche/ Jeffrey Orihuela: Implement Database

In order to have something to store the data sent, a database will be necessary. Here you can make querys. The database implemented will be Firebase ,a cloud-hosted NoSQL database.

- v1.1 Create sets of data in JSON model.
- v1.2 Connect database into the backend using Firebase Connect.
- v1.3 Add users
- v1.4 Add and remove collaborators
- v2.0 Give data for the QR generator.

# Design

## Architecture

### Architecture Diagram

![Architecture Diagram](https://github.com/cs2901/yape-bcp-project-yacket-fingerlog/blob/master/Developer_Guide/Diagrama_de_componentes/arquitectura.jpg)

### Class Diagram

![class diagram](https://github.com/cs2901/yape-bcp-project-yacket-fingerlog/blob/master/Developer_Guide/Diagrama_de_componentes/clases.jpg) 
#### UI
The UI section has been divided into 2 parts which are for the collaborator and the owner, obviously both have much in common. What they share both will be the part of registration and and making tickets and invoices. The difference is when we enter the owner component since it manages the collaborators. That is why owner have notifications, collaborators, movements, adjustments and profile. And the collaborator section can only make tickets and invoices. We have a controller view which will be able to handle each button that redirects us to another page, in addition we have an authentication section that jumps when the login data fails.


### Interaction between components

#### Remove Collaborator
![removecollab](https://github.com/cs2901/yape-bcp-project-yacket-fingerlog/blob/master/Developer_Guide/Diagrama_de_componentes/interaccion2.jpg)
#### Generate Qr
![Add Business](https://github.com/cs2901/yape-bcp-project-yacket-fingerlog/blob/master/Developer_Guide/Diagrama_de_componentes/interaccion1.jpg)
#### Add Collaborator
![Log In as Business](https://github.com/cs2901/yape-bcp-project-yacket-fingerlog/blob/master/Developer_Guide/Diagrama_de_componentes/interaccion3.jpeg)
                     


# FAQ

#### **Q:** Is a separate application necessary for the implementation of this feature?

**A:** Yes, due to operating methods and users preferences the best way is to have separate apps

#### **Q:** Is a database manager really needed for this implentation?

**A** A database administrator is crucial to this implementation due to the confidential information and important good management of the data.
# Glossary

    * Yape: name of the application.
    * Yacket: name of the services.
    * MYPE/PYME: Micro and Small sized enterprises.
    * Owner: Micro and Small sized enterprises owner.
    * Micro sized entreprise: Conformed by less than 10 employees.
    * Client: person who use yape to pay.
    * Small sized entreprise: Conformed by less than 20 employess.
    * Collaborator: Employee.
    * Notifications: alert wich triggers when collaborators entry in your business.
    * Movements: charges made by collaborators.
    * Consumer: The person who purchase a product.
    * MYPE/PYME owner: The person who owns/manages a MYPE/PYME.
    * Ticket/invoice/selling: Payment vouchers.
    * Settings: settings of the business or owner.
    * ORM: Object-relational mapping
    * Database: data save.
    * RUC: Unique Taxpayers Registry
    * Querys: data petition.
    * Log out: session ends.
    * Get back: back to the last layout.
    * Layout: view of the app.
    * Inputs: entry of data.
    * Forms: entry of data for registration purposes.
    * SUNAT: Entity that collects taxes.
    * Firebase: Cloud platform to help the web and mobile applications development
    * Sendgrid: Is a customer communication platform for transactional and marketing email.
    
