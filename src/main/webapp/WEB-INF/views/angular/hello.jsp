<head>
	<title>learn-angularjs</title>
</head>

<script type="text/javascript">
	function PhoneListCtrl($scope, $http) {
	  $http.get('static/angularjs/1.2.20/phones.json').success(function(data) {
	    $scope.phones = data;
	  });
	  
	  //设置默认排序
	  $scope.orderProp = 'age';
	}
</script>

<div ng-app>		
  <br><br>
  Your name: <input type="text" ng-model="yourname" placeholder="World">
  <hr>
  Hello {{yourname || 'World'}}!
  <br><br>
  <table>
    <tr><th>row number</th></tr>
    <tr ng-repeat="i in [0, 1, 2, 3, 4, 5, 6, 7]"><td>{{i+1}}</td></tr>
  </table>
  <br><br>
  <table>
    <tr><td ng-repeat="i in [0, 1, 2, 3, 4, 5, 6, 7]"> {{i+1}} </td></tr>
  </table>
  <br><br>

  <div class="row-fluid"  ng-controller="PhoneListCtrl">
    <div class="span2">
      <!--Sidebar content-->

      Search: <input type="text" ng-model="query">
      <br>
	  Sort by:
	  <select ng-model="orderProp">
		<option value="name">Alphabetical</option>
		<option value="age">Newest</option>
	  </select>
    </div>
    <div class="span8 offset1">
      <!--Body content-->

      <ul class="phones">
        <li ng-repeat="phone in phones | filter:query | orderBy:orderProp">
          {{phone.name}}
        <p>{{phone.snippet}}</p>
        </li>
      </ul>

    </div>
  </div>
</div>
