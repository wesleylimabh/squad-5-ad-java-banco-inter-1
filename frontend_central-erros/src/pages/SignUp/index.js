import React, { useState } from "react";
import { Link } from "react-router-dom";

import "./SingUp.css";

import api from "../../services/api";
import logo from "../../assets/logo.png";

export default function SingUp({ history }) {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  async function handleSubmit(e) {
    e.preventDefault();
    if (!name || !email || !password) {
      setError("Preencha todos os campos para se cadastrar");
    } else {

      const data ={
        "nome": name,
        "email": email,
        "senha": password
      }

      try {
        const response = await api.post('/usuarios/cadastro', data)
        if (response) {
          if (response.data && response.data.access_token) {
              alert("Usuário cadastrado com sucesso!");
              history.push(`/`);
          }
        }

      } catch (err) {
        console.log(err);
        setError("Ocorreu um erro ao realizar o cadastro.");
      }
    }
  }

  return (
    <div className="signup-container">
      <form onSubmit={handleSubmit}>
        <div className="signup-container logo">
          <img src={logo} alt="Novo Cadastro" />
          <h2>Novo Cadastro</h2>
        </div>
        {error && <p>{error}</p>}
        <input
          type="name"
          placeholder="Digite seu nome"
          value={name}
          onChange={e => setName(e.target.value)}
        />
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
        <Link to="/">Fazer Login</Link>
      </form>
    </div>
  );
}
