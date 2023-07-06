import { Component, OnInit , ViewChild} from '@angular/core';
import { ChartConfiguration, ChartData, ChartEvent, ChartType } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import { ReportService } from 'src/app/services/report.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  @ViewChild(BaseChartDirective) chart: BaseChartDirective | undefined;

   

  public pieChartType: ChartType = 'pie';
  public pieChartOptions: ChartConfiguration['options'] = {
    responsive: true
  };
  public paymentPieChartData:any;
  public requestsPieChartData: any;

  constructor(private reportService: ReportService) { 
    reportService.getPaymentStatusReport().subscribe(
      (data) => {
       this.paymentPieChartData = {
          labels: [ "Success Payments", "Failed Payments", 'Other Payment status' ],
          datasets: [ {
            data: data
          } ]
        };
      },
      (error) => {
        console.log(error)
      }
    )
    reportService.getFundRaiseStatusReport().subscribe(
      (data) => {
       this.requestsPieChartData = {
          labels: [ "Approved Requests", "Rejected Requests", 'Other Status' ],
          datasets: [ {
            data: data
          } ]
        };
      },
      (error) => {
        console.log(error)
      }
    )
  }


  ngOnInit(): void {
  }

}
