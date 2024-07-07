import { useState } from "react";
import axios from "axios";

export function SignUp() {
  const [username, setUsername] = useState();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [passwordRepeat, setPasswordRepeat] = useState();
  const onSubmit = (event) => 
    {
    event.preventDefault();
    axios.post('/api/1.0/users', {
      username,
      email,
      password,
    });
  };

  return (
    <form onSubmit = {onSubmit}>
      <h1>Sign Up</h1>
      <div>
        <label htmlFor="username">Username</label>
        <input
          id="username"
          onChange={(event) => setUsername(event.target.value)}
        />
      </div>
      <div>
        <label htmlFor="email">E-mail</label>
        <input id="email" onChange={(event) => setEmail(event.target.value)} />
      </div>
      <div>
        <label htmlFor="password">Password</label>
        <input
          id="password"
          type="password"
          onChange={(event) => setPassword(event.target.value)}
        />
      </div>
      <div>
        <label htmlFor="passwordRepeat">Password Repeat</label>
        <input
          id="passwordRepeat"
          type="password"
          onChange={(event) => setPasswordRepeat(event.target.value)}
        />
      </div>

      <div>
        <button
          disabled={!password || password != passwordRepeat}
          
        >
          Sign Up
        </button>
      </div>
    </form>
  );
}
