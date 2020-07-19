import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing/app-routing.module';

import { AppComponent } from './app.component';
import { ResponsaveisComponent } from './responsaveis/responsaveis.component';
import { MenuSuperiorComponent } from './menu-superior/menu-superior.component';
import { LayoutsComponent } from './layouts/layouts.component';
import { InicioComponent } from './inicio/inicio.component';
import { ConsultaResponsaveisComponent } from './consulta-responsaveis/consulta-responsaveis.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ServicosComponent } from './servicos/servicos.component';
import { ConsultaServicosComponent } from './consulta-servicos/consulta-servicos.component';

import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';

@NgModule({
  declarations: [
    AppComponent,
    ResponsaveisComponent,
    MenuSuperiorComponent,
    LayoutsComponent,
    InicioComponent,
    ConsultaResponsaveisComponent,
    ServicosComponent,
    ConsultaServicosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
