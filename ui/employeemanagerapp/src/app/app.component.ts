import { Component, OnInit } from '@angular/core';
import { Employee } from './employee/employee';
import {EmployeeService} from './employee-service/employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public employees: Employee[] = [];
  public editEmployee:Employee | undefined;


  constructor(private employeeService: EmployeeService){}

  ngOnInit() {
     this.getEmployees();
  }

  public getEmployees():void {
   this.employeeService.getEmployees().subscribe(
     (response: Employee[])=> {
        this.employees = response;
     },
     (error: HttpErrorResponse) => {
       console.log(error.message)
     }
   );
  }

  public onOpenModal(employee: any, mode: string):void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');

    if(mode === 'add') {
        button.setAttribute('data-bs-target', '#addEmployeeModal');
    }

    if(mode === 'edit') {
        this.editEmployee = employee;
        button.setAttribute('data-bs-target', '#editEmployeeModal');
    }

    if(mode === 'delete') {
        button.setAttribute('data-bs-target', '#deleteEmployeeModal');
    }

    if(container !== null) {
     container.appendChild(button);
    }

    button.click();
  }

  public onAddEmployee(addForm: NgForm):void {
  const closeModalBtn = document.getElementById('add-employee-btn');
  if(closeModalBtn !== null) {
    closeModalBtn.click();
  }
     this.employeeService.addEmployee(addForm.value).subscribe(
      (response:Employee)=> {
       console.log(response);
       this.getEmployees();
      },
      (error:HttpErrorResponse)=> {
        console.log(error.message);
      },
     )
  }

  public onEditEmployee(employee: Employee): void{
  this.employeeService.updateEmployee(employee).subscribe(
     (response:Employee)=> {
      console.log(response);
      this.getEmployees();
     },
     (error:HttpErrorResponse)=> {
       console.log(error.message);
     },
  )

  }

}
