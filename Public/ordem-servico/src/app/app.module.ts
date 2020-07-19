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

@NgModule({
  declarations: [
    AppComponent,
    ResponsaveisComponent,
    MenuSuperiorComponent,
    LayoutsComponent,
    InicioComponent,
    ConsultaResponsaveisComponent,
    ServicosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
