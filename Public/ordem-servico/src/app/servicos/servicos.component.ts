import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-servicos',
  templateUrl: './servicos.component.html',
  styleUrls: ['./servicos.component.css', '../app.component.css']
})
export class ServicosComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }
  responsaveis = [];
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

    this.route.params.subscribe(parametros =>{
      if(parametros['id']){
        fetch("http://localhost:8080/api/servico/"+parametros['id'],{
          headers: {'Content-type': 'application/json'}
        })
        .then((response)=>{
          return response.text();
        }).then((text)=>{
          let servico = JSON.parse(text);
          (document.querySelector("#id") as HTMLInputElement).value = servico.id;
          (document.querySelector("#cliente") as HTMLInputElement).value = servico.cliente;
          (document.querySelector("#email") as HTMLInputElement).value = servico.email;
          (document.querySelector("#endereco") as HTMLInputElement).value = servico.endereco;
          (document.querySelector("#telefone") as HTMLInputElement).value = servico.telefone;
          (document.querySelector("#produto") as HTMLInputElement).value = servico.produto;
          (document.querySelector("#marca") as HTMLInputElement).value = servico.marca_produto;
          (document.querySelector("#tipo") as HTMLInputElement).value = servico.tipo_produto;
          (document.querySelector("#responsavel") as HTMLInputElement).value = servico.responsavel.id;
          (document.querySelector("#valor") as HTMLInputElement).value = servico.valor;
          (document.querySelector("#contratacao") as HTMLInputElement).value = servico.data_contratacao;
          (document.querySelector("#entrega") as HTMLInputElement).value = servico.data_entrega;
          (document.querySelector("#cliente") as HTMLInputElement).readOnly = true;
          (document.querySelector("#produto") as HTMLInputElement).readOnly = true;
          (document.querySelector("#contratacao") as HTMLInputElement).readOnly = true;
          if(servico.status == '1') (document.querySelector("#Aberto") as HTMLInputElement).checked = true;
          if(servico.status == '2') (document.querySelector("#Finalizado") as HTMLInputElement).checked = true;
          if(servico.status == '3') (document.querySelector("#Entregue") as HTMLInputElement).checked = true;
          if(servico.status == '4') (document.querySelector("#Cancelado") as HTMLInputElement).checked = true;
        }).catch((e)=>{
          console.log("Erro ao conectar com API. \n" + e);
        })
      }
    })
  }

  limpar(){
    window.location.reload();
  }
  confirmar(){
    let id = (document.querySelector("#id") as HTMLInputElement).value;
    let cliente = (document.querySelector("#cliente") as HTMLInputElement).value;
    let email = (document.querySelector("#email") as HTMLInputElement).value;
    let endereco = (document.querySelector("#endereco") as HTMLInputElement).value;
    let telefone = (document.querySelector("#telefone") as HTMLInputElement).value;
    let produto = (document.querySelector("#produto") as HTMLInputElement).value;
    let marca = (document.querySelector("#marca") as HTMLInputElement).value;
    let tipo = (document.querySelector("#tipo") as HTMLInputElement).value;
    let responsavel = (document.querySelector("#responsavel") as HTMLInputElement).value;
    let valor = (document.querySelector("#valor") as HTMLInputElement).value;
    let contratacao = (document.querySelector("#contratacao") as HTMLInputElement).value;
    let entrega = (document.querySelector("#entrega") as HTMLInputElement).value;
    let status = '';
    if((document.querySelector("#Aberto") as HTMLInputElement).checked) status = "1";
    if((document.querySelector("#Finalizado") as HTMLInputElement).checked) status = "2";
    if((document.querySelector("#Entregue") as HTMLInputElement).checked) status = "3";
    if((document.querySelector("#Cancelado") as HTMLInputElement).checked) status = "4";

    if(!cliente || !email || !endereco || !telefone || !produto || !marca || !tipo || responsavel == '#' || !valor || !contratacao || !endereco){
      alert("Preencha todos os campos.");

      if(!cliente) document.querySelector("#cliente").classList.add("preencher");
      if(!email) document.querySelector("#email").classList.add("preencher");
      if(!endereco) document.querySelector("#endereco").classList.add("preencher");
      if(!telefone) document.querySelector("#telefone").classList.add("preencher");
      if(!produto) document.querySelector("#produto").classList.add("preencher");
      if(!marca) document.querySelector("#marca").classList.add("preencher");
      if(!tipo) document.querySelector("#tipo").classList.add("preencher");
      if(responsavel == '#') document.querySelector("#responsavel").classList.add("preencher");
      if(!valor) document.querySelector("#valor").classList.add("preencher");
      if(!contratacao) document.querySelector("#contratacao").classList.add("preencher");
      if(!entrega) document.querySelector("#entrega").classList.add("preencher");

      return;
    };
    let valorConvertido:number = 0.00;

    try {
      valorConvertido =  parseFloat(parseFloat(valor).toFixed(2));
    } catch (error) {
      alert("Erro ao converter valor.");
      return;
    }
    let url ='';
    let metodo='';
    let dados ={};
    if(id == ''){
      url = "http://localhost:8080/api/servico";
      metodo = "POST"
      dados = {
        cliente: cliente,
        email: email,
        endereco: endereco,
        telefone:telefone,
        produto: produto,
        marca: marca,
        tipo: tipo,
        responsavel: {id: responsavel},
        valor: valorConvertido,
        contratacao: contratacao,
        entrega: entrega,
        status: status
      }
    }else{
      url = "http://localhost:8080/api/servico/"+id;
      metodo = "PUT"
      dados = {
        id:id,
        cliente: cliente,
        email: email,
        endereco: endereco,
        telefone:telefone,
        produto: produto,
        marca: marca,
        tipo: tipo,
        responsavel: {id: responsavel},
        valor: valorConvertido,
        contratacao: contratacao,
        entrega: entrega,
        status: status
      }
    }
    fetch(url,{
      method: metodo,
      body: JSON.stringify(dados),
      headers: {'Content-type' : 'application/json'}
    }).then((response)=>{
        if(response.status == 200){
          alert("Salvo com sucesso");
          window.location.reload();
        }else{
          alert("Erro ao salvar serviço.\n"+ response.statusText);
        }
    }).catch((e)=>{
      console.log("Erro ao se conectar com API. \n" + e);
    })

  }

}
