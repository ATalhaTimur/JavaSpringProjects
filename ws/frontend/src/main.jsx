import React from 'react'
import ReactDOM from 'react-dom/client'
//import App from './App.jsx'
import "./styles.scss";

import { SignUp } from './Pages/SignUp/index.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <SignUp />
  </React.StrictMode>,
)
