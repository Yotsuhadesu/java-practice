# Aquadel Water Refilling Station Program
## Business Information
- Address: Pili, Camarines Sur
- Employees: Cashier, Delivery Guy, Dishwasher
## Prices (PHP)
Water Amount | Price per Piece 
--- | --- |---
1 Gallon | 25 
1 Liter | 17.50
500 mL | 7.30 
350 mL | 5.83 
- Delivery Fee: 5 
## Workflow
- Pickup
    1. The customer places their order.
    2. The cashier records the customer's order and information.
    3. The customer pays.
    4. The order is picked up.
    5. The transaction is recorded.
- Delivery:
    1. The customer places their order.
    2. The cashier records the customer's order and information.
    3. The delivery guy delivers the order.
    4. The customer pays.
    5. The transaction is recorded.
- Refill:
    1. The customer asks for refill.
    2. The cashier records the customer's order and information.
    3. The delivery guy picks up the empty container.
    4. The delivery guy delivers the refilled container.
    5. The customer pays.
    6. The transaction is recorded.
## Classes
- Main - comprises all the classes and executes the program
- Transaction - transaction information
- Input - for input validation
- Order - order information
- Inventory - stocks
- Cashier - the entity who records the transaction
- Customer - customer information

## Tasks
- [x] - save customer in a text file
- [ ] - view transactions
- [ ] - search transactions
- [x] - cashier log in

## System Issues
- [x] The product information form doesn't accept quantity that is equal to stock.
- [x] The saved product ID in transaction file is always null.
- [ ] Delivery Method doesn't add 5 peso fee