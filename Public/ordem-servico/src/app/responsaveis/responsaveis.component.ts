import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-responsaveis',
  templateUrl: './responsaveis.component.html',
  styleUrls: ['./responsaveis.component.css', '../app.component.css']
})
export class ResponsaveisComponent implements OnInit {

  constructor() { }

  url = '';
  dados = {};
  metodo ='';
  confirmar(){
      let id = (document.querySelector("#id") as HTMLInputElement).value;
      let nome =  (document.querySelector("#nome") as HTMLInputElement).value;
      let email = (document.querySelector("#email") as HTMLInputElement).value;
      let telefone = (document.querySelector("#telefone") as HTMLInputElement).value;
      let endereco = (document.querySelector("#endereco") as HTMLInputElement).value;
      let sexo  = ((document.querySelector("#Masculino") as HTMLInputElement).checked) ? "M" : "F";

      if(nome == '' || email == '' || telefone == '' || endereco == ''){
        alert("Preencha todos os campos");
        if(nome == ''){
          document.querySelector("#nome").classList.add("preencher");
        }
        if(email == ''){
          document.querySelector("#email").classList.add("preencher");
        }
        if(telefone == ''){
          document.querySelector("#telefone").classList.add("preencher");
        }
        if(endereco == ''){
          document.querySelector("#endereco").classList.add("preencher");
        }
        return;
      }
      document.querySelector("#nome").classList.remove("preencher");
      document.querySelector("#email").classList.remove("preencher");
      document.querySelector("#telefone").classList.remove("preencher");
      document.querySelector("#endereco").classList.remove("preencher");
      if(id == ''){
          this.dados = {
            nome: nome,
            email: email,
            telefone: telefone,
            endereco: endereco,
            sexo: sexo
          };
          this.url = "http://localhost:8080/api/responsavel";
          this.metodo = "POST";
      }else{
        this.dados = {
          id: id,
          nome: nome,
          email: email,
          telefone: telefone,
          endereco: endereco,
          sexo: sexo
        };
        this.url = "http://localhost:8080/api/responsavel/"+id;
        this.metodo = "PUT";
      }

      fetch(this.url,{
        method:this.metodo,
        body: JSON.stringify(this.dados),
        headers: {'Content-type' : 'application/json'}
      }).then((response) =>{
        if(response.status == 200){
          alert("Salvo com sucesso");
          window.location.reload();
          return;
        }else{
          alert("Erro ao salvar responsável. \n" + response.text());
          return;
        }
      }).catch((e)=>{
        console.log("Erro ao realizar comunicação com servidor. " + e);
      })
      
  }

  limpar(){
    (document.querySelector("#id") as HTMLInputElement).value = '';
    (document.querySelector("#nome") as HTMLInputElement).value = '';
    (document.querySelector("#email") as HTMLInputElement).value = '';
    (document.querySelector("#telefone") as HTMLInputElement).value = '';
    (document.querySelector("#endereco") as HTMLInputElement).value = '';
  }
  ngOnInit(): void {
    
  }

}
