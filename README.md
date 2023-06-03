# securityJWT
minimal example.

postman:
step 1:
http://localhost:8080/auth/init
auth: @Post - body - raw
{
    "username": "admin",
    "password": "12345"
}

step2:
@Get
http://localhost:8080/info
headers: Authorization -> get value token on step 1.
