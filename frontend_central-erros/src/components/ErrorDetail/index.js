import React from "react";
import { Link } from "react-router-dom";

import "./ErrorDetail.css"

import api from "../../services/api"

export default function Detail({ history }) {

  return (
  <div className="container-error-detail">
    <div className="container-error-title">
        
            <Link to="/main">
                <button>Voltar</button>
            </Link>
        
        <h2>Erro no sadkljashdjklhask</h2>
    </div>
    <div className="container-body">
        <div className="container-describe">
        
            <div className="container-body-title">
                <h4>Título</h4>
                <p> descricao</p>
            </div>
            <div className="container-body-detail">
                <h4>Detalhes</h4>
                <p>é simplesmente uma simulação de texto da indústria tipográfica 
                e de impressos, e vem sendo utilizado desde o século XVI, quando
                 um impressor desconhecido pegou uma bandeja de tipos e os embaralhou 
                 para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu 
                 não só a cinco séculos, como também ao salto para a editoração 
                 eletrônica, permanecendo essencialmente inalterado. Se popularizou 
                 na década de 60, quando a Letraset lançou decalques contendo passagens
                  de Lorem Ipsum, e mais recentemente quando passou a ser integrado a 
                  softwares de editoração eletrônica como Aldus PageMaker.</p>
            </div>
        
        </div>
            <div className="container-body-infos">
            <p>error</p>

            <h5>Eventos</h5>
            <p>1000</p>
            
            <h5>Coletado por</h5>
            <p>Token do usuario</p>
            </div>
    </div>
  </div>
);
}