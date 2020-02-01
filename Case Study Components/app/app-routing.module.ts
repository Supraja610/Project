import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './authorization/login/login.component';
import { RegisterComponent } from './authorization/register/register.component';
import { SingleMediaComponent } from './upload media/single-media/single-media.component';
import {  GalleryComponent } from './my media/gallery/gallery.component';
import { FollowersFollowingComponent } from './following/folowers/followers-following/followers-following.component';
import { AccountUpdateComponent } from './account details/account-update/account-update.component';
import { NewsfeedComponent } from './account details/newsfeed/newsfeed.component';
import { BlockedUsersComponent } from './account details/blocked-users/blocked-users.component';
import { LogoutComponent } from './account details/logout/logout.component';
import { SearchComponent } from './account details/search/search.component';
import { MultipleMediaComponent } from './upload media/multiple-media/multiple-media.component';
import { MyMediaDetailsComponent } from './my media/my-media-details/my-media-details.component';


const routes: Routes = [
  { path:"  ",redirectTo: '/login' , pathMatch: "full"},
  { path: 'login', component:LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path:'upload', component:SingleMediaComponent},
  { path:'mymedia', component: GalleryComponent},
  {path: 'followers', component: FollowersFollowingComponent},
  {path:'account', component: AccountUpdateComponent},
  {path:'newsfeed', component: NewsfeedComponent},
  {path:'blocked',component:BlockedUsersComponent},
  {path:'logout',component:LogoutComponent},
  { path: 'search', component: SearchComponent},
  {path:'multiplemedia',component:MultipleMediaComponent},
  {path:'singlemedia',component:SingleMediaComponent},
  {path:'aboutmedia',component:MyMediaDetailsComponent}

  



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
