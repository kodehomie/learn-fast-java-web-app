# Application Flow

### About

1. Static page providing information about "Learn Fast."

### Contact

1. Static page providing contact information about "Learn Fast."

### User Create An Account

1. User selects "Create an account."
2. User completes form.
3. User submits completed form.
4. Request goes to "create-an-account" servlet.
5. Servlet creates a user object.
6. Servlet creates user in the database.
7. Response to user confirming addition (show a message on the jsp.)

### User Sign In

1. User selects "Sign in."
2. User enters username and password on form
3. User submits completed form.
4. If user is authenticated, the server will handle allowing access to edit
   pages.
5. If authentication fails, then display error message.