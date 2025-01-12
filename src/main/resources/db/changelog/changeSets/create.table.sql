-- liquibase formatted sql

-- changeset alex2:Categories
CREATE TABLE Categories (
CategoryID INT AUTO_INCREMENT NOT NULL,
Name VARCHAR(255) NULL,
CONSTRAINT PK_CATEGORIES PRIMARY KEY (CategoryID));

-- changeset alex2:Products
CREATE TABLE Products (
ProductID INT AUTO_INCREMENT NOT NULL,
Name VARCHAR(255) NULL,
CategoryID INT NULL,
DiscountPrice DOUBLE NULL,
Price DOUBLE NULL,
CreatedAt datetime NULL,
UpdatedAt datetime NULL,
`Description` VARCHAR(255) NULL,
ImageURL VARCHAR(255) NULL,
CONSTRAINT PK_PRODUCTS PRIMARY KEY (ProductID));

-- changeset alex2:IndexProductsFk
CREATE INDEX FK_PRODUCTS_CATEGORYID_IDX ON Products(CategoryID);

-- changeset alex2:REFERENCES_PRODUCTS_CATEGORIES
ALTER TABLE Products ADD CONSTRAINT FK_PRODUCTS_CATEGORYID_REFERENCES FOREIGN KEY (CategoryID)
REFERENCES Categories (CategoryID) ON UPDATE RESTRICT ON DELETE RESTRICT;


CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL UNIQUE,
    PhoneNumber VARCHAR(255),
    PasswordHash VARCHAR(255) NOT NULL,
    Role ENUM('CLIENT', 'ADMIN') NUll DEFAULT 'CLIENT'
);

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    DeliveryAddress VARCHAR(255),
    ContactPhone VARCHAR(255),
    DeliveryMethod VARCHAR(255),
    Status ENUM('Pending', 'Shipped', 'Delivered', 'Canceled') NULL DEFAULT 'Shipped',
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE
);

CREATE TABLE OrderItems (
    OrderItemID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT NOT NULL,
    ProductID INT NOT NULL,
    Quantity INT NOT NULL,
    PriceAtPurchase INT NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID) ON DELETE CASCADE
);

CREATE TABLE Cart (
    CartID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE
);

CREATE TABLE CartItems (
    CartItemID INT PRIMARY KEY AUTO_INCREMENT,
    CartID INT NOT NULL,
    ProductID INT NOT NULL,
    Quantity INT NOT NULL,
    FOREIGN KEY (CartID) REFERENCES Cart(CartID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID) ON DELETE CASCADE
);

CREATE TABLE Favorites (
    FavoriteID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT NOT NULL,
    ProductID INT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID) ON DELETE CASCADE
);