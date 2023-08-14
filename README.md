# Indian Flavor Scape

### Description:

Indian Flavor Scape is a restaurant that aims to digitalize the ordering process by providing a web application for customers to select their preferred flavors. Customers can log in, place combination dish orders, and check order status, while staff can view and update orders on the server-side.

### Project Scope:

Develop a web application for Indian Flavor Scape restaurant to digitalize the ordering process. Allow customers to Sign up/log in, select their preferred flavors for a combination dish (such as selecting main dish followed by additive, side), place orders, and check order statuses. Provide staff members with the ability to view and update orders on the server-side.

### Features:

-User-friendly interface for selecting flavors and placing orders

-Order management and status tracking

-Secure user authentication

-Database integration for storing order data

### System Requirements:

Compatible Operating Systems: Windows, MacOS

**Usage:** 

Clone the repository to your local machine

**Command :** git clone <https://git.cs.slu.edu/group_3/indian-flavor-scape.git>

We had the Architecture in 3 layers and each layer has specific dependencies and process of deployment:

Please follow these steps

### Backend Setup:

-Download and Install Vs code-add spring boot dependencies

-Add Gradle dependency

-Add latest java dependency JDK (java development kit) 

-Install MySQL work bench

-Run the SQL scripts in MYSQL work bench provided in the project path -> 

    -Indian-Flavor-Scape\Backend\indian\_flavor\_scape\src\main\resources\scripts

    -First create a Database with name: indian\_flavor\_scape

    -Second create user: springuser , password: ThePassword

    -grant all on indian\_flavor\_scape.\* to 'springuser'@'%';

    -open project in vs code
    
    -Navigate to the Back-End directory (`Indian-Flavor-Scape\Back-End\indian_flavor_scape`).
    
    -Execute the command `gradle build` to build the project.
    
    -On successful build the target folder 'build' is generated
    
    -Navigate to (`build/libs`).

    -Execute command (`java -jar indian_flavor_scape-0.0.1-SNAPSHOT.jar`).
    
    -Backend will be up and running.

-Test from post man

-Once the backend is up and running.

### Front-End Setup:

-Go to the root folder of the project.

-Change directory to Indian-flavor-scape/Front-end. 

Perform npm commands:
    - npm install to install dependencies. 
    - npm start to start the server.

-Access the application from web browser `http://localhost:3001/`.

**If you are encountering reload page please execute this command in terminal Root(Front-End) directory:**

$env:NODE_OPTIONS="--openssl-legacy-provider"

### Front-End Compilation and Running:

1. Open a terminal window.
2. Navigate to the Front-End directory (`Indian-flavor-scape/Front-end`).
3. Execute the command `npm install` to install project dependencies.
4. Run the command `npm start` to start the front-end server.
5. Access the application using a web browser: [http://localhost:3001/](http://localhost:3001/)
