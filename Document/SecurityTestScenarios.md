# Security Test Scenarios - QuantumLeap

## 1. Authentication Bypass
- Attempt to directly access a protected page (e.g., https://www.saucedemo.com/inventory.html) without logging in.
- Expected: System should redirect to login page.
- If access is granted → report vulnerability.

## 2. Input Validation (XSS)
- Enter script payload in login fields:
  - Username: `<script>alert('XSS')</script>`
  - Password: `anything`
- Submit form.
- Expected: System should reject or escape input.
- If alert box appears or script executes → report vulnerability.
