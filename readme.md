# Assumptions and decisions

## Entities

### JavaScriptFramework

Assuming that each framework is represented by a single record with multiple versions and only a single hype level.

## Controller

### Creating an entity

Assuming that we always create framework with a single version only. Currently the controller does not allow creating a framework with multiple versions at once.

Sample request to create a new framework version:

```json
{ "name": "React", "version": "1.3", "deprecationDate": "2100-12-01", "hypeLevel": 4.2 }
```

### Searching entities

Searching frameworks by part of their name (case-insensitive) is implemented at `/frameworks/search?name=some_text`.

### Deleting a framework version

There is a separate endpoint for deleting framework versions. Otherwise there's no way of deleting a version without deleting the whole framework.

The endpoint is available at `/frameworks/versions/{version_id}`.
