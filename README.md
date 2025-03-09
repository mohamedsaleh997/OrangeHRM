# OrangeHRM Project  

This repository contains automated test cases for the **OrangeHRM** system.  
The test cases cover various scenarios such as **user management, login, and role-based access control**.  
This project follows the **Page Object Model (POM)** for better organization and maintainability.  

---

## 📌 Prerequisites  

Before running the test cases, ensure you have the following installed:  

- **Selenium WebDriver** (for browser automation)  
- **Java** (depending on the language used)  
- **Maven** (for managing dependencies)  
- **TestNG** (for running the test cases)  
- **Supported Browsers:** Chrome, Firefox, Edge  

---

## ⚙️ Setup  

### Clone the Repository  
Clone this project to your local machine:  
```sh
git clone https://github.com/mohamedsaleh997/OrangeHRM

-----

## 🔧 Configuration  

### **Change Browser Name**  
Modify the browser name in the `WebConfiguration.properties` file:

BrowserName=chrome  # Options: chrome, firefox, edge (Default: chrome)

___________________________________________________________________________
**  Update the UserInfo.json file to configure user details:

{
    "role": "Admin",  // Options: "Admin" or "ESS" (Default: "Admin")
    "status": "enabled",  // Options: "enabled" or "disabled" (Default: "enabled")
    "employeeName": "John Doe",
    "password": "YourSecurePassword",
    "passwordConfirm": "YourSecurePassword"
}



