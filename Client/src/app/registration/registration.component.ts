// src/app/registration/registration.component.ts

import { Component, OnInit } from "@angular/core";
import { NgbDateStruct } from "@ng-bootstrap/ng-bootstrap";
import { Apollo } from "apollo-angular";
import gql from "graphql-tag";
import { Observable } from "rxjs/Observable";
import "rxjs/add/operator/map";

class Registration {
  constructor(
    public id: string = "",
    public firstName: string = "",
    public lastName: string = "",
    // public dob: NgbDateStruct = null,
    // public email: string = "",
    // public password: string = "",
    // public country: string = "Select country"
  ) {}
}

@Component({
  selector: "app-registration",
  templateUrl: "./registration.component.html",
  styleUrls: ["./registration.component.css"]
})
export class RegistrationComponent implements OnInit {
  // It maintains list of Registrations
  registrations: Array<any> = [];
  // It maintains registration Model
  regModel: Registration;
  // It maintains registration form display status. By default it will be false.
  showNew: Boolean = false;
  // It will be either 'Save' or 'Update' based on operation.
  submitType: string = "Save";
  // It maintains table row index based on selection.
  selectedRow: number;
  // It maintains Array of countries.
  // countries: string[] = ["US", "UK", "India", "UAE"];

  registrationList: Array<any> = []; // List of Users

  comments: Observable<any>;

  constructor(private apollo: Apollo) {}

  ngOnInit() {
    this.displayRegistrations();
  }

  // Get all registrations
  displayRegistrations() {
    debugger;
    const getRegistrations = gql`
      {      
        allAuthors {
          id
          authorName
          price
        }      
      }
    `;

    this.apollo
      .watchQuery({
        query: getRegistrations,
        fetchPolicy: "network-only"
      })
      .valueChanges.map((result: any) =>result.data['allAuthors'])
      .subscribe(data => {
        this.registrations = data;
      });
  }

  // This method associate to New Button.
  onNew() {
    // Initiate new registration.
    this.regModel = new Registration();
    // Change submitType to 'Save'.
    this.submitType = "Save";
    // display registration entry section.
    this.showNew = true;
  }

  // This method associate to Save Button.
  onSave() {
    // var dateVal =
    //   this.regModel.dob.year.toString() +
    //   "-" +
    //   this.regModel.dob.month.toString() +
    //   "-" +
    //   this.regModel.dob.day.toString();
    if (this.submitType === "Save") {
      const saveRegistration = gql`
        mutation addAuthor(
          $id: ID!
          $authorName: String!
          $price: String!          
        ) {
          addAuthor(
            id: $id
            authorName: $authorName
            price: $price
           ) 
           {
            id
          }
        }
      `;
      this.apollo
        .mutate({
          mutation: saveRegistration,
          variables: {
            id:this.regModel.id,  
            authorName: this.regModel.firstName,
            price: this.regModel.lastName,
                    
          }
        })
        .subscribe(
          ({ data }) => {
            this.displayRegistrations();
          },
          error => {
            console.log("there was an error sending the query", error);
          }
        );

      // Push registration model object into registration list.
      // this.registrations.push(this.regModel);
    } else {
      const updateRegistration = gql`
        mutation updateAuthor(
          $id: ID!
          $authorName: String!
          $price: String!         
        ) {
          updateAuthor(
            id: $id
            authorName: $pname
            price: $price            
          ) {
            id
            authorName
            price
          }
        }
      `;
      this.apollo
        .mutate({
          mutation: updateRegistration,
          variables: {
            id: this.regModel.id,
            authorName: this.regModel.firstName,
            price: this.regModel.lastName
            // dob: new Date(dateVal),
            // email: this.regModel.email,
            // password: this.regModel.password,
            // country: this.regModel.country
          }
        })
        .subscribe(
          ({ data }) => {
            console.log("got editdata", data);
            this.displayRegistrations();
          },
          error => {
            console.log("there was an error sending the query", error);
          }
        );
    }
    // Hide registration entry section.
    this.showNew = false;
  }

  // This method associate to Edit Button.
  onEdit(index: number) {
    // Assign selected table row index.
    this.selectedRow = index;
    // Initiate new registration.
    this.regModel = new Registration();
    // Retrieve selected registration from list and assign to model.
    this.regModel = Object.assign({}, this.registrations[this.selectedRow]);
    const dob = new Date(this.registrations[this.selectedRow].dob);

    // this.regModel.dob = {
    //   day: dob.getDate(),
    //   month: dob.getMonth() + 1,
    //   year: dob.getFullYear()
    // };

    // Change submitType to Update.
    this.submitType = "Update";
    // Display registration entry section.
    this.showNew = true;
  }

  // This method associate to Delete Button.
  onDelete(index: number) {
    console.log(index);
    const deleteRegistration = gql`
      mutation deleteAuthor($id: ID!) {
        deleteAuthor(id: $id) {
          id
        }
      }
    `;
    this.apollo
      .mutate({
        mutation: deleteRegistration,
        variables: {
          id: index +1
          // id: this.regModel.id,
          //  id:this.regModel.id,     
        }        
      })
      .subscribe(
        ({ data }) => {
          console.log("got editdata", data);
          this.displayRegistrations();
        },
        error => {
          console.log("there was an error sending the query", error);
        }
      );
  }

  // This method associate toCancel Button.
  onCancel() {
    // Hide registration entry section.
    this.showNew = false;
  }

  // This method associate to Bootstrap dropdown selection change.
  
}