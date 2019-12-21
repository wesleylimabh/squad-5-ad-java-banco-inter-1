import React, { useState } from "react";
import { Link } from "react-router-dom";

import "./Login.css";
import logo from "../../assets/logo.png";

import loginOauth from "../../services/loginOauth"
import {login, saveEmail} from "../../services/auth"

export default function Login({ history }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  async function handleSubmit(e) {
    e.preventDefault();
    if (!email || !password) {
      setError("Preencha todos os campos para continuar");
    } else {
      try {
        const response = await loginOauth(email, password)
        if (response) {
          if (response.data && response.data.access_token) {
              login(response.data.access_token);
              saveEmail(email);
              console.log(response);
              history.push(`/main`);
          }
        }
      } catch (err) {
        console.log(err);
        setError("Ocorreu um erro no login, verifique suas credenciais.");
      }
    }
  }

  return (
    <div className="login-container">
      <form onSubmit={handleSubmit}>
        <div className="login-container logo">
          <img src={logo} alt="Central de Erros" />
          <h2>Login</h2>
        </div>
        {error && <p>{error}</p>}
        <input
          type="email"
          placeholder="Digite seu email"
          value={email}
          onChange={e => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Digite sua senha"
          value={password}
          onChange={e => setPassword(e.target.value)}
        />
        <button type="submit">Enviar</button>
        <hr />
        <Link to="/signup">Cadatrar novo usuário</Link>
      </form>
    </div>
  );
}
