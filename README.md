# API Endpoints Documentation

This document provides an overview of all the API endpoints.

---

## 1. Authentication APIs

- **URL**: `http://localhost:8080/api/auth/**`
- **Access**: Public (No authentication required)
- **Description**:  
  Endpoints related to user authentication, such as:
  - **User login**:  
    ```http
    POST http://localhost:8080/api/auth/login
    ```
  - **User registration**:  
    ```http
    POST http://localhost:8080/api/auth/register
    ```
---

## 2. User APIs

- **URL**: `http://localhost:8080/api/user/**`
- **Access**: Requires `USER` role
- **Description**:  
  These endpoints are accessible only by authenticated users with the `USER` role. Examples:
  - **View user details**:  
    ```http
    GET http://localhost:8080/api/user/me
    ```
  - **Update user settings**:  
    ```http
    PUT http://localhost:8080/api/user/settings
    ```

---

## 3. Admin APIs

- **URL**: `http://localhost:8080/api/admin/**`
- **Access**: Requires `ADMIN` role
- **Description**:  
  These endpoints are restricted to users with the `ADMIN` role for administrative tasks. Examples include:
  - **Manage users**:  
    ```http
    GET/POST/DELETE http://localhost:8080/api/admin/users
    ```
  - **View system reports**:  
    ```http
    GET http://localhost:8080/api/admin/reports
    ```
  - **Application configuration**:  
    ```http
    POST http://localhost:8080/api/admin/config
    ```

---

## 4. Team APIs

- **URL**: `http://localhost:8080/api/team/**`
- **Access**: Requires `TEAM` role
- **Description**:  
  These endpoints allow users with the `TEAM` role to manage and access team-related data. Examples:
  - **View team details**:  
    ```http
    GET http://localhost:8080/api/team/details
    ```
  - **Manage team members**:  
    ```http
    POST/DELETE http://localhost:8080/api/team/members
    ```
  - **Team collaboration tools**:  
    ```http
    POST http://localhost:8080/api/team/collaborate
    ```

---

## Summary of Access Rules

| API URL Pattern                       | Full URL Example                           | Required Authority | Description                                    |
|---------------------------------------|--------------------------------------------|--------------------|------------------------------------------------|
| `/api/auth/**`                        | `http://localhost:8080/api/auth/login`     | None               | Public authentication (login, signup)          |
| `/api/user/**`                        | `http://localhost:8080/api/user/profile`   | `USER`             | User-specific APIs (profile, settings)          |
| `/api/admin/**`                       | `http://localhost:8080/api/admin/users`    | `ADMIN`            | Admin-only APIs (user management, reports)      |
| `/api/team/**`                        | `http://localhost:8080/api/team/details`   | `TEAM`             | Team-specific APIs (team management, collaboration) |

---