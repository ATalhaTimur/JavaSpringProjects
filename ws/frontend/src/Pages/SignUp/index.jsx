import { useEffect, useState } from "react";
import { signUp } from "./api"; // signUpout yerine signUp olmalı

export function SignUp() {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [passwordRepeat, setPasswordRepeat] = useState('');
  const [apiProgress, setApiProgress] = useState(false);
  const [succesMessage, setSuccesMessage] = useState('');
  const [errors, setErrors] = useState({});
  const [generalError, setGeneralError] = useState('');

  useEffect(() => {
    setErrors({});
  }, [username, email, password, passwordRepeat]);

  const onSubmit = async (event) => {
    event.preventDefault();
    setSuccesMessage('');
    setGeneralError('');
    setApiProgress(true);

    try {
      const response = await signUp({
        username,
        email,
        password,
      });
      setSuccesMessage(response.data.message);
    } catch (axiosError) {
      if (axiosError.response?.data && axiosError.response.data.status === 400) {
        setErrors(axiosError.response.data.validationErrors);
      } else {
        setGeneralError('There is a problem with the server');
      }
    } finally {
      setApiProgress(false);
    }
  };

  return (
    <div className="container">
      <div className="col-lg-6 offset-lg-3 col-sm-8 offset-sm-2">
        <form className="card" onSubmit={onSubmit}>
          <div className="text-center card-header">
            <h1>Sign Up</h1>
          </div>
          <div className="card-body">
            <div className="mb-3">
              <label htmlFor="username" className="form-label">
                Username
              </label>
              <input
                id="username"
                className={
                  errors.username ? "form-control is-invalid" : "form-control"
                }
                value={username}
                onChange={(event) => setUsername(event.target.value)}
              />
              <div className="invalid-feedback">{errors.username}</div>
            </div>

            <div className="mb-3">
              <label htmlFor="email" className="form-label">
                E-mail
              </label>
              <input
                id="email"
                className={
                  errors.email ? "form-control is-invalid" : "form-control"
                }
                value={email}
                onChange={(event) => setEmail(event.target.value)}
              />
              <div className="invalid-feedback">{errors.email}</div>
            </div>

            <div className="mb-3">
              <label htmlFor="password" className="form-label">
                Password
              </label>
              <input
                id="password"
                type="password"
                className={
                  errors.password ? "form-control is-invalid" : "form-control"
                }
                value={password}
                onChange={(event) => setPassword(event.target.value)}
              />
              <div className="invalid-feedback">{errors.password}</div>
            </div>

            <div className="mb-3">
              <label htmlFor="passwordRepeat" className="form-label">
                Password Repeat
              </label>
              <input
                id="passwordRepeat"
                type="password"
                className={
                  errors.passwordRepeat
                    ? "form-control is-invalid"
                    : "form-control"
                }
                value={passwordRepeat}
                onChange={(event) => setPasswordRepeat(event.target.value)}
              />
              <div className="invalid-feedback">{errors.passwordRepeat}</div>
            </div>

            {succesMessage && (
              <div className="alert alert-success">{succesMessage}</div>
            )}
            {generalError && (
              <div className="alert alert-danger">{generalError}</div>
            )}

            <div className="text-center">
              <div>
                <button
                  className="btn btn-primary"
                  disabled={
                    apiProgress || !password || password !== passwordRepeat
                  }
                >
                  {apiProgress && (
                    <span
                      className="spinner-border spinner-border-sm"
                      aria-hidden="true"
                    ></span>
                  )}
                  Sign Up
                </button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
}