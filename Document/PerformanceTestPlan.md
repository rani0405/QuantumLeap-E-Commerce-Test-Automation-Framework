# Performance Test Plan - QuantumLeap

## Objective
To evaluate the login functionality of SauceDemo under load conditions.

## Scope
- Test only the login API and login page.
- Out of scope: checkout, payment.

## Workload Model
- 50 concurrent users.
- Each user performs 1 login attempt per minute for 10 minutes.

## Metrics to Monitor
- Response time (target: < 2 seconds).
- Throughput (logins per second).
- Error rate (should be < 2%).
- Resource utilization (CPU, memory of server if monitored).

## Tools
- JMeter or Gatling.
