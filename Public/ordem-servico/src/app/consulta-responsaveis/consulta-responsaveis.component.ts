import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-consulta-responsaveis',
  templateUrl: './consulta-responsaveis.component.html',
  styleUrls: ['./consulta-responsaveis.component.css']
})
export class ConsultaResponsaveisComponent implements OnInit {

  constructor() { }
  responsaveis = []
  teste = "oi";
  ngOnInit(): void {
    fetch("http://localhost:8080/api/responsaveis",{
      headers: {'Content-type': 'application/json'}
    })
    .then((response)=>{
      return response.text();
    }).then((text)=>{
      let responsaveis = JSON.parse(text);
      responsaveis.forEach(responsavel => {
        this.responsaveis.push(responsavel);
      });
    }).catch((e)=>{
      console.log("Erro ao conectar com API. \n" + e);
    })
  }
  excluirResponsavevel(id){
    if(confirm("Confirma a exclusão do responsável? ID:" + id)){
      fetch("http://localhost:8080/api/responsavel/"+id,{
        method: "DELETE"
      }).then((response)=>{
        if(response.status == 200){
          alert("Responsável excluído com sucesso.");
          window.location.reload();
          return;
        }
      }).catch((e)=>{
        console.log("Erro ao conectar com a API. \n" + e);
      })
    }
    
  }

  editarResponsavel(id){
    fetch("http://localhost:8080/api/responsavel/"+id,{
      headers: {'Content-type': 'application/json'}
    })
    .then((response)=>{
      return response.text();
    }).then((text)=>{
      let responsavel = JSON.parse(text);
      (document.querySelector("#id") as HTMLInputElement).value = responsavel.id;
      (document.querySelector("#nome") as HTMLInputElement).value = responsavel.nome;
      (document.querySelector("#email") as HTMLInputElement).value = responsavel.email;
      (document.querySelector("#telefone") as HTMLInputElement).value = responsavel.telefone;
      (document.querySelector("#endereco") as HTMLInputElement).value = responsavel.endereco;
    }).catch((e)=>{
      console.log("Erro ao conectar com API. \n" + e);
    })
  }
  }
  
