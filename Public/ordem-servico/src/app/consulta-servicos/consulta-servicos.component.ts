import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-consulta-servicos',
  templateUrl: './consulta-servicos.component.html',
  styleUrls: ['./consulta-servicos.component.css', '../app.component.css']
})
export class ConsultaServicosComponent implements OnInit {

  constructor() {  }
  servicos = [];
  ngOnInit(): void {
    fetch("http://localhost:8080/api/servicos")
    .then((response)=>{
      return response.text();
    }).then((text)=>{
      let servicos = JSON.parse(text);
      servicos.forEach(servico => {
          this.servicos.push(servico);
      });
    }).catch((e)=>{
      console.log("Erro ao se conectar com a API. \n" + e);
    })
  }

  retonarStatus(status){
    if(status == "1"){
      return "Em Aberto";
    }
    if(status == "2"){
      return "Finalizado";
    }

    if(status == "3"){
      return "Entregue";
    }

    return "Cancelado";
  }
}
