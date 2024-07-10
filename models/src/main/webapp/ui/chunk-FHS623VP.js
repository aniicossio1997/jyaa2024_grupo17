import{a as f}from"./chunk-PNDMECNC.js";import{a as Ne,b as Ve,c as Be,d as Ge,e as ze,g as qe}from"./chunk-DIJEXQVT.js";import{b as se,c as ve,d as be,e as he}from"./chunk-IG2HBKO5.js";import{b as Le}from"./chunk-CNX4EVCT.js";import{B as Qe,D as Ae,E as z,F as q,H as Oe,b as I,c as xe,k as Ee,n as Me,o as we,p as Te,q as Ie,r as Re,s as L,t as Pe,u as ke,w as De,y as je}from"./chunk-6ORVLML4.js";import{B as M,C as le,D as pe,E as w,F as ce,H as D,I as N,K as V,L as j,P as B,Q,S as A,U as G,V as ue,W as H,X as d,_ as de,aa as T,ba as fe,da as ge,ga as ye,ha as _e,j as k,n as ae,na as Fe,oa as Ce,pa as Se,s as me}from"./chunk-FEXW6FWZ.js";import{$ as U,Cb as X,Db as Y,Eb as Z,Fb as S,Gb as l,Hb as ee,Ib as x,Kb as te,Lb as ie,Mb as re,Na as m,Nb as E,Oa as u,Oc as ne,Pb as $,Qb as oe,R as K,_ as h,db as O,eb as J,fb as s,ha as F,ia as C,ob as a,pb as i,qb as g,ub as P,wb as v,xb as _}from"./chunk-G7V5XMVF.js";var Ze=["dt"],et=()=>["nombre"],tt=()=>({"min-width":"auto"}),it=n=>[n];function rt(n,r){if(n&1){let c=P();a(0,"h2",12),l(1,"Familias Productoras"),i(),a(2,"div",13)(3,"span",14),g(4,"i",15),a(5,"input",16),v("input",function(e){F(c),_();let o=S(2);return C(o.filterGlobal(e.target.value,"contains"))}),i()(),g(6,"p-button",17),i()}if(n&2){let c=_();m(6),s("routerLink",oe(1,it,"/"+c.RoutestEnum.FamiliaProductora+"/"+c.RoutestEnum.New))}}function ot(n,r){n&1&&(a(0,"tr")(1,"th",18),l(2,"Acciones"),i(),a(3,"th",19),l(4,"C\xF3digo "),g(5,"p-sortIcon",20),i(),a(6,"th",21),l(7,"Nombre "),g(8,"p-sortIcon",22),i(),a(9,"th",23),l(10," Descripci\xF3n "),g(11,"p-sortIcon",24),i()())}function nt(n,r){if(n&1){let c=P();a(0,"tr")(1,"td")(2,"button",25),v("click",function(e){let o=F(c).$implicit,p=S(4),y=_();return C(y.generateMenu(o,p,e))}),i(),g(3,"p-menu",26,2),i(),a(5,"td"),l(6),i(),a(7,"td"),l(8),i(),a(9,"td"),l(10),i()()}if(n&2){let c=r.$implicit,t=_();m(3),s("popup",!0)("model",t.itemsMenu),m(3),x("#",c.id,""),m(2),x(" ",c.nombre," "),m(2),x(" ",c.descripcion," ")}}function at(n,r){if(n&1&&(a(0,"div",27),l(1),i()),n&2){let c=_(),t=S(2);m(),x(" En total hay ",t.filteredValue?t.filteredValue.length:c.familias.length," registros. ")}}function mt(n,r){n&1&&(a(0,"tr")(1,"td",28),l(2," No se encontraron registros "),i()()),n&2&&(m(),J("colspan",5))}function lt(n,r){if(n&1){let c=P();a(0,"div",29)(1,"span",30),l(2),i(),a(3,"p",31),l(4),i(),a(5,"div",32)(6,"button",33),v("click",function(){F(c),_();let e=S(9);return C(e.reject())}),i(),a(7,"button",34),v("click",function(){F(c),_();let e=S(9);return C(e.accept())}),i()()()}if(n&2){let c=r.$implicit;m(2),x(" ",c.header," "),m(2),ee(c.message)}}var Je=(()=>{let r=class r{get RoutestEnum(){return d}constructor(t,e,o){this.familiaProductoraService=t,this.confirmationService=e,this.router=o,this.itemsMenu=[],this.familias=[],this.productDialog=!1}ngOnInit(){this.fetchAll()}fetchAll(){this.familiaProductoraService.get().subscribe(t=>{this.familias=t})}generateMenu(t,e,o){e.toggle(o),this.itemsMenu=[{label:"Editar",icon:"pi pi-pencil",command:()=>{this.router.navigate([`/${d.FamiliaProductora}/${d.Edit}/`,t.id])}},{label:"Eliminar",icon:"pi pi-trash",command:()=>{this.delete(t)}}]}delete(t){this.confirmationService.confirm({message:"\xBFEsta seguro de eliminar  la familia "+t.nombre+"?",header:"Confirmar la Eliminaci\xF3n",icon:"pi pi-exclamation-triangle",acceptIcon:"none",rejectIcon:"none",key:"positionDialog",acceptButtonStyleClass:"p-button-danger p-button-text ",rejectButtonStyleClass:"p-button-secondary p-button-text",accept:()=>{this.familiaProductoraService.delete(t.id).subscribe(e=>{this.fetchAll()})},reject:()=>{}})}};r.\u0275fac=function(e){return new(e||r)(u(f),u(k),u(T))},r.\u0275cmp=h({type:r,selectors:[["app-query"]],viewQuery:function(e,o){if(e&1&&X(Ze,5),e&2){let p;Y(p=Z())&&(o.dt=p.first)}},features:[E([f,ae,k])],decls:11,vars:10,consts:[["dt",""],["cd",""],["menu",""],[1,"card"],["dataKey","id","currentPageReportTemplate","Mostrar {first} a {last} de {totalRecords} registros",3,"selectionChange","value","rows","paginator","globalFilterFields","tableStyle","selection","rowHover","showCurrentPageReport"],["pTemplate","caption"],["pTemplate","header"],["pTemplate","body"],["pTemplate","summary"],["pTemplate","emptymessage"],["key","positionDialog","position","center"],["pTemplate","headless"],[1,"mb-4"],[1,"flex","align-items-center","justify-content-between","flex-wrap"],[1,"p-input-icon-left"],[1,"pi","pi-search"],["pInputText","","type","text","placeholder","Buscar...",3,"input"],["pRipple","","severity","primary","label","Agregar Familia Productora","icon","pi pi-plus",1,"mr-2",3,"routerLink"],[2,"width","4rem"],["pSortableColumn","id"],["field","id"],["pSortableColumn","nombre"],["field","nombre"],["pSortableColumn","descripcion"],["field","descripcion"],["pButton","","pRipple","","type","button","icon","pi pi-bars",1,"p-button-rounded","p-button-text",3,"click"],["appendTo","body",3,"popup","model"],[1,"flex","align-items-center","justify-content-between"],[1,"text-center","py-4"],[1,"flex","flex-column","p-5","surface-overlay","border-round"],[1,"font-bold","text-2xl","block","mb-2","mt-4"],[1,"mb-0"],[1,"flex","justify-content-between","flex-wrap","mt-4"],["pButton","","label","No",1,"p-button-outlined","p-button-secondary","w-5rem",3,"click"],["pButton","","label","Si",1,"w-5rem","p-button-danger",3,"click"]],template:function(e,o){if(e&1){let p=P();a(0,"div",3)(1,"p-table",4,0),re("selectionChange",function(b){return F(p),ie(o.selectedProducts,b)||(o.selectedProducts=b),C(b)}),O(3,rt,7,3,"ng-template",5)(4,ot,12,0,"ng-template",6)(5,nt,11,5,"ng-template",7)(6,at,2,1,"ng-template",8)(7,mt,3,1,"ng-template",9),i(),a(8,"p-confirmDialog",10,1),O(10,lt,8,2,"ng-template",11),i()()}e&2&&(m(),s("value",o.familias)("rows",5)("paginator",!0)("globalFilterFields",$(8,et))("tableStyle",$(9,tt)),te("selection",o.selectedProducts),s("rowHover",!0)("showCurrentPageReport",!0))},dependencies:[fe,pe,w,me,I,Fe,we,Te,Ie,M,ye],styles:["[_nghost-%COMP%]     .p-dialog .product-image{width:150px;margin:0 auto 2rem;display:block}"]});let n=r;return n})();var Xe=(()=>{let r=class r{constructor(t,e,o,p){this.fb=t,this.router=e,this.familiaProductoraService=o,this.toastr=p,this.myForm=this.fb.group({nombre:["",N.required],descripcion:[""]})}ngOnInit(){}cancel(){this.router.navigate(["/"+d.FamiliaProductora])}save(){if(this.myForm.valid){let t={nombre:this.myForm.get("nombre").value,descripcion:this.myForm.get("descripcion").value};this.familiaProductoraService.post(t).subscribe(e=>{e&&this.cancel()})}}};r.\u0275fac=function(e){return new(e||r)(u(G),u(T),u(f),u(Se))},r.\u0275cmp=h({type:r,selectors:[["app-new"]],features:[E([f])],decls:18,vars:7,consts:[[1,"card"],[1,"mb-5","m-2"],[1,"p-fluid","p-formgrid","grid",3,"formGroup"],[1,"field","col-12","md:col-12"],["htmlFor","firstname2"],["pInputText","","id","firstname2","type","text","formControlName","nombre","placeholder","Nombre / Raz\xF3n social","appCustomInputError","",3,"valueForm","errors"],["customLabel","",3,"valueForm","errors"],["htmlFor","descripcionid"],["formControlName","descripcion","rows","5","cols","30","pInputTextarea","","placeholder","Descripci\xF3n",3,"autoResize"],[1,"field","col-12"],[1,"flex","justify-content-between","flex-wrap"],["pRipple","","label","Cancelar","icon","pi pi-times","severity","secondary",3,"click"],["pRipple","","label","Guardar","icon","pi pi-check",3,"click","disabled"]],template:function(e,o){if(e&1&&(a(0,"div",0)(1,"h5",1),l(2,"Agregar familia productora"),i(),a(3,"form",2)(4,"div",3)(5,"label",4),l(6,"Nombre / Raz\xF3n social *"),i(),g(7,"input",5)(8,"span",6),i(),a(9,"div",3)(10,"label",7),l(11,"Descripci\xF3n"),i(),a(12,"textarea",8),l(13,"      "),i()(),a(14,"div",9)(15,"div",10)(16,"p-button",11),v("click",function(){return o.cancel()}),i(),a(17,"p-button",12),v("click",function(){return o.save()}),i()()()()()),e&2){let p,y,b,R;m(3),s("formGroup",o.myForm),m(4),s("valueForm",(p=o.myForm.get("nombre"))==null?null:p.value)("errors",(y=o.myForm.get("nombre"))==null?null:y.errors),m(),s("valueForm",(b=o.myForm.get("nombre"))==null?null:b.value)("errors",(R=o.myForm.get("nombre"))==null?null:R.errors),m(4),s("autoResize",!0),m(5),s("disabled",o.myForm.invalid)}},dependencies:[w,I,L,B,D,V,j,Q,A,M,z,q]});let n=r;return n})();var Ye=(()=>{let r=class r{constructor(t,e,o,p){this.activateRouter=t,this.familiaProductoraService=e,this.router=o,this.fb=p,this.myForm=this.fb.group({nombre:["",N.required],descripcion:[""]})}ngOnInit(){this.id=Number(this.activateRouter.snapshot.paramMap.get("id")),this.id&&this.familiaProductoraService.getById(this.id).subscribe(t=>{this.myForm.get("nombre").setValue(t.nombre),this.myForm.get("descripcion").setValue(t.descripcion),this.myForm.get("nombre").markAsTouched(),this.myForm.get("descripcion").markAsTouched(),this.myForm.updateValueAndValidity()})}cancel(){this.router.navigate(["/"+d.FamiliaProductora])}save(){if(this.myForm.valid){let t={nombre:this.myForm.get("nombre").value,descripcion:this.myForm.get("descripcion").value};this.familiaProductoraService.putFamilia(this.id,t).subscribe(e=>{e&&this.cancel()})}}get formNombre(){return this.myForm.get("nombre").valueChanges.pipe()}};r.\u0275fac=function(e){return new(e||r)(u(de),u(f),u(T),u(G))},r.\u0275cmp=h({type:r,selectors:[["app-edit-familia"]],features:[E([f])],decls:18,vars:7,consts:[[1,"card"],[1,"mb-5","m-2"],[1,"p-fluid","p-formgrid","grid",3,"formGroup"],[1,"field","col-12","md:col-12"],["htmlFor","firstname2"],["pInputText","","id","firstname2","type","text","formControlName","nombre","placeholder","Nombre / Razon social","appCustomInputError","",3,"valueForm","errors"],["customLabel","",3,"valueForm","errors"],["htmlFor","descripcionid"],["formControlName","descripcion","rows","5","cols","30","placeholder","Descripci\xF3n","pInputTextarea","",3,"autoResize"],[1,"field","col-12"],[1,"flex","justify-content-between","flex-wrap"],["pRipple","","label","Cancelar","icon","pi pi-times","severity","secondary",3,"click"],["pRipple","","label","Guardar","icon","pi pi-check",3,"click","disabled"]],template:function(e,o){if(e&1&&(a(0,"div",0)(1,"h5",1),l(2,"Editar familia productora"),i(),a(3,"form",2)(4,"div",3)(5,"label",4),l(6,"Nombre / Razon social *"),i(),g(7,"input",5)(8,"span",6),i(),a(9,"div",3)(10,"label",7),l(11,"Descripci\xF3n"),i(),a(12,"textarea",8),l(13,"      "),i()(),a(14,"div",9)(15,"div",10)(16,"p-button",11),v("click",function(){return o.cancel()}),i(),a(17,"p-button",12),v("click",function(){return o.save()}),i()()()()()),e&2){let p,y,b,R;m(3),s("formGroup",o.myForm),m(4),s("valueForm",(p=o.myForm.get("nombre"))==null?null:p.value)("errors",(y=o.myForm.get("nombre"))==null?null:y.errors),m(),s("valueForm",(b=o.myForm.get("nombre"))==null?null:b.value)("errors",(R=o.myForm.get("nombre"))==null?null:R.errors),m(4),s("autoResize",!0),m(5),s("disabled",o.myForm.invalid)}},dependencies:[w,I,L,B,D,V,j,Q,A,M,z,q]});let n=r;return n})();var dt=[{path:"",redirectTo:"query",pathMatch:"full"},{path:`${d.Edit}/:id`,component:Ye,title:"Editar Familia Productora"},{path:d.Query,component:Je,title:"Listado de Familias Productoras"},{path:d.New,component:Xe,title:"Agregar Familia Productora"}],ci=(()=>{let r=class r{};r.\u0275fac=function(e){return new(e||r)},r.\u0275mod=U({type:r}),r.\u0275inj=K({imports:[ne,ge.forChild(dt),ce,se,xe,Pe,Ce,ke,De,Ne,Ve,Re,be,ue,H,je,he,Ee,Be,Qe,Ae,Ge,Le,Me,ze,le,ve,qe,_e,H,Oe]});let n=r;return n})();export{ci as FamiliaProductoraModule};
