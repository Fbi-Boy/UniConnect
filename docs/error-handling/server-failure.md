# Server Failure Handling

HTTP 5xx responses are transient candidates. After the retry budget is exhausted, the final typed error reaches the caller.
