# Retry Strategy

Retries use bounded exponential backoff. The default budget is three attempts with a 500 ms initial delay and a 4 second delay ceiling.
