import React from "react";
import { Link } from "react-router-dom";

import "./ErrorDetailed.css";

import Header from ".././../components/Header";
import ErrorDetail from ".././../components/ErrorDetail";


export default function Detail({ match }) {
  return (
    <div className="main-container">
      <Header />
      <ErrorDetail />     
    </div>
  );
}
