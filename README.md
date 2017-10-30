# A Sample Spring Boot Application
- Developed using N-tier architecture - Controller, Assembler/ValueObjects, Service, Repository and Entity layers.
- Validated data using spring boot annotation at value objects and entities.
- Generated custom error messages if validation fails or an exception is thrown while processing the request.
- Added sample unit tests at Controller, Service and Repository layers.
- Added documentation both at class and method levels.

## Tools and Versions
Java 8, Maven 3.3.9, Spring Boot 1.5.8.RELEASE

## Hosted at Heroku
https://whispering-temple-67991.herokuapp.com

## REST APIs

- GET /tasks/validateBrackets?input={brackets}

Checks if brackets in a string as specified by 'input' parameter are balanced.

#### Criteria for a balanced string of brackets:
    - For every opening bracket (i.e., (, {, or [), there is a matching closing bracket (i.e., ), }, or ]) of the same type (i.e., ( matches ), { matches }, and [ matches ]). An opening bracket must appear before (to the left of) its matching closing bracket. For example, ]{}[ is not balanced.
    - No unmatched braces lie between some pair of matched bracket. For example, ({[]}) is balanced, but {[}] and [{)] are not balanced.

### Response

200 - OK
```
{
  "input": "[(]",
  "isBalanced": false
}
```
400 - Bad Request
```
{
  "details": [
    {
      "location": "params",
      "param": "text",
      "msg": "Input parameter must be given"
    }
  ],
  "name": "ValidationError"
}
```

- POST /todo
```
{
  "text": "Be a human!"
}
```

Creates a to do item.

### Response

200 - OK
```
{
  "id": {id},
  "text": "Be a human!",
  "isCompleted": false,
  "createdAt": "2017-10-13T01:50:58.735Z"
}
```
400 - Bad Request
```
{
  "details": [
    {
      "location": "params",
      "param": "text",
      "msg": "Must be between 1 and 50 chars long",
      "value": ""
    }
  ],
  "name": "ValidationError"
}
```

- GET /todo/{id}

Retrieves the to do item with the specified id.

### Response

200 - OK
```
{
  "id": {id},
  "text": "Be a human!",
  "isCompleted": false,
  "createdAt": "2017-10-13T01:50:58.735Z"
}
```
404 - Not Found
```
{
  "details": [
    {
      "message": "Item with {id} not found"
    }
  ],
  "name": "NotFoundError"
}
```

- PATCH /todo/{id}
```
{
  "text": "Be a bad-human!",
  "isCompleted": true
}
```

Modifies the to do item with the specified id.

### Response

200 - OK
```
{
  "id": {id},
  "text": "Be a bad-human!",
  "isCompleted": true,
  "createdAt": "2017-10-13T01:50:58.735Z"
}
```
404 - Not Found
```
{
  "details": [
    {
      "message": "Item with {id} not found"
    }
  ],
  "name": "NotFoundError"
}
```
400 - Bad Request
```
{
  "details": [
    {
      "location": "params",
      "param": "text",
      "msg": "Must be between 1 and 50 chars long",
      "value": ""
    }
  ],
  "name": "ValidationError"
}
```
