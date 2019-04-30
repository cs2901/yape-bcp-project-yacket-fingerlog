# YapeTicket Documentation

## Target user profile and Value proposition

In our project, we have two main target users. The first is a YAPE user that use it to purchase products in a MYPE/PYME. The second is a YAPE user who manages a PYME/MYPE.

Both have a big liking of technology and constantly look for new ways of digitizing the purchase and sell proccess taking advantage of these tools that streamline secure and facilitate the shopping and sales.

The main value proposal of our team is to add the feature of make possible to generate a ticket or invoice when you pay through YAPE instantly.

## User Stories

### Must have

* As the owner of a MYPE, I would like to keep a record of my clients in order to recognize them and build loyalty.

* As a MYPE customer, I can pay without cash so I'm not afraid about receiving fake money.

* As a MYPE customer, I can have a ticket to ensure the register of the purchase in case there is a problem with the product or service.
 
* As a MYPE owner, I can receive payments in a digital way so I won't receive fake bills.

* As a MYPE customer, I can pay my purchases using my smartphone so I avoid having cash everytime.

* As a MYPE customer, I can have electronic invoices or receipts so I can be sure that I will never lose any of them.

* As MYPE owner, I can avoid paying an electronic billing service to save much more money.

* As a MYPE owner, I can offer an easy way to pay in my business, so that I can attract more clients.

* As MYPE owner, I want to automate the payment system to avoid being stolen in the cashier box.

* As a MYPE customer, I want the payment process to be fast so I can continue with my daily activities.

* As a MYPE owner, I want the tickets to be organized so that the procedures with the SUNAT will be easier for me.

### Nice To Have
 
* As a MYPE owner, I need the application not to hang up so that I can quickly attend all my clients.
 
* As a MYPE customer, I want to be able to see my expenses organized so that I can better invest my money and not make unnecessary expenses.
 
* As a MYPE owner, I would like to keep a record of my clients in order to recognize and retain them.
 
* As a MYPE owner, I would like to receive information on sales throughout the days of the week in order to better distribute the resources.
 
* As a MYPE owner, I want to have my business with YAPE payment so that clients that use that application can feel attracted.
 
* As a MYPE customer, I would like to be able to tip the waiter and register it.
 
* As MYPE custoemer, I would like you to give a rating to the restaurants to know the quality of the service before you try it.
 
* As a MYPE customer, I would like to be able to divide the account among several people in order to facilitate payment.
 
* As a user, I would like to be able to access my tickets from the application to be able to view my tickets in a faster way.
 
* As a MYPE customer, I can add my favorite restaurants to pay there faster.
 
* As a MYPE owner, I would like to be able to charge the deliveries to addresses and that the delivery person generates a QR to have a greater reach of my product.

### Not Useful
 
* As a MYPE customer, I want to feel more in touch with technology so I can use it daily and simplify my life.
 
* As a MYPE frequent customer, I can receive offers paying with yape to be more satisfied with the application.
 
* As a MYPE customer, I want to make a good impression in front of other people when using my cell phone as a means of payment.
 
* As a MYPE customer, I can avoid spending paper to keep the planet clean.
 
* As a MYPE owner, I would like to be able to scan the bar codes of the products to be able to charge them faster.

## Use cases

1. As a client, I want to have electronic ticket/invoices or bills to be sure that I will
never lose them.

* Software System: Yape
* Actor: MYPE Customer
* Use Case : Generate electronic bill
    * (a)  Client scans transaction QR code
    * (b)  Yape collects transaction data
    * (c)  Yape makes a request to SUNAT servers
    * (d)  Yape generates and sends the pdf ticket/invoice to the Client
    * (e)  Yape awaits the response from the SUNAT BDD
Use Case ends

2. As the owner of a MYPE, I would like to keep a record of my clients in order to recognize them and build loyalty.

* Software System: Yape
* Actor: MYPE owner , Client
* Use Case : Save frequent clients
    * (a)  Client makes payment
    * (b)  MYPE owner receives payment
    * (c)  Yape saves Client transactions counter
    * (d)  Add one to client counter
    * (e)  Update counters
    * (f)  List clients with more transactions
Use Case ends.

## Non-functional requirements

* To be able to organize, according to sector, the payments made by each user.

* Take a register of the consumers and analyze the most concurrent days and of the highest demand.

* Accept within the tip payment or be in the ability to divide the account into a certain number of people.

* To be able to support payments of orders at home.

* Conclude the procedure with SUNAT in real time.

* Categorize the type of product or service sold.

## Glossary

* MYPE/PYME: Micro and Small sized enterprises.
* MYPE Customer: The person who purchase a product in a MYPE.
* MYPE owner: The person who owns/manages a MYPE.
* Ticket/invoice: Payment vouchers.
* SUNAT: Entity that collect taxes.