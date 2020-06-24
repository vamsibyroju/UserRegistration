# UserRegistration
Controllers :
1.)login
url:/login/
Method:Post
Body:
{
    "password": "vamsi"
    "email": "byrojuvamsi@gmail.com"
}
Success Response:
Welcome 
error_response:
-> Invalid Password  
-> Invalid Credentials.Please SignUp!

2.) Register
url:/register/
Method:Post
Body:
{
    "password": "vamsi"
    "email": "byrojuvamsi@gmail.com"
}
Success Response:
User created User{id=1, email=byrojuvamsi@gmail.com, password=vamsi} 
error_response:
-> User with provided Credentials already Exists.Please login! 

3.) Get all the Users
url:getAll/
Method:Get
Success Response:
[
    {
        "id": 1,
        "email": "byrojuvamsi@gmail.com",
        "password": "vamsi12"
    }
]

if no users empty list is returned.


Note:
Tested login api with 100 requests,
a)Total time taken :585ms
b)Average time taken: 5.85ms
c)Least time taken:3ms
d)Highest Time taken:15ms
