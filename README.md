# COMP2000 Assignment
## Assignment Scenario
A supermarket chain requires an Automated Checkout System with a Kiosk User Interface for customers to scan and pay for their goods and a stock database.

The stock database automatically removes items from stock when bought. It will also add, remove and edit existing stock items. 

The stock database requires admin accounts for staff. Admin users require a login name and password with access to the stock database. The system will highlight any stock that needs replenishing when an admin logs in. Admin users can send orders for new stock and update replenished items when deliveries arrive.

The kiosk User Interface allows customers to scan a code on items, this code will match the stock database code for that item. When the items are paid for, the stock database updates its remaining items. The kiosk interface displays a list of the currently scanned items with their names, prices and a running total price for all items. 

Customers can pay using cash or a card. Cash payment will calculate and display any change required to be given to the customer. Card payments need a verification screen that displays an accept or deny message from their bank.

The receipt requires a printout of the item names and their prices, the total price and payment method. If the payment method is cash, also print the change given.

The receipt display is required to be in a separate GUI panel of the application. Use threading to inject the receipt data into the panel and output the text as you may see in paper receipts. This includes the company name, date and the information above. The process should only start when the thread has finished processing the receipt data.
##### App opening with a welcome screen.
![Image of opening the app](https://github.com/LightP1256/COMP2000-Main/blob/master/picturesOfApp/Launch.PNG)
##### App checkout section where you can go to the admin section or stay in the section if your a customer.
![Image of the checkout](https://github.com/LightP1256/COMP2000-Main/blob/master/picturesOfApp/checkout.PNG)
##### Not allowing the admin to login without a correct username and password.
![Image of the login screen](https://github.com/LightP1256/COMP2000-Main/blob/master/picturesOfApp/message%20box%20for%20no%20match.PNG)
##### Vailed login details and have access to the product sheet.
![Image of the product sheet](https://github.com/LightP1256/COMP2000-Main/blob/master/picturesOfApp/admin%20product%20sheet.PNG)
##### Where the admin can edit, delete and save food products 
![Image of using the product sheet](https://github.com/LightP1256/COMP2000-Main/blob/master/picturesOfApp/edit%2C%20delete%20and%20save%20product%20sheet.PNG)
##### Adding products as a customer to make their shopping list. 
![Image of using the checkout](https://github.com/LightP1256/COMP2000-Main/blob/master/picturesOfApp/products%20added.PNG)
##### Buying eggs using the cash option 
![Image of using the checkout Cash](https://github.com/LightP1256/COMP2000-Main/blob/master/picturesOfApp/Cash%20option.PNG)
##### using the card option to checkout
![Image of using the Card option](https://github.com/LightP1256/COMP2000-Main/blob/master/picturesOfApp/Card%20option.PNG)
##### waiting for the process of printing out the receipt
![Image of using the Card option receipt](https://github.com/LightP1256/COMP2000-Main/blob/master/picturesOfApp/receipt.PNG)



Built using Intellij IDEA 2020.2.4
