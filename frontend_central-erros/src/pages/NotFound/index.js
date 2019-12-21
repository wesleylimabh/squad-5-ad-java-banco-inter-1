import React from "react";

import "./NotFound.css";

export default function NotFound({ history }) {
  async function handleClick(e) {
    e.preventDefault();

    history.goBack();
  }

  return (
    <div className="notfound-container">
      <h1> 404 :( </h1>
      <h1>Página não encontrada</h1>
      <button onClick={handleClick}>Voltar</button>
    </div>
  );
}
