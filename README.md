# Selenium Java Test Automation Project

This project is a comprehensive Selenium WebDriver test automation framework built with Java and TestNG for testing web applications. The project follows Page Object Model (POM) design pattern and includes best practices for test automation.

## 🚀 Project Overview

This automation framework is designed to test web applications with a focus on:
- **Page Object Model (POM)** - Modular and maintainable test structure
- **TestNG Framework** - Advanced testing capabilities
- **Selenium WebDriver 4.18.1** - Modern web automation
- **WebDriverManager** - Automated driver management
- **Maven** - Dependency management and build tool

## 📁 Project Structure

```
src/test/java/
├── pages/           # Page Object Model classes
│   ├── BasePage.java
│   ├── HomePage.java
│   ├── CareersPage.java
│   └── QaJobsPage.java
├── tests/           # Test scenarios
│   └── QATest.java
└── utils/           # Utility classes
    └── Driver.java
```

## 🛠️ Technologies Used

- **Java** - Primary programming language
- **Selenium WebDriver 4.18.1** - Web automation framework
- **TestNG 7.9.0** - Testing framework
- **WebDriverManager 5.7.0** - Driver management
- **Maven** - Build and dependency management
- **Chrome Browser** - Test execution browser

## 🎯 Test Scenarios

### 1. Home Page Title Verification
- **Test:** `shouldOpenHomePageAndCheckTitle()`
- **Description:** Verify that the home page opens successfully and the title information is correct.

### 2. Careers Page Navigation
- **Test:** `shouldNavigateToCareersAndCheckBlocksVisibility()`
- **Description:** Verify that by selecting Careers from the Company menu, the Careers page and its sub-blocks (Locations, Teams, Life at Company) are opened.

### 3. QA Job Filtering
- **Test:** `shouldFilterQAJobsByLocationAndDepartment()`
- **Description:** Verify that on the QA job listings page, the job listing is retrieved by filtering with Istanbul, Turkey and Quality Assurance.

### 4. Job Listings Validation
- **Test:** `shouldCheckAllFilteredJobsContainQAAndLocation()`
- **Description:** Verify that the position, department and location information of the filtered job listings are correct.

### 5. Application Form Redirection
- **Test:** `shouldRedirectToLeverApplicationFormWhenViewRoleClicked()`
- **Description:** Verify that when the View Role button is clicked, it redirects to the Lever Application form page.

## 🏗️ Design Patterns

### Page Object Model (POM)
- Each web page has its own class
- Locators are encapsulated within page classes
- Reusable methods for page interactions
- Maintainable and scalable structure

### Singleton Pattern
- Driver class uses singleton pattern
- Ensures single WebDriver instance
- Memory optimization

### Inheritance
- BasePage abstract class
- Common functionality shared across pages
- Code reusability

## 🔧 Setup and Installation

### Prerequisites
- Java 8 or higher
- Maven 3.6 or higher
- Chrome browser

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/ramazansener/ramazan_sener_cs.git
   cd ramazan_sener_cs
   ```

2. **Compile the project**
   ```bash
   mvn clean compile
   ```

3. **Run tests**
   ```bash
   mvn clean test
   ```

## 🚀 Running Tests

### Run all tests
```bash
mvn clean test
```

### Run specific test class
```bash
mvn test -Dtest=QATest
```

### Run specific test method
```bash
mvn test -Dtest=QATest#shouldOpenHomePageAndCheckTitle
```

## 📊 Test Reports

After test execution, reports are generated in:
- `target/surefire-reports/` - TestNG HTML reports
- `target/test-output/` - Detailed test output

## 🔍 Key Features

### Explicit Wait Implementation
- WebDriverWait for dynamic elements
- ElementToBeClickable conditions
- VisibilityOfElementLocated conditions
- TextToBePresentInElementLocated conditions

### Exception Handling
- Graceful cookie banner handling
- Try-catch blocks for dynamic elements
- Proper error messages

### JavaScript Execution
- Scroll operations (top/bottom)
- Page manipulation
- Element interactions

### Window Management
- Multiple tab handling
- Window handle switching
- New tab navigation

## 🎨 Best Practices Implemented

1. **Locator Strategies**
   - CSS Selectors for performance
   - XPath for complex scenarios
   - ID and Class selectors where appropriate

2. **Wait Strategies**
   - Explicit waits over implicit waits
   - Custom wait conditions
   - Proper synchronization

3. **Code Organization**
   - Clear package structure
   - Meaningful method names
   - Comprehensive comments

4. **Error Handling**
   - Graceful exception handling
   - Informative error messages
   - Proper cleanup

## 📈 Performance Optimizations

- **WebDriverManager** for automatic driver setup
- **Explicit waits** for better performance
- **CSS selectors** for faster element location
- **Singleton pattern** for memory efficiency

## 🔒 Security Considerations

- No hardcoded credentials
- Environment-based configuration
- Secure driver management

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**Ramazan Şener**
- GitHub: [@ramazansener](https://github.com/ramazansener)

## 📞 Support

For questions and support, please open an issue on GitHub or contact the author.

---

**Note:** This project is designed for educational and professional purposes. Make sure to update URLs and locators according to your specific application under test. 