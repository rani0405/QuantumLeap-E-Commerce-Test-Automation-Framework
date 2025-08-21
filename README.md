# QuantumLeap Test Automation Framework

## Overview
**QuantumLeap** is a beginner-friendly, full-stack test automation framework built for **UI and API testing** of e-commerce applications.  
It uses **Selenium WebDriver**, **TestNG**, **Cucumber (BDD)**, **REST Assured**, and **Extent Reports** to deliver robust, maintainable, and portfolio-ready test automation.

This project automates both web and API testing for:

- **Web Application:** [Sauce Labs Demo E-Commerce Site](https://www.saucedemo.com/)  
- **REST API:** [ReqRes - A Hosted REST API](https://reqres.in/)
  
## Features

### UI Test Automation
- Page Object Model (POM) architecture.
- Data-driven login tests using TestNG `@DataProvider`.
- End-to-end purchase flow automation.
- Explicit waits for stable tests.
- Screenshots on test failure.
- JavaScriptExecutor for advanced interactions.

### BDD Integration
- Cucumber feature files for readable test scenarios.
- Step definitions reuse Page Object methods.
- TestNG runner for executing feature files.

### API Test Automation
- CRUD operations using REST Assured:
  - `GET` users
  - `POST` create user
  - `PUT` update user
- Response validation and assertions.

### Reporting & Non-Functional Testing
- Extent Reports for UI & API test results.
- Performance Test Plan (documented).
- Security Test Scenarios (authentication bypass & XSS).

## Project Structure

QuantumLeap-TestAutomation/
├── pom.xml
├── README.md
├── src/
│ ├── main/java/com/quantumleap/utils
│ └── test/java/com/quantumleap/ui
│ ├── pages
│ ├── tests
│ ├── bdd
│ └── api
├── reports/
└── docs/

## How to Run

1. **Clone the repository**
git clone https://github.com/yourusername/QuantumLeap-TestAutomation.git

Reporting
Reports will be generated automatically in the reports/ folder.

Screenshots are saved for failed UI tests.

Notes for Beginners
The framework uses Page Object Model for maintainability.

All reusable code is in utils/.

Cucumber step definitions call Page Object methods for reusability.

REST Assured is used for easy API automation.

Author
Rani Suresh Nikhade
Beginner QA Automation Engineer


If you want, I can also **create a ready-to-use version with badges, screenshots, and instructions for beginners** so it looks professional on GitHub.  

Do you want me to do that?
