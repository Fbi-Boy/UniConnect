# Timeout Handling

HTTP 408 and connectivity timeouts are eligible for bounded retry. The client must never create an unbounded retry loop.
