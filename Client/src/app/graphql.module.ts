// src/app/graphql.module.ts

import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";

// Apollo
import { ApolloModule, Apollo } from "apollo-angular";
import { HttpLinkModule, HttpLink } from "apollo-angular-link-http";
import { InMemoryCache } from "apollo-cache-inmemory";

@NgModule({
  exports: [HttpClientModule, ApolloModule, HttpLinkModule]
})
export class GraphQLModule {
  constructor(apollo: Apollo, httpLink: HttpLink) {
    apollo.create({
      link: httpLink.create({ uri: "http://localhost:7899/graphql" }),
      cache: new InMemoryCache()
    });
  }
}
