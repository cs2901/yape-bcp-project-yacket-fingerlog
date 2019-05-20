# Introduction
Since the evolution of the internet and the creation of smart phones, mobile applications have become increasingly necessary to facilitate us in our daily lives. In banking issues this facility is not alien, since the way to transfer money has changed radically. One of the applications that most sound and have changed the way we do transactions is Yape, this is an application for smarthphones launched by the BCP that facilitates the transfer of money.
 In the course of Software Engineering a professional environment has been recreated with real costumers, in this case Yape is the costumer to whom we have to advise so that the number of users that he has increases rapidly, for which he will have to present an idea for then validate it and, followed by the metrics taught in the course, implement them. In the present report, Yacket will be presented which will add the feature of issuing an electronic invoice to the Yape application, in this way we intend to increase the amount of Yaperos.
For this, two potential costumers have been defined. The first one is the yape costumer that usually goes to mypes and pymes. The second is a possible owner and owner of the mypes and pymes. Both like technology and constantly seek new ways to digitize the entire sales process, taking advantage of these tools that speed up, ensure and facilitate buying and selling.
The purpose of this project will be to implement the functionality of electronic tickets and invoices through Yape.

# Features
 ## Antonio Toche/Fernando Socualaya/Sergio Carbone: UI design
 
 ### Sergio Carbone/Antonio Toche/Fernando Socualaya: Yape UI
This section will recreate the UI of the yape application since our functionality will be within the same application. Thanks to the enhanced interviews, it was decided that the functionality will be done within the application, so it is necessary to recreate the Yape interface.

* v1.1 Add login UI.
* v1.2 Add Main page UI.
* v1.3 Add sidebar and componentes.


### Sergio Carbone: Entity picker
In this section you can select if it is a company or an User. Since to generate a bill / invoice you need to be a company.
* v1.1 Add button component.
* v1.2 Add pickers.


### Sergio Carbone: Person pay feature
To try to recreate Yape as best as possible, it is necessary to integrate the interfaces it has.

* v1.1 Add person pay feature interface.
* v1.2 Add forms.
* v1.3 Add button to pay.


### Sergio Carbone: Add business info
We need to save the business data for invoices purpose.

* v1.1 Add forms.
* v1.3 Add button to save.


### Antonio Toche: Business pay feature
In this section the items are placed to later collect. It is working in this way since it is necessary to set aside this method of payment with what a client normally does.(See Anexx C)

* v1.1 Add business pay feature interface.
* v1.2 Add forms.
* v1.3 Add buttons to get/change new business.


### Fernando Socualaya: Qr code feature
Once the items are placed, you will need to generate the Qr code so that the payment can be made effectively.(See anexx D)

* v1.1 Add Qr interface.


 ## Antonio Toche/Fernando Socualaya/Sergio Carbone/Jose Chavez/ Jeffrey Orihuela: Implementation}
 ### Jeffrey Orihuela/Antonio Toche: Ticket
The ticket generator will be the feature that sends the generated ticket to the respective emails. For this feature, you need the yape owner's email and the customer's email these had to be filled in previously.

* v1.1 Get data.
* v1.2 Send email.
* v1.3 Save ticket.


### Fernando Socualaya/José Chavez: Bill
The selling generator will be the component that sends the generated selling to the respective emails. For this function, you need the email from the Yape owner and the customer's email, in addition you will need the Ruc, all these had to be filled in previously.

* v1.1 Get data.
* v1.2 Send data to reniec.
* v1.3 Send/Save bill to email.


### Sergio Carbone/Jeffrey Orihuela: Qr generator
Once the items are placed, you will need to generate the Qr code so that the payment can be made effectively.

* v1.1 Get/Show data.
* v1.2 Set Qr.

# Design
## Architecture
### Class Diagram
### Architecture Diagram
### Components
### Interaction between components
# FAQ
# Glossary

    * Yape: name of the application.
    * Yacket: name of the services.
    * MYPE/PYME: Micro and Small sized enterprises.
    * Micro sized entreprise: Conformed by less than 10 employees.
    * Client: person who use yape to pay.
    * Small sized entreprise: Conformed by less than 20 employess.
    * Consumer: The person who purchase a product.
    * MYPE/PYME owner: The person who owns/manages a MYPE/PYME.
    * Ticket/invoice/selling: Payment vouchers.
    * SUNAT: Entity that collects taxes.
