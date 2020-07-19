import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutsComponent } from '../layouts/layouts.component';
import { ResponsaveisComponent } from '../responsaveis/responsaveis.component';
import { InicioComponent } from '../inicio/inicio.component';

const routes: Routes = [
  {path: '', redirectTo: 'index', pathMatch: 'full'},
  {
    path: '',
    component: LayoutsComponent,
    children: [
      {path: 'responsaveis', component: ResponsaveisComponent},
      {path: 'servicos', component: ResponsaveisComponent},
      {path: 'index', component: InicioComponent}
    ]
  }
]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
