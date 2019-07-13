package com.learning.maven.jdbc.app;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.learning.maven.jdbc.app.util.DataTransferObject;

public class Order implements DataTransferObject {
	private long id;
    private String customerFirstName;
    private String customerLastLane;
    private String customerEmail;
    private Date creationDate;
    private BigDecimal totalDue;
    private String status;
    private String salespersonFirstName;
    private String salespersonLastName;
    private String salespersonEmail;
    private List<OrderLine> orderLines;
    
    
    public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastLane() {
		return customerLastLane;
	}

	public void setCustomerLastLane(String customerLastLane) {
		this.customerLastLane = customerLastLane;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(BigDecimal totalDue) {
		this.totalDue = totalDue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSalespersonFirstName() {
		return salespersonFirstName;
	}

	public void setSalespersonFirstName(String salespersonFirstName) {
		this.salespersonFirstName = salespersonFirstName;
	}

	public String getSalespersonLastName() {
		return salespersonLastName;
	}

	public void setSalespersonLastName(String salespersonLastName) {
		this.salespersonLastName = salespersonLastName;
	}

	public String getSalespersonEmail() {
		return salespersonEmail;
	}

	public void setSalespersonEmail(String salespersonEmail) {
		this.salespersonEmail = salespersonEmail;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastLane='" + customerLastLane + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", creationDate=" + creationDate +
                ", totalDue=" + totalDue +
                ", status='" + status + '\'' +
                ", salespersonFirstName='" + salespersonFirstName + '\'' +
                ", salespersonLastName='" + salespersonLastName + '\'' +
                ", salespersonEmail='" + salespersonEmail + '\'' +
                ", orderLines=" + orderLines +
                '}';
    }
    
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
