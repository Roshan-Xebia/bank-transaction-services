<html>
<head>
      <title>Backbase Bank</title>
      
      <script type="text/javascript">
      function getTransactionByAccountId() {
    	  var xhttp = new XMLHttpRequest();
    	  xhttp.onreadystatechange = function() {
    	    if (this.readyState == 4 && this.status == 200) {
    	     document.getElementById("resdata").innerHTML = this.responseText;
    	    }else if (this.status == 400) {
    	     document.getElementById("resdata").innerHTML = this.responseText;
    	    }
    	  };
    	  xhttp.open("GET", "rs/v1/current-accounts/transactions?accountId="+document.getElementById("accountId").value, true);
    	  xhttp.send();
    	}
      
      function getTransactionByType() {
    	  var xhttp = new XMLHttpRequest();
    	  xhttp.onreadystatechange = function() {
    	    if (this.readyState == 4 && this.status == 200) {
    	     document.getElementById("resdata").innerHTML = this.responseText;
    	    }else if (this.status == 400) {
    	     document.getElementById("resdata").innerHTML = this.responseText;
    	    }
    	  };
    	  xhttp.open("GET", "rs/v1/current-accounts/transactionsbytype?transType="+document.getElementById("transType").value+"&accountId="+document.getElementById("accountId").value, true);
    	  xhttp.send();
    	}
      
      function getTransactionTotalAmount() {
    	  var xhttp = new XMLHttpRequest();
    	  xhttp.onreadystatechange = function() {
    	    if (this.readyState == 4 && this.status == 200) {
    	     document.getElementById("resdata").innerHTML = this.responseText;
    	    }else if (this.status == 400) {
    	     document.getElementById("resdata").innerHTML = this.responseText;
    	    }
    	  };
    	  xhttp.open("GET", "rs/v1/current-accounts/transaction/total-amount?transType="+document.getElementById("transType").value+"&accountId="+document.getElementById("accountId").value, true);
    	  xhttp.send();
    	}
      </script>
      
   </head>
   
<body>
<form>
  Account Id: <input type="text" name="accountId" id="accountId" value="savings-kids-john">
  <br><br>
  Trans Type: <input type="text" name="transType" id="transType" value="SANDBOX_TAN">
  <br><br>
  <a href="https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions"> open Bank </a>
</br>



<table border="1">
  <tr>
    <th>Action</th>
    <th>End Point</th>
    <th>Description</th>
  </tr>
  <tr>
    <td><button type="button" onclick="getTransactionByAccountId()">Get Transaction For Specific Account Id</button></td>
    <td>rs/v1/current-accounts/transactions?accountId=</td>
    <td>This end point will return the transaction list.<br>Provide <b>accountId</b> parameter</td>
  </tr>
  <tr>
    <td><button type="button" onclick="getTransactionByType()">Get Transaction By Transaction Type For Specific Account Id</button></td>
    <td>rs/v1/current-accounts/transactionsbytype?transType=&accountId=</td>
    <td>This end point will return the transaction list for specific transaction type.<br>Provide <b>accountId and transType</b> parameter</td>
  </tr>
  <tr>
    <td><button type="button" onclick="getTransactionTotalAmount()">Get Transaction Total Amount For Specific Transaction Type and Account Id</button></td>
    <td>rs/v1/current-accounts/transaction/total-amount?transType=&accountId=</td>
    <td>This end point will return the transaction total amount for specific transaction type.<br>Provide <b>accountId and transType</b> parameter</td>
  </tr>
</table>
<b>Response:</b><br>

<textarea rows="20" cols="200" name="resdata" id="resdata" style="overflow:scroll;">
Please submit your request >> .
</textarea>
</form> 


</body>
</html>
