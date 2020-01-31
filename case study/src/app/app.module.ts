import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountButtonComponent } from './account/account-button/account-button.component';
import { AccountProfileComponent } from './account/account-profile/account-profile.component';
import { HeaderOneComponent } from './header/header-one/header-one.component';
import { HeaderTwoComponent } from './userheader/header-two/header-two.component';
import { FollowersFollowingComponent } from './media/followers-following/followers-following.component';
import { MyMediaComponent } from './media/my-media/my-media.component';
import { UploadMediaComponent } from './media/upload-media/upload-media.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountButtonComponent,
    AccountProfileComponent,
    HeaderOneComponent,
    HeaderTwoComponent,
    FollowersFollowingComponent,
    MyMediaComponent,
    UploadMediaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
