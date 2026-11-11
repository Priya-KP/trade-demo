# Trade Demo

Small Java 17 + Spring Boot + Maven project for hands-on practice.

## Requirements
- Java 17
- Maven 3.9+
- IntelliJ IDEA or VS Code
- Git

## Run
```bash
mvn clean test
mvn spring-boot:run
```

## API
GET http://localhost:8080/api/trades

POST http://localhost:8080/api/trades

Example JSON:
```json
{
  "tradeId": "T1002",
  "accountId": "A501",
  "currencyPair": "GBP/USD",
  "side": "SELL",
  "amount": 250000,
  "rate": 1.27
}
```

Remote change for Git pull practice.

Git pull and merge conflict practice completed.